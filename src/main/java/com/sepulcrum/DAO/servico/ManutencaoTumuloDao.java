package com.sepulcrum.dao.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.servico.ManutencaoTumulo;

public class ManutencaoTumuloDao {
    public void createManutencaoTumulo(ManutencaoTumulo mt){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            connection.setAutoCommit(false);

            int idGerado;
            
            String sql = "INSERT INTO servico (SER_TIPO, SER_DESCRICAO, SER_INFORMACOES_ADICIONAIS, SER_STATUS, SER_DATA, COV_CPF, TUM_NUMERO, TUM_RUA, CEM_CNPJ) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            try(PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                stmt.setString(1, mt.getTipoServico());           // SER_TIPO
                stmt.setString(2, mt.getDescricao());             // SER_DESCRICAO
                stmt.setString(3, mt.getInformacoesAdicionais()); // SER_INFORMACOES_ADICIONAIS
                stmt.setString(4, mt.getStatusServico());         // SER_STATUS
                stmt.setDate(5, mt.getDataServico());             // SER_DATA
                stmt.setString(6, mt.getAdmCpf());                // COV_CPF
                stmt.setString(7, mt.getTumNumero());             // TUM_NUMERO
                stmt.setString(8, mt.getTumRua());                // TUM_RUA
                stmt.setString(9, mt.getCemCnpj());               // CEM_CNPJ

                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Falha ao inserir o serviço. Nenhuma linha afetada.");
                }

                // Pegar o ID gerado
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                    } else {
                        throw new SQLException("Falha ao obter o ID do serviço inserido.");
                    }
                }
            }
            String sqlEx = "INSERT INTO MANUTENCAO_TUMULO (SER_ID)" +
                        "VALUES (?)";

            try(PreparedStatement stmtEx = connection.prepareStatement(sqlEx)){
                stmtEx.setInt(1, idGerado);

                if(stmtEx.executeUpdate() == 0){
                    throw new SQLException("Falha ao inserir o serviço. Nenhuma linha afetada.");
                }
            }

            connection.commit();

        } catch(Exception e){
            try {
                conn.getConnection().rollback();
            } catch (SQLException ex2) {
                throw new IllegalArgumentException("Erro ao desfazer transação: " + ex2.getMessage());
            }
            throw new IllegalArgumentException("Não foi possível inserir no banco: " + e.getMessage());
        } finally {
            try {
                conn.getConnection().setAutoCommit(true);
            } catch (SQLException err) {
                throw new IllegalArgumentException("Erro ao refazer AutoCommit: " + err.getMessage());
            }
            conn.close();
        }
    }

    public ManutencaoTumulo readManutencaoTumulo(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT s.SER_TIPO, s.SER_DESCRICAO, s.SER_INFORMACOES_ADICIONAIS, s.SER_STATUS, s.SER_DATA, " +
                        "s.COV_CPF, s.TUM_NUMERO, s.TUM_RUA, s.CEM_CNPJ " +
                        "FROM servico s " +
                        "JOIN MANUTENCAO_TUMULO mt ON s.SER_ID = mt.SER_ID " +
                        "WHERE s.SER_ID = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        ManutencaoTumulo mt = new ManutencaoTumulo(
                            rs.getString("SER_TIPO"),
                            rs.getString("SER_DESCRICAO"),
                            rs.getString("SER_STATUS"),
                            rs.getDate("SER_DATA"),
                            rs.getString("TUM_RUA"),
                            rs.getString("TUM_NUMERO"),
                            rs.getString("CEM_CNPJ"),
                            rs.getString("COV_CPF")
                        );
                        mt.setInformacoesAdicionais(rs.getString("SER_INFORMACOES_ADICIONAIS"));

                        return mt;
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao ler serviço: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void updateManutencaoTumulo(ManutencaoTumulo mt, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlServico = "UPDATE servico SET SER_TIPO = ?, SER_DESCRICAO = ?, SER_INFORMACOES_ADICIONAIS = ?, " +
                                "SER_STATUS = ?, SER_DATA = ?, COV_CPF = ?, TUM_NUMERO = ?, TUM_RUA = ?, CEM_CNPJ = ? " +
                                "WHERE SER_ID = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sqlServico)) {
                stmt.setString(1, mt.getTipoServico());
                stmt.setString(2, mt.getDescricao());
                stmt.setString(3, mt.getInformacoesAdicionais());
                stmt.setString(4, mt.getStatusServico());
                stmt.setDate(5, mt.getDataServico());
                stmt.setString(6, mt.getAdmCpf());
                stmt.setString(7, mt.getTumNumero());
                stmt.setString(8, mt.getTumRua());
                stmt.setString(9, mt.getCemCnpj());
                stmt.setInt(10, id);

                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Falha ao atualizar o serviço.");
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao atualizar serviço: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void deleteManutencaoTumulo(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlExumacao = "DELETE FROM manutencao_tumulo WHERE SER_ID = ?";

            try (PreparedStatement stmtEx = connection.prepareStatement(sqlExumacao)) {
                stmtEx.setInt(1, id);
                stmtEx.executeUpdate();
            }

            String sqlServico = "DELETE FROM servico WHERE SER_ID = ?";

            try (PreparedStatement stmtServ = connection.prepareStatement(sqlServico)) {
                stmtServ.setInt(1, id);
                int linhasAfetadas = stmtServ.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao deletar serviço. Nenhuma linha afetada.");
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao deletar serviço: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }
}
