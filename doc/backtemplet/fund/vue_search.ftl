<style lang="less">
</style>

<template>
    <div class="page-body">
        <Modal
                v-model="shows"
                :title="modalTitle"
                @on-visible-change="onVisibleChange_"
                @on-ok="okFun_"
                :width="modalWidth_"
                loading
                mask
                :mask-closable="false"
                scrollable>


            <table-list :columns="tableColumns_" :tableData="tableDatas_" :total="total_" :loading="loading_" :dialogInModal="true"
                        @selectionChange="selectionChange_" @callback="tablePaddingCallback_">
            <#if (querys?exists && querys?size > 0 )>
            <Row slot="form">
                    <#list querys as being>
                        <#if project.queryMode == 'toolbar' >
                            <!-- 工具栏 方式 -->
                            <FormItem   <#if (being.queryTitle?exists) && (being.queryTitle?length > 0) > label="${being.queryTitle}" </#if> >

                                <#if being.columnPage?exists && being.columnPage.columnConfig?exists>
                                    <#if being.columnPage.element == 'text' || being.columnPage.element == 'textarea' >
                                        <Input type="text" v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'digits' >
                                        <InputNumber  v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'number' >
                                        <InputNumber  v-model="searchForm_.${being.columnPage.columnConfig.javaName}"  precision="2" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'date' >
                                        <DatePicker type="date"   v-model="searchForm_.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'timestamp' >
                                        <DatePicker type="datetime"   v-model="searchForm_.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'email' >
                                        <Input type="email" v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'url' >
                                        <Input type="url" v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />

                                    <#elseif being.columnPage.element == 'radio' >
                                        <RadioGroup v-model="searchForm_.${being.columnPage.columnConfig.javaName}">
                                            <Radio v-for="(item, index) in ${being.columnPage.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                                <span>{{item.dictName}}</span>
                                            </Radio>
                                        </RadioGroup>

                                    <#elseif being.columnPage.element == 'checkbox' >
                                        <CheckboxGroup  v-model="searchForm_.${being.columnPage.columnConfig.javaName}">
                                            <Checkbox  v-for="(item, index) in ${being.columnPage.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                                <span>{{item.dictName}}</span>
                                            </Checkbox >
                                        </CheckboxGroup >



                                    <#elseif being.columnPage.element == 'select' >
                                        <Select v-model="searchForm_.${being.columnPage.columnConfig.javaName}" placeholder="${being.queryPlaceholder}" style="width: 200px">
                                            <Option value="">所有</Option>
                                            <Option v-for="(item, index) in ${being.columnPage.columnConfig.dictType}Dict" :value="item.dictVal" :key="item.dictVal" >{{item.dictName}}</Option>
                                        </Select>

                                    <#elseif being.columnPage.element == 'openwin' >
                                        <Input v-model="searchForm_.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.originalColumn.fkTableConfig.fullResourceFile}"/>

                                    <#else >
                                        <Input type="text" v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    </#if>
                                <#elseif being.columnPage?exists && being.columnPage.exColumn?exists>
                                    <#if being.columnPage.element == 'openwin' >
                                        <Input v-model="searchForm_.${being.columnPage.exColumn.javaName}"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.fullResourceFile}"/>
                                    </#if>
                                <#else>
                                    <Input type="text" v-model="searchForm_.${being.queryFieldName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                </#if>
                            </FormItem>
                        <#elseif project.queryMode == 'ordinary'>
                            <!-- 一个查询条件占一行 方式 -->

                            <#if being.columnPage?exists && being.columnPage.columnConfig?exists>

                                <#if being.columnPage.element == 'select' || being.columnPage.element == 'checkbox' || being.columnPage.element == 'radio'>
                                        <${being.columnPage.columnConfig.javaName}Dict <#if (being.queryTitle?exists) && (being.queryTitle?length > 0) > label="${being.queryTitle}" </#if> :selectData="${being.columnPage.columnConfig.dictType}Dict"  v-model="searchForm_.${being.columnPage.columnConfig.javaName}"  @change="findList" />
                                <#elseif being.columnPage.element == 'openwin' >
                                    <Input v-model="searchForm_.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.originalColumn.fkTableConfig.fullResourceFile}"/>
                                <#else>
                                    <#if being.columnPage.element == 'text' || being.columnPage.element == 'textarea' >
                                        <Input type="text" v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'digits' >
                                        <InputNumber  v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'number' >
                                        <InputNumber  v-model="searchForm_.${being.columnPage.columnConfig.javaName}"  precision="2" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'date' >
                                        <DatePicker type="date"   v-model="searchForm_.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'timestamp' >
                                        <DatePicker type="datetime"   v-model="searchForm_.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'email' >
                                        <Input type="email" v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'url' >
                                        <Input type="url" v-model="searchForm_.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    </#if>
                                </#if>
                            <#elseif being.columnPage?exists && being.columnPage.exColumn?exists>
                                <#if being.columnPage.element == 'openwin' >
                                    <Input v-model="searchForm_.${being.columnPage.exColumn.javaName}"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.fullResourceFile}"/>
                                </#if>
                            <#else>
                                <Input type="text" v-model="searchForm_.${being.queryFieldName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                            </#if>
                        <#else>
                            //todo 项目的查询方式设置错误， 或者有新的选项添加没有及时处理
                        </#if>

                    </#list>
            </Row>
            </#if>

            </table-list>


        <#list queryFkTables as fkTable>

            <#if fkTable.isBuildUi == '1'>
            <${fkTable.fullResourceFile}Search title="选择${fkTable.tableComment}" :modalDisplay="select${fkTable.javaName}Display_"
                                               :businessType="businessType_"  @closeDialog="closeDialog_('select${fkTable.javaName}')"
                <#list queryFks[fkTable.fullResourceFile] as queryField >
                                               @on-selected-${queryField.columnPage.javaName}="selected${queryField.columnPage.javaName}Callback"
                </#list>
            />
            </#if>

        </#list>

        </Modal>
    </div>
