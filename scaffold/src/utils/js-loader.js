/**
 * 加载js文件
 * @param src
 */
const jsLoader = function (src) {
    var jqscript = document.createElement('script');
    jqscript.type = 'text/javascript';
    jqscript.src = src;
    document.getElementsByTagName('head')[0].appendChild(jqscript);
};

export default jsLoader;
