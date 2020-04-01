# Host: localhost  (Version: 5.7.26)
# Date: 2019-12-19 00:16:18
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "clientinform"
#

DROP TABLE IF EXISTS `clientinform`;
CREATE TABLE `clientinform` (
                              `clientId` int(11) NOT NULL AUTO_INCREMENT,
                              `clientName` varchar(20) DEFAULT NULL,
                              `clientTel` varchar(20) DEFAULT NULL,
                              `address` varchar(20) DEFAULT NULL,
                              PRIMARY KEY (`clientId`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "clientinform"
#

/*!40000 ALTER TABLE `clientinform` DISABLE KEYS */;
INSERT INTO `clientinform` VALUES (1,'王虎','16724332453','东莞理工学院松山湖大学1号'),(2,'李虎','17832432455','东莞市松山湖村委会'),(3,'王二','142543554545','东莞市'),(4,'齐佩','15623445555','东莞市麻涌村'),(5,'齐笑','17832434444','东庄镇');
/*!40000 ALTER TABLE `clientinform` ENABLE KEYS */;

#
# Structure for table "contractinform"
#

DROP TABLE IF EXISTS `contractinform`;
CREATE TABLE `contractinform` (
                                `contractId` int(11) NOT NULL AUTO_INCREMENT,
                                `clientId` int(11) NOT NULL,
                                `clientName` varchar(20) NOT NULL,
                                `salerId` int(11) NOT NULL,
                                `contractName` varchar(20) NOT NULL,
                                `contractCreateTime` date NOT NULL,
                                `contractStartTime` date DEFAULT NULL,
                                `contractEndTime` date DEFAULT NULL,
                                `constractStatus` varchar(10) NOT NULL,
                                `contractRemark` varchar(120) DEFAULT NULL,
                                PRIMARY KEY (`contractId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "contractinform"
#


#
# Structure for table "contractitem"
#

DROP TABLE IF EXISTS `contractitem`;
CREATE TABLE `contractitem` (
                              `contractItemId` int(11) NOT NULL,
                              `goodsId` int(11) NOT NULL,
                              `goodsName` varchar(20) DEFAULT NULL,
                              `contractId` int(11) NOT NULL,
                              `clientId` int(11) NOT NULL,
                              `goodsNum` int(11) NOT NULL,
                              `goodsOutPrice` double DEFAULT NULL,
                              `itemStatus` varchar(20) NOT NULL,
                              `needGoodsNum` int(11),
                              PRIMARY KEY (`contractId`,`contractItemId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "contractitem"
#


#
# Structure for table "dispatchlist"
#

DROP TABLE IF EXISTS `dispatchlist`;
CREATE TABLE `dispatchlist` (
                              `dispatchListId` int(11) NOT NULL AUTO_INCREMENT,
                              `contractId` int(11) NOT NULL,
                              `contractItemId` int(11) NOT NULL,
                              `startTime` date NOT NULL,
                              `endTime` date DEFAULT NULL,
                              `realGoodsNum` int(11),
                              PRIMARY KEY (`dispatchListId`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

#
# Data for table "dispatchlist"
#


#
# Structure for table "goodsinform"
#

DROP TABLE IF EXISTS `goodsinform`;
CREATE TABLE `goodsinform` (
                             `goodsId` int(11) NOT NULL AUTO_INCREMENT,
                             `goodsStoreNum` int(11) DEFAULT NULL,
                             `goodsName` varchar(20) DEFAULT NULL,
                             `goodsOutPrice` double DEFAULT NULL,
                             `goodsInPrice` double DEFAULT NULL,
                             PRIMARY KEY (`goodsId`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "goodsinform"
#

/*!40000 ALTER TABLE `goodsinform` DISABLE KEYS */;
INSERT INTO `goodsinform` VALUES (1,260,'主机',300,200),(2,100,'键盘',100,50),(3,398,'鼠标',100,50),(4,40,'耳机',40,20),(5,50,'移动硬盘',400,200),(6,10,'显示屏',1000,500),(7,200,'鼠标垫',20,10),(8,20,'充电器',50,25),(9,200,'电池',10,5);
/*!40000 ALTER TABLE `goodsinform` ENABLE KEYS */;

#
# Structure for table "logisticinform"
#

DROP TABLE IF EXISTS `logisticinform`;
CREATE TABLE `logisticinform` (
                                `dispatchListId` int(11) NOT NULL,
                                `currentPostion` varchar(30) NOT NULL,
                                `stepTime` date NOT NULL,
                                PRIMARY KEY (`dispatchListId`,`currentPostion`,`stepTime`),
                                UNIQUE KEY `dispatchlistid` (`dispatchListId`,`currentPostion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "logisticinform"
#


#
# Structure for table "purchaselist"
#

DROP TABLE IF EXISTS `purchaselist`;
CREATE TABLE `purchaselist` (
                              `purchaseId` int(11) NOT NULL AUTO_INCREMENT,
                              `contractId` int(11) NOT NULL,
                              `contractItemId` int(11) NOT NULL,
                              `inTime` date NOT NULL,
                              `realGoodsNum` int(11),
                              PRIMARY KEY (`purchaseId`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "purchaselist"
#


#
# Structure for table "saleperson"
#

DROP TABLE IF EXISTS `saleperson`;
CREATE TABLE `saleperson` (
                            `salerId` int(11) NOT NULL AUTO_INCREMENT,
                            `userName` varchar(20) DEFAULT NULL,
                            `passWord` varchar(20) DEFAULT NULL,
                            `salerName` varchar(20) DEFAULT NULL,
                            `salerTel` varchar(20) DEFAULT NULL,
                            `reportDutyTime` date DEFAULT NULL,
                            PRIMARY KEY (`salerId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "saleperson"
#

/*!40000 ALTER TABLE `saleperson` DISABLE KEYS */;
INSERT INTO `saleperson` VALUES (1,'admin','123456','黄黄','15626610645','2019-11-19'),(2,'qiqi','123456','齐齐','178237923233','2019-10-11'),(3,'liyu','123456','李与','18923721312','2019-11-30');
/*!40000 ALTER TABLE `saleperson` ENABLE KEYS */;

#
# Structure for table "salermanager"
#

DROP TABLE IF EXISTS `salermanager`;
CREATE TABLE `salermanager` (
                              `saleManagerId` int(11) NOT NULL AUTO_INCREMENT,
                              `userName` varchar(20) NOT NULL,
                              `passWord` varchar(20) NOT NULL,
                              `saleManagerName` varchar(20) NOT NULL,
                              `salerManagerTel` varchar(20) DEFAULT NULL,
                              PRIMARY KEY (`saleManagerId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "salermanager"
#

/*!40000 ALTER TABLE `salermanager` DISABLE KEYS */;
INSERT INTO `salermanager` VALUES (1,'admin','123456','李玉','16782362832'),(2,'li','123456','李智','17832378444');
/*!40000 ALTER TABLE `salermanager` ENABLE KEYS */;

#
# Structure for table "storemanager"
#

DROP TABLE IF EXISTS `storemanager`;
CREATE TABLE `storemanager` (
                              `storeMangerId` int(11) NOT NULL AUTO_INCREMENT,
                              `userName` varchar(20) NOT NULL,
                              `passWord` varchar(20) NOT NULL,
                              `storeMangerName` varchar(20) NOT NULL,
                              `storeMangerTel` varchar(20) DEFAULT NULL,
                              PRIMARY KEY (`storeMangerId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "storemanager"
#

/*!40000 ALTER TABLE `storemanager` DISABLE KEYS */;
INSERT INTO `storemanager` VALUES (1,'admin','123456','王宇','15625510645'),(2,'wang','123456','王话','15637934455');
/*!40000 ALTER TABLE `storemanager` ENABLE KEYS */;
