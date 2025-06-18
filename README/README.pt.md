# Sistema de Gerenciamento de Cemitério

Sistema desktop para gerenciamento de informações de falecidos, responsáveis, sepulturas e exumações. Desenvolvido em **Java**, com **interface gráfica (GUI)** e **integração com banco de dados**.

## Funcionalidades

- Cadastro, busca, edição e exclusão de:
  - Falecidos
  - Familiares responsáveis
  - Sepulturas
  - Funcionários/Administradores
- Consulta de dados por CPF ou CNPJ(PK's)
- Controle de serviços
- Validações de entrada (ex: datas, campos obrigatórios)
- Interface gráfica intuitiva
- Persistência dos dados em banco de dados

## Tecnologias Utilizadas

- **Java 21+**
- **Swing (GUI)**
- **MySQL (banco de dados relacional)**
- **VSCode** – IDE utilizada

## Como Executar

1. Clone o repositório:
  ```bash
  git clone https://github.com/AzumaNoDoragon/Sepulcrum.git
  ```

2. Importe o projeto na sua IDE (Eclipse, IntelliJ, NetBeans, etc.)

3. Configure o banco de dados:
- Crie o banco com o script `Sepulcrum.sql` (na pasta `/databaseConfig`)
- Edite o arquivo `config.example.properties` de configuração com suas credenciais (na pasta `src\main\resources\config.example.properties`).
- Renomeie para `config.properties`.
- Edite o conteúdo com suas credenciais do banco de dados. Caso utilize MySQL, basta ajustar o usuário e a senha:
- Se optar por outro banco relacional (como PostgreSQL), altere também os campos db.url e db.driver conforme a documentação do respectivo JDBC driver.
  ```Java
  db.url=jdbc:mysql://localhost:3306/sepulcrum
  db.user=user
  db.password=senha
  db.driver=com.mysql.cj.jdbc.Driver
  ```

4. Execute o projeto a partir da classe `Main.java`

## Diagrama Entidade-Relacionamento (DER)

Diagrama lógico das entidades e relacionamentos do banco de dados:
![Image](https://github.com/user-attachments/assets/424f4948-7e0f-4794-92d3-587691c4aff5)

## Estrutura Básica

**Legenda das Pastas**
- `app/` – Ponto de entrada da aplicação (classe principal)
- `controller/` – Controladores responsáveis pela lógica entre interface e dados
- `database/` – para gerenciar conexão e encerramento com o banco
- `view/` – Interface gráfica (telas e componentes visuais)
- `dao/` – Acesso e persistência dos dados no banco de dados
- `resources/` – Arquivos de configuração, como `config.properties` com usuário e senha do banco
- `model/` – Estrutura de dados e entidades do domínio da aplicação
  - `localidade/` – Elementos físicos do cemitério (cemitérios, túmulos, etc.)
  - `pessoa/` – Entidades humanas do sistema (falecidos, familiares, administradores)
  - `servico/` – Ações realizadas no Cemitério (exumações, manutenções, etc.)
  - `utils/` – Classes utilitárias comuns (heranças, formatações, validações, etc.)
  - `comum/` – para telas compartilhadas/gerais de navegação entre entidades

```
📁 Sepulcrum
├── 📦 src
│   └── 📁 main
│       ├── 📁 java
│       │   └── 📁 com
│       │       └── 📁 sepulcrum
│       │           ├── 📁 app
│       │           ├── 📁 controller
│       │           │   ├── 📁 localidade
│       │           │   ├── 📁 pessoa
│       │           │   └── 📁 servico
│       │           ├── 📁 dao
│       │           │   ├── 📁 localidade
│       │           │   ├── 📁 pessoa
│       │           │   └── 📁 servico
│       │           ├── 📁 database
│       │           ├── 📁 model
│       │           │   ├── 📁 localidade
│       │           │   │   └── 📁 utils
│       │           │   ├── 📁 pessoa
│       │           │   │   └── 📁 utils
│       │           │   └── 📁 servico
│       │           │       └── 📁 utils
│       │           ├── 📁 utils
│       │           └── 📁 view
│       │               ├── 📁 comum
│       │               │   └── 📁 utils
│       │               ├── 📁 localidade
│       │               ├── 📁 pessoa
│       │               └── 📁 servico
│       │                   └── 📁 comum
│       └── 📁 resources
├── 📁 target
│   └── 📁 classes
```

## Artefatos do Projeto

### Levantamento de Requisitos

Aqui foram definidos os **objetivos**, **público-alvo**, **necessidade da implementação**, **impacto e benefícios**, **critérios de sucesso da solução**, além dos **requisitos funcionais e não funcionais**.

[Levantamento de Requisitos (PDF)](https://github.com/AzumaNoDoragon/Sepulcrum/blob/main/documentacao/Levantamento%20de%20requisios.pdf)

### Diagrama de Casos de Uso

Visualização dos atores e funcionalidades do sistema:

[Diagrama de Casos de Uso (PDF)](https://github.com/AzumaNoDoragon/Sepulcrum/blob/main/documentacao/Diagrama%20de%20Casos%20de%20uso.pdf)

### Diagrama de Classes

Representação das principais classes e suas relações no sistema:

[Diagrama de Classes (PDF)](https://github.com/AzumaNoDoragon/Sepulcrum/blob/main/documentacao/Diagrama%20de%20Classes.pdf)

### Protótipo de Alta Fidelidade

Protótipo desenvolvido no Figma, representando a interface gráfica planejada para o sistema:

[Acessar Protótipo no Figma – Sepulcrum](https://www.figma.com/proto/A5obT1irJp1okvwqMJ6vkt/Sepulcrum?node-id=0-1&t=4ha3TvRyFWAvMtRV-1)

## ⚠️ Limitações

- Não possui autenticação de usuários
- Apenas um parente responsável por falecido
- Interface básica, sem responsividade

## Contribuições

Contribuições são bem-vindas! Para isso:

- Fork o projeto
- Crie uma branch: `feature/sua-feature`
- Faça commit das alterações
- Envie um pull request

**Nota:** Projeto acadêmico desenvolvido para fins de aprendizado.

## 📄 Licença

Este projeto está licenciado sob a Licença MIT.  
Veja o arquivo [LICENSE](LICENSE) para mais detalhes.