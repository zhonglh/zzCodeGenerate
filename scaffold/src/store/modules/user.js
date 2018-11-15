import Cookies from 'js-cookie';
import storageUtils from '@/utils/storageUtils'
import loginApi from "../../api/loginApi";

const user = {
    state: {},
    mutations: {
        logout (state, vm) {

            loginApi.logout().then(response => {

                storageUtils.clear();
                Cookies.remove('sessionKey');
                Cookies.remove('userInfo');
                // 恢复默认样式
                let themeLink = document.querySelector('link[name="theme"]');
                themeLink.setAttribute('href', '');
                // 清空打开的页面等数据，但是保存主题数据
                let theme = '';
                if (localStorage.theme) {
                    theme = localStorage.theme;
                }
                localStorage.clear();
                if (theme) {
                    localStorage.theme = theme;
                }

                const loginUrl = response.body.url;
                window.location.href = loginUrl;
            });

        }
    }
};

export default user;
