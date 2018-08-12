<style>

</style>
<template>
    <Modal
            v-model="show"
            :title="title"
            @on-visible-change="onVisibleChange"
            :width="width"
            loading
            scrollable>


        <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
            <#list columnPages as page>
                <#if page.existPage == '1'>

                    <#if page.hiddenable == '1'>

                    <#elseif page.editable == '0'>
                    <FormItem label="${being.columnComment}" prop="${being.javaName}">
                        {{ formValidate.${page.javaName} }}
                    </FormItem>
                    <#elseif page.editable == '1'>


                        <FormItem label="${being.columnComment}" prop="${being.javaName}">
                        <#if page?exists && page.columnConfig?exists>
                            <#if page.element == 'input' >
                                <Input type="text" v-model="searchForm.${page.columnConfig.javaName}" step="1" precision="0"
                                       <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                       <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                       style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}"
                                        <#if page.events?exists>
                                            <#list page.events as event>
                                                @${event.eventName}="${event.funcName}"
                                            </#list>
                                        </#if>
                                />
                            <#elseif page.element == 'digits' >
                                <InputNumber  v-model="searchForm.${page.columnConfig.javaName}"
                                              <#if page.min?exists && page.min != 0>min="${page.min}"</#if> <#if page.max?exists && page.max != 0>max="${page.max}"</#if>
                                              style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}"
                                            <#if page.events?exists>
                                                <#list page.events as event>
                                                      @${event.eventName}="${event.funcName}"
                                                </#list>
                                            </#if>
                                />
                            <#elseif page.element == 'number' >
                                <InputNumber  v-model="searchForm.${page.columnConfig.javaName}"  precision="2"
                                              <#if page.min?exists && page.min != 0>min="${page.min}"</#if> <#if page.max?exists && page.max != 0>max="${page.max}"</#if>
                                              style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}"
                                            <#if page.events?exists>
                                                <#list page.events as event>
                                                      @${event.eventName}="${event.funcName}"
                                                </#list>
                                            </#if>
                                />
                            <#elseif page.element == 'date' >
                                <DatePicker type="date"   v-model="searchForm.${page.columnConfig.javaName}"  clearable editable="false"
                                    <#if page.events?exists>
                                        <#list page.events as event>
                                            @${event.eventName}="${event.funcName}"
                                        </#list>
                                    </#if>
                                            style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                            <#elseif page.element == 'timestamp' >
                                <DatePicker type="datetime"   v-model="searchForm.${page.columnConfig.javaName}"  clearable editable="false"
                                    <#if page.events?exists>
                                        <#list page.events as event>
                                            @${event.eventName}="${event.funcName}"
                                        </#list>
                                    </#if>
                                            style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                            <#elseif page.element == 'email' >
                                <Input type="email" v-model="searchForm.${page.columnConfig.javaName}"
                                       <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                       <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                    <#if page.events?exists>
                                        <#list page.events as event>
                                       @${event.eventName}="${event.funcName}"
                                        </#list>
                                    </#if>
                                       style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />
                            <#elseif page.element == 'url' >
                                <Input type="url" v-model="searchForm.${page.columnConfig.javaName}"
                                       <#if page.maxlength ?exists && page.maxlength != 0>maxlength="${page.maxlength}" </#if>
                                       <#if page.minlength ?exists && page.minlength != 0>maxlength="${page.minlength}" </#if>
                                    <#if page.events?exists>
                                        <#list page.events as event>
                                       @${event.eventName}="${event.funcName}"
                                        </#list>
                                    </#if>
                                       style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}" />

                            <#elseif page.element == 'radio' >
                                <RadioGroup v-model="searchForm.${page.columnConfig.javaName}">
                                    <Radio v-for="(item, index) in ${page.columnConfig.dictType}s" :label="item.val" :key="item.val">
                                        <span>{{item.name}}</span>
                                    </Radio>
                                </RadioGroup>

                            <#elseif page.element == 'checkbox' >
                                <CheckboxGroup  v-model="searchForm.${page.columnConfig.javaName}">
                                    <Checkbox  v-for="(item, index) in ${page.columnConfig.dictType}s" :label="item.val" :key="item.val">
                                        <span>{{item.name}}</span>
                                    </Checkbox >
                                </CheckboxGroup >



                            <#elseif page.element == 'select' >
                                <Select v-model="searchForm.${page.columnConfig.javaName}" placeholder="${being.queryPlaceholder}"
                                    <#if page.events?exists>
                                        <#list page.events as event>
                                        @${event.eventName}="${event.funcName}"
                                        </#list>
                                    </#if>
                                        style="width: 200px">
                                    <#if page.required == '0'>
                                    <Option value=""></Option>
                                    </#if>
                                    <Option v-for="(item, index) in ${page.columnConfig.dictType}s" :value="item.val" :key="item.val" >{{item.name}}</Option>
                                </Select>

                            <#elseif page.element == 'openwin' >
                                <Input v-model="searchForm.${page.columnConfig.javaName}Name"   style="width: 200px;margin-left: 7px" @on-focus="select_${page.columnConfig.javaName}_${page.columnConfig.fkTableConfig.fullResourceFile}"/>

                            <#else >
                                <Input type="text" v-model="searchForm.${page.columnConfig.javaName}"   style="width: 200px;margin-left: 7px" placeholder="${being.queryPlaceholder}"
                                    <#if page.events?exists>
                                        <#list page.events as event>
                                       @${event.eventName}="${event.funcName}"
                                        </#list>
                                    </#if>
                                />
                            </#if>
                        <#elseif page?exists && page.exColumn?exists>
                            <#if page.element == 'openwin' >
                                <Input v-model="searchForm.${page.exColumn.javaName}"   style="width: 200px;margin-left: 7px" @on-focus="select_${page.exColumn.javaName}_${page.exColumn.originalColumn.fkTableConfig.fullResourceFile}"/>
                            </#if>
                        <#else>
                            //todo 生成编辑界面错误， columnPage 应该没有这种情况
                            ${page.id}
                        </#if>
                        </FormItem>

                    </#if>

                </#if>
            </#list>
        </Form>


        <div slot="footer">
            <Button type="primary" @click="save">保存</Button>
            <Button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
        </div>
    </Modal>

