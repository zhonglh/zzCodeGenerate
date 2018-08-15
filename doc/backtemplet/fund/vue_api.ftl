import baseApi from '@/api/baseApi'

export default class ${table.javaName}Api extends baseApi{

static restApi() {

let serverPath = process.env.SERVER_URL;
    return {
        list: serverPath + '${table.fullResourceName}/list',
        detail: serverPath + '${table.fullResourceName}/detail/',
        checkUnique: serverPath + '${table.fullResourceName}/checkUnique/',
        checkAllUnique: serverPath + '${table.fullResourceName}/checkAllUnique/',
        <#list operations as op>
        ${op.operationResource}: serverPath + '${table.fullResourceName}/${op.operationResource}'<#if op_has_next>,</#if>
        </#list>
    };
}

    /**
    * 新增或者修改时，检验数据是否唯一
    * @param params
    */
    static checkUnique (params) {
        return this.Post(this.restApi().checkUnique, params, callBack);
    }

    /**
    * 新增或者修改时，检验数据是否唯一
    * @param params
    */
    static checkAllUnique (params) {
        return this.Post(this.restApi().checkAllUnique, params, callBack);
    }



    /**
    * ${table.tableComment}列表
    * @param params
    * @param callBack
    * @returns {Promise<*>}
    */
    static list(params, callBack){
        return this.Get(this.restApi().list, params, callBack)
    }


    /**
    * 查看${table.tableComment}
    * @param id
    * @param callBack
    * @returns {Promise<*>}
    */
    static detail(id, callBack){
        return this.Get(this.restApi().detail + id, '' , callBack)
    }


    <#list operations as op>
    /**
    * ${op.operationName}${table.tableComment}
    * @param id
    * @param callBack
    */
    static ${op.operationResource}(params,callBack){
        return this.Post(this.restApi().${op.operationResource}, params, callBack)
    }
    </#list>

}
