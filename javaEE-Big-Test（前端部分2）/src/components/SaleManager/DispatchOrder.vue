<template>
  <div>
    <el-card style="margin:20px">
      <el-table :data="disPatchListData" class="yy-table">
        <el-table-column label="合同编号" prop="contractid"></el-table-column>
        <el-table-column label="合同子项编号" prop="contractitemid"></el-table-column>
         <el-table-column label="销售编号" prop="clientid"></el-table-column>
        <el-table-column label="商品名称" prop="goodsname"></el-table-column>
        <el-table-column label="预订商品数量" prop="goodsnum">
        </el-table-column>
            <el-table-column label="现需商品数量" prop="realgoodsnum"  width="180px">
                <template slot-scope="scope"> 
                    <el-input-number size="mini"  v-model="scope.row.realgoodsnum"></el-input-number>
            </template>
           </el-table-column> 
        <el-table-column label="商品销售价格" prop="goodsoutprice"></el-table-column>
        <el-table-column label="商品库存量" prop="goodsstorenum" ></el-table-column>
         <!-- <el-table-column label="状态"  prop="itemstatus"></el-table-column> -->
         <el-table-column label="操作" >
            <template slot-scope="scope" >
              <template v-if="scope.row.realgoodsnum<scope.row.goodsstorenum">
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
       if(row.goodsname>row.realgoodsnum){
          that.$message({
          message: '选择发货商品数量不可大于合同数量',
          type: 'warn'
        });
        return;
       }  
     
      that.$axios.addDispatchOrder(parma).then(res=>{
        that.disPatchListData.splice(index,1);
           that.$message({
          message: '生成发货单成功',
          type: 'success'
        });
      }).catch(err=>{
       console.log(err)
      })
       that.disPatchListData.splice(index,1);
      //  that.getData();
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
        // that.getData();
    },
    getData:function(){
        var that = this;  
        this.disPatchListData=[];
            that.$axios.allGoodsList().then(res=>{
            that.goodsList = res.data
              
        that.$axios.allContractItem().then(res=>{
        
            for(var i in res.data){
            var item =[];
              if(res.data[i].itemstatus=="等待开始" || res.data[i].needgoodsnum > 0){
                  item =res.data[i];
                      for(var i in that.goodsList){
                        if(that.goodsList[i].goodsid==item.goodsid){
                            item["goodsname"] =that.goodsList[i].goodsname;
                            item["goodsoutprice"] =that.goodsList[i].goodsoutprice;
                            item["goodsstorenum"] =that.goodsList[i].goodsstorenum;   
                            item['realgoodsnum'] = item.needgoodsnum;
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
  },
  computed:{
 
  },
  created:function(){
   this.getData();
  }



}
</script>

<style>
.yy-table{
  margin: 20px;
  width: 100%;
}

</style>