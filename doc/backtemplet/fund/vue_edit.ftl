<style>

</style>
<template>
    <Modal
            v-model="show"
            :title="title"
            @on-visible-change="onVisibleChange"
            :width="dialogWidth"
            loading
            draggable
            :mask-closable="maskClosable"
            scrollable>


        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="labelWidth">
        <#list showColumnPages as page>
            <#if (page_index==0)>
            <Row style="padding : 10px ">
            </#if>

            <#if page.editable == '0'>
                <Col :xs="24" :sm="12" :md="12" :lg="12">
                <FormItem label="${page.columnComment}" prop="${page.javaName}">
                    {{ formValidate.${page.javaName} }}
                </FormItem>
                </Col>
            <#elseif page.editable == '1'>

                <Col :xs="24" :sm="12" :md="12" :lg="12">
                <FormItem label="${page.columnComment}" prop="${page.javaName}">
                    <#if page?exists && page.columnConfig?exists>
                        <#if page.element == 'input' >
                            <Input type="text" v-model="formValidate.${page.columnConfig.javaName}" step="1" precision="0"
                                   <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                   <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'digits' >
                            <InputNumber  v-model="formValidate.${page.columnConfig.javaName}"
                                          <#if page.min?exists && page.min != 0>min="${page.min}"</#if> <#if page.max?exists && page.max != 0>max="${page.max}"</#if>
                                             
                                <#if page.events?exists>
                                    <#list page.events as event>
                                          @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'number' >
                            <InputNumber  v-model="formValidate.${page.columnConfig.javaName}"  precision="2"
                                          <#if page.min?exists && page.min != 0>min="${page.min}"</#if> <#if page.max?exists && page.max != 0>max="${page.max}"</#if>
                                             
                                <#if page.events?exists>
                                    <#list page.events as event>
                                          @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'date' >
                            <DatePicker type="date"   v-model="formValidate.${page.columnConfig.javaName}"  clearable editable="false"
                                <#if page.events?exists>
                                    <#list page.events as event>
                                        @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                                             />
                        <#elseif page.element == 'timestamp' >
                            <DatePicker type="datetime"   v-model="formValidate.${page.columnConfig.javaName}"  clearable editable="false"
                                <#if page.events?exists>
                                    <#list page.events as event>
                                        @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                                             />
                        <#elseif page.element == 'email' >
                            <Input type="email" v-model="formValidate.${page.columnConfig.javaName}"
                                   <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                   <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>  />
                        <#elseif page.element == 'url' >
                            <Input type="url" v-model="formValidate.${page.columnConfig.javaName}"
                                   <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                   <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>  />

                        <#elseif page.element == 'radio' >
                            <RadioGroup v-model="formValidate.${page.columnConfig.javaName}">
                                <Radio v-for="(item, index) in ${page.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                    <span>{{item.dictName}}</span>
                                </Radio>
                            </RadioGroup>

                        <#elseif page.element == 'checkbox' >
                            <CheckboxGroup  v-model="formValidate.${page.columnConfig.javaName}">
                                <Checkbox  v-for="(item, index) in ${page.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                    <span>{{item.dictName}}</span>
                                </Checkbox >
                            </CheckboxGroup >



                        <#elseif page.element == 'select' >
                            <Select v-model="formValidate.${page.columnConfig.javaName}"
                                <#if page.events?exists>
                                    <#list page.events as event>
                                    @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                             >
                                <#if page.required == '0'>
                                    <Option value=""></Option>
                                </#if>
                                <Option v-for="(item, index) in ${page.columnConfig.dictType}Dict" :value="item.dictVal" :key="item.dictVal" >{{item.dictName}}</Option>
                            </Select>

                        <#elseif page.element == 'openwin' >
                            <Input v-model="formValidate.${page.columnConfig.javaName}Name"       @on-focus="select_${page.columnConfig.javaName}_${page.columnConfig.originalColumn.fkTableConfig.javaName}"/>

                        <#else >
                            <Input type="text" v-model="formValidate.${page.columnConfig.javaName}"      
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        </#if>
                    <#elseif page?exists && page.exColumn?exists>
                        <#if page.element == 'openwin' >
                            <Input v-model="formValidate.${page.exColumn.javaName}"       @on-focus="select_${page.exColumn.javaName}_${page.exColumn.originalColumn.fkTableConfig.javaName}"/>
                        </#if>
                    <#else>
                        //todo 生成编辑界面错误， columnPage 应该没有这种情况
                    ${page.id}
                    </#if>
                </FormItem>
                </Col>
            </#if>

            <#if (!page_has_next)>
            </Row>
            </#if>
        </#list>
        </Form>


        <div slot="footer">
            <Button type="primary" @click="save">保存</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
        </div>


    <#list fkTables as fkTable>
        <${fkTable.javaName}Search modalTitle="选择${fkTable.tableComment}" :display="select${fkTable.javaName}Display" :businessType="bsType" @closeDialog="closeDialog('select${fkTable.javaName}')"
            <#list fks[fkTable.fullResourceFile] as field >
                                   @on-selected-${field.javaName}="selected${field.javaName}Callback"
            </#list>
        />

    </#list>

    </Modal>

