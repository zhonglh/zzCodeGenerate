<style>

    .my-head{
        clear: both;
        border-bottom: solid 1.5px #00acc1;
        font-weight: normal;
        font-size: 13px;
        margin-bottom: 5px;
    }
</style>
<template>
    <Row class="my-head">
        <Col :xs="24" :sm="12" :md="12" :lg="12">
            <Icon :type="icon" :color="iconColor" :size="iconSize"/><b>{{title}}</b>
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="12" style="text-align: right;padding: 2px">
            <slot name="toolbar"></slot>
        </Col>

    </Row>
</template>
<script>


    export default {
        name: 'blockHead',
        props: {
            icon:  {
                type: String,
                default: 'ios-list'
            },
            iconColor:  {
                type: String,
                default: '#00acc1'
            },
            iconSize:  {
                type: Number,
                default: 30
            },
            title:  {
                type: String,
                default: ''
            }
        }
    }
</script>
