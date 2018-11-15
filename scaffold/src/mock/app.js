import {resultVO,responseData} from './base'
import api from '@/api/api';
var Mock = require('mockjs');

Mock.mock(api.menuList, 'get', function (options) {

    let data = [
        {
            path: '/demo',
            icon: 'ios-grid-view',
            name: 'demo',
            title: '常用实例',
            component: 'Main',
            children: [
                {path: 'pdf', title: 'PDF预览', name: 'pdf', icon: 'edit', component: 'demo/pdf'},
                {path: 'userlist', title: '用户管理', name: 'userlist', icon: 'edit', component: 'user/user'},
                // { path: 'userEdit', title: '编辑用户', name: 'userEdit', icon: 'edit', component: 'user/userEdit'}
            ]
        },{
            path: '/week',
            icon: 'ios-grid-view',
            name: 'week',
            title: '周报',
            component: 'Main',
            children: [
                {path: 'myweek', title: '周报', name: 'myweek', icon: 'edit', component: 'week-report/report'},
            ]
        }



    ];
    resultVO.body = {total: 3, data: data};
    resultVO.msg = '成功';
    return responseData(resultVO);
});



Mock.mock(api.topMenu, 'get', function (options) {
    let data = [{id: '1', icon: 'videocamera', name: '管理驾驶舱', path: '/demo2/pdf2'}, {id: '2', icon: 'leaf', name: '我的工作台', path: '/demo/userlist'}]
    resultVO.body = data;
    resultVO.msg = '成功';
    return responseData(resultVO);
});