</template>


<script>

    import dialog from '@/utils/dialog'
    import baseForm from '@/mixins/baseForm';
    import commonApi from '@/api/commonApi';
    import ${table.javaName}Api from '@/api/${table.fullResourceFile}/${table.javaName}Api' ;


    <#list fkTables as fkTable>
    import ${fkTable.javaName}Search from '@/views${fkTable.fullResourceName}/${fkTable.javaName}Search'
    </#list>

    export default {
        mixins:[baseForm],
        components: {
        <#list fkTables as fkTable>
            ${fkTable.javaName}Search <#if fkTable_has_next>,</#if>
        </#list>


        },
        data () {
            return {
                width:500,
                bsType: '',
                maskClosable: false,
                formValidate: {
        <#list columnPages as page>
            <#if page.existPage == '1'>
            ${page.javaName}:'',
            </#if>
        </#list>
                aaaaaa:''
        },

        <#list fkTables as fkTable>
                select${fkTable.javaName}Display: false,
        </#list>

        <#list dictSet as dictPage>
            <#if dictPage.exColumn?exists>${dictPage.exColumn.dictType}Dict:{},
            <#else>${dictPage.columnConfig.dictType}Dict:[],
            </#if>
        </#list>
                ruleValidate: {

            <#list columnPages as page>
                <#if page.existPage == '1' && page.editable == '1' >
                    <#if page.required == '1' || page.validates?exists>
                    ${page.javaName}:[


                        <#if page.validates?exists>
                            <#list  page.validates as validate>
                                <#if page.element == 'select' >
                                    { type: 'string', message: '${validate.msg}', trigger: 'change', pattern: ${validate.rex} },
                                <#elseif  page.element == 'radio' >
                                    {  type: 'array',  message: '${validate.msg}', trigger: 'change', pattern: ${validate.rex} },
                                <#elseif  page.element == 'checkbox' >
                                    {  type: 'array',  message: '${validate.msg}', trigger: 'change', pattern: ${validate.rex} },
                                <#elseif  page.element == 'openwin' >
                                    { type: 'string', message: '${validate.msg}', trigger: 'blur', pattern: ${validate.rex} },
                                <#else>
                                    { type: 'string', message: '${validate.msg}', trigger: 'blur', pattern: ${validate.rex} },
                                </#if>
                            </#list>
                        </#if>

                        <#if page.required == '1'>
                            <#if page.element == 'select' >
                                { required: true,  message: '请选择${page.columnComment}', trigger: 'change' }
                            <#elseif  page.element == 'radio' >
                                { required: true, type: 'array', min: 1, message: '请选择${page.columnComment}', trigger: 'change' }
                            <#elseif  page.element == 'checkbox' >
                                { required: true, type: 'array', min: 1, message: '请至少选择一项${page.columnComment}', trigger: 'change' }
                            <#elseif  page.element == 'openwin' >
                                { required: true,  message: '请选择${page.columnComment}', trigger: 'blur' }
                            <#else>
                                { required: true, message: '请输入${page.columnComment}', trigger: 'blur' }
                            </#if>
                        </#if>

                    ],
                    </#if>
                </#if>
            </#list>

            },


        };
        },
    methods: {

    <#list columnEvents as event>
    ${event.funcBody},
    </#list>

    <#list fks?values as fkList >
        <#list fkList as page >
            selected${page.javaName}Callback(selection){
                <#if page.exColumn?exists>
                    this.formValidate.${page.exColumn.originalColumn.javaName} = selection.id;
                    this.formValidate.${page.javaName} = selection.${page.exColumn.fkJavaName};
                <#else >
                    this.formValidate.${page.columnConfig.originalColumn.javaName} = selection.id;
                    this.formValidate.${page.javaName} = selection.${page.columnConfig.fkJavaName};
                </#if>
                this.select${page.exColumn.originalColumn.fkTableConfig.javaName}Display = false ;

            },
        </#list>
    </#list>


    <#list columnPages as columnPage>
        <#if columnPage?exists && columnPage.element == 'openwin' >
            <#if columnPage.columnConfig?exists>
            <#elseif  columnPage.exColumn?exists>
                select_${columnPage.exColumn.javaName}_${columnPage.exColumn.originalColumn.fkTableConfig.javaName}(){
                    this.bsType='${columnPage.javaName}';
                    this.select${columnPage.exColumn.originalColumn.fkTableConfig.javaName}Display = true ;
                },
            </#if>
        </#if>
    </#list>

    <#if events?exists>
        <#list events as event>
        ${event.funcBody} ,
        </#list>
    </#if>

        save() {
            this.handleSubmit('formValidate');
            if ((this.formValid)) {
                let that = this;
                if (this.id != '') {
                    this.formValidate.id = this.id;
                    ${table.javaName}Api.update(this.formValidate,{
                        onSuccess(body){
                            that.handleReset('formValidate');
                            that.$emit('saveSuccess');
                            dialog.success(body.msg);
                        }
                    });


                } else {
                    ${table.javaName}Api.add(this.formValidate,{
                        onSuccess(body){
                            that.handleReset('formValidate');
                            that.$emit('saveSuccess');
                            dialog.success(body.msg);
                        }
                    });

                }
            }
        },
        findById() {
            let that = this;
            ${table.javaName}Api.detail(this.id,{
                onSuccess(body){
                    that.formValidate = body["${table.javaName?uncap_first}"];
                }
            });

        }
    },
    mounted() {
        let that = this;


    <#if dictSet?exists && (dictSet?size > 0) >
        commonApi.allDicts('<#list dictSet as columnPage><#if columnPage.exColumn?exists>${columnPage.exColumn.dictType}<#if columnPage_has_next>,</#if><#else>${columnPage.columnConfig.dictType}<#if columnPage_has_next>,</#if></#if></#list>', {
            onSuccess(dictMap){
                <#list dictSet as dictPage>
                    <#if dictPage.exColumn?exists>that.${dictPage.exColumn.dictType}Dict=dictMap["${dictPage.exColumn.dictType}"]<#if dictPage_has_next>,</#if>
                    <#else>that.${dictPage.columnConfig.dictType}Dict=dictMap["${dictPage.columnConfig.dictType}"]<#if dictPage_has_next>;</#if>
                    </#if>
                </#list>
            }
        });
    </#if>

        this.$on('findById', function (id) {
            that.id = id;
            that.findById();
        })
    }
    };
</script>
