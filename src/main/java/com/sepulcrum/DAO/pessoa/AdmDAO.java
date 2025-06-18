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
            
            String sql = "INSERT INTO coveiro (COV_NOME, COV_CPF, COV_RG, COV_DATA_NASCIMENTO, COV_DATA_CONTRATACAO, COV_EMAIL, COV_TELEFONE, COV_CARGO)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, a.getNome());
                stmt.setString(2, a.getCpf());
                stmt.setString(3, a.getRg());
                stmt.setDate(4, a.getDataNascimento());
                stmt.setDate(5, a.getDataContratacao());
                stmt.setString(6, a.getEmail());
                stmt.setString(7, a.getTelefone());
                stmt.setString(8, a.getCargo());

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

    public Adm readAdm(String id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT COV_CPF, COV_NOME, COV_RG, COV_DATA_NASCIMENTO, COV_EMAIL, COV_TELEFONE, COV_CARGO, COV_DATA_CONTRATACAO " +
                        "FROM coveiro WHERE COV_CPF = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Adm a = new Adm(
                            rs.getString("COV_NOME"),
                            rs.getString("COV_CPF"),
                            rs.getDate("COV_DATA_NASCIMENTO"),
                            rs.getDate("COV_DATA_CONTRATACAO"),
                            rs.getString("COV_EMAIL"),
                            rs.getString("COV_TELEFONE"),
                            rs.getString("COV_CARGO")
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

    public void updateAdm(Adm a, String id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            if (!a.getCpf().equals(id)) {
                String sqlDeleteAdm = "DELETE FROM adm WHERE ADM_CPF = ?";
                try (PreparedStatement stmtAdm = connection.prepareStatement(sqlDeleteAdm)) {
                    stmtAdm.setString(1, id);
                    stmtAdm.executeUpdate();
                }
            }
            
            String sql = "UPDATE coveiro SET COV_NOME = ?, COV_CPF = ?, COV_RG = ?, COV_DATA_NASCIMENTO = ?, COV_DATA_CONTRATACAO = ?, COV_EMAIL = ?, COV_TELEFONE = ?, COV_CARGO = ? " + 
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

                stmt.setString(10, id); // Busca por este

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao alterar o Coveiro. Nenhuma linha afetada.");
                }
            }

            if (a.getCargo().equalsIgnoreCase("Adm")) {
                // Verifica se já existe no ADM
                String sqlSelectAdm = "SELECT 1 FROM adm WHERE ADM_CPF = ?";
                try (PreparedStatement stmtSelect = connection.prepareStatement(sqlSelectAdm)) {
                    stmtSelect.setString(1, a.getCpf());
                    ResultSet rs = stmtSelect.executeQuery();

                    if (!rs.next()) {
                        String sqlInsert = "INSERT INTO adm (ADM_CPF) VALUES (?);";
                        try (PreparedStatement stmtInsert = connection.prepareStatement(sqlInsert)) {
                            stmtInsert.setString(1, a.getCpf());
                            stmtInsert.executeUpdate();
                        }
                    } else if (!a.getCpf().equals(id)) {
                        String sqlUpdate = "UPDATE adm SET ADM_CPF = ? WHERE ADM_CPF = ?;";
                        try (PreparedStatement stmtUpdate = connection.prepareStatement(sqlUpdate)) {
                            stmtUpdate.setString(1, a.getCpf());
                            stmtUpdate.setString(2, id);
                            stmtUpdate.executeUpdate();
                        }
                    }
                }
            } else {
                // Se o cargo NÃO for mais Adm, remove da tabela adm
                String sqlDelete = "DELETE FROM adm WHERE ADM_CPF = ?;";
                try (PreparedStatement stmtDelete = connection.prepareStatement(sqlDelete)) {
                    stmtDelete.setString(1, id);
                    stmtDelete.executeUpdate();
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public void deleteAdm(String id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlDeleteAdm = "DELETE FROM adm WHERE ADM_CPF = ?";
            try (PreparedStatement stmtAdm = connection.prepareStatement(sqlDeleteAdm)) {
                stmtAdm.setString(1, id);
                stmtAdm.executeUpdate();
            }
            
            String sql = "DELETE FROM coveiro WHERE COV_CPF = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, id);

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