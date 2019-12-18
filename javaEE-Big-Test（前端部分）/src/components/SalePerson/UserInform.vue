<template>
<div style="margin-left:120px">
    <el-row >
        <el-col :span="3">
            <div class="yy-inform-text-2" >
              监护人电话
            </div>  
        </el-col>
        <el-col :span="5"><div class="yy-inform-text-3">{{userinform.name}}</div></el-col>
    </el-row>
     <el-row >
        <el-col :span="3">
            <div class="yy-inform-text-2" >
              监护人姓名
            </div>  
        </el-col>
        <el-col :span="5"><div class="yy-inform-text-3">{{userinform.guarderName}}</div></el-col>
         <el-col :span="16"></el-col>
    </el-row>
 
      <el-row >
        <el-col :span="3">
            <div class="yy-inform-text-2" >
              监护人电话
            </div>  
        </el-col>
        <el-col :span="5"><div class="yy-inform-text-3">{{userinform.guarderPhone}}</div></el-col>
    </el-row>

     <el-row >
        <el-col :span="3">
            <div class="yy-inform-text-2" >
              监护人身份证
            </div>  
        </el-col>
        <!-- //{{userinform.guarderIdentity}} -->
        <el-col :span="5"><div class="yy-inform-text-3">{{userinform.guarderIdentity}}</div></el-col>
    </el-row> 

     <el-row >
        <el-col :span="3">
            <div class="yy-inform-text-2" >
              用户手机号码
            </div>  
        </el-col>
        <el-col :span="5"><div class="yy-inform-text-3">{{userinform.phone}}</div></el-col>
    </el-row> 
</div>


    
</template>


<script>
export default {
    data:function(){
        return{
            
             userinform:[]
        }
    },
    created(){
        // var that = this
        // var userid = this.$route.params.userId;
        // console.log(userid)
        // that.$axios.userDetail(userid).then(res=>{
        //     that.userinform = res.data

        // }).catch(err=>{
        //   console.log(err)
        // })
    }
}
</script>
<style scoped>
.yy-inform-text-1{
color:rgba(26, 26, 26, 1);
font-size:30px;
margin-top: 20px;    
margin-right: 50px;
}
.yy-inform-text-2{
    font-size: 17px;
    color: rgba(26, 26, 26, 0.44);
    margin-top: 40px;

}
.yy-inform-text-3{
       font-size: 17px;
       color: rgba(26, 26, 26);
       margin-top: 40px;
       margin-right: 80px;
}
</style>