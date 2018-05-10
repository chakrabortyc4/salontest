CREATE DATABASE  IF NOT EXISTS `salontest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `salontest`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: salontest
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `discount_data`
--

DROP TABLE IF EXISTS `discount_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount_data` (
  `discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_code` varchar(45) NOT NULL,
  `created_by` int(11) NOT NULL,
  `discount_persent` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`discount_id`),
  UNIQUE KEY `UK_i7wqpm4daw48kmi6kqc09tgym` (`user_id`),
  CONSTRAINT `fk_user_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file` longblob NOT NULL,
  `original_file_name` varchar(200) NOT NULL,
  `titel` varchar(200) NOT NULL,
  `upload_time` datetime NOT NULL,
  `category_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `category_index` varchar(45) NOT NULL,
  PRIMARY KEY (`file_id`),
  UNIQUE KEY `uk_cat_index` (`category_id`,`user_id`,`category_index`),
  KEY `FK_531rkvqn45lw9t2djf0c2mw9h` (`user_id`),
  CONSTRAINT `FK_531rkvqn45lw9t2djf0c2mw9h` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_bf4ylg9f9tq16wv3strp0wimv` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pay_status`
--

DROP TABLE IF EXISTS `pay_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_status` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `attempt_section` int(11) NOT NULL,
  `total_entry` int(11) NOT NULL,
  `coupon_code_number` varchar(45) DEFAULT NULL,
  `total_amount` int(11) NOT NULL,
  `discount_amount` int(11) NOT NULL,
  `courency_type` varchar(45) NOT NULL,
  `recived_amont` int(11) DEFAULT NULL,
  `entry_created_time` datetime NOT NULL,
  `paying_status` varchar(45) NOT NULL,
  `pay_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `recived_courency_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pay_id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `address` varchar(500) NOT NULL,
  `city` varchar(200) NOT NULL,
  `club` varchar(200) DEFAULT NULL,
  `country` varchar(200) NOT NULL,
  `created_on` datetime NOT NULL,
  `email` varchar(200) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `gender` varchar(200) NOT NULL,
  `honer` varchar(200) DEFAULT NULL,
  `last_loggin` datetime NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(45) NOT NULL,
  `state` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'salontest'
--

--
-- Dumping routines for database 'salontest'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-10 17:30:55
