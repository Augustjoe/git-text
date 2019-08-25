new Vue({
    el:"#box",
    data:{
            age:20,
            x:0,
            y:0,
            name:""
    },
    methods:{
        add : function (){
            this.age++
        },
        dec : function(){
            this.age--
        },
        mousem : function(event){
            this.x=event.offsetX;
            this.y=event.offsetY
        },
        keyup : function () {
            this.age=this.$refs.age.value
            this.name=this.$refs.name.value
        }
    }
})