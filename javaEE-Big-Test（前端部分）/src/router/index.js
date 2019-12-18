import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Header from '@/components/Header'


import SPMainPage from '@/components/SalePerson/SPMainPage'
import ChangePassword from '@/components/SalePerson/ChangePassword'
import UserInform from '@/components/SalePerson/UserInform'
import AchieveSearch from '@/components/SalePerson/AchieveSearch'
import Contractlist from '@/components/SalePerson/Contractlist'
import ContractDetail from '@/components/SalePerson/ContractDetail'

import SMmainPage from '@/components/SaleManager/SMmainPage'
import StatisticlSales from '@/components/SaleManager/StatisticlSales'
import SaleManage from '@/components/SaleManager/SaleManage'
import ClientManage from '@/components/SaleManager/ClientManage'
import ContractManage from '@/components/SaleManager/ContractManage'
import DispatchOrder from '@/components/SaleManager/DispatchOrder'
import AddContractInform from '@/components/SaleManager/AddContractInform'
import EditingContractInform from '@/components/SaleManager/EditingContractInform'
import ContractDetailTwo from '@/components/SaleManager/ContractDetailTwo'


import STMmainPage from '@/components/StoreManager/STMmainPage'
import DispatchList from '@/components/StoreManager/DispatchList'
import RecordLogistic from '@/components/StoreManager/RecordLogistic'
import AddLogiditic from '@/components/StoreManager/AddLogiditic'
import PurchaseList from '@/components/StoreManager/PurchaseList'
import AddGoods from '@/components/StoreManager/AddGoods'
//import ChangePassword from '@/components/StoreManager/ChangePassword'


Vue.use(Router)

export default new Router({
    routes: [{
            path: '/Header',
            name: "Header",
            component: Header
        }, {
            path: '/STMmainPage',
            name: "STMmainPage",
            component: STMmainPage,
            children: [{
                path: '/DispatchList',
                name: "DispatchList",
                component: DispatchList,
            }, {
                path: '/PurchaseList',
                name: "PurchaseList",
                component: PurchaseList,
            }, {
                path: "/RecordLogistic",
                name: "RecordLogistic",
                component: RecordLogistic
            }, {
                path: '/AddLogiditic',
                name: 'AddLogiditic',
                component: AddLogiditic
            }, {
                path: '/AddGoods',
                name: 'AddGoods',
                component: AddGoods
            }]
        }, {
            path: '/SMmainPage',
            name: 'SMmainPage',
            component: SMmainPage,
            children: [{
                path: "/ContractDetailTwo",
                name: "ContractDetailTwo",
                component: ContractDetailTwo
            }, {
                path: '/StatisticlSales',
                name: 'StatisticlSales',
                component: StatisticlSales
            }, {
                path: '/SaleManage',
                name: 'SaleManage',
                component: SaleManage
            }, {
                path: '/ClientManage',
                name: 'ClientManage',
                component: ClientManage
            }, {
                path: '/ContractManage',
                name: 'ContractManage',
                component: ContractManage
            }, {
                path: '/ChangePassword',
                name: 'ChangePassword',
                component: ChangePassword,
            }, {
                path: '/DispatchOrder',
                name: 'DispatchOrder',
                component: DispatchOrder
            }, {
                path: '/AddContractInform',
                name: "AddContractInform",
                component: AddContractInform
            }, {
                path: '/EditingContractInform',
                name: 'EditingContractInform',
                component: EditingContractInform
            }]
        }, {
            path: '/HelloWorld',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/',
            name: 'Login',
            component: Login
        },
        {
            path: '/SPMainPage',
            name: 'SPMainPage',
            component: SPMainPage,
            children: [{
                path: '/ChangePassword',
                name: 'ChangePassword',
                component: ChangePassword,
            }, {
                path: '/UserInform',
                name: 'UserInform',
                component: UserInform
            }, {
                path: '/AchieveSearch',
                name: 'AchieveSearch',
                component: AchieveSearch
            }, {
                path: '/Contractlist',
                name: "Contractlist",
                component: Contractlist
            }, {
                path: "/ContractDetail",
                name: 'ContractDetail',
                component: ContractDetail
            }]
        },
    ]
})