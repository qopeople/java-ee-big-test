<template>
  <div>
    <el-card style="margin:20px">
      <el-table :data="disPatchListData" class="yy-table">
        <el-table-column label="合同编号" prop="contractid"></el-table-column>
        <el-table-column label="合同子项编号" prop="contractitemid"></el-table-column>
         <el-table-column label="销售编号" prop="clientid"></el-table-column>
        <el-table-column label="商品名称" prop="goodsname"></el-table-column>
        <el-table-column label="商品数量" prop="goodsnum" width="180px">
                       
                <template slot-scope="scope"> 
                    <el-input-number size="mini" v-model="scope.row.goodsnum"></el-input-number>
            </template>
        </el-table-column>
        <el-table-column label="商品销售价格" prop="goodsoutprice"></el-table-column>
        <el-table-column label="商品库存量" prop="goodsstorenum" ></el-table-column>
         <el-table-column label="状态"  prop="itemstatus"></el-table-column>
         <el-table-column label="操作" >
            <template slot-scope="scope" >
              <template v-if="scope.row.goodsnum<scope.row.goodsstorenum">
                 <el-button   type="success" plain size="mini" v-model="scope.$index" @click="setDispatchOrder(scope.$index,scope.row)"> 生成发货单</el-button>
              </template>
                 <el-button v-else type="warning" plain  size="mini" v-model="scope.$index" @click="setPurchase(scope.$index,scope.row)"> 生成进货单</el-button>
               </template>
         </el-table-column>
      </el-table>
    </el-card>

  </div>
</template>

<script>
export default {
  data:function(){
    return{
      disPatchListData:[],
      goodsList:[]
    }
  },
  methods:{
    setDispatchOrder:function(index,row){
       var  parma = this.disPatchListData[index];
       var nowDate= new Date();
       var that =this;
       parma.itemstatus="等待发货";
       parma.constractstatus="进行中";
      //  parma.goodsstorenum = parma.goodsstorenum- parma.goodsnum;
       parma["starttime"] = nowDate.getFullYear()+"-"+(nowDate.getMonth()+1)+"-"+nowDate.getDate();
       console.log(parma)
      that.$axios.addDispatchOrder(parma).then(res=>{
        that.disPatchListData.splice(index,1);
           that.$message({
          message: '生成发货单成功',
          type: 'success'
        });
      }).catch(err=>{
       console.log(err)
      })
   },
    setPurchase:function(index,row){
        var  parma = this.disPatchListData[index];
       var nowDate= new Date();
       var that =this;
       parma.itemstatus="等待进货";
      //  parma.goodsstorenum = parma.goodsstorenum + parma.goodsnum+20;
        parma["intime"] = nowDate.getFullYear()+"-"+(nowDate.getMonth()+1)+"-"+nowDate.getDate();
          that.$axios.addPurchase(parma).then(res=>{
        that.disPatchListData.splice(index,1);
           that.$message({
          message: '生成进货单成功',
          type: 'success'
        });
      }).catch(err=>{
       console.log(err)
      })
    }
  },
  computed:{
   disPatchListData2:function(){
     var that =this;
   }
  },
  created:function(){
    
   var that = this;  
      that.$axios.allGoodsList().then(res=>{
      that.goodsList = res.data
        
   that.$axios.allContractItem().then(res=>{
    console.log(that.goodsList)
       for(var i in res.data){
       var item =[];
         if(res.data[i].itemstatus=="等待开始"){
            item =res.data[i];
                for(var i in that.goodsList){
                  if(that.goodsList[i].goodsid==item.goodsid){
                      item["goodsname"] =that.goodsList[i].goodsname;
                      item["goodsoutprice"] =that.goodsList[i].goodsoutprice;
                      item["goodsstorenum"] =that.goodsList[i].goodsstorenum;   
                   break;
                  }
                }
                that.disPatchListData.push(item)
                     
           
         }
       }
   }).catch(err=>{
     console.log(err);
   })
     
   }).catch(err=>{
      
   })

   
  }



}
</script>

<style>
.yy-table{
  margin: 20px;
  width: 97%;
}

</style>