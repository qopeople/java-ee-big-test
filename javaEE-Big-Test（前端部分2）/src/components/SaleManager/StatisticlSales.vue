<template>
<div>
    <el-card style="margin:20px">
        <!-- 筛选条件 -->
      <el-row style=" margin-top: 13px;">
        <el-col :span="5">
          <div class="yy-title">业绩时间</div>
           <el-date-picker
            v-model="createTime"
            type="daterange"
            align="right"
            unlink-panels
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          value-format="yyyy-MM-dd"
              style="width:330px"
             >
          </el-date-picker>
        </el-col>
          <el-col :span="5" :offset="3" >
          <div class="yy-title">商品编号</div>
           <el-select v-model="goodsid" clearable placeholder="请选择">
            <el-option
              v-for="item in goodsids"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-col>
          <el-col :span="5" :offset="1" >
          <div class="yy-title">客户编号</div>
         <el-select v-model="clientid" clearable placeholder="请选择">
            <el-option
              v-for="item in clientids"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-col>
        <el-col :span="3" :offset="1"   style="margin-top: 35px;">
             <el-button type="primary" @click="countSalary">统计销售额</el-button>
        </el-col>
      </el-row>
    </el-card>
        <el-card style="margin:20px">
        <el-table :data="orderListData2" class="yy-table">
                   <el-table-column  prop="dispatchlistid" label="订单编号" > </el-table-column>
          <el-table-column  prop="starttime" label="订单开始时间" > </el-table-column>
            <el-table-column  prop="endtime" label="订单完成时间" > </el-table-column>
            <el-table-column
              sortable
              prop="goodsid"
              label="商品编号">
            </el-table-column>
 <el-table-column
              sortable
              prop="goodsname"
              label="商品名称">
            </el-table-column>

          <el-table-column
          sortable
          prop="realgoodsnum"
          label="销售数量">
        </el-table-column>


        <el-table-column
          prop="goodsoutprice"
          label="销售单价">
        </el-table-column>
          <el-table-column
          prop="allcost"
          label="销售总价">
        </el-table-column> 
        </el-table>
        </el-card>
</div>

</template>

<script>
export default {
data:function(){
    return{
     orderListData:[],
     createTime:[],
     clientids:[],
     goodsids:[],
     goodsid:"",
     clientid:"",
     allcost:0

    }
},
methods:{
  countSalary:function(){
 var allcost =0;
 console.log(this.goodsid);
 console.log(this.clientid);
 console.log(this.orderListData2)
    console.log(this.clientid);
     if(this.goodsid !=""&& this.clientid!=""){
     
        for(var i in this.orderListData2){
          if(this.orderListData2[i].goodsid == this.goodsid && this.orderListData2[i].clientid==this.clientid){
             allcost += this.orderListData2[i].allcost
          }
        }
     }else if(this.goodsid !=""){
     
        for(var i in this.orderListData2){
          if(this.orderListData2[i].goodsid == this.goodsid ){
             allcost += this.orderListData2[i].allcost
          }
        }
     }else if(this.clientid!=""){
        for(var i in this.orderListData2){
        if( this.orderListData2[i].clientid==this.clientid){
          allcost += this.orderListData2[i].allcost;
        }
        }
     }else{
          for(var i in this.orderListData2){
       
          allcost += this.orderListData2[i].allcost;
        }
     }
        this.$alert("总销售额为: "+allcost+"元", '总销售额', {
          confirmButtonText: '确定',
    });
  }
},
computed:{
  orderListData2:function(){
          if(this.createTime.length>0){
       var orderListData3=[];
          var createTime = this.createTime[0];
          var endTime = this.createTime[1];
          var allcost =0
          for(var i in this.orderListData){
            console.log(this.orderListData[i].endtime)
            if(this.orderListData[i].endtime>createTime && this.orderListData[i].endtime<endTime){
              orderListData3.push(this.orderListData[i]);
            
            }
          }
          return orderListData3;
        }
    //  var orderListData3=[];
    //  var allcost =0;   
    //      if(this.createTime.length!=0){
    //       var createTime = this.createTime[0];
    //       var endTime = this.createTime[1];
    //       for(var i in this.orderListData){
    //         if(this.orderListData[i].endtime>createTime && this.orderListData[i].endtime<endTime){
    //           orderListData3.push(this.orderListData[i]);
    //           allcost += this.orderListData[i].allcost
    //         }
    //       }
         
    //     }else{
    //       orderListData3 = this.orderListData;
    //     }
    //    console.log(orderListData3); 
    //    var orderListData4=[];  
    //     if(this.goodsid!=''){
    //       allcost = 0;
    //       for(var i in orderListData3){
    //          if(orderListData3[i].goodsid==this.goodsid){
    //              orderListData4.push(this.orderListData3[i]);
    //              allcost += this.orderListData3[i].allcost;
    //          }
    //       }
    //     }else{
    //        orderListData4 = orderListData3;
    //     }
    //      console.log(orderListData4); 
    //        var orderListData5=[];  
    //     if(this.clientid!=''){
    //       allcost = 0;
    //       for(var i in orderListData4){
    //         orderListData5.push(this.orderListData4[i]);
    //         allcost+=this.orderListData4[i].allcost;
    //          this.allcost = allcost;
    //         return orderListData5;
    //       }
    //     }else{
    //       orderListData5 = orderListData4; 
    //        this.allcost = allcost;
    //       return orderListData5
    //     }
       return this.orderListData;
  }
},
created:function(){
     var that =this;
      that.$axios.orderList().then(res=>{
          for(var i in res.data){
          res.data[i].endtime =  res.data[i].endtime.substr(0,10);
          res.data[i].starttime = res.data[i].starttime.substr(0,10);
          res.data[i]["allcost"] = res.data[i].realgoodsnum*res.data[i].goodsoutprice;
          var item={
            value:res.data[i].goodsid,
            label:res.data[i].goodsid
          }
          that.goodsids.push(item);
          var item2={
            value:res.data[i].clientid,
            label:res.data[i].clientid
          }
          for(var i in that.clientids){
             if(that.clientids[i].value==res.data[i].clientid){
               break;
             }
          }
          if(i!=that.clientids.length){
             that.clientids.push(item2)
          }
         
        }
          that.orderListData = res.data
      }).catch(err=>{
        console.log(err)
      })
      // //获取商品的信息
      // that.$axios.allGoodsList().then(res=>{

      // }).catch(err=>{
      //   console.log(err);
      // })
}
}
</script>

<style>
.yy-table{
    margin: 20px;
    width: 85%;
    margin-left: 40px;
    height: 460px;
}
.yy-input {
    height: 40px;
    line-height: 40px;
    margin-top: 10px;
    font-size: 1rem;
    border-radius: 8px;
    background: rgba(246, 246, 246, 1);
    outline: none;
    border: 0px;
    width: 520px;
    padding-left: 20px;
    margin-left: 0px;
}

.el-icon-search {
    color: rgb(52, 145, 240);
    font-size: 1.4rem;
    /* right: 20px; */
    position: absolute;
    right: 20px;
    top: 18px;
}
.yy-title {
    color: rgba(26, 26, 26, 1);
    text-align: left;
    font-size: 1.2rem;
    margin-bottom: 15px;
}
</style>