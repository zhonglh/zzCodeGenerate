/**
 * localStory存储类
 */
export default class storageUtils{


    static set (key, value, timeOut) {

        var curTime = new Date().getTime();
        if (timeOut != undefined){
            sessionStorage.setItem(key, JSON.stringify({data: value,time:curTime, timeout: timeOut}))
        }else {
            sessionStorage.setItem(key, JSON.stringify({data: value,time:curTime, timeout: -1}))

        }
    }

    static get(key){
        const data = sessionStorage.getItem(key);
        if(data != undefined){
            const dataObj  = JSON.parse(data);
            const  timeout = dataObj.timeout;
            if (timeout != -1){
                if ((new Date().getTime() - dataObj.time)/60000 > timeout) {
                    return undefined;
                }else {
                    return dataObj.data;
                }
            }else {
                return dataObj.data;
            }
        }else {
            return undefined;
        }
    }

    static remove(key){
        sessionStorage.removeItem(key);
    }

    static clear(){
        sessionStorage.clear();
    }

}
