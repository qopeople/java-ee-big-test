-- 销售人员
-- drop table if exists SalePerson ;
create table  SalePerson(
`salerId`  varchar(20) not null primary key,
`salePassWord` varchar(20) not null,
`salerName`  varchar(20) not null,
`salerTel`    varchar(20),
`reportDutyTime` date
);

-- 客户信息
--   drop table if exists  ClientInform ;
  create  table ClientInform(
   `clientId` varchar(20) not null primary key,
   `clientPassWord` varchar(20) not null,
    `clientName`  varchar(20) not null,
   `clientTel` varchar(20) not null
  );
-- 销售管理员
-- drop table if exists SalerManager ;
create table  SalerManager (
`saleManagerId`  varchar(20) not null primary key,
`saleManagerPassWord` varchar(20) not null,
`saleManagerName`  varchar(20) not null,
`salerManagerTel`    varchar(20)
);
-- 合同内容
-- drop table if exists ContractInform ;
create table  ContractInform(
`contractId`   varchar(20) not null primary key,
`customerId`    varchar(20) not null,
`customerName`  varchar(20) not null,
`salerId`  varchar(20) not null,
`contractName` varchar(20) not null,
`contractCreateTime`  DATE not null ,
`contractStartTime`  DATE ,
`contractEndTime`  DATE ,
`constractStatus`  varchar (10) not null,
`contractRemark`  varchar (120)
);
-- 仓库管理员
--  drop table if exists StoreManager ;
 create table StoreManager(
 `storeMangerId` varchar(20) not null primary key,
 `StoreManagerPassWord` varchar(20) not null,
 `storeMangerName`  varchar(20) not null,
 `storeMangerTel`  varchar(20)
 );

-- 存货信息·
-- drop table if exists  GoodsInform ;
 create  table GoodsInform (
    `goodsId` varchar(20) not null primary key ,
    `goodsStoreNum` int  ,
    `goodsName` varchar(20)
 );
-- 进货单
--  drop table if exists  PurchaseList ;
 create  table PurchaseList (
 `purchaseId` varchar(20) not null primary key,
 `storeMangerId` varchar(20) not null ,
 `constractId` varchar(20) not null ,
 `contractItemId` varchar(20) not null ,
 `inTime` date not null ,
  `goodsInPrice` double ,
 `allCost` double  not null
 );
--  发货单 （订货单）
--  DROP  TABLE if exists DispatchList;
 create  table DispatchList(
 `dispatchListId` varchar(20) not null primary key,
 `constractId` varchar(20) not null ,
 `contractItemId` varchar(20) not null ,
 `storeMangerId` varchar(20) not null ,
 `goodsListStatus` varchar(10) not null ,
 `logisticId` varchar(20) not null,
 `startTime` DATE not null ,
 `endTime` DATE not null
 );
--  物流项
--  DROP  TABLE if exists logisticInform;
 create table logisticInform(
 `logisticId` varchar(20) not null,
 `currentPostion` varchar(30) not null,
 primary key( `logisticId`,`currentPostion`)
 );
-- 合同内容项
-- DROP table if exists ContractItem;
create table ContractItem(
`contractItemId` varchar(20) not null ,
`goodsId` varchar(20) not null ,
`goodsName` varchar(20) not null,
`contractId`   varchar(20) not null,
 `clientId` varchar(20) not null,
`goodsNum` int not null ,
`goodsOutPrice` double ,
`itemStatus` varchar(20) not null,
   primary key( `contractId`,`contractItemId` )
);



