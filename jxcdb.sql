/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : jxcdb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-03-22 10:05:27
*/

DROP DATABASE IF EXISTS `jxcdb`;

create database `jxcdb`;

use `jxcdb`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `Auth_id` int(11) NOT NULL AUTO_INCREMENT,
  `Auth_name` varchar(50) NOT NULL,
  `Auth_createTime` date NOT NULL,
  PRIMARY KEY (`Auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------

-- ----------------------------
-- Table structure for backsales
-- ----------------------------
DROP TABLE IF EXISTS `backsales`;
CREATE TABLE `backsales` (
  `BSA_id` varchar(30) NOT NULL,
  `Customer_id` int(11) NOT NULL,
  `RequestDate` date DEFAULT NULL,
  `ReviewEmp` int(11) NOT NULL,
  `ReviewState` varchar(0) DEFAULT NULL,
  `BackNum` varchar(0) DEFAULT NULL,
  `BackReason` varchar(0) DEFAULT NULL,
  PRIMARY KEY (`BSA_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backsales
-- ----------------------------

-- ----------------------------
-- Table structure for backsalesdetail
-- ----------------------------
DROP TABLE IF EXISTS `backsalesdetail`;
CREATE TABLE `backsalesdetail` (
  `BSAD_id` int(11) NOT NULL AUTO_INCREMENT,
  `BSA_id` int(11) NOT NULL,
  `Product_id` int(11) NOT NULL,
  `Count` int(11) NOT NULL,
  PRIMARY KEY (`BSAD_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backsalesdetail
-- ----------------------------

-- ----------------------------
-- Table structure for backstock
-- ----------------------------
DROP TABLE IF EXISTS `backstock`;
CREATE TABLE `backstock` (
  `BST_id` varchar(30) NOT NULL,
  `Employee_id` int(11) NOT NULL,
  `Supplier_id` int(11) NOT NULL,
  `ManagerReviewState` varchar(0) DEFAULT NULL,
  `ManagerReviewEmp` varchar(0) DEFAULT NULL,
  `BackStockDate` date DEFAULT NULL,
  `BackStockReason` varchar(0) DEFAULT NULL,
  PRIMARY KEY (`BST_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backstock
-- ----------------------------

-- ----------------------------
-- Table structure for backstockdetail
-- ----------------------------
DROP TABLE IF EXISTS `backstockdetail`;
CREATE TABLE `backstockdetail` (
  `BSTD_id` int(11) NOT NULL AUTO_INCREMENT,
  `BST_id` int(11) NOT NULL,
  `Product_id` int(11) NOT NULL,
  `Count` varchar(0) DEFAULT NULL,
  PRIMARY KEY (`BSTD_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backstockdetail
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `Customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `Cus_name` varchar(50) NOT NULL,
  `Cus_address` varchar(100) NOT NULL,
  `Cus_phone` varchar(50) NOT NULL,
  `PostalCode` varchar(50) DEFAULT NULL,
  `Cus_contact` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for customerpayment
-- ----------------------------
DROP TABLE IF EXISTS `customerpayment`;
CREATE TABLE `customerpayment` (
  `CP_id` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_id` int(11) NOT NULL,
  `SalesOrder_id` varchar(30) NOT NULL,
  `FPaymentAmount` varchar(0) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `FPaymentTime` date DEFAULT NULL,
  `FPaymentStatus` varchar(0) DEFAULT NULL,
  `LPaymentAmount` varchar(0) DEFAULT NULL,
  `LPaymentTime` date DEFAULT NULL,
  `LPaymentStatus` varchar(0) DEFAULT NULL,
  PRIMARY KEY (`CP_id`),
  KEY `FK_FK_CPayment_SalesOrder` (`SalesOrder_id`),
  KEY `FK_FK_Payment_Customer` (`Customer_id`),
  CONSTRAINT `FK_FK_CPayment_SalesOrder` FOREIGN KEY (`SalesOrder_id`) REFERENCES `salesorder` (`SO_id`),
  CONSTRAINT `FK_FK_Payment_Customer` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customerpayment
-- ----------------------------

-- ----------------------------
-- Table structure for damagedrequest
-- ----------------------------
DROP TABLE IF EXISTS `damagedrequest`;
CREATE TABLE `damagedrequest` (
  `DamagedRequest_id` varchar(30) NOT NULL,
  `RequestEmpId` varchar(30) NOT NULL,
  `RequestTime` datetime NOT NULL,
  `DamagedStoreHouse` int(11) NOT NULL,
  `DeptReviewStatus` int(11) DEFAULT NULL,
  `DeptReviewEmp` varchar(30) DEFAULT NULL,
  `DeptReviewTime` datetime DEFAULT NULL,
  `DamagedReason` varchar(255) NOT NULL,
  `Remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DamagedRequest_id`),
  KEY `FK_RequestEmp_Emp` (`RequestEmpId`),
  KEY `FK_DamagedStore_Store` (`DamagedStoreHouse`),
  KEY `FK_DeptReStatus` (`DeptReviewStatus`),
  KEY `FK_DeptReEmp_Emp` (`DeptReviewEmp`),
  CONSTRAINT `FK_DamagedStore_Store` FOREIGN KEY (`DamagedStoreHouse`) REFERENCES `storehouse` (`StoreHouse_id`),
  CONSTRAINT `FK_DeptReEmp_Emp` FOREIGN KEY (`DeptReviewEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_DeptReStatus` FOREIGN KEY (`DeptReviewStatus`) REFERENCES `reviewstatus` (`RS_id`),
  CONSTRAINT `FK_RequestEmp_Emp` FOREIGN KEY (`RequestEmpId`) REFERENCES `employee` (`EmpLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of damagedrequest
-- ----------------------------

-- ----------------------------
-- Table structure for damagedrequestdetail
-- ----------------------------
DROP TABLE IF EXISTS `damagedrequestdetail`;
CREATE TABLE `damagedrequestdetail` (
  `DRD_id` int(8) NOT NULL AUTO_INCREMENT,
  `DamaagedRequest_id` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Count` int(8) NOT NULL,
  `ProductUnit_id` int(8) NOT NULL,
  PRIMARY KEY (`DRD_id`),
  KEY `FK_DamagedId_Damaged` (`DamaagedRequest_id`),
  KEY `FK_Product_Product` (`Product_id`),
  KEY `FK_Unit_Unit` (`ProductUnit_id`),
  CONSTRAINT `FK_DamagedId_Damaged` FOREIGN KEY (`DamaagedRequest_id`) REFERENCES `damagedrequest` (`DamagedRequest_id`),
  CONSTRAINT `FK_Product_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_Unit_Unit` FOREIGN KEY (`ProductUnit_id`) REFERENCES `productunit` (`ProductUnit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of damagedrequestdetail
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `DeptId` int(11) NOT NULL AUTO_INCREMENT,
  `DeptName` varchar(20) NOT NULL,
  `DeptDes` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DeptId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '财务部', '分发工资 做账');
INSERT INTO `dept` VALUES ('2', '仓库管理部', '管理仓库');
INSERT INTO `dept` VALUES ('3', '销售部', '跑业务 拉客户');
INSERT INTO `dept` VALUES ('4', '采购部', '和供应商洽谈 采购货物');
INSERT INTO `dept` VALUES ('5', '董事', '拥有最高权限');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `EmpLoginName` varchar(30) NOT NULL,
  `EmpLoginPwd` varchar(30) NOT NULL,
  `EmpName` varchar(30) NOT NULL,
  `RoleId` int(11) NOT NULL,
  `DeptId` int(11) NOT NULL,
  `JoinDate` date NOT NULL,
  `Gender` varchar(2) NOT NULL,
  `Birthday` date NOT NULL,
  `Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  PRIMARY KEY (`EmpLoginName`),
  KEY `FK_FK_EMP_DEPT` (`DeptId`),
  KEY `FK_PK_EMP_Role` (`RoleId`),
  CONSTRAINT `FK_FK_EMP_DEPT` FOREIGN KEY (`DeptId`) REFERENCES `dept` (`DeptId`),
  CONSTRAINT `FK_PK_EMP_Role` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('james', '123', '詹姆斯', '2', '4', '2010-02-01', '男', '1994-06-14', '江苏省南京市', '17683728192', 'abc@163.com');
INSERT INTO `employee` VALUES ('rose', '123', '罗斯', '2', '3', '2015-03-04', '男', '1991-06-04', '徐州泉山区', '19787283921', '5241593@qq.com');
INSERT INTO `employee` VALUES ('wade', '123', '哓擎', '1', '3', '2016-10-26', '男', '1996-04-16', '江苏省徐州市', '18796284434', 'lxq413@126.com');

-- ----------------------------
-- Table structure for enterstock
-- ----------------------------
DROP TABLE IF EXISTS `enterstock`;
CREATE TABLE `enterstock` (
  `EnterStock_id` varchar(30) NOT NULL,
  `StoreHouse_id` int(11) NOT NULL,
  `Employee_id` varchar(30) NOT NULL,
  `EnterDate` date NOT NULL,
  `EnterStockType_id` int(11) NOT NULL,
  `UpstreamNo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`EnterStock_id`),
  KEY `FK_FK_EnterStoreEmp_Emp` (`Employee_id`),
  KEY `FK_FK_EnterStore_Store` (`StoreHouse_id`),
  KEY `FK_FK_EnterStore_Type` (`EnterStockType_id`),
  CONSTRAINT `FK_FK_EnterStoreEmp_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_EnterStore_Store` FOREIGN KEY (`StoreHouse_id`) REFERENCES `storehouse` (`StoreHouse_id`),
  CONSTRAINT `FK_FK_EnterStore_Type` FOREIGN KEY (`EnterStockType_id`) REFERENCES `enterstocktype` (`EST_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterstock
-- ----------------------------

-- ----------------------------
-- Table structure for enterstockdetail
-- ----------------------------
DROP TABLE IF EXISTS `enterstockdetail`;
CREATE TABLE `enterstockdetail` (
  `SP_id` int(11) NOT NULL AUTO_INCREMENT,
  `EnterStock_id` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Product_count` int(11) NOT NULL,
  `Product_price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`SP_id`),
  KEY `FK_FK_EnterStoreDetail_Product` (`Product_id`),
  KEY `FK_FK_EnterStore_EnterStoreDetail` (`EnterStock_id`),
  CONSTRAINT `FK_FK_EnterStoreDetail_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_FK_EnterStore_EnterStoreDetail` FOREIGN KEY (`EnterStock_id`) REFERENCES `enterstock` (`EnterStock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterstockdetail
-- ----------------------------

-- ----------------------------
-- Table structure for enterstocktype
-- ----------------------------
DROP TABLE IF EXISTS `enterstocktype`;
CREATE TABLE `enterstocktype` (
  `EST_id` int(11) NOT NULL AUTO_INCREMENT,
  `EST_name` varchar(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`EST_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterstocktype
-- ----------------------------
INSERT INTO `enterstocktype` VALUES ('1', '采购入库', '从供应商进货入库');
INSERT INTO `enterstocktype` VALUES ('2', '退货入库', '客户退货');
INSERT INTO `enterstocktype` VALUES ('3', '调拨入库', '调拨入得');

-- ----------------------------
-- Table structure for leavestock
-- ----------------------------
DROP TABLE IF EXISTS `leavestock`;
CREATE TABLE `leavestock` (
  `LS_id` varchar(30) NOT NULL,
  `Employee_id` varchar(30) NOT NULL,
  `StoreHouse_id` int(11) NOT NULL,
  `LeaveStock_time` date NOT NULL,
  `LeaveStockType_id` int(11) NOT NULL,
  `UpstreamNo` varchar(30) NOT NULL,
  PRIMARY KEY (`LS_id`),
  KEY `FK_FK_LeaveStoreEmp_Emp` (`Employee_id`),
  KEY `FK_FK_LeaveStore_Store` (`StoreHouse_id`),
  KEY `FK_FK_OutStore_OutStoreType` (`LeaveStockType_id`),
  CONSTRAINT `FK_FK_LeaveStoreEmp_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_LeaveStore_Store` FOREIGN KEY (`StoreHouse_id`) REFERENCES `storehouse` (`StoreHouse_id`),
  CONSTRAINT `FK_FK_OutStore_OutStoreType` FOREIGN KEY (`LeaveStockType_id`) REFERENCES `leavestocktype` (`LST_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leavestock
-- ----------------------------

-- ----------------------------
-- Table structure for leavestockdetail
-- ----------------------------
DROP TABLE IF EXISTS `leavestockdetail`;
CREATE TABLE `leavestockdetail` (
  `LSD_id` int(11) NOT NULL AUTO_INCREMENT,
  `LeaveStock_id` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Count` int(11) NOT NULL,
  PRIMARY KEY (`LSD_id`),
  KEY `FK_FK_LeaveStoreDetail_Product` (`Product_id`),
  KEY `FK_FK_LeaveStore_LeaveStoreDetail` (`LeaveStock_id`),
  CONSTRAINT `FK_FK_LeaveStoreDetail_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_FK_LeaveStore_LeaveStoreDetail` FOREIGN KEY (`LeaveStock_id`) REFERENCES `leavestock` (`LS_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leavestockdetail
-- ----------------------------

-- ----------------------------
-- Table structure for leavestocktype
-- ----------------------------
DROP TABLE IF EXISTS `leavestocktype`;
CREATE TABLE `leavestocktype` (
  `LST_id` int(11) NOT NULL AUTO_INCREMENT,
  `LST_name` varchar(20) NOT NULL,
  `LST_des` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`LST_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leavestocktype
-- ----------------------------
INSERT INTO `leavestocktype` VALUES ('1', '销售出库', '啊啊啊');
INSERT INTO `leavestocktype` VALUES ('2', '退货出库', '退货');
INSERT INTO `leavestocktype` VALUES ('3', '报损出库', '货物报损');
INSERT INTO `leavestocktype` VALUES ('4', '销毁出库', '销毁');
INSERT INTO `leavestocktype` VALUES ('5', '调拨出库', '调拨');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `Product_id` varchar(30) NOT NULL,
  `Product_name` varchar(50) NOT NULL,
  `ProductType_id` int(11) NOT NULL,
  `ProductUnit_id` int(11) NOT NULL,
  `Employee_id` varchar(30) NOT NULL,
  `CreateDate` date NOT NULL,
  PRIMARY KEY (`Product_id`),
  KEY `FK_FK_PRO_PROUNIT` (`ProductUnit_id`),
  KEY `FK_PRO_PROTYPE` (`ProductType_id`),
  KEY `FK_Pro_Emp` (`Employee_id`),
  CONSTRAINT `FK_FK_PRO_PROUNIT` FOREIGN KEY (`ProductUnit_id`) REFERENCES `productunit` (`ProductUnit_id`),
  CONSTRAINT `FK_PRO_PROTYPE` FOREIGN KEY (`ProductType_id`) REFERENCES `producttype` (`ProductType_id`),
  CONSTRAINT `FK_Pro_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('CPS-10001', '旋转叶片', '1', '1', 'wade', '2016-03-10');
INSERT INTO `product` VALUES ('CPS-10002', '螺栓12mm', '4', '6', 'rose', '2010-02-09');
INSERT INTO `product` VALUES ('CPS-10003', '螺栓13mm', '4', '6', 'rose', '2010-02-09');
INSERT INTO `product` VALUES ('CPS-10004', '螺帽12mm', '4', '6', 'james', '2018-01-30');
INSERT INTO `product` VALUES ('CPS-10018', '螺帽13mm', '4', '6', 'wade', '2018-03-22');
INSERT INTO `product` VALUES ('CPS-10034', '滑轮轴承', '8', '4', 'rose', '2018-03-20');
INSERT INTO `product` VALUES ('CPS-11084', '固定叶片', '3', '2', 'rose', '2018-03-20');
INSERT INTO `product` VALUES ('CPS-21908', '压力框架', '2', '2', 'rose', '2018-03-15');

-- ----------------------------
-- Table structure for producttype
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `ProductType_id` int(11) NOT NULL AUTO_INCREMENT,
  `ProductType_name` varchar(50) NOT NULL,
  `Remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ProductType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producttype
-- ----------------------------
INSERT INTO `producttype` VALUES ('1', '分离器', null);
INSERT INTO `producttype` VALUES ('2', '磨盘部', '啊啊啊');
INSERT INTO `producttype` VALUES ('3', '加压装置', null);
INSERT INTO `producttype` VALUES ('4', '中架体部', null);
INSERT INTO `producttype` VALUES ('5', '喷嘴环部', null);
INSERT INTO `producttype` VALUES ('6', '轴套', null);
INSERT INTO `producttype` VALUES ('7', '轮胎', null);
INSERT INTO `producttype` VALUES ('8', '轴承', null);

-- ----------------------------
-- Table structure for productunit
-- ----------------------------
DROP TABLE IF EXISTS `productunit`;
CREATE TABLE `productunit` (
  `ProductUnit_id` int(11) NOT NULL AUTO_INCREMENT,
  `PU_name` varchar(30) NOT NULL,
  `PU_des` varchar(200) DEFAULT NULL,
  `Employee_id` varchar(30) NOT NULL,
  `CreateTime` date NOT NULL,
  PRIMARY KEY (`ProductUnit_id`),
  KEY `FK_ProductUnit_Emp` (`Employee_id`),
  CONSTRAINT `FK_ProductUnit_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productunit
-- ----------------------------
INSERT INTO `productunit` VALUES ('1', '架', '啊啊啊', 'wade', '2010-02-02');
INSERT INTO `productunit` VALUES ('2', '台', '阿斯顿飞洒地方；林肯郡', 'wade', '2010-02-02');
INSERT INTO `productunit` VALUES ('3', '个', '不不不', 'james', '2010-02-02');
INSERT INTO `productunit` VALUES ('4', '包', '吃吃吃', 'wade', '2010-02-02');
INSERT INTO `productunit` VALUES ('5', '捆', '对对对', 'wade', '2010-02-02');
INSERT INTO `productunit` VALUES ('6', '箱', '啊啊啊', 'rose', '2010-02-02');

-- ----------------------------
-- Table structure for purchasepaymentslip
-- ----------------------------
DROP TABLE IF EXISTS `purchasepaymentslip`;
CREATE TABLE `purchasepaymentslip` (
  `PPS_id` varchar(30) NOT NULL,
  `PRD_id` varchar(30) NOT NULL,
  `Supplier_id` varchar(30) NOT NULL,
  `FEmployee_id` varchar(30) DEFAULT NULL,
  `FPayment_time` date DEFAULT NULL,
  `FPayment_amount` decimal(10,0) DEFAULT NULL,
  `FPayment_status` varchar(30) DEFAULT NULL,
  `FReviewEmp_id` varchar(30) DEFAULT NULL,
  `FReviewTime` date DEFAULT NULL,
  `FReviewStatus` int(11) DEFAULT NULL,
  `LEmployee_id` varchar(30) DEFAULT NULL,
  `LPayment_time` date DEFAULT NULL,
  `LPayment_amount` decimal(10,0) DEFAULT NULL,
  `LPayment_status` varchar(30) DEFAULT NULL,
  `LReviewEmp_id` varchar(30) DEFAULT NULL,
  `LReviewTime` date DEFAULT NULL,
  `LReviewStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`PPS_id`),
  KEY `FK_FK_PurchasePamentFirstReview` (`FReviewStatus`),
  KEY `FK_FK_PurchasePayFirstReviewEmp_Emp` (`FReviewEmp_id`),
  KEY `FK_FK_PurchasePaymentFirstPay` (`FEmployee_id`),
  KEY `FK_FK_PurchasePaymentLastPay` (`LEmployee_id`),
  KEY `FK_FK_PurchasePaymentLastReviewStatus` (`LReviewStatus`),
  KEY `FK_FK_PurchasePaymentLastReview_Emp` (`LReviewEmp_id`),
  KEY `FK_FK_PurchasePayment_PurchaseRequisition` (`PRD_id`),
  KEY `FK_FK_PurchasePayment_Supplier` (`Supplier_id`),
  CONSTRAINT `FK_FK_PurchasePamentFirstReview` FOREIGN KEY (`FReviewStatus`) REFERENCES `reviewstatus` (`RS_id`),
  CONSTRAINT `FK_FK_PurchasePayFirstReviewEmp_Emp` FOREIGN KEY (`FReviewEmp_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_PurchasePaymentFirstPay` FOREIGN KEY (`FEmployee_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_PurchasePaymentLastPay` FOREIGN KEY (`LEmployee_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_PurchasePaymentLastReviewStatus` FOREIGN KEY (`LReviewStatus`) REFERENCES `reviewstatus` (`RS_id`),
  CONSTRAINT `FK_FK_PurchasePaymentLastReview_Emp` FOREIGN KEY (`LReviewEmp_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_PurchasePayment_PurchaseRequisition` FOREIGN KEY (`PRD_id`) REFERENCES `purchaserequest` (`PurchaseRequest_id`),
  CONSTRAINT `FK_FK_PurchasePayment_Supplier` FOREIGN KEY (`Supplier_id`) REFERENCES `supplier` (`Supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchasepaymentslip
-- ----------------------------

-- ----------------------------
-- Table structure for purchaserequest
-- ----------------------------
DROP TABLE IF EXISTS `purchaserequest`;
CREATE TABLE `purchaserequest` (
  `PurchaseRequest_id` varchar(30) NOT NULL,
  `RequestEmpId` varchar(30) NOT NULL,
  `RequestTime` date NOT NULL,
  `Supplier_id` varchar(30) NOT NULL,
  `SuppContact` varchar(30) DEFAULT NULL,
  `SuppPhone` varchar(30) DEFAULT NULL,
  `DeptReviewStatus` int(11) DEFAULT NULL,
  `DeptReviewTime` date DEFAULT NULL,
  `DeptReviewEmp` varchar(30) DEFAULT NULL,
  `FinancialAuditStatus` int(11) DEFAULT NULL,
  `FinancialAuditTime` date DEFAULT NULL,
  `FinancialAuditEmp` varchar(30) DEFAULT NULL,
  `Remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PurchaseRequest_id`),
  KEY `FK_DEPTREVIEW_EMP` (`DeptReviewEmp`),
  KEY `FK_FK_AUDITREVIEW_EMP` (`FinancialAuditEmp`),
  KEY `FK_FK_AUDIT_REVIEW` (`FinancialAuditStatus`),
  KEY `FK_FK_DEPTREVIEW_REVIEW` (`DeptReviewStatus`),
  KEY `FK_FK_REQUEST_EMP` (`RequestEmpId`),
  KEY `FK_PURCHASE_SUPP` (`Supplier_id`),
  CONSTRAINT `FK_DEPTREVIEW_EMP` FOREIGN KEY (`DeptReviewEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_AUDITREVIEW_EMP` FOREIGN KEY (`FinancialAuditEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_AUDIT_REVIEW` FOREIGN KEY (`FinancialAuditStatus`) REFERENCES `reviewstatus` (`RS_id`),
  CONSTRAINT `FK_FK_DEPTREVIEW_REVIEW` FOREIGN KEY (`DeptReviewStatus`) REFERENCES `reviewstatus` (`RS_id`),
  CONSTRAINT `FK_FK_REQUEST_EMP` FOREIGN KEY (`RequestEmpId`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_PURCHASE_SUPP` FOREIGN KEY (`Supplier_id`) REFERENCES `supplier` (`Supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaserequest
-- ----------------------------
INSERT INTO `purchaserequest` VALUES ('CGBOVI032004210234394', 'wade', '2018-03-07', 'GHS10001', null, null, '1', '2018-03-14', 'wade', '1', '2018-03-16', 'wade', null);

-- ----------------------------
-- Table structure for purchaserequestdetail
-- ----------------------------
DROP TABLE IF EXISTS `purchaserequestdetail`;
CREATE TABLE `purchaserequestdetail` (
  `PRD_id` int(11) NOT NULL AUTO_INCREMENT,
  `PurchaseRequest_id` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Count` int(11) NOT NULL,
  `ProductUnit_id` int(11) DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`PRD_id`),
  KEY `FK_FK_PurchaseRequest_PurchaseRequestDetail` (`PurchaseRequest_id`),
  KEY `FK_FK_REQUESTDETAIL_PRO` (`Product_id`),
  KEY `FK_PurchaseDetail_ProductUnit` (`ProductUnit_id`),
  CONSTRAINT `FK_FK_PurchaseRequest_PurchaseRequestDetail` FOREIGN KEY (`PurchaseRequest_id`) REFERENCES `purchaserequest` (`PurchaseRequest_id`),
  CONSTRAINT `FK_FK_REQUESTDETAIL_PRO` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_PurchaseDetail_ProductUnit` FOREIGN KEY (`ProductUnit_id`) REFERENCES `productunit` (`ProductUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaserequestdetail
-- ----------------------------
INSERT INTO `purchaserequestdetail` VALUES ('1', 'CGBOVI032004210234394', 'CPS-10003', '2', null, null);
INSERT INTO `purchaserequestdetail` VALUES ('2', 'CGBOVI032004210234394', 'CPS-10004', '3', null, null);
INSERT INTO `purchaserequestdetail` VALUES ('3', 'CGBOVI032004210234394', 'CPS-10034', '5', null, null);

-- ----------------------------
-- Table structure for requisition
-- ----------------------------
DROP TABLE IF EXISTS `requisition`;
CREATE TABLE `requisition` (
  `Requisition_id` varchar(30) NOT NULL,
  `RequestEmp` varchar(30) NOT NULL,
  `RequestTime` date NOT NULL,
  `ReviewEmp` varchar(30) DEFAULT NULL,
  `ReviewTime` date DEFAULT NULL,
  `ReviewStatus` int(11) DEFAULT NULL,
  `OutboundStoreHouse` int(11) DEFAULT NULL,
  `OutboundStoreHouseTime` date DEFAULT NULL,
  `OutboundEmp` varchar(30) DEFAULT NULL,
  `StorageStoreHouse` int(11) DEFAULT NULL,
  `StorageStoreHouseTime` date DEFAULT NULL,
  `StorageStoreHouseEmp` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Requisition_id`),
  KEY `FK_FK_RequisitionEmp_Emp` (`RequestEmp`),
  KEY `FK_FK_RequisitionEnterEmp_Emp` (`StorageStoreHouseEmp`),
  KEY `FK_FK_RequisitionEnter_Store` (`StorageStoreHouse`),
  KEY `FK_FK_RequisitionLeaveEmp_Emp` (`OutboundEmp`),
  KEY `FK_FK_RequisitionLeave_Store` (`OutboundStoreHouse`),
  KEY `FK_FK_RequisitionReview_Emp` (`ReviewEmp`),
  KEY `FK_FK_RequisitionReview_ReviewStatus` (`ReviewStatus`),
  CONSTRAINT `FK_FK_RequisitionEmp_Emp` FOREIGN KEY (`RequestEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_RequisitionEnterEmp_Emp` FOREIGN KEY (`StorageStoreHouseEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_RequisitionEnter_Store` FOREIGN KEY (`StorageStoreHouse`) REFERENCES `storehouse` (`StoreHouse_id`),
  CONSTRAINT `FK_FK_RequisitionLeaveEmp_Emp` FOREIGN KEY (`OutboundEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_RequisitionLeave_Store` FOREIGN KEY (`OutboundStoreHouse`) REFERENCES `storehouse` (`StoreHouse_id`),
  CONSTRAINT `FK_FK_RequisitionReview_Emp` FOREIGN KEY (`ReviewEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_RequisitionReview_ReviewStatus` FOREIGN KEY (`ReviewStatus`) REFERENCES `reviewstatus` (`RS_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requisition
-- ----------------------------

-- ----------------------------
-- Table structure for requisitiondetail
-- ----------------------------
DROP TABLE IF EXISTS `requisitiondetail`;
CREATE TABLE `requisitiondetail` (
  `RE_id` int(11) NOT NULL AUTO_INCREMENT,
  `Requisition_id` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Count` int(11) NOT NULL,
  PRIMARY KEY (`RE_id`),
  KEY `FK_FK_Requisition_Pro` (`Product_id`),
  KEY `FK_FK_Requisition_RequDetail` (`Requisition_id`),
  CONSTRAINT `FK_FK_Requisition_Pro` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_FK_Requisition_RequDetail` FOREIGN KEY (`Requisition_id`) REFERENCES `requisition` (`Requisition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requisitiondetail
-- ----------------------------

-- ----------------------------
-- Table structure for reviewstatus
-- ----------------------------
DROP TABLE IF EXISTS `reviewstatus`;
CREATE TABLE `reviewstatus` (
  `RS_id` int(11) NOT NULL AUTO_INCREMENT,
  `RS_name` varchar(20) NOT NULL,
  PRIMARY KEY (`RS_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reviewstatus
-- ----------------------------
INSERT INTO `reviewstatus` VALUES ('1', '未审核');
INSERT INTO `reviewstatus` VALUES ('2', '审核通过');
INSERT INTO `reviewstatus` VALUES ('3', '审核未通过');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(50) NOT NULL,
  `Description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '采购员', '可以申请采购进货');
INSERT INTO `role` VALUES ('2', '采购部经理', '权限比采购员高 可以审核采购申请');

-- ----------------------------
-- Table structure for role_auth
-- ----------------------------
DROP TABLE IF EXISTS `role_auth`;
CREATE TABLE `role_auth` (
  `Role_Auth_id` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) NOT NULL,
  `Auth_id` int(11) DEFAULT NULL,
  `AuthId` int(11) NOT NULL,
  PRIMARY KEY (`Role_Auth_id`),
  KEY `FK_FK_AUTH_ROLEAUTH` (`Auth_id`),
  KEY `FK_FK_ROLE_ROLEAUTH` (`RoleId`),
  CONSTRAINT `FK_FK_AUTH_ROLEAUTH` FOREIGN KEY (`Auth_id`) REFERENCES `authority` (`Auth_id`),
  CONSTRAINT `FK_FK_ROLE_ROLEAUTH` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_auth
-- ----------------------------

-- ----------------------------
-- Table structure for salesorder
-- ----------------------------
DROP TABLE IF EXISTS `salesorder`;
CREATE TABLE `salesorder` (
  `SO_id` varchar(30) NOT NULL,
  `Employee_id` varchar(30) NOT NULL,
  `Customer_id` int(11) NOT NULL,
  `Sales_time` date NOT NULL,
  `Sales_price` decimal(10,0) NOT NULL,
  `ReviewEmp_id` varchar(30) DEFAULT NULL,
  `ReviewDate` date DEFAULT NULL,
  `ReviewStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`SO_id`),
  KEY `FK_FK_SalesOrderReivew_Emp` (`ReviewEmp_id`),
  KEY `FK_FK_SalesOrderReview_ReviewStatus` (`ReviewStatus`),
  KEY `FK_FK_SalesOrder_Customer` (`Customer_id`),
  KEY `FK_FK_SalesOrder_Emp` (`Employee_id`),
  CONSTRAINT `FK_FK_SalesOrderReivew_Emp` FOREIGN KEY (`ReviewEmp_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_SalesOrderReview_ReviewStatus` FOREIGN KEY (`ReviewStatus`) REFERENCES `reviewstatus` (`RS_id`),
  CONSTRAINT `FK_FK_SalesOrder_Customer` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`),
  CONSTRAINT `FK_FK_SalesOrder_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salesorder
-- ----------------------------

-- ----------------------------
-- Table structure for salesorderdetail
-- ----------------------------
DROP TABLE IF EXISTS `salesorderdetail`;
CREATE TABLE `salesorderdetail` (
  `SOD_id` int(11) NOT NULL AUTO_INCREMENT,
  `SalesOrder_id` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Count` int(11) NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`SOD_id`),
  KEY `FK_FK_SalesOrderDetail_Product` (`Product_id`),
  KEY `FK_FK_SalesOrder_SOD` (`SalesOrder_id`),
  CONSTRAINT `FK_FK_SalesOrderDetail_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_FK_SalesOrder_SOD` FOREIGN KEY (`SalesOrder_id`) REFERENCES `salesorder` (`SO_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salesorderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for stockpile
-- ----------------------------
DROP TABLE IF EXISTS `stockpile`;
CREATE TABLE `stockpile` (
  `SP_id` int(11) NOT NULL AUTO_INCREMENT,
  `StoreHouse_id` int(11) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `ProsPecification` varchar(30) DEFAULT NULL,
  `ProductUnit_id` int(11) DEFAULT NULL,
  `CostPrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`SP_id`),
  KEY `FK_FK_StockPile_ProductUnit` (`ProductUnit_id`),
  KEY `FK_FK_Stock_Product` (`Product_id`),
  KEY `FK_FK_StoreHouse_Stock` (`StoreHouse_id`),
  CONSTRAINT `FK_FK_StockPile_ProductUnit` FOREIGN KEY (`ProductUnit_id`) REFERENCES `productunit` (`ProductUnit_id`),
  CONSTRAINT `FK_FK_Stock_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_FK_StoreHouse_Stock` FOREIGN KEY (`StoreHouse_id`) REFERENCES `storehouse` (`StoreHouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockpile
-- ----------------------------

-- ----------------------------
-- Table structure for storehouse
-- ----------------------------
DROP TABLE IF EXISTS `storehouse`;
CREATE TABLE `storehouse` (
  `StoreHouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `SH_address` varchar(200) NOT NULL,
  `SH_phone` varchar(20) NOT NULL,
  `Employee_id` varchar(30) NOT NULL,
  `CreateDate` date NOT NULL,
  PRIMARY KEY (`StoreHouse_id`),
  KEY `FK_FK_StoreHouseEmp_Emp` (`Employee_id`),
  CONSTRAINT `FK_FK_StoreHouseEmp_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storehouse
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `Supplier_id` varchar(30) NOT NULL,
  `Supp_name` varchar(50) NOT NULL,
  `Supp_address` varchar(100) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `PostalCode` varchar(50) NOT NULL,
  `Supp_contact` varchar(50) NOT NULL,
  `SuppContactPho` varchar(50) NOT NULL,
  `SuppBank` varchar(50) NOT NULL,
  `SuppBankNum` varchar(50) NOT NULL,
  `Remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('GHS10001', '张三供货商', '徐州市泉山区', '18678927383', '221000', '李思思', '1987693827', '建设银行', '62102879838217328389', '主要售卖建材');

-- ----------------------------
-- Procedure structure for sum2
-- ----------------------------
DROP PROCEDURE IF EXISTS `sum2`;
DELIMITER ;;
CREATE DEFINER=`skip-grants user`@`skip-grants host` PROCEDURE `sum2`(a int)
begin
         declare sum int default 0;
        declare i int default 1;
         loop_name:loop -- 循环开始
           if i>a then 
                leave loop_name;  -- 判断条件成立则结束循环  好比java中的 boeak
            end if;
             set sum=sum+i;
            set i=i+1;
         end loop;  -- 循环结束
         select sum; -- 输出结果
 end
;;
DELIMITER ;