</template>


<script>
    import baseForm from '@/mixins/baseForm';
    import commonApi from '@/api/commonApi';


    <#list fkTables as fkTable>
    import ${fkTable.fullResourceFile}Search from '@/views/${fkTable.fullResourceName}/${fkTable.fullResourceFile}Search'
    </#list>

    export default {
        mixins:[baseForm],
        components: {
        <#list fkTables as fkTable>
            ${fkTable.fullResourceFile}Search <#if fkTable_has_next>,</#if>
        </#list>


        },
        data () {
            return {
                width:500,
                formValidate: {
                    <#list columnPages as page>
                        <#if page.existPage == '1'>
                        ${page.javaName},
                        </#if>
                    </#list>
                    aaaaaa
                },
                ruleValidate: {

                    <#list columnPages as page>
                        <#if page.existPage == '1' && page.editable == '1' >
                     ${page.javaName}:[
                            <#if page.required == '1'>
                                <#if page.element == 'select' >
                                    { required: true,  message: '请选择${page.columnComment}', trigger: 'change' }
                                <#elseif  page.element == 'radio' >
                                { required: true, type: 'array', min: 1, message: '请选择${page.columnComment}', trigger: 'change' },
                                <#elseif  page.element == 'checkbox' >
                                    { required: true, type: 'array', min: 1, message: '请至少选择一项${page.columnComment}', trigger: 'change' },
                                <#elseif  page.element == 'openwin' >
                                    { required: true,  message: '请选择${page.columnComment}', trigger: 'blur' },
                                <#else>
                                    { required: true, message: '请输入${page.columnComment}', trigger: 'blur' },
                                </#if>
                            </#if>

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


                        ],
                        </#if>
                    </#list>

                },


            };
        },
        methods: {

        <#list fks?values as fkList >
            <#list fkList as page >
                selected${page.javaName}Fun(selection){
                    <#if page.exColumn?exists>
                        this.searchForm.${page.exColumn.originalColumn.javaName} = selection.id;
                        this.searchForm.${queryField.javaName} = selection.${page.exColumn.fkJavaName};
                    <#else >
                        this.searchForm.${page.columnConfig.originalColumn.javaName} = selection.id;
                        this.searchForm.${queryField.javaName} = selection.${page.columnConfig.fkJavaName};
                    </#if>
                    this.selectDisplay = false;

                },
            </#list>
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
                        userApi.update(this.formValidate).then((response) => {
                            that.handleReset('formValidate');
                        that.$emit('saveSuccess');

                    })
                    } else {
                        userApi.save(this.formValidate).then((response) => {
                            that.handleReset('formValidate');
                        that.$emit('saveSuccess');
                    })
                    }
                }
            },
            findById() {
                let that = this;
                userApi.findUserById(this.id).then((response) =>{
                    const body = response.data.result.body;
                that.formValidate = body;
            })
            }
        },
        mounted() {

            // this.width = document.documentElement.clientWidth;
            let that = this;
            commonApi.address().then(response => {
                that.addresses = response.data.result.body.data
            });

            commonApi.postList().then(response => {
                that.postList = response.data.result.body.data
            });

            commonApi.loveList().then(response => {
                that.loveList = response.data.result.body.data
            });

            this.$on('findById', function (id) {
                that.id = id;
                that.findById();
            })
        }
    };
</script>
