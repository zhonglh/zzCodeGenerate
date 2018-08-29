<style lang="less">
</style>

<template>
    <div class="page-body">
        <Modal
                v-model="shows"
                :title="modalTitle"
                @on-visible-change="onVisibleChange"
                @on-ok="okFun"
                width="1000"
                loading
                draggable
                :transfer="transfer"
                :mask-closable="maskClosable"
                scrollable>

            <table-list :columns="columns" :tableData="data" :total="total" :loading="loading" :dialogInModal="dialogInModal" @selectionChange="selectionChange" @callback="callback">
            <#if querys?exists >
                <ROW slot="form">
                    <#list querys as being>
                        <#if project.queryMode == 'toolbar' >
                            <!-- 工具栏 方式 -->
                            <FormItem   <#if (being.queryTitle?exists) && (being.queryTitle?length > 0) > label="${being.queryTitle}" </#if> >

                                <#if being.columnPage?exists && being.columnPage.columnConfig?exists>
                                    <#if being.columnPage.element == 'text' || being.columnPage.element == 'textarea' >
                                        <Input type="text" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'digits' >
                                        <InputNumber  v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'number' >
                                        <InputNumber  v-model="searchForm.${being.columnPage.columnConfig.javaName}"  precision="2" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'date' >
                                        <DatePicker type="date"   v-model="searchForm.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'timestamp' >
                                        <DatePicker type="datetime"   v-model="searchForm.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'email' >
                                        <Input type="email" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'url' >
                                        <Input type="url" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />

                                    <#elseif being.columnPage.element == 'radio' >
                                        <RadioGroup v-model="searchForm.${being.columnPage.columnConfig.javaName}">
                                            <Radio v-for="(item, index) in ${being.columnPage.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                                <span>{{item.dictName}}</span>
                                            </Radio>
                                        </RadioGroup>

                                    <#elseif being.columnPage.element == 'checkbox' >
                                        <CheckboxGroup  v-model="searchForm.${being.columnPage.columnConfig.javaName}">
                                            <Checkbox  v-for="(item, index) in ${being.columnPage.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                                <span>{{item.dictName}}</span>
                                            </Checkbox >
                                        </CheckboxGroup >



                                    <#elseif being.columnPage.element == 'select' >
                                        <Select v-model="searchForm.${being.columnPage.columnConfig.javaName}" placeholder="${being.queryPlaceholder}" style="width: 200px">
                                            <Option value="">所有</Option>
                                            <Option v-for="(item, index) in ${being.columnPage.columnConfig.dictType}Dict" :value="item.dictVal" :key="item.dictVal" >{{item.dictName}}</Option>
                                        </Select>

                                    <#elseif being.columnPage.element == 'openwin' >
                                        <Input v-model="searchForm.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.originalColumn.fkTableConfig.fullResourceFile}"/>

                                    <#else >
                                        <Input type="text" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    </#if>
                                <#elseif being.columnPage?exists && being.columnPage.exColumn?exists>
                                    <#if being.columnPage.element == 'openwin' >
                                        <Input v-model="searchForm.${being.columnPage.exColumn.javaName}"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.fullResourceFile}"/>
                                    </#if>
                                <#else>
                                    <Input type="text" v-model="searchForm.${being.queryFieldName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                </#if>
                            </FormItem>
                        <#elseif project.queryMode == 'ordinary'>
                            <!-- 一个查询条件占一行 方式 -->

                            <#if being.columnPage?exists && being.columnPage.columnConfig?exists>

                                <#if being.columnPage.element == 'select' || being.columnPage.element == 'checkbox' || being.columnPage.element == 'radio'>
                                        <${being.columnPage.columnConfig.javaName}Dict <#if (being.queryTitle?exists) && (being.queryTitle?length > 0) > label="${being.queryTitle}" </#if> :selectData="${being.columnPage.columnConfig.dictType}Dict"  v-model="searchForm.${being.columnPage.columnConfig.javaName}"  @change="findList" />
                                <#elseif being.columnPage.element == 'openwin' >
                                    <Input v-model="searchForm.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.originalColumn.fkTableConfig.fullResourceFile}"/>
                                <#else>
                                    <#if being.columnPage.element == 'text' || being.columnPage.element == 'textarea' >
                                        <Input type="text" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'digits' >
                                        <InputNumber  v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'number' >
                                        <InputNumber  v-model="searchForm.${being.columnPage.columnConfig.javaName}"  precision="2" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'date' >
                                        <DatePicker type="date"   v-model="searchForm.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'timestamp' >
                                        <DatePicker type="datetime"   v-model="searchForm.${being.columnPage.columnConfig.javaName}"  clearable editable="false" style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'email' >
                                        <Input type="email" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    <#elseif being.columnPage.element == 'url' >
                                        <Input type="url" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                    </#if>
                                </#if>
                            <#elseif being.columnPage?exists && being.columnPage.exColumn?exists>
                                <#if being.columnPage.element == 'openwin' >
                                    <Input v-model="searchForm.${being.columnPage.exColumn.javaName}"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.fullResourceFile}"/>
                                </#if>
                            <#else>
                                <Input type="text" v-model="searchForm.${being.queryFieldName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                            </#if>
                        <#else>
                            //todo 项目的查询方式设置错误， 或者有新的选项添加没有及时处理
                        </#if>

                    </#list>
                </ROW>
            </#if>

            </table-list>


        <#list queryFkTables as fkTable>
            <${fkTable.fullResourceFile}Search title="选择${fkTable.tableComment}" :display="selectDisplay" :businessType="bsType"
                <#list queryFks[fkTable.fullResourceFile] as queryField >
                                               @on-selected-${queryField.columnPage.javaName}="selected${queryField.columnPage.javaName}Callback"
                </#list>
            />

        </#list>

        </Modal>
    </div>
