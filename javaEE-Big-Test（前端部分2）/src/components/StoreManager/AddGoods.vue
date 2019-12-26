<template>
  <el-card style="margin:20px">
  <div slot="header" class="clearfix">
          <span>商品列表</span>
            <el-button style="float:right" size="small" type="primary" @click="addItem" >新增商品</el-button>
        </div>
          <el-table :data="goodsList" class="yy-table" height="500">
            
            <el-table-column label="商品编号" prop="goodsid">
              <template slot-scope="scope"> 
                    <span  >{{scope.row.goodsid}}  </span>
            </template>
            </el-table-column>
            <el-table-column label="商品名称" prop="goodsname">
              <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.goodsname" ></el-input> 
                </template>
                    <span v-else >{{scope.row.goodsname}}  </span>
            </template>
            </el-table-column>
            <el-table-column label="商品存货量" prop="goodsstorenum">

                <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                    <el-input-number size="mini" v-model="scope.row.goodsstorenum"></el-input-number>
                
                </template>
                    <span v-else >{{scope.row.goodsstorenum}}  </span>
            </template>
            </el-table-column>
            <el-table-column label="商品销售价"  prop="goodsoutprice">
              
                <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini"  v-model="scope.row.goodsoutprice" ></el-input> 
                </template>
                    <span v-else >{{scope.row.goodsoutprice}}  </span>
              </template>
            </el-table-column>
            <el-table-column label="商品进货价" prop="goodsinprice">
               <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.goodsinprice" ></el-input> 
                </template>
                    <span v-else >{{scope.row.goodsinprice}}  </span>
              </template>
              </el-table-column>    
             <el-table-column label="操作" prop="editing">
              <template slot-scope="scope"> 
                  <template v-if="scope.row.editing">
                    <el-button type="primary" size="mini" @click="confirmAdd(scope.$index,scope.row)">完成</el-button> 
                  </template>
                    <span v-else > 
                     <el-button type="primary" size="mini" @click="confirmDelete(scope.$index,scope.row)">移除</el-button>   </span>
              </template>
               </el-table-column>    
        </el-table>
      
  </el-card>   
</template>

<script>
export default {
  data:function(){
    return{
        goodsList:[]
    }
  },
created:function(){
  this.getItem()
},
  methods:{
      getItem:function(){
        var that =this;
            that.$axios.allGoodsList().then(res=>{
                that.goodsList =res.data
            }).catch(err=>{
                console.log(err);
            })
      },
       addItem:function(){
      var item ={
        goodsid:this.goodsList.length+1,
        goodsname:"",
        goodsnum:"",
        goodsoutprice:"",
        goodsstorenum:"",
        goodsinprice:'',
        editing:true
      }
    this.goodsList.push(item);
    },    
        confirmAdd:function(index,row){
    var that =this;
    that.goodsList[index].editing  = false;
    delete row.editing 
    row.goodsinprice = parseFloat(row.goodsinprice);
    row.goodsoutprice = parseFloat(row.goodsoutprice);
    
    that.$axios.goodsAdd(row).then(res=>{
         that.$message({
          message: '添加成功',
          type: 'success'
        });
      console.log(res)
    }).catch(err=>{
      console.log(err)
    })
  that.getItem();

  },  
  confirmDelete:function(index,row){
    var that =this;
    that.goodsList.splice(index,1);
     that.$axios.goodsDelete(row.goodsid).then(res=>{
         this.$message({
                message: '删除成功',
                type: 'success'
              });
     }).catch(err=>{
       console.log(err)
     })
      that.getItem();
  
  },
  }
} 
</script>