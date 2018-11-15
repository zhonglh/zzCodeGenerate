<template>

    <Modal
            v-model="show"
            :title="title"
            @on-visible-change="onVisibleChange"
            :footer-hide="false"
            @on-ok="okFun"
            :width="width"
            :mask-closable="false"
            loading
            scrollable>

    <table-list :columns="selectColumns" :tableData="tableData" :total="total" :loading="loading" @selectionChange="selectionChange" @callback="callback" :tableFit="false" :pageBarDisplay="false"/>

    </Modal>

</template>
<script>

    import tableList from '@/components/table-list/tableList'

    export  default {
        name: 'tableSelect',
        props:{

            title:  {
                type: String,
                default: ''
            },
            display:  {
                type: Boolean,
                default: false
            },
            tableColumns:  {
                type: Array,
                default () {
                    return []
                }
            },
            tableData:  {
                type: Array,
                default () {
                    return []
                }
            },
            total:  {
                type: Number,
                default: 0
            },
            loading:  {
                type: Boolean,
                default: false
            },
            width:  {
                type: Number,
                default: 800
            }
        },
        components:{
            tableList
        },
        data() {
            return {

                show: false,
                selectColumns: [
                    {
                        title: '序号',
                        type: 'selection',
                        width: 80,
                        align: 'center'
                    },
                    {
                        title: '用户姓名',
                        key: 'userName',
                        align: 'center',
                        width: 150
                    },
                    {
                        title: '所属机构部门名称',
                        key: 'deptName',
                        align: 'center'
                    }

                ],
                selection:[]
            };
        },
        watch:{

            display(val, oldVal){
                this.show = val;
            }
        },

        methods: {

            selectionChange(selection){
                this.selection = selection;
            },
            callback(){

            },
            onVisibleChange(v){
                if (!v)  this.$emit('closeDialog');
            },
            okFun(){
                this.$emit('selectionChange',this.selection);
                this.$emit('closeDialog');
            }
        }
    }
</script>
<style>

</style>
