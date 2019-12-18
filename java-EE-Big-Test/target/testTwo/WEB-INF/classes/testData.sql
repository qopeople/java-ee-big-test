-- 合同信息表
INSERT INTO `contractinform` (`contractId`, `customerId`, `customerName`, `salerId`, `contractName`, `contractCreateTime`, `contractStartTime`, `contractEndTime`, `constractStatus`, `contractRemark`) VALUES
('CT123', 'CU123', '小黄', 'SR123', '星球大战物资筹备', '2019-12-06', '2019-12-06', NULL, '等待进行', NULL),
('CT124', 'CU123', '小黄', 'SR123', '星球大战物资筹备2', '2019-12-07', '2019-12-16', NULL, '等待开始', NULL);
-- 客户信息
INSERT INTO `clientinform` (`clientId`, `clientPassWord`, `clientName`, `clientTel`) VALUES
('C123', '123456', '王婉', '15625510645'),
('C232', '123456', '琪琪', '15625510643');
--合同项1
INSERT INTO `contractitem` (`contractItemId`, `goodsId`, `goodsName`, `contractId`, `clientId`, `goodsNum`, `goodsOutPrice`, `itemStatus`) VALUES
('CTI1', 'GD123', '芯片', 'CT123', 'C123', '10', '200', '等待支付'),
('CTI2', 'GD124', '主板', 'CT123', 'C123', '2', '1000', '等待支付');
--库存内容
INSERT INTO `goodsinform` (`goodsId`, `goodsStoreNum`, `goodsName`) VALUES
('GD123 ', '200', '芯片'), ('GD124', '20', '主板');
--销售人员
INSERT INTO `saleperson` (`salerId`, `salePassWord`, `salerName`, `salerTel`, `reportDutyTime`) VALUES
('SR123', '123456', '小李', '15622683333', '2019-11-05'),
('SR143', '123456', '小齐', '15622683335', '2019-09-10');
--销售经理
INSERT INTO `salermanager` (`saleManagerId`, `saleManagerPassWord`, `saleManagerName`, `salerManagerTel`) VALUES
 ('SM123', '123456', '王经理', '16778214532'),
 ('SM135', '123456', '许经理', '13378214532');
 --仓库管理员
 INSERT INTO `storemanager` (`storeMangerId`, `StoreManagerPassWord`, `storeMangerName`, `storeMangerTel`) VALUES
 ('STM123', '123456', '张管', '13235322323'),
 ('STM132', '123456', '张希', '13232322323');
