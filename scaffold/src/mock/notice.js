import {resultVO,responseData} from './base'
import api from '@/api/api';
var Mock = require('mockjs');
Mock.mock(api.notice.list, 'get', function (options) {

    let result = [{id:'1', userName:'超级管理员', content:'在2018-07-16 06:00，检测到基金"123"存在2项风险！请及时处理！1', dateTime:'2018-07-16 06:00',noticeType: '基金风险检测',status:0},
        {id:'2', userName:'超级管理员', content:'在2018-07-16 06:00，检测到基金"123"存在2项风险！请及时处理！2', dateTime:'2018-07-16 06:00',noticeType: '基金风险检测',status:0},
        {id:'3', userName:'超级管理员', content:'在2018-07-16 06:00，检测到基金"123"存在2项风险！请及时处理！3', dateTime:'2018-07-16 06:00',noticeType: '基金风险检测',status:0},
        {id:'31', userName:'超级管理员', content:'在2018-07-16 06:00，检测到基金"123"存在2项风险！请及时处理！4', dateTime:'2018-07-16 06:00',noticeType: '基金风险检测',status:0},
        {id:'4', userName:'超级管理员', content:'在2018-07-16 06:00，检测到基金"123"存在2项风险！请及时处理！5', dateTime:'2018-07-16 06:00',noticeType: '基金风险检测',status:0}];

    let  noticeList = JSON.parse(localStorage.getItem('noticeList'));
    if (noticeList == null){
        localStorage.setItem('noticeList',JSON.stringify(result));
    } else {
        result = noticeList;
    }
    resultVO.body = {total: result.length, data: result};
    resultVO.msg = '成功';
    const res = responseData(resultVO);
    return res;
});


Mock.mock(api.notice.read, 'post', function (options) {
    let ids = JSON.parse(options.body);

    let  jsonList = JSON.parse(localStorage.getItem('noticeList'));
    if (jsonList == null) jsonList = [];
    let noticeList = [];
    for (let id of ids) {
        noticeList = jsonList.map((item) => {
            if (item.id == id) {
                item.status = 1;
            }
            return item;
        });

    }

    localStorage.removeItem('noticeList');
    localStorage.setItem('noticeList',JSON.stringify(noticeList));
    resultVO.msg = '保存成功';
    return responseData(resultVO);
});


Mock.mock(api.notice.delete, 'delete', function (options) {
    const ids = options.body;

    let  jsonList = JSON.parse(localStorage.getItem('noticeList'));
    if (jsonList == null) jsonList = [];
    const  noticeList = jsonList.filter((item) => {
        if (!ids.includes(item.id)) {
            return item;
        }
    });

    localStorage.removeItem('noticeList');
    localStorage.setItem('noticeList',JSON.stringify(noticeList));
    resultVO.msg = '保存成功';
    return responseData(resultVO);
});