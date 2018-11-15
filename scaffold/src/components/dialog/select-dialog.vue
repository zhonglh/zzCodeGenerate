<template>
    <Modal
            v-model="show"
            :title="title"
            @on-visible-change="onVisibleChange"
            @on-ok="okFun"
            width="1000"
            loading
            scrollable>

        <custormer-grid ref="mcom"></custormer-grid>


    </Modal>
</template>

<script>

    import custormerGrid from '@/views/demo/user/userGrid'

    export default {
        props: {
            title: String,
            url: {
                type: String,
                default: ''
            },
            display: {
                type: Boolean,
                default: false
            },
            mutiSelect: {
                type: Boolean,
                default: false
            }
        },
        components:{
            custormerGrid:custormerGrid
        },
        computed: {
            show () {
                return this.display;
            }
        },
        methods: {
            onVisibleChange(v) {
                this.$emit('onVisibleChange',v);
            },
            okFun(){

                let selectedData = this.$refs.mcom.selectedData;
                if (selectedData.length<1){
                    this.$Message.error('请选择要数据！')
                }else {
                    if (this.mutiSelect){
                        this.$emit('on-selected',selectedData);
                    } else {
                        this.$emit('on-selected',selectedData[0]);
                    }

                }
            }
        }
    };

</script>


<style lang="less">
</style>