</template>

<script>
    import ${table.javaName}Api from '@/api/${table.fullResourceFile}/${table.javaName}Api' ;
    import dialog from '@/utils/dialog'
    import commonApi from '@/api/commonApi';
    import searchMix from '@/mixins/searchMix'

    import timeFormat from '@/utils/timeformat';
    <#if project.queryMode == 'ordinary' >
    import selectSpan from '@/components/select-span/select-span';
    </#if>

    <#list queryFkTables as fkTable>
        <#if fkTable.isBuildUi == '1'>
    import ${fkTable.fullResourceFile}Search from '@/views/${fkTable.fullResourceName}/${fkTable.javaName}Search'
        </#if>
    </#list>

    export default {
        name: '${table.fullResourceFile}Search',
        mixins: [searchMix],
        components: {
        <#list queryFkTables as fkTable>

            <#if fkTable.isBuildUi == '1'>
            ${fkTable.fullResourceFile}Search <#if fkTable_has_next>,</#if>
            </#if>
        </#list>
        <#if project.queryMode == 'ordinary' >
            <#list queryDicts as dict>
                ${dict.columnPage.columnConfig.javaName}Dict : selectSpan,
            </#list>
        </#if>

        },
        props: {

            <#list columns as column>
                <#if column.columnIsfk == '1'>
                ${column.javaName} :{
                    type:String,
                default:''
                },
                </#if>
            </#list>


        },
        data () {
            return {
                ${table.fullResourceFile}: {},

            <#list queryFkTables as fkTable>
                select${fkTable.javaName}Display_: false,
            </#list>


                searchForm_:{
            <#list querys as being >
                <#if being.columnPage?exists>
                    <#if being.columnPage.element == 'openwin'>
                        <#if being.columnPage.exColumn?exists>
                        ${being.columnPage.exColumn.originalColumn.javaName}:'',
                        <#else>
                        ${being.columnPage.columnConfig.originalColumn.javaName}:'',
                        </#if>
                    </#if>
                ${being.columnPage.javaName}:'',
                <#else>
                ${being.queryFieldName}:'',
                </#if>
            </#list>

                },
        <#list queryDictSet as queryColumn>
            <#if queryColumn.columnPage.exColumn?exists>${queryColumn.columnPage.exColumn.dictType}Dict : [],
            <#else>${queryColumn.columnPage.columnConfig.dictType}Dict :[],
            </#if>
        </#list>
                tableColumns_: [
                {
                    title: '序号',
                    type: 'selection',
                    width: 80,
                    fixed: 'left',
                    align: 'center'
                },
            <#list listColumnPages as page>
            <#if (page_index < 4) >
                {
                    title: '<#if page.columnConfig?exists>${page.columnConfig.columnComment}<#else >${page.exColumn.columnTitle}</#if>',
                    key: '<#if page.columnConfig?exists>${page.columnConfig.javaName}<#else >${page.exColumn.javaName}</#if>',
                    align: 'center',
                    width: 150
                }<#if page_has_next>,</#if>
            </#if>
            </#list>

            ]
        };
        },



    methods: {

    <#list queryFks?values as queryFkList >
        <#list queryFkList as queryField >
            selected${queryField.columnPage.javaName}Callback(selection){
                <#if queryField.columnPage.exColumn?exists>
                    this.searchForm_.${queryField.columnPage.exColumn.originalColumn.javaName} = selection.id;
                    this.searchForm_.${queryField.queryFieldName} = selection.${queryField.columnPage.exColumn.fkJavaName};
                <#else >
                    this.searchForm_.${queryField.columnPage.columnConfig.originalColumn.javaName} = selection.id;
                    this.searchForm_.${queryField.queryFieldName} = selection.${queryField.columnPage.columnConfig.fkJavaName};
                </#if>
                this.select${queryField.columnPage.exColumn.originalColumn.fkTableConfig.javaName}Display_ = false ;

            },
        </#list>
    </#list>





    <#list querys as being>
        <#if being.columnPage?exists && being.columnPage.element == 'openwin' >
            <#if being.columnPage.columnConfig?exists>
            <#elseif  being.columnPage.exColumn?exists>
                select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}{

                    this.businessType_='${being.columnPage.javaName}';
            this.select${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}Display_ = true ;
            }
            </#if>
        </#if>
    </#list>



        findList () {
            let that = this;
            ${table.javaName}Api.list(this.searchParams_, {
                onSuccess(res) {
                    that.loading_ = false;
                    that.total_ = res.total;
                    that.tableDatas_ = res.rows;
                }
            });
        },
        findDicts(){

        <#if queryDictSet?exists && (queryDictSet?size > 0) >
            commonApi.allDicts('<#list queryDictSet as queryColumn><#if queryColumn.columnPage.exColumn?exists>${queryColumn.columnPage.exColumn.dictType}<#if queryColumn_has_next>,</#if><#else>${queryColumn.columnPage.columnConfig.dictType}<#if queryColumn_has_next>,</#if></#if></#list>', {
                onSuccess(dictMap) {
                    <#list queryDictSet as queryColumn>
                        <#if queryColumn.columnPage.exColumn?exists>that.${queryColumn.columnPage.exColumn.dictType}Dict = dictMap["${queryColumn.columnPage.exColumn.dictType}"]<#if queryColumn_has_next>;</#if>
                        <#else>that.${queryColumn.columnPage.columnConfig.dictType}Dict = dictMap["${queryColumn.columnPage.columnConfig.dictType}"]<#if queryColumn_has_next>;</#if>
                        </#if>
                    </#list>
                }
            });
        </#if>
        },
        customerFun(){

        },
        initData(){

        }
    },

    mounted () {

    }



    };
</script>
