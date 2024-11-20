CREATE DATABASE  IF NOT EXISTS `bd_audio`;
USE `bd_audio`;
--
-- Table structure for table `Audio`
--

DROP TABLE IF EXISTS `Audio`;
CREATE TABLE `Audio` (
  `idAudio` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `precio` float NOT NULL,
  `bluetooth` tinyint DEFAULT NULL,
  PRIMARY KEY (`idAudio`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Audio`
--

INSERT INTO `Audio` VALUES (1,'7799111','Parlante Party Rocker One','Hisense',461799,0),(2,'4895229','Sistema de audio  TAX5708/77','Philips',824099,1),(3,'8804240','Auriculares pop blanco','Foxbox',2729,0),(4,'6925281','Auriculares Tune 520 ','JBL',69999,1),(5,'7117195','Auriculares Headset para PS5','Sony',301119,0);

--
-- Table structure for table `Auricular`
--

DROP TABLE IF EXISTS `Auricular`;
CREATE TABLE `Auricular` (
  `idAuricular` int NOT NULL,
  `microfonoIncorporado` tinyint NOT NULL,
  `tipoUso` varchar(10) NOT NULL,
  PRIMARY KEY (`idAuricular`),
  CONSTRAINT `fk_Auricular_1` FOREIGN KEY (`idAuricular`) REFERENCES `Audio` (`idAudio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Auricular`
--

INSERT INTO `Auricular` VALUES (3,1,'in ear'),(4,1,'on ear'),(5,1,'over ear');

--
-- Table structure for table `Parlante`
--

DROP TABLE IF EXISTS `Parlante`;
CREATE TABLE `Parlante` (
  `idParlante` int NOT NULL AUTO_INCREMENT,
  `potencia` smallint NOT NULL,
  `entradasUSB` smallint NOT NULL,
  `wifi` tinyint NOT NULL,
  PRIMARY KEY (`idParlante`),
  UNIQUE KEY `wifi_UNIQUE` (`wifi`),
  CONSTRAINT `fk_Parlante_1` FOREIGN KEY (`idParlante`) REFERENCES `Audio` (`idAudio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Parlante`
--

INSERT INTO `Parlante` VALUES (1,300,1,0),(2,400,2,1);

--
-- Table structure for table `Venta`
--

DROP TABLE IF EXISTS `Venta`;
CREATE TABLE `Venta` (
  `idVenta` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cliente` varchar(25) NOT NULL,
  `descuento` float NOT NULL,
  PRIMARY KEY (`idVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Venta`
--

INSERT INTO `Venta` VALUES (1,'2024-05-20','Gustavo Siciliano',2729),(2,'2024-05-21','Oscar Ruina',230900),(3,'2024-05-22','Alejandra Vranic',4093.5);

--
-- Table structure for table `ItemVenta`
--

DROP TABLE IF EXISTS `ItemVenta`;
CREATE TABLE `ItemVenta` (
  `idItemVenta` int NOT NULL AUTO_INCREMENT,
  `idVenta` int NOT NULL,
  `idAudio` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idItemVenta`,`idVenta`,`idAudio`),
  KEY `fk_ItemVenta_Venta1_idx` (`idVenta`),
  KEY `fk_ItemVenta_Audio1_idx` (`idAudio`),
  CONSTRAINT `fk_ItemVenta_1` FOREIGN KEY (`idVenta`) REFERENCES `Venta` (`idVenta`),
  CONSTRAINT `fk_ItemVenta_2` FOREIGN KEY (`idAudio`) REFERENCES `Audio` (`idAudio`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ItemVenta`
--

INSERT INTO `ItemVenta` VALUES (1,1,2,1),(2,1,3,5),(3,2,1,3),(4,2,2,1),(5,3,3,7),(6,3,1,1);
