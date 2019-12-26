<template>
  <div>
    <el-card style="margin:20px">
        <div slot="header" class="clearfix">
          <span>合同基本信息</span>
            <el-button type="primary" @click="onSubmit" style="float:right" size="small"  >立即添加</el-button>
        </div>
    <el-form :model="contractInform" label-width="100px" ref="contractInform" style="margin-top:30px">
      <el-row>
        <el-col :span="7" :offset="1">
          <el-form-item label="合同名称">
                  <el-input v-model="contractInform.contractname" placeholder="请输入内容" ></el-input>
            </el-form-item>
        </el-col>
       <el-col :span="7" :offset="1">
           <el-form-item label="客户编号">
              <el-select v-model="contractInform.clientid" clearable placeholder="请选择"   @change="selectClientId">
              <el-option
              v-for="item in clientList"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
              </el-option>
          </el-select>   
             </el-form-item>    
        </el-col>        
      </el-row>
    
      <el-row>
        <el-col :span="7" :offset="1">
             <el-form-item label="客户名称">
              <el-input v-model="contractInform.clientname" disabled placeholder="请输入内容"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="7" :offset="1">
          <el-form-item label="销售人员编号">
             <el-select v-model="contractInform.salerid" clearable placeholder="请选择"   >
              <el-option
              v-for="item in salerList"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
               </el-option>
          </el-select>   
          </el-form-item>          
        </el-col>
      </el-row>
     
      <el-row>
        <el-col :span="5" :offset="1">
          <el-form-item label="创建时间">
              <el-date-picker
                          v-model="contractInform.contractcreatetime"
                          align="right"
                          type="date"
                          placeholder="选择日期"
                           value-format="yyyy-MM-dd"
                          :picker-options="pickerOptions">
                          </el-date-picker>
            </el-form-item>          
        </el-col>
        <el-col :span="5" :offset="3">
            <el-form-item label="开始时间">
                      <el-date-picker
                          v-model="contractInform.contractstarttime"
                          align="right"
                          type="date"
                          placeholder="选择日期"
                           value-format="yyyy-MM-dd"
                          :picker-options="pickerOptions">
                          </el-date-picker>        
            </el-form-item>          
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="5" :offset="1">
          <el-form-item label="结束时间">
                  <el-date-picker
                    v-model="contractInform.contractendtime"
                    align="right"
                    type="date"
                    disabled
                    placeholder="选择日期"
                     value-format="yyyy-MM-dd"
                    :picker-options="pickerOptions">
                    </el-date-picker>        
          </el-form-item>
        </el-col>
        <el-col :span="5" :offset="3">
          
       <el-form-item label="合同状态">
           <el-input v-model="contractInform.constractstatus" disabled placeholder="请输入内容" ></el-input> 
       </el-form-item>
        </el-col>
      </el-row>

    


       <el-form-item label="备注" style="width:500px;margin-left:50px" >
           <el-input
                 style="width:400px"
                type="textarea"
                :autosize="{ minRows: 4, maxRows: 6}"
                placeholder="请输入内容"
                v-model="contractInform.contractremark">
                </el-input>
         </el-form-item>       
    </el-form>
    </el-card> 
    <!-- 合同子项 -->
  <el-card style="margin:20px">
  <div slot="header" class="clearfix">
          <span>合同子项</span>
            <el-button style="float:right" size="small" type="primary" @click="addItem" >新增合同项</el-button>
        </div>
          <el-table :data="contractItems" class="yy-table">
            <el-table-column label="合同子项" prop="contractitemid">
             <!-- <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.contractitemid" ></el-input> 
                </template>
                    <span v-else >{{scope.row.contractitemid}}  </span>
            </template> -->
            </el-table-column>
            <el-table-column label="商品编号" prop="goodsid">
              <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <div popper-class="yy-select">
                   <el-select v-model="scope.row.goodsid" clearable placeholder="请选择"  >
                    <el-option
                    v-for="item in goodsList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                  >
                  </el-option>
              </el-select>   
                </div>
                </template>
                    <span v-else >{{scope.row.goodsid}}  </span>
            </template>
            </el-table-column>
            <el-table-column label="商品名称" prop="goodsname">
              <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.goodsname" disabled ></el-input> 
                </template>
                    <span v-else >{{scope.row.goodsname}}  </span>
            </template>
            </el-table-column>
            <el-table-column label="预订商品数量" prop="goodsnum">

                <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                    <el-input-number size="mini" v-model="scope.row.goodsnum"></el-input-number>
                
                </template>
                    <span v-else >{{scope.row.goodsnum}}  </span>
            </template>
            </el-table-column>
               <el-table-column label="待发货数量" prop="needgoodsnum">
            </el-table-column>
            <el-table-column label="商品单价"  prop="goodsoutprice">
              
                <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" disabled v-model="scope.row.goodsoutprice" ></el-input> 
                </template>
                    <span v-else >{{scope.row.goodsoutprice}}  </span>
              </template>
            </el-table-column>
            <el-table-column label="子项状态" prop="itemstatus">
               <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.itemstatus" ></el-input> 
                </template>
                    <span v-else >{{scope.row.itemstatus}}  </span>
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
  </div>
