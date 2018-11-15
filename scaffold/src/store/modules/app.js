import {otherRouter} from '@/router/router';
import Util from '@/utils/util';
import Vue from 'vue';
import Main from '@/views/Main';
const _import = require('@/router/_import_production');
import storageUtils from '@/utils/storageUtils';

const app = {
    state: {
        cachePage: [],
        lang: '',
        isFullScreen: false,
        openedSubmenuArr: [], // 要展开的菜单数组
        menuTheme: 'dark', // 主题
        themeColor: '',
        fetchLoading: false,
        pageOpenedList: [{
            title: '首页',
            path: '',
            name: 'home_index'
        }],
        currentPageName: '',
        currentPath: [
            {
                title: '首页',
                path: '',
                name: 'home_index'
            }
        ], // 面包屑数组
        menuList: [],
        //用户信息
        userInfo: {},
        //用户权限
        permissions: [],
        routers: [],
        tagsList: [],
        messageCount: 0,
        dontCache: ['text-editor', 'artical-publish'] // 在这里定义你不想要缓存的页面的name属性值(参见路由配置router.js)
    },
    mutations: {
        updateUserInfo (state) {
            let user = storageUtils.get('userInfo');
            if (user != undefined && user != ''){
                state.userInfo = user;
            }
        },
        updatePermissions (state, permissions){
            state.permissions = permissions;
        },
        setTagsList (state, list) {
            state.tagsList.push(...list);
        },
        updateMenulist (state, menuList) {

            if (menuList != undefined){
                for (let item of menuList) {
                    const conmponetpath = item.component;
                    item.component = Main;
                    if (item.children != undefined){
                        for (let child of item.children) {
                            if (child.component != undefined && child.component != '') child.component = _import(child.component);
                            if (child.children != undefined)
                                for (let c of child.children) {
                                    c.component = _import(c.component)
                                }

                        }
                    }else {
                        item.children = [{ path: item.path, title: item.title, name: item.name, component: _import(conmponetpath) }]
                    }

                }
                // state.menuList = [demoRouter,...menuList];
                state.menuList = [...menuList];

            }

        },
        updateFetchLoading (state, loadding){
            state.fetchLoading = loadding;
        },
        changeMenuTheme (state, theme) {
            state.menuTheme = theme;
        },
        changeMainTheme (state, mainTheme) {
            state.themeColor = mainTheme;
        },
        addOpenSubmenu (state, name) {
            let hasThisName = false;
            let isEmpty = false;
            if (name.length === 0) {
                isEmpty = true;
            }
            if (state.openedSubmenuArr.indexOf(name) > -1) {
                hasThisName = true;
            }
            if (!hasThisName && !isEmpty) {
                state.openedSubmenuArr.push(name);
            }
        },
        closePage (state, name) {
            state.cachePage.forEach((item, index) => {
                if (item === name) {
                    state.cachePage.splice(index, 1);
                }
            });
        },
        initCachepage (state) {
            if (localStorage.cachePage) {
                state.cachePage = JSON.parse(localStorage.cachePage);
            }
        },
        removeTag (state, name) {
            state.pageOpenedList.map((item, index) => {
                if (item.name === name) {
                    state.pageOpenedList.splice(index, 1);
                }
            });
        },
        pageOpenedList (state, get) {
            let openedPage = state.pageOpenedList[get.index];
            if (get.argu) {
                openedPage.argu = get.argu;
            }
            if (get.query) {
                openedPage.query = get.query;
            }
            state.pageOpenedList.splice(get.index, 1, openedPage);
        },
        clearAllTags (state) {
            state.pageOpenedList.splice(1);
            state.cachePage.length = 0;
        },
        clearOtherTags (state, vm) {
            let currentName = vm.$route.name;
            let currentIndex = 0;
            state.pageOpenedList.forEach((item, index) => {
                if (item.name === currentName) {
                    currentIndex = index;
                }
            });
            if (currentIndex === 0) {
                state.pageOpenedList.splice(1);
            } else {
                state.pageOpenedList.splice(currentIndex + 1);
                state.pageOpenedList.splice(1, currentIndex - 1);
            }
            let newCachepage = state.cachePage.filter(item => {
                return item === currentName;
            });
            state.cachePage = newCachepage;
        },
        setOpenedList (state) {
        },
        setCurrentPath (state, pathArr) {
            state.currentPath = pathArr;
        },
        setCurrentPageName (state, name) {
            state.currentPageName = name;
        },
        setAvator (state, path) {
            localStorage.avatorImgPath = path;
        },
        switchLang (state, lang) {
            state.lang = lang;
            Vue.config.lang = lang;
        },
        clearOpenedSubmenu (state) {
            state.openedSubmenuArr.length = 0;
        },
        setMessageCount (state, count) {
            state.messageCount = count;
        },
        increateTag (state, tagObj) {
            if (!Util.oneOf(tagObj.name, state.dontCache)) {
                state.cachePage.push(tagObj.name);
            }
            state.pageOpenedList.push(tagObj);
        }
    }
};

export default app;
