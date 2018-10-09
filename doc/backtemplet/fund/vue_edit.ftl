<style>

</style>
<template>
    <div :style="bodyStyle_" ref="mbody">

        <div>
            <block-head title="基本信息" v-if="isInclude">
                <div slot="toolbar">
                    <Button type="primary" v-show="!isEdit_  <#if table.isBuildRbac == '1'>&& permissions_.includes('${table.fullResourceFile}:update')</#if> " @click="isEdit_ = !isEdit_" size="small">编辑</Button>
                    <Button v-show="isEdit_" type="primary" @click="save" size="small">保存</Button>
                    <Button v-show="isEdit_ && formData.id" @click="resetForm_" size="small">重置</Button>
                    <Button v-show="isEdit_" @click="emptyForm('formData')"size="small">清空</Button>
                    <Button v-show="isEdit_" @click="isEdit_ = !isEdit_" size="small">取消</Button>
                </div>
            </block-head>

        <Form  v-show="!isEdit_" :label-width="formLabelWidth_">
            <Row style="padding : 10px ">
        <#list showColumnPages as page>


            <#if (page.existPage == '1' &&  page.editable == '0')>
                <#if page.hiddenable == '0'>
                    <Col :xs="24" :sm="12" :md="12" :lg="12">
                    <FormItem label="${page.columnComment}">
                        <#if page.element == 'date' >
                            {{ formData.${page.javaName} | date('%Y-%m-%d') }}
                        <#elseif  page.element == 'timestamp' >
                            {{ formData.${page.javaName} | date('%Y-%m-%d %H:%M:%S') }}
                        <#else >
                            {{ formData.${page.javaName} }}
                        </#if >
                    </FormItem>
                    </Col>
                </#if>
            <#elseif (page.existPage == '1' && page.editable == '1')>

                <#if (page.element == 'textarea' || page.element == 'singlefile' || page.element == 'multifile' || page.element == 'singleimage' || page.element == 'multiimage' ) >
                <Col :xs="24" :sm="24" :md="24" :lg="24">
                <#elseif (page.element != 'openwin')>
                <Col :xs="24" :sm="12" :md="12" :lg="12">
                </#if>

                <#if (page.element != 'openwin') >
                <FormItem label="${page.columnComment}" >
                </#if>

                    <#if page?exists && page.columnConfig?exists>
                        <#if page.element == 'input' >
                            {{formData.${page.columnConfig.javaName}}}
                        <#elseif page.element == 'digits' >
                            {{formData.${page.columnConfig.javaName}}}
                        <#elseif page.element == 'number' >
                            {{formData.${page.columnConfig.javaName}}}
                        <#elseif page.element == 'date' >
                            {{formData.${page.columnConfig.javaName}}}
                        <#elseif page.element == 'timestamp' >
                            {{formData.${page.columnConfig.javaName}}}
                        <#elseif page.element == 'email' >
                            {{formData.${page.columnConfig.javaName}}}
                        <#elseif page.element == 'url' >
                            {{formData.${page.columnConfig.javaName}}}
                        <#elseif page.element == 'radio' || page.element == 'checkbox' || page.element == 'select'>
                            <#if page.columnConfig.exCloumns?exists >{{formData.${page.columnConfig.exCloumns[0].javaName}}} </#if>
                        <#elseif page.element == 'openwin' >
                            <#if page.columnConfig.exCloumns?exists >
                                <#list page.columnConfig.exCloumns as exCloumn>
                                    <Col :xs="24" :sm="12" :md="12" :lg="12">
                                    <FormItem label="${exCloumn.columnTitle}" >
                                    {{formData.${exCloumn.javaName}}}
                                    </FormItem>
                                    </Col>
                                </#list>
                            </#if>


                        <#elseif page.element == 'singlefile' >
                            <${page.columnConfig.javaName}Upload :fileDisplay="true" :businessType.sync="formData.${page.columnConfig.javaName}" :action="uploadApi_"  :fileSize="1" :format="uploadFormat_" :multiple='singleFile' :max-size="uploadMaxSize_"  name="file" :data="uploadParams_" :defaultFileList="formData.${page.columnConfig.javaName}List"/>
                        <#elseif page.element == 'multifile' >
                            <${page.columnConfig.javaName}Upload :fileDisplay="true" :businessType.sync="formData.${page.columnConfig.javaName}" :action="uploadApi_"  :format="uploadFormat_" :multiple='multipleFile' :max-size="uploadMaxSize_"  name="file" :data="uploadParams_" :defaultFileList="formData.${page.columnConfig.javaName}List"/>
                        <#elseif page.element == 'singleimage' >

                        <#elseif page.element == 'multiimage' >

                        <#else >
                            {{formData.${page.columnConfig.javaName}}}
                        </#if>
                    <#elseif page?exists && page.exColumn?exists>
                        <#if page.element != 'openwin' >
                            {{formData.${page.exColumn.originalColumn.fkTableConfig.javaName}}}
                        </#if>
                    <#else>
                        //todo 生成编辑界面错误， columnPage 应该没有这种情况
                    ${page.id}
                    </#if>

                <#if (page.element != 'openwin') >
                </FormItem>
                </Col>
                </#if>
            </#if>

        </#list>
            </Row>
        </Form>


        <Form ref="formData" v-show="isEdit_" :model="formData" :rules="ruleValidate" :label-width="formLabelWidth_">
            <Row style="padding : 10px ">
        <#list showColumnPages as page>
            <#if (page.existPage == '1' &&  page.editable == '0')>
                <#if page.hiddenable == '0'>
                    <Col :xs="24" :sm="12" :md="12" :lg="12">
                    <FormItem label="${page.columnComment}" prop="${page.javaName}">
                        <#if page.element == 'date' >
                            {{ formData.${page.javaName} | date('%Y-%m-%d') }}
                        <#elseif  page.element == 'timestamp' >
                            {{ formData.${page.javaName} | date('%Y-%m-%d %H:%M:%S') }}
                        <#else >
                            {{ formData.${page.javaName} }}
                        </#if >
                    </FormItem>
                    </Col>
                </#if>
            <#elseif (page.existPage == '1' && page.editable == '1')>

                <#if (page.element == 'textarea' || page.element == 'singlefile' || page.element == 'multifile' || page.element == 'singleimage' || page.element == 'multiimage' ) >
                <Col :xs="24" :sm="24" :md="24" :lg="24">
                <#else >
                <Col :xs="24" :sm="12" :md="12" :lg="12">
                </#if>


                <FormItem label="${page.columnComment}" prop="${page.javaName}">
                    <#if page?exists && page.columnConfig?exists>
                        <#if page.element == 'input' >
                            <Input type="text" v-model="formData.${page.columnConfig.javaName}" step="1" precision="0"
                                   <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                   <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'digits' >
                            <InputNumber  v-model="formData.${page.columnConfig.javaName}"
                                          <#if page.min?exists && page.min != 0>min="${page.min}"</#if> <#if page.max?exists && page.max != 0>max="${page.max}"</#if>

                                <#if page.events?exists>
                                    <#list page.events as event>
                                          @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'number' >
                            <InputNumber  v-model="formData.${page.columnConfig.javaName}"  precision="2"
                                          <#if page.min?exists && page.min != 0>min="${page.min}"</#if> <#if page.max?exists && page.max != 0>max="${page.max}"</#if>

                                <#if page.events?exists>
                                    <#list page.events as event>
                                          @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'date' >
                            <DatePicker type="date"   v-model="formData.${page.columnConfig.javaName}"  clearable :editable="false" @on-change="onChange${page.columnConfig.javaName?cap_first}"
                                <#if page.events?exists>
                                    <#list page.events as event>
                                        @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'timestamp' >
                            <DatePicker type="datetime"   v-model="formData.${page.columnConfig.javaName}"  clearable :editable="false" @on-change="onChange${page.columnConfig.javaName?cap_first}"
                                <#if page.events?exists>
                                    <#list page.events as event>
                                        @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        <#elseif page.element == 'email' >
                            <Input type="email" v-model="formData.${page.columnConfig.javaName}"
                                   <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                   <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>  />
                        <#elseif page.element == 'url' >
                            <Input type="url" v-model="formData.${page.columnConfig.javaName}"
                                   <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                   <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>  />

                        <#elseif page.element == 'radio' >
                            <RadioGroup v-model="formData.${page.columnConfig.javaName}">
                                <Radio v-for="(item, index) in ${page.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                    <span>{{item.dictName}}</span>
                                </Radio>
                            </RadioGroup>

                        <#elseif page.element == 'checkbox' >
                            <CheckboxGroup  v-model="formData.${page.columnConfig.javaName}">
                                <Checkbox  v-for="(item, index) in ${page.columnConfig.dictType}Dict" :label="item.dictVal" :key="item.dictVal">
                                    <span>{{item.dictName}}</span>
                                </Checkbox >
                            </CheckboxGroup >



                        <#elseif page.element == 'select' >
                            <Select v-model="formData.${page.columnConfig.javaName}"
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
                            <Input v-model="formData.${page.columnConfig.javaName}Name"       @on-focus="select_${page.columnConfig.javaName}_${page.columnConfig.originalColumn.fkTableConfig.javaName}"/>




                        <#elseif page.element == 'singlefile' >
                            <${page.columnConfig.javaName}Upload :fileDisplay="false" :businessType.sync="formData.${page.columnConfig.javaName}" :action="uploadApi_"  :fileSize="1" :format="uploadFormat_" :multiple='singleFile' :max-size="uploadMaxSize_"  name="file" :data="uploadParams_" :defaultFileList="formData.${page.columnConfig.javaName}List"/>
                        <#elseif page.element == 'multifile' >
                            <${page.columnConfig.javaName}Upload :fileDisplay="false" :businessType.sync="formData.${page.columnConfig.javaName}" :action="uploadApi_"  :format="uploadFormat_" :multiple='multipleFile' :max-size="uploadMaxSize_"  name="file" :data="uploadParams_" :defaultFileList="formData.${page.columnConfig.javaName}List"/>
                        <#elseif page.element == 'singleimage' >

                        <#elseif page.element == 'multiimage' >

                        <#else >
                            <Input type="text" v-model="formData.${page.columnConfig.javaName}"
                                <#if page.events?exists>
                                    <#list page.events as event>
                                   @${event.eventName}="${event.funcName}"
                                    </#list>
                                </#if>
                            />
                        </#if>
                    <#elseif page?exists && page.exColumn?exists>
                        <#if page.element == 'openwin' >
                            <Input v-model="formData.${page.exColumn.javaName}"       @on-focus="select_${page.exColumn.javaName}_${page.exColumn.originalColumn.fkTableConfig.javaName}"/>
                        </#if>
                    <#else>
                        //todo 生成编辑界面错误， columnPage 应该没有这种情况
                    ${page.id}
                    </#if>
                </FormItem>
                </Col>
            </#if>

        </#list>
        </Row>
        </Form>


        <Row type="flex" justify="center" v-if="!formData.id">
            <Col span="24" style="text-align: right;padding-right: 20px;border-top: solid 1px #dddddd;height: 40px;line-height: 40px;">

            <Button type="primary" @click="save">保存</Button>
            <Button @click="handleReset('formData')" style="margin-left: 8px">重置</Button>
            </Col>
        </Row>


    <#list fkTables as fkTable>

        <#if fkTable.isBuildUi == '1'>
            <${fkTable.javaName}Search modalTitle="选择${fkTable.tableComment}" :modalDisplay="select${fkTable.javaName}Display_" :businessType="businessType_" @closeDialog="closeDialog_('select${fkTable.javaName}')"
                <#list fks[fkTable.fullResourceFile] as field >
                                       @on-selected-${field.javaName}="selected${field.javaName}Callback"
                </#list>
            />
        </#if>

    </#list>
        </div>

    </div>

