-- -----------------------------------------------------
-- Table `Sepulcrum`.`COVEIRO`
-- -----------------------------------------------------
`COV_CPF` VARCHAR(15) NOT NULL,
`COV_NOME` VARCHAR(150) NOT NULL,
`COV_RG` VARCHAR(15) NULL,
`COV_DATA_NASCIMENTO` DATE NOT NULL,
`COV_EMAIL` VARCHAR(150) NOT NULL,
`COV_TELEFONE` VARCHAR(45) NOT NULL,
`COV_CARGO` ENUM('Adm', 'Coveiro') NOT NULL,
`COV_DATA_CONTRATACAO` DATE NOT NULL,
`CEM_CNPJ` VARCHAR(15) NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`ADM`
-- -----------------------------------------------------
`ADM_CPF` VARCHAR(11) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`CEMITERIO`
-- -----------------------------------------------------
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
-- -----------------------------------------------------
-- Table `Sepulcrum`.`TUMULO`
-- -----------------------------------------------------
`TUM_NUMERO` VARCHAR(15) NOT NULL,
`TUM_RUA` VARCHAR(150) NOT NULL,
`TUM_TIPO` ENUM('CovaRasa', 'TumuloAlvenaria', 'JazigoPerpetuo', 'Ossuario', 'Mausoleu', 'Columbario') NOT NULL,
`TUM_DATA_OCUOPACAO` DATE NULL,
`TUM_SITUACAO` ENUM('Vazio', 'Reservado', 'Comprado', 'Ocupado', 'Manutencao', 'AguardandoExumação', 'DesativadoIndisponível') NOT NULL,
`CEM_CNPJ` VARCHAR(15) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`FINADO`
-- -----------------------------------------------------
`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,
`FIN_CPF` VARCHAR(15) NOT NULL,
`FIN_NOME` VARCHAR(150) NOT NULL,
`FIN_RG` VARCHAR(15) NULL,
`FIN_DATA_NASCIMENTO` DATE NOT NULL,
`FIN_DATA_FALECIMENTO` DATE NOT NULL,
`FIN_CAUSA_MORTE` VARCHAR(150) NOT NULL,
`TUM_NUMERO` VARCHAR(15) NOT NULL,
`TUM_RUA` VARCHAR(150) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`FAMILIAR`
-- -----------------------------------------------------
`FAM_CPF` VARCHAR(15) NOT NULL,
`FAM_NOME` VARCHAR(150) NOT NULL,
`FAM_RG` VARCHAR(15) NULL,
`FAM_DATA_NASCIMENTO` DATE NOT NULL,
`FAM_EMAIL` VARCHAR(150) NOT NULL,
`FAM_TELEFONE` VARCHAR(15) NOT NULL,
`FAM_GRAU_PARENTESCO` ENUM('Ascendente', 'Descendente', 'Colateral', 'Conjuge', 'NaoParente') NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`Responsavel_Tumulo`
-- -----------------------------------------------------
`FAM_CPF` VARCHAR(15) NOT NULL,
`TUM_NUMERO` VARCHAR(15) NOT NULL,
`TUM_RUA` VARCHAR(150) NOT NULL,
`CEM_CNPJ` VARCHAR(15) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`SERVICOS`
-- -----------------------------------------------------
`SER_ID` INT NOT NULL AUTO_INCREMENT,
`SER_TIPO` ENUM('Exumacao', 'ManutencaoTumulo', 'ReservaTumulo', 'TransferenciaTumulo', 'Vistoria') NOT NULL,
`SER_DESCRICAO` VARCHAR(150) NOT NULL,
`SER_INFORMACOES_ADICIONAIS` VARCHAR(150) NULL,
`SER_STATUS` ENUM('Marcado', 'Andamento', 'Concluido', 'Adiado', 'Cancelado') NULL,
`COV_CPF` VARCHAR(15) NOT NULL,
`TUMULO_TUM_NUMERO` VARCHAR(15) NOT NULL,
`TUMULO_TUM_RUA` VARCHAR(150) NOT NULL,
`TUMULO_CEM_CNPJ` VARCHAR(15) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`EXUMACAO`
-- -----------------------------------------------------
`SER_ID` INT NOT NULL,
`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`RESERVA_TUMULO`
-- -----------------------------------------------------
`SER_ID` INT NOT NULL,
`FAM_CPF` VARCHAR(15) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`TRANSFERENCIA_DEFUNTO`
-- -----------------------------------------------------
`SER_ID` INT NOT NULL,
`TUM_NUMERO` VARCHAR(15) NOT NULL,
`TUM_RUA` VARCHAR(150) NOT NULL,
`CEM_CNPJ` VARCHAR(15) NOT NULL,
`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,
-- -----------------------------------------------------
-- Table `Sepulcrum`.`RESPONSAVEL_FINADO`
-- -----------------------------------------------------
`FAM_CPF` VARCHAR(15) NOT NULL,
`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL,