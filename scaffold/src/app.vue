<template>
    <div id="main" class="app-main">

        <loadding v-show="fetchLoading"></loadding>
        <router-view></router-view>
    </div>
</template>

<script>
    import loadding from '@/components/loadding/loadding'
    export default {
        components:{
            loadding
        },
        data () {
            return {
                theme: this.$store.state.app.themeColor
            };
        },
        computed:{
            fetchLoading(){
                return this.$store.state.app.fetchLoading
            }
        },
        mounted () {
        },
        beforeDestroy () {

        },
        methods: {

        }
    };
</script>

<style lang="less">
html,body{
    width: 100%;
    height: 100%;
    background: #f0f0f0;
    overflow: hidden;
}
.app-main{
    width: 100%;
    height: 100%;
}


.allcls{

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


.form-bottom-btns{
    text-align: right;
    padding-right: 20px;
    border-top: solid 1px #dddddd;
    height: 40px;
    line-height: 40px;
}

.page-body{
    /*margin-top: 10px*/
}

.ivu-form .ivu-form-item-label {
    text-align: right;
    vertical-align: middle;
    float: left;
    font-weight: normal;
    font-size: 13px;
    color: #495060;
    line-height: 1;
    padding: 10px 12px 10px 0;
    box-sizing: border-box;
}

.ivu-modal-header {
    border-bottom: 1px solid #e9eaec;
    padding: 10px 15px;
    line-height: 1;
    background-color: #00acc1;
}

.ivu-modal-body {
    padding: 5px;
    font-size: 12px;
    line-height: 1.5;
}
.ivu-table th, .ivu-table td{
    height:32px;
}
.ivu-modal-close .ivu-icon-ios-close {
    font-size: 31px;
    color: #ffffff;
    transition: color 0.2s ease;
    position: relative;
    top: 1px;
}
/*.ivu-modal-footer {*/
    /*border-top: 1px solid #e4e5e7;*/
    /*padding: 12px 18px 12px 18px;*/
    /*text-align: right;*/
    /*background-color: #eeeeee;*/
/*}*/
.ivu-modal-header p, .ivu-modal-header-inner {
    display: inline-block;
    width: 100%;
    height: 20px;
    line-height: 20px;
    font-size: 14px;
    color: #f7f7f7;
    font-weight: bold;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.ivu-modal-close .ivu-icon-ios-close-empty {
    font-size: 31px;
    color: #f7f7f7;
    transition: color 0.2s ease;
    position: relative;
    top: 1px;
}

.ivu-tag-dot {
    height: 40px;
    line-height: 40px;
    border: 1px solid #e9eaec !important;
    color: #495060 !important;
    background: #fff !important;
    padding: 0 12px;
}
.main .tags-con {
    height: 40px;
    z-index: -1;
    overflow: hidden;
    background-color: #ffffff;
}
.main .tags-con .tags-outer-scroll-con .tags-inner-scroll-body {
    position: absolute;
    padding: 0px 10px;
    overflow: visible;
    white-space: nowrap;
    transition: left .3s ease;
}

.toolbar{
    line-height: 40px;
    // border-top: solid #00a854 2px;
}

.search-form{
    // line-height: 50px;
    /*border-bottom: solid #00acc1 2px;*/
    /*padding-bottom: 5px;*/
}


.form-item{
    clear: both;
    .label{
        width: 80px;
        height: 30px;
        line-height: 30px;
        font-weight: bold;
        text-align: right;
        font-size: 13px;
        float: left;
    }
    .content{

        height: auto;
        margin-left: 20px;
        font-size: 13px;
        float: left;
        min-width: 600px;
        ul{
            list-style: none;
            li{
                float: left;
                width: 80px;
                height: 30px;
                line-height: 30px;
                /*background-color: #cccccc;*/
                text-align: center;
                /*border: dotted 1px #cccccc;*/
                color: #023256;
                cursor: pointer;
                margin: 5px;
            }

            li:hover{
                float: left;
                width: 80px;
                height: 30px;
                line-height: 30px;
                text-align: center;
                background-color: #049ae5;
                color: white;
                cursor: pointer;
                margin: 5px;
            }

            .active{
                color: white;
                background-color: #049ae5;
            }
        }
    }

}
</style>
