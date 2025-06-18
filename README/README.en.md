# Cemetery Management System

Desktop system for managing information about deceased individuals, responsible family members, graves, and exhumations. Developed in **Java**, with a **graphical user interface (GUI)** and **database integration**.

## Features

- Register, search, edit, and delete:
  - Deceased individuals
  - Responsible family members
  - Graves
  - Employees/Administrators
- Data lookup by CPF or CNPJ(PK's)
- Control of exhumations and maintenance
- Input validations (e.g., dates, required fields)
- Intuitive graphical interface
- Data persistence with database support

## Technologies Used

- **Java 21+**
- **Swing (GUI)**
- **MySQL (relational database)**
- **VSCode** – IDE used

## How to Run

1. Clone the repository:
  ```bash
  git clone https://github.com/AzumaNoDoragon/Sepulcrum.git
  ```

2. Import the project into your IDE (Eclipse, IntelliJ, NetBeans, etc.)

3. Configure the database:
- Create the database using the `Sepulcrum.sql` script (located in the `/databaseConfig` folder)
- Edit the `config.example.properties` file with your credentials (in `src\main\resources\config.example.properties`).
- Rename the file to `config.properties`.
- Update its content with your database credentials. If you're using MySQL, just update the user and password:
- If using another relational database (such as PostgreSQL), also update the `db.url` and `db.driver` fields according to the respective JDBC driver documentation.
  ```Java
  db.url=jdbc:mysql://localhost:3306/sepulcrum
  db.user=user
  db.password=senha
  db.driver=com.mysql.cj.jdbc.Driver
  ```

4. Run the project from the `Main.java` class

## Entity-Relationship Diagram (ERD)

Logical diagram of the database entities and relationships:
![Image](https://github.com/user-attachments/assets/424f4948-7e0f-4794-92d3-587691c4aff5)

## Basic Structure

**Folder Legend**
- `app/`  – Application entry point (main class)
- `controller/` – Controllers responsible for logic between UI and data
- `database/` – Manages the database connection and disconnection
- `view/` – Graphical interface (screens and visual components)
- `dao/`  – Data access and persistence layer
- `resources/` – Configuration files, such as `config.properties` with database credentials
- `model/` – Data structures and domain entities
  - `localidade/` – Physical cemetery elements (cemeteries, graves, etc.)
  - `pessoa/` – Human entities in the system (deceased, family members, administrators)
  - `servico/` – Actions performed in the cemetery (exhumations, maintenance, etc.)
  - `utils/` – Common utility classes (inheritance, formatting, validations, etc.)
  - `comum/` – Shared screens used to route access between different entities

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

## Project Artifacts

### Requirements Gathering

Defines the  **goals**, **target audience**, **implementation needs**, **impact and benefits**, **solution success criteria**, and both **functional and non-functional requirements**.

[Requirements Gathering (PDF)](https://github.com/AzumaNoDoragon/Sepulcrum/blob/main/documentacao/Levantamento%20de%20requisios.pdf)

### Use Case Diagram

Visual representation of system actors and functionalities:

[Use Case Diagram (PDF)](https://github.com/AzumaNoDoragon/Sepulcrum/blob/main/documentacao/Diagrama%20de%20Casos%20de%20uso.pdf)

### Class Diagram

Representation of main classes and their relationships in the system:

[Class Diagram (PDF)](https://github.com/AzumaNoDoragon/Sepulcrum/blob/main/documentacao/Diagrama%20de%20Classes.pdf)

### High-Fidelity Prototype

Prototype designed in Figma, representing the planned graphical interface:

[Access Sepulcrum Figma Prototype](https://www.figma.com/proto/A5obT1irJp1okvwqMJ6vkt/Sepulcrum?node-id=0-1&t=4ha3TvRyFWAvMtRV-1)

## ⚠️ Limitations

- No user authentication
- Only one responsible family member per deceased
- Basic interface without responsiveness

## Contributions

Contributions are welcome! To contribute:

- Fork the repository
- Create a new branch: `feature/your-feature`
- Commit your changes
- Submit a pull request

**Note:** Academic project developed for learning purposes.

## 📄 License

This project is licensed under the MIT License.
See the [LICENSE](LICENSE) file for more details.