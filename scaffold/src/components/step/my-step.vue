<style lang="less">

        .ivu-steps-item:hover{
            // background-color: #f0f0f0;
            // border-right: solid #00a854 5px;
            cursor: pointer;
            // .ivu-steps-title{
            //     background-color: #f0f0f0;
            // }
            // .ivu-steps-head{
            //     background-color: #f0f0f0;
            // }
        }

        .ivu-steps.ivu-steps-small .ivu-steps-title {
            margin-bottom: 4px;
            margin-top: 0;
            color: #666;
            font-size: 14px;
            font-weight: bold;
        }

        .itemSel{
            background: linear-gradient(#f0f0f0,#cccccc);

            border-right: solid #00a854 5px;
            cursor: pointer;
            .ivu-steps-title{
                background: linear-gradient(#f0f0f0,#e6e6e6);
            }
            .ivu-steps-head{
                background: linear-gradient(#f0f0f0,#e6e6e6);
            }
        }

</style>
<template>

    <div :class="wrapClasses" :style="styles" @click="clickHandle">
        <div :class="[prefixCls + '-tail']"><i></i></div>
        <div :class="[prefixCls + '-head']">
            <div :class="[prefixCls + '-head-inner']">
                <span v-if="!icon && currentStatus != 'finish' && currentStatus != 'error'">{{ stepNumber }}</span>
                <span v-else :class="iconClasses"></span>
            </div>
        </div>
        <div :class="[prefixCls + '-main']">
            <div :class="[prefixCls + '-title']">{{ title }}</div>
            <slot>
                <div v-if="content" :class="[prefixCls + '-content']">{{ content }}</div>
            </slot>
        </div>
    </div>
</template>
<script>
    import Emitter from 'iview/src/mixins/emitter';
    import { oneOf } from 'iview/src/utils/assist';

    const prefixCls = 'ivu-steps';
    const iconPrefixCls = 'ivu-icon';

    export default {
        name: 'mystep',
        mixins: [ Emitter ],
        props: {
            status: {
                validator (value) {
                    return oneOf(value, ['wait', 'process', 'finish', 'error']);
                }
            },
            title: {
                type: String,
                default: ''
            },
            content: {
                type: String
            },
            icon: {
                type: String
            }
        },
        data () {
            return {
                prefixCls: prefixCls,
                stepNumber: '',
                nextError: false,
                total: 1,
                currentStatus: ''
            };
        },
        computed: {
            wrapClasses () {
                return [
                    `${prefixCls}-item`,
                    `${prefixCls}-status-${this.currentStatus}`,
                    {
                        [`${prefixCls}-custom`]: !!this.icon,
                        [`${prefixCls}-next-error`]: this.nextError
                    }
                ];
            },
            iconClasses () {
                let icon = '';

                if (this.icon) {
                    icon = this.icon;
                } else {
                    if (this.currentStatus == 'finish') {
                        icon = 'ios-checkmark-empty';
                    } else if (this.currentStatus == 'error') {
                        icon = 'ios-close-empty';
                    }
                }

                return [
                    `${prefixCls}-icon`,
                    `${iconPrefixCls}`,
                    {
                        [`${iconPrefixCls}-${icon}`]: icon != ''
                    }
                ];
            },
            styles () {
                return {
                    width: `${1/this.total*100}%`
                };
            }
        },
        watch: {
            status (val) {
                this.currentStatus = val;
                if (this.currentStatus == 'error') {
                    this.$parent.setNextError();
                }
            }
        },
        methods: {

            clickHandle() {
                this.$emit('clickHandle');
            }
        },
        created () {
            this.currentStatus = this.status;
        },
        mounted () {
            this.dispatch('Steps', 'append');
        },
        beforeDestroy () {
            this.dispatch('Steps', 'remove');
        }
    };
</script>
