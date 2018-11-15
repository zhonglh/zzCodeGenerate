import storageUtils from '@/utils/storageUtils';
import dialog from '@/utils/dialog'
import objectUtil from '@/utils/objectUtil'
import blockHead from '@/components/block-head/block-head';
import timeFormat from '@/utils/timeformat';



const mixin = {
    components: {
        blockHead

    },
    props: {
        id: {
            type: String,
            default: ''
        },
        btnSize: {
            type: String,
            default: 'default'
        },
        isInclude: {
            type: Boolean,
            default: false
        }
    },
    watch: {
        id:{

            handler: function (val, oldVal) {
                this.findBy();
                if (this.isInclude){
                    this.isEdit_ = false;
                } else {
                    this.isEdit_ = true;
                }

            },
            deep: false,
            immediate: true
        }
    },
    data: function () {
        return {
            isEdit_: false,
            bodyStyle_:{},
            formLabelWidth_:160,
            permissions_: this.$store.state.app.permissions,
            uploadSuccessFiles_: '',
            uploadDefaultFileList_: [],
            uploadMaxSize_: 2048,
            uploadApi_: `${process.env.SERVER_URL}/file/upload`,
            uploadFormat_: ['xls','xlsx','pdf','doc','docx','ppt','pptx','png','jpg','gif','mp4','flv','mkv','mpg','mpeg','3gp','rmvb','avi','vob'],
            uploadParams_: {
                sessionKey: storageUtils.get('sessionKey')
            },
            businessType_: '',
            initFormData_:{},
            formValid_:false
        }
    },
    computed: {
        searchParams_ () {

            //TODO
            return this.$props;
        },
        allFormData_(){
            return objectUtil.objectMerge(this.formData, this.$props)
        }
    },

    methods: {
        validateForm_(formRef) {
           this.$refs[formRef].validate((valid) => {
               if (valid) {
                   this.formValid_ = true
               }else {
                   this.formValid_ = false
               }
            });
        },
        resetForm_() {

            for(let col in this.formData){
                this.$set(this.formData,`${col}`,this.initFormData_[col]);
            }

            try {
                eval('this.customerReset()');
            }catch (e) {}
        },

        emptyForm_(formName) {
            var formName = this.$refs[formName];
            if (formName != undefined){
                formName.resetFields();
            }
        },
        onVisibleChange_(v) {
            //TODO
        },

        fileRemove_(file, fileList){
            this.uploadSuccessFiles = [];
            for(let item of fileList){
                this.uploadSuccessFiles.push(item.id);
            }
        },
        saveOk_(body,that, formRef){
            //TODO 区分弹框消失，还是刷新当前页面数据
            that.$emit('freshTable');
            dialog.success(body.msg,that);
            if (this.isInclude) that.isEdit_ = false;
            that.emptyForm_(formRef);
        },
        computeFormDialog_(){
            //TODO 实现弹框内容自适应
/*            let h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
            var mbodyHeight = window.getComputedStyle(this.$refs.mbody).height;
            if (h < parseInt(mbodyHeight)){
                mbodyHeight = h;
            }
            this.bodyStyle.height = mbodyHeight;
            this.bodyStyle.overflow = 'auto';*/
        },
        initData_(){


            if (this.id != undefined && this.id != '') {
                this.isEdit_ = false;
            } else {
                this.isEdit_ = true;
            }
            this.findBy();

        },
        closeDialog_(btnSource) {
            this[btnSource + 'Display_'] = false;
        }

    },
    mounted() {

        this.initData_();
        this.findDicts();
        this.customerFun();
        this.computeFormDialog_();

    }

};

export default mixin;
