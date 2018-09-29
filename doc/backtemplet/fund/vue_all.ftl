<style lang="less">
    .m-container{
        width: 100%;
        height: 100%;
        margin: 5px;
        border-left: 1px #ccc solid;

    .tabs{
        width: 100%;
        border-bottom: 1px #ccc solid;
        padding: 5px;
    }

    }
    .title{
        text-align: left;
        float: left;
    }

    .All{

    .header{


    .title{
        height: 40px;
        line-height: 40px;
        font-size: 18px;
        font-weight: bold;
        padding-bottom: 5px;
    }
    .label{
        height: 40px;
        line-height: 40px;
        margin-left: 10px;
        font-size: 13px;
        font-weight: bold;
    }
    .val{
        height: 40px;
        line-height: 40px;
        font-size: 13px;
        color: #ee9900;
        font-weight: bold;
    }
    }

    }
</style>

<template>
    <Modal

            v-model="show"
            :title="title"
            fullscreen
            @on-visible-change="onVisibleChange"
            :footer-hide="true"
            loading
            scrollable>



        <Row :gutter="32" class="fundAll">
            <Col span="24" class="header">
            <span class="title"></span>
            <span class="label"></span><span class="val"></span>
            </Col>
            <Col span="24" class="demo-tabs-style2">
            <Tabs type="card" @on-click="handleTab">
                <TabPane v-for="(item,index) in tabs" :key="index" :label="item.title" name="item.component" ></TabPane>
            </Tabs>

            <keep-alive>
                <component v-bind:is="currentComponent" :${table.simpleName}Id="${table.javaName}.id"></component>
            </keep-alive>
            </Col>
        </Row>

    </Modal>
</template>

<script>
    const _import = require('@/router/_import_production');
    import propMix from '@/mixins/propMix';

    export default {
        mixins:[propMix],
        components:{

        },

        props: {
            ${table.javaName}:  {
                type:Object,
                default:function () {
                    return {};
                }
            }
        },
        watch: {
            ${table.javaName}: function (newVal, oldVal) {
                this.handleTab('${table.javaName}Detail');
            }
        },

        data () {
            return {
                btnType: 'success',
                btnGhost: 'ghost',
                currentComponent: '',
                tabs: []
            };
        },

        methods:{

            handleTab(name){
                this.currentComponent = name;
            },

            assemblingComponent(){
                this.tabs = [];

                this.tabs.push({title: '基本信息', component: '${table.javaName}Detail'});
                this.$options.components['${table.javaName}Detail'] = _import('${table.fullResourceName?substring(1)}/${table.javaName}Detail');


                <#if table.childFkTables?exists >
                <#list table.childFkTables as child>
                <#if child.pageRelation?exists && child.pageRelation == '2'>
                <#if child.tableRelation?exists && child.tableRelation == 'one-multi'>
                this.tabs.push({title: '${child.tableComment}', component: '${child.javaName}List'});
                this.$options.components['${child.javaName}List'] = _import('${child.fullResourceName?substring(1)}/${child.javaName}List');
                <#else >
                this.tabs.push({title: '${child.tableComment}', component: '${child.javaName}Detail'});
                this.$options.components['${child.javaName}Detail'] = _import('${child.fullResourceName?substring(1)}/${child.javaName}Detail');
                </#if>
                </#if>
                </#list>
                </#if>

                this.handleTask('${table.javaName}Detail');
            }

        },
        mounted() {
            this.$nextTick(function () {
                this.assemblingComponent();
            });
        }
    };
</script>

