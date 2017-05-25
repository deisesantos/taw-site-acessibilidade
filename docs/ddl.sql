-- MySQL Workbench Synchronization

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `taw`.`escoteiro` (
  `registro` VARCHAR(30) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  `sobrenome` VARCHAR(100) NULL DEFAULT NULL,
  `patrulha_id` INT(11) NOT NULL,
  PRIMARY KEY (`registro`),
  INDEX `fk_escoteiro_patrulha1_idx` (`patrulha_id` ASC),
  CONSTRAINT `fk_escoteiro_patrulha1`
    FOREIGN KEY (`patrulha_id`)
    REFERENCES `taw`.`patrulha` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `taw`.`patrulha` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `taw`.`reuniao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tema` VARCHAR(100) NOT NULL,
  `objetivo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `taw`.`participacao_escoteiro` (
  `escoteiro_registro` VARCHAR(30) NOT NULL,
  `reuniao_id` INT(11) NOT NULL,
  `presenca` ENUM('PRESENTE', 'ATRASO', 'FALTOU', 'FALTA_JUSTIFICADA', 'PONTE', 'ROTA') NULL DEFAULT 'PRESENTE',
  `participacao` TINYINT(4) NULL DEFAULT NULL,
  `uniforme` TINYINT(4) NULL DEFAULT NULL,
  `disciplina` TINYINT(4) NULL DEFAULT NULL,
  `observacao` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`escoteiro_registro`, `reuniao_id`),
  INDEX `fk_participacao_escoteiro_reuniao_idx` (`reuniao_id` ASC),
  INDEX `fk_participacao_escoteiro_escoteiro_idx` (`escoteiro_registro` ASC),
  CONSTRAINT `fk_participacao_escoteiro_escoteiro`
    FOREIGN KEY (`escoteiro_registro`)
    REFERENCES `taw`.`escoteiro` (`registro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participacao_escoteiro_reuniao`
    FOREIGN KEY (`reuniao_id`)
    REFERENCES `taw`.`reuniao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
