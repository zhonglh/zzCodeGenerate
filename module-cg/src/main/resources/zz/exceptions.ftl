package ${table.basePackage}.exceptions;

import com.fullbloom.core.exceptions.BizException;

/**
* 用户异常自定义类
*/
public class ${table.shortTableName?cap_first}Exceptions extends BizException {


public static final ${table.shortTableName?cap_first}Exceptions Save_Error = new ${table.shortTableName?cap_first}Exceptions(202090, "${table.tableComments}保存失败");
public static final ${table.shortTableName?cap_first}Exceptions Update_Error = new ${table.shortTableName?cap_first}Exceptions(202090, "${table.tableComments}修改失败");
public static final ${table.shortTableName?cap_first}Exceptions Delete_Error = new ${table.shortTableName?cap_first}Exceptions(202090, "${table.tableComments}删除失败");



public ${table.shortTableName?cap_first}Exceptions() {
}

public ${table.shortTableName?cap_first}Exceptions(int code, String msgFormat, Object... args) {
super(code, msgFormat, args);
}

public ${table.shortTableName?cap_first}Exceptions(int code, String msg) {
super(code, msg);
}

/**
* 实例化异常
*
* @param msgFormat
* @param args
* @return
*/
public ${table.shortTableName?cap_first}Exceptions newInstance(String msgFormat, Object... args) {
return new ${table.shortTableName?cap_first}Exceptions(this.code, msgFormat, args);
}

public ${table.shortTableName?cap_first}Exceptions print() {
return this;
}

}
