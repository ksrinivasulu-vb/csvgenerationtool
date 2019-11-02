/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 10.4.7-MariaDB : Database - csvtool
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`csvtool` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `csvtool`;

/*Table structure for table `batchcolumns` */

DROP TABLE IF EXISTS `batchcolumns`;

CREATE TABLE `batchcolumns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batchid` varchar(10) DEFAULT NULL,
  `csvcolumn` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `batchcolumns` */

insert  into `batchcolumns`(`id`,`batchid`,`csvcolumn`) values (1,'2598348448','$$0$$  180423');
insert  into `batchcolumns`(`id`,`batchid`,`csvcolumn`) values (2,'2598348448','$$1$$  coffee mug ');
insert  into `batchcolumns`(`id`,`batchid`,`csvcolumn`) values (3,'2598348448',' ');
insert  into `batchcolumns`(`id`,`batchid`,`csvcolumn`) values (4,'2598348448',' ');

/*Table structure for table `batchdetails` */

DROP TABLE IF EXISTS `batchdetails`;

CREATE TABLE `batchdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batchid` varchar(10) DEFAULT NULL,
  `batchname` varchar(100) DEFAULT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `userid` int(11) DEFAULT NULL,
  `batchsize` int(11) DEFAULT NULL,
  `filename` varchar(300) DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `batchdetails` */

insert  into `batchdetails`(`id`,`batchid`,`batchname`,`createddate`,`userid`,`batchsize`,`filename`,`isactive`) values (1,'2598348448','mug','2019-11-01 08:52:28',1,200,'C:\\test\\Accountant names.csv',1);

/*Table structure for table `csvcolumns` */

DROP TABLE IF EXISTS `csvcolumns`;

CREATE TABLE `csvcolumns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `columnname` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `csvcolumns` */

insert  into `csvcolumns`(`id`,`columnname`) values (1,'SKUID');
insert  into `csvcolumns`(`id`,`columnname`) values (2,'Sub-category');
insert  into `csvcolumns`(`id`,`columnname`) values (3,'Brand');
insert  into `csvcolumns`(`id`,`columnname`) values (4,'ModelName');

/*Table structure for table `csvdata` */

DROP TABLE IF EXISTS `csvdata`;

CREATE TABLE `csvdata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `batchid` int(10) DEFAULT NULL,
  `RCreferenceID` varchar(100) DEFAULT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `ProductType` varchar(100) DEFAULT NULL,
  `ProductTypeReferenceID` varchar(100) DEFAULT NULL,
  `ProductURL` varchar(100) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `csvdata` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`password`,`email`,`isactive`) values (1,'admin','admin','admn@example.com',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
