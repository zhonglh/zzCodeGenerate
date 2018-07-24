package ${table.basePackage}.domain;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ${table.tableComments} 用于装载用户在查询时提交的数据
 * 链式查询
 * @author ${table.author}
 * @date ${.now}
 */
public class ${table.shortTableName?cap_first}QueryWebImpl<PK extends Serializable> extends ${table.shortTableName?cap_first}AbstractQueryImpl<PK> implements Serializable {

<#list table.columnList as being>




	<#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">

		<#if being.shortColumnName == "id" ||  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">


            private PK ${being.shortColumnName}_IN;
            private PK ${being.shortColumnName}_NOTIN;
		<#elseif being.columnPrecision == "1" || being.columnPrecision == "2" >


            private String ${being.shortColumnName}_IN;
            private String ${being.shortColumnName}_NOTIN;

		<#else>

            private String ${being.shortColumnName}_IN;
            private String ${being.shortColumnName}_NOTIN;
		</#if>

	<#else>
        ;
	</#if>



</#list>











<#list table.columnList as being>




        <#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">

            <#if being.shortColumnName == "id" ||  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">




                public PK get${being.shortColumnName?cap_first}() {
                    return ${being.shortColumnName};
                }


                public void set${being.shortColumnName?cap_first}(PK ${being.shortColumnName}) {
                    this.${being.shortColumnName} = ${being.shortColumnName};
                }


                public PK get${being.shortColumnName?cap_first}_NE() {
                return ${being.shortColumnName}_NE;
                }


                public void set${being.shortColumnName?cap_first}_NE(PK ${being.shortColumnName}_NE) {
                this.${being.shortColumnName}_NE = ${being.shortColumnName}_NE;
                }








                public PK get${being.shortColumnName?cap_first}_IN() {
                    return ${being.shortColumnName}_IN;
                }

                public void set${being.shortColumnName?cap_first}_IN(PK ${being.shortColumnName}_IN) {
                    this.${being.shortColumnName}_IN = ${being.shortColumnName}_IN;
                }

                public PK get${being.shortColumnName?cap_first}_NOTIN() {
                    return ${being.shortColumnName}_NOTIN;
                }

                public void set${being.shortColumnName?cap_first}_NOTIN(PK ${being.shortColumnName}_NOTIN) {
                    this.${being.shortColumnName}_NOTIN = ${being.shortColumnName}_NOTIN;
                }



            <#elseif being.columnPrecision == "1" || being.columnPrecision == "2" >




                public String get${being.shortColumnName?cap_first}() {
                    return ${being.shortColumnName};
                }


                public void set${being.shortColumnName?cap_first}(String ${being.shortColumnName}) {
                    this.${being.shortColumnName} = ${being.shortColumnName};
                }


                public String get${being.shortColumnName?cap_first}_NE() {
                    return ${being.shortColumnName}_NE;
                }


                public void set${being.shortColumnName?cap_first}_NE(String ${being.shortColumnName}_NE) {
                    this.${being.shortColumnName}_NE = ${being.shortColumnName}_NE;
                }



                public String get${being.shortColumnName?cap_first}_IN() {
                    return ${being.shortColumnName}_IN;
                }

                public void set${being.shortColumnName?cap_first}_IN(String ${being.shortColumnName}_IN) {
                    this.${being.shortColumnName}_IN = ${being.shortColumnName}_IN;
                }

                public String get${being.shortColumnName?cap_first}_NOTIN() {
                    return ${being.shortColumnName}_NOTIN;
                }

                public void set${being.shortColumnName?cap_first}_NOTIN(String ${being.shortColumnName}_NOTIN) {
                    this.${being.shortColumnName}_NOTIN = ${being.shortColumnName}_NOTIN;
                }

            <#else>




                public String get${being.shortColumnName?cap_first}() {
                    return ${being.shortColumnName};
                }


                public void set${being.shortColumnName?cap_first}(String ${being.shortColumnName}) {
                    this.${being.shortColumnName} = ${being.shortColumnName};
                }


                public String get${being.shortColumnName?cap_first}_NE() {
                    return ${being.shortColumnName}_NE;
                }


                public void set${being.shortColumnName?cap_first}_NE(String ${being.shortColumnName}_NE) {
                    this.${being.shortColumnName}_NE = ${being.shortColumnName}_NE;
                }



                public String get${being.shortColumnName?cap_first}_IN() {
                    return ${being.shortColumnName}_IN;
                }

                public void set${being.shortColumnName?cap_first}_IN(String ${being.shortColumnName}_IN) {
                    this.${being.shortColumnName}_IN = ${being.shortColumnName}_IN;
                }

                public String get${being.shortColumnName?cap_first}_NOTIN() {
                    return ${being.shortColumnName}_NOTIN;
                }

                public void set${being.shortColumnName?cap_first}_NOTIN(String ${being.shortColumnName}_NOTIN) {
                    this.${being.shortColumnName}_NOTIN = ${being.shortColumnName}_NOTIN;
                }




