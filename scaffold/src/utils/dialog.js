export default class dialog {

    /**
     * 确认框
     * @param content
     * @param okFun
     */
    static confirm(content){

/*
        $.confirm({
            title: title,
            content: content,
            type: 'green',
            buttons: {
                ok: {
                    text: "ok!",
                    btnClass: 'btn-primary',
                    keys: ['enter'],
                    action: okFun
                }
            }
        });

*/

        // new $.flavr().confirm(content, onFun, function(){ });

        var r = confirm(content);
        return r;
    }

    static success(content, ctx) {
        ctx.$Message.success(content);
    }

    static warning(content, ctx) {
        ctx.$Message.warning(content);
    }

    static error(content, ctx) {
        ctx.$Message.error(content);
    }


}
