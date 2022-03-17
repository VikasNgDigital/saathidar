CREATE DATABASE  IF NOT EXISTS `sathidar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sathidar`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: sathidar
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cast`
--

DROP TABLE IF EXISTS `cast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cast` (
  `cast_id` int NOT NULL AUTO_INCREMENT,
  `cast_name` varchar(150) DEFAULT NULL,
  `religion_id` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cast_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cast`
--

LOCK TABLES `cast` WRITE;
/*!40000 ALTER TABLE `cast` DISABLE KEYS */;
/*!40000 ALTER TABLE `cast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(150) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `state_id` int DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `member_number` int DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `marital_status` varchar(200) DEFAULT NULL,
  `contact_number` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `membercol` varchar(45) DEFAULT NULL,
  `created_by` varchar(200) DEFAULT NULL,
  `updated_by` varchar(200) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `plan_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_preference`
--

DROP TABLE IF EXISTS `member_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_preference` (
  `member_preference_id` int NOT NULL AUTO_INCREMENT,
  `member_id` int DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `agebetween` varchar(45) DEFAULT NULL,
  `lifestyle` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `cast_id` int DEFAULT NULL,
  `subcaste_id` int DEFAULT NULL,
  `religion_id` int DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  PRIMARY KEY (`member_preference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_preference`
--

LOCK TABLES `member_preference` WRITE;
/*!40000 ALTER TABLE `member_preference` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberdetails`
--

DROP TABLE IF EXISTS `memberdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `memberdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL,
  `cast_id` int DEFAULT NULL,
  `subcaste_id` int DEFAULT NULL,
  `native` varchar(100) DEFAULT NULL,
  `height` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `religion_id` int DEFAULT NULL,
  `lifestyles` varchar(100) DEFAULT NULL,
  `known_languages` varchar(200) DEFAULT NULL,
  `education` varchar(500) DEFAULT NULL,
  `job` varchar(500) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  `income` varchar(45) DEFAULT NULL,
  `zodiac_sign` varchar(200) DEFAULT NULL,
  `hobbies` varchar(500) DEFAULT NULL,
  `expectations` varchar(500) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberdetails`
--

LOCK TABLES `memberdetails` WRITE;
/*!40000 ALTER TABLE `memberdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `memberdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberstories`
--

DROP TABLE IF EXISTS `memberstories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `memberstories` (
  `story_id` int NOT NULL AUTO_INCREMENT,
  `member_id` int DEFAULT NULL,
  `story_submitted` varchar(45) DEFAULT NULL,
  `memberstoriescol` varchar(45) DEFAULT NULL,
  `story_test` varchar(800) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`story_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberstories`
--

LOCK TABLES `memberstories` WRITE;
/*!40000 ALTER TABLE `memberstories` DISABLE KEYS */;
/*!40000 ALTER TABLE `memberstories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `old_gender`
--

DROP TABLE IF EXISTS `old_gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `old_gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gendername` varchar(45) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deleteflag` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `old_gender`
--

LOCK TABLES `old_gender` WRITE;
/*!40000 ALTER TABLE `old_gender` DISABLE KEYS */;
INSERT INTO `old_gender` VALUES (1,'Male','2022-03-10 06:20:24','N'),(2,'Female','2022-03-10 06:20:24','N');
/*!40000 ALTER TABLE `old_gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `old_marritalstatus`
--

DROP TABLE IF EXISTS `old_marritalstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `old_marritalstatus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mstatusname` varchar(100) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deleteflag` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `old_marritalstatus`
--

LOCK TABLES `old_marritalstatus` WRITE;
/*!40000 ALTER TABLE `old_marritalstatus` DISABLE KEYS */;
INSERT INTO `old_marritalstatus` VALUES (1,'Unmarried','2022-03-10 06:21:19','N'),(2,'Widow','2022-03-10 06:21:19','N'),(3,'Divorced','2022-03-10 06:21:19','N'),(4,'Seperated','2022-03-10 06:21:19','N'),(5,'Awaiting Divorce','2022-03-10 06:21:19','N');
/*!40000 ALTER TABLE `old_marritalstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `old_profilecreatedfor`
--

DROP TABLE IF EXISTS `old_profilecreatedfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `old_profilecreatedfor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pcreatedfor` varchar(100) DEFAULT NULL,
  `dattime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deleteflag` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `old_profilecreatedfor`
--

LOCK TABLES `old_profilecreatedfor` WRITE;
/*!40000 ALTER TABLE `old_profilecreatedfor` DISABLE KEYS */;
INSERT INTO `old_profilecreatedfor` VALUES (1,'Self','2022-03-10 06:22:15','N'),(2,'Son','2022-03-10 06:22:15','N'),(3,'Daughter','2022-03-10 06:22:15','N'),(4,'Relative/Friends','2022-03-10 06:22:15','N'),(5,'Sister','2022-03-10 06:22:15','N'),(6,'Brother','2022-03-10 06:22:15','N');
/*!40000 ALTER TABLE `old_profilecreatedfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `old_religion`
--

DROP TABLE IF EXISTS `old_religion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `old_religion` (
  `religion_id` int NOT NULL AUTO_INCREMENT,
  `religion_name` varchar(100) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`religion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `old_religion`
--

LOCK TABLES `old_religion` WRITE;
/*!40000 ALTER TABLE `old_religion` DISABLE KEYS */;
INSERT INTO `old_religion` VALUES (1,'Hindu','2022-03-10 11:52:54','N',NULL,'2022-03-15 10:20:33','2022-03-15 10:20:33'),(2,'Muslim','2022-03-10 11:52:54','N',NULL,'2022-03-15 10:20:33','2022-03-15 10:20:33'),(3,'Christian','2022-03-10 11:52:54','N',NULL,'2022-03-15 10:20:33','2022-03-15 10:20:33'),(4,'Sikh','2022-03-10 11:52:54','N',NULL,'2022-03-15 10:20:33','2022-03-15 10:20:33'),(5,'Jain','2022-03-10 11:52:54','N',NULL,'2022-03-15 10:20:33','2022-03-15 10:20:33'),(6,'Parsi','2022-03-10 11:52:54','N',NULL,'2022-03-15 10:20:33','2022-03-15 10:20:33'),(7,'Others','2022-03-10 11:52:54','N',NULL,'2022-03-15 10:20:33','2022-03-15 10:20:33');
/*!40000 ALTER TABLE `old_religion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `old_state`
--

DROP TABLE IF EXISTS `old_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `old_state` (
  `id` int NOT NULL AUTO_INCREMENT,
  `statename` varchar(45) DEFAULT NULL,
  `countryid` int DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deleteflag` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `old_state`
--

LOCK TABLES `old_state` WRITE;
/*!40000 ALTER TABLE `old_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `old_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plans`
--

DROP TABLE IF EXISTS `plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plans` (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(500) DEFAULT NULL,
  `plan_validity` varchar(100) DEFAULT NULL,
  `plan_price` double DEFAULT NULL,
  `plan_discount` double DEFAULT NULL,
  `plan_status` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plans`
--

LOCK TABLES `plans` WRITE;
/*!40000 ALTER TABLE `plans` DISABLE KEYS */;
/*!40000 ALTER TABLE `plans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `religion`
--

DROP TABLE IF EXISTS `religion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `religion` (
  `religion_id` int NOT NULL AUTO_INCREMENT,
  `religion_name` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`religion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `religion`
--

LOCK TABLES `religion` WRITE;
/*!40000 ALTER TABLE `religion` DISABLE KEYS */;
/*!40000 ALTER TABLE `religion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_status` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'USER','active',NULL,NULL,'2022-03-15 12:44:51','2022-03-15 12:44:51'),(2,'ADMIN','active',NULL,NULL,'2022-03-15 12:44:52','2022-03-15 12:44:52'),(3,'GUEST','active',NULL,NULL,'2022-03-15 12:44:52','2022-03-15 12:44:52');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `states` (
  `state_id` int NOT NULL AUTO_INCREMENT,
  `state_name` varchar(150) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcasts`
--

DROP TABLE IF EXISTS `subcasts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcasts` (
  `subcast_id` int NOT NULL AUTO_INCREMENT,
  `subcast_name` varchar(150) DEFAULT NULL,
  `cast_id` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`subcast_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcasts`
--

LOCK TABLES `subcasts` WRITE;
/*!40000 ALTER TABLE `subcasts` DISABLE KEYS */;
/*!40000 ALTER TABLE `subcasts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `deleteflag` char(1) DEFAULT 'N',
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `created_At` timestamp NULL DEFAULT NULL,
  `updated_At` timestamp NULL DEFAULT NULL,
  `confirmation_Token` varchar(200) DEFAULT NULL,
  `is_Temp_Password` tinyint DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `enabled` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'vikas','{bcrypt}$2a$10$3cMoAKO2OVy62p1DvyatQOb0W2uDhv4jHch1p0mIGYboFy7xl3DLK','vikas@gmail.com','ROLE_USER','N','2022-03-14 18:39:07','2022-03-14 18:39:08','2022-03-14 19:06:03','admin1',0,'vikas','aher',1),(2,'pratik','{bcrypt}$2a$10$2NlOe76uXe4Qny10tF.O0uqzxzS3MAejkasKKq5LLbFRwbVkksowm','pratik@gmail.com','ROLE_USER','N','2022-03-15 04:44:37','2022-03-15 04:44:36','2022-03-15 04:48:41','admin2',0,'pratik','aher',1),(3,'mihir','{bcrypt}$2a$10$Fdcd03x7NHBa0R6Mik7qP.ssUgCZjO9uN5WaGK/Kr7UsjPCtPlXqa','mihir@gmail.com','ROLE_USER','N','2022-03-15 06:56:45','2022-03-15 06:56:45','2022-03-15 06:56:45','06d4531d-16f2-4619-8a50-7473ea7726ec',0,'mihir','aher',1),(4,'nikhil','{bcrypt}$2a$10$YNldkh9A88/7uHqkfrpxjOffI7xFsqDGKMTxB7turXB6U1bNl6Bc2','nikhil@gmail.com','ROLE_USER','N','2022-03-15 07:20:11','2022-03-15 07:20:11','2022-03-15 07:23:34','nkadmiin',0,'nikhil','Gujrathi',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `creadted_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1,1,'2022-03-15 12:46:36'),(2,2,2,'2022-03-15 12:46:36'),(3,3,1,'2022-03-15 12:46:36'),(4,4,3,'2022-03-15 12:46:36');
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sathidar'
--

--
-- Dumping routines for database 'sathidar'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-15 23:50:49
