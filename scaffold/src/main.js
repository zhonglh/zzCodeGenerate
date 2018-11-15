import Vue from 'vue';
import iView from 'iview';
import store from './store';
import App from './app.vue';
import '@/locale';
import './styles/main.less';
import VueI18n from 'vue-i18n';

import Util from './utils/util';
import VueRouter from 'vue-router';

import loginApi from '@/api/loginApi';
import {routers} from './router/router';
import 'jquery';
import 'jquery-confirm'
import VueFilter from 'vue-filter';
import commonApi from '@/api/commonApi';
import industrysApi from '@/api/industrysApi';
import consts from '@/utils/const';
import storageUtils from '@/utils/storageUtils';
// import mavonEditor from 'mavon-editor'
// import 'mavon-editor/dist/css/index.css'
// import VueHtml5Editor from 'vue-html5-editor'


Vue.use(VueI18n);
Vue.use(iView);
Vue.use(VueRouter);
Vue.use(VueFilter);
// use
// Vue.use(mavonEditor);
// Vue.use(VueHtml5Editor);
if (process.env.MOCK) {
    // require('./mock/mock');
}


Vue.filter('yesOrNo', function (val) {
    if (val == 1) {
        return '是';
    }else if(val == 0){
        return '否';
    }else{
        return '';
    }
});

Vue.filter('dict', function (val, dict) {
    let result = '';
    for(let item of dict){
        if (val== item.id) {
            result = item.name;
            break;
        }
    }
     return result;
});
let router = {};

init();

 function  init() {
     assemRouter();
     initVue();

}
 function assemRouter(){
    let RouterConfig = {
        mode: 'history',
        routes: routers
    };
     router =  new VueRouter(RouterConfig);

    router.beforeEach((to, from, next) => {

        iView.LoadingBar.start();
        Util.title(to.meta.title);
        const  ticket = to.query.ticket;
        if (ticket != undefined && ticket !=''){
            next(true);
        }else {
            const sessionKey = storageUtils.get('sessionKey');
            if (sessionKey == undefined) {
                loginApi.toLogin().then(response => {
                    const loginUrl = response.body.url;
                    window.location.href = loginUrl
                });
            }else {
                storageUtils.set('userInfo',storageUtils.get('userInfo'),process.env.COOKIE_TIMEOUT);
                storageUtils.set('sessionKey',storageUtils.get('sessionKey'),process.env.COOKIE_TIMEOUT);
                next(true);
            }
        }

    });

    router.afterEach((to) => {
        Util.openNewPage(router.app, to.name, to.params, to.query);
        iView.LoadingBar.finish();
        window.scrollTo(0, 0);
    });


}



function initVue() {


    new Vue({
        el: '#app',
        router: router,
        store: store,
        render: h => h(App),
        data: {
            currentPageName: ''
        },
        computed: {
            leftMenus() {
                return this.$store.state.app.menuList;
            }
        },
        methods: {},
        mounted () {
            const menus = storageUtils.get('menuList');
            const permissions = storageUtils.get('permissions');
            const userInfo = storageUtils.get('userInfo');
            this.currentPageName = this.$route.name;
            this.$store.commit('updateMenulist',menus);
            this.$store.commit('updateUserInfo');
            this.$store.commit('updatePermissions',permissions);
            if (this.leftMenus != undefined && this.leftMenus.length>0)
                this.$router.addRoutes(this.leftMenus);

/*            this.$store.commit('setOpenedList');
            this.$store.commit('initCachepage');
            */

           /* commonApi.multiDict('projectType,investDirection,touziState,projectState', {
                onSuccess(res) {
                    let projectTypeDicts = res.projectType;
                    let investDirectionDicts = res.investDirection;
                    let touziStateDicts = res.touziState;
                    let projectStateDicts = res.projectState;


                    storageUtils.set(consts.projectTypeDicts, projectTypeDicts);
                    storageUtils.set(consts.investDirectionDicts, investDirectionDicts);
                    storageUtils.set(consts.touziStateDicts, touziStateDicts);
                    storageUtils.set(consts.projectStateDicts, projectStateDicts);
                }
            });

            //省份列表
            commonApi.provinceList('', {
                onSuccess(res) {
                    let provinceList = [];
                    for (let item of res.rows) {
                        let o = {};
                        o.id = item.id;
                        o.name = item.name;
                        provinceList.push(o);

                    }
                    storageUtils.set(consts.provinceList, provinceList);
                }
            });
            //行业列表
            industrysApi.list('', {
                onSuccess(res) {
                    const industrysList  = [];
                    for (let item of res.rows) {
                        let o = {};
                        o.id = item.id;
                        o.name = item.industryName;
                        industrysList.push(o);

                    }
                    storageUtils.set(consts.industrysList, industrysList);
                }
            });*/
        },
        created () {
            let tagsList = [];
            const menus = storageUtils.get('menuList');
            if (menus != undefined && menus.length>0){
                menus.map((item) => {
                    if (item.children != undefined) {
                        tagsList.push(...item.children);
                    } else {
                        tagsList.push(item);
                    }
                });
                this.$store.commit('setTagsList', tagsList);

            }
        },
        destroyed () {
        }
    });

}

