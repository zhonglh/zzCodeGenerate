import {resultVO,responseData} from './base'
import api from '@/api/api';
var Mock = require('mockjs');
Mock.mock(api.testUserList, 'get', function (options) {

    // let data = Mock.mock({'list|20': [{'name': '@cname', 'gender': '@string("男女",1)', 'post': '@cword(3)'}]});

    const params = JSON.parse(options.body);
    let data = JSON.parse(localStorage.getItem('userList')) || [];
    const pageSize = params.pageSize;
    const pageNo = params.pageNum;
    let searchParam = [];
    for (let k in params){
        if (k != 'pageSize' && k != 'pageNum' && k != 'code' && k !='encryptedData' && k!= 'ivStr'){
            searchParam[k] = params[k]
        }
    }

    for (let p in searchParam){
        let  keys = p.split('_');
        if (keys[1] == 'eq') {
            keys[1] = '==';
        }
        if (keys[1] == 'neq') {
            keys[1] = '!==';
        }
        if (keys[1] == 'gt') {
            keys[1] = '>';
        }
        if (keys[1] == 'egt') {
            keys[1] = '>=';
        }
        if (keys[1] == 'lt') {
            keys[1] = '<';
        }

        if (keys[1] == 'elt') {
            keys[1] = '<=';
        }
        data = data.filter((item) => {

            if (keys[1] == 'like'){
                if(`${item[keys[0]]}`.indexOf(`${searchParam[p]}`) != -1){
                    return item
                }
            }else {
                let flag = false;
                let exp = item[keys[0]] + keys[1] +  searchParam[p];
                try {
                    flag = eval(exp);
                }catch (e) {
                    exp = `'${item[keys[0]]}'` + keys[1] +  `'${searchParam[p]}'`;
                    flag = eval(exp);
                }
                if (flag)  return item;
            }
        });
    }

    let result = [];
    let start = (pageNo-1) * pageSize;
    const end = pageSize * pageNo > data.length ? data.length : pageSize * pageNo
    for (;start<end; start++) {
        result.push(data[start]);
    }

    resultVO.body = {total: data.length, data: result};
    resultVO.msg = '成功';

    const res = responseData(resultVO);
    return res;
});

Mock.mock(api.userSave, 'post', function (options) {
    let  userList = JSON.parse(localStorage.getItem('userList'));
    if (userList == null) userList = [];
    var id = Date.parse(new Date());
    let data = JSON.parse(options.body);
    data.id = id;
    userList.unshift(data);
    localStorage.setItem('userList',JSON.stringify(userList));
    resultVO.msg = '保存成功';
    return responseData(resultVO);
});

Mock.mock(api.userUpdate, 'post', function (options) {
    let data = JSON.parse(options.body);
    const id = data.id;

    let  jsonList = JSON.parse(localStorage.getItem('userList'));
    if (jsonList == null) jsonList = [];
    const  userList = jsonList.map((item) => {
        if (item.id == id) {
            item = data
        }
        return item;
    });
    localStorage.removeItem('userList');
    localStorage.setItem('userList',JSON.stringify(userList));
    resultVO.msg = '保存成功';
    return responseData(resultVO);
});

Mock.mock(api.findById, 'get', function (options) {
    const id = options.body;
    let  userList = JSON.parse(localStorage.getItem('userList'));
    let result = userList.filter((item) => {
        if (item.id == id) {
            return item;
        }
    })
    resultVO.body = result[0]
    resultVO.msg = '查询成功';
    return responseData(resultVO);
});



Mock.mock(api.deleteById, 'delete', function (options) {
    const id = options.body;

    let  jsonList = JSON.parse(localStorage.getItem('userList'));
    if (jsonList == null) jsonList = [];
    const  userList = jsonList.filter((item) => {
        if (item.id != id) {
            return item;
        }
    });
    localStorage.removeItem('userList');
    localStorage.setItem('userList',JSON.stringify(userList));
    resultVO.msg = '保存成功';
    return responseData(resultVO);
});



