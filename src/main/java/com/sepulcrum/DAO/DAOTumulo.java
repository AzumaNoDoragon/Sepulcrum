package com.sepulcrum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.localidade.Tumulo;

public class DAOTumulo {
    public void createTumulo(Tumulo t){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "INSERT INTO tumulo (TUM_TIPO, TUM_SITUACAO, TUM_DATA_OCUPACAO, TUM_RUA, TUM_NUMERO, CEM_CNPJ)" +
                        "VALUES (?, ?, ?, ?, ?, ?);";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, t.getTipo());
                stmt.setString(2, t.getSituacao());
                stmt.setString(3, t.getDataOcupacao());
                stmt.setString(4, t.getRua());
                stmt.setString(5, t.getNumero());
                stmt.setString(6, t.getCemCnpj());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao inserir o tumulo. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public Tumulo readTumulo(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT TUM_TIPO, TUM_SITUACAO, TUM_DATA_OCUPACAO, TUM_RUA, TUM_NUMERO, CEM_CNPJ" +
                        "FROM tumulo WHERE ??? = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Tumulo t = new Tumulo(
                            rs.getString("TUM_TIPO"),
                            rs.getString("TUM_SITUACAO"),
                            rs.getString("TUM_DATA_OCUPACAO"),
                            rs.getString("TUM_RUA"),
                            rs.getString("TUM_NUMERO"),
                            rs.getString("CEM_CNPJ")
                        );

                        return t;
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao ler tumulo: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void updateTumulo(Tumulo t, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "UPDATE tumulo SET TUM_TIPO = ?, TUM_SITUACAO = ?, TUM_DATA_OCUPACAO = ?, TUM_RUA = ?, TUM_NUMERO = ?," +
                        "CEM_CNPJ = ? WHERE ??? = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, t.getTipo());
                stmt.setString(2, t.getSituacao());
                stmt.setString(3, t.getDataOcupacao());
                stmt.setString(4, t.getRua());
                stmt.setString(5, t.getNumero());
                stmt.setString(6, t.getCemCnpj());

                stmt.setString(11, Integer.toString(id)); // Busca por este

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao atualizar o tumulo. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public void deleteTumulo(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "DELETE FROM tumulo WHERE ??? = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao deletar o tumulo. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}