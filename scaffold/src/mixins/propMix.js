const mixin = {
    props: {
        title:  {
            type: String,
            default: ''
        },
        display:  {
            type: Boolean,
            default: false
        },
    },
    data: function () {
        return {
            id: '',
            show: false,
            maskClosable: false,
            formValid: false,
            dialogWidth: 800,
            labelWidth:160
        }
    },
    watch: {
        display: function (newVal, oldVal) {
            this.show = newVal;
        }
    },

    methods: {
        closeDialog(btnSource) {
            this[btnSource + 'Display'] = false;
        },
        onVisibleChange(v) {
            if (!v){
                this.$emit('closeDialog')
            }
        }
    }

};

export default mixin;
