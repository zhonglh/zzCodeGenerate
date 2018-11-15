import {resultVO,responseData} from './base'
import api from '@/api/api';
var Mock = require('mockjs');

Mock.mock(api.address, 'get', function (options) {

    const address = [{
        value: 'beijing',
        label: '北京',
        children: [
            {
                value: 'gugong',
                label: '故宫'
            },
            {
                value: 'tiantan',
                label: '天坛'
            },
            {
                value: 'wangfujing',
                label: '王府井'
            }
        ]
    }, {
        value: 'jiangsu',
        label: '江苏',
        children: [
            {
                value: 'nanjing',
                label: '南京',
                children: [
                    {
                        value: 'fuzimiao',
                        label: '夫子庙',
                    }
                ]
            },
            {
                value: 'suzhou',
                label: '苏州',
                children: [
                    {
                        value: 'zhuozhengyuan',
                        label: '拙政园',
                    },
                    {
                        value: 'shizilin',
                        label: '狮子林',
                    }
                ]
            }
        ],
    }];
    resultVO.body = {total: address.length, data: address};
    resultVO.msg = '成功';

    return responseData(resultVO);
});


Mock.mock(api.postList, 'get', function (options) {

    const postList = [{id:1,name:'销售经理'},{id:2,name:'程序猿'},{id:3,name:'行政秘书'},{id:4,name:'财务总监'}];
    resultVO.body = {total: postList.length, data: postList};
    resultVO.msg = '成功';

    return responseData(resultVO);
});

Mock.mock(api.loveList, 'get', function (options) {

    const loveList = [{id:1,name:'吃饭'},{id:2,name:'睡觉'},{id:3,name:'跑步'},{id:4,name:'看电影'},{id:5,name:'打篮球'}];
    resultVO.body = {total: loveList.length, data: loveList};
    resultVO.msg = '成功';

    return responseData(resultVO);
});