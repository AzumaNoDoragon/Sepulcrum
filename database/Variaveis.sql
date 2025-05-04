-- -----------------------------------------------------
-- Table `Sepulcrum`.`COVEIRO`
-- -----------------------------------------------------
--`COV_CPF` VARCHAR(15) NOT ***, PK 
--`COV_NOME` VARCHAR(150) ***, 
--`COV_RG` VARCHAR(15) NULL,
--`COV_DATA_NASCIMENTO` DATE ***,
--`COV_EMAIL` VARCHAR(150) ***,
--`COV_TELEFONE` VARCHAR(45) ***,
--`COV_CARGO` VARCHAR(150) ***, <<<<<<<<<<Conferir se está enum>>>>>>>>>>
--`COV_DATA_CONTRATACAO` DATE ***,
--`CEM_CNPJ` VARCHAR(15) ***, FK.CEMITERIO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`ADM`
-- -----------------------------------------------------
--`ADM_CPF` VARCHAR(11) NOT NULL, PK FK.COVEIRO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`CEMITERIO`
-- -----------------------------------------------------
--`CEM_CNPJ` VARCHAR(15) NOT ***, PK
--`CEM_NUMERO` VARCHAR(15) ***,
--`CEM_RUA` VARCHAR(150) ***,
--`CEM_NOME` VARCHAR(150) ***,
--`CEM_ESTADO` VARCHAR(45) ***,
--`CEM_CIDADE` VARCHAR(45) ***,
--`CEM_TELEFONE` VARCHAR(45) ***,
--`CEM_CEP` VARCHAR(45) ***,
--`CEM_CAPACIDADE` INT NULL,
--`ADM_CPF` VARCHAR(11) ***, FK.ADM

-- -----------------------------------------------------
-- Table `Sepulcrum`.`TUMULO`
-- -----------------------------------------------------
--`TUM_NUMERO` VARCHAR(15) NOT ***, PK
--`TUM_RUA` VARCHAR(150) NOT ***, <<<<<<<<<<faltou PK>>>>>>>>>>
--`TUM_TIPO` VARCHAR(150) ***, <<<<<<<<<<Conferir se está enum>>>>>>>>>>
--`TUM_DATA_OCUPACAO` DATE NULL,
--`TUM_SITUACAO` VARCHAR(150) ***, <<<<<<<<<<Conferir se está enum>>>>>>>>>>
--`CEM_CNPJ` VARCHAR(15) NOT ***, FK.CEMITERIO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`FINADO`
-- -----------------------------------------------------
--`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT ***, PK
--`FIN_CPF` VARCHAR(15) ***, cpf não fica nulo, é sobreescrito por certObito
--`FIN_NOME` VARCHAR(150) NULL,
--`FIN_RG` VARCHAR(15) NULL,
--`FIN_DATA_NASCIMENTO` DATE ***, setar valor padrão caso não tenha
--`FIN_DATA_FALECIMENTO` DATE ***,
--`FIN_CAUSA_MORTE` VARCHAR(150) ***,
--`TUM_NUMERO` VARCHAR(15) NOT ***, FK.TUMULO
--`TUM_RUA` VARCHAR(150) NOT ***, FK.TUMULO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`FAMILIAR`
-- -----------------------------------------------------
--`FAM_CPF` VARCHAR(15) NOT ***, PK
--`FAM_NOME` VARCHAR(150) ***,
--`FAM_RG` VARCHAR(15) NULL,
--`FAM_DATA_NASCIMENTO` DATE ***,
--`FAM_EMAIL` VARCHAR(150) ***,
--`FAM_TELEFONE` VARCHAR(15) ***,
--`FAM_GRAU_PARENTESCO` VARCHAR(150) NULL, <<<<<<<<<<Conferir se está enum>>>>>>>>>>

-- -----------------------------------------------------
-- Table `Sepulcrum`.`SERVICOS`
-- -----------------------------------------------------
--`SER_ID` INT NOT ***, PK INCREMENTAL
--`SER_TIPO` VARCHAR(45) NOT ***, PK <<<<<<<<<<Conferir se está enum>>>>>>>>>>
--`SER_DESCRICAO` VARCHAR(150) ***,
--`SER_INFORMACOES_ADICIONAIS` VARCHAR(150) NULL,
--`SER_STATUS` VARCHAR(150) NULL, <<<<<<<<<<Conferir se está enum>>>>>>>>>>
--`COV_CPF` VARCHAR(15) NOT ***, FK.COVEIRO 
--`TUM_RUA` VARCHAR(15) NOT ***, FK.TUMULO
--`TUM_NUMERO` VARCHAR(15) NOT ***, FK.TUMULO
--`CEM_CNPJ` VARCHAR(15) NOT ***, FK.TUMULO

-- -----------------------------------------------------
-- Table `Sepulcrum`.`EXUMACAO`
-- -----------------------------------------------------
--`SERVICOS_SER_ID` INT NOT ***, PK FK.SERVICOS
--`FIN_CERTIDAO_OBITO` VARCHAR(15) NOT ***, FK.FINADO

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

-- -----------------------------------------------------
-- Table `Sepulcrum`.`Responsavel_Tumulo` ASSOCIACAO
-- -----------------------------------------------------
`FAM_CPF` VARCHAR(15) NOT NULL, PK.FAMILIAR
`TUM_NUMERO` VARCHAR(15) NOT NULL, PK.TUMULO
`TUM_RUA` VARCHAR(150) NOT NULL, PK.TUMULO
`CEM_CNPJ` VARCHAR(15) NOT NULL, PK.CEMITEIRO