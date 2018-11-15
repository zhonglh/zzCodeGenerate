import dialog from '@/utils/dialog';

const mixin = {
    data () {
        return {
            id: '',
            isEdit: false,
            selectedIds:[],
            selectedData: [],
            selectedIndex: null,
            total: 0,
            pageSize: 10,
            pageNo: 1,
            loading: true,
            show: false,
            title: '',
            columns: [],
            data: [],
            labelWidth:80,
            editDisplay: false,
            addDisplay: false,
            viewDisplay: false,
            searchForm:{},
            permissions: this.$store.state.app.permissions


        };
    },
    computed: {
        param () {
            let param = {
                    pageNum: this.pageNo,
                    pageSize: this.pageSize
                };
            for(let col in this.searchForm){

                if (this.searchForm[col] != '' && this.searchForm[col] != undefined){

                    param[col] = this.searchForm[col];
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

            Object.assign(param, this.$props);
            return param;
        }
    },
    methods: {

        onVisibleChange(v){
            if (!v){
                this.id = '';
            }
        },
        selectionChange(selection){

            this.selectedData = selection;
            this.selectedIds = [];
            for (let item of selection) {
                this.selectedIds.push(item.id);
            }
        },
        selectCurrentRow(currentRow, oldCurrentRow) {
            this.selectedData = [currentRow];
        },
        selectCancel(selection, row) {
        },
        reset(formName){
            this.$refs[formName].resetFields();
        },
        /**
         * 点击按钮弹框
         * @param {*} title 弹框标题
         * @param {*} selectType  弹框前置条件 0: 不要求选中table数据项 1：必须选中一条数据 2： 可以选中多条数据
         * @param {*} btnSource  按钮名称
         */
        showDialog(title, selectType, btnSource){

            if (selectType === 0) {
                this.showModelDialog(title, btnSource, false);
            } else if (selectType === 1) {

                if (this.selectedIds.length < 1) {
                    dialog.warning('请选择要操作的数据!', this);
                } else if (this.selectedIds.length > 1) {
                    dialog.warning('一次只能操作一条数据!',this);
                } else {
                    this.showModelDialog(title, btnSource, true);
                }
            } else if (selectType === 2) {

                if (this.selectedIds.length < 1) {
                    dialog.warning('请选择要操作的数据!', this);
                }else {
                   this.showModelDialog(title, btnSource, true);
                }
            }
        },
        /**
         *
         * @param {执行弹框} title
         * @param {*} btnSource
         * @param {*} isEmit
         */
        showModelDialog(title, btnSource, isEmit) {
            this.title = title;
            this[btnSource + 'Display'] = true;
            if (isEmit) {
                this.$refs[btnSource + 'Ref'].$emit('findById', this.selectedIds.join(','));
            }
        },
        /**
         * 无弹框操作
         * @param selectType 弹框前置条件 0: 不要求选中table数据项 1：必须选中一条数据 2： 可以选中多条数据
         * @param funName 执行方法
         */
        btnOperator(selectType, funName) {

             if (selectType === 0) {

                 this.title = btnName + title;
                 this[btnSource + 'Display'] = true;
             } else if (selectType === 1) {

                 if (this.selectedIds.length < 1) {
                     dialog.warning('请选择要操作的数据!',this);
                 } else if (this.selectedIds.length > 1) {
                     dialog.warning('一次只能操作一条数据!',this);
                 } else {
                     eval('this.' + funName + '()');
                 }
             } else if (selectType === 2) {

                 if (this.selectedIds.length < 1) {
                     dialog.warning('请选择要操作的数据!',this);
                 } else {
                      eval('this.' + funName + '()');
                 }
             }

        },
        showAddDialog (title){
            this.title = this.$t('add')+title;
            this.editDisplay = true;
        },
        showEditDialog (title){

            if (this.selectedIds.length <1){
                dialog.warning('请选择要操作的数据!',this);
            } else if (this.selectedIds.length >1){
                dialog.warning('一次只能修改一条数据!',this);
            }else {
                this.title = this.$t('edit')+title;
                this.editDisplay = true;
                this.$refs['editRef'].$emit('findById',this.selectedIds.join(','));
            }
        },
        closeViewDialog(){
            this.viewDisplay = false;
        },
        closeDialog(btnSource) {
            this[btnSource + 'Display'] = false;
        },
        saveSuccess(btnSource) {
            this[btnSource + 'Display'] = false;
            this.findList();
        },
        callback(pageNo,pageSize){

            this.pageNo = pageNo;
            this.pageSize = pageSize;
            this.findList();
        },
        emitEvent(that,params,title,refName,eventName,display){

            let currentRowData = that.data[params.index];
            const id = String(currentRowData.id);
            that.id = id;
            that.title = title;
            that.$refs[refName].$emit(eventName,id);
            that[display] = true;

        },
        createBtn(btnIcon, btnType, btnText, h, btnFun) {

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
        createEmitBtn(that, btnIcon, btnType, btnText, h, params,dialogTitle, dialogRefName, eventName, display){

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
                        that.emitEvent(that,params,dialogTitle,dialogRefName,eventName,display);
                    }
                }
            }, btnText);
        },
        renderBtn: (that,h, params, title, btns) => {

            let btnArr = [];
            for (let item of btns){
                if (item == 'view') {
                    let viewBtn = that.createEmitBtn(that, 'ios-eye', 'primary', that.$t('view'), h, params, that.$t('view') + title, 'displayRef', 'findById', 'viewDisplay');
                    btnArr.push(viewBtn);
                }else if (item == 'edit') {
                    let editBtn = that.createEmitBtn(that, 'edit', 'primary', that.$t('edit'), h, params, that.$t('edit') + title, 'editRef', 'findById', 'editDisplay');
                    btnArr.push(editBtn);
                }else if (item == 'delete') {

                    let deleteBtn = h('Poptip', {
                        props: {
                            confirm: true,
                            title: that.$t('confirmDeleteMessage'),
                            transfer: true
                        },
                        on: {
                            'on-ok': () => {
                                let currentRowData = that.data[params.index];
                                const id = currentRowData.id;
                                that.delete(id);

                            }
                        }
                    }, [
                        h('Button', {
                            style: {
                                margin: '0 5px'
                            },
                            props: {
                                type: 'error',
                                size: 'small',
                                icon: 'android-delete',
                                placement: 'top'
                            }
                        }, that.$t('delete'))
                    ]);

                    btnArr.push(deleteBtn);
                }
            }
            return btnArr
        }
    },
    mounted () {
    }

};

export default mixin;
