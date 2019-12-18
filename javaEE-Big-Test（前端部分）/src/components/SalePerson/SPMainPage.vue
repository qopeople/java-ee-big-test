<template>

<el-container>
    <el-aside width="180px">
    
            <img :src="avatar" class="yy-avatar">
      
         <!-- <span style="font-size:13px;padding-bottom:20px;line-height:0px">欢迎进入系统</span>  -->
    <el-menu
      active-text-color="white"
       :router="true"
       background-color="transparent"
       text-color="white">

  <router-link to="/Contractlist">
        <el-menu-item index="/Contractlist">
          <i class="el-icon-s-order" style="color:white"></i>
          <span slot="title">查看合同</span>
        </el-menu-item>
      </router-link>
      
      <router-link to="/AchieveSearch">
        <el-menu-item index="/AchieveSearch">
          <i class="el-icon-set-up" style="color:white"></i>
          <span slot="title">业绩查询</span>
        </el-menu-item>    
      </router-link>
  
    

       <!-- <router-link to="/ChangePassWord">
        <el-menu-item index="/ChangePassWord">
          <i class="el-icon-lock" style="color:white"></i>
          <span slot="title">修改密码</span>
        </el-menu-item>
       </router-link> -->
      

      <router-link to="/">
        <el-menu-item index="/">
          <i class="el-icon-switch-button" style="color:white"></i>
          <span slot="title">退出登陆</span>
        </el-menu-item>
      </router-link>

    </el-menu>

    </el-aside>
  
  <el-container>
    <el-header height="90px">
               <Header></Header>
            </el-header>
    <el-main>
       <router-view/>
    </el-main>
  </el-container>
</el-container>
</template>

<script>
import Header from '../Header.vue'
export default {
  components:{
    Header
  },
  data: function(){
    return {
     avatar:require("../../assets/images/avatar.jpg")
      
    }
  },
  
    created:function(){
      console.log(this.$cookies.get("id"));
    },
     methods: {
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped src="../../assets/css/comment.css"></style>

