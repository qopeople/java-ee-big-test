<template>
  <div>
      <el-table :data="disPatchList"  style="margin:30px auto;  width: 95%;height:550px">
        <el-table-column label="发货编号" prop="dispatchlistid"></el-table-column>
        <el-table-column label="合同编号" prop="contractid"></el-table-column>
        <el-table-column label="合同子项编号" prop="contractitemid"></el-table-column>
        <el-table-column label="商品名称" prop="goodsname"></el-table-column>
        <el-table-column label="发货数量" prop="realgoodsnum">
        </el-table-column>
        <el-table-column label="商品销售价格" prop="goodsoutprice"></el-table-column>
        <el-table-column label="商品库存量" prop="goodsstorenum" ></el-table-column>
         <!-- <el-table-column label="状态"  prop="itemstatus"></el-table-column> -->
         <el-table-column label="操作" >
            <template slot-scope="scope" >
                 <el-button  type="success" plain size="mini" v-model="scope.$index" @click="finish(scope.$index,scope.row)"> 确认发货</el-button>
               </template>
         </el-table-column>
      </el-table>
  </div>
</template>

<script>
export default {
data:function(){
  return{
    disPatchList:[]
  }
},
created:function(){
 this.getData()
},
 
    methods:{
      getData:function(){
        var that =this;
        that.$axios.allDispatchOrder().then(res=>{
          for(var i in res.data){
            if(res.data[i].itemstatus=="等待发货" && res.data[i].endtime==null){
              that.disPatchList.push(res.data[i])
            }
          }
        }).catch(err=>{
            console.log(err); 
          })
      },
    finish:function(index,row){
       var that =this;
       
       var parma1 = {
         clientid:that.disPatchList[index].clientid,
         goodsid:that.disPatchList[index].goodsid,
         goodsname:that.disPatchList[index].goodsname,
         goodsoutprice:that.disPatchList[index].goodsoutprice,
         itemstatus:"进行中",
         contractid:that.disPatchList[index].contractid,
         contractitemid:that.disPatchList[index].contractitemid,
         goodsnum:that.disPatchList[index].goodsnum,
         needgoodsnum:that.disPatchList[index].goodsnum - that.disPatchList[index].realgoodsnum
       }
       console.log(parma1)
       //更新合同项状态
       that.$axios.updateContractItem(parma1).then(res=>{
             
       }).catch(err=>{
         console.log(err);
       })
       var parma4 ={
           contractid:that.disPatchList[index].contractid,
           contractitemid:that.disPatchList[index].contractitemid,
           constractstatus:"进行中"
       }
        that.$axios.contractStatusTwo(parma4).then(res4=>{
          }).catch(err=>{
            console.log(err);
          })
       var parma2={
           goodsid:that.disPatchList[index].goodsid,
         goodsname:that.disPatchList[index].goodsname,
         goodsoutprice:that.disPatchList[index].goodsoutprice,
         goodsinprice:that.disPatchList[index].goodsinprice,
         goodsstorenum:that.disPatchList[index].goodsstorenum-that.disPatchList[index].realgoodsnum
        }
        //更新仓库存储的商品数量
       that.$axios.updateGoods(parma2).then(res=>{
             
       }).catch(err=>{
         console.log(err);
       })
       var nowDate= new Date();
       //开始存储物流信息
       var parma3={
         dispatchlistid:that.disPatchList[index].dispatchlistid,
         currentpostion:"开始受理",
         steptime:nowDate.getFullYear()+"-"+(nowDate.getMonth()+1)+"-"+nowDate.getDate()
       }
       that.$axios.addLogistic(parma3).then(res=>{

       }).catch(err=>{
         console.log(err);
       })
      that.disPatchList.splice(index,1);
        that.$message({
          message: '发货成功',
          type: 'success'
        });
         that.getData()
    }
  }
}
</script>

<style>
.yy-table{
  margin: 20px;
  width: 95%;
  height:550px;
}

</style>