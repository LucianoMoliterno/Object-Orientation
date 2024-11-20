-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema stock
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stock` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `stock` ;

-- -----------------------------------------------------
-- Table `stock`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stock`.`lote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`lote` (
  `id_lote` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `id_producto` INT NOT NULL,
  PRIMARY KEY (`id_lote`),
  INDEX `fk_lote_producto_idx` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_lote_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `stock`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stock`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`stock` (
  `id_stock` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `id_lote` INT NOT NULL,
  `id_producto` INT NOT NULL,
  PRIMARY KEY (`id_stock`),
  INDEX `fk_stock_lote1_idx` (`id_lote` ASC) VISIBLE,
  INDEX `fk_stock_producto1_idx` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_stock_lote1`
    FOREIGN KEY (`id_lote`)
    REFERENCES `stock`.`lote` (`id_lote`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stock_producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `stock`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stock`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`almacen` (
  `id_almacen` INT NOT NULL,
  `ubicacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_almacen`),
  CONSTRAINT `fk_almacen_stock1`
    FOREIGN KEY (`id_almacen`)
    REFERENCES `stock`.`stock` (`id_stock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stock`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock`.`pedido` (
  `id_pedido` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  CONSTRAINT `fk_pedido_stock1`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `stock`.`stock` (`id_stock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `stock`.`producto`
-- -----------------------------------------------------
START TRANSACTION;
USE `stock`;
INSERT INTO `stock`.`producto` (`id_producto`, `codigo`, `nombre`, `precio`) VALUES (1, '1', 'parlantes', 10000);
INSERT INTO `stock`.`producto` (`id_producto`, `codigo`, `nombre`, `precio`) VALUES (2, '2', 'microfono', 8000);
INSERT INTO `stock`.`producto` (`id_producto`, `codigo`, `nombre`, `precio`) VALUES (3, '3', 'monitor', 15000);
INSERT INTO `stock`.`producto` (`id_producto`, `codigo`, `nombre`, `precio`) VALUES (4, '4', 'teclado', 3000);
INSERT INTO `stock`.`producto` (`id_producto`, `codigo`, `nombre`, `precio`) VALUES (5, '5', 'mouse', 2500);

COMMIT;


-- -----------------------------------------------------
-- Data for table `stock`.`lote`
-- -----------------------------------------------------
START TRANSACTION;
USE `stock`;
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (1, '1', 1);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (2, '2', 2);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (3, '3', 3);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (4, '4', 4);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (5, '5', 5);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (6, '6', 1);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (7, '7', 2);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (8, '8', 3);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (9, '9', 4);
INSERT INTO `stock`.`lote` (`id_lote`, `codigo`, `id_producto`) VALUES (10, '10', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `stock`.`stock`
-- -----------------------------------------------------
START TRANSACTION;
USE `stock`;
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (1, 50, 1, 1);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (2 , 75, 2, 2);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (3, 50, 3, 3);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (4, 175, 4, 4);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (5, 200, 5, 5);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (6, 100, 6, 1);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (7, 75, 7, 2);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (8, 30, 8, 3);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (9, 60, 9, 4);
INSERT INTO `stock`.`stock` (`id_stock`, `cantidad`, `id_lote`, `id_producto`) VALUES (10, 15, 10, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `stock`.`almacen`
-- -----------------------------------------------------
START TRANSACTION;
USE `stock`;
INSERT INTO `stock`.`almacen` (`id_almacen`, `ubicacion`) VALUES (2, 'Lanus');
INSERT INTO `stock`.`almacen` (`id_almacen`, `ubicacion`) VALUES (4, 'Banfield');
INSERT INTO `stock`.`almacen` (`id_almacen`, `ubicacion`) VALUES (5, 'Lanus');
INSERT INTO `stock`.`almacen` (`id_almacen`, `ubicacion`) VALUES (6, 'Lanus');
INSERT INTO `stock`.`almacen` (`id_almacen`, `ubicacion`) VALUES (7, 'Banfield');

COMMIT;


-- -----------------------------------------------------
-- Data for table `stock`.`pedido`
-- -----------------------------------------------------
START TRANSACTION;
USE `stock`;
INSERT INTO `stock`.`pedido` (`id_pedido`, `fecha`, `cliente`) VALUES (1, '2024-05-17', 'Juan');
INSERT INTO `stock`.`pedido` (`id_pedido`, `fecha`, `cliente`) VALUES (3, '2024-05-18', 'Juan');
INSERT INTO `stock`.`pedido` (`id_pedido`, `fecha`, `cliente`) VALUES (8, '2024-05-20', 'Pablo');
INSERT INTO `stock`.`pedido` (`id_pedido`, `fecha`, `cliente`) VALUES (9, '2024-05-21', 'Jose');
INSERT INTO `stock`.`pedido` (`id_pedido`, `fecha`, `cliente`) VALUES (10, '2024-05-23', 'Juan');

COMMIT;

