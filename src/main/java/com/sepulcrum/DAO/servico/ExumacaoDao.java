package com.sepulcrum.dao.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.servico.Exumacao;

public class ExumacaoDao {
    public void createExumacao(Exumacao ex){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            connection.setAutoCommit(false);

            int idGerado;
            
            String sql = "INSERT INTO servico (SER_TIPO, SER_DESCRICAO, SER_INFORMACOES_ADICIONAIS, SER_STATUS, SER_DATA, COV_CPF, TUM_NUMERO, TUM_RUA, CEM_CNPJ) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            try(PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                stmt.setString(1, ex.getTipoServico());           // SER_TIPO
                stmt.setString(2, ex.getDescricao());             // SER_DESCRICAO
                stmt.setString(3, ex.getInformacoesAdicionais()); // SER_INFORMACOES_ADICIONAIS
                stmt.setString(4, ex.getStatusServico());         // SER_STATUS
                stmt.setDate(5, ex.getDataServico());             // SER_DATA
                stmt.setString(6, ex.getAdmCpf());                // COV_CPF
                stmt.setString(7, ex.getTumNumero());             // TUM_NUMERO
                stmt.setString(8, ex.getTumRua());                // TUM_RUA
                stmt.setString(9, ex.getCemCnpj());               // CEM_CNPJ

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

            String sqlEx = "INSERT INTO exumacao (SER_ID, FIN_CERTIDAO_OBITO)" +
                        "VALUES (?, ?)";

            try(PreparedStatement stmtEx = connection.prepareStatement(sqlEx)){
                stmtEx.setInt(1, idGerado);
                stmtEx.setString(2, ex.getFinCertidaoObito());

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

    public Exumacao readExumacao(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT s.SER_TIPO, s.SER_DESCRICAO, s.SER_INFORMACOES_ADICIONAIS, s.SER_STATUS, s.SER_DATA, " +
                        "s.COV_CPF, s.TUM_NUMERO, s.TUM_RUA, s.CEM_CNPJ, e.FIN_CERTIDAO_OBITO " +
                        "FROM servico s " +
                        "JOIN exumacao e ON s.SER_ID = e.SER_ID " +
                        "WHERE s.SER_ID = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Exumacao ex = new Exumacao(
                            rs.getString("SER_TIPO"),
                            rs.getString("SER_DESCRICAO"),
                            rs.getString("SER_STATUS"),
                            rs.getDate("SER_DATA"),
                            rs.getString("COV_CPF"),
                            rs.getString("TUM_NUMERO"),
                            rs.getString("TUM_RUA"),
                            rs.getString("CEM_CNPJ"),
                            rs.getString("FIN_CERTIDAO_OBITO")
                        );
                        ex.setInformacoesAdicionais(rs.getString("SER_INFORMACOES_ADICIONAIS"));

                        return ex;
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

    public void updateExumacao(Exumacao ex, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlServico = "UPDATE servico SET SER_TIPO = ?, SER_DESCRICAO = ?, SER_INFORMACOES_ADICIONAIS = ?, " +
                                "SER_STATUS = ?, SER_DATA = ?, COV_CPF = ?, TUM_NUMERO = ?, TUM_RUA = ?, CEM_CNPJ = ? " +
                                "WHERE SER_ID = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sqlServico)) {
                stmt.setString(1, ex.getTipoServico());
                stmt.setString(2, ex.getDescricao());
                stmt.setString(3, ex.getInformacoesAdicionais());
                stmt.setString(4, ex.getStatusServico());
                stmt.setDate(5, ex.getDataServico());
                stmt.setString(6, ex.getAdmCpf());
                stmt.setString(7, ex.getTumNumero());
                stmt.setString(8, ex.getTumRua());
                stmt.setString(9, ex.getCemCnpj());
                stmt.setInt(10, id);

                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Falha ao atualizar o serviço.");
                }
            }

            String sqlExumacao = "UPDATE exumacao SET FIN_CERTIDAO_OBITO = ? WHERE SER_ID = ?";

            try (PreparedStatement stmtEx = connection.prepareStatement(sqlExumacao)) {
                stmtEx.setString(1, ex.getFinCertidaoObito());
                stmtEx.setInt(2, id);

                if (stmtEx.executeUpdate() == 0) {
                    throw new SQLException("Falha ao atualizar a serviço.");
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao atualizar serviço: " + e.getMessage(), e);
        } finally {
            conn.close();
        }
    }

    public void deleteExumacao(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlExumacao = "DELETE FROM exumacao WHERE SER_ID = ?";

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
