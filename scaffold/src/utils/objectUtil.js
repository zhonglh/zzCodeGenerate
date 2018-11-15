/**
 * 两个对象合并，obj2 合并到obj
 * @param obj
 * @param obj2
 * @returns {*}
 */
function objectMerge(obj,obj2){

    for(let col in obj2) {

        if (obj2[col] != undefined && obj2[col] != '') {
            obj[col] = obj2[col];
        }
    }

    return obj;
}
module.exports = {
    objectMerge: objectMerge
}
