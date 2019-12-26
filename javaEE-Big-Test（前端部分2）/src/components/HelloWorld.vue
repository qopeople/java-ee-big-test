<template>
<el-container>
  <el-aside width="200px">Aside</el-aside>
  <el-container>
    <el-header height="90px">
      <el-row>
    <el-col :span="3">
      <img :src="imageLogo" class="yy-img">
    </el-col>
       <el-col :span="1"  :offset="18"  >
          <div class="yy-div">
            <i class=" el-icon-s-home el-icon-iconName"></i>
            <span class="yy-span">首页</span>
          </div>  
    </el-col>
    <el-col :span="1"   >
      <div class="yy-div">
             <i class="el-icon-s-fold el-icon-iconName" ></i>
               <span class="yy-span">上一页</span>
      </div>
    
    </el-col>
    <el-col :span="1" >
      <div class="yy-div"> 
          <i class="el-icon-eleme el-icon-iconName"></i>
          <span class="yy-span">退出</span>
       </div>   
    </el-col>
  </el-row>  
    </el-header>
    <el-main>Main</el-main>
  </el-container>
</el-container>

</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        imageLogo:require("../assets/images/logo.png")
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style>
.el-header, .el-footer {
    color: #333;
    text-align: center;
    padding: 0px
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
  }
  .yy-img{
    width: 180px;
    padding: 0px;
    height: 90px;
  }
  .yy-span{
        display: inline-block;
    padding: 0 3px;
    height: 1em;
    color: #333;
  }
  .el-icon-iconName{
    font-size: 34px;
    margin-top:16px;
    color: #333;
  }
  .el-icon-iconName:hover,.el-icon-iconName:active{
   
    color: #5cb6ff;
  }
    .yy-span:hover,  .yy-span:active{
         
    color: #5cb6ff;
    }
</style>