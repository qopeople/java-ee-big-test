-- 销售人员
drop table if exists SalePerson ;
create table  SalePerson(
`salerId`  int not null primary key AUTO_INCREMENT,
`userName`     varchar(20) not null,  
`passWord` varchar(20) not null,
`salerName`  varchar(20),
`salerTel`    varchar(20),
`reportDutyTime` date
);
-- 销售管理员
drop table if exists SalerManager ;
create table  SalerManager (
`saleManagerId`  int not null primary key AUTO_INCREMENT,
`userName`     varchar(20) not null,  
`passWord` varchar(20) not null,
`saleManagerName`  varchar(20) not null,
`salerManagerTel`    varchar(20)
);

-- 仓库管理员
drop table if exists StoreManager ;
 create table StoreManager(
 `storeMangerId` int not null primary key AUTO_INCREMENT,
 `userName`     varchar(20) not null,  
 `passWord` varchar(20) not null,
 `storeMangerName`  varchar(20) not null,
 `storeMangerTel`  varchar(20)
 );
-- 客户信息
drop table if exists  ClientInform ;
  create  table ClientInform(
   `clientId` int not null primary key AUTO_INCREMENT,
    `clientName`  varchar(20) ,
   `clientTel`  varchar(20) ,
    `address`   varchar(20) ,
  ); 

-- 合同内容
drop table if exists ContractInform ;
create table  ContractInform(
`contractId`   int not null primary key AUTO_INCREMENT,
`customerId`    int not null,
`customerName`  varchar(20) not null,
`salerId`  int not null,
`contractName` varchar(20) not null,
`contractCreateTime`  DATE not null ,
`contractStartTime`  DATE ,
`contractEndTime`  DATE ,
`constractStatus`  varchar (10) not null,
`contractRemark`  varchar (120)
);


-- 存货信息·
drop table if exists  GoodsInform ;
 create  table GoodsInform (
    `goodsId` int not null primary key AUTO_INCREMENT ,
    `goodsStoreNum` int  ,
    `goodsName` varchar(20)
 );
-- 进货单
drop table if exists  PurchaseList ;
 create  table PurchaseList (
 `purchaseId` int not null primary key AUTO_INCREMENT,
 `storeMangerId` int not null ,
 `constractId` int not null ,
 `contractItemId` int not null ,
 `inTime` date not null ,
  `goodsInPrice` double ,
 `allCost` double  not null
 );
--  发货单 （订货单）
DROP  TABLE if exists DispatchList;
 create  table DispatchList(
 `dispatchListId` int not null primary key AUTO_INCREMENT,
 `constractId` int not null ,
 `contractItemId` int not null ,
 `storeMangerId` int not null ,
 `goodsListStatus` varchar(10) not null ,
 `logisticId` int not null,
 `startTime` DATE not null ,
 `endTime` DATE not null
 );
--  物流项
DROP  TABLE if exists logisticInform;
 create table logisticInform(
 `logisticId` int not null,
 `currentPostion` varchar(30) not null,
 primary key( `logisticId`, `currentPostion`)
 );
-- 合同内容项
DROP table if exists ContractItem;
create table ContractItem(
`contractItemId` int not null  ,
`goodsId` int not null ,
`goodsName` varchar(20) not null,
`contractId`   int not null,
 `clientId` int not null,
`goodsNum` int not null ,
`goodsOutPrice` double ,
`itemStatus` varchar(20) not null,
 primary key( `contractId`,`contractId`)
)