</template>

<script>
    import ${table.javaName}Api from '@/api/${table.fullResourceFile}/${table.javaName}Api' ;
    import dialog from '@/utils/dialog'

    import commonApi from '@/api/commonApi';

    import tableList from '@/components/table-list/tableList'
    import tableMix from '@/mixins/tableMix'
    import timeFormat from '@/utils/timeformat';
    <#if project.queryMode == 'ordinary' >
    import selectSpan from '@/components/select-span/select-span';
    </#if>

    <#list queryFkTables as fkTable>
    import ${fkTable.fullResourceFile}Search from '@/views/${fkTable.fullResourceName}/${fkTable.javaName}Search'
    </#list>

    export default {
        name: '${table.fullResourceFile}List',
        components: {
            tableList,
        <#list queryFkTables as fkTable>
            ${fkTable.fullResourceFile}Search <#if fkTable_has_next>,</#if>
        </#list>
        <#if project.queryMode == 'ordinary' >
            <#list queryDicts as dict>
                ${dict.columnPage.columnConfig.javaName}Dict : selectSpan,
            </#list>
        </#if>

        },
        props: {
            modalTitle: {
                type: String,
                default: ''
            },
            url: {
                type: String,
                default: ''
            },
            display: {
                type: Boolean,
                default: false
            },
            mutiSelect: {
                type: Boolean,
                default: false
            },
            businessType: {
                type: String,
                default: ''
            }
        },
        computed: {
            shows () {
                return this.display;
            }
        },
        mixins:[tableMix],
        data () {
            return {
        ${table.fullResourceFile}: {},
            selectDisplay: false,
                    maskClosable: false,
                    bsType: '',
                    transfer: false,
                    dialogInModal: true,

            <#list queryFkTables as fkTable>
                    select${fkTable.javaName}Display: false,
            </#list>


                    searchForm:{
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
                columns: [
                {
                    title: '序号',
                    type: 'selection',
                    width: 80,
                    fixed: 'left',
                    align: 'center'
                },
            <#list listColumnPages as page>
                {
                    title: '<#if page.columnConfig?exists>${page.columnConfig.columnComment}<#else >${page.exColumn.columnTitle}</#if>',
                    key: '<#if page.columnConfig?exists>${page.columnConfig.javaName}<#else >${page.exColumn.javaName}</#if>',
                    align: 'center',
                    width: 150
                }<#if page_has_next>,</#if>
            </#list>

            ]
        };
        },



    methods: {

    <#list queryFks?values as queryFkList >
        <#list queryFkList as queryField >
            selected${queryField.columnPage.javaName}Callback(selection){
                <#if queryField.columnPage.exColumn?exists>
                    this.searchForm.${queryField.columnPage.exColumn.originalColumn.javaName} = selection.id;
                    this.searchForm.${queryField.queryFieldName} = selection.${queryField.columnPage.exColumn.fkJavaName};
                <#else >
                    this.searchForm.${queryField.columnPage.columnConfig.originalColumn.javaName} = selection.id;
                    this.searchForm.${queryField.queryFieldName} = selection.${queryField.columnPage.columnConfig.fkJavaName};
                </#if>
                this.select${queryField.columnPage.exColumn.originalColumn.fkTableConfig.javaName}Display = false ;

            },
        </#list>
    </#list>





    <#list querys as being>
        <#if being.columnPage?exists && being.columnPage.element == 'openwin' >
            <#if being.columnPage.columnConfig?exists>
            <#elseif  being.columnPage.exColumn?exists>
                select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}{

                    this.bsType='${being.columnPage.javaName}';
            this.select${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}Display = true ;
            }
            </#if>
        </#if>
    </#list>


    onVisibleChange(v) {
        if (!v){
            this.$emit('closeDialog')
        }
    },
    okFun(){

        let selectedData = this.selectedData;



        if (selectedData.length<1){
            dialog.warning('请选择要操作的数据!', this);
        }else {
            if (this.mutiSelect){
                this.$emit('on-selected-'+this.businessType,selectedData);
            } else {
                this.$emit('on-selected-'+this.businessType,selectedData[0]);
            }

        }
    },

    findList () {
        let that = this;
        ${table.javaName}Api.list(this.param, {
            onSuccess(res) {
                that.loading = false;
                that.total = res.total;
                that.data = res.rows;
            }
        });
    }
    },

    mounted () {
        this.$nextTick(function () {
            let that = this;
            this.findList();

        <#if queryDictSet?exists && (queryDictSet?size > 0) >
            commonApi.allDicts('<#list queryDictSet as queryColumn><#if queryColumn.columnPage.exColumn?exists>${queryColumn.columnPage.exColumn.dictType}<#if queryColumn_has_next>,</#if><#else>${queryColumn.columnPage.columnConfig.dictType}<#if queryColumn_has_next>,</#if></#if></#list>', {
                onSuccess(dictMap) {
                    <#list queryDictSet as queryColumn>
                        <#if queryColumn.columnPage.exColumn?exists>that.${queryColumn.columnPage.exColumn.dictType}Dict=dictMap["${queryColumn.columnPage.exColumn.dictType}"]<#if queryColumn_has_next>;</#if>
                        <#else>that.${queryColumn.columnPage.columnConfig.dictType}Dict=dictMap["${queryColumn.columnPage.columnConfig.dictType}"]<#if queryColumn_has_next>;</#if>
                        </#if>
                    </#list>
                }
            });
        </#if>



        });
    }



    };
</script>
