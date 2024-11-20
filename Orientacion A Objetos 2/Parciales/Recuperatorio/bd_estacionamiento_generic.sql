CREATE DATABASE  IF NOT EXISTS `bd_estacionamiento`;
USE `bd_estacionamiento`;

--
-- Table structure for table `Vehiculo`
--

DROP TABLE IF EXISTS `Vehiculo`;
CREATE TABLE `Vehiculo` (
  `idVehiculo` int NOT NULL AUTO_INCREMENT,
  `patente` varchar(7) NOT NULL,
  PRIMARY KEY (`idVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Vehiculo`
--

INSERT INTO `Vehiculo` VALUES (1,'135ASD'),(2,'166DIK'),(3,'653OOI'),(4,'775DJK'),(5,'ES486GR'),(6,'UF447AF'),(7,'VC325OI'),(8,'OI654EE');


--
-- Table structure for table `Automovil`
--

DROP TABLE IF EXISTS `Automovil`;
CREATE TABLE `Automovil` (
  `idAutomovil` int NOT NULL,
  `esPickup` bit(1) NOT NULL,
  PRIMARY KEY (`idAutomovil`),
  CONSTRAINT `fk_Automovil_1` FOREIGN KEY (`idAutomovil`) REFERENCES `Vehiculo` (`idVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Automovil`
--

INSERT INTO `Automovil` VALUES (1,_binary ''),(2,_binary '\0'),(3,_binary '\0'),(4,_binary '');

--
-- Table structure for table `Moto`
--

DROP TABLE IF EXISTS `Moto`;
CREATE TABLE `Moto` (
  `idMoto` int NOT NULL,
  `esMensajeria` bit(1) NOT NULL,
  PRIMARY KEY (`idMoto`),
  CONSTRAINT `fk_Moto_1` FOREIGN KEY (`idMoto`) REFERENCES `Vehiculo` (`idVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Moto`
--

INSERT INTO `Moto` VALUES (5,_binary '\0'),(6,_binary ''),(7,_binary '\0'),(8,_binary '');

--
-- Table structure for table `Ticket`
--

DROP TABLE IF EXISTS `Ticket`;
CREATE TABLE `Ticket` (
  `idTicket` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `horaIngreso` time NOT NULL,
  `horaEgreso` time DEFAULT NULL,
  `monto` float NOT NULL DEFAULT '0',
  `idVehiculo` int NOT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `fk_Ticket_1_idx` (`idVehiculo`),
  CONSTRAINT `fk_Ticket_1` FOREIGN KEY (`idVehiculo`) REFERENCES `Vehiculo` (`idVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Ticket`
--

INSERT INTO `Ticket` VALUES (1,'2024-06-11','09:30:00',NULL,0,2),(2,'2024-06-11','11:30:00','13:15:00',2250,1),(3,'2024-06-11','12:30:00',NULL,0,4),(4,'2024-06-11','08:30:00',NULL,0,3),(5,'2024-06-11','10:00:00',NULL,0,8),(6,'2024-06-11','10:15:00',NULL,0,5),(7,'2024-06-11','11:20:00','16:05:00',71125,6);
