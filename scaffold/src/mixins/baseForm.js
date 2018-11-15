import storageUtils from '@/utils/storageUtils';
const mixin = {
    props: {
        title:  {
            type: String,
            default: ''
        },
        display:  {
            type: Boolean,
            default: false
        },
    },
    data: function () {
        return {
            id: '',
            show: false,
            maskClosable: false,
            formValid: false,
            dialogWidth: 680,
            dialogHeight: 680,
            labelWidth:160,
            permissions: this.$store.state.app.permissions,
            uploadSuccessFiles: '',
            defaultFileList: [],
            uploadMaxSize: 2048,
            uploadApi: `${process.env.SERVER_URL}/file/upload`,
            uploadFormat: ['xls','xlsx','pdf','doc','docx','ppt','pptx','png','jpg','gif','mp4','flv','mkv','mpg','mpeg','3gp','rmvb','avi','vob'],
            uploadParams: {
                sessionKey: storageUtils.get('sessionKey')
            },

            isEdit: false,
            formValidate:{},
            beforeFormValidate:{}
        }
    },
    watch: {
        display: function (newVal, oldVal) {
            this.show = newVal;
        }
    },
    methods: {
        handleSubmit(name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                   this.formValid = true
                }else {
                    this.formValid = false
                }
            });
        },
        handleReset(formName) {

            var formName = this.$refs[formName];
            if (formName != undefined){
                formName.resetFields();
            }
        },
        resetForm() {

            for(let col in this.formValidate){
                this.$set(this.formValidate,col,this.beforeFormValidate[col]);
            }
        },
        emptyForm(formName) {
            var formName = this.$refs[formName];
            if (formName != undefined){
                formName.resetFields();
            }
        },
        closeDialog(btnSource) {
            this[btnSource + 'Display'] = false;
        },
        onVisibleChange(v) {
            if (!v){
                this.$emit('closeDialog')
            }
            this.handleReset('formValidate');
        },

        fileRemove(file, fileList){
            this.uploadSuccessFiles = [];
            for(let item of fileList){
                this.uploadSuccessFiles.push(item.id);
            }
        },


        toogleEdit(){
            this.isEdit = true;
        },
        toogleCancel(){
            this.isEdit = false;
        }
    },
    mounted() {

        let h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
        this.dialogHeight = 400;
    }

};

export default mixin;
