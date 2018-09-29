<style lang="less">

</style>

<template>
    <div class="page-body">

        <table-list :columns="columns" :tableData="data" :total="total" :loading="loading" @selectionChange="selectionChange" @callback="callback">
        <#if querys?exists >
            <Row slot="form">
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
                                    <Input v-model="searchForm.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.originalColumn.fkTableConfig.javaName}"/>

                                <#else >
                                    <Input type="text" v-model="searchForm.${being.columnPage.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                                </#if>
                            <#elseif being.columnPage?exists && being.columnPage.exColumn?exists>
                                <#if being.columnPage.element == 'openwin' >
                                    <Input v-model="searchForm.${being.columnPage.exColumn.javaName}"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}"/>
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
                                <Input v-model="searchForm.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.originalColumn.fkTableConfig.javaName}"/>
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
                                <Input v-model="searchForm.${being.columnPage.exColumn.javaName}"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}"/>
                            </#if>
                        <#else>
                            <Input type="text" v-model="searchForm.${being.queryFieldName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                        </#if>
                    <#else>
                        //todo 项目的查询方式设置错误， 或者有新的选项添加没有及时处理
                    </#if>

                </#list>
            </Row>
        </#if>

        <Row slot="toolbar">
        <#list operations as operation>
            <#if (operation.position?exists && operation.position == 'top' || operation.position == 'all') && (operation.operationResource!='update')>
                <Button   <#if (operation.other?exists && operation.other?length > 0)>type="${operation.other}"<#else >type="success"</#if>
                        title="${operation.operationName}"
                        <#if (operation.icons?exists && operation.icons?length > 0)>icon="${operation.icons}"</#if>
                        <#if (operation.styles?exists && operation.styles?length > 0)>style="${operation.styles}"</#if>
                        <#if (operation.classs?exists && operation.classs?length > 0)>class="${operation.classs}"</#if>
                    <#if operation.operationBO?exists && operation.operationBO.opMode == '1' >
                        @click="showDialog('${operation.operationName}',${operation.operationBO.selectMode},'<#if operation.operationResource == 'add' || operation.operationResource == 'update'>edit<#else >${operation.operationResource}</#if>')"
                    <#else>
                        @click="${operation.operationResource}"
                    </#if>
                    <#if table.isBuildRbac == '1'>v-show="permissions.includes('${table.fullResourceFile}:${operation.operationResource}')"</#if>
                    >${operation.operationName}</Button>
            </#if>
        </#list>
        </Row>
        </table-list>

    <#if (table.tableType =='2')>
        <${table.javaName}All :${table.javaName}="${table.javaName}" @closeDialog="closeDialog('all')"  :display="allDisplay"  />
    </#if>


    <#list operations as operation>
        <#if (operation.operationResource == 'add' || (table.tableType !='2' && operation.operationResource == 'update' ))>
        <Modal
        v-model="editDisplay"
        title="title"
        :width="1000"
        loading
        draggable
        :footerHide="true"
        :mask-closable="false"
        @on-visible-change="onVisibleChange"
        scrollable>
            <${table.javaName}Edit @saveSuccess="saveSuccess('edit')" :id="id"  @closeDialog="closeDialog('edit')"   ref="editRef"  />
        </Modal>
            <#break>
        </#if>
    </#list>

    <#if table.tableType !='2'>
    <Modal
            v-model="detailDisplay"
            title="title"
            :width="1000"
            loading
            draggable
            :footerHide="true"
            :mask-closable="false"
            @on-visible-change="onVisibleChange"
            scrollable>
        <${table.javaName}Detail  @closeDialog="closeDialog('detail')" ref="detailRef"  />
    </Modal>
    </#if>


    <#list operations as operation>
        <#if operation.operationBO?exists && operation.operationBO.opMode == '1' >
            <#if operation.operationResource != 'add' && operation.operationResource != 'update'  && operation.operationResource != 'detail'>
                <${table.javaName}${operation.operationResource?cap_first} @saveSuccess="saveSuccess('${operation.operationResource}')" @closeDialog="closeDialog('${operation.operationResource}')" :title="title"   ref="${operation.operationResource}Ref" :display="${operation.operationResource}Display" />
            </#if>
        </#if>
    </#list>



    <#list queryFkTables as fkTable>

        <#if fkTable.isBuildUi == '1'>
        <${fkTable.javaName}Search modalTitle="选择${fkTable.tableComment}" :display="select${fkTable.javaName}Display" :businessType="bsType"
            <#list queryFks[fkTable.fullResourceFile] as queryField >
                                   @on-selected-${queryField.columnPage.javaName}="selected${queryField.columnPage.javaName}Callback"
            </#list>
        />
        </#if>

    </#list>

    </div>
