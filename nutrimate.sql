-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: nutrimate
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `catatan_makanan`
--

DROP TABLE IF EXISTS `catatan_makanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catatan_makanan` (
  `CatatanID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `MakananID` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Waktu` time NOT NULL,
  `Porsi` double NOT NULL DEFAULT 1,
  `Kalori` double NOT NULL,
  PRIMARY KEY (`CatatanID`),
  KEY `UserID` (`UserID`),
  KEY `MakananID` (`MakananID`),
  CONSTRAINT `catatan_makanan_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE,
  CONSTRAINT `catatan_makanan_ibfk_2` FOREIGN KEY (`MakananID`) REFERENCES `makanan` (`MakananID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catatan_makanan`
--

LOCK TABLES `catatan_makanan` WRITE;
/*!40000 ALTER TABLE `catatan_makanan` DISABLE KEYS */;
INSERT INTO `catatan_makanan` VALUES (1,1,1,'2026-06-02','07:30:00',1,200),(2,1,2,'2026-06-02','07:30:00',1,150);
/*!40000 ALTER TABLE `catatan_makanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `makanan`
--

DROP TABLE IF EXISTS `makanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `makanan` (
  `MakananID` int(11) NOT NULL AUTO_INCREMENT,
  `Nama_Makanan` varchar(100) NOT NULL,
  `Kalori` double NOT NULL,
  `Karbohidrat` double DEFAULT 0,
  `Protein` double DEFAULT 0,
  `Lemak` double DEFAULT 0,
  `Kategori` varchar(50) NOT NULL,
  PRIMARY KEY (`MakananID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makanan`
--

LOCK TABLES `makanan` WRITE;
/*!40000 ALTER TABLE `makanan` DISABLE KEYS */;
INSERT INTO `makanan` VALUES (1,'Nasi Putih',200,45,4,0.5,'Karbohidrat'),(2,'Telur Dadar',150,1,11,12,'Protein'),(3,'Ayam Panggang',250,0,30,14,'Protein'),(4,'Oatmeal',180,32,6,3,'Karbohidrat'),(5,'Apel',80,22,0.5,0.3,'Buah'),(6,'Susu Low Fat',120,12,8,2,'Minuman');
/*!40000 ALTER TABLE `makanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Umur` int(11) NOT NULL,
  `Jenis_Kelamin` varchar(20) NOT NULL,
  `Berat_Badan` double NOT NULL,
  `Tinggi_Badan` int(11) NOT NULL,
  `Aktivitas` varchar(100) NOT NULL,
  `Target_Diet` varchar(100) NOT NULL,
  `Target_Kalori` int(11) DEFAULT 2000,
  `BMR` double DEFAULT 0,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'andi','password123','Andi',25,'Laki-laki',70,170,'Sedang (3-5 hari/minggu)','Menurunkan Berat Badan',2000,1668);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-04 20:31:36
