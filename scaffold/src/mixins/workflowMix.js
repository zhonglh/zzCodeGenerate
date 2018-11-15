import dialog from '@/utils/dialog';
import taskApi from '@/api/workflow/taskApi';
import objectUtil from '@/utils/objectUtil'

/**
 * 带有审批业务提交功能
 */
const mixin = {
    data: function () {
        return {
            //当前结点
            currentFlowName_: '',
            //下个结点
            nextFlowName_: '',

            //审批结果
            approve_resutDict_: [],
            //下个节点审批人选择列表
            taskNextUserList_: [],
            //下个节点的审批人
            taskNextUserId_: '',
            //流程类型
            workflowType_: '',
            //下个节点ID
            nextActId_: ''
        }
    },
    computed: {
        wfFormData_(){
            let obj =  objectUtil.objectMerge(this.formData, this.$props);
            return Object.assign(obj,{nextActId:this.nextActId_,taskNextUserId:this.taskNextUserId_});
        },
        flowInfo_(){
            return {
                currentFlowName: this.currentFlowName_,
                nextFlowName: this.nextFlowName_,
                taskNextUserList: this.taskNextUserList_,

            }
        }
    },
    methods: {


        //返回选择的下个节点审批人
        nextUserChangeCallback_(personId){
            this.taskNextUserId_ = personId;

        },
        //判断当前审核状态下业务是否可以编辑
        isInWorkflow_(){
            return (this.formData.approveState === '2' || this.formData.approveState === '4');
        },
        //获取启动任务 需要的信息
        beforeStartWF_() {
            let that = this;
            taskApi.beforeStartWF({businessType:this.workflowType_}, {
                onSuccess(body) {
                    that.currentFlowName_  = body.firstUserTask.name;
                    that.nextFlowName_  = body.nextFlowName;
                    that.nextActId_  = body.nextActId;
                    const personList = body.secondUserTaskUserMap[that.nextActId_];
                    that.taskNextUserList_ = personList;
                }
            });

        },

        submitProcess_(){
            let  that = this;
            if (this.formData.nextActId == ''){
                dialog.success("当前流程不完整，请检查流程图的完整性", this);
            } else {
                if (that.taskNextUserId_ == undefined || that.taskNextUserId_ == '' ){
                    alert('请选择审批人',that);
                    return;
                }
                this.validateForm_('formData');
                if (this.formValid_) {

                    eval('that.submitInfo()');

                }

            }
        },
        mounted() {

        }
    }
};

export default mixin;
