package ${table.fullPackageName}.${templet.fileInnerPackage};

import ${table.fullPackageName}.BaseTest;
import ${table.fullPackageName}.domain.${table.javaName};
import ${table.fullPackageName}.interfaces.${table.javaName}Service;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.fullbloom.utils.java.IdUtils;
import com.fullbloom.core.exceptions.NoAutoException;
import com.fullbloom.core.exceptions.DbException;


/**
 *
 *  ${table.javaName} ${templet.fileInnerPackage} 层测试类
 *
 */
public class ${table.javaName}${templet.fileSuffix} extends BaseTest {

    @Autowired
    private ${table.javaName}Service ${table.javaName?uncap_first}Service;


    private String insertId ;

    @Test
    public void testSuccessInsert(){
        ${table.javaName} addObj = new ${table.javaName}();
        <#list columns as column>
        <#if column.columnIsnull == '0'>
            <#if column.columnIskey == '1'>
            addObj.${column.setMethodName}(IdUtils.getId());
            <#elseif column.columnIsfk == '1'>
            addObj.${column.setMethodName}(IdUtils.getId());
            <#elseif column.columnIsdict == '1'>
            addObj.${column.setMethodName}("1");
            <#else >
                addObj.${column.setMethodName}(this.new${column.javaSimpleClass}(<#if (column.columnLength?exists)>${column.columnLength}<#else >0</#if>));
            </#if>
        </#if>
        </#list>
        int size = ${table.javaName?uncap_first}Service.save(addObj);
        Assert.assertEquals(size  , 1);

        insertId =  addObj.getId();

        ${table.javaName} result = ${table.javaName?uncap_first}Service.findById(insertId);
        Assert.assertEquals(result.getId()  , addObj.getId());
    }


    @Test
    public void testFailInsert(){
        ${table.javaName} addObj = new ${table.javaName}();

        //只设置非必填的
        <#list columns as column>
            <#if column.columnIsnull == '1'>
                <#if column.columnIskey == '1'>
                addObj.${column.setMethodName}(IdUtils.getId());
                <#elseif column.columnIsfk == '1'>
                addObj.${column.setMethodName}(IdUtils.getId());
                <#elseif column.columnIsdict == '1'>
                addObj.${column.setMethodName}("1");
                <#else >
                addObj.${column.setMethodName}(this.new${column.javaSimpleClass}(<#if (column.columnLength?exists)>${column.columnLength}<#else >0</#if>));
                </#if>
            </#if>
        </#list>
        try{
            int size = ${table.javaName?uncap_first}Service.save(addObj);
            Assert.assertEquals(size  , 0);
        }catch(Exception e){
            Assert.assertEquals(1  , 1);
        }
    }

    @Test
    public void testDelete(){
        testSuccessInsert();
        String id = insertId;
        ${table.javaName} delObj = new ${table.javaName}();
        delObj.setId(id);
        int size = ${table.javaName?uncap_first}Service.delete(delObj);
        Assert.assertEquals(size  , 1);
        try{
            ${table.javaName}  obj = ${table.javaName?uncap_first}Service.findById(id);
            Assert.assertNull(obj);
        }catch(NoAutoException e){

        }catch(Exception e){
            Assert.assertEquals(2  , 1);
        }
    }


    @Test
    public void testUpdate(){
        testSuccessInsert();
        String id = insertId;
        Timestamp curr = new Timestamp(System.currentTimeMillis());
        ${table.javaName}  obj = ${table.javaName?uncap_first}Service.findById(id);
        obj.setUpdateTime(curr);
        int size = ${table.javaName?uncap_first}Service.update(obj);
        Assert.assertEquals(size  , 1);

        try{
            ${table.javaName}  result = ${table.javaName?uncap_first}Service.findById(id);
            Assert.assertTrue(curr.getTime()  - result.getUpdateTime().getTime() < 1000);
        }catch(Exception e){
            Assert.assertEquals(2  , 1);
        }
    }



}


