<style>

    .form-item .content {
        height: auto;
        margin-left: 20px;
        font-size: 13px;
        float: left;
        /* min-width: 600px; */
    }
</style>
<template>

        <div class="form-item">
            <div class="label">{{label}}:</div>
            <div class="content">
                <ul>
                    <li v-for="(m,index) in listData" :class="{ active:index==selectedIndex}" :key="index" @click="click(m.dictVal,index)">
                        {{m.dictName}}
                    </li>
                </ul>
            </div>
        </div>
</template>

<script>
    export default {
        name: 'select-span',
        props: {
            value: {
                type: [String, Number, Array],
                default: ''
            },
            label:{
                type: String,
                default: ''
            },
            selectData: {
                type: Array,
                default: []
            }
        },
        data () {
            return {
                selectedIndex: undefined
            }
        },
        computed:{
            listData() {
                let data =  this.selectData;
                return [{dictVal:'',dictName:'全部'},...data];
            }
        },
        methods: {
            click(id, index){
                this.selectedIndex = index;
                this.$emit('input',id);
                this.$emit('change');
            }
        }
    }
</script>
