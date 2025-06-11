package com.sepulcrum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.pessoas.Finado;

public class DAOFinado {
    public void createFinado(Finado fin){
        Conexao conn = new Conexao();
        try{
            conn.conectar();
            Connection connection = conn.getConnection();

            String sql = "INSERT INTO finado (FIN_NOME, FIN_CPF, FIN_DATA_NASCIMENTO, FIN_DATA_FALECIMENTO, FIN_CERTIDAO_OBITO, FIN_CAUSA_MORTE, TUM_RUA, TUM_NUMERO)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, fin.getNome());
                stmt.setString(2, fin.getCpf());
                stmt.setDate(3, fin.getDataNascimento());
                stmt.setDate(4, fin.getDataFalecimento());
                stmt.setString(5, fin.getCertidaoObito());
                stmt.setString(6, fin.getCausaMorte());
                stmt.setString(7, fin.getTumRua());
                stmt.setString(8, fin.getTumNumero());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao inserir o finado. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public Finado readFinado(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT FIN_NOME, FIN_CPF, FIN_DATA_NASCIMENTO, FIN_DATA_FALECIMENTO, FIN_CERTIDAO_OBITO, FIN_CAUSA_MORTE, TUM_RUA, TUM_NUMERO" +
                        "FROM finado WHERE FIN_CERTIDAO_OBITO = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Finado fin = new Finado(
                            rs.getString("FIN_NOME"),
                            rs.getString("FIN_CPF"),
                            rs.getDate("FIN_DATA_NASCIMENTO"),
                            rs.getDate("FIN_DATA_FALECIMENTO"),
                            rs.getString("FIN_CERTIDAO_OBITO"),
                            rs.getString("FIN_CAUSA_MORTE"),
                            rs.getString("TUM_RUA"),
                            rs.getString("TUM_NUMERO")
                        );
                        fin.setRg(rs.getString("FIN_RG"));

                        return fin;
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao ler Finado: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void updateFinado(Finado fin, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "UPDATE finado SET FIN_NOME = ?, FIN_CPF = ?, FIN_DATA_NASCIMENTO = ?, FIN_DATA_FALECIMENTO = ?, FIN_CERTIDAO_OBITO = ?," +
                        "FIN_CAUSA_MORTE = ?, TUM_RUA = ?, TUM_NUMERO = ?, FIN_RG = ? WHERE FIN_CERTIDAO_OBITO = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, fin.getNome());
                stmt.setString(2, fin.getCpf());
                stmt.setString(3, fin.getRg());
                stmt.setDate(4, fin.getDataNascimento());
                stmt.setDate(5, fin.getDataFalecimento());
                stmt.setString(6, fin.getCausaMorte());
                stmt.setString(7, fin.getCertidaoObito());
                stmt.setString(8, fin.getTumRua());
                stmt.setString(9, fin.getTumNumero());

                stmt.setString(10, Integer.toString(id)); // Busca por este

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao atualizar o finado. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public void deleteFinado(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "DELETE FROM finado WHERE = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao deletar o finado. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}
