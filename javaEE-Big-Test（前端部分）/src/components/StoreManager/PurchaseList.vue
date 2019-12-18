<template>
  <div>
      <el-table :data="purchaseList" class="yy-table" style="margin:30px auto;  width: 95%;height:550px">
        <el-table-column label="进货编号" prop="purchaseid"></el-table-column>
        <!-- <el-table-column label="进货时间" prop="intime"></el-table-column> -->
         <el-table-column label="合同编号" prop="contractid"></el-table-column>
        <el-table-column label="合同子项编号" prop="contractitemid"></el-table-column>
        
        <el-table-column label="进货商品名称" prop="goodsname"></el-table-column>
        <el-table-column label="进货商品数量" prop="goodsnum">
              
                <template slot-scope="scope"> 
                    <el-input-number size="mini" v-model="scope.row.goodsnum"></el-input-number>
            </template>
        </el-table-column>
        <el-table-column label="进货价格" prop="goodsinprice"></el-table-column>
       
        <el-table-column label="现商品库存量" prop="goodsstorenum" ></el-table-column>
         <el-table-column label="状态"  prop="itemstatus"></el-table-column>
         <el-table-column label="操作" >
            <template slot-scope="scope" >
                 <el-button  type="success" plain size="mini" v-model="scope.$index" @click="finish(scope.$index,scope.row)"> 进货完成</el-button>
               </template>
         </el-table-column>
      </el-table>
  </div>
</template>

<script>
export default {
  data:function(){
    return{
      purchaseList:[],
      goodsList:[],

    }
  },
  created:function(){
      
   var that = this;  
      that.$axios.allGoodsList().then(res=>{
      that.goodsList = res.data
        
   that.$axios.allPurchase().then(res=>{
     for(var i in res.data){
       if(res.data[i].itemstatus=="等待进货"){
      //  res.data[i].intime=res.data[i].intime.substr(0,10);
           that.purchaseList.push(res.data[i]); 
       }
        
     }
  
  

      
   }).catch(err=>{
     console.log(err);
   })
     
   }).catch(err=>{
      
   })
  },
  methods:{
    finish:function(index,row){
       var that =this;
       
       var parma1 = {
         clientid:that.purchaseList[index].clientid,
         goodsid:that.purchaseList[index].goodsid,
         goodsname:that.purchaseList[index].goodsname,
         goodsoutprice:that.purchaseList[index].goodsoutprice,
         itemstatus:"等待开始",
         contractid:that.purchaseList[index].contractid,
         contractitemid:that.purchaseList[index].contractitemid,
         goodsnum:that.purchaseList[index].goodsnum
       }
       console.log(parma1)
       that.$axios.updateContractItem(parma1).then(res=>{
             
       }).catch(err=>{
         console.log(err);
       })
       var parma2={
           goodsid:that.purchaseList[index].goodsid,
         goodsname:that.purchaseList[index].goodsname,
         goodsoutprice:that.purchaseList[index].goodsoutprice,
         goodsinprice:that.purchaseList[index].goodsinprice,
         goodsstorenum:that.purchaseList[index].goodsstorenum+that.purchaseList[index].goodsnum
        }
            console.log(parma2)
       that.$axios.updateGoods(parma2).then(res=>{
             
       }).catch(err=>{
         console.log(err);
       })
         that.$message({
          message: '进货成功',
          type: 'success'
        });
      that.purchaseList.splice(index,1);
    }
  }

}
</script>

<style>
.yy-table{
  margin: 20px;
  width: 90%;
}

</style>