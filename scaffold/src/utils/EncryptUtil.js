import CryptoJS from 'crypto-js';

export default class EncryptUtil {
    /**
     *  使用前执行：  npm install crypto-js
     */
/*     var SHA1KEY = '*&^%$6jdkhf7222sdfa21saw765%$32430-{}HMD9098:?><>?';
     var DES_IV_KEY = '743BB7EB';
     var DES_SECRETKEY = 'QWERTTTQ'; */
    /**
     * sha1 加密
     * @param data
     * @returns {*|string}
     */
    static sign (data) {
        let HmacSHA1 = CryptoJS.HmacSHA1(data, '*&^%$6jdkhf7222sdfa21saw765%$32430-{}HMD9098:?><>?');
        var sign = CryptoJS.enc.Base64.stringify(HmacSHA1);
        var subStr = /\+/g;
        var result = sign.replace(subStr, '-');
        var subStr2 = /\//g;
        var results = result.replace(subStr2, '_');
        return results;
    }

    /**
     * des 加密
     * @param data
     * @returns {*|CipherParams|PromiseLike<ArrayBuffer>}
     */
    static encrypt (data) {
        var kb = CryptoJS.enc.Utf8.parse('QWERTTTQ');// KEY
        var vb = CryptoJS.enc.Utf8.parse('743BB7EB');// IV
        var eb = CryptoJS.enc.Utf8.parse(data);
        return CryptoJS.DES.encrypt(eb, kb, {
            iv: vb,
            mode: CryptoJS.mode.CBC,
            padding: CryptoJS.pad.Pkcs7
        });
    }

    /**
     * des 解密
     * @param data
     */
    static decrypt (data) {
        var kb = CryptoJS.enc.Utf8.parse('QWERTTTQ');// KEY
        var vb = CryptoJS.enc.Utf8.parse('743BB7EB');// IV
        var ub = CryptoJS.DES.decrypt(data, kb, {
            iv: vb,
            mode: CryptoJS.mode.CBC,
            padding: CryptoJS.pad.Pkcs7
        });
        return CryptoJS.enc.Utf8.stringify(ub);
    }
}
