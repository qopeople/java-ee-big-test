<template>
  <div>
    <el-form :model="contractInform" label-width="100px" ref="contractInform" style="margin-top:30px">
      <el-row>
        <el-col :span="7" :offset="1">
          <el-form-item label="合同名称">
                  <el-input v-model="contractInform.contractname" placeholder="请输入内容" ></el-input>
            </el-form-item>
        </el-col>
       <el-col :span="7" :offset="1">
           <el-form-item label="客户编号">
             <el-input v-model="contractInform.clientid" clearable placeholder="请输入内容"></el-input>
             </el-form-item>    
        </el-col>        
      </el-row>
    
      <el-row>
        <el-col :span="7" :offset="1">
             <el-form-item label="客户名称">
              <el-input v-model="contractInform.clientname" placeholder="请输入内容"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="7" :offset="1">
          <el-form-item label="销售人员编号">
              <el-input v-model="contractInform.salerid" placeholder="请输入内容"></el-input>
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
                              value-format="yyyy-MM-dd"
                          placeholder="选择日期"
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
                    placeholder="选择日期"
                        value-format="yyyy-MM-dd"
                    :picker-options="pickerOptions">
                    </el-date-picker>        
          </el-form-item>
        </el-col>
        <el-col :span="5" :offset="3">
          
       <el-form-item label="合同状态">
          <el-select v-model="contractInform.constractstatus" clearable placeholder="请选择">
              <el-option
              v-for="item in contractstatuss"
              :key="item.value"
              :label="item.label"
              :value="item.value">
              </el-option>
          </el-select>         
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
                  <el-input size="mini" v-model="scope.row.goodsid" ></el-input> 
                </template>
                    <span v-else >{{scope.row.goodsid}}  </span>
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
            <el-table-column label="商品数量" prop="goodsnum">

                <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.goodsnum" ></el-input> 
                </template>
                    <span v-else >{{scope.row.goodsnum}}  </span>
            </template>
            </el-table-column>
            <el-table-column label="商品单价" prop="goodsoutprice">
              
                <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.goodsoutprice" ></el-input> 
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
            
        </el-table>
     
  </div>
</template>

<script>
export default {
  data:function(){
    return{
        contractItems:[],
      contractInform:{},
      contractstatuss:[{
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
    }
  }
},
created:function(){
   console.log(this.$route.query.contractInform);
   this.contractInform = this.$route.query.contractInform;
   var that = this;
   console.log(that.contractInform.contractid)
   that.$axios.allContractItemById(that.contractInform.contractid).then(res=>{
     that.contractItems = res.data;
   }).catch(err=>{
     console.log(err);
   })
},
methods:{
  
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
.yy-btn{
    width:200px;
    margin-left: 60px;
    margin-top: 40px;
}
</style>