</template>

<script>



    import ${table.javaName}Api from '@/api/${table.fullResourceFile}/${table.javaName}Api' ;

    <#list operations as operation>
    <#if (operation.operationResource == 'update' && table.tableType =='2') >
    import ${table.javaName}All from './${table.javaName}All' ;
    <#break >
    </#if>
    </#list>

    <#list operations as operation>
    <#if (operation.operationResource == 'add' || (table.tableType !='2' && operation.operationResource == 'update'))>
    import ${table.javaName}Edit from './${table.javaName}Edit' ;
    <#break >
    </#if>
    </#list>

    <#if table.tableType !='2'>
    import ${table.javaName}Detail from './${table.javaName}Detail' ;
    </#if>

    <#list operations as operation>
    <#if operation.operationBO?exists && operation.operationBO.opMode == '1' >
    <#if operation.operationResource != 'add' && operation.operationResource != 'update' && operation.operationResource != 'detail'>
    import ${table.javaName}${operation.operationResource?cap_first} from './${table.javaName}${operation.operationResource?cap_first}' ;
    </#if>
    </#if>
    </#list>



    import dialog from '@/utils/dialog'
    import commonApi from '@/api/commonApi';
    import tableList from '@/components/table-list/tableList'
    import tableMix from '@/mixins/tableMix'
    import timeFormat from '@/utils/timeformat';
    <#if project.queryMode == 'ordinary' >
    import selectSpan from '@/components/select-span/select-span';
    </#if>

    <#list queryFkTables as fkTable>
    <#if fkTable.isBuildUi == '1'>
    import ${fkTable.javaName}Search from '@/views${fkTable.fullResourceName}/${fkTable.javaName}Search'
    </#if>
    </#list>

    export default {
        name: '${table.javaName}List',

        components: {

    <#list operations as operation>
        <#if (operation.operationResource == 'update' && table.tableType =='2') >
            ${table.javaName}All ,
            <#break >
        </#if>
    </#list>

    <#list operations as operation>
    <#if (operation.operationResource == 'add' || (table.tableType !='2' && operation.operationResource == 'update'))>
        ${table.javaName}Edit,
        <#break >
    </#if>
    </#list>

    <#if table.tableType !='2'>
        ${table.javaName}Detail,
    </#if>



    <#list operations as operation>
        <#if operation.operationBO?exists && operation.operationBO.opMode == '1' >
            <#if operation.operationResource != 'add' && operation.operationResource != 'update' && operation.operationResource != 'detail'>
            ${table.javaName}${operation.operationResource?cap_first} ,
            </#if>
        </#if>
    </#list>

        tableList,
    <#list queryFkTables as fkTable>
        <#if fkTable.isBuildUi == '1'>
        ${fkTable.javaName}Search <#if fkTable_has_next>,</#if>
        </#if>
    </#list>
    <#if project.queryMode == 'ordinary' >
        <#list queryDicts as dict>
            ${dict.columnPage.columnConfig.javaName}Dict : selectSpan,
        </#list>
    </#if>

    },
    mixins:[tableMix],

    props:{
    <#list columns as column>
    <#if column.columnIsfk == '1'>
        ${column.javaName} :{
            type:String,
            default:''
        },
    </#if>
    </#list>


    },

    watch: {

    <#list columns as column>
        <#if column.columnIsfk == '1'>
        ${column.javaName} : function (newVal, oldVal) {
            this.findList();
        },
        </#if>
    </#list>

    },
    data () {
        return {
            ${table.javaName}: {},



            <#list operations as operation>
            <#if operation.operationResource == 'detail'>
            detailDisplay: false,
            <#break>
            </#if>
            </#list>


            <#list operations as operation>
            <#if (operation.operationResource == 'add' || (table.tableType !='2' && operation.operationResource == 'update'))>
            editDisplay: false,
            <#break >
            </#if>
            </#list>


            <#list operations as operation>
            <#if (operation.operationResource == 'update' && table.tableType =='2') >
            allDisplay: false,
            </#if>
            </#list>

            <#list operations as operation>
            <#if operation.operationBO?exists && operation.operationBO.opMode == '1' >
            <#if operation.operationResource != 'add' && operation.operationResource != 'update' && operation.operationResource != 'detail'>
            ${operation.operationResource}Display: false,
            </#if>
            </#if>
            </#list>

    <#list queryFkTables as fkTable>
            select${fkTable.javaName}Display: false,
    </#list>

            bsType: '',

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
            ${being.columnPage.javaName}:''<#if being_has_next>,</#if>
            <#else>
            ${being.queryFieldName}:''<#if being_has_next>,</#if>
            </#if>
        </#list>
            },

    <#list queryDictSet as queryColumn>
        <#if queryColumn.columnPage.exColumn?exists>
                    ${queryColumn.columnPage.exColumn.dictType}Dict : [],
        <#else>
                    ${queryColumn.columnPage.columnConfig.dictType}Dict :[],
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
            <#if (page_index == 0 )>

                <#if table.pageRelation == '2' >
                    ,
                    render: (h, params) => {
                        let that = this;
                        let data = params.row;
                        let title = data[<#if page.columnConfig?exists>${page.columnConfig.javaName}<#else >${page.exColumn.javaName}</#if>];
                        return h('a',{
                            style: {
                                height: '30px',
                                lineHeight:'30px',
                                fontWeight:'bold'
                            },
                            on: {
                                click: () => {
                                    <#if table.tableType =='2'>
                                        that.${table.javaName} =  that.data[params.index];
                                        that.showModelDialog(`${table.tableComment}详细`, 'all', true);
                                    <#else >
                                        that.${table.javaName} =  that.data[params.index];
                                        that.id = that.data[params.index].id;
                                        that.showModelDialog(`${table.tableComment}`, 'edit', true);
                                    </#if>
                                }
                            }
                        },`${r'${title}'}`);
                    }
                </#if>



            <#elseif page.element == 'date'>
            ,
            render: (h, params) => {
                return timeFormat.formatTime(params.row.${page.columnConfig.javaName},'Y-M-D');
            }
            <#elseif page.element == 'timestamp'>
            ,
            render: (h, params) => {
                return timeFormat.formatTime(params.row.${page.columnConfig.javaName},'Y-M-D h:m:s');
            }
            </#if>
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

    <#list operations as operation>
        <#if operation.operationBO?exists && operation.operationBO.opMode != '1' >
            ${operation.operationResource}(){
            let that = this;


            <#if operation.operationBO.selectMode == '2' >
                if (this.selectedIds.length <1){
                    dialog.warning('请选择要操作的数据!',that);
                    return ;
                }
            <#elseif operation.operationBO.selectMode == '1' >
                if (this.selectedIds.length <1){
                    dialog.warning('请选择要操作的数据!',that);
                    return ;
                }else if (this.selectedIds.length >1){
                    dialog.warning('每次只能操作一条数据!',that);
                    return ;
                }
            </#if>
            let confirmMsg = '确认要${operation.operationName}该${table.tableComment}？';
            let dialogFlag = dialog.confirm(confirmMsg);

            if (dialogFlag) {
                ${table.javaName}Api.${operation.operationResource}({ids: this.selectedIds.join(',')}, {
                    onSuccess(res){
                        dialog.success("${operation.operationName}${table.tableComment}成功",that);
                        that.findList();
                    }
                })
            }
        },
        </#if>
    </#list>

        findList (){
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
                        <#if queryColumn.columnPage.exColumn?exists>that.${queryColumn.columnPage.exColumn.dictType}Dict = dictMap["${queryColumn.columnPage.exColumn.dictType}"]<#if queryColumn_has_next>;</#if>
                        <#else>that.${queryColumn.columnPage.columnConfig.dictType}Dict = dictMap["${queryColumn.columnPage.columnConfig.dictType}"]<#if queryColumn_has_next>;</#if>
                        </#if>
                    </#list>
                }
            });
        </#if>
        });
    }

    };
</script>
