import Main from '@/views/Main';
const _import = require('./_import_production');
// 不作为Main组件的子页面展示的页面单独写，如下
export const loginRouter = {
    path: '/login',
    name: 'login',
    meta: {
        title: 'Login - 登录'
    },
    component: _import('login')
};

export const page404 = {
    path: '/*',
    name: 'error-404',
    meta: {
        title: '404-页面不存在'
    },
    component: _import('error-page/404')
};

export const page403 = {
    path: '/403',
    meta: {
        title: '403-权限不足'
    },
    name: 'error-403',
    component: _import('error-page/403')
};

export const page500 = {
    path: '/500',
    meta: {
        title: '500-服务端错误'
    },
    name: 'error-500',
    component: _import('error-page/500')
};


export const locking = {
    path: '/locking',
    name: 'locking',
    component: _import('main-components/lockscreen/components/locking-page')
};


// 作为Main组件的子页面展示但是不在左侧菜单显示的路由写在otherRouter里
export const otherRouter = {
    path: '/',
    name: 'otherRouter',
    redirect: '/login',
    component: Main,
    children: [
        { path: 'home', title: {i18n: 'home'}, name: 'home_index', component: _import('home/home') },
        { path: 'notice', title: '消息通知', name: 'notice', component: _import('system/notice/noticeList') },
    ]
};



export const demoRouter = {
    path: '/demo',
    name: 'demo',
    icon:'ios-apps-outline',
    title: 'demo示例',
    redirect: '/home',
    component: Main,
    children: [

        { path: 'fileupload', title: '文件上传', name: 'fileupload', component:  _import('demo/upload/fileUpload')},
        { path: 'step', title: '步骤条', name: 'step', component:  _import('demo/steps/step')},
        { path: 'table', title: '普通表格', name: 'table', component:  _import('demo/user/user')},
        { path: 'searchtable', title: '查询表格', name: 'searchtable', component:  _import('demo/user/userSearch')},
        { path: 'edittable', title: '可编辑表格', name: 'edittable', component:  _import('demo/user/userLineEdit')},
        { path: 'tabs', title: '选项卡', name: 'tabs', component:  _import('demo/tabs/tabs')},
        { path: 'pdf', title: 'PDF', name: 'pdf', component:  _import('demo/pdf/pdf')},
        { path: 'todoWorkflow', title: '待办', name: 'todoWorkflow', component:  _import('workflow/todoWorkflowAll')}
    ]
};


// 所有上面定义的路由都要写在下面的routers里
export const routers = [
    locking,
    loginRouter,
    otherRouter,
    // demoRouter,
    page500,
    page403
];
