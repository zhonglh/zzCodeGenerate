package ${table.basePackage}.bo;

import com.zz.bsmcc.base.domain.${table.shortTableName?cap_first}Entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* ${table.tableComments} BO , 扩展 ${table.tableComments}Entity对象
* @author Administrator
*/
@EntityAnnotation(value="${table.tableComments}" , resource = "")
@TableName(value="${table.tableName}" , resultMap = "${table.shortTableName?cap_first}ResultMap")
public class ${table.shortTableName?cap_first}BO extends ${table.shortTableName?cap_first}Entity implements Serializable {

}
