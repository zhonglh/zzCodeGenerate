package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.core.db.entity.IBoEntity;

import java.io.Serializable;


/**
* <h1>${table.javaName}Group BO , 扩展 ${table.javaName}BO 对象</h1>
* ${table.tableComment} 数据传输对象，对应界面中的所有元素
* 注意： 对象属性需要和 ${table.javaName}GroupServiceImpl.getServices 对应
* @author ${project.projectAuthor}
* @date ${.now}
*/
public class ${table.javaName}GroupBO extends ${table.mainTableConfig.javaName}GroupBO implements Serializable, IBoEntity {


    @Override
    public boolean isTable() {
        return false;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}