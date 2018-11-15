import dialog from '@/utils/dialog';
import selectSpan from '@/components/select-span/select-span';
import tableList from '@/components/table-list/tableList'
import blockHead from '@/components/block-head/block-head';

const mixin = {
    props: {
        btnSize: {
            type: String,
            default: 'default'
        },
        modalTitle: {
            type: String,
            default: ''
        },
        modalDisplay: {
            type: Boolean,
            default: false
        },
        mutiSelect: {
            type: Boolean,
            default: false
        },
        businessType: {
            type: String,
            default: ''
        }
    },
    components: {
        selectSpan,
        tableList,
        blockHead


    },
    data () {
        return {
            modalWidth_:800,
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
            for(let col in this.searchForm_){

                if (this.searchForm_[col] != '' && this.searchForm_[col] != undefined){

                    param[col] = this.searchForm_[col];
                }
/*                const val = this.searchForm[col].value;
                let express = this.searchForm[col].express;
                if (express == '' ||  express == undefined){
                    express = 'eq';
                }

                if (val != '' && val != undefined) {
                    const key = `${col}_${express}`;
                    param[key] = val;
                }*/
            }

            //TODO prop+searchForm+ 分页数据
            Object.assign(param, this.$props);
            return param;
        },
        shows() {
            return this.modalDisplay;
        }
    },
    methods: {

        onVisibleChange_(v) {
            if (!v) {
                this.$emit('closeDialog')
            }
        },
        okFun_() {

            if (this.selectedDatas_.length < 1) {
                dialog.warning('请选择要操作的数据!', this);
            } else {
                if (this.mutiSelect) {
                    this.$emit('on-selected-' + this.businessType, this.selectedDatas_);
                } else {
                    this.$emit('on-selected-' + this.businessType, this.selectedDatas_[0]);
                }

            }
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
        createBtn_(btnIcon, btnType, btnText, h, btnFun) {

            return h('Button', {
                props: {
                    type: btnType,
                    icon: btnIcon,
                    size: 'large'
                },
                style: {
                    marginRight: '5px'
                },
                on: {
                    click: btnFun
                }
            }, btnText);
        },
        createEmitBtn_(that, btnIcon, btnType, btnText, h, params,dialogTitle, dialogRefName, eventName, display){

            return h('Button', {
                props: {
                    type: btnType,
                    icon: btnIcon,
                    size: 'small'
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
    }

};

export default mixin;
