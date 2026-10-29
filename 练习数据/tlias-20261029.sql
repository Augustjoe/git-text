-- MySQL dump 10.13  Distrib 26.7.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tlias
-- ------------------------------------------------------
-- Server version	26.7.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `tlias`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `tlias` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tlias`;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (1,'学工部','2024-09-25 09:47:40','2024-09-25 09:47:40');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (2,'教研部','2024-09-25 09:47:40','2024-09-09 15:17:04');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (3,'咨询部','2024-09-25 09:47:40','2024-09-30 21:26:24');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (4,'就业部','2024-09-25 09:47:40','2024-09-25 09:47:40');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (5,'人事部','2024-09-25 09:47:40','2024-09-25 09:47:40');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (8,'财务部','2026-09-29 14:44:45','2026-09-29 15:47:32');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint unsigned NOT NULL COMMENT '性别，1:男，2:女',
  `phone` char(11) NOT NULL COMMENT '手机号',
  `job` tinyint unsigned DEFAULT NULL COMMENT '职位，1:班主任，2:讲师...',
  `salary` int unsigned DEFAULT NULL COMMENT '薪资',
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `entry_date` date DEFAULT NULL COMMENT '入职日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `dept_id` int unsigned DEFAULT NULL COMMENT '关联的部门ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`),
  KEY `fk_emp_dept_id` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (1,'emp001','123456','张三',1,'13900000001',1,8500,NULL,'2022-03-15','2026-10-10 11:17:44','2026-10-10 11:17:44',1);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (2,'emp002','123456','李四',1,'13900000002',1,9200,NULL,'2021-06-10','2026-10-10 11:17:44','2026-10-10 11:17:44',1);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (3,'emp003','123456','王丽',2,'13900000003',3,12000,NULL,'2020-09-01','2026-10-10 11:17:44','2026-10-10 11:17:44',1);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (4,'emp004','123456','赵敏',2,'13900000004',1,7800,NULL,'2023-04-12','2026-10-10 11:17:44','2026-10-10 11:17:44',1);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (5,'emp005','123456','孙强',1,'13900000005',1,8800,NULL,'2022-11-20','2026-10-10 11:17:44','2026-10-10 11:17:44',1);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (6,'emp006','123456','周杰',1,'13900000006',2,15000,NULL,'2020-05-18','2026-10-10 11:17:44','2026-10-10 11:17:44',2);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (7,'emp007','123456','吴芳',2,'13900000007',2,13500,NULL,'2021-08-22','2026-10-10 11:17:44','2026-10-10 11:17:44',2);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (8,'emp008','123456','郑伟',1,'13900000008',4,22000,NULL,'2019-03-10','2026-10-10 11:17:44','2026-10-10 11:17:44',2);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (9,'emp009','123456','陈静',2,'13900000009',2,16000,NULL,'2022-07-15','2026-10-10 11:17:44','2026-10-10 11:17:44',2);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (10,'emp010','123456','刘洋',1,'13900000010',2,14500,NULL,'2023-01-08','2026-10-10 11:17:44','2026-10-10 11:17:44',2);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (11,'emp011','123456','黄涛',1,'13900000011',5,11000,NULL,'2021-04-06','2026-10-10 11:17:44','2026-10-10 11:17:44',3);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (12,'emp012','123456','杨雪',2,'13900000012',5,10500,NULL,'2022-02-16','2026-10-10 11:17:44','2026-10-10 11:17:44',3);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (13,'emp013','123456','何明',1,'13900000013',5,12500,NULL,'2020-10-12','2026-10-10 11:17:44','2026-10-10 11:17:44',3);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (14,'emp014','123456','高洁',2,'13900000014',5,9800,NULL,'2024-03-05','2026-10-10 11:17:44','2026-10-10 11:17:44',3);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (15,'emp015','123456','林峰',1,'13900000015',NULL,11500,NULL,'2022-06-18','2026-10-10 11:17:44','2026-10-10 11:17:44',4);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (16,'emp016','123456','徐静',2,'13900000016',NULL,10800,NULL,'2021-09-20','2026-10-10 11:17:44','2026-10-10 11:17:44',4);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (17,'emp017','123456','罗军',1,'13900000017',NULL,13000,NULL,'2020-12-08','2026-10-10 11:17:44','2026-10-10 11:17:44',4);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (18,'emp018','123456','宋佳',2,'13900000018',NULL,9500,NULL,'2023-07-11','2026-10-10 11:17:44','2026-10-10 11:17:44',4);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (19,'emp019','123456','唐莉',2,'13900000019',NULL,12000,NULL,'2021-05-14','2026-10-10 11:17:44','2026-10-10 11:17:44',5);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (20,'emp020','123456','邓超',1,'13900000020',NULL,11000,NULL,'2022-08-09','2026-10-10 11:17:44','2026-10-10 11:17:44',5);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (21,'emp021','123456','谢敏',2,'13900000021',NULL,14500,NULL,'2020-03-16','2026-10-10 11:17:44','2026-10-10 11:17:44',5);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (22,'emp022','123456','曹磊',1,'13900000022',NULL,9800,NULL,'2024-01-22','2026-10-10 11:17:44','2026-10-10 11:17:44',5);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (23,'emp023','123456','彭丽',2,'13900000023',NULL,12500,NULL,'2026-10-01','2026-10-10 11:17:44','2026-10-10 11:17:44',8);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (24,'emp024','123456','潘伟',1,'13900000024',NULL,15000,NULL,'2026-10-03','2026-10-10 11:17:44','2026-10-10 11:17:44',8);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (25,'emp025','123456','冯雪',2,'13900000025',NULL,13500,NULL,'2026-10-06','2026-10-10 11:17:44','2026-10-10 11:17:44',8);
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `phone`, `job`, `salary`, `image`, `entry_date`, `create_time`, `update_time`, `dept_id`) VALUES (26,'java_test_1026_01','Test123456','测试员工甲',1,'13900001026',2,9000,'','2026-10-26','2026-10-26 16:00:43','2026-10-26 16:00:43',1);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_expr`
--

DROP TABLE IF EXISTS `emp_expr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_expr` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID 主键',
  `begin` date DEFAULT NULL COMMENT '开始时间',
  `end` date DEFAULT NULL COMMENT '结束时间',
  `company` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `job` varchar(50) DEFAULT NULL COMMENT '工作名称',
  `emp_id` int unsigned DEFAULT NULL COMMENT '员工ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_expr`
--

LOCK TABLES `emp_expr` WRITE;
/*!40000 ALTER TABLE `emp_expr` DISABLE KEYS */;
INSERT INTO `emp_expr` (`id`, `begin`, `end`, `company`, `job`, `emp_id`) VALUES (1,'2022-07-01','2024-06-30','示例科技甲公司','Java开发工程师',26);
INSERT INTO `emp_expr` (`id`, `begin`, `end`, `company`, `job`, `emp_id`) VALUES (2,'2024-07-01','2026-09-30','示例科技乙公司','Java开发工程师',26);
/*!40000 ALTER TABLE `emp_expr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tlias'
--

--
-- Dumping routines for database 'tlias'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-29 16:38:19