</template>


<script>

    import commonApi from '@/api/commonApi';
    import formMix from '@/mixins/formMix';

    import ${table.javaName}Api from '@/api/${table.fullResourceFile}/${table.javaName}Api' ;
    import fileUpload from '@/components/file-upload/file-upload';


    <#list fkTables as fkTable>
        <#if fkTable.isBuildUi == '1'>
        import ${fkTable.javaName}Search from '@/views${fkTable.fullResourceName}/${fkTable.javaName}Search';
        </#if>
    </#list>

    export default {
        mixins: [formMix],
        components: {
            fileUpload,
        <#list showColumnPages as page>
            <#if (page.editable == '1' && page.columnConfig?exists && (page.element == 'singlefile' || page.element == 'multifile') )>
            ${page.columnConfig.javaName}Upload :fileUpload,
            </#if>
        </#list>


        <#list fkTables as fkTable>
            <#if fkTable.isBuildUi == '1'>
            ${fkTable.javaName}Search ,
            </#if>
        </#list>


        },



        props:{

            <#list columns as column>
            <#if column.columnIsfk == '1'>
            ${column.javaName} :{
                type:String,
                default:''
            },
            </#if>
            </#list>
            id :{
                type:String,
                default:''
            },
            ${table.simpleName}Id:{
                type:String,
                default:''
            }


        },

        watch: {

            <#list columns as column>
            <#if column.columnIsfk == '1'>
            ${column.javaName} : function (newVal, oldVal) {
                this.findBy();
            },
            </#if>
            </#list>

            id: function (newVal, oldVal) {
                this.findBy();
            },

            ${table.simpleName}Id: function (newVal, oldVal) {
                this.findBy();
            }

        },


        data () {
            return {

                multipleFile:true,
                singleFile:false,


                formData: {
            <#list columnPages as page>
                <#if page.existPage == '1'>
                    ${page.javaName}:'',
                </#if>
            </#list>


        <#list showColumnPages as page>
            <#if (page.editable == '1' && page.columnConfig?exists && (page.element == 'singlefile' || page.element == 'multifile') )>
                    ${page.columnConfig.javaName}List :[],
            </#if>
        </#list>
                },

        <#list fkTables as fkTable>
                select${fkTable.javaName}Display_: false,
        </#list>

        <#list dictSet as dictPage>
            <#if dictPage.exColumn?exists>
                ${dictPage.exColumn.dictType}Dict:{},
            <#else>
                ${dictPage.columnConfig.dictType}Dict:[],
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
                                <#elseif  page.element == 'date' || page.element == 'timestamp'>
                                    { type: 'date', message: '${validate.msg}', trigger: 'blur', pattern: ${validate.rex} },
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
                            <#elseif  page.element == 'date' || page.element == 'timestamp'>
                                { required: true,  type: 'date',message: '请选择${page.columnComment}', trigger: 'blur' }
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


    <#list showColumnPages as page>
        <#if (page.existPage == '1' && page.editable == '1' && page.element == 'date')>
            onChange${page.columnConfig.javaName?cap_first}(v){
                this.formData.${page.columnConfig.javaName} = new Date(v);
            },

        <#elseif (page.existPage == '1' && page.editable == '1' && page.element == 'timestamp')>
            onChange${page.columnConfig.javaName?cap_first}(v){
                this.formData.${page.columnConfig.javaName} = new Date(v);
            },
        </#if>
    </#list>

    <#list columnEvents as event>
            ${event.funcBody},
    </#list>

    <#list fks?values as fkList >
        <#list fkList as page >
            selected${page.javaName}Callback(selection){
                <#if page.exColumn?exists>
                this.formData.${page.exColumn.originalColumn.javaName} = selection.id;
                this.formData.${page.javaName} = selection.${page.exColumn.fkJavaName};
                <#else >
                this.formData.${page.columnConfig.originalColumn.javaName} = selection.id;
                this.formData.${page.javaName} = selection.${page.columnConfig.fkJavaName};
                </#if>
                this.select${page.exColumn.originalColumn.fkTableConfig.javaName}Display_ = false ;

            },
        </#list>
    </#list>

    <#list columnPages as columnPage>
        <#if columnPage?exists && columnPage.element == 'openwin' >
        <#if columnPage.columnConfig?exists>
        <#elseif  columnPage.exColumn?exists>
            select_${columnPage.exColumn.javaName}_${columnPage.exColumn.originalColumn.fkTableConfig.javaName}(){
                this.businessType_='${columnPage.javaName}';
                this.select${columnPage.exColumn.originalColumn.fkTableConfig.javaName}Display_ = true ;
            },
        </#if>
        </#if>
    </#list>

            save() {

                this.validateForm_('formData');
                if (this.formValid_) {
                    let that = this;
                    let allInfo = this.allFormData_;
                    if (allInfo.id != undefined && allInfo.id != '') {
                        ${table.javaName}Api.update(allInfo,{
                            onSuccess(body) {
                                that.saveOk_(body,that,'formData');
                                that.findBy();
                            }
                        });


                    } else {
                        ${table.javaName}Api.add(allInfo,{
                            onSuccess(body) {
                                that.saveOk_(body,that,'formData');
                                that.findBy();
                            }
                        });

                    }
                }
            },


            findBy() {
                let that = this;
                ${table.javaName}Api.detailBy(that.searchParams_,{
                    onSuccess(body){
                        that.formData = body["${table.javaName?uncap_first}"];

                        <#list columnPages as being>
                        <#if being.element == 'singlefile' || being.element == 'multifile' >
                        if (that.formData.${being.javaName} == undefined) that.formData.${being.javaName} = '';
                        </#if>
                        </#list>
                    }
                });

            },
            findDicts(){
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
            },
            customerFun(){

            }

        },
        mounted() {

        }


    };
</script>
