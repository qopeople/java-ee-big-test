<template>
  <div>
          

        <el-table :data="contractTableData" style="margin:30px auto;  width: 95%;height:550px"    stripe >
           <el-table-column label="合同编号" prop="contractid"></el-table-column>
           <el-table-column label="合同名称" prop="contractname"></el-table-column>
         
           <el-table-column label="客户名称" prop="clientname"></el-table-column>
        
           <el-table-column label="合同创建时间"  sortable prop="contractcreatetime"></el-table-column>
           <el-table-column label="合同开始时间"  sortable prop="contractstarttime"></el-table-column>
            <!-- <el-table-column label="合同状态" prop="constractstatus"></el-table-column>   -->
            <el-table-column
            label="操作">
            <template slot-scope="scope" >
                <!-- @click="userReceive(scope.$index)" -->
                <el-button   type="primary" size="mini" v-model="scope.$index" @click="editing(scope.$index)">查看详情</el-button>
                </template> 
            </el-table-column>
      
      </el-table>
    <!-- <div class="yy-page">
        <el-pagination
          background
          layout="prev, pager, next"
          :total="1000"
          :page-size="7"
          :current-page="currentPage"
          @current-change="currentChange"
          @prev-click='prevPage'
          @next-click='nextPage'>
        </el-pagination>
  </div> -->
    </div>
</template>

<script>
export default {
    data:function(){
        return{
            contractTableData:[],
            search:'',
            salerid:'',
        }
    },
    created:function(){
      var that =this;
      var salerid =that.$cookies.get("id")
      that.$axios.contractBySalerId(salerid).then(res=>{
        for(var i in res.data){
          res.data[i].contractcreatetime =  res.data[i].contractcreatetime.substr(0,10);
          res.data[i].contractstarttime = res.data[i].contractstarttime.substr(0,10);
        }
      that.contractTableData = res.data
      }).catch(err=>{
        console.log(err);
      })
    },
    methods:{
      editing:function(index){
  this.$router.push({path:'/ContractDetail',query:{contractInform:this.contractTableData[index]}})
      }
    }
}
</script>

<style scoped src="../../assets/css/ContractList.css"></style>