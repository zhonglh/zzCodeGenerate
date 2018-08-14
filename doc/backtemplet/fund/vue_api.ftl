import baseApi from '@/api/baseApi'

export default class ${table.javaName}Api extends baseApi{

static restApi() {

let serverPath = process.env.SERVER_URL;
return {
list: serverPath + '${table.fullResourceName}/list',
save: serverPath + '${table.fullResourceName}/save/',
delete: serverPath + '${table.fullResourceName}/delete',
detail: serverPath + '${table.fullResourceName}/detail/'
checkUnique: serverPath + '${table.fullResourceName}/checkUnique/'
checkAllUnique: serverPath + '${table.fullResourceName}/checkAllUnique/'
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
* 保存${table.tableComment}
* @param params
* @param callBack
*/
static save (params, callBack) {
this.Post(this.restApi().save, params, callBack);
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
* 删除${table.tableComment}
* @param id
* @param callBack
*/
static delete(params,callBack){
return this.Post(this.restApi().delete, params, callBack)
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

}
