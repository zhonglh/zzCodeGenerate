package com.zz.bsmcc.business;

import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.freemarker.FreemarkerUtil;
import com.zz.bsmcc.base.bo.TcgProjectBO;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理字典类型类
 * @author Administrator
 */
public class DictTypeBusiness {

    public static void buildDictType(TcgProjectBO projectBO, Map<String, String> dictTypeMap) {
        Map<String , Object> model = new HashMap<String , Object>();
        String path = BusinessUtil.getBasePath() + File.separator + "enums";
        StringBuilder projectNoteBuild = BusinessUtil.getProjectNote(projectBO);

        for(Map.Entry<String,String> entry : dictTypeMap.entrySet()){

            StringBuilder sb = new StringBuilder(projectNoteBuild);

            sb.append("\n").append("package ").append(projectBO.getProjectPackage()).append(".enums; ");

            sb.append("\n").append("import java.io.Serializable;");
            sb.append("\n").append("import com.zz.bms.core.enums.EnumBase;");

            sb.append("\n\n/**");
            sb.append("\n * 字典类型 ").append(entry.getValue());
            sb.append("\n * @author ").append(projectBO.getProjectAuthor());
            sb.append("\n */");
            sb.append("\n").append("public enum Enum").append(StringFormatKit.toCapitalizeCamelCase(entry.getKey())).append(" implements EnumBase<String> {");

            sb.append("\n\n").append("  ;");
            sb.append("\n\n").append("  Enum").append(StringFormatKit.toCapitalizeCamelCase(entry.getKey())).append("(String theValue, String theName) {");
            sb.append("\n").append("        this.theValue = theValue;");
            sb.append("\n").append("        this.theName = theName;");
            sb.append("\n").append("    }");

            sb.append("\n\n").append("  String theValue ;");
            sb.append("\n").append("  String theName ;");
            sb.append("\n\n");

            sb.append("\n   @Override");
            sb.append("\n   public String getVal() {");
            sb.append("\n       return theValue;");
            sb.append("\n   }");

            sb.append("\n\n");

            sb.append("\n   @Override");
            sb.append("\n   public String getLabel() {");
            sb.append("\n       return theName;");
            sb.append("\n   }");

            sb.append("\n\n");

            sb.append("\n   @Override");
            sb.append("\n   public String getValue() {");
            sb.append("\n       return theValue;");
            sb.append("\n   }");

            sb.append("\n\n");



            sb.append("\n   public static Enum").append(StringFormatKit.toCapitalizeCamelCase(entry.getKey())).append(" getEnumByValue(String v){");
            sb.append("\n       for(Enum").append(StringFormatKit.toCapitalizeCamelCase(entry.getKey()));
            sb.append(" enum1 : Enum").append(StringFormatKit.toCapitalizeCamelCase(entry.getKey())).append(".values()){");
            sb.append("\n           if(enum1.getVal().equals(v)){");
            sb.append("\n               return enum1;");
            sb.append("\n           }");
            sb.append("\n       }");
            sb.append("\n       return  null;");
            sb.append("\n   }");




            sb.append("\n\n").append("}");

            String result = FreemarkerUtil.renderString( sb.toString() , model);

            BusinessUtil.buildFile(path, "Enum"+StringFormatKit.toCapitalizeCamelCase(entry.getKey())+".java", result);

        }
    }


}
