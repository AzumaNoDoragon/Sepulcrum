package com.sepulcrum.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.pessoa.Familiar;

public class FamiliarDAO {
    public void createFamiliar(Familiar fam){
        Conexao conn = new Conexao();
        try{
            conn.conectar();
            Connection connection = conn.getConnection();

            String sql = "INSERT INTO familiar (FAM_NOME, FAM_CPF, FAM_DATA_NASCIMENTO, FAM_EMAIL, FAM_TELEFONE, FAM_GRAU_PARENTESCO, FAM_RG, FIN_CERTIDAO_OBITO)" + 
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, fam.getNome());
                stmt.setString(2, fam.getCpf());
                stmt.setDate(3, fam.getDataNascimento());
                stmt.setString(4, fam.getEmail());
                stmt.setString(5, fam.getTelefone());
                stmt.setString(6, fam.getGrauParentesco());
                stmt.setString(7, fam.getRg());
                stmt.setString(8, fam.getCertidaoObito());
                
                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao inserir o cemitério. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public Familiar readFamiliar(int id){
        Conexao conn = new Conexao();
        try{
            conn.conectar();
            Connection connection = conn.getConnection();

            String sql = "SELECT FAM_NOME, FAM_CPF, FAM_DATA_NASCIMENTO, FAM_EMAIL, FAM_TELEFONE, FAM_GRAU_PARENTESCO, FAM_RG, FIN_CERTIDAO_OBITO" +
                        "FROM familiar WHERE FAM_CPF = ?;";
        
            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Familiar fam = new Familiar(
                            rs.getString("FAM_NOME"),
                            rs.getString("FAM_CPF"),
                            rs.getDate("FAM_DATA_NASCIMENTO"),
                            rs.getString("FAM_EMAIL"),
                            rs.getString("FAM_TELEFONE")
                        );
                        fam.setGrauParentesco(rs.getString("FAM_GRAU_PARENTESCO"));
                        fam.setRg(rs.getString("FAM_RG"));
                        fam.setCertidaoObito(rs.getString("FIN_CERTIDAO_OBITO"));

                        return fam;
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao ler familiar: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void updateFamiliar(Familiar fam, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "UPDATE familiar SET FAM_NOME = ?, FAM_CPF = ?, FAM_DATA_NASCIMENTO = ?, FAM_EMAIL = ?, FAM_TELEFONE = ?," +
                        "FAM_GRAU_PARENTESCO = ?, FAM_RG = ?, FIN_CERTIDAO_OBITO = ? WHERE FAM_CPF = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, fam.getNome());
                stmt.setString(2, fam.getCpf());
                stmt.setDate(3, fam.getDataNascimento());
                stmt.setString(4, fam.getEmail());
                stmt.setString(5, fam.getTelefone());
                stmt.setString(6, fam.getGrauParentesco());
                stmt.setString(7, fam.getRg());
                stmt.setString(8, fam.getCertidaoObito());

                stmt.setString(9, Integer.toString(id)); // Busca por este

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao alterar o familiar. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public void deleteFamiliar(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "DELETE FROM familiar WHERE FAM_CPF = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao deletar o familiar. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}