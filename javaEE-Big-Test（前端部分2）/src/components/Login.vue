<template>
<div >
            <el-card class="box-card" style="margin-top:80px">
                <div slot="header" class="clearfix">
                    <p class="yy-head">企业信息管理系统登录入口</p>
                </div>
              
                    <div class="inputs">
                        <el-select v-model="selectedId" clearable placeholder="请选择身份" style="width: 280px;">
                            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                            </el-option>
                        </el-select>
                    </div>
                    <div class="inputs">
                        <!-- <input placeholder=" 请输入用户名" name="username" type="text" require="required"> -->
                        <el-input placeholder="请输入用户名"  v-model="username" clearable style="width: 280px;">
                        </el-input>
                    </div>
                    <div class="inputs">
                        <el-input placeholder="请输入密码" v-model="password" require="required" show-password style="width: 280px;"></el-input>
                    </div>
                    
                    <el-button  class="yy-btn" @click="confirmLogin" >登录</el-button>
            </el-card>
</div>

</template>
<script>
  export default {
    data() {
      return {
        activeName: 'second',
        username:"",
        password:"",
        options:[{
          value:"销售人员",
          lable:"销售人员"
        },{
          value:"销售管理员",
          lable:"销售管理员"
        },{
          value:"仓库管理员",
          lable:"仓库管理员"
          }],
        selectedId:""
      };
    },
    created:function(){
      if(this.$cookies.get("id"))
      this.$cookies.remove("id");
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      },
      confirmLogin(){
        var that =this;
          var parma ={
             username:that.username,
             password:that.password
           }
           console.log(parma);
        if(that.selectedId=="销售管理员"){
           that.$axios.login(parma).then(res=>{
             if(res.data==-1){
                 this.$message.error(res.msg);
                 return;
             }
             if(res.data.password==that.password){
               this.$message({
                message: '登录成功',
                type: 'success'
              });
             that.$cookies.set("id",res.data.salemanagerid);
             that.$router.replace('/SMmainPage')
               return;
           }else if(res.data.password!=that.password){
                 this.$message.error("用户与密码不对应，请确认重新输入！");
                 return;
           }
           
           }).catch(err=>{
             console.log(err);
           })
        }else if(that.selectedId=="仓库管理员"){
             that.$axios.loginSTM(parma).then(res=>{
                if(res.data==-1){
                  this.$message.error(res.msg);
                  return;
                }
                if(res.data.password==that.password){
                  this.$message({
                    message: '登录成功',
                    type: 'success'
                  });
                  that.$cookies.set("id",res.data.storemangerid);
                  that.$router.replace('/STMmainPage')
                  return;
              }else if(res.data.password!=that.password){
                    this.$message.error("用户与密码不对应，请确认重新输入！");
                    return;
              }
            
           }).catch(err=>{
             console.log(err);
           })
           }else{
               that.$axios.loginSP(parma).then(res=>{
                           if(res.data==-1){
                  this.$message.error(res.msg);
                  return;
                }
                if(res.data.password==that.password){
                  this.$message({
                    message: '登录成功',
                    type: 'success'
                  });
                  that.$cookies.set("id",res.data.salerid);
                  that.$router.replace('/SPMainPage')
                  return;
              }else if(res.data.password!=that.password){
                    this.$message.error("用户与密码不对应，请确认重新输入！");
                    return;
              }
                }).catch(err=>{
                  console.log(err);
                })
           }
        
      }
    }
  };
</script>

<style scoped>
    .box-card {
        margin-top: 250px;
        width: 500px;
        background-color: aliceblue;
        margin: 0 auto;
    }
    
    .inputs {
        width: 100%;
        margin: 0 auto;
        margin-bottom: 30px;
       
        margin-top: 20px;
       
    }
    
    .inputs>input {
        width: 280px;
        height: 30px;
    }
    
    .others {
       margin: 0 auto;
        margin: 20px;
      
    }
    
    .yy-btn {
       margin: 0 auto;
        margin-top: 20px;
        width: 300px;
        height: 40px;
        background-color: #409eff;
        color: aliceblue;
        outline: none;
    }
    .yy-head{
      text-align: center; color: #409eff;font-size:25px;font-weight: bold;
    }

</style>