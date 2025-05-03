-- -----------------------------------------------------
-- Table `Sepulcrum`.`COVEIRO`
-- -----------------------------------------------------
`COV_CPF` VARCHAR(15) NOT NULL, PK
`COV_NOME` VARCHAR(150) NULL,
`COV_RG` VARCHAR(15) NULL,
`COV_DATA_NASCIMENTO` DATE NULL,
`COV_EMAIL` VARCHAR(150) NULL,
`COV_TELEFONE` VARCHAR(45) NULL,
`COV_CARGO` VARCHAR(150) NULL,
`COV_DATA_CONTRATACAO` DATE NULL,
`CEM_CNPJ` VARCHAR(15) NULL, FK.CEMITERIO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`ADM`
-- -----------------------------------------------------
`ADM_CPF` VARCHAR(11) NOT NULL, PK FK.COVEIRO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`CEMITERIO`
-- -----------------------------------------------------
`CEM_CNPJ` VARCHAR(15) NOT NULL, PK
`CEM_NUMERO` VARCHAR(15) NULL,
`CEM_RUA` VARCHAR(150) NULL,
`CEM_NOME` VARCHAR(150) NULL,
`CEM_ESTADO` VARCHAR(45) NULL,
`CEM_CIDADE` VARCHAR(45) NULL,
`CEM_TELEFONE` VARCHAR(45) NULL,
`CEM_CEP` VARCHAR(45) NULL,
`CEM_CAPACIDADE` INT NULL,
`ADM_CPF` VARCHAR(11) NULL, FK.ADM

-- -----------------------------------------------------
-- Table `Sepulcrum`.`TUMULO`
-- -----------------------------------------------------
`TUM_NUMERO` VARCHAR(15) NOT NULL, PK
`TUM_RUA` VARCHAR(150) NOT NULL,
`TUM_TIPO` VARCHAR(150) NULL,
`TUM_DATA_OCUPACAO` DATE NULL,
`TUM_SITUACAO` VARCHAR(150) NULL,
`CEM_CNPJ` VARCHAR(15) NOT NULL, FK.CEMITERIO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`FINADO`
-- -----------------------------------------------------
`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL, PK
`FIN_CPF` VARCHAR(15) NULL,
`FIN_NOME` VARCHAR(150) NULL,
`FIN_RG` VARCHAR(15) NULL,
`FIN_DATA_NASCIMENTO` DATE NULL,
`FIN_DATA_FALECIMENTO` DATE NULL,
`FIN_CAUSA_MORTE` VARCHAR(150) NULL,
`TUM_NUMERO` VARCHAR(15) NOT NULL, FK.TUMULO
`TUM_RUA` VARCHAR(150) NOT NULL, FK.TUMULO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`FAMILIAR`
-- -----------------------------------------------------
`FAM_CPF` VARCHAR(15) NOT NULL, PK
`FAM_NOME` VARCHAR(150) NULL,
`FAM_RG` VARCHAR(15) NULL,
`FAM_DATA_NASCIMENTO` DATE NULL,
`FAM_EMAIL` VARCHAR(150) NULL,
`FAM_TELEFONE` VARCHAR(15) NULL,
`FAM_GRAU_PARENTESCO` VARCHAR(150) NULL,

-- -----------------------------------------------------
-- Table `Sepulcrum`.`Responsavel_Tumulo` ASSOCIACAO
-- -----------------------------------------------------
`FAM_CPF` VARCHAR(15) NOT NULL, PK.FAMILIAR
`TUM_NUMERO` VARCHAR(15) NOT NULL, PK.TUMULO
`TUM_RUA` VARCHAR(150) NOT NULL, PK.TUMULO
`CEM_CNPJ` VARCHAR(15) NOT NULL, PK.CEMITEIRO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`SERVICOS`
-- -----------------------------------------------------
`SER_ID` INT NOT NULL, PK INCREMENTAL
`SER_TIPO` VARCHAR(45) NOT NULL, PK
`SER_DESCRICAO` VARCHAR(150) NULL,
`SER_INFORMACOES_ADICIONAIS` VARCHAR(150) NULL,
`SER_STATUS` VARCHAR(150) NULL,
`COV_CPF` VARCHAR(15) NOT NULL, FK.COVEIRO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`EXUMACAO`
-- -----------------------------------------------------
`SERVICOS_SER_ID` INT NOT NULL, PK FK.SERVICOS
`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL, FK.FINADO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`RESERVA_TUMULO`
-- -----------------------------------------------------
`SER_ID` INT NOT NULL, PK FK.SERVICOS
`FAM_CPF` VARCHAR(15) NOT NULL, FK.FAMILIAR

-- -----------------------------------------------------
-- Table `Sepulcrum`.`TRANSFERENCIA_DEFUNTO`
-- -----------------------------------------------------
`SER_ID` INT NOT NULL, PK FK.SERVICOS
`TUM_NUMERO` VARCHAR(15) NOT NULL, FK.TUMULO
`TUM_RUA` VARCHAR(150) NOT NULL, FK.TUMULO
`CEM_CNPJ` VARCHAR(15) NOT NULL, FK.CEMITEIRO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`RESPONSAVEL_FINADO` ASSOCIACAO
-- -----------------------------------------------------
`FAM_CPF` VARCHAR(15) NOT NULL, PK.FAMILIAR
`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT NULL, PK.FINADO
