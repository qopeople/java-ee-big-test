<template>
  <div>
      <!-- 筛选条件 -->
      <el-card style="margin:20px">
            <el-row style=" margin-top: 13px;">
                    <el-col :span="10" >
                    <div style="position:relative">
                        <input
                        v-model="search"
                        type="text"
                        placeholder="输入关键词搜索"
                        class="yy-input"/>   
                        <i class="el-icon-search" ></i>
                    </div>
            
                    </el-col>
                    <el-col :span="3" :offset="11" style="margin-top: 7px;">
                    <el-button type="primary" @click="addContract">新增合同</el-button> 
                    </el-col>
                </el-row>
      </el-card>
       <el-card style="margin:20px">
      <el-table :data="contractTableData"   style="height:400px"  stripe >
           <el-table-column label="合同编号" prop="contractid" width="80px"></el-table-column>
           <el-table-column label="合同名称" prop="contractname"></el-table-column>
         
           <el-table-column label="客户名称" prop="clientname"></el-table-column>
           <el-table-column label="销售员编号" prop="salerid"></el-table-column>
        
           <el-table-column label="合同创建时间"  sortable prop="contractcreatetime"></el-table-column>
           <el-table-column label="合同开始时间"  sortable prop="contractstarttime"></el-table-column>
           <el-table-column label="合同结束时间"  sortable prop="contractendtime"></el-table-column>
            <el-table-column label="合同状态" prop="constractstatus"></el-table-column>  
            <el-table-column
            label="操作">
            <template slot-scope="scope" >
                <!-- @click="userReceive(scope.$index)" -->
                <el-button v-if="scope.row.constractstatus=='等待开始'"  type="primary" size="mini" v-model="scope.$index" @click="editing(scope.$index)">修改</el-button>
                <el-button v-else type="primary" size="mini"  v-model="scope.$index" @click="contractDetail(scope.$index)">详情</el-button>
    <el-button  type="danger" size="mini" v-model="scope.$index" @click="deleteItem( scope.$index,scope.row)" >删除</el-button>
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
        contractTableData2:[],
        search:''
    }
},
computed:{ 
      contractTableData:function(){
               const search = this.search;
                  if (search) {
                return this.contractTableData2.filter(dataNews => {
                    return Object.keys(dataNews).some(key => {
                        return String(dataNews[key]).toLowerCase().indexOf(search) > -1
                    })
                })
            }
            return this.contractTableData2
      }

},
methods:{
    deleteItem:function(index,row){
      var that = this;
       that.contractTableData2.splice(index,1);
           that.$axios.contractDelete(row.contractid).then(res=>{
       that.$message({
          message: '删除成功',
          type: 'success'
        });
    }).catch(err=>{
      console.log(err)
    })
 
    },
    contractDetail:function(index){
       this.$router.push({path:'/ContractDetailTwo',query:{contractInform:this.contractTableData[index]}})
    },
    addContract:function(){
         this.$router.push({path:'/AddContractInform',query:{contractid:this.contractTableData.length+1}})
    },
editing:function(index){
    this.$router.push({path:'/EditingContractInform',query:{contractInform:this.contractTableData[index]}})
},
formDateString:function(dateString){
    return dateString.substr(0,10);
}
},
created:function(){
    var that =this;
     that.$axios.allContractList().then(res=>{
      for(var i in res.data){
          if(res.data[i].contractcreatetime){
              res.data[i].contractcreatetime = that.formDateString(res.data[i].contractcreatetime);
          }
          if(res.data[i].contractstarttime){
              res.data[i].contractstarttime = that.formDateString(res.data[i].contractstarttime);
          }
          if(res.data[i].contractendtime){
              res.data[i].contractendtime = that.formDateString(res.data[i].contractendtime);
          } 
       }
       that.contractTableData2 = res.data
     }).catch(err=>{
         console.log(err);
     })
}
}
</script>


<style scoped src="../../assets/css/ContractList.css"></style>