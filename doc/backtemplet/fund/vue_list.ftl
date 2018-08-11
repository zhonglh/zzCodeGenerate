<style lang="less">

</style>

<template>
    <div class="page-body">

        <table-list :columns="columns" :tableData="data" :total="total" :loading="loading" @selectionChange="selectionChange" @callback="callback">
        <#if querys?exists >
            <div slot="form">
                <#list querys as being>
                    <#if project.queryMode == 'toolbar' >
                        <!-- 工具栏 方式 -->
                        <FormItem   <#if (being.queryTitle?exists) && (being.queryTitle?length > 0) > label="${being.queryTitle}" </#if> >

                            <#if being.columnPage?exists && being.columnPage.columnConfig?exists>
                                <#if being.columnPage.element == 'input' >
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
                                        <Radio v-for="(item, index) in ${being.columnPage.columnConfig.dictType}s" :label="item.val" :key="item.val">
                                            <span>{{item.name}}</span>
                                        </Radio>
                                    </RadioGroup>

                                <#elseif being.columnPage.element == 'checkbox' >
                                    <CheckboxGroup  v-model="searchForm.${being.columnPage.columnConfig.javaName}">
                                        <Checkbox  v-for="(item, index) in ${being.columnPage.columnConfig.dictType}s" :label="item.val" :key="item.val">
                                            <span>{{item.name}}</span>
                                        </Checkbox >
                                    </CheckboxGroup >



                                <#elseif being.columnPage.element == 'select' >
                                    <Select v-model="searchForm.${being.columnPage.columnConfig.javaName}" placeholder="${being.queryPlaceholder}" style="width: 200px">
                                        <Option value="">所有</Option>
                                        <Option v-for="(item, index) in ${being.columnPage.columnConfig.dictType}s" :value="item.val" :key="item.val" >{{item.name}}</Option>
                                    </Select>

                                <#elseif being.columnPage.element == 'openwin' >
                                    <Input v-model="searchForm.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.fkTableConfig.fullResourceFile}"/>

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
                                <${being.columnPage.columnConfig.javaName}-dicts label="<#if (being.queryTitle?exists) && (being.queryTitle?length > 0) > label="${being.queryTitle}" </#if>" :selectData="${being.columnPage.columnConfig.dictType}s"  v-model="searchForm.${being.columnPage.columnConfig.javaName}"  @change="findList" />
                            <#elseif being.columnPage.element == 'openwin' >
                                <Input v-model="searchForm.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.fkTableConfig.fullResourceFile}"/>
                            <#else>
                                <#if being.columnPage.element == 'input' >
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
                        </#if>
                    <#else>
                        //todo 项目的查询方式设置错误， 或者有新的选项添加没有及时处理
                    </#if>

                </#list>
            </div>
        </#if>

            <div slot="toolbar">
                <#list operations as operation>
                    <#if operation.position == 'top' || operation.position == 'all'>
                        <Button type="success" icon="${operation.icons}" title="${operation.operationName}"
                            <#if operation.styles?exists && operation.styles?length > 0>style="${operation.styles}"</#if>
                            <#if operation.styles?class && operation.class?length > 0>class="${operation.class}"</#if>
                                @click="changStatus">${operation.operationName}</Button>
                    </#if>
                </#list>
            </div>
        </table-list>

    </div>
</template>

<script>
    import ${table.fullResourceFile}Edit from './${table.fullResourceFile}Edit' ;
    import ${table.fullResourceFile}Api from '@/api/${table.fullResourceFile}Api' ;
    import tableList from '@/views/page-template/tableList' ;
    import tableMix from '@/views/mixins/tableMix' ;
    import timeFormat from '@/utils/timeformat';
    <#if project.queryMode == 'ordinary' >
    import selectSpan from '@/views/my-components/select-span/select-span';
    </#if>
    import userGrid from './userGrid'

    export default {
        name: '${table.fullResourceFile}List',
        components: {
            ${table.fullResourceFile}Edit,
            tableList
        },
        mixins:[tableMix],
        data () {
            return {
                notice: {},
                noticeDisplay: false,
                footerHide: true,
                searchForm:{
                    isRead: ''
                },
                columns: [
                    {
                        title: '序号',
                        type: 'selection',
                        width: 80,
                        align: 'center'
                    },
                    {
                        title: '状态',
                        align: 'center',
                        key: 'isRead',
                        width: 80,
                        render: (h, params) => {

                        let status = params.row.isRead;
            let color = '';
            if (status == '0'){

                color = '#cc9933';
                return h('Icon',{
                    props: {
                        type: 'email',
                        size: '32',
                        color: color
                    },
                })
            } else if (status == '1'){
                color = '#ccc';
                return h('Icon',{
                    props: {
                        type: 'ios-filing',
                        size: '32',
                        color: color
                    },
                })
            }

        }
        },
            {
                title: '标题',
                        align: 'center',
                    key: 'title',
                    width: 300,
                    render: (h, params,v) => {

                let that = this;
                let rowData = params.row;

                return h('a',{
                    style: {
                        height: '50px',
                        lineHeight:'50px'
                    },
                    on: {
                        click: () => {
                        that.notice = that.data[params.index];
                that.noticeDisplay =  true;
            }
            }
            },`${rowData.title}`);

            }
            },
            {
                title: '消息内容',
                        align: 'center',
                    key: 'content'
            },
            {
                title: '时间',
                        align: 'center',
                    width: 150,
                    key: 'notifyTime'
            }
        ]
        };
        },
        methods: {
        },

        mounted () {

        }
    };
</script>
