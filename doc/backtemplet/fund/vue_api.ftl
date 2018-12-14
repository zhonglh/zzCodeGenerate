import baseApi from '@/api/baseApi'

export default class ${table.javaName}Api extends baseApi{

static restApi() {

let serverPath = process.env.SERVER_URL;
    return {
        list: serverPath + '${table.fullResourceName}/list',
        detail: serverPath + '${table.fullResourceName}/detail/',
        detailByFk: serverPath + '${table.fullResourceName}/detailByFk/',
        detailBy: serverPath + '${table.fullResourceName}/detailBy/',
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
    static checkUnique (params, callBack) {
        return this.Post(this.restApi().checkUnique, params, callBack);
    }

    /**
    * 新增或者修改时，检验数据是否唯一
    * @param params
    */
    static checkAllUnique (params, callBack) {
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

    /**
    * 查看${table.tableComment} , 根据外键
    * @param id
    * @param callBack
    * @returns {Promise<*>}
    */
    static detailByFk(fkName, fkId, callBack){
        return this.Get(this.restApi().detailByFk + fkName + "/"+fkId, '' , callBack)
    }

    /**
    * 查看${table.tableComment} , 根据查询条件
    * @param id
    * @param callBack
    * @returns {Promise<*>}
    */
    static detailBy(params, callBack){
        return this.Get(this.restApi().detailBy, params, callBack)
    }




    <#list operations as op>
    <#if (op.operationResource != 'detail' && op.operationResource != 'detailByFk')>
    /**
    * ${op.operationName}${table.tableComment}
    * @param id
    * @param callBack
    */
    static ${op.operationResource}(params,callBack){
        return this.Post(this.restApi().${op.operationResource}, params, callBack)
    }
    </#if>
    </#list>

}
