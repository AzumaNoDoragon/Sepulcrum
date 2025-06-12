package com.sepulcrum.dao.localidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.localidade.Tumulo;

public class TumuloDAO {
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

    public Tumulo readTumulo(String num, String rua, String cnpj){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT TUM_TIPO, TUM_SITUACAO, TUM_DATA_OCUPACAO, TUM_RUA, TUM_NUMERO, CEM_CNPJ" +
                        "FROM tumulo WHERE TUM_NUMERO = ? AND TUM_RUA = ? AND CEM_CNP = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, num);
                stmt.setString(2, rua);
                stmt.setString(3, cnpj);

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

    public void updateTumulo(Tumulo t, String num, String rua, String cnpj){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "UPDATE tumulo SET TUM_TIPO = ?, TUM_SITUACAO = ?, TUM_DATA_OCUPACAO = ?, TUM_RUA = ?, TUM_NUMERO = ?," +
                        "CEM_CNPJ = ? WHERE TUM_NUMERO = ? AND TUM_RUA = ? AND CEM_CNP = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, t.getTipo());
                stmt.setString(2, t.getSituacao());
                stmt.setString(3, t.getDataOcupacao());
                stmt.setString(4, t.getRua());
                stmt.setString(5, t.getNumero());
                stmt.setString(6, t.getCemCnpj());

                stmt.setString(7, num); // Busca por este
                stmt.setString(8, rua); // Busca por este
                stmt.setString(9, cnpj); // Busca por este

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

    public void deleteTumulo(String num, String rua, String cnpj){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "DELETE FROM tumulo WHERE TUM_NUMERO = ? AND TUM_RUA = ? AND CEM_CNP = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, num);
                stmt.setString(2, rua);
                stmt.setString(3, cnpj);

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