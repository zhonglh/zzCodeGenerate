<style lang="less">

    .message-con{
        .ivu-select-dropdown {

            padding: unset;
            top: 55px;

        }

        .messge-dialog{


            height: 300px;
            width: 270px;
            .header {
                color: #ffffff;
                font-weight: bold;
                font-size: 13px;
                height: 40px;
                line-height: 40px;
                background-color: #90a4ae;
                text-align: left;
                padding-left: 10px;
            }

            .body{

                height: 220px ;
                overflow: auto;
                ul{
                    li{
                        height: 50px;
                        line-height: 50px;
                        padding-left: 5px;
                    }
                }

                .m-item{
                    height: 60px;
                    border-bottom: solid #dddddd 1px;
                    .micon{
                        float: left;
                        width: 60px;
                        img{
                            height: 50px;
                            width: 50px;
                            margin-left: 5px;
                            margin-top: 4px;
                        }
                    }
                    .content{
                        float: left;
                        width: 190px;
                        text-align: left;
                        padding-left: 5px;
                        height: 25px;
                        line-height: 25px;

                    }

                }

                .m-item:hover{
                    background-color: #0fa85699;
                }

            }

            .bottom{
                position: absolute;
                bottom: 0px;
                height: 40px;
                width: 100%;
                line-height: 40px;
                text-align: center;
                background-color: #eeeeee;
            }
        }

    }


    .dt-container{
        .m-item{
            height: 60px;
            border-bottom: solid #dddddd 1px;
            .micon{
                float: left;
                width: 60px;
                img{
                    height: 50px;
                    width: 50px;
                    margin-left: 5px;
                    margin-top: 4px;
                }
            }
            .content{
                float: left;
                width: 190px;
                text-align: left;
                padding-left: 5px;
                height: 25px;
                line-height: 25px;

            }

        }
    }

</style>
<template>

    <div  class="message-con">
        <Dropdown trigger="hover" >
        <Badge :count="count">
            <Icon type="md-volume-up" :size="22" color="#ffc107"/>
        </Badge>
        <DropdownMenu slot="list" style="top: 55px">

            <div  class="messge-dialog">
                <div class="header"><Icon type="email" size="20"></Icon>  <span style="color: red;padding-left: 5px;padding-right: 5px">{{count}}</span>  条未读信息</div>
                <div class="body">

                    <div class="m-item" v-for="(item,index) in noticeList" :key="index" @click="showMessage(index)">
                        <div class="micon"><img src="http://123.57.235.9:88/tzcp/third/mongodb/5a7e6a680a80fe1744b20f08"></img></div>
                        <div class="content">
                                <div>{{item.title}}</div>
                                <div>{{item.notifyTime}}</div>
                        </div>
                    </div>

                </div>
                <div class="bottom">
                    <router-link to="/notice">查看所有消息</router-link>
                </div>
            </div>


        </DropdownMenu>
        </Dropdown>

        <Modal v-model="noticeDisplay"  title="消息详情" :footerHide="footerHide" width="800px">
            <notice-detail :notice="notice"></notice-detail>
        </Modal>
    </div>
</template>

<script>
import noticeDetail from '@/views/system/notice/noticeDetail'
import Cookies from 'js-cookie';
import timeFormat from '@/utils/timeformat';

export default {
    name: 'messageTip',
    props: {
        value: {
            type: Number,
            default: 0
        }
    },
    components: {
        noticeDetail
    },
    data () {
        return {
            id: {
                type: String,
                default: ''
            },
            notice: {},
            noticeList: [],
            noticeDisplay: false,
            footerHide: true
        }
    },
    computed: {
        count () {
            return this.noticeList.length;
        }
    },
    methods: {
        showMessage (index) {
            this.notice = this.noticeList[index];
            this.noticeList.splice(index,1);
            this.noticeDisplay = true;
        },
        messageNotice(){

            if (process.env.NODE_ENV == 'production'){


            let that = this;
            if ("WebSocket" in window)
            {
                var ws = new WebSocket(process.env.NOTICE_URL +  Cookies.get("sessionKey"));
                ws.onopen = function()
                {

                };
                ws.onmessage = function (evt)
                {
                    let data = JSON.parse(evt.data);
                    that.notice = data;
                    that.noticeDisplay = true;
                    that.noticeList.push(data);
                };
                ws.onclose = function()
                {
                    console.log("连接已关闭...");
                };
            } else
            {
                // 浏览器不支持 WebSocket
                console.log("您的浏览器不支持 WebSocket!");
            }
            }
        }
    },
    mounted(){
        this.messageNotice();
    }
};
</script>