</template>

<script>
export default {
  data:function(){
    return{
      search:"",
      contractInform:{constractstatus:"等待开始"},
      constractstatuss:[{
          value:"等待开始",
          lable:"等待开始"
      },{
          value:"进行中",
          lable:"进行中"
      },{
          value:"履行完成",
          lable:"履行完成"
      }],
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
    },
    goodsList:[],
    clientList:[],
    salerList:[],   
    contractItems:[],
    
  }
},
created:function(){
  console.log(this.$route.query.contractid)
  this.contractInform["contractid"] = this.$route.query.contractid;
  var that =this;
  //获取销售人员的信息
  that.$axios.allSalePersonList().then(res=>{
    for(var i in res.data){
      var item = {
        value:"",
        label:"",
        name:""
      };
      item.value = res.data[i].salerid;
      item.label = res.data[i].salerid;
      item.name  = res.data[i].salername;  
      that.salerList.push(item);
      }
  }).catch(err=>{
    console.log(err);
  })
  //获取客户人员的信息
  that.$axios.allClientList().then(res=>{
  for(var i in res.data){
      var item = {
        value:"",
        label:"",
        name:""}
      item.value = res.data[i].clientid;
      item.label = res.data[i].clientid;
      item.name  = res.data[i].clientname;  
      that.clientList.push(item);
    }
  }).catch(err=>{
       console.log(err);
  })
  //获取商品id号
  that.$axios.allGoodsList().then(res=>{
  for(var i in res.data){
      var item = {
        value:"",
        label:"",
        name:"",
        goodsoutprice:''
      };
      item.value = res.data[i].goodsid;
      item.label = res.data[i].goodsid;
      item.name  = res.data[i].goodsname;  
      item.goodsoutprice = res.data[i].goodsoutprice;
      that.goodsList.push(item);
    }
  }).catch(err=>{
       console.log(err);
  })
},
methods:{
  selectClientId:function(e){
    for(var i in this.clientList){
      if(this.clientList[i].value == e){
      
         this.contractInform.clientname = this.clientList[i].name
      }
    }
  },
  confirmAdd:function(index,row){
    var that =this;
    if(that.contractInform.contractid){
    that.contractItems[index].editing  = false;
    delete row.editing 
    row["contractid"]  =that.contractInform.contractid;
    row["salerid"] = that.contractInform.salerid;
    row["clientid"] =that.contractInform.clientid;
    row["needgoodsnum"]  = that.contractItems[index].goodsnum; 
   for(var i in that.goodsList){
     if(that.goodsList[i].value == row.goodsid){
       row['goodsname'] = that.goodsList[i].name;
       row['goodsoutprice'] = that.goodsList[i].goodsoutprice;
     }
   }
    that.$axios.addContractItem(row).then(res=>{
        that.contractItems[index]["editing"]  = true;
      console.log(res)
    }).catch(err=>{
      console.log(err)
    })
    }else{
             that.$message({
          showClose: true,
          message: '请先填写合同编号！',
          type: 'warning'
        });
    }


  },
  confirmDelete:function(index,row){
    var that =this;
    that.contractItems.splice(index,1);
     if(that.contractInform.contractid &&row.contractitemid){
   var parma = {
       contractid:that.contractInform.contractid,
       contractitemid:row.contractitemid
     }
     that.$axios.deleteContractItem(parma).then(res=>{

     }).catch(err=>{
       console.log(err)
     })
     }
  
  },
  confirmUpdate:function(index,row){
        var that =this;
        //  that.contractItems[index] = row;
           console.log(this.contractItems[index])
              console.log(row)
         that.contractItems[index]["editing"]  = false;
           delete row.editing 
         that.$axios.updateContractItem(row).then(res=>{
            console.log(res);
              that.contractItems[index]["editing"]  = false;
          }).catch(err=>{
            console.log(err)
          })
  },
  update:function(index,row){
    console.log(this.contractItems[index])
     this.contractItems[index]["editing"]  = true;
  },
    addItem:function(){
      var item ={
      contractitemid: this.contractItems.length+1,
        goodsid:"",
        goodsname:"",
        goodsnum:"",
        goodsoutprice:"",
        needgoodsnum:"",
        itemstatus:"等待开始",
        editing:true
      }
    this.contractItems.push(item);
    },
    onSubmit:function(){
      console.log(this.contractInform);
      var that =this;
      that.$axios.addContractList(that.contractInform).then(res=>{
         that.$message({
          message: '添加成功！',
          type: 'success'
        });
       that.$router.back(-1); 
      }).catch(err=>{
        console.log(err);
      })
    }
}
}
</script>

<style>
.yy-table{
    width: 92%;
   margin: 0 auto;
}
.yy-form{
    margin-top:30px ;
}
 /* .el-select  .el-input__inner {
    cursor: pointer;
    padding-right: 35px;
    height: 28px;
} */
</style>