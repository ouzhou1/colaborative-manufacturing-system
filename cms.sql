-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: localhost    Database: CMS
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ability_evaluation`
--

DROP TABLE IF EXISTS `ability_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ability_evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `establishment_evaluation` double NOT NULL,
  `infrastructure_evaluation` double NOT NULL,
  `manufacturing_evaluation` double NOT NULL,
  `service_evaluation` double NOT NULL,
  `total_evaluation` double NOT NULL,
  `user_id` double NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ability_evaluation`
--

LOCK TABLES `ability_evaluation` WRITE;
/*!40000 ALTER TABLE `ability_evaluation` DISABLE KEYS */;
INSERT INTO `ability_evaluation` VALUES (1,0.9,0.87,0.73,0.67,0.8,6,'KLA-Tencor'),(2,0.65,0.83,0.57,0.65,0.84,5,'LamResearch'),(3,0.83,0.65,0.65,0.57,0.84,4,'Teradyne'),(4,0.49,0.84,0.57,0.83,0.65,3,'semens'),(5,0.53,0.83,0.84,0.49,0.53,2,'elk'),(6,0.65,0.57,0.65,0.53,0.49,1,'tongji');
/*!40000 ALTER TABLE `ability_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidates`
--

DROP TABLE IF EXISTS `candidates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rate` double NOT NULL,
  `service_id` bigint(20) NOT NULL,
  `service_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidates`
--

LOCK TABLES `candidates` WRITE;
/*!40000 ALTER TABLE `candidates` DISABLE KEYS */;
INSERT INTO `candidates` VALUES (1,0.9,2,'单晶硅生长炉',6,'KLA-Tencor'),(2,0.81,9,'Furrance001',5,'LamResearch'),(3,0.79,10,'Furrance002',4,'Teradyne');
/*!40000 ALTER TABLE `candidates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `demands`
--

