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
</style>

<template>
    <Row class="m-container">
        <Col :xs="24" :sm="24" :md="24" :lg="24">
        <div class="tabs">
                <span v-for="(item,index) in tabs" :key="index">
                    <Button :type="btnType" icon="android-add-circle" ghost  v-if="stepIndex != index"  style="margin-left:10px;"  @click="handleTask(index,item)">{{item.title}}</Button>
                    <Button :type="btnType" icon="android-add-circle" v-if="stepIndex == index"   style="margin-left:10px;"  @click="handleTask(index,item)">{{item.title}}</Button>

                </span>

        </div>

        </Col>
        <Col :xs="24" :sm="24" :md="24" :lg="24">
        <keep-alive>
            <component v-bind:is="currentComponent"></component>
        </keep-alive>
        </Col>
    </Row>
</template>

<script>
    const _import = require('@/router/_import_production');
    import projectStepTaskApi from '@/api/projectStepTaskApi';
    import onfire from 'onfire.js'
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
        data () {
            return {
                btnType: 'success',
                btnGhost: 'ghost',
                currentComponent: '',
                tabs: []
            };
        },
        watch: {
            ${table.javaName}(val ,oldVal){
                onfire.fire('projectInfo',this.${table.javaName}, this.step);
                this.findStepTaskList();
            }
        },
        methods:{

            handleTask(index,item){
                this.currentComponent = item.component;
            },
            assemblingComponent(){
                this.tabs = [];
                <#list childFkTables as child>
                this.tabs.push({id: item.id, isMust: item.isMust,title: item.taskName, component: componentName});
                </#list>

                this.handleTask(0,this.tabs[0]);
            }

        },
        mounted() {
            let that = this;
            this.assemblingComponent();
        },

        created: function () {
        }
    };
</script>

