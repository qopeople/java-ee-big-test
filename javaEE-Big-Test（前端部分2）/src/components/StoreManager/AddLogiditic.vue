<template>
   <el-row>
     <el-col :span="10" :push="1">
        <div style="margin-top:30px">
          <el-card class="box-card">
          <el-timeline>
                <el-timeline-item
                  v-for="(activity, index) in activities"
                  :key="index"
                  :icon="activity.icon"
                  :type="activity.type"
                  :color="activity.color"
                  :size="activity.size"
                  :timestamp="activity.timestamp"
                  placement="top">
                      <h4> {{activity.content}}</h4>
                  
                </el-timeline-item>
              </el-timeline>
          </el-card>
     
        </div>
     </el-col>
     <el-col :span="12" >
       <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>添加物流信息</span>
            <el-button style="float: right;" size="small" type="primary" @click="addLogidtic">确认添加</el-button>
             <el-button style="float: right;margin-right:20px" size="small" type="primary" @click="confirmRecive">已签收</el-button>
          </div>
          <el-row>
            <el-col :span="5">配送地址</el-col>
            <el-col :span="8">
              <el-input v-model="currentpostion" placeholder="请填写配送地址"></el-input>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="5">配送时间</el-col>
            <el-col :span="8">
               <el-date-picker
              v-model="steptime"
              align="right"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期时间">
            </el-date-picker>
            </el-col>
  
          </el-row>
        </el-card>
     </el-col>
   </el-row>


</template>

<script>
export default {
data:function(){
    return{
         activities: [],
         dispatchlistid:'',
         steptime:"",
         currentpostion:"",

    }  },
created:function(){
    var that =this;
    var dispatchlistid = that.$route.query.dispatchlistid;
    that.dispatchlistid = dispatchlistid;
    that.getLogiditic();
},
methods:{
 
  getLogiditic:function(){
     this.activities=[];
     var that =this;
         that.$axios.allLogisticById(that.dispatchlistid).then(res=>{
      for(var i in res.data){
        var item={
            content: '',
          timestamp: '',
           size: 'large',
          type: 'primary',
          icon: 'el-icon-location'
        }
        item['content'] = res.data[i].currentpostion;
        item['timestamp'] = res.data[i].steptime.substr(0,10);
        that.activities.push(item);
      }
    }).catch(err=>{
        console.log(err);
    })
  },
  confirmRecive:function(){
        var  contractid;
       var that =this;
       var parma={}
       console.log(that.dispatchlistid)
      that.$axios.dispatchById(that.dispatchlistid).then(res=>{
            parma={
             contractid:res.data.contractid,
             itemstatus:"履行完成",
             contractitemid:res.data.contractitemid,
           }
           contractid = res.data.contractid;
           that.$axios.itemStatusOne(parma).then(res2=>{
              that.$axios.contractStatus(contractid).then(res3=>{
              that.$message({
                message: '更新物流信息成功',
                type: 'success'
              });
               that.$router.back(-1); 
              }).catch(err=>{
                console.log(err);
              })
           }).catch(err=>{
             console.log(err);
           })
       }).catch(err=>{
         console.log(err);
       })
        
  },
  addLogidtic:function(){
       var that =this;
       var parma = {
         dispatchlistid:that.dispatchlistid,
         currentpostion:that.currentpostion,
         steptime:that.steptime
       }
       console.log(that.steptime);
       that.$axios.addLogistic(parma).then(res=>{
               that.$message({
                message: '更新物流信息成功',
                type: 'success'
              });
              that.currentpostion="";
              that.steptime="";
           that.getLogiditic();
       }).catch(err=>{
         console.log(err);
       })
  }
}
}
</script>

<style scoped>
.text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 450px;
    margin-top: 40px;
    height: 400px;
    
  }
.el-col{
  line-height: 40px;
  margin-top: 20px
}
.box-card2{
  width: 240px;
  height: 140px;
}
</style>