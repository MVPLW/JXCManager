/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : jxcdb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-18 08:55:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for backsales
-- ----------------------------
DROP TABLE IF EXISTS `backsales`;
CREATE TABLE `backsales` (
  `BSA_id` varchar(30) NOT NULL,
  `Customer_id` int(11) NOT NULL,
  `RequestDate` date NOT NULL,
  `ReviewEmp` varchar(30) DEFAULT NULL,
  `ReviewState` int(11) DEFAULT NULL,
  `BackReason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BSA_id`),
  KEY `FK_Customer` (`Customer_id`),
  KEY `FK_reviewEmp` (`ReviewEmp`),
  CONSTRAINT `FK_Customer` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`),
  CONSTRAINT `FK_reviewEmp` FOREIGN KEY (`ReviewEmp`) REFERENCES `employee` (`EmpLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backsales
-- ----------------------------
INSERT INTO `backsales` VALUES ('THHS8e738373584748', '18392', '2018-04-04', 'rose', '1', '今天周二');
INSERT INTO `backsales` VALUES ('THSIO393474923283738', '18392', '2018-04-08', null, null, '哈哈哈');

-- ----------------------------
-- Table structure for backsalesdetail
-- ----------------------------
DROP TABLE IF EXISTS `backsalesdetail`;
CREATE TABLE `backsalesdetail` (
  `BSAD_id` int(11) NOT NULL AUTO_INCREMENT,
  `bs` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Productunitid` int(11) NOT NULL,
  `price` double(10,2) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`BSAD_id`),
  KEY `FK_BackSales` (`bs`),
  KEY `FK_product` (`Product_id`),
  KEY `FK_productUnit_s` (`Productunitid`),
  CONSTRAINT `FK_BackSales` FOREIGN KEY (`bs`) REFERENCES `backsales` (`BSA_id`),
  CONSTRAINT `FK_product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_productUnit_s` FOREIGN KEY (`Productunitid`) REFERENCES `productunit` (`ProductUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backsalesdetail
-- ----------------------------
INSERT INTO `backsalesdetail` VALUES ('1', 'THHS8e738373584748', 'CPS-10001', '1', null, '2');
INSERT INTO `backsalesdetail` VALUES ('2', 'THHS8e738373584748', 'CPS-10003', '2', null, '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=18393 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('18392', '哈哈哈', '徐州市', '2938372', '221000', '战汉');

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
  `EmpLoginPwd` varchar(60) NOT NULL,
  `EmpName` varchar(30) NOT NULL,
  `DeptId` int(11) NOT NULL,
  `JoinDate` date NOT NULL,
  `Gender` varchar(2) NOT NULL,
  `Birthday` date NOT NULL,
  `Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  PRIMARY KEY (`EmpLoginName`),
  KEY `FK_FK_EMP_DEPT` (`DeptId`),
  CONSTRAINT `FK_FK_EMP_DEPT` FOREIGN KEY (`DeptId`) REFERENCES `dept` (`DeptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('james', '202cb962ac59075b964b07152d234b70', '詹姆斯', '4', '2010-02-01', '男', '1994-06-14', '江苏省南京市', '17683728192', 'abc@163.com');
INSERT INTO `employee` VALUES ('jinying', '202cb962ac59075b964b07152d234b70', '煞笔', '1', '2018-04-09', '男', '2018-04-09', '阿双方打底衫', '23847636', '454dfd');
INSERT INTO `employee` VALUES ('Jordan', '202cb962ac59075b964b07152d234b70', '乔丹', '4', '2018-04-02', '女', '2015-11-11', '美国洛杉矶', '19383734', '837344593@qq.com');
INSERT INTO `employee` VALUES ('rose', '202cb962ac59075b964b07152d234b70', '罗斯', '3', '2015-03-04', '男', '1991-06-04', '徐州泉山区', '19787283921', '5241593@qq.com');
INSERT INTO `employee` VALUES ('wade', '202cb962ac59075b964b07152d234b70', '哓擎', '3', '2016-10-26', '男', '1996-04-16', '江苏省徐州市', '18796284434', 'lxq413@126.com');

-- ----------------------------
-- Table structure for employeerole
-- ----------------------------
DROP TABLE IF EXISTS `employeerole`;
CREATE TABLE `employeerole` (
  `EmployeeRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) NOT NULL,
  `EmpLoginName` varchar(30) NOT NULL,
  PRIMARY KEY (`EmployeeRoleId`),
  KEY `FK_Role` (`RoleId`),
  KEY `FK_Emp` (`EmpLoginName`),
  CONSTRAINT `FK_Emp` FOREIGN KEY (`EmpLoginName`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_Role` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeerole
-- ----------------------------
INSERT INTO `employeerole` VALUES ('8', '2', 'jinying');
INSERT INTO `employeerole` VALUES ('9', '2', 'wade');
INSERT INTO `employeerole` VALUES ('10', '3', 'wade');
INSERT INTO `employeerole` VALUES ('11', '4', 'wade');
INSERT INTO `employeerole` VALUES ('12', '5', 'wade');
INSERT INTO `employeerole` VALUES ('13', '6', 'wade');
INSERT INTO `employeerole` VALUES ('15', '8', 'wade');
INSERT INTO `employeerole` VALUES ('16', '9', 'wade');

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
  `ReviewEmp` varchar(30) DEFAULT NULL,
  `ReviewDate` date DEFAULT NULL,
  `ReviewStatus` int(11) DEFAULT NULL,
  `ReviewReason` varchar(255) DEFAULT NULL,
  `Remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EnterStock_id`),
  KEY `FK_FK_EnterStoreEmp_Emp` (`Employee_id`),
  KEY `FK_FK_EnterStore_Store` (`StoreHouse_id`),
  KEY `FK_FK_EnterStore_Type` (`EnterStockType_id`),
  KEY `FK_ReviewEmp_Emp` (`ReviewEmp`),
  KEY `FK_ReviewStatus` (`ReviewStatus`),
  CONSTRAINT `FK_FK_EnterStoreEmp_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_FK_EnterStore_Store` FOREIGN KEY (`StoreHouse_id`) REFERENCES `storehouse` (`StoreHouse_id`),
  CONSTRAINT `FK_FK_EnterStore_Type` FOREIGN KEY (`EnterStockType_id`) REFERENCES `enterstocktype` (`EST_id`),
  CONSTRAINT `FK_ReviewEmp_Emp` FOREIGN KEY (`ReviewEmp`) REFERENCES `employee` (`EmpLoginName`),
  CONSTRAINT `FK_ReviewStatus` FOREIGN KEY (`ReviewStatus`) REFERENCES `reviewstatus` (`RS_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterstock
-- ----------------------------
INSERT INTO `enterstock` VALUES ('RKRYEW041302470089244', '4', 'james', '2018-04-13', '1', 'CGHDMR041010550061856', 'wade', '2018-04-13', '2', '地方地方', '');
INSERT INTO `enterstock` VALUES ('RKUMHD041302310507481', '4', 'jinying', '2018-04-13', '2', 'THHS8e738373584748', 'wade', '2018-04-16', '3', 'dsafd', '');

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
  `ProductUnit_id` int(11) NOT NULL,
  `ShouldCount` int(11) NOT NULL,
  PRIMARY KEY (`SP_id`),
  KEY `FK_EnterStoreDetail_Product` (`Product_id`),
  KEY `FK_EnterStore_EnterStoreDetail` (`EnterStock_id`),
  KEY `FK_ProductUnit_Unit` (`ProductUnit_id`),
  CONSTRAINT `FK_EnterStoreDetail_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_EnterStore_EnterStoreDetail` FOREIGN KEY (`EnterStock_id`) REFERENCES `enterstock` (`EnterStock_id`),
  CONSTRAINT `FK_ProductUnit_Unit` FOREIGN KEY (`ProductUnit_id`) REFERENCES `productunit` (`ProductUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterstockdetail
-- ----------------------------
INSERT INTO `enterstockdetail` VALUES ('20', 'RKUMHD041302310507481', 'CPS-10001', '1', '0', '1', '2');
INSERT INTO `enterstockdetail` VALUES ('21', 'RKUMHD041302310507481', 'CPS-10003', '2', '0', '2', '2');
INSERT INTO `enterstockdetail` VALUES ('22', 'RKRYEW041302470089244', 'CPS-21908', '2', '0', '2', '2');
INSERT INTO `enterstockdetail` VALUES ('23', 'RKRYEW041302470089244', 'CPS-10001', '2', '0', '1', '2');

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
  `ProductUnit_id` int(11) NOT NULL,
  PRIMARY KEY (`LSD_id`),
  KEY `FK_LeaveStoreDetail_Product` (`Product_id`),
  KEY `FK_LeaveStore_LeaveStoreDetail` (`LeaveStock_id`),
  KEY `FK_ProductUnit_PUnit` (`ProductUnit_id`),
  CONSTRAINT `FK_LeaveStoreDetail_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_LeaveStore_LeaveStoreDetail` FOREIGN KEY (`LeaveStock_id`) REFERENCES `leavestock` (`LS_id`),
  CONSTRAINT `FK_ProductUnit_PUnit` FOREIGN KEY (`ProductUnit_id`) REFERENCES `productunit` (`ProductUnit_id`)
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
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `Permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `PermissionDesc` varchar(255) NOT NULL,
  `PermissionUrl` varchar(255) NOT NULL,
  `IsNavi` int(11) NOT NULL,
  `PermissionCode` varchar(255) NOT NULL,
  PRIMARY KEY (`Permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '采购单', '/gopurchase', '1', 'purchase:list');
INSERT INTO `permission` VALUES ('2', '添加采购单', '/goPurchaseRequest', '0', 'purchase:add');
INSERT INTO `permission` VALUES ('3', '修改采购单', '/goPurchaseUpdate', '0', 'purchase:update');
INSERT INTO `permission` VALUES ('4', '部门审核采购单', '/deptReview', '0', 'purchase:deptreview');
INSERT INTO `permission` VALUES ('5', '财务审核采购单', '/finalReview', '0', 'purchase:finalreview');
INSERT INTO `permission` VALUES ('6', '删除采购单', '/deletePurchases', '0', 'purchase:delete');
INSERT INTO `permission` VALUES ('7', '查看角色', '/goRole', '0', 'role:list');
INSERT INTO `permission` VALUES ('8', '添加角色', '/goRoleAdd', '0', 'role:add');
INSERT INTO `permission` VALUES ('9', '删除角色', '/goRoleDelete', '0', 'role:delete');
INSERT INTO `permission` VALUES ('10', '修改角色', '/goRoleUpdate', '0', 'role:update');
INSERT INTO `permission` VALUES ('11', '查看员工', '/goEmployee', '0', 'employee:list');
INSERT INTO `permission` VALUES ('12', '添加员工', '/goEmployeeAdd', '0', 'employee:add');
INSERT INTO `permission` VALUES ('13', '修改员工', '/goEmployeeUpdate', '0', 'employee:update');
INSERT INTO `permission` VALUES ('14', '删除员工', '/goEmployeeDelete', '0', 'employee:delete');
INSERT INTO `permission` VALUES ('15', '销售单', '/gosales', '1', 'sales:list');
INSERT INTO `permission` VALUES ('16', '新增销售单', '/goSalesAdd', '0', 'sales:add');
INSERT INTO `permission` VALUES ('17', '修改销售单', '/goSalesUpdate', '0', 'sales:update');
INSERT INTO `permission` VALUES ('18', '删除销售单', '/goSalesDelete', '0', 'sales:delete');
INSERT INTO `permission` VALUES ('19', '审核销售单', '/goSalesReview', '0', 'sales:review');
INSERT INTO `permission` VALUES ('20', '报损单', '/godamaged', '1', 'damaged:list');
INSERT INTO `permission` VALUES ('21', '新增报损单', '/goDamagedAdd', '0', 'damaged:add');
INSERT INTO `permission` VALUES ('22', '修改报损单', '/goDamagedUpdate', '0', 'damaged:update');
INSERT INTO `permission` VALUES ('23', '删除报损单', '/goDamagedDelete', '0', 'damaged:delete');
INSERT INTO `permission` VALUES ('24', '审核报损单', '/goDamagedReview', '0', 'damaged:review');
INSERT INTO `permission` VALUES ('25', '入库单', '/goenterstock', '1', 'enterstock:list');
INSERT INTO `permission` VALUES ('26', '新增入库单', '/goEnterStockAdd', '0', 'enterstock:add');
INSERT INTO `permission` VALUES ('27', '修改入库单', '/goEnterStockUpdate', '0', 'enterstock:update');
INSERT INTO `permission` VALUES ('28', '删除入库单', '/goEnterStockDelete', '0', 'enterstock:delete');
INSERT INTO `permission` VALUES ('29', '审核入库单', '/goEnterStockReview', '0', 'enterstock:review');
INSERT INTO `permission` VALUES ('30', '调拨单', '/gorequisition', '1', 'requisition:review');
INSERT INTO `permission` VALUES ('31', '新增调拨单', '/goRequisitionAdd', '0', 'requisition:add');
INSERT INTO `permission` VALUES ('32', '修改调拨单', '/goRequisitionUpdate', '0', 'requisition:update');
INSERT INTO `permission` VALUES ('33', '删除调拨单', '/goRequisitionDelete', '0', 'requisition:delete');
INSERT INTO `permission` VALUES ('34', '审核调拨单', '/goRequisitionReview', '0', 'requisition:review');
INSERT INTO `permission` VALUES ('35', '资源管理', '/gopermission', '0', 'permission:list');
INSERT INTO `permission` VALUES ('36', '新增资源', '/gopermissionAdd', '0', 'permission:add');
INSERT INTO `permission` VALUES ('37', '修改资源', '/gopermissionUpdate', '0', 'permission:update');
INSERT INTO `permission` VALUES ('38', '删除资源', '/gopermissionDelete', '0', 'permission:delete');

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
  `DeptReviewReason` varchar(255) DEFAULT NULL,
  `FinancialAuditStatus` int(11) DEFAULT NULL,
  `FinancialAuditTime` date DEFAULT NULL,
  `FinancialAuditEmp` varchar(30) DEFAULT NULL,
  `FinancialAuditReason` varchar(255) DEFAULT NULL,
  `Remark` varchar(255) DEFAULT NULL,
  `OrderStatus` int(8) DEFAULT NULL,
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
INSERT INTO `purchaserequest` VALUES ('CGBOVI032004210234394', 'wade', '2018-03-07', 'GHS10001', '394', 'sfsdf', '2', '2018-06-02', 'wade', '今天周二', '1', '2018-03-16', 'wade', null, '394第一个单子是；打飞机收电费卡；阿斯顿；飞纪委批复件；而是离开发的刷卡缴费四海鼎沸飞斯蒂芬开户金额疯狂送飞机；撒快递费飞肥婆巨额额罚款交多少方解石方式几十块交罚款单数据库都是', '2');
INSERT INTO `purchaserequest` VALUES ('CGEJQA050403470083212', 'rose', '2018-05-01', 'GHS10902', '张三', '1837498472', '3', '2018-05-04', 'wade', '萨芬地方', '1', null, null, null, '今天周二', '5');
INSERT INTO `purchaserequest` VALUES ('CGGTST042001190444967', 'jinying', '2018-04-20', 'GHS10001', '张三', '18796284456', '2', '2018-05-04', 'wade', '是的', '2', '2018-05-04', 'wade', '是多少', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', '7');
INSERT INTO `purchaserequest` VALUES ('CGHCCY032809540465676', 'rose', '2018-03-01', 'GHS10902', '朱军', '19762983728', '1', null, null, null, '1', null, null, null, '676阿斯顿；罚款交多少发；束带结发卡戴珊分萨拉丁；封孔剂；里多撒卡缴费就；发斯蒂芬实得分但是飞', '2');
INSERT INTO `purchaserequest` VALUES ('CGHDMR041010550061856', 'jinying', '2018-04-02', 'GHS10001', '张三', '4585145624', '1', null, null, null, '1', null, null, null, '及同年你这偶然', '1');
INSERT INTO `purchaserequest` VALUES ('CGKTIJ041709490105728', 'jinying', '2018-04-17', 'GHS10902', '张三', '18796284456', '1', null, null, null, '1', null, null, null, '今天周二', '1');
INSERT INTO `purchaserequest` VALUES ('CGMXIZ032708500014915', 'rose', '2018-03-27', 'GHS10902', '李刚', '186936283621', '2', '2018-04-02', 'wade', '阿斯顿发大水', '2', '2018-04-02', 'wade', '今天周二', '915adsfdsf爱的色放发的第三方', '7');
INSERT INTO `purchaserequest` VALUES ('CGRCTQ041910080064518', 'jinying', '2018-04-19', 'GHS10001', '张三', '18796284456', '2', '2018-05-07', 'wade', 'sdf', '2', '2018-05-07', 'wade', 'asdf', '今天周二', '6');
INSERT INTO `purchaserequest` VALUES ('CGSDFDF129383483', 'wade', '2016-09-08', 'GHS10001', '张三今天周二123', '1592383492', '1', null, null, null, '1', null, null, null, '明天周三三水水水水水水水水水水水水水', '3');
INSERT INTO `purchaserequest` VALUES ('CGSPXO032809550233525', 'james', '2018-03-03', 'GHS10001', '大爷', '19374837293', '3', '2018-04-02', 'wade', '今天周二', '1', null, null, null, '525阿三；李的会计法撒旦教父；科技大厦飞；阿斯蒂芬卡戴珊', '5');
INSERT INTO `purchaserequest` VALUES ('CGVHMC040302380319951', 'wade', '2018-04-03', 'GHS10001', '的地方过分', '2343543', '1', null, null, null, '1', null, null, null, '地方', '3');
INSERT INTO `purchaserequest` VALUES ('CGZZNZ033012140135319', 'wade', '2018-03-30', 'GHS10001', '靳颖', '1542156456', '2', '2018-04-02', 'wade', '今天周二', '2', '2018-04-02', 'wade', '哈哈哈', '今天卡将地方；看桑德菲杰倒扣分', '6');

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
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaserequestdetail
-- ----------------------------
INSERT INTO `purchaserequestdetail` VALUES ('2', 'CGBOVI032004210234394', 'CPS-10004', '7', '4', '3.40');
INSERT INTO `purchaserequestdetail` VALUES ('3', 'CGBOVI032004210234394', 'CPS-10034', '5', '5', null);
INSERT INTO `purchaserequestdetail` VALUES ('6', 'CGMXIZ032708500014915', 'CPS-10004', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('7', 'CGMXIZ032708500014915', 'CPS-10002', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('9', 'CGMXIZ032708500014915', 'CPS-10034', '5', '4', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('10', 'CGMXIZ032708500014915', 'CPS-11084', '3', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('11', 'CGHCCY032809540465676', 'CPS-10004', '3', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('12', 'CGHCCY032809540465676', 'CPS-10034', '2', '4', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('13', 'CGHCCY032809540465676', 'CPS-11084', '5', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('14', 'CGSPXO032809550233525', 'CPS-10004', '3', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('15', 'CGSPXO032809550233525', 'CPS-10002', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('16', 'CGSPXO032809550233525', 'CPS-10003', '4', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('17', 'CGZZNZ033012140135319', 'CPS-10004', '3', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('18', 'CGZZNZ033012140135319', 'CPS-10002', '1', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('19', 'CGZZNZ033012140135319', 'CPS-10003', '4', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('20', 'CGZZNZ033012140135319', 'CPS-10034', '4', '4', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('21', 'CGZZNZ033012140135319', 'CPS-11084', '4', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('54', 'CGSDFDF129383483', 'CPS-10003', '1', '6', '12.00');
INSERT INTO `purchaserequestdetail` VALUES ('55', 'CGSDFDF129383483', 'CPS-10002', '3', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('56', 'CGSDFDF129383483', 'CPS-11084', '2', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('57', 'CGSDFDF129383483', 'CPS-10001', '3', '1', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('66', 'CGVHMC040302380319951', 'CPS-10004', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('67', 'CGVHMC040302380319951', 'CPS-10002', '3', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('68', 'CGVHMC040302380319951', 'CPS-10003', '4', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('69', 'CGVHMC040302380319951', 'CPS-10034', '4', '4', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('70', 'CGVHMC040302380319951', 'CPS-11084', '4', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('71', 'CGHDMR041010550061856', 'CPS-21908', '2', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('72', 'CGHDMR041010550061856', 'CPS-10001', '2', '1', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('78', 'CGKTIJ041709490105728', 'CPS-10004', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('79', 'CGKTIJ041709490105728', 'CPS-10002', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('80', 'CGKTIJ041709490105728', 'CPS-10003', '1', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('81', 'CGKTIJ041709490105728', 'CPS-10034', '3', '4', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('82', 'CGKTIJ041709490105728', 'CPS-11084', '2', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('83', 'CGRCTQ041910080064518', 'CPS-10004', '1', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('84', 'CGRCTQ041910080064518', 'CPS-10002', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('85', 'CGRCTQ041910080064518', 'CPS-10003', '3', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('86', 'CGRCTQ041910080064518', 'CPS-10034', '4', '4', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('87', 'CGRCTQ041910080064518', 'CPS-11084', '5', '2', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('88', 'CGGTST042001190444967', 'CPS-10004', '1', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('89', 'CGGTST042001190444967', 'CPS-10002', '1', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('90', 'CGGTST042001190444967', 'CPS-10003', '1', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('91', 'CGGTST042001190444967', 'CPS-10034', '1', '4', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('96', 'CGEJQA050403470083212', 'CPS-10004', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('97', 'CGEJQA050403470083212', 'CPS-10002', '2', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('98', 'CGEJQA050403470083212', 'CPS-10003', '3', '6', '0.00');
INSERT INTO `purchaserequestdetail` VALUES ('99', 'CGEJQA050403470083212', 'CPS-10034', '1', '4', '0.00');

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
INSERT INTO `requisition` VALUES ('DBRMWF040810290442633', 'jinying', '2018-04-08', null, null, '1', '1', null, null, '1', null, null);
INSERT INTO `requisition` VALUES ('DBTOZC040410490419528', 'jinying', '2018-04-03', null, null, '1', '1', null, null, '1', null, null);
INSERT INTO `requisition` VALUES ('DBYEJA040501540359351', 'jinying', '2018-04-05', null, null, '1', '2', null, null, '2', null, null);
INSERT INTO `requisition` VALUES ('DBZUUI040311220008363', 'rose', '2018-04-03', null, null, '1', '1', null, null, '1', null, null);

-- ----------------------------
-- Table structure for requisitiondetail
-- ----------------------------
DROP TABLE IF EXISTS `requisitiondetail`;
CREATE TABLE `requisitiondetail` (
  `RE_id` int(11) NOT NULL AUTO_INCREMENT,
  `Requisition_id` varchar(30) NOT NULL,
  `Product_id` varchar(30) NOT NULL,
  `Count` int(11) NOT NULL,
  `ProductUnitId` int(11) NOT NULL,
  PRIMARY KEY (`RE_id`),
  KEY `FK_FK_Requisition_Pro` (`Product_id`),
  KEY `FK_FK_Requisition_RequDetail` (`Requisition_id`),
  KEY `FK_ProductUnit` (`ProductUnitId`),
  CONSTRAINT `FK_FK_Requisition_Pro` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_FK_Requisition_RequDetail` FOREIGN KEY (`Requisition_id`) REFERENCES `requisition` (`Requisition_id`),
  CONSTRAINT `FK_ProductUnit` FOREIGN KEY (`ProductUnitId`) REFERENCES `productunit` (`ProductUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requisitiondetail
-- ----------------------------
INSERT INTO `requisitiondetail` VALUES ('35', 'DBTOZC040410490419528', 'CPS-10004', '2', '6');

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
INSERT INTO `reviewstatus` VALUES ('3', '审核拒绝');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(50) NOT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `RoleCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', '采购部经理', '权限比采购员高 可以审核采购申请', null);
INSERT INTO `role` VALUES ('3', '销售员', '销售货物', null);
INSERT INTO `role` VALUES ('4', '销售经理', '可以审核销售单', null);
INSERT INTO `role` VALUES ('5', '仓库管理员', '管理仓库', null);
INSERT INTO `role` VALUES ('6', '采购员', '可以申请采购进货', null);
INSERT INTO `role` VALUES ('8', '人事', '人员信息的增删改', null);
INSERT INTO `role` VALUES ('9', '仓管经理', '审核调拨单 删除之类的权限', null);
INSERT INTO `role` VALUES ('11', 'test1', '123', '123');
INSERT INTO `role` VALUES ('12', 'test2', '123', '123');
INSERT INTO `role` VALUES ('13', 'test4', '123', '123');

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `Role_Permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) NOT NULL,
  `PermissionId` int(11) NOT NULL,
  PRIMARY KEY (`Role_Permission_id`),
  KEY `FK_RolePermission_Role` (`RoleId`),
  KEY `FK_RolePermission_Permission` (`PermissionId`),
  CONSTRAINT `FK_RolePermission_Permission` FOREIGN KEY (`PermissionId`) REFERENCES `permission` (`Permission_id`),
  CONSTRAINT `FK_RolePermission_Role` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('9', '2', '2');
INSERT INTO `rolepermission` VALUES ('10', '2', '1');
INSERT INTO `rolepermission` VALUES ('11', '2', '3');
INSERT INTO `rolepermission` VALUES ('12', '2', '4');
INSERT INTO `rolepermission` VALUES ('13', '2', '5');
INSERT INTO `rolepermission` VALUES ('14', '6', '1');
INSERT INTO `rolepermission` VALUES ('15', '6', '2');
INSERT INTO `rolepermission` VALUES ('16', '6', '3');
INSERT INTO `rolepermission` VALUES ('18', '2', '6');
INSERT INTO `rolepermission` VALUES ('19', '3', '16');
INSERT INTO `rolepermission` VALUES ('20', '3', '17');
INSERT INTO `rolepermission` VALUES ('21', '3', '15');
INSERT INTO `rolepermission` VALUES ('22', '4', '15');
INSERT INTO `rolepermission` VALUES ('23', '4', '16');
INSERT INTO `rolepermission` VALUES ('24', '4', '17');
INSERT INTO `rolepermission` VALUES ('25', '4', '18');
INSERT INTO `rolepermission` VALUES ('26', '4', '19');
INSERT INTO `rolepermission` VALUES ('27', '5', '20');
INSERT INTO `rolepermission` VALUES ('28', '5', '21');
INSERT INTO `rolepermission` VALUES ('29', '5', '22');
INSERT INTO `rolepermission` VALUES ('30', '9', '23');
INSERT INTO `rolepermission` VALUES ('31', '9', '20');
INSERT INTO `rolepermission` VALUES ('32', '9', '21');
INSERT INTO `rolepermission` VALUES ('33', '9', '22');
INSERT INTO `rolepermission` VALUES ('34', '9', '24');
INSERT INTO `rolepermission` VALUES ('35', '5', '25');
INSERT INTO `rolepermission` VALUES ('36', '5', '26');
INSERT INTO `rolepermission` VALUES ('37', '5', '27');
INSERT INTO `rolepermission` VALUES ('38', '5', '30');
INSERT INTO `rolepermission` VALUES ('39', '5', '31');
INSERT INTO `rolepermission` VALUES ('40', '5', '32');
INSERT INTO `rolepermission` VALUES ('41', '9', '25');
INSERT INTO `rolepermission` VALUES ('42', '9', '26');
INSERT INTO `rolepermission` VALUES ('43', '9', '27');
INSERT INTO `rolepermission` VALUES ('44', '9', '28');
INSERT INTO `rolepermission` VALUES ('45', '9', '29');
INSERT INTO `rolepermission` VALUES ('46', '9', '30');
INSERT INTO `rolepermission` VALUES ('47', '9', '31');
INSERT INTO `rolepermission` VALUES ('48', '9', '32');
INSERT INTO `rolepermission` VALUES ('49', '9', '33');
INSERT INTO `rolepermission` VALUES ('50', '9', '34');
INSERT INTO `rolepermission` VALUES ('51', '8', '7');
INSERT INTO `rolepermission` VALUES ('52', '8', '8');
INSERT INTO `rolepermission` VALUES ('53', '8', '9');
INSERT INTO `rolepermission` VALUES ('54', '8', '10');
INSERT INTO `rolepermission` VALUES ('55', '8', '11');
INSERT INTO `rolepermission` VALUES ('56', '8', '12');
INSERT INTO `rolepermission` VALUES ('57', '8', '13');
INSERT INTO `rolepermission` VALUES ('58', '8', '14');
INSERT INTO `rolepermission` VALUES ('63', '11', '1');
INSERT INTO `rolepermission` VALUES ('64', '11', '30');
INSERT INTO `rolepermission` VALUES ('65', '11', '34');
INSERT INTO `rolepermission` VALUES ('66', '8', '35');
INSERT INTO `rolepermission` VALUES ('67', '8', '36');
INSERT INTO `rolepermission` VALUES ('68', '8', '37');
INSERT INTO `rolepermission` VALUES ('69', '8', '38');

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
  `ProductUnit_id` int(11) NOT NULL,
  PRIMARY KEY (`SOD_id`),
  KEY `FK_SalesOrderDetail_Product` (`Product_id`),
  KEY `FK_SalesOrder_SOD` (`SalesOrder_id`),
  KEY `FK_ProductUnit_ProductUnitId` (`ProductUnit_id`),
  CONSTRAINT `FK_ProductUnit_ProductUnitId` FOREIGN KEY (`ProductUnit_id`) REFERENCES `productunit` (`ProductUnit_id`),
  CONSTRAINT `FK_SalesOrderDetail_Product` FOREIGN KEY (`Product_id`) REFERENCES `product` (`Product_id`),
  CONSTRAINT `FK_SalesOrder_SOD` FOREIGN KEY (`SalesOrder_id`) REFERENCES `salesorder` (`SO_id`)
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockpile
-- ----------------------------
INSERT INTO `stockpile` VALUES ('1', '1', 'CPS-10003', '12', '12', '3', '12');

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
  `SH_Name` varchar(255) NOT NULL,
  PRIMARY KEY (`StoreHouse_id`),
  KEY `FK_FK_StoreHouseEmp_Emp` (`Employee_id`),
  CONSTRAINT `FK_FK_StoreHouseEmp_Emp` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`EmpLoginName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storehouse
-- ----------------------------
INSERT INTO `storehouse` VALUES ('1', '徐州沛县', '15837283928', 'wade', '2018-04-03', '时光仓库');
INSERT INTO `storehouse` VALUES ('2', '泉山区', '39484729', 'rose', '2018-04-06', '周二库');
INSERT INTO `storehouse` VALUES ('3', '云龙区', '29473628181', 'wade', '2018-04-03', '周三库');
INSERT INTO `storehouse` VALUES ('4', '哈哈哈', '28473629132', 'james', '2018-04-01', '周天');

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
INSERT INTO `supplier` VALUES ('GHS10902', '徐州建材公司', '沛县', '13762892827', '221001', '李刚', '1983739928', '工商银行', '68397383928393727388', '售卖水泥钢材等等');
