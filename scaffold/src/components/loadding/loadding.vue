<style lang="less">
    .loading{
        position: fixed;
        top:0;
        left:0;
        z-index:9999;
        width: 100%;
        height: 100%;
        background: rgba(0,0,0,0.7);
        display: table-cell;
        vertical-align: middle;
        text-align: center;
    }
    .loading img{
        margin:10rem auto;
    }
</style>
<template>

    <div class="loading">
        <img src="./img/puff.svg" />
    </div>
</template>
<script>

    export default {
        name: 'loadding',
        props: {
            type: {
                type: String,
                default: ''
            },
        }

    };
</script>
