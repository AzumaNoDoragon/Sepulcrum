package com.sepulcrum.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.pessoa.Adm;

public class AdmDAO {
    public void createAdm(Adm a){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "INSERT INTO coveiro (COV_NOME, COV_CPF, COV_RG, COV_DATA_NASCIMENTO, COV_DATA_CONTRATACAO, COV_EMAIL, COV_TELEFONE, COV_CARGO, CEM_CNPJ)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, a.getNome());
                stmt.setString(2, a.getCpf());
                stmt.setString(3, a.getRg());
                stmt.setDate(4, a.getDataNascimento());
                stmt.setDate(5, a.getDataContratacao());
                stmt.setString(6, a.getEmail());
                stmt.setString(7, a.getTelefone());
                stmt.setString(8, a.getCargo());
                if(a.getCemCnpj().equals("")){
                    stmt.setString(9, null);
                } else {
                    stmt.setString(9, a.getCemCnpj());
                }

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao inserir o Coveiro. Nenhuma linha afetada.");
                }
            }

            if (a.getCargo().equalsIgnoreCase("Adm")) {
                String sqlAdm = "INSERT INTO adm (ADM_CPF) VALUES (?);";
                try (PreparedStatement stmtAdm = connection.prepareStatement(sqlAdm)) {
                    stmtAdm.setString(1, a.getCpf());
                    
                    int linhasAfetadas = stmtAdm.executeUpdate();
                    if (linhasAfetadas == 0) {
                        throw new SQLException("Falha ao inserir o Adm. Nenhuma linha afetada.");
                    }
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public Adm readAdm(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT COV_CPF, COV_NOME, COV_RG, COV_DATA_NASCIMENTO, COV_EMAIL, COV_TELEFONE, COV_CARGO, COV_DATA_CONTRATACAO, CEM_CNPJ " +
                        "FROM coveiro WHERE COV_CPF = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Adm a = new Adm(
                            rs.getString("COV_NOME"),
                            rs.getString("COV_CPF"),
                            rs.getDate("COV_DATA_NASCIMENTO"),
                            rs.getDate("COV_DATA_CONTRATACAO"),
                            rs.getString("COV_EMAIL"),
                            rs.getString("COV_TELEFONE"),
                            rs.getString("COV_CARGO"),
                            rs.getString("CEM_CNPJ")
                        );
                        a.setRg(rs.getString("COV_RG"));

                        return a;
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao ler coveiro: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void updateAdm(Adm a, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "UPDATE coveiro SET COV_NOME = ?, COV_CPF = ?, COV_RG = ?, COV_DATA_NASCIMENTO = ?, COV_DATA_CONTRATACAO = ?, COV_EMAIL = ?, COV_TELEFONE = ?, COV_CARGO = ?, CEM_CNPJ = ? " + 
                        "WHERE COV_CPF = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, a.getNome());
                stmt.setString(2, a.getCpf());
                stmt.setString(3, a.getRg());
                stmt.setDate(4, a.getDataNascimento());
                stmt.setDate(5, a.getDataContratacao());
                stmt.setString(6, a.getEmail());
                stmt.setString(7, a.getTelefone());
                stmt.setString(8, a.getCargo());
                stmt.setString(9, a.getCemCnpj());

                stmt.setString(10, Integer.toString(id)); // Busca por este

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao alterar o Coveiro. Nenhuma linha afetada.");
                }
            }

            if (a.getCargo().equalsIgnoreCase("Adm")) {
                String sqlAdm = "UPDATE adm ADM_CPF = ?;";
                try (PreparedStatement stmtAdm = connection.prepareStatement(sqlAdm)) {
                    stmtAdm.setString(1, a.getCpf());
                    
                    int linhasAfetadas = stmtAdm.executeUpdate();
                    if (linhasAfetadas == 0) {
                        throw new SQLException("Falha ao alterar o Adm. Nenhuma linha afetada.");
                    }
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public void deleteAdm(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlDeleteAdm = "DELETE FROM adm WHERE ADM_CPF = ?";
            try (PreparedStatement stmtAdm = connection.prepareStatement(sqlDeleteAdm)) {
                stmtAdm.setString(1, Integer.toString(id));
                stmtAdm.executeUpdate(); // mesmo que não exista, tudo certo
            }
            
            String sql = "DELETE FROM coveiro WHERE COV_CPF = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao deletar coveiro. Nenhuma linha afetada.");
                }
            }

        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}