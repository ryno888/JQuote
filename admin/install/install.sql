-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table loc_quoteapp.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `add_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_line1` varchar(256) NOT NULL DEFAULT '',
  `add_line2` varchar(256) NOT NULL DEFAULT '',
  `add_suburb` varchar(256) NOT NULL DEFAULT '',
  `add_country` varchar(256) NOT NULL DEFAULT '',
  `add_code` varchar(256) NOT NULL DEFAULT '',
  `add_town` varchar(256) NOT NULL DEFAULT '',
  `add_ref_person` int(11) DEFAULT NULL,
  PRIMARY KEY (`add_id`),
  KEY `fk_add_ref_person` (`add_ref_person`),
  CONSTRAINT `fk_add_ref_person` FOREIGN KEY (`add_ref_person`) REFERENCES `person` (`per_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table loc_quoteapp.invoice
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `inv_id` int(11) NOT NULL AUTO_INCREMENT,
  `inv_ref_person` int(11) DEFAULT NULL,
  `inv_total_excl` double DEFAULT '0',
  `inv_date_created` datetime DEFAULT NULL,
  `inv_number` varchar(256) DEFAULT '',
  PRIMARY KEY (`inv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table loc_quoteapp.invoice_item
DROP TABLE IF EXISTS `invoice_item`;
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `ini_id` int(11) NOT NULL AUTO_INCREMENT,
  `ini_ref_invoice` int(11) DEFAULT NULL,
  `ini_ref_quote_item` int(11) DEFAULT NULL,
  PRIMARY KEY (`ini_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table loc_quoteapp.person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_name` varchar(256) DEFAULT '',
  `per_firstname` varchar(256) DEFAULT '',
  `per_lastname` varchar(256) DEFAULT '',
  `per_email` varchar(256) DEFAULT '',
  `per_account_nr` varchar(256) DEFAULT '',
  `per_contact_nr` varchar(256) DEFAULT '',
  `per_trading_name` varchar(256) DEFAULT '',
  `per_is_active` tinyint(4) DEFAULT '0',
  `per_birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table loc_quoteapp.quote_item
DROP TABLE IF EXISTS `quote_item`;
CREATE TABLE IF NOT EXISTS `quote_item` (
  `qut_id` int(11) NOT NULL AUTO_INCREMENT,
  `qut_name` varchar(256) DEFAULT '',
  `qut_unit` int(11) DEFAULT '0',
  `qut_unit_price` double DEFAULT '0',
  `qut_price` double DEFAULT '0',
  PRIMARY KEY (`qut_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
