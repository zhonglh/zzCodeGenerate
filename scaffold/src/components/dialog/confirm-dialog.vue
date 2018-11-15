<style>

    .confirm .ivu-card-head{
        background-color: #e65100;
        height: 100%;
        width: 100%;
        display: block;
    }
</style>
<template>

    <div class="confirm">
        <Modal
                v-model="display"
                title="title"
                @on-visible-change="onVisibleChange"
                width="300"
                @on-ok="confirm"
                @on-hidden="hiddenFn">
            <p>{{content}}</p>
        </Modal>
    </div>


</template>
<script>
    export default {
        props: {
            id: String,
            title: String,
            content:String,
            show: false
        },
        data () {
            return {
                display: false
            }
        },
        watch: {
            show: function (newValue, oldValue) {
                this.display = newValue
            }
        },
        methods: {
            confirm() {
                this.$emit('confirm');
            },
            onVisibleChange(v) {
                this.$emit('confirmFun',v);
            },
            hiddenFn(){
                this.display = false;
            }
        },
        mounted() {}
    };
</script>
