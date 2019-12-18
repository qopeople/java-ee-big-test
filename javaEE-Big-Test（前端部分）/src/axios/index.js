  /*引入Vue框架*/
  import Vue from 'vue';
  /*引入资源请求插件*/
  import axios from 'axios';
  import qs from 'qs';
  import { Message } from "element-ui";

  /*使用axios插件*/
  Vue.prototype.$axios = axios;
  //Vue.prototype.GLOBAL = global_ //挂载到Vue实例上面
  const Axios = axios.create({
      baseURL: "/apis", // 因为我本地做了反向代理
      timeout: 10000,
      responseType: "json",
      withCredentials: true, // 是否允许带cookie这些
      headers: {
          "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
      }
  });


  //传参序列化
  Axios.interceptors.request.use(
      (config) => {
          config.data = qs.stringify(config.data);



          //   if (global_.token) {
          //       config.headers['token'] = global_.token
          //   }
          return config;
      },
      (error) => {
          Message({
              //  饿了么的消息弹窗组件,类似toast
              showClose: true,
              message: error,
              type: "error.data.error.message"
          });
          return Promise.reject(error);
      });

  //返回状态判断
  Axios.interceptors.response.use((res) => {
      if (res.data && res.data.code != '200') {
          console.log(res)
          return Promise.reject(res);
      }
      return res;
  }, (error) => {

      //404等问题可以在这里处理
      //   if (res.data.msg == "登录信息不存在，请重新登录") {
      //       Axios.post('/education/api/login', {
      //           username: 'admin',
      //           password: 'admin',
      //       }).then((res) => {
      //           global_.token = res.data
      //       }).catch((err) => {
      //           console.log(err)
      //       })
      //   }
      return Promise.reject(error);
  });
  //进行封装处理
  const request = (url, method, params) => {

      return new Promise((resolve, reject) => {
          if (method == 'post') {
              Axios.post(url, params)
                  .then((res) => {

                      resolve(res.data);
                  })
                  .catch((err) => {
                      console.log("出错啦")
                      reject(err)
                  })
          } else if (method == 'get') {
              Axios.get(url, { params: params })
                  .then((res) => {

                      resolve(res.data);
                  })
                  .catch((err) => {
                      console.log("出错啦")
                      console.log("----------------")
                      reject(err)
                  })
          } else if (method == 'put') {
              Axios.put(url, params)
                  .then((res) => {

                      resolve(res.data);
                  })
                  .catch((err) => {
                      console.log("出错啦")
                      reject(err)
                  })
          } else if (method == 'delete') {
              Axios.delete(url, params)
                  .then((res) => {
                      resolve(res.data)
                  })
                  .catch((err) => {
                      console.log("出错啦")
                      reject(err)
                  })
          }

      })
  }
  export default ({
      //登录
      login: (data) => {
          return request('/sm/login', 'post', data)
      },
      loginSTM: (data) => {
          return request('/stm/login', 'post', data)
      },
      loginSP: (data) => {
          return request('/sp/login', 'post', data)
      },
      allContractList: (data) => {
          return request("/sm/contract/allList", "post", data)
      },
      updateContract: (data) => {
          return request("/sm/contract/update", "post", data)
      },
      addContractList: (data) => {
          return request("/sm/contract/add", "post", data)
      },
      addContractItem: (data) => {
          return request("/sm/contractItem/add", "post", data)
      },
      allContractItemById: (data) => {
          return request("/sm/contractItemById/all/" + data, "post", "")
      },
      allContractItemByKey: (data) => {
          return request("/sm/contractItemByKey/all", "post", data)
      },
      allContractItem: (data) => {
          return request("/sm/contractItem/all", "post", data)
      },
      updateContractItem: (data) => {
          return request("/sm/contractItem/update", "post", data)
      },
      deleteContractItem: (data) => {
          return request("/sm/contractItem/delete", "post", data)
      },

      addSalePerson: (data) => {
          return request("/sm/salePerson/add", "post", data)
      },
      allSalePersonList: (data) => {
          return request("/sm/salePerson/allList", "post", data)
      },
      updateSalePerson: (data) => {
          return request("/sm/salePerson/update", "post", data)
      },
      deleteSalePerson: (data) => {
          return request("/sm/salePerson/delete/" + data, "post", "")
      },

      addClient: (data) => {
          return request("/sm/client/add", "post", data)
      },
      allClientList: (data) => {
          return request("/sm/client/allList", "post", data)
      },
      updateClient: (data) => {
          return request("/sm/client/update", "post", data)
      },
      deleteClient: (data) => {
          return request("/sm/client/delete/" + data, "post", "")
      },
      allGoodsList: (data) => {
          return request("/sm/goods/all", "post", data)
      },
      findGoodsById: (data) => {
          return request("/sm/goodsById/" + data, "post", "")
      },
      updateGoods: (data) => {
          return request("/sm/goods/update", "post", data);
      },
      addDispatchOrder: (data) => {
          return request("/sm/dispatch/add", "post", data)
      },
      addPurchase: (data) => {
          return request("/sm/purchase/add", "post", data)
      },
      allDispatchOrder: (data) => {
          return request("/sm/dispatch/all", "post", data)
      },
      dispatchById: (data) => {
          return request("/sm/dispatchById/" + data, "post", "")
      },

      allPurchase: (data) => {
          return request("/sm/purchase/all", "post", data)
      },
      allLogisticById: (data) => {
          return request("/stm/logisticById/all/" + data, "post", "")
      },
      addLogistic: (data) => {
          return request("/stm/logistic/add", "post", data)
      },
      contractBySalerId: (data) => {
          return request("/sp/contractBySalerId/" + data, "post", "")
      },
      findSomeTimeSalary: (data) => {
          return request("/sp/contractByClientId", "post", data)
      },
      changeInformSP: (data) => {
          return request("/sp/changeInform", "post", data)
      },
      itemStatusOne: (data) => {
          return request("/sp/itemStatusOne/update", "post", data)
      },
      contractStatusTwo: (data) => {
          return request("/sm/contractStatusTwo/update", "post", data)
      },
      contractStatus: (data) => {
          return request("/sm/contractStatus/update/" + data, "post", "")
      },
      orderBySalerId: (data) => {
          return request("/sp/orderBySalerId/" + data, "post", "")
      },
      orderList: (data) => {
          return request("/sm/order/all", "post", data)
      },
      goodsAdd: (data) => {
          return request("/stm/goods/add", 'post', data);
      },
      goodsDelete: (data) => {
          return request("/stm/goods/delete/" + data, "post", "")
      },
      contractDelete: (data) => {
          return request('/sm/contract/delete/' + data, "post", '');
      }
  });

  //   userBeginWeek:"",
  //   userBeginMonth:"",
  //   transactionBeginWeek:"",
  //   transactionBeginMonth:"",
  //   depositBeginDay:"",
  //   depositBeginWeek:"",
  //   depositBeginMonth:"",
  //   profitBeginWeek:"",
  //   profitBeginMonth:""