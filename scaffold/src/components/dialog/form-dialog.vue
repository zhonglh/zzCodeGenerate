<style>
    @import "https://cdn.jsdelivr.net/npm/animate.css@3.5.2/animate.min.css";

</style>
<template>

    <div>
        <Modal
                v-model="display"
                :title="title"
                @on-visible-change="onVisibleChange"
                width="800"
                loading
                scrollable>


            <slot></slot>
            <div slot="footer">
                <slot name="footer">
                    <Button type="ghost" @click="closeDialog" style="margin-left: 8px">取消</Button>
                </slot>
            </div>
        </Modal>
    </div>


</template>
<script>
    export default {
        props: {
            title: String,
        },
        data () {
            return {
                display: false
            }
        },
        methods: {
            closeDialog(){
                this.display = false
            },
            onVisibleChange() {
                this.$emit('onVisibleChange');
            }
        },
        mounted() {
            let that = this;
            this.$on('showFormDialog', function (v) {
                that.display = true;
            });
            this.$on('closeFormDialog', function (v) {
                that.display = false;
            })
        }
    };
</script>
