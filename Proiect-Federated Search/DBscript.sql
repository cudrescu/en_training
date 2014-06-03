CREATE DATABASE  IF NOT EXISTS `moviedb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `moviedb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: moviedb
-- ------------------------------------------------------
-- Server version	5.6.17-log

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
-- Table structure for table `moviedata`
--

DROP TABLE IF EXISTS `moviedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moviedata` (
  `movieID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `rated` varchar(255) DEFAULT NULL,
  `released` varchar(255) DEFAULT NULL,
  `runtime` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `actors` varchar(1000) DEFAULT NULL,
  `plot` varchar(10000) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `awards` varchar(255) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `metascore` varchar(255) DEFAULT NULL,
  `imdbRating` varchar(255) DEFAULT NULL,
  `imdbVotes` varchar(255) DEFAULT NULL,
  `imdbID` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `network` varchar(255) DEFAULT NULL,
  `air_day` varchar(255) DEFAULT NULL,
  `air_time` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `seasons` varchar(255) DEFAULT NULL,
  `classification` varchar(255) DEFAULT NULL,
  `idQuery` int(11) DEFAULT NULL,
  PRIMARY KEY (`movieID`),
  UNIQUE KEY `movieID_UNIQUE` (`movieID`),
  KEY `fk_moviedata_Query_idx` (`idQuery`),
  CONSTRAINT `fk_moviedata_Query` FOREIGN KEY (`idQuery`) REFERENCES `query` (`idQuery`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1061 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviedata`
--

LOCK TABLES `moviedata` WRITE;
/*!40000 ALTER TABLE `moviedata` DISABLE KEYS */;
/*!40000 ALTER TABLE `moviedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `query`
--

DROP TABLE IF EXISTS `query`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `query` (
  `idQuery` int(11) NOT NULL AUTO_INCREMENT,
  `requestedMovie` varchar(255) DEFAULT NULL,
  `insertedTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idQuery`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `query`
--

LOCK TABLES `query` WRITE;
/*!40000 ALTER TABLE `query` DISABLE KEYS */;
/*!40000 ALTER TABLE `query` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-30 17:44:49