DROP TABLE IF EXISTS `demands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demands` (
  `demand_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `delivery_date` date NOT NULL,
  `demand_name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `mapped_service_id` varchar(255) DEFAULT NULL,
  `mapped_service_name` varchar(255) DEFAULT NULL,
  `publish_time` date NOT NULL,
  `related_field` varchar(255) NOT NULL,
  `related_order_id` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `related_order_name` varchar(255) NOT NULL,
  PRIMARY KEY (`demand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demands`
--

LOCK TABLES `demands` WRITE;
/*!40000 ALTER TABLE `demands` DISABLE KEYS */;
INSERT INTO `demands` VALUES (1,'2017-12-10','氧化','some description','','','2017-10-10','semiconductor','1','PROCESSING','氧化'),(2,'2017-12-10','procedure2','some description','','','2017-10-10','semiconductor','1','WAITING','semiconductor_product'),(3,'2018-12-21','晶圆制造','a demo',NULL,NULL,'2018-03-10','semiconductor','2','PROCESSING','晶圆制造'),(4,'2018-09-18','单晶硅生长','单晶硅生长 demo',NULL,NULL,'2018-03-15','semiconductor','2','NEW','');
/*!40000 ALTER TABLE `demands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ability_evaluation` double NOT NULL,
  `quality_evaluation` double NOT NULL,
  `service_evaluation` double NOT NULL,
  `time_evaluation` double NOT NULL,
  `total_evaluation` double NOT NULL,
  `user_id` double NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation`
--

LOCK TABLES `evaluation` WRITE;
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
INSERT INTO `evaluation` VALUES (1,0.88,0.71,0.86,0.68,0.81,6,'KLA-Tencor'),(2,0.98,0.84,0.51,0.62,0.65,5,'LamResearch'),(3,0.46,0.58,0.65,0.77,0.85,4,'Teradyne'),(4,0.39,0.91,0.81,0.65,0.88,3,'semens'),(5,0.98,0.65,0.68,0.62,0.74,2,'elk'),(6,0.65,0.66,0.55,0.86,0.65,1,'tongji');
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hardware_resource`
--

DROP TABLE IF EXISTS `hardware_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hardware_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `current_status` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `function_description` varchar(255) DEFAULT NULL,
  `function_name` varchar(255) NOT NULL,
  `load_status` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `operation_days` bigint(20) DEFAULT NULL,
  `owl_file` tinyblob,
  `owner` varchar(255) NOT NULL,
  `resource_code` varchar(255) NOT NULL,
  `use_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hardware_resource`
--

LOCK TABLES `hardware_resource` WRITE;
/*!40000 ALTER TABLE `hardware_resource` DISABLE KEYS */;
INSERT INTO `hardware_resource` VALUES (1,'制造设备','NEW',NULL,'','单晶硅生长','','单晶硅生长炉',NULL,NULL,'Tongji','AH3177000','2015-02-05'),(2,'制造设备','NEW',NULL,'','晶圆加工','','示例资源',NULL,NULL,'tongji','2301900','2018-03-01'),(3,'制造设备','NEW',NULL,'12','111','','test',NULL,NULL,'tongji','111','2018-03-08'),(4,'制造设备','NEW',NULL,'','qwe','','单晶硅生长炉',NULL,NULL,'tongji','920134','2018-03-02'),(5,'制造设备','NEW',NULL,'','22','','单晶硅生长炉',NULL,NULL,'10','103912','2018-03-01'),(6,'制造设备','NEW',NULL,'','3455','','单晶硅生长炉',NULL,NULL,'tongji','2314','2018-03-01'),(7,'制造设备','NEW',NULL,'','234','','123',NULL,NULL,'tongji','32','2018-03-08');
/*!40000 ALTER TABLE `hardware_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturing_service`
--

DROP TABLE IF EXISTS `manufacturing_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturing_service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `code` bigint(20) DEFAULT NULL,
  `current_status` varchar(255) DEFAULT NULL,
  `data_format` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `function_description` varchar(255) DEFAULT NULL,
  `function_name` varchar(255) DEFAULT NULL,
  `instruction` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operation_days` bigint(20) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `production_date` date DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturing_service`
--

LOCK TABLES `manufacturing_service` WRITE;
/*!40000 ALTER TABLE `manufacturing_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `manufacturing_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_service_binding`
--

DROP TABLE IF EXISTS `order_service_binding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_service_binding` (
  `binding_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) NOT NULL,
  `service_id` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`binding_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_service_binding`
--

LOCK TABLES `order_service_binding` WRITE;
/*!40000 ALTER TABLE `order_service_binding` DISABLE KEYS */;
INSERT INTO `order_service_binding` VALUES (2,'2','3','ACTIVE'),(41,'4','1','ACTIVE'),(42,'4','1','ACTIVE'),(43,'2','12','ACTIVE'),(44,'1','2','ACTIVE'),(45,'1','1','ACTIVE');
/*!40000 ALTER TABLE `order_service_binding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `craft_category` varchar(255) NOT NULL,
  `field` varchar(255) NOT NULL,
  `order_name` varchar(255) NOT NULL,
  `period` varchar(5) NOT NULL,
  `publish_time` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `raw_description` varchar(255) DEFAULT NULL,
  `scale` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `sub_order_nums` varchar(255) NOT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `tech_category` varchar(255) NOT NULL,
  `delivery_date` varchar(255) NOT NULL,
  `partner_nums` varchar(255) NOT NULL,
  `demand_id` varchar(255) NOT NULL,
  `demand_name` varchar(255) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'shanghai','product','semiconductor','semiconductor_product','60','2017-10-10','tongji',NULL,'medium','PROCESSING','4',NULL,'NULL','2018-09-03','3','3','晶圆制造'),(2,'shanghai','manufacturing','semiconductor','晶圆制造','180','2018-03-03','tongji',NULL,'medium','PROCESSING','3',NULL,'NULL','2018-09-03','5','3','晶圆制造'),(3,'shanghai','manufacturing','semiconductor','封装测试','30','2017-12-24','tongji',NULL,'medium','FINISHED','3',NULL,'NULL','2018-01-03','3','3','晶圆制造'),(4,'shanghai','manufacturing','semiconductor','氧化','2','2018-03-15','tongji',NULL,'medium','PROCESSING','1',NULL,'NULL','2018-03-20','2','1','氧化'),(5,'shanghai','manufacturing','semiconductor','刻蚀','2','2018-03-15','tongji',NULL,'small','PROCESSING','1',NULL,'NULL','2018-03-20','1','1','氧化');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partners`
--

DROP TABLE IF EXISTS `partners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partners` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` date NOT NULL,
  `level` int(11) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `sub_order_id` varchar(255) DEFAULT NULL,
  `sub_order_name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partners`
--

LOCK TABLES `partners` WRITE;
/*!40000 ALTER TABLE `partners` DISABLE KEYS */;
INSERT INTO `partners` VALUES (1,'2018-03-14',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,1,'tongji'),(2,'2018-03-14',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,1,'tongji'),(3,'2018-03-14',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(4,'2018-03-14',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(5,'2018-03-14',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,5,'LamResearch'),(6,'2018-03-14',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(7,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(8,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,2,'elk'),(9,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(10,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,2,'elk'),(11,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(12,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,2,'elk'),(13,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(14,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(15,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,2,'elk'),(16,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,2,'elk'),(17,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,2,'elk'),(18,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(19,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(20,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,4,'Teradyne'),(21,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(22,'2018-03-15',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,5,'LamResearch'),(23,'2018-03-16',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(24,'2018-03-16',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,4,'Teradyne'),(25,'2018-03-16',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(26,'2018-03-16',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,6,'KLA-Tencor'),(27,'2018-03-16',NULL,NULL,NULL,'NEW',NULL,NULL,NULL,1,'tongji');
/*!40000 ALTER TABLE `partners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quality_evaluation`
--

DROP TABLE IF EXISTS `quality_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quality_evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `function_evaluation` double NOT NULL,
  `secure_evaluation` double NOT NULL,
  `stability_evaluation` double NOT NULL,
  `total_evaluation` double NOT NULL,
  `user_id` double NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quality_evaluation`
--

LOCK TABLES `quality_evaluation` WRITE;
/*!40000 ALTER TABLE `quality_evaluation` DISABLE KEYS */;
INSERT INTO `quality_evaluation` VALUES (1,0.81,0.31,0.68,0.63,6,'KLA-Tencor'),(2,0.56,0.89,0.77,0.91,5,'LamResearch'),(3,0.82,0.37,0.59,0.66,4,'Teradyne'),(4,0.65,0.98,0.88,0.82,3,'semens'),(5,0.49,0.65,0.76,0.69,2,'elk'),(6,0.65,0.83,0.92,0.65,1,'tongji');
/*!40000 ALTER TABLE `quality_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_evaluation`
--

DROP TABLE IF EXISTS `service_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_evaluation` double NOT NULL,
  `service_attitude_evaluation` double NOT NULL,
  `total_evaluation` double NOT NULL,
  `user_id` double NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_evaluation`
--

LOCK TABLES `service_evaluation` WRITE;
/*!40000 ALTER TABLE `service_evaluation` DISABLE KEYS */;
INSERT INTO `service_evaluation` VALUES (1,0.92,0.59,0.65,6,'KLA-Tencor'),(2,0.65,0.91,0.83,5,'LamResearch'),(3,0.39,0.65,0.47,4,'Teradyne'),(4,0.76,0.48,0.65,3,'semens'),(5,0.39,0.48,0.75,2,'elk'),(6,0.39,0.65,0.55,1,'tongji');
/*!40000 ALTER TABLE `service_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `field` varchar(255) DEFAULT NULL,
  `online_nums` varchar(255) DEFAULT NULL,
  `owner` varchar(255) NOT NULL,
  `publishtime` varchar(255) NOT NULL,
  `service_use_times` varchar(255) DEFAULT NULL,
  `servicename` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `subcategory` varchar(255) DEFAULT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'服务','能力','1','tongji','2017-09-21','0','半导体生产线调度','NEW',NULL,'制造能力','10',NULL),(2,'资源','硬资源','3','KLA-Tencor','2018-02-01','1','单晶硅生长炉','PROCESSING',NULL,'设备资源','5',NULL),(3,'资源','硬资源','60','elk','2018-01-09','0','晶棒','NEW',NULL,'生产物料','50',NULL),(4,'资源','软资源','1','Teradyne','2017-10-02','5','AutoCAD','CROWDED',NULL,'软件资源','7',NULL),(5,'服务','能力','1','elk','2017-11-17','1','单晶硅拉伸','NEW',NULL,'制造能力','3',NULL),(6,'资源','硬资源','2','semens','2017-12-21','0','离子刻蚀系统','PROCESSING',NULL,NULL,'9',NULL),(7,'能力','能力','1','Teradyne','2017-11-02','0','半导体晶圆封装','PROCESSING',NULL,'封装能力','3',NULL),(8,'资源','能力',NULL,'tongji','2017-12-12','0','test1','PROCESSING','this is a test',NULL,'5',NULL),(9,'资源','硬资源',NULL,'中国电子科技集团第四十五所','2018-02-11','2','Furrance001','PROCESSING',NULL,'设备资源','7',NULL),(10,'资源','资源',NULL,'中国电子科技集团第四十五所','2018-03-11','0','Furrance002','NEW',NULL,'设备资源','3',NULL),(11,'资源','资源',NULL,'上海机械厂','2018-03-14','0','Furrance003','NEW',NULL,'设备资源','7',NULL),(12,'硬件资源类','半导体',NULL,'Tongji','2018-03-13',NULL,'示例服务','NEW','',NULL,'20',NULL),(13,'硬件资源类','半导体',NULL,'Tongji','2018-03-13',NULL,'test1','NEW','',NULL,'12',NULL),(14,'资源','资源',NULL,'Evatech','2018-03-13','0','Furrance004','NEW',NULL,'设备资源',NULL,NULL),(18,'硬件资源类','半导体',NULL,'Tongji','2018-03-15',NULL,'示例服务','NEW','',NULL,'10',NULL),(19,'硬件资源类','半导体',NULL,'Tongji','2018-03-15',NULL,'12123','NEW','',NULL,'10',NULL),(20,'硬件资源类','半导体',NULL,'Tongji','2018-03-15',NULL,'示例服务','NEW','',NULL,'10',NULL),(21,'硬件资源类','半导体',NULL,'Tongji','2018-03-15',NULL,'示例服务','NEW','',NULL,'10',NULL),(22,'硬件资源类','半导体',NULL,'Tongji','2018-03-16',NULL,'示例服务','NEW','',NULL,'10',NULL),(23,'硬件资源类','半导体',NULL,'Tongji','2018-03-16',NULL,'示例服务','NEW','',NULL,'10',NULL);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `software_resource`
--

DROP TABLE IF EXISTS `software_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `code` bigint(20) DEFAULT NULL,
  `current_status` varchar(255) DEFAULT NULL,
  `data_format` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `function_description` varchar(255) DEFAULT NULL,
  `function_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operation_days` bigint(20) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `production_date` date DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `instruction` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `software_resource`
--

LOCK TABLES `software_resource` WRITE;
/*!40000 ALTER TABLE `software_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `software_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_orders`
--

DROP TABLE IF EXISTS `sub_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_orders` (
  `sub_order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_order_id` bigint(20) NOT NULL,
  `parent_order_name` varchar(255) NOT NULL,
  `sub_order_name` varchar(255) NOT NULL,
  `delivery_date` varchar(255) NOT NULL,
  `sub_order_status` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `mapped_service_id` varchar(255) DEFAULT NULL,
  `mapped_service_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sub_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_orders`
--

LOCK TABLES `sub_orders` WRITE;
/*!40000 ALTER TABLE `sub_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_evaluation`
--

DROP TABLE IF EXISTS `time_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `duration_evaluation` double NOT NULL,
  `online_evaluation` double NOT NULL,
  `ontime_evaluation` double NOT NULL,
  `total_evaluation` double NOT NULL,
  `user_id` double NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_evaluation`
--

LOCK TABLES `time_evaluation` WRITE;
/*!40000 ALTER TABLE `time_evaluation` DISABLE KEYS */;
INSERT INTO `time_evaluation` VALUES (1,0.83,0.78,0.69,0.74,6,'KLA-Tencor'),(2,0.91,0.65,0.72,0.89,5,'LamResearch'),(3,0.83,0.87,0.65,0.55,4,'Teradyne'),(4,0.97,0.59,0.28,0.96,3,'semens'),(5,0.31,0.65,0.39,0.83,2,'elk'),(6,0.36,0.65,0.65,0.74,1,'tongji');
/*!40000 ALTER TABLE `time_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `field` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `personal_statement` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `u_scale` varchar(255) DEFAULT NULL,
  `user_category` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `evaluation` double DEFAULT NULL,
  `relative_evaluation` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'tongji@tongji.edu.cn','education','Shanghai','名称:	现代制造工程研究所\n经营范围:	\n×××研究实验室，地址：同济大学','ACTIVE','021-69583223','10000+','college','tongji','tongji',NULL,NULL,NULL),(2,'elk','semiconductor','Shanghai','公司主要销售智能电表、工业控制系统和铁路设备的安全和通信芯片。同时为母公司供应部件、电力设备。','PROCESSING','021-86821972','50-100','enterprise','elk','elk',NULL,NULL,NULL),(3,'semens','electricity','Guangzhou','公司销售从微控制器到电源管理芯片等元件。','ARCHIVED',NULL,'10000+','enterprise','semens','semens',NULL,NULL,NULL),(4,'Teradyne','semiconductor','American',NULL,'ACTIVE','2910000','5000','enterprise','Teradyne','Teradyne',NULL,NULL,NULL),(5,'LamResearch','semiconductor','American',NULL,'ACTIVE','6410000','10000+','enterprise','LamResearch','Teradyne',NULL,NULL,NULL),(6,'KLA-Tencor','semiconductor','American',NULL,'ACTIVE','2167884','10000+','enterprise','KLA-Tencor','Teradyne',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_message`
--

DROP TABLE IF EXISTS `user_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_message`
--

LOCK TABLES `user_message` WRITE;
/*!40000 ALTER TABLE `user_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order_binding`
--

DROP TABLE IF EXISTS `user_order_binding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_order_binding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `status` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order_binding`
--

LOCK TABLES `user_order_binding` WRITE;
/*!40000 ALTER TABLE `user_order_binding` DISABLE KEYS */;
INSERT INTO `user_order_binding` VALUES (1,2,'ACTIVE',1),(4,2,'ACTIVE',5),(5,2,'ACTIVE',6),(25,1,'ACTIVE',6),(26,1,'ACTIVE',1);
/*!40000 ALTER TABLE `user_order_binding` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-22 18:43:47
