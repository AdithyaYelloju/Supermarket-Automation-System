-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 13, 2018 at 07:21 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `SAS`
--

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE IF NOT EXISTS `Employee` (
  `Id` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `MRP` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`Id`, `Name`, `MRP`, `Quantity`, `Total`) VALUES
('12345', 'dish soap', 45, 4, 180),
('12346', 'food storage bags', 10, 12, 120),
('12347', 'laundry detergent', 50, 35, 1750),
('12348', 'stain remover', 70, 45, 3150),
('12349', 'notebooks', 20, 123, 2460),
('12350', 'wet mopping cloths', 345, 89, 30705),
('12351', 'body scrub', 33, 100, 3300),
('12352', 'hand sanitizer', 450, 45, 20250),
('12353', 'hair gel', 55, 270, 14850),
('12354', 'shaving cream', 27, 234, 6318),
('12355', 'wax strips', 56, 320, 17920),
('12356', 'pain relievers', 230, 125, 28750),
('12357', 'dental floss ', 87, 450, 39150);

-- --------------------------------------------------------

--
-- Table structure for table `Login`
--

CREATE TABLE IF NOT EXISTS `Login` (
  `UserName` varchar(30) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Login`
--

INSERT INTO `Login` (`UserName`, `Password`, `type`) VALUES
('adithya', 'rgukt', 'clerk'),
('rakesh', 'rak', 'manager'),
('rohithbys', 'rgukt123', 'employee');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
