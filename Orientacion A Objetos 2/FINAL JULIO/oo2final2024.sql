-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema oo2final
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema oo2final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `oo2final` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `oo2final` ;

-- -----------------------------------------------------
-- Table `oo2final`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oo2final`.`plan` (
  `id_plan` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `costo_base` DOUBLE NOT NULL,
  `descuento` DOUBLE NOT NULL,
  `cobertura` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_plan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oo2final`.`afiliado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oo2final`.`afiliado` (
  `id_afiliado` INT NOT NULL AUTO_INCREMENT,
  `nro_afiliado` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_alta` DATE NOT NULL,
  `id_plan` INT NOT NULL,
  PRIMARY KEY (`id_afiliado`),
  INDEX `fk_afiliado_plan_idx` (`id_plan` ASC) VISIBLE,
  CONSTRAINT `fk_afiliado_plan`
    FOREIGN KEY (`id_plan`)
    REFERENCES `oo2final`.`plan` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oo2final`.`base`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oo2final`.`base` (
  `id_base` INT NOT NULL,
  `limite_consultas_gratis` INT NOT NULL,
  `costo_adicional` DOUBLE NOT NULL,
  PRIMARY KEY (`id_base`),
  CONSTRAINT `fk_base_plan1`
    FOREIGN KEY (`id_base`)
    REFERENCES `oo2final`.`plan` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oo2final`.`premium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oo2final`.`premium` (
  `id_premium` INT NOT NULL,
  `servicio_adicional` VARCHAR(45) NOT NULL,
  `tarifa_adicional` DOUBLE NOT NULL,
  PRIMARY KEY (`id_premium`),
  CONSTRAINT `fk_premium_plan1`
    FOREIGN KEY (`id_premium`)
    REFERENCES `oo2final`.`plan` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `oo2final`.`plan`
-- -----------------------------------------------------
START TRANSACTION;
USE `oo2final`;
INSERT INTO `oo2final`.`plan` (`id_plan`, `nombre`, `costo_base`, `descuento`, `cobertura`) VALUES (1, 'Plan Base 1', 100, 10, 'Parcial');
INSERT INTO `oo2final`.`plan` (`id_plan`, `nombre`, `costo_base`, `descuento`, `cobertura`) VALUES (2, 'Plan Base 2', 150, 10, 'Parcial');
INSERT INTO `oo2final`.`plan` (`id_plan`, `nombre`, `costo_base`, `descuento`, `cobertura`) VALUES (3, 'Plan Base 3', 200, 10, 'Total');
INSERT INTO `oo2final`.`plan` (`id_plan`, `nombre`, `costo_base`, `descuento`, `cobertura`) VALUES (4, 'Plan Premium 1', 250, 20, 'Total');
INSERT INTO `oo2final`.`plan` (`id_plan`, `nombre`, `costo_base`, `descuento`, `cobertura`) VALUES (5, 'Plan Premium 2', 300, 20, 'Total');
INSERT INTO `oo2final`.`plan` (`id_plan`, `nombre`, `costo_base`, `descuento`, `cobertura`) VALUES (6, 'Plan Premium 3', 350, 20, 'Total');

COMMIT;


-- -----------------------------------------------------
-- Data for table `oo2final`.`afiliado`
-- -----------------------------------------------------
START TRANSACTION;
USE `oo2final`;
INSERT INTO `oo2final`.`afiliado` (`id_afiliado`, `nro_afiliado`, `nombre`, `apellido`, `fecha_alta`, `id_plan`) VALUES (1, '1', 'Oscar', 'Ruina', '2022-1-15', 1);
INSERT INTO `oo2final`.`afiliado` (`id_afiliado`, `nro_afiliado`, `nombre`, `apellido`, `fecha_alta`, `id_plan`) VALUES (2, '2', 'Alejandra', 'Vranic', '2024-5-2', 2);
INSERT INTO `oo2final`.`afiliado` (`id_afiliado`, `nro_afiliado`, `nombre`, `apellido`, `fecha_alta`, `id_plan`) VALUES (3, '3', 'Gustavo', 'Siciliano', '2022-2-8', 5);
INSERT INTO `oo2final`.`afiliado` (`id_afiliado`, `nro_afiliado`, `nombre`, `apellido`, `fecha_alta`, `id_plan`) VALUES (4, '4', 'Ezequiel', 'Scordamaglia', '2024-6-30', 6);
INSERT INTO `oo2final`.`afiliado` (`id_afiliado`, `nro_afiliado`, `nombre`, `apellido`, `fecha_alta`, `id_plan`) VALUES (5, '5', 'Juan', 'Perez', '2024-5-10', 1);
INSERT INTO `oo2final`.`afiliado` (`id_afiliado`, `nro_afiliado`, `nombre`, `apellido`, `fecha_alta`, `id_plan`) VALUES (6, '6', 'Pablo', 'Perez', '2022-1-1', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `oo2final`.`base`
-- -----------------------------------------------------
START TRANSACTION;
USE `oo2final`;
INSERT INTO `oo2final`.`base` (`id_base`, `limite_consultas_gratis`, `costo_adicional`) VALUES (1, 1, 20);
INSERT INTO `oo2final`.`base` (`id_base`, `limite_consultas_gratis`, `costo_adicional`) VALUES (2, 2, 20);
INSERT INTO `oo2final`.`base` (`id_base`, `limite_consultas_gratis`, `costo_adicional`) VALUES (3, 3, 20);

COMMIT;


-- -----------------------------------------------------
-- Data for table `oo2final`.`premium`
-- -----------------------------------------------------
START TRANSACTION;
USE `oo2final`;
INSERT INTO `oo2final`.`premium` (`id_premium`, `servicio_adicional`, `tarifa_adicional`) VALUES (4, 'Servicio 1', 50);
INSERT INTO `oo2final`.`premium` (`id_premium`, `servicio_adicional`, `tarifa_adicional`) VALUES (5, 'Servicio 2', 100);
INSERT INTO `oo2final`.`premium` (`id_premium`, `servicio_adicional`, `tarifa_adicional`) VALUES (6, 'Servicio 3', 150);

COMMIT;

