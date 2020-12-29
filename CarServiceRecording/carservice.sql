-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.22 - MySQL Community Server - GPL
-- Server OS:                    Linux
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for testing
CREATE DATABASE IF NOT EXISTS `testing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `testing`;

-- Dumping structure for table testing.car
CREATE TABLE IF NOT EXISTS `car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `car_no` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_no` (`car_no`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table testing.car: ~0 rows (approximately)
DELETE FROM `car`;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` (`id`, `car_name`, `car_no`) VALUES
	(1, 'jeep', 'c1'),
	(2, 'bolero', 'c2'),
	(3, 'tiago', 'c3'),
	(4, 'swift', 'c4'),
	(5, 'landrover', 'c5'),
	(6, 'fortuiner', 'c6'),
	(7, 'aspire', 'c7'),
	(8, 'ecosport', 'c8'),
	(9, 'i10', 'c9'),
	(10, 'verna', 'c10'),
	(11, 'alto', 'c11'),
	(16, 'c12', 'c12'),
	(17, 'c13', 'c13'),
	(18, 'c30', 'c30'),
	(19, 'brizza', 'c31');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;

-- Dumping structure for table testing.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `phone` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table testing.customer: ~0 rows (approximately)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `customer_name`, `phone`) VALUES
	(1, 'jacqub', 123456),
	(2, 'tom', 234567),
	(3, 'herry', 345678),
	(4, 'donald', 321123),
	(5, 'richa', 345543),
	(6, 'robert', 234543),
	(7, 'deep', 4567890);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table testing.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table testing.hibernate_sequence: ~1 rows (approximately)
DELETE FROM `hibernate_sequence`;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table testing.service
CREATE TABLE IF NOT EXISTS `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `service_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- Dumping data for table testing.service: ~0 rows (approximately)
DELETE FROM `service`;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` (`id`, `car_id`, `customer_id`, `service_date`) VALUES
	(1, 1, 1, '2020-12-28 12:00:49'),
	(2, 10, 1, '2020-12-28 12:01:13'),
	(3, 9, 2, '2020-12-28 12:01:19'),
	(4, 6, 2, '2020-12-28 12:01:26'),
	(5, 7, 3, '2020-12-28 12:01:37'),
	(6, 2, 4, '2020-12-28 12:02:01'),
	(7, 3, 4, '2020-12-28 12:02:07'),
	(8, 4, 4, '2020-12-28 12:02:12'),
	(9, 5, 4, '2020-12-28 12:02:23'),
	(10, 2, 4, '2020-12-28 12:02:01'),
	(12, 11, 3, '2020-12-28 13:35:10'),
	(13, 11, 3, '2020-12-28 13:35:24'),
	(14, 19, 7, '2020-12-28 13:39:06'),
	(15, 19, 7, '2020-12-28 13:39:44'),
	(16, 19, 7, '2020-12-28 15:25:51'),
	(17, 19, 7, '2020-12-28 15:52:55');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
