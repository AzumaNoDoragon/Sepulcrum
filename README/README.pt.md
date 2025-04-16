# Sistema de Gerenciamento de Cemitério

Sistema desktop para gerenciamento de informações de falecidos, responsáveis, sepulturas e exumações. Desenvolvido em **Java**, com **interface gráfica (GUI)** e **integração com banco de dados**.

## Funcionalidades

- Cadastro, buesca, edição e exclusão de:
  - Falecidos
  - Familiar responsáveis
  - Sepulturas
  - Funcionários/Administradores
- Consulta de dados por CPF, nome ou ID
- Controle de exumações e manutenções
- Validações de entrada (ex: datas, campos obrigatórios)
- Interface gráfica intuitiva
- Persistência dos dados em banco de dados

## Tecnologias Utilizadas

- **Java 21+**
- **Swing** (GUI) - em desenvolvimento
- **MySQL** (banco de dados relacional) - em desenvolvimento
- **VSCode** – IDE utilizada

## Como Executar

1. Clone o repositório:
   ```bash
    git clone https://github.com/seu-usuario/sistema-cemiterio.git
2. Importe o projeto na sua IDE (Eclipse, IntelliJ, NetBeans) estou usando o VSCode
3. Configure o banco de dados:
    - Crie o banco com o script database.sql (na pasta /db)
    - Atualize o arquivo de configuração com suas credenciais:
    ```Java
    String url = "EXEMPLO";
    String user = "EXEMPLO";
    String password = "EXEMPLO";
    ```
4. Execute o projeto a partir da classe Main.java

## Estrutura Básica
**Legenda das Pastas**
- `app/` – Ponto de entrada da aplicação
- `core/` – Camada intermediária entre a aplicação e o modelo
- `model/` – Estrutura e dados do domínio da aplicação
    - `localidade/` – Entidades físicas do cemitério (cemitérios, túmulos, etc.)
    - `pessoas/` – Entidades humanas do sistema (falecidos, parentes, administradores)
    - `servicos/` – Serviços e operações realizadas (exumações, manutenções, etc.)
- Possui em varios modulos:
    - `controller/` – Padrões recorrentes para controle
    - `core/` – Padrões recorrentes lógica central
    - `utils/` – Padrões recorrentes classes utilitárias de herança
    - `view/` – interfaces gráficas
```
📦 src
┣📂 app
┣📂 core
┃ ┣📂 controller
┃ ┣📂 utils
┃ ┗📂 view
┗📂 model
    ┣📂 localidade
    ┃ ┣📂 cemiterio
    ┃ ┣📂 tumulo
    ┃ ┗📂 utils
    ┣📂 pessoas
    ┃ ┣📂 adm
    ┃ ┣📂 finado
    ┃ ┣📂 parente
    ┃ ┗📂 utils
    ┗ 📂 servicos
    ┣📂 core
    ┣📂 utils
    ┗📂 view
```
    
## ⚠️ Limitações

- Não possui autenticação de usuários
- Apenas um parente responsável por falecido
- Interface básica, sem responsividade

## Contribuições
Contribuições são bem-vindas! Para isso:

- Fork o projeto
- Crie uma branch: feature/sua-feature
- Faça commit das alterações
- Envie um pull request

**Nota:** Projeto acadêmico desenvolvido para fins de aprendizado.