                public String get${being.shortColumnName?cap_first}_LIKE() {
                    return ${being.shortColumnName}_LIKE;
                }

                public void set${being.shortColumnName?cap_first}_LIKE(String ${being.shortColumnName}_LIKE) {
                    this.${being.shortColumnName}_LIKE = ${being.shortColumnName}_LIKE;
                }

                public String get${being.shortColumnName?cap_first}_NOTLIKE() {
                    return ${being.shortColumnName}_NOTLIKE;
                }

                public void set${being.shortColumnName?cap_first}_NOTLIKE(String ${being.shortColumnName}_NOTLIKE) {
                    this.${being.shortColumnName}_NOTLIKE = ${being.shortColumnName}_NOTLIKE;
                }
            </#if>



        <#elseif being.columnType=="int" || being.columnType=="double" || being.columnType=="decimal" || being.columnType=="long"  || being.columnType=="number" >


            public ${being.javaType} get${being.shortColumnName?cap_first}() {
                return ${being.shortColumnName};
            }


            public void set${being.shortColumnName?cap_first}(${being.javaType} ${being.shortColumnName}) {
                this.${being.shortColumnName} = ${being.shortColumnName};
            }


            public ${being.javaType} get${being.shortColumnName?cap_first}_NE() {
                return ${being.shortColumnName}_NE;
            }


            public void set${being.shortColumnName?cap_first}_NE(${being.javaType} ${being.shortColumnName}_NE) {
                this.${being.shortColumnName}_NE = ${being.shortColumnName}_NE;
            }



            public ${being.javaType} get${being.shortColumnName?cap_first}_GT() {
                return ${being.shortColumnName}_GT;
            }


            public void set${being.shortColumnName?cap_first}_GT(${being.javaType} ${being.shortColumnName}_GT) {
                this.${being.shortColumnName}_GT = ${being.shortColumnName}_GT;
            }


            public ${being.javaType} get${being.shortColumnName?cap_first}_GE() {
                return ${being.shortColumnName}_GE;
            }


            public void set${being.shortColumnName?cap_first}_GE(${being.javaType} ${being.shortColumnName}_GE) {
                this.${being.shortColumnName}_GE = ${being.shortColumnName}_GE;
            }




            public ${being.javaType} get${being.shortColumnName?cap_first}_LT() {
                return ${being.shortColumnName}_LT;
            }


            public void set${being.shortColumnName?cap_first}_LT(${being.javaType} ${being.shortColumnName}_LT) {
                this.${being.shortColumnName}_LT = ${being.shortColumnName}_LT;
            }


            public ${being.javaType} get${being.shortColumnName?cap_first}_LE() {
                return ${being.shortColumnName}_LE;
            }


            public void set${being.shortColumnName?cap_first}_LE(${being.javaType} ${being.shortColumnName}_LE) {
                this.${being.shortColumnName}_LE = ${being.shortColumnName}_LE;
            }



        <#elseif being.columnType=="date" || being.columnType=="timestamp" >



            public ${being.javaType} get${being.shortColumnName?cap_first}() {
                return ${being.shortColumnName};
            }


            public void set${being.shortColumnName?cap_first}(${being.javaType} ${being.shortColumnName}) {
                this.${being.shortColumnName} = ${being.shortColumnName};
            }


            public ${being.javaType} get${being.shortColumnName?cap_first}_NE() {
                return ${being.shortColumnName}_NE;
            }


            public void set${being.shortColumnName?cap_first}_NE(${being.javaType} ${being.shortColumnName}_NE) {
                this.${being.shortColumnName}_NE = ${being.shortColumnName}_NE;
            }



            public ${being.javaType} get${being.shortColumnName?cap_first}_GT() {
                return ${being.shortColumnName}_GT;
            }


            public void set${being.shortColumnName?cap_first}_GT(${being.javaType} ${being.shortColumnName}_GT) {
                this.${being.shortColumnName}_GT = ${being.shortColumnName}_GT;
            }


            public ${being.javaType} get${being.shortColumnName?cap_first}_GE() {
                return ${being.shortColumnName}_GE;
            }


            public void set${being.shortColumnName?cap_first}_GE(${being.javaType} ${being.shortColumnName}_GE) {
                this.${being.shortColumnName}_GE = ${being.shortColumnName}_GE;
            }




            public ${being.javaType} get${being.shortColumnName?cap_first}_LT() {
                return ${being.shortColumnName}_LT;
            }


            public void set${being.shortColumnName?cap_first}_LT(${being.javaType} ${being.shortColumnName}_LT) {
                this.${being.shortColumnName}_LT = ${being.shortColumnName}_LT;
            }


            public ${being.javaType} get${being.shortColumnName?cap_first}_LE() {
                return ${being.shortColumnName}_LE;
            }


            public void set${being.shortColumnName?cap_first}_LE(${being.javaType} ${being.shortColumnName}_LE) {
                this.${being.shortColumnName}_LE = ${being.shortColumnName}_LE;
            }

        <#else>
            ;
        </#if>



</#list>

	
}