import axios from 'axios';
import EncryptUtil from '@/utils/EncryptUtil';
import storageUtils from '@/utils/storageUtils';
import loginApi from '@/api/loginApi';

// create an axios instance
const httpClient = axios.create({
    baseURL: process.env.BASE_API, // api的base_url
    timeout: 60000// request timeout
/*    headers:{
        'Content-Type':'application/x-www-form-urlencoded'
    },
    withCredentials:true   //加了这段就可以跨域了*/
});

// request interceptor
httpClient.interceptors.request.use(config => {
    return getConfig(config);
}, error => {
    Promise.reject(error);
});

// respone interceptor
httpClient.interceptors.response.use(
    response => {
        if (response.status === 200) {
            let data = response.data;
            let mysign = '';
            if (response.config.url.indexOf('http') != -1) {
                mysign = EncryptUtil.sign(response.config.encryptsign + data.result);
            }else {
                mysign = EncryptUtil.sign(1);
            }

            if (mysign === data.sign) {
                let result = data.result;
                if (process.env.ENCRYPT) {
                    result = EncryptUtil.decrypt(result);
                    return JSON.parse(result);
                } else {
                    return result;
                }
            } else {
                alert('数据校验异常');
                return Promise.reject(new Error('数据校验异常！'));
            }
        } else {
            alert('网络请求错误');
            return Promise.reject(new Error('网络请求错误！'));
        }
    },
    error => {
        // alert(error.message);
        return Promise.reject(error.message);
    });

function getConfig(config) {
    let param = getData(config.data);
    console.log('request paramter is :');
    console.log(param);
    if (process.env.ENCRYPT) {
        param  = EncryptUtil.encrypt(param)
    }

    let mUrl = config.url;
    if (config.method == 'get'){
        mUrl = config.url + `?param=${param}`
        config.url = config.url + `?param=${encodeURIComponent(param)}`
    }
    const {header, encryptsign} = getHeader(mUrl, getData(config.data),config.method)

    console.log('header paramter is :');
    console.log(header);
    config.data = `${param}`
    config.headers = header;
    config.encryptsign = encryptsign
    return config;
}
function getHeader(access_url, data, method) {
    let d = new Date()
    let access_time = d.getTime();
    let sessionKey= storageUtils.get('sessionKey');
    if (sessionKey == undefined) sessionKey = '';

    let contentType = method === 'POST' ? 'application/x-www-form-urlencoded' : 'application/json'

    let encryptsign = '{' +
        "machine_code:'" + '1' + '\'' +
        ', access_time:' + access_time +
        ", access_url:'" + access_url + '\'' +
        ", os_type:'" + '0' + '\'' +
        ", os_version:'1'" +
        ", sessionKey:'" + sessionKey + '\'' +
        '}'
    let jsonheader = encryptsign
    let sign = EncryptUtil.sign(jsonheader + data)
    let header = {'Content-Type': contentType, 'machine_code': '1', 'access_time': access_time, 'access_url': access_url, 'os_type': '0', 'os_version':'1', 'sessionKey': sessionKey, 'sign': sign}
    return {header, encryptsign}
}


function getData(data) {
    const {code, encryptedData, iv} = getAuth()
    const postData = margeObj2Str({'code': code, 'encryptedData': encryptedData, 'ivStr': iv}, data)
    return postData
}

function getAuth() {
    const encryptedData = '1';
    const iv = '1'
    const code = '1'
    return {code, encryptedData, iv}
}

function margeObj2Str(obj1, obj2) {
    let paramStr = ''
    if (obj1) {
        paramStr = JSON.stringify(obj1)
    }
    if (obj2) {
        let dataStr = JSON.stringify(obj2)
        paramStr = paramStr.substring(0, paramStr.length - 1) + ',' + dataStr.substring(1, dataStr.length)
    }
    return paramStr
}
export default httpClient;
