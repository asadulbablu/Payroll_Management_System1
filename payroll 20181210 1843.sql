-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema payroll2
--

CREATE DATABASE IF NOT EXISTS payroll2;
USE payroll2;

--
-- Definition of table `allowance`
--

DROP TABLE IF EXISTS `allowance`;
CREATE TABLE `allowance` (
  `allowanceid` int(10) unsigned NOT NULL auto_increment,
  `allowancehead` varchar(45) NOT NULL,
  PRIMARY KEY  (`allowanceid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allowance`
--

/*!40000 ALTER TABLE `allowance` DISABLE KEYS */;
INSERT INTO `allowance` (`allowanceid`,`allowancehead`) VALUES 
 (1,'overtime'),
 (2,'bonus'),
 (3,'Treatment'),
 (4,'Tranceport');
/*!40000 ALTER TABLE `allowance` ENABLE KEYS */;


--
-- Definition of table `basicyear`
--

DROP TABLE IF EXISTS `basicyear`;
CREATE TABLE `basicyear` (
  `yearid` int(10) unsigned NOT NULL auto_increment,
  `year` varchar(45) NOT NULL,
  PRIMARY KEY  (`yearid`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basicyear`
--

/*!40000 ALTER TABLE `basicyear` DISABLE KEYS */;
INSERT INTO `basicyear` (`yearid`,`year`) VALUES 
 (101,'2018'),
 (102,'2019'),
 (103,'2020');
/*!40000 ALTER TABLE `basicyear` ENABLE KEYS */;


--
-- Definition of table `deduction`
--

DROP TABLE IF EXISTS `deduction`;
CREATE TABLE `deduction` (
  `deductionid` int(10) unsigned NOT NULL auto_increment,
  `deductionhead` varchar(45) NOT NULL,
  PRIMARY KEY  (`deductionid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deduction`
--

/*!40000 ALTER TABLE `deduction` DISABLE KEYS */;
INSERT INTO `deduction` (`deductionid`,`deductionhead`) VALUES 
 (1,'providend fund'),
 (2,'absent');
/*!40000 ALTER TABLE `deduction` ENABLE KEYS */;


--
-- Definition of table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `deptid` int(10) unsigned NOT NULL auto_increment,
  `deptname` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`deptid`,`deptname`) VALUES 
 (101,'hr'),
 (102,'admin'),
 (103,'sales');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Definition of table `empinfo`
--

DROP TABLE IF EXISTS `empinfo`;
CREATE TABLE `empinfo` (
  `empid` int(10) unsigned NOT NULL auto_increment,
  `empname` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `joiningdate` date NOT NULL,
  `typeid` int(10) unsigned NOT NULL,
  `deptid` int(10) unsigned NOT NULL,
  `phoneno` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empinfo`
--

/*!40000 ALTER TABLE `empinfo` DISABLE KEYS */;
INSERT INTO `empinfo` (`empid`,`empname`,`gender`,`joiningdate`,`typeid`,`deptid`,`phoneno`) VALUES 
 (1,'erewr','Male','2018-12-08',1,102,23654),
 (2,'trpr','Male','2018-12-01',1,102,236987),
 (3,'fef','Female','2018-12-04',1,102,45456);
/*!40000 ALTER TABLE `empinfo` ENABLE KEYS */;


--
-- Definition of table `emploan`
--

DROP TABLE IF EXISTS `emploan`;
CREATE TABLE `emploan` (
  `loanid` int(10) unsigned NOT NULL auto_increment,
  `empid` int(10) unsigned NOT NULL,
  `loandate` date NOT NULL,
  `maturedate` date NOT NULL,
  `loantypeid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`loanid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emploan`
--

/*!40000 ALTER TABLE `emploan` DISABLE KEYS */;
INSERT INTO `emploan` (`loanid`,`empid`,`loandate`,`maturedate`,`loantypeid`) VALUES 
 (1,1,'2018-09-04','2018-12-06',0),
 (2,1,'2018-12-04','2018-12-08',1);
/*!40000 ALTER TABLE `emploan` ENABLE KEYS */;


--
-- Definition of table `joballowcal`
--

DROP TABLE IF EXISTS `joballowcal`;
CREATE TABLE `joballowcal` (
  `joballowcalid` int(10) unsigned NOT NULL auto_increment,
  `titleid` int(10) unsigned NOT NULL,
  `allowanceid` int(10) unsigned NOT NULL,
  `allowpermonth` double NOT NULL,
  PRIMARY KEY  (`joballowcalid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `joballowcal`
--

/*!40000 ALTER TABLE `joballowcal` DISABLE KEYS */;
/*!40000 ALTER TABLE `joballowcal` ENABLE KEYS */;


--
-- Definition of table `jobdeductcal`
--

DROP TABLE IF EXISTS `jobdeductcal`;
CREATE TABLE `jobdeductcal` (
  `jobdeductcalid` int(10) unsigned NOT NULL auto_increment,
  `titleid` int(10) unsigned NOT NULL,
  `deductionid` int(10) unsigned NOT NULL,
  `deductpermonth` double NOT NULL,
  PRIMARY KEY  (`jobdeductcalid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jobdeductcal`
--

/*!40000 ALTER TABLE `jobdeductcal` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobdeductcal` ENABLE KEYS */;


--
-- Definition of table `jobtitle`
--

DROP TABLE IF EXISTS `jobtitle`;
CREATE TABLE `jobtitle` (
  `jobtitleid` int(10) unsigned NOT NULL auto_increment,
  `jobtitle` varchar(45) NOT NULL,
  `basicsalary` varchar(45) NOT NULL,
  `yearid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`jobtitleid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jobtitle`
--

/*!40000 ALTER TABLE `jobtitle` DISABLE KEYS */;
INSERT INTO `jobtitle` (`jobtitleid`,`jobtitle`,`basicsalary`,`yearid`) VALUES 
 (1,'Manager','50000.0',101),
 (3,'Office Executive','10000.0',101),
 (5,'Assistant Manager','40000.0',101);
/*!40000 ALTER TABLE `jobtitle` ENABLE KEYS */;


--
-- Definition of table `jobtype`
--

DROP TABLE IF EXISTS `jobtype`;
CREATE TABLE `jobtype` (
  `typeid` int(10) unsigned NOT NULL auto_increment,
  `typename` varchar(45) NOT NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jobtype`
--

/*!40000 ALTER TABLE `jobtype` DISABLE KEYS */;
INSERT INTO `jobtype` (`typeid`,`typename`) VALUES 
 (1,'Monthly'),
 (2,'Hourly');
/*!40000 ALTER TABLE `jobtype` ENABLE KEYS */;


--
-- Definition of table `loanpayment`
--

DROP TABLE IF EXISTS `loanpayment`;
CREATE TABLE `loanpayment` (
  `loanpayid` int(10) unsigned NOT NULL auto_increment,
  `empid` int(10) unsigned NOT NULL,
  `loanid` int(10) unsigned NOT NULL,
  `loanpayamount` double NOT NULL,
  `loanpaydate` date NOT NULL,
  PRIMARY KEY  (`loanpayid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loanpayment`
--

/*!40000 ALTER TABLE `loanpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `loanpayment` ENABLE KEYS */;


--
-- Definition of table `loantype`
--

DROP TABLE IF EXISTS `loantype`;
CREATE TABLE `loantype` (
  `loantypeid` int(10) unsigned NOT NULL auto_increment,
  `loandescription` varchar(45) NOT NULL,
  `loanamount` double NOT NULL,
  PRIMARY KEY  USING BTREE (`loantypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loantype`
--

/*!40000 ALTER TABLE `loantype` DISABLE KEYS */;
INSERT INTO `loantype` (`loantypeid`,`loandescription`,`loanamount`) VALUES 
 (1,'monthly loan',10000),
 (2,'yearly Loan',20000);
/*!40000 ALTER TABLE `loantype` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `paymentid` int(10) unsigned NOT NULL auto_increment,
  `empid` int(10) unsigned NOT NULL,
  `paymentdate` date NOT NULL,
  `paymenttypeid` int(10) unsigned NOT NULL,
  `chequeno` varchar(45) NOT NULL,
  `bank` varchar(45) NOT NULL,
  `month` varchar(45) NOT NULL,
  `year` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`paymentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `paymentallowance`
--

DROP TABLE IF EXISTS `paymentallowance`;
CREATE TABLE `paymentallowance` (
  `payallowid` int(10) unsigned NOT NULL auto_increment,
  `allowancehead` varchar(45) NOT NULL,
  `allowanceid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`payallowid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentallowance`
--

/*!40000 ALTER TABLE `paymentallowance` DISABLE KEYS */;
INSERT INTO `paymentallowance` (`payallowid`,`allowancehead`,`allowanceid`) VALUES 
 (1,'overtime',1);
/*!40000 ALTER TABLE `paymentallowance` ENABLE KEYS */;


--
-- Definition of table `paymentdeduction`
--

DROP TABLE IF EXISTS `paymentdeduction`;
CREATE TABLE `paymentdeduction` (
  `paydeductid` int(10) unsigned NOT NULL auto_increment,
  `paymentid` int(10) unsigned NOT NULL,
  `deductionhead` varchar(45) NOT NULL,
  `paymentamount` double NOT NULL,
  PRIMARY KEY  (`paydeductid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentdeduction`
--

/*!40000 ALTER TABLE `paymentdeduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentdeduction` ENABLE KEYS */;


--
-- Definition of table `paymenttype`
--

DROP TABLE IF EXISTS `paymenttype`;
CREATE TABLE `paymenttype` (
  `paymenttypeid` int(10) unsigned NOT NULL auto_increment,
  `paymenttypename` varchar(45) NOT NULL,
  PRIMARY KEY  (`paymenttypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymenttype`
--

/*!40000 ALTER TABLE `paymenttype` DISABLE KEYS */;
INSERT INTO `paymenttype` (`paymenttypeid`,`paymenttypename`) VALUES 
 (1,'cash'),
 (2,'bank');
/*!40000 ALTER TABLE `paymenttype` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `emailid` varchar(255) NOT NULL,
  `phone` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`emailid`,`phone`,`username`) VALUES 
 ('as','+88456','aaa'),
 ('bablu@gmail.com','01747417507','bablu'),
 ('grfg','+8814555','qqqq'),
 ('raihan@gmail.com','+8801874125','raihan');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `emailid` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  `role` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userrole`
--

/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` (`emailid`,`password`,`role`,`status`) VALUES 
 ('as','999','ROLE_USER','True'),
 ('bablu@gmail.com','123','ROLE_USER','True'),
 ('grfg','11122','ROLE_USER','True'),
 ('raihan@gmail.com','321','ROLE_USER','True');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
