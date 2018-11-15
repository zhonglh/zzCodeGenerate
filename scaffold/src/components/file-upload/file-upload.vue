<style lang="less">

    .file-ul{
        padding-left: 10px;
        li{
            list-style: none;
            cursor: pointer;
            color: #1e6abc;
            height: 30px;
            line-height: 30px;
        }
        /*li::before{*/
        /*content:"●";*/
        /*color:blue;*/
        /*font-size:20px;*/
        /*}*/

    }

</style>
<template>

    <div>


        <template v-if="fileDisplay">
            <ul class="file-ul">
                <li v-for="f in defaultFile"  @click="handleFile(f)">
                    {{f.showName}}
                </li>
            </ul>

        </template>
        <template v-else>
            <Upload  :name="name" :action="action" :headers="headers" :multiple="multiple" :data="data"
                     :with-credentials="withCredentials" :show-upload-list="showUploadList" :type="type" :format="format"
                     :accept="accept" :max-size="maxSize" :before-upload="beforeUploadFun" :on-progress="onProgress"
                     :on-success="uploadSuccess" :on-error="onError"   :on-preview="onPreview" :on-exceeded-size="onExceededSize"
                     :on-remove="fileRemove"   :defaultFileList="defaultFile">
                <Button icon="ios-cloud-upload-outline">选择</Button>

            </Upload>
        </template>
    </div>
</template>


<script>
    const prefixCls = 'ivu-upload';
    export default {
        name: 'fileUpload',
        props: {
            name: {
                type: String,
                default: 'file'
            },
            fileDisplay: {
                type: Boolean,
                default: false
            },
            businessType: {
                type: String
            },
            fileSize: {
                type: Number,
                default: 10
            },
            action: {
                type: String,
                required: true
            },
            headers: {
                type: Object,
                default () {
                    return {};
                }
            },
            multiple: {
                type: Boolean,
                default: false
            },
            data: {
                type: Object
            },
            withCredentials: {
                type: Boolean,
                default: false
            },
            showUploadList: {
                type: Boolean,
                default: true
            },
            type: {
                type: String,
                default: 'select'
            },
            format: {
                type: Array,
                default () {
                    return [];
                }
            },
            accept: {
                type: String
            },
            maxSize: {
                type: Number
            },
            beforeUpload: Function,
            onProgress: {
                type: Function,
                default () {
                    return {};
                }
            },
            onSuccess: {
                type: Function,
                default () {
                    return {};
                }
            },
            onError: {
                type: Function,
                default () {
                    return {};
                }
            },
            onRemove: {
                type: Function,
                default () {
                    return {};
                }
            },
            onPreview: {
                type: Function,
                default () {
                    return {};
                }
            },
            onExceededSize: {
                type: Function,
                default () {
                    return {};
                }
            },
            onFormatError: {
                type: Function,
                default () {
                    return {};
                }
            },
            defaultFileList: {
                type: Array,
                default() {
                    return [];
                }
            },
            paste: {
                type: Boolean,
                default: false
            },
            uploadApi: {
                type: String
            },
            uploadFormat: {
                type: Array,
                default() {
                    return [];
                }
            },
            uploadParams: {
                type: Object,
                default() {
                    return {};
                }
            },
            uploadMaxSize: {
                type: Object,
                default() {
                    return {};
                }
            }
        },
        watch: {
            defaultFileList: function (newVal, oldVal) {


                if (newVal != undefined) {
                    this.defaultFile = newVal;
                    this.defaultFile = this.defaultFile.map(item => {
                        item.name = item.showName;
                        return item;
                    });
                }
            }
        },
        data: function () {
            return {
                defaultFile: [],
                uploadSuccessFiles: []
            }
        },
        methods: {

            handleFile(file){
                window.open(process.env.SERVER_URL + file.accessUrl,'_blank');
            },
            beforeUploadFun(){
                if (this.uploadSuccessFiles.length >= this.fileSize){
                    alert('文件列表已经超过最大上传个数,默认为'+ this.fileSize + '个文件');
                    return false;
                }
            },
            fileRemove(file, fileList){
                this.uploadSuccessFiles = [];
                const  EncryptUtil = require('../../utils/EncryptUtil');
                for(let item of fileList){
                    // let result = JSON.parse(EncryptUtil.default.decrypt(item.response.result));
                    // this.uploadSuccessFiles.push(result.body);
                    this.uploadSuccessFiles.push(item.id);
                }
                let rs = this.uploadSuccessFiles.join(',');
                this.$emit('update:businessType', rs);
                this.$emit('on-success',rs);
            },
            uploadSuccess(res, file) {
                const  EncryptUtil = require('../../utils/EncryptUtil');
                let result = JSON.parse(EncryptUtil.default.decrypt(res.result));
                if (result.code == 200) {
                    this.uploadSuccessFiles.push(result.body);
                    let rs = this.uploadSuccessFiles.join(',');
                    if (this.businessType.length>0) rs = this.businessType + ',' + rs;
                    this.$emit('update:businessType', rs);
                    this.$emit('on-success',rs);
                }else {
                    this.uploadSuccessFiles = [];
                }
            }

        }
    };
</script>

