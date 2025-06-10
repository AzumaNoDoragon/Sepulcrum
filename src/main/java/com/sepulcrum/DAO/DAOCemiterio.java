package com.sepulcrum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.localidade.Cemiterio;

public class DAOCemiterio {
    public void createCemiterio(Cemiterio c){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "INSERT INTO cemiterio (cem_nome, cem_estado, cem_cidade, cem_rua, cem_numero, cem_cep, cem_capacidade, cem_telefone, cem_cnpj, adm_Cpf)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getEstado());
                stmt.setString(3, c.getCidade());
                stmt.setString(4, c.getRua());
                stmt.setString(5, c.getNumero());
                stmt.setString(6, c.getCep());
                stmt.setInt(7, c.getCapacidadeMax());
                stmt.setString(8, c.getTelefone());
                stmt.setString(9, c.getCnpj());
                stmt.setString(10, c.getAdmCpf());

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

    public Cemiterio readCemiterio(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT cem_nome, cem_estado, cem_cidade, cem_rua, cem_numero, cem_cep, cem_capacidade, cem_telefone, cem_cnpj, adm_cpf " +
                        "FROM cemiterio WHERE cem_cnpj = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Cemiterio c = new Cemiterio(
                            rs.getString("cem_nome"),
                            rs.getString("cem_estado"),
                            rs.getString("cem_cidade"),
                            rs.getString("cem_rua"),
                            rs.getString("cem_numero"),
                            rs.getString("cem_cep"),
                            rs.getString("cem_telefone"),
                            rs.getString("cem_cnpj"),
                            rs.getString("adm_cpf")
                        );
                        c.setCapacidadeMax(rs.getInt("cem_capacidade"));

                        return c;
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao ler cemitério: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void updateCemiterio(Cemiterio c, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "UPDATE cemiterio SET CEM_NOME = ?, CEM_ESTADO = ?, CEM_CIDADE = ?, CEM_RUA = ?, CEM_NUMERO = ?," +
                        "CEM_CEP = ?, CEM_CAPACIDADE = ?, CEM_TELEFONE = ?, CEM_CNPJ = ?, ADM_CPF = ? WHERE CEM_CNPJ = ?;";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getEstado());
                stmt.setString(3, c.getCidade());
                stmt.setString(4, c.getRua());
                stmt.setString(5, c.getNumero());
                stmt.setString(6, c.getCep());
                stmt.setInt(7, c.getCapacidadeMax());
                stmt.setString(8, c.getTelefone());
                stmt.setString(9, c.getCnpj());
                stmt.setString(10, c.getAdmCpf());

                stmt.setString(11, Integer.toString(id)); // Busca por este

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao alterar o cemitério. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }

    public void deleteCemiterio(Cemiterio c, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "DELETE FROM cemiterio WHERE CEM_CNPJ = ?";

            try(PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, Integer.toString(id));

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao deletar cemitério. Nenhuma linha afetada.");
                }
            }
        } catch(Exception e){
            throw new IllegalArgumentException("Não foi possivel inserir no banco: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}