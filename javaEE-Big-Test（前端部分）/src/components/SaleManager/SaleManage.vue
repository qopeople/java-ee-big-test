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
             <el-button type="primary" @click="addUser">新增用户</el-button>
        </el-col>
      </el-row>
      </el-card>
      <el-card style="margin:20px">
      <el-table :data="saleTableData2" style="height:450px" >
        <el-table-column  :key="Math.random()" label="销售编号" prop="salerid">
         
        </el-table-column>
        <el-table-column  :key="Math.random()" label="销售名称" prop="salername">
               <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.salername" ></el-input> 
                </template>
                    <span v-else >{{scope.row.salername}}  </span>
              </template>
        </el-table-column>
               <el-table-column  :key="Math.random()" label="系统用户名" prop="username">
               <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.username" ></el-input> 
                </template>
                    <span v-else >{{scope.row.username}}  </span>
              </template>
        </el-table-column>
                 <el-table-column  :key="Math.random()" label="系统默认密码" prop="username">
               <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.password" ></el-input> 
                </template>
                    <span v-else >{{scope.row.password}}  </span>
              </template>
        </el-table-column>
        
        <el-table-column  :key="Math.random()" label="入职时间" prop="reportdutytime">
              <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                 <el-date-picker
                          v-model="scope.row.reportdutytime"
                          align="right"
                          type="date"
                          placeholder="选择日期"
                           value-format="yyyy-MM-dd"
                          :picker-options="pickerOptions">
                          </el-date-picker>   
                </template>
                    <span v-else >{{scope.row.reportdutytime}}  </span>
              </template>
        </el-table-column>
        <el-table-column  :key="Math.random()" label="联系方式" prop="salertel">
           <template slot-scope="scope"> 
                <template v-if="scope.row.editing">
                  <el-input size="mini" v-model="scope.row.salertel" ></el-input> 
                </template>
                    <span v-else >{{scope.row.salertel}}  </span>
              </template>
        </el-table-column>
        <el-table-column  :key="Math.random()" label="操作" prop="editing">
              <template slot-scope="scope" >
               
               <el-button  type="primary" size="mini"  v-if="!scope.row.editing"  @click="updateItem(scope.row)" >修改</el-button>
                <el-button  type="primary" size="mini"  v-if="scope.row.editing"   @click="confirmUpdateItem(scope.row)" >完成</el-button>
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
        saleTableData:[],
        search:'',
          pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
            }
          }
    }
},
computed:{
 saleTableData2:function(){
               const search = this.search;
                  if (search) {
                return this.saleTableData.filter(dataNews => {
                    return Object.keys(dataNews).some(key => {
                        return String(dataNews[key]).toLowerCase().indexOf(search) > -1
                    })
                })
            }
            return this.saleTableData
      }
},
methods:{
    updateItem:function(row){
    //this.saleTableData[index].editing=!this.saleTableData[index].editing;
    for(var i in this.saleTableData){
      if(this.saleTableData[i]==row){
          this.saleTableData[i].editing=!this.saleTableData[i].editing;

      }
    }
  },
   deleteItem:function(index,row){
    this.saleTableData.splice(index,1);
    var that = this;
    that.$axios.deleteSalePerson(row.salerid).then(res=>{
       that.$message({
          message: '删除成功',
          type: 'success'
        });
    }).catch(err=>{
      console.log(err)
    })
  },
   confirmUpdateItem:function(row){
     for(var i in this.saleTableData){
      if(this.saleTableData[i]==row){
          this.saleTableData[i].editing=false;
      }
    }
    //this.saleTableData[index].editing =false
    var that=this;
   var  parms = row;
    delete parms.editing;
    that.$axios.updateSalePerson(row).then(res=>{
      if(res.data!="-1"&&row.salername){
         that.$message({
          message: '修改成功',
          type: 'success'
        });
      }else{
        that.$axios.addSalePerson(row).then(res=>{
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
      salerid:this.saleTableData.length+1,
      salername:"",
      salertel:"",
      reportdutytime:"",
      username:"",
      password:"123456",
      editing:true
    }
    this.saleTableData.push(item);
  },
  getDataList:function(){
  var that =this;
  //获取客户信息
  that.$axios.allSalePersonList().then(res=>{
    for(var i in res.data){
      res.data[i]["editing"] = false;
      res.data[i].reportdutytime = res.data[i].reportdutytime.substr(0,10);
    }
    that.saleTableData = res.data;
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