import dialog from '@/utils/dialog';
import selectSpan from '@/components/select-span/select-span';
import tableList from '@/components/table-list/tableList'
import blockHead from '@/components/block-head/block-head';
import objectUtil from '@/utils/objectUtil'

const mixin = {
    props: {
        btnSize: {
            type: String,
            default: 'default'
        },
        isInclude: {
            type: Boolean,
            default: false
        },
        tableFit: {
            type: Boolean,
            default: true
        }
    },
    components: {
        selectSpan,
        tableList,
        blockHead


    },
    data () {
        return {
            componentShow_: false,
            isEdit_: false,
            selectedIds_:[],
            selectedDatas_: [],
            total_: 0,
            pageSize_: 10,
            pageNo_: 1,
            loading_: true,
            title_: '',
            tableColumns_: [],
            tableDatas_: [],
            searchForm_:{},
            permissions_: this.$store.state.app.permissions,

            editDisplay_: false,
            allDisplay_: false,
            detailDisplay_: false,
            businessType_: ''


        };
    },
    computed: {
        searchParams_ () {
            let param = {
                    pageNum: this.pageNo,
                    pageSize: this.pageSize
                };
            param = objectUtil.objectMerge(param, this.searchForm_);
            param = objectUtil.objectMerge(param, this.$props);
            //TODO prop+searchForm+ 分页数据
            return param;
        }
    },
    methods: {

        onVisibleChange_(v){

            //TODO
        },
        selectionChange_(selection){

            this.selectedDatas_ = selection;
            this.selectedIds_ = [];
            for (let item of selection) {
                this.selectedIds_.push(item.id);
            }
        },
        resetSearchForm_(formName){
            //TODO
            this.$refs[formName].resetFields();
        },
        /**
         * 点击按钮弹框，验证
         * @param {*} title 弹框标题
         * @param {*} selectType  弹框前置条件 0: 不要求选中table数据项 1：必须选中一条数据 2： 可以选中多条数据
         * @param {*} btnSource  按钮ref
         */
        showDialog_(title, selectType, btnSource){

            if (selectType === 0) {
                this.showModalDialog_(title, btnSource, false);
            } else if (selectType === 1) {

                if (this.selectedIds_.length < 1) {
                    dialog.warning('请选择要操作的数据!', this);
                } else if (this.selectedIds_.length > 1) {
                    dialog.warning('一次只能操作一条数据!',this);
                } else {
                    this.showModalDialog_(title, btnSource, true);
                }
            } else if (selectType === 2) {

                if (this.selectedIds_.length < 1) {
                    dialog.warning('请选择要操作的数据!', this);
                }else {
                   this.showModalDialog_(title, btnSource, true);
                }
            }
        },


        /**
         *弹框
         * @param title
         * @param btnSource
         * @param isEmit
         * @param emitName
         */
        showModalDialog_(title, btnSource, isEmit, emitName) {
            this.title_ = title;
            this[btnSource + 'Display_'] = true;
            if (isEmit) {
                this.$refs[btnSource + 'Ref'].$emit(emitName, this.selectedIds_.join(','));
            }
        },
        /**
         * 无弹框操作
         * @param btnText 按钮名称
         * @param selectType 弹框前置条件 0: 不要求选中table数据项 1：必须选中一条数据 2： 可以选中多条数据
         * @param funName 执行方法
         */
        btnExec_(btnText,selectType, funName) {

             if (selectType === 0) {
                 eval('this.' + funName + '()');
             } else if (selectType === 1) {

                 if (this.selectedIds_.length < 1) {
                     dialog.warning('请选择要操作的数据!',this);
                 } else if (this.selectedIds_.length > 1) {
                     dialog.warning('一次只能操作一条数据!',this);
                 } else {
                     let content = `确认${btnText}该数据？`;
                     let dialogFlag = dialog.confirm(content);
                     if (dialogFlag) {
                         eval('this.' + funName + '()');
                     }
                 }
             } else if (selectType === 2) {

                 if (this.selectedIds_.length < 1) {
                     dialog.warning('请选择要操作的数据!',this);
                 } else {
                     let content = `确认${btnText}该数据？`;
                     let dialogFlag = dialog.confirm(content);
                     if (dialogFlag) {
                         eval('this.' + funName + '()');
                     }
                 }
             }

        },

        closeDialog_(btnSource) {
            this[btnSource + 'Display_'] = false;
        },
        freshTable_(btnSource) {
            this[btnSource + 'Display_'] = false;
            this.findList();
        },
        /**
         * 数据表格翻页方法
         * @param pageNo
         * @param pageSize
         */
        tablePaddingCallback_(pageNo,pageSize){

            this.pageNo = pageNo;
            this.pageSize = pageSize;
            this.findList();
        },

        emitEvent_(that,params,title,refName,eventName,display){

            let currentRowData = that.data[params.index];
            const id = String(currentRowData.id);
            that.id = id;
            that.title = title;
            that.$refs[refName].$emit(eventName,id);
            that[display] = true;
        },
        createBtn_(btnIcon, btnType, btnText,btnSize, h, btnFun) {

            return h('Button', {
                props: {
                    type: btnType,
                    icon: btnIcon,
                    size: btnSize || 'default'
                },
                style: {
                    marginRight: '5px'
                },
                on: {
                    click: btnFun
                }
            }, btnText);
        },
        createEmitBtn_(that, btnIcon, btnType, btnText, btnSize, h, params,dialogTitle, dialogRefName, eventName, display){

            return h('Button', {
                props: {
                    type: btnType,
                    icon: btnIcon,
                    size: btnSize || 'default'
                },
                style: {
                    marginRight: '5px'
                },
                on: {
                    click: () => {
                        that.emitEvent_(that,params,dialogTitle,dialogRefName,eventName,display);
                    }
                }
            }, btnText);
        }
    },
    mounted () {

        this.$nextTick(function () {
            this.initData();
            this.findList();
            this.findDicts();
            this.customerFun();
        });
    },
    created () {
        // 显示content
        setTimeout(() => {
            this.componentShow_ = true;
        }, 500);

    }

};

export default mixin;
