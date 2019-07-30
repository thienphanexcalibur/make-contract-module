-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2019 at 12:35 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cnpm`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `ID` int(10) NOT NULL,
  `ContractID` int(10) NOT NULL,
  `PaymentDate` date DEFAULT NULL,
  `PaymentType` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Total` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Discriminator` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`ID`, `Name`, `Description`, `Discriminator`) VALUES
(1, 'Tesla', 'An automatic electric car', ''),
(2, 'Honda', 'A japansese car brand', ''),
(3, 'Toyota', NULL, ''),
(4, 'Ford', NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `IdCardNumber` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `ContractID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`ID`, `Name`, `Birthday`, `IdCardNumber`, `Email`, `Phone`, `ContractID`) VALUES
(20, 'Phan Khanh Thien', '1997-10-06', '001097000612', 'thien061097@gmail.com', '0904657914', 26),
(23, 'John Mayer', '2019-05-15', '001097000612', 'abc@gmail.com', '92929292929', 29),
(24, 'Katy Perry', '2019-05-23', '123123213', 'thien061097@gmail.com', '0904232818', 30);

-- --------------------------------------------------------

--
-- Table structure for table `collateral`
--

CREATE TABLE `collateral` (
  `ID` int(10) NOT NULL,
  `ContractID` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Value` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `collateral`
--

INSERT INTO `collateral` (`ID`, `ContractID`, `Name`, `Value`) VALUES
(22, 26, 'Macbook Pro 2018', 40000000),
(25, 29, 'Apple Watch', 100000),
(26, 30, 'Macbook', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `ID` int(10) NOT NULL,
  `ClientID` int(10) NOT NULL,
  `Start_date` date DEFAULT NULL,
  `Finish_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`ID`, `ClientID`, `Start_date`, `Finish_date`) VALUES
(26, 20, '2019-05-06', '2019-05-09'),
(29, 23, '2019-03-04', '2019-03-05'),
(30, 24, '2019-03-04', '2019-03-05');

-- --------------------------------------------------------

--
-- Table structure for table `contract_vehicle`
--

CREATE TABLE `contract_vehicle` (
  `ContractID` int(10) NOT NULL,
  `VehicleID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `deposit`
--

CREATE TABLE `deposit` (
  `ID` int(10) NOT NULL,
  `ContractID` int(10) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deposit`
--

INSERT INTO `deposit` (`ID`, `ContractID`, `Description`, `amount`) VALUES
(20, 26, NULL, 10000000),
(23, 29, NULL, 100000),
(24, 30, NULL, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `entity`
--

CREATE TABLE `entity` (
  `ContractIndex` int(10) NOT NULL,
  `Vehicle` int(10) DEFAULT NULL,
  `ContractID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `punish`
--

CREATE TABLE `punish` (
  `ID` int(10) NOT NULL,
  `VehicleID` int(10) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Value` float DEFAULT NULL,
  `Quantity` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rentvehicle`
--

CREATE TABLE `rentvehicle` (
  `ID` int(10) NOT NULL,
  `ContractID` int(10) NOT NULL,
  `PunishID` int(10) DEFAULT NULL,
  `VehicleID` int(10) NOT NULL,
  `ClientID` int(11) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rentvehicle`
--

INSERT INTO `rentvehicle` (`ID`, `ContractID`, `PunishID`, `VehicleID`, `ClientID`, `Description`, `Price`) VALUES
(14, 26, NULL, 7, 20, NULL, NULL),
(17, 29, NULL, 5, 23, NULL, NULL),
(18, 30, NULL, 5, 24, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `ID` int(10) NOT NULL,
  `BrandID` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`ID`, `BrandID`, `Name`, `Type`, `Price`, `Description`) VALUES
(1, 1, 'Model X', NULL, 100, NULL),
(2, 1, 'Model X', NULL, 100, NULL),
(3, 1, 'Model 2019', NULL, 200, NULL),
(4, 3, 'Yaris', NULL, 650, NULL),
(5, 3, 'Yaris', NULL, 650000000, NULL),
(6, 2, 'Mazda', NULL, 20000000, NULL),
(7, 4, 'Ranger', NULL, 30000000, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKBill474438` (`ContractID`);

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKContractID` (`ContractID`);

--
-- Indexes for table `collateral`
--
ALTER TABLE `collateral`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ContractID` (`ContractID`);

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ClientID` (`ClientID`);

--
-- Indexes for table `contract_vehicle`
--
ALTER TABLE `contract_vehicle`
  ADD PRIMARY KEY (`ContractID`),
  ADD KEY `FKVehicleID` (`VehicleID`);

--
-- Indexes for table `deposit`
--
ALTER TABLE `deposit`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ContractID` (`ContractID`);

--
-- Indexes for table `entity`
--
ALTER TABLE `entity`
  ADD PRIMARY KEY (`ContractIndex`,`ContractID`);

--
-- Indexes for table `punish`
--
ALTER TABLE `punish`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKPunish355208` (`VehicleID`);

--
-- Indexes for table `rentvehicle`
--
ALTER TABLE `rentvehicle`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ContractID` (`ContractID`),
  ADD KEY `FKRentVehicl740036` (`PunishID`),
  ADD KEY `FKRentVehicl799399` (`VehicleID`),
  ADD KEY `FKClient` (`ClientID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKVehicle416789` (`BrandID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `collateral`
--
ALTER TABLE `collateral`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `contract_vehicle`
--
ALTER TABLE `contract_vehicle`
  MODIFY `ContractID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `deposit`
--
ALTER TABLE `deposit`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `punish`
--
ALTER TABLE `punish`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rentvehicle`
--
ALTER TABLE `rentvehicle`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FKBill474438` FOREIGN KEY (`ContractID`) REFERENCES `contract` (`ID`);

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKContractID` FOREIGN KEY (`ContractID`) REFERENCES `contract` (`ID`) ON DELETE SET NULL;

--
-- Constraints for table `collateral`
--
ALTER TABLE `collateral`
  ADD CONSTRAINT `FKCollateral852367` FOREIGN KEY (`ContractID`) REFERENCES `contract` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `FKContract95693` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contract_vehicle`
--
ALTER TABLE `contract_vehicle`
  ADD CONSTRAINT `FKVehicleID` FOREIGN KEY (`VehicleID`) REFERENCES `vehicle` (`ID`);

--
-- Constraints for table `deposit`
--
ALTER TABLE `deposit`
  ADD CONSTRAINT `FKDeposit542951` FOREIGN KEY (`ContractID`) REFERENCES `contract` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `punish`
--
ALTER TABLE `punish`
  ADD CONSTRAINT `FKPunish355208` FOREIGN KEY (`VehicleID`) REFERENCES `vehicle` (`ID`);

--
-- Constraints for table `rentvehicle`
--
ALTER TABLE `rentvehicle`
  ADD CONSTRAINT `FKClient` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKRentVehicl740036` FOREIGN KEY (`PunishID`) REFERENCES `punish` (`ID`),
  ADD CONSTRAINT `FKRentVehicl799399` FOREIGN KEY (`VehicleID`) REFERENCES `vehicle` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKRentVehicl954306` FOREIGN KEY (`ContractID`) REFERENCES `contract` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `FKVehicle416789` FOREIGN KEY (`BrandID`) REFERENCES `brand` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
