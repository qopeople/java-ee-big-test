<template>

<el-container>
    
    <el-aside width="180px">
         <img :src="avatar" class="yy-avatar">
    <el-menu
     :router="true"
       background-color="transparent"
       text-color="white"
       active-text-color="white">
  <router-link to="/ContractManage">
        <el-menu-item index="/ContractManage">
          <i class="el-icon-s-order"  style="color:white"></i>
          <span slot="title">合同信息管理</span>
        </el-menu-item>
      </router-link>

        <router-link to="/ClientManage">
        <el-menu-item index="/ClientManage">
          <i class="el-icon-set-up"  style="color:white"></i>
          <span slot="title">客户信息管理</span>
        </el-menu-item>    
      </router-link>

      <router-link to="/SaleManage">
        <el-menu-item index="/SaleManage">
          <i class="el-icon-set-up"  style="color:white"></i>
          <span slot="title">销售人员管理</span>
        </el-menu-item>    
      </router-link>
  
      <router-link to="/StatisticlSales">
        <el-menu-item index="/StatisticlSales">
          <i class="el-icon-set-up"  style="color:white"></i>
          <span slot="title">统计销售额</span>
        </el-menu-item>    
      </router-link>
  
      <router-link to="/DispatchOrder">
        <el-menu-item index="/DispatchOrder">
          <i class="el-icon-set-up"  style="color:white"></i>
          <span slot="title">添加发货单</span>
        </el-menu-item>    
      </router-link>

       <!-- <router-link to="/ChangePassWord">
        <el-menu-item index="/ChangePassWord">
          <i class="el-icon-lock"></i>
          <span slot="title">修改密码</span>
        </el-menu-item>
       </router-link>
       -->

      <router-link to="/">
        <el-menu-item index="/">
          <i class="el-icon-switch-button"  style="color:white"></i>
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