-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Sepulcrum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Sepulcrum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Sepulcrum` ;
USE `Sepulcrum` ;

-- -----------------------------------------------------
-- Table `Sepulcrum`.`COVEIRO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`COVEIRO` (
  `COV_CPF` VARCHAR(15) NOT NULL,
  `COV_NOME` VARCHAR(150) NOT NULL,
  `COV_RG` VARCHAR(15) NULL,
  `COV_DATA_NASCIMENTO` DATE NOT NULL,
  `COV_EMAIL` VARCHAR(150) NOT NULL,
  `COV_TELEFONE` VARCHAR(45) NOT NULL,
  `COV_CARGO` ENUM('Adm', 'Coveiro') NOT NULL,
  `COV_DATA_CONTRATACAO` DATE NOT NULL,
  `CEM_CNPJ` VARCHAR(15) NULL,
  PRIMARY KEY (`COV_CPF`),
  INDEX `fk_COVEIRO_CEMITERIO1_idx` (`CEM_CNPJ` ASC) VISIBLE,
  CONSTRAINT `fk_COVEIRO_CEMITERIO1`
    FOREIGN KEY (`CEM_CNPJ`)
    REFERENCES `Sepulcrum`.`CEMITERIO` (`CEM_CNPJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`ADM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`ADM` (
  `ADM_CPF` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`ADM_CPF`),
  CONSTRAINT `fk_ADM_COVEIRO1`
    FOREIGN KEY (`ADM_CPF`)
    REFERENCES `Sepulcrum`.`COVEIRO` (`COV_CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`CEMITERIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`CEMITERIO` (
  `CEM_CNPJ` VARCHAR(15) NOT NULL,
  `CEM_NUMERO` VARCHAR(15) NOT NULL,
  `CEM_RUA` VARCHAR(150) NOT NULL,
  `CEM_NOME` VARCHAR(150) NOT NULL,
  `CEM_ESTADO` VARCHAR(45) NOT NULL,
  `CEM_CIDADE` VARCHAR(45) NOT NULL,
  `CEM_TELEFONE` VARCHAR(45) NOT NULL,
  `CEM_CEP` VARCHAR(45) NOT NULL,
  `CEM_CAPACIDADE` INT NULL,
  `ADM_CPF` VARCHAR(11) NULL,
  PRIMARY KEY (`CEM_CNPJ`),
  INDEX `fk_CEMITERIO_ADM1_idx` (`ADM_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_CEMITERIO_ADM1`
    FOREIGN KEY (`ADM_CPF`)
    REFERENCES `Sepulcrum`.`ADM` (`ADM_CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`TUMULO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`TUMULO` (
  `TUM_NUMERO` VARCHAR(15) NOT NULL,
  `TUM_RUA` VARCHAR(150) NOT NULL,
  `TUM_TIPO` ENUM('CovaRasa', 'TumuloAlvenaria', 'JazigoPerpetuo', 'Ossuario', 'Mausoleu', 'Columbario') NOT NULL,
  `TUM_DATA_OCUOPACAO` DATE NULL,
  `TUM_SITUACAO` ENUM('Vazio', 'Reservado', 'Comprado', 'Ocupado', 'Manutencao', 'AguardandoExumação', 'DesativadoIndisponível') NOT NULL,
  `CEM_CNPJ` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`TUM_NUMERO`, `TUM_RUA`, `CEM_CNPJ`),
  INDEX `fk_TUMULO_CEMITERIO_idx` (`CEM_CNPJ` ASC) VISIBLE,
  CONSTRAINT `fk_TUMULO_CEMITERIO`
    FOREIGN KEY (`CEM_CNPJ`)
    REFERENCES `Sepulcrum`.`CEMITERIO` (`CEM_CNPJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`FINADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`FINADO` (
  `FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,
  `FIN_CPF` VARCHAR(15) NOT NULL,
  `FIN_NOME` VARCHAR(150) NOT NULL,
  `FIN_RG` VARCHAR(15) NULL,
  `FIN_DATA_NASCIMENTO` DATE NOT NULL,
  `FIN_DATA_FALECIMENTO` DATE NOT NULL,
  `FIN_CAUSA_MORTE` VARCHAR(150) NOT NULL,
  `TUM_NUMERO` VARCHAR(15) NOT NULL,
  `TUM_RUA` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`FIN_CERTIDAO_OBITO`, `TUM_NUMERO`, `TUM_RUA`),
  INDEX `fk_FINADO_TUMULO1_idx` (`TUM_NUMERO` ASC, `TUM_RUA` ASC) VISIBLE,
  CONSTRAINT `fk_FINADO_TUMULO1`
    FOREIGN KEY (`TUM_NUMERO` , `TUM_RUA`)
    REFERENCES `Sepulcrum`.`TUMULO` (`TUM_NUMERO` , `TUM_RUA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`FAMILIAR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`FAMILIAR` (
  `FAM_CPF` VARCHAR(15) NOT NULL,
  `FAM_NOME` VARCHAR(150) NOT NULL,
  `FAM_RG` VARCHAR(15) NULL,
  `FAM_DATA_NASCIMENTO` DATE NOT NULL,
  `FAM_EMAIL` VARCHAR(150) NOT NULL,
  `FAM_TELEFONE` VARCHAR(15) NOT NULL,
  `FAM_GRAU_PARENTESCO` ENUM('Ascendente', 'Descendente', 'Colateral', 'Conjuge', 'NaoParente') NOT NULL,
  PRIMARY KEY (`FAM_CPF`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`Responsavel_Tumulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`Responsavel_Tumulo` (
  `FAM_CPF` VARCHAR(15) NOT NULL,
  `TUM_NUMERO` VARCHAR(15) NOT NULL,
  `TUM_RUA` VARCHAR(150) NOT NULL,
  `CEM_CNPJ` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`FAM_CPF`, `TUM_NUMERO`, `TUM_RUA`, `CEM_CNPJ`),
  INDEX `fk_FAMILIAR_has_TUMULO_TUMULO1_idx` (`TUM_NUMERO` ASC, `TUM_RUA` ASC, `CEM_CNPJ` ASC) VISIBLE,
  INDEX `fk_FAMILIAR_has_TUMULO_FAMILIAR1_idx` (`FAM_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_FAMILIAR_has_TUMULO_FAMILIAR1`
    FOREIGN KEY (`FAM_CPF`)
    REFERENCES `Sepulcrum`.`FAMILIAR` (`FAM_CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FAMILIAR_has_TUMULO_TUMULO1`
    FOREIGN KEY (`TUM_NUMERO` , `TUM_RUA` , `CEM_CNPJ`)
    REFERENCES `Sepulcrum`.`TUMULO` (`TUM_NUMERO` , `TUM_RUA` , `CEM_CNPJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`SERVICOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`SERVICOS` (
  `SER_ID` INT NOT NULL AUTO_INCREMENT,
  `SER_TIPO` ENUM('Exumacao', 'ManutencaoTumulo', 'ReservaTumulo', 'TransferenciaTumulo', 'Vistoria') NOT NULL,
  `SER_DESCRICAO` VARCHAR(150) NOT NULL,
  `SER_INFORMACOES_ADICIONAIS` VARCHAR(150) NULL,
  `SER_STATUS` ENUM('Marcado', 'Andamento', 'Concluido', 'Adiado', 'Cancelado') NULL,
  `COV_CPF` VARCHAR(15) NOT NULL,
  `TUMULO_TUM_NUMERO` VARCHAR(15) NOT NULL,
  `TUMULO_TUM_RUA` VARCHAR(150) NOT NULL,
  `TUMULO_CEM_CNPJ` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`SER_ID`),
  INDEX `fk_SERVICOS_COVEIRO1_idx` (`COV_CPF` ASC) VISIBLE,
  INDEX `fk_SERVICOS_TUMULO1_idx` (`TUMULO_TUM_NUMERO` ASC, `TUMULO_TUM_RUA` ASC, `TUMULO_CEM_CNPJ` ASC) VISIBLE,
  CONSTRAINT `fk_SERVICOS_COVEIRO1`
    FOREIGN KEY (`COV_CPF`)
    REFERENCES `Sepulcrum`.`COVEIRO` (`COV_CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SERVICOS_TUMULO1`
    FOREIGN KEY (`TUMULO_TUM_NUMERO` , `TUMULO_TUM_RUA` , `TUMULO_CEM_CNPJ`)
    REFERENCES `Sepulcrum`.`TUMULO` (`TUM_NUMERO` , `TUM_RUA` , `CEM_CNPJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`EXUMACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`EXUMACAO` (
  `SER_ID` INT NOT NULL,
  `FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,
  INDEX `fk_EXUMACAO_FINADO1_idx` (`FIN_CERTIDAO_OBITO` ASC) VISIBLE,
  PRIMARY KEY (`SER_ID`),
  CONSTRAINT `fk_EXUMACAO_FINADO1`
    FOREIGN KEY (`FIN_CERTIDAO_OBITO`)
    REFERENCES `Sepulcrum`.`FINADO` (`FIN_CERTIDAO_OBITO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EXUMACAO_SERVICOS1`
    FOREIGN KEY (`SER_ID`)
    REFERENCES `Sepulcrum`.`SERVICOS` (`SER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`RESERVA_TUMULO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`RESERVA_TUMULO` (
  `SER_ID` INT NOT NULL,
  `FAM_CPF` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`SER_ID`),
  INDEX `fk_RESERVA_TUMULO_FAMILIAR1_idx` (`FAM_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_RESERVA_TUMULO_SERVICOS1`
    FOREIGN KEY (`SER_ID`)
    REFERENCES `Sepulcrum`.`SERVICOS` (`SER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RESERVA_TUMULO_FAMILIAR1`
    FOREIGN KEY (`FAM_CPF`)
    REFERENCES `Sepulcrum`.`FAMILIAR` (`FAM_CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`TRANSFERENCIA_DEFUNTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`TRANSFERENCIA_DEFUNTO` (
  `SER_ID` INT NOT NULL,
  `TUM_NUMERO` VARCHAR(15) NOT NULL,
  `TUM_RUA` VARCHAR(150) NOT NULL,
  `CEM_CNPJ` VARCHAR(15) NOT NULL,
  `FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`SER_ID`),
  INDEX `fk_TRANSFERENCIA_DEFUNTO_TUMULO1_idx` (`TUM_NUMERO` ASC, `TUM_RUA` ASC, `CEM_CNPJ` ASC) VISIBLE,
  INDEX `fk_TRANSFERENCIA_DEFUNTO_FINADO1_idx` (`FIN_CERTIDAO_OBITO` ASC) VISIBLE,
  CONSTRAINT `fk_TRANSFERENCIA_DEFUNTO_SERVICOS1`
    FOREIGN KEY (`SER_ID`)
    REFERENCES `Sepulcrum`.`SERVICOS` (`SER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TRANSFERENCIA_DEFUNTO_TUMULO1`
    FOREIGN KEY (`TUM_NUMERO` , `TUM_RUA` , `CEM_CNPJ`)
    REFERENCES `Sepulcrum`.`TUMULO` (`TUM_NUMERO` , `TUM_RUA` , `CEM_CNPJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TRANSFERENCIA_DEFUNTO_FINADO1`
    FOREIGN KEY (`FIN_CERTIDAO_OBITO`)
    REFERENCES `Sepulcrum`.`FINADO` (`FIN_CERTIDAO_OBITO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sepulcrum`.`RESPONSAVEL_FINADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sepulcrum`.`RESPONSAVEL_FINADO` (
  `FAM_CPF` VARCHAR(15) NOT NULL,
  `FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`FAM_CPF`, `FIN_CERTIDAO_OBITO`),
  INDEX `fk_FAMILIAR_has_FINADO_FINADO1_idx` (`FIN_CERTIDAO_OBITO` ASC) VISIBLE,
  INDEX `fk_FAMILIAR_has_FINADO_FAMILIAR1_idx` (`FAM_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_FAMILIAR_has_FINADO_FAMILIAR1`
    FOREIGN KEY (`FAM_CPF`)
    REFERENCES `Sepulcrum`.`FAMILIAR` (`FAM_CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FAMILIAR_has_FINADO_FINADO1`
    FOREIGN KEY (`FIN_CERTIDAO_OBITO`)
    REFERENCES `Sepulcrum`.`FINADO` (`FIN_CERTIDAO_OBITO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- ------------------------------------------------------- ------------------------------------------------------- -----------------------------------------------------
-- -----------------------------------------------------
-- Inserindo primeiro cemitério vinculado ao root
-- -----------------------------------------------------
INSERT INTO `Sepulcrum`.`CEMITERIO` (
  CEM_CNPJ, CEM_NUMERO, CEM_RUA, CEM_NOME, 
  CEM_ESTADO, CEM_CIDADE, CEM_TELEFONE, CEM_CEP, 
  CEM_CAPACIDADE, ADM_CPF
) VALUES (
  '12345678901234', '001', 'Rua Central', 'Cemitério Municipal',
  'PR', 'Cornélio Procópio', '4300000000', '86300000',
  1000, '00000000000'
);

-- -----------------------------------------------------
-- Inserindo root na tabela COVEIRO
-- -----------------------------------------------------
INSERT INTO `Sepulcrum`.`COVEIRO` (
  COV_CPF, COV_NOME, COV_RG, COV_DATA_NASCIMENTO, 
  COV_EMAIL, COV_TELEFONE, COV_CARGO, COV_DATA_CONTRATACAO, CEM_CNPJ
) VALUES (
  '00000000000', 'Root Admin', '0000000', '1970-01-01',
  'root@sepulcrum.com', '00000000000', 'Administrador Geral', '2025-01-01', '12345678901234'
);

-- -----------------------------------------------------
-- Inserindo root na tabela ADM
-- -----------------------------------------------------
INSERT INTO `Sepulcrum`.`ADM` (ADM_CPF)
VALUES ('00000000000');

-- -----------------------------------------------------
-- Alterar COVEIRO.CEM_CNPJ para NOT NULL
-- -----------------------------------------------------
ALTER TABLE `Sepulcrum`.`COVEIRO`
MODIFY COLUMN `CEM_CNPJ` VARCHAR(15) NOT NULL;

-- -----------------------------------------------------
-- Alterar CEMITERIO.ADM_COV_CPF para NOT NULL
-- -----------------------------------------------------
ALTER TABLE `Sepulcrum`.`CEMITERIO`
MODIFY COLUMN `ADM_CPF` VARCHAR(11) NOT NULL;

-- ------------------------------------------------------- ------------------------------------------------------- -----------------------------------------------------

-- -----------------------------------------------------
-- Configurações de ambiente
-- -----------------------------------------------------
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
