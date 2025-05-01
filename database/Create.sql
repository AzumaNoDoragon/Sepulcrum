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