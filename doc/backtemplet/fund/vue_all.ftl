<style lang="less">

</style>

<template>


    <Row :gutter="32" class="allcls">
        <Col span="24" class="header">
            <span class="title"></span>
            <span class="label"></span><span class="val"></span>
        </Col>
        <Col span="24" class="demo-tabs-style2">
            <Tabs type="card" @on-click="handleTab" v-model="defaultTab">
                <TabPane v-for="(item,index) in tabs" :key="index" :label="item.title" :name="item.component" ></TabPane>
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

    export default {
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
                currentComponent: '',
                defaultTab:'${table.javaName}Detail',
                tabs: []
            };
        },

        methods:{

            handleTab(name){
                this.defaultTab=name;
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

                this.handleTab('${table.javaName}Detail');
            }

        },
        mounted() {
            this.$nextTick(function () {
                this.assemblingComponent();
            });
        }
    }
</script>

