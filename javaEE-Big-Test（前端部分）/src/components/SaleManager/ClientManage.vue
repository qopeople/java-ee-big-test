<template>
  <div>
    <el-card style="margin:20px">     
         <!-- 筛选条件 -->
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
        <el-col :span="3" :offset="9" style="margin-top: 7px;">
             <el-button type="primary"  @click="addUser">新增用户</el-button>
        </el-col>
      </el-row>
    </el-card>
     <el-card style="margin:20px">    
      <el-table :data="clientTableData2" class="yy-table">
        <el-table-column label="客户编号" prop="clientid">
      
        </el-table-column>
        <el-table-column label="客户名称" prop="clientname">
          <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.clientname" ></el-input> 
                </template>
                    <span v-else >{{scope.row.clientname}}  </span>
              </template>
        </el-table-column>
        <el-table-column label="客户联系方式" prop="clienttel">
            <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.clienttel" ></el-input> 
                </template>
                    <span v-else >{{scope.row.clienttel}}  </span>
              </template>
        </el-table-column>
         <el-table-column label="家庭住址" prop="address">
              <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.address" ></el-input> 
                </template>
                    <span v-else >{{scope.row.address}}  </span>
              </template>
         </el-table-column>
        <el-table-column label="操作" prop="editing">
              <template slot-scope="scope" >
               
               <el-button  type="primary" size="mini"  v-if="!scope.row.editing" v-model="scope.$index" @click="updateItem(scope.$index,scope.row)" >修改</el-button>
                <el-button  type="primary" size="mini"  v-if="scope.row.editing"  v-model="scope.$index" @click="confirmUpdateItem(scope.$index,scope.row)">完成</el-button>
               <el-button  type="danger" size="mini" v-model="scope.$index" @click="deleteItem(scope.$index,scope.row)" >删除</el-button>
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
        clientTableData:[],
        search:"",
         fullscreenLoading: false
    }
},
computed:{
 clientTableData2:function(){
               const search = this.search;
                  if (search) {
                return this.clientTableData.filter(dataNews => {
                    return Object.keys(dataNews).some(key => {
                        return String(dataNews[key]).toLowerCase().indexOf(search) > -1
                    })
                })
            }
            return this.clientTableData
      }

},
methods:{
  updateItem:function(index,row){
   this.clientTableData[index].editing=true;
  },
  deleteItem:function(index,row){
    this.clientTableData.splice(index,1);
    var that = this;
    that.$axios.deleteClient(row.clientid).then(res=>{
       that.$message({
          message: '删除成功',
          type: 'success'
        });
    }).catch(err=>{
      console.log(err)
    })
  },
  confirmUpdateItem:function(index,row){

    var that=this;
    var parma =row;
     that.clientTableData[index].editing=false ;
    delete parma.editing
    that.$axios.updateClient(parma).then(res=>{
      if(res.data!="-1"){
         that.$message({
          message: '修改成功',
          type: 'success'
        });
      }else{
        that.$axios.addClient(parma).then(res=>{
       that.$message({
          message: '添加成功',
          type: 'success'
        });
      
    }).catch(err=>{
      console.log(err)
    })
      }
    }).catch(err=>{
      console.log(err)
    })
that.getDataList();
  },
  addUser:function(){
    var item ={
      clientid:this.clientTableData.length+1,
      clientname:"",
      clienttel:"",
      address:"",
      editing:true
    }
    this.clientTableData.push(item);
  },
  getDataList:function(){
 var that =this;
  //获取客户信息
  that.$axios.allClientList().then(res=>{
    for(var i in res.data){
      res.data[i]["editing"] = false
    }
    that.clientTableData = res.data;
   }).catch(err=>{
     console.log(err);
   })
  }
},
created:function(){
 
  this.getDataList();
}
}
</script>

<style scoped src="../../assets/css/ContractList.css"></style>