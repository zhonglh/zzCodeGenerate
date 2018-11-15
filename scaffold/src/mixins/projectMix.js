const mixin = {
    props: {
        projectId:  {
            type: String,
            default: ''
        }
    },
    watch: {
        projectId:{

            handler: function (val, oldVal) {
                try {
                    this.findBy();
                }catch (e) {

                }

                try {
                    this.findByFkId("projectId", val);
                }catch (e) {

                }

            },
            deep: false,
            immediate: true
        }
    }

};
export default mixin;
