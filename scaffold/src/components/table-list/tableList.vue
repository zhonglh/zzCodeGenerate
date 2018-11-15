<style lang="less">

</style>

<template>
    <div>
        <Form ref="searchForm"  :label-width="80" inline :style="searchStyle" v-show="!formHidden" class="search-form">
            <slot name="form">
                <!-- <div class="search-form"></div> -->
            </slot>
        </Form>
        <!--         <div style="width: 60px;margin:0 auto;cursor:pointer;" @click="resizeSearchPannel" v-show="searchShow">
                        <Icon type="ios-arrow-down" v-show="!searchResize" size="25" color="#2b85e4"></Icon>
                        <Icon type="ios-arrow-up" v-show="searchResize" size="25" color="#2b85e4"></Icon>
                    </div>-->
        <Row class="toolbar" ref="toolbar" v-show="!toolbarHidden">
            <slot name="toolbar"></slot>
        </Row>
        <Table :columns="columns_" highlight-row :loading="loading" :data="tableData" v-if="tableFit" :height="height" border @on-selection-change="selectionChange"  @on-current-change="selectCurrentRow" @on-row-click="rowClick"></Table>
        <Table :columns="columns_" highlight-row :loading="loading" :data="tableData" v-if="!tableFit" border @on-selection-change="selectionChange"  @on-current-change="selectCurrentRow" @on-row-click="rowClick"></Table>
        <Page v-if="pageBarDisplay" ref="pageBar" :total="total" :page-size="pageSize" show-total show-sizer :current="1" @on-change="onPageChange" @on-page-size-change="onPageSizeChange"  :style="pageStyle"></Page>
    </div>
</template>

<script>



    export default {
        name: 'tableList',
        props:{
            columns: {
                type: Array,
                default: []
            },
            tableData: {
                type: Array,
                default:function () {
                    return [];
                }
            },
            tableFit: {
                type: Boolean,
                default: true
            },
            mutiSelect: {
                type: Boolean,
                default: false
            },
            loading: {
                type: Boolean,
                default: false
            },
            dialogInModal: {
                type: Boolean,
                default: false
            },
            total: {
                type: Number,
                default: 0
            },
            toolbarHidden: {
                type: Boolean,
                default: false
            },

            pageBarDisplay: {
                type: Boolean,
                default: true
            },

            formHidden: {
                type: Boolean,
                default: false
            }
        },
        data () {
            return {
                columns_:[],
                searchShow: false,
                searchResize: false,
                // searchStyle: {height: '80px',overflow: 'hidden'},
                searchStyle: {},
                height: 300,
                labelWidth:80,
                pageSize: 10,
                pageNo: 1,
                show: false,
                paddingStyle:'float: right',
                heightElems:['searchForm','pageBar','toolbar'],//计算高度的元素
                offsetHeight:130, //额外减去的高度
                indexCol: {
                    title: '序号',
                    align:'center',
                    width: 80,
                    fixed: 'left',
                    key: 'checkBox',
                    render:(h,params)=>{
                        let that = this;
                        return h('div',[
                            h('Checkbox',{
                                props:{
                                    value:params.row.checkBox
                                },
                                on:{
                                    'on-change':(e)=>{
                                        that.tableData.forEach((items)=>{      //先取消所有对象的勾选，checkBox设置为false
                                            that.$set(items,'checkBox',false)
                                        });
                                        that.tableData[params.index].checkBox = e;  //再将勾选的对象的checkBox设置为true
                                        let data = [that.tableData[params.index]];
                                        if (e){

                                            that.$emit('selectionChange',data);
                                        } else {

                                            that.$emit('selectionChange',[]);
                                        }
                                    }
                                }
                            })
                        ])
                    }
                }

            };
        },
        watch: {
            columns:{

                handler: function (val, oldVal) {

                    var dt = Object.assign([], val);
                    if(dt[0].type === 'selection' && !this.mutiSelect){
                        dt.shift();
                        dt.unshift(this.indexCol);
                    }
                    this.columns_ = dt;

                },
                deep: false,
                immediate: true
            }
        },
        computed:{
            pageStyle(){
                let style = {};
                style.marginTop = '10px';
                if (this.dialogInModal) {
                    style.textAlign = 'right';
                }else {
                    style.float = 'right';
                }
                return style;
            }
        },
        methods: {

            resizeSearchPannel(){
                if (this.searchResize) {

                    this.searchStyle.height = '80px';
                    this.searchStyle.overflow = 'hidden';
                }else{
                    this.searchStyle.height = 'unset';

                }
                this.searchResize = !this.searchResize;
                this.resize();
            },
            onPageChange (pageNo) {
                this.pageNo = pageNo;
                this.$emit('callback', this.pageNo,this.pageSize)
            },
            onPageSizeChange (pageSize){
                this.pageSize = pageSize;
                this.$emit('callback', this.pageNo,this.pageSize)
            },
            resize(){
                let h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
                h = h - this.offsetHeight;
                for (let e of this.heightElems) {
                    if (this.$refs[e] != undefined && this.$refs[e].$el != undefined) {
                        h -= this.$refs[e].$el.offsetHeight
                    }
                }
                this.height = h;
            },
            reset(formName){
                var formName = this.$refs[formName];
                if (formName != undefined){
                    formName.resetFields();
                }
            },
            selectionChange(selection){
                this.$emit('selectionChange',selection);
            },
            selectCurrentRow(currentRow, oldCurrentRow) {
                this.$emit('selectCurrentRow',currentRow,oldCurrentRow);
            },
            rowClick(currentRow,index){
                this.$emit('rowClick',currentRow, index );
            }

        },
        mounted () {
            if (this.$refs.searchForm.$el.scrollHeight > 80) {
                this.searchShow = true;
            }
            if(!this.dialogInModal && this.tableFit){
                this.resize();
                let that = this;
                window.onresize = function () {
                    that.resize()
                }
            }
        }
    };
</script>
