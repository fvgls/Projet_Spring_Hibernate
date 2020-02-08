-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: fvignolles_ensg
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `num_event` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ending_date` datetime DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `intitule` varchar(255) NOT NULL,
  `nb_part_max` int(11) NOT NULL,
  `organisator` varchar(255) DEFAULT NULL,
  `starting_date` datetime DEFAULT NULL,
  `theme` varchar(255) NOT NULL,
  PRIMARY KEY (`num_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Wonderful musci concert staring Phoebe Buffay','2020-02-21 00:00:00','concert','Phoebe Concert',20,'Central Perk','2020-02-20 00:00:00','music'),(2,'Gourmet Food','2020-02-15 00:00:00','diner','Monica Diner',15,'L\'Alessandro\'s','2020-02-15 00:00:00','food');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participant` (
  `num_pers` int(11) NOT NULL,
  `birth_date` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `observations` varchar(255) DEFAULT NULL,
  `organisation` varchar(255) DEFAULT NULL,
  `event_num_event` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_pers`),
  KEY `FK9a24483vkm893cuh62iox16c6` (`event_num_event`),
  CONSTRAINT `FK9a24483vkm893cuh62iox16c6` FOREIGN KEY (`event_num_event`) REFERENCES `event` (`num_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` VALUES (1,'1970-10-18 00:00:00','dynosaur@friends.com','Ross','Geller','We were on a break','museum',1),(2,'1968-01-09 00:00:00','food@friends.com','Joey','Tribbiani','Joey does NOT share his food','actor',1),(3,'1967-02-16 00:00:00','smellycat@friends.com','Phoebe','Buffay','','',1),(4,'1971-04-22 00:00:00','chief@friends.com','Monica','Geller','','L\'Alessandro\'s',2),(5,'1971-05-05 00:00:00','blonde@friends.com','Rachel','Green','Bad at cooking: the beef diplomate','BloomingDale',2),(6,'1968-04-08 00:00:00','funny@friends.com','Chandler','Bing','I want a MILLION dollars !','',2);
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-08 16:24:14
