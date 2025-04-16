# Cemetery Management System

Desktop system for managing information about deceased individuals, responsible family members, graves, and exhumations. Developed in **Java**, with a **Graphical User Interface (GUI)** and **database integration**.

## Features

- Create, search, update, and delete:
  - Deceased individuals
  - Responsible family members
  - Graves
  - Staff/Administrators
- Query data by CPF, name, or ID
- Manage exhumations and maintenance
- Input validation (e.g., dates, required fields)
- Intuitive graphical interface
- Data persistence via database

## Technologies Used

- **Java 21+**
- **Swing** (GUI) – under development
- **MySQL** (relational database) – under development
- **VSCode** – IDE used

## How to Run

1. Clone the repository:
  ```bash
  git clone https://github.com/seu-usuario/sistema-cemiterio.git
  ```
    
2. Import the project into your IDE (Eclipse, IntelliJ, NetBeans, etc.)  

3. Set up the database:
- Create the database using the `database.sql` script (located in the `/db` folder)
- Update the configuration file with your credentials:
  ```java
  String url = "EXAMPLE";
  String user = "EXAMPLE";
  String password = "EXAMPLE";
  ```

4. Run the project from the `Main.java` class

## Project Structure

**Folder Legend**
- `app/` – Application entry point
- `core/` – Intermediate layer between app and model
- `model/` – Domain structure and data
  - `localidade/` – Physical cemetery entities (cemeteries, graves, etc.)
  - `pessoas/` – People entities (deceased, relatives, admins)
  - `servicos/` – Services and operations (exhumations, maintenance, etc.)
- Found in various modules:
  - `controller/` – Recurrent control patterns
  - `core/` – Recurrent business logic patterns
  - `utils/` – Utility base classes
  - `view/` – GUI-related code

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

## ⚠️ Limitations

- No user authentication implemented
- Only one responsible relative per deceased individual
- Basic UI without responsiveness

## Contributions

Contributions are welcome! To contribute:

- Fork the repository
- Create a branch: `feature/your-feature`
- Commit your changes
- Submit a pull request

**Note:** Academic project developed for educational purposes.