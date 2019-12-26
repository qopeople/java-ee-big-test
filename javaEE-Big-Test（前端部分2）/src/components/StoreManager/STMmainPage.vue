<template>

<el-container>
 
    <el-aside width="180px">
    <img :src="avatar" class="yy-avatar">
    <el-menu
    active-text-color="white"
        :router="true"
       background-color="transparent"
       text-color="white">
  <router-link to="/PurchaseList">
        <el-menu-item index="/PurchaseList">
          <i class="el-icon-s-order" style="color:white"></i>
          <span slot="title">进货管理</span>
        </el-menu-item>
      </router-link>
      
      <router-link to="/DispatchList">
        <el-menu-item index="/DispatchList">
          <i class="el-icon-set-up" style="color:white"></i>
          <span slot="title">发货管理</span>
        </el-menu-item>    
      </router-link>
  
       <router-link to="/RecordLogistic">
        <el-menu-item index="/RecordLogistic">
          <i class="el-icon-lock" style="color:white"></i>
          <span slot="title">物流信息管理</span>
        </el-menu-item>
       </router-link>
       

       <router-link to="/AddGoods">
        <el-menu-item index="/AddGoods">
          <i class="el-icon-lock" style="color:white"></i>
          <span slot="title" >商品管理</span>
        </el-menu-item>
       </router-link>
      

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
     
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped src="../../assets/css/comment.css"></style>
