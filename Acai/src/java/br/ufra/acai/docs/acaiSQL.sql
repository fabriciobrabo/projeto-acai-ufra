SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema acai
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `acai` ;
CREATE SCHEMA IF NOT EXISTS `acai` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `acai` ;

-- -----------------------------------------------------
-- Table `acai`.`associacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acai`.`associacao` ;

CREATE TABLE IF NOT EXISTS `acai`.`associacao` (
  `associacao` INT NOT NULL AUTO_INCREMENT,
  `responsavel` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `localizacao` VARCHAR(45) NOT NULL,
  `descricao_Atividade` VARCHAR(300) NULL,
  PRIMARY KEY (`associacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acai`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acai`.`usuario` ;

CREATE TABLE IF NOT EXISTS `acai`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(200) NOT NULL,
  `perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acai`.`local`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acai`.`local` ;

CREATE TABLE IF NOT EXISTS `acai`.`local` (
  `local` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `localidade` VARCHAR(45) NOT NULL,
  `complemento` LONGTEXT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  `validado` TINYINT(1) NULL,
  PRIMARY KEY (`local`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acai`.`produtor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acai`.`produtor` ;

CREATE TABLE IF NOT EXISTS `acai`.`produtor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NULL,
  `associacao` INT NULL,
  `usuario` INT NULL,
  `local` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Produtor_Associacao1_idx` (`associacao` ASC),
  INDEX `fk_produtor_usuario1_idx` (`usuario` ASC),
  INDEX `fk_produtor_local1_idx` (`local` ASC),
  CONSTRAINT `fk_Produtor_Associacao1`
    FOREIGN KEY (`associacao`)
    REFERENCES `acai`.`associacao` (`associacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtor_usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `acai`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtor_local1`
    FOREIGN KEY (`local`)
    REFERENCES `acai`.`local` (`local`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acai`.`colheita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acai`.`colheita` ;

CREATE TABLE IF NOT EXISTS `acai`.`colheita` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_colheita` DATETIME NOT NULL,
  `produtor` INT NOT NULL,
  `peso` DECIMAL(6,3) NULL COMMENT 'quantidade aproximada de açai colhido',
  `observacao` VARCHAR(45) NULL COMMENT 'quantidade de cachos; ' /* comment truncated */ /*se todos estavam maduros; 
etc...
*/,
  `local` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Acai_Produtor1_idx` (`produtor` ASC),
  INDEX `fk_extracao_local1_idx` (`local` ASC),
  CONSTRAINT `fk_Acai_Produtor1`
    FOREIGN KEY (`produtor`)
    REFERENCES `acai`.`produtor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_extracao_local1`
    FOREIGN KEY (`local`)
    REFERENCES `acai`.`local` (`local`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acai`.`rasa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acai`.`rasa` ;

CREATE TABLE IF NOT EXISTS `acai`.`rasa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `volume` DECIMAL(6,3) NOT NULL COMMENT 'em quilogramas',
  `codigo` VARCHAR(45) NULL,
  `complemento` VARCHAR(100) NULL COMMENT 'informações adicionais a critério do produtor',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acai`.`produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acai`.`produto` ;

CREATE TABLE IF NOT EXISTS `acai`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rasa` INT NOT NULL,
  `colheita` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_rasa1_idx` (`rasa` ASC),
  INDEX `fk_produto_colheita1_idx` (`colheita` ASC),
  CONSTRAINT `fk_produto_rasa1`
    FOREIGN KEY (`rasa`)
    REFERENCES `acai`.`rasa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_colheita1`
    FOREIGN KEY (`colheita`)
    REFERENCES `acai`.`colheita` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
