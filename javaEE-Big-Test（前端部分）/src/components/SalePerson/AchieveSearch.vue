<template>
  <div>
    <el-card style="margin:20px">
     <el-row style="margin-top:20px">
        <el-col :span="5" :offset="1">
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
      

          <el-col :span="3" :offset="7">
            <el-button type="primary" icon="el-icon-search" @click="searchWay2" style="width: 140px;margin-top: 35px;" >统计销售额</el-button>
            </el-col>                
      </el-row>
    </el-card>
     
    <el-card  style="margin:20px">
          <el-table
        :data="orderListData2"
        stripe
      style="height:370px" >
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
          prop="goodsnum"
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
            createTime:"",
            orderListData3:[],
            allcost:0,
        }
    },
    computed:{
      orderListData2:function(){
        if(this.createTime){
       var orderListData3=[];
          var createTime = this.createTime[0];
          var endTime = this.createTime[1];
          var allcost =0
          for(var i in this.orderListData){
            console.log(this.orderListData[i].endtime)
            if(this.orderListData[i].endtime>createTime && this.orderListData[i].endtime<endTime){
              orderListData3.push(this.orderListData[i]);
              allcost += this.orderListData[i].allcost
            }
          }
          this.allcost = allcost;
          return orderListData3;
        }
       

       return this.orderListData

      }
    },
    created:function(){
      var that =this;
         var salerid =that.$cookies.get("id")
      that.$axios.orderBySalerId(salerid).then(res=>{
          for(var i in res.data){
          res.data[i].endtime =  res.data[i].endtime.substr(0,10);
          res.data[i].starttime = res.data[i].starttime.substr(0,10);
          res.data[i]["allcost"] = res.data[i].goodsnum*res.data[i].goodsoutprice;
        }
          that.orderListData = res.data
      }).catch(err=>{
        console.log(err)
      })
    },
    methods:{
      searchWay2:function(){
            if(this.createTime){
         
            this.$alert("总销售额为: "+this.allcost+"元", '总销售额', {
             confirmButtonText: '确定',
        });
      
        }
      }
    }
}
</script>

<style scoped src="../../assets/css/AchieveSearch.css"></style>
