package com.sepulcrum.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    private Connection conn;
    private final String URL;
    private final String USER;
    private final String SENHA;
    private final String DRIVER;

    public Conexao() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                throw new RuntimeException("Arquivo config.properties não encontrado");
            }

            prop.load(input);

            this.URL = prop.getProperty("db.url");
            this.USER = prop.getProperty("db.user");
            this.SENHA = prop.getProperty("db.password");
            this.DRIVER = prop.getProperty("db.driver");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar configuração do banco: " + e.getMessage());
        }
    }

    public void conectar(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, SENHA);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}