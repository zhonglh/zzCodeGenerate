    <style lang="less">
    </style>

    <template>
        <div class="page-body">
            <Modal
                    v-model="shows"
                    :title="title"
                    @on-visible-change="onVisibleChange"
                    @on-ok="okFun"
                    width="1000"
                    loading
                    scrollable>

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
                                    <${being.columnPage.columnConfig.javaName}Dict label="<#if (being.queryTitle?exists) && (being.queryTitle?length > 0) > label="${being.queryTitle}" </#if>" :selectData="${being.columnPage.columnConfig.dictType}s"  v-model="searchForm.${being.columnPage.columnConfig.javaName}"  @change="findList" />
                                <#elseif being.columnPage.element == 'openwin' >
                                    <Input v-model="searchForm.${being.columnPage.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${being.columnPage.columnConfig.javaName}_${being.columnPage.columnConfig.originalColumn.fkTableConfig.fullResourceFile}"/>
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
                            <#else>
                                <Input type="text" v-model="searchForm.${being.queryFieldName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                            </#if>
                        <#else>
                            //todo 项目的查询方式设置错误， 或者有新的选项添加没有及时处理
                        </#if>

                    </#list>
                </div>
            </#if>

            </table-list>

        <#list queryFkTables as fkTable>
            <${fkTable.fullResourceFile}Search title="选择${fkTable.tableComment}" :display="selectDisplay" :type="type"
                                               <#list queryFks[fkTable().getFullResourceFile()] as queryField >
                                               @on-selected-${queryField.columnPage.javaName}="selected${queryField.columnPage.javaName}Fun"
                                               </#list>
            />

        </#list>

            </Modal>
        </div>
    </template>

    <script>
        import ${table.fullResourceFile}Edit from './${table.fullResourceFile}Edit' ;
        import ${table.fullResourceFile}View from './${table.fullResourceFile}View' ;
        import ${table.fullResourceFile}Api from '@/api/${table.fullResourceFile}Api' ;

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
                ${table.fullResourceFile}Edit,
                ${table.fullResourceFile}View,
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
                type: {
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
                    type: '',
                    searchForm:{
                        <#list querys as being >
                        <#if being.columnPage?exists>
                        <#if being.columnPage.element == 'openwin'>
                            <#if being.columnPage.exColumn?exists>
                            ${being.columnPage.exColumn.originalColumn.javaName},
                            <#else>
                            ${being.columnPage.columnConfig.originalColumn.javaName},
                            </#if>
                        </#if>
                        ${being.columnPage.javaName},
                        <#else>
                        ${being.queryFieldName},
                        </#if>
                        </#list>

                    },
                    <#list queryDictSet as queryColumn>
                        <#if queryColumn.columnPage.exColumn?exists>${queryColumn.columnPage.exColumn.dictType}Dict : [],
                        <#else>that.${queryColumn.columnPage.columnConfig.dictType}Dict :[],
                        </#if>
                    </#list>
                    columns: [
                        {
                            title: '序号',
                            type: 'index',
                            width: 80,
                            fixed: 'left',
                            align: 'center'
                        },
                        <#list listColumnPages as page>
                            {
                                title: '<#if page.columnConfig?exists>${page.columnConfig.columnComment}<#else >${page.exColumn.columnTitle}</#if>',
                                key: '<#if page.columnConfig?exists>${page.columnConfig.javaName}<#else >${page.exColumn.javaName}</#if>',
                                fixed: 'left',
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
                    selected${queryField.columnPage.javaName}Fun(selection){
                        <#if queryField.columnPage.exColumn?exists>
                            this.searchForm.${queryField.columnPage.exColumn.originalColumn.javaName} = selection.id;
                            this.searchForm.${queryField.javaName} = selection.${queryField.columnPage.exColumn.fkJavaName};
                        <#else >
                            this.searchForm.${queryField.columnPage.columnConfig.originalColumn.javaName} = selection.id;
                            this.searchForm.${queryField.javaName} = selection.${queryField.columnPage.columnConfig.fkJavaName};
                        </#if>
                        this.selectDisplay = false;

                    },
                </#list>
                </#list>



            <#list querys as being>
                <#if being.columnPage?exists && being.columnPage.element == 'openwin' >
                    <#if being.columnPage.columnConfig?exists>
                    <#elseif  being.columnPage.exColumn?exists>
                        select_${being.columnPage.exColumn.javaName}_${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}{

                            this.type='${being.columnPage.javaName}';
                    this.select${being.columnPage.exColumn.originalColumn.fkTableConfig.javaName}Display = true ;
                    }
                    </#if>
                </#if>
            </#list>


            onVisibleChange(v) {
                this.$emit('onVisibleChange',v);
            },
            okFun(){

                let selectedData = this.selectedData;



                if (selectedData.length<1){
                    this.$Message.error('请选择要数据！')
                }else {
                    if (this.mutiSelect){
                        this.$emit('on-selected-'+this.type,selectedData);
                    } else {
                        this.$emit('on-selected-'+this.type,selectedData[0]);
                    }

                }
            },

                findList () {
                    let that = this;
                    ${table.fullResourceFile}Api.${table.fullResourceFile}List(this.param).then(response => {
                        const body = response.data.result.body;
                    that.total = body.total;
                    that.loading = false;
                    that.data = body.data;
                });
                }
            },

            mounted () {
                let that = this;
                this.findList();


            commonApi.allDicts(<#list queryDictSet as queryColumn><#if queryColumn.columnPage.exColumn?exists>${queryColumn.columnPage.exColumn.dictType}<#if queryColumn_has_next>,</#if><#else>that.${queryColumn.columnPage.columnConfig.dictType}<#if queryColumn_has_next>,</#if></#if></#list>).then(response => {
                let dictMap = response.data.result.body.data;
                    <#list queryDictSet as queryColumn>
                        <#if queryColumn.columnPage.exColumn?exists>that.${queryColumn.columnPage.exColumn.dictType}Dict=dictMap.get("${queryColumn.columnPage.exColumn.dictType}"),
                        <#else>that.${queryColumn.columnPage.columnConfig.dictType}Dict=dictMap.get("${queryColumn.columnPage.columnConfig.dictType}"),
                        </#if>
                    </#list>

                    });

            }
        };
    </script>
