<template>
  <div>
      <el-table
          :data="orderData"
          style="margin:30px auto;  width: 95%;height:550px">
          <el-table-column prop="dispatchlistid" label="订货单号"> </el-table-column>
          <el-table-column label="合同编号" prop="contractid"></el-table-column>
        <el-table-column label="合同子项编号" prop="contractitemid"></el-table-column>
        <el-table-column label="商品名称" prop="goodsname"></el-table-column>
        <el-table-column label="发货数量" prop="realgoodsnum"></el-table-column>
        <el-table-column label="商品销售价格" prop="goodsoutprice"></el-table-column>
        <!-- <el-table-column label="状态"  prop="itemstatus"></el-table-column> -->
         <el-table-column label="操作" >
            <template slot-scope="scope" >
                 <el-button  type="success" plain size="mini" v-model="scope.$index" @click="addLogiditc(scope.$index,scope.row)"> 添加物流信息</el-button>
               </template>
         </el-table-column>
      </el-table>
  </div>
</template>

<script>
export default {
data:function(){
    return{
       orderData:[]
    }
},
created:function(){
     var that =this;
 that.$axios.allDispatchOrder().then(res=>{
  for(var i in res.data){
    if(res.data[i].endtime==null){
       that.orderData.push(res.data[i])
    }
  }
 }).catch(err=>{
     console.log(err); 
   })
},
methods:{
    addLogiditc:function(index,row){
        this.$router.push({path:"/AddLogiditic",query:{dispatchlistid:this.orderData[index].dispatchlistid}});
    }
}
}
</script>

<style>

</style>