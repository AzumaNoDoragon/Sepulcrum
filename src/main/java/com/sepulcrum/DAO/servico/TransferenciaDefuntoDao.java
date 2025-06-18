package com.sepulcrum.dao.servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sepulcrum.database.Conexao;
import com.sepulcrum.model.servico.TransferenciaDefunto;

public class TransferenciaDefuntoDao {
    public void createTransferenciaDefunto(TransferenciaDefunto td){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            connection.setAutoCommit(false);

            int idGerado;
            
            String sql = "INSERT INTO servico (SER_TIPO, SER_DESCRICAO, SER_INFORMACOES_ADICIONAIS, SER_STATUS, SER_DATA, COV_CPF, TUM_NUMERO, TUM_RUA, CEM_CNPJ) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            try(PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                stmt.setString(1, td.getTipoServico());           // SER_TIPO
                stmt.setString(2, td.getDescricao());             // SER_DESCRICAO
                stmt.setString(3, td.getInformacoesAdicionais()); // SER_INFORMACOES_ADICIONAIS
                stmt.setString(4, td.getStatusServico());         // SER_STATUS
                stmt.setDate(5, td.getDataServico());             // SER_DATA
                stmt.setString(6, td.getAdmCpf());                // COV_CPF
                stmt.setString(7, td.getTumNumero());             // TUM_NUMERO
                stmt.setString(8, td.getTumRua());                // TUM_RUA
                stmt.setString(9, td.getCemCnpj());               // CEM_CNPJ

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

            String sqlEx = "INSERT INTO transferencia_defunto (SER_ID, TUM_NOVO_NUMERO, TUM_NOVO_RUA, CEM_NOVO_CNPJ, FIN_CERTIDAO_OBITO)" +
                        "VALUES (?, ?, ?, ?, ?)";

            try(PreparedStatement stmtEx = connection.prepareStatement(sqlEx)){
                stmtEx.setInt(1, idGerado);
                stmtEx.setString(2, td.getTumNumeroDestino());
                stmtEx.setString(3, td.getTumRuaDestino());
                stmtEx.setString(4, td.getCemCnpjDestino());
                stmtEx.setString(5, td.getFinCertidaoObito());

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

    public TransferenciaDefunto readTransferenciaDefunto(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();
            
            String sql = "SELECT s.SER_TIPO, s.SER_DESCRICAO, s.SER_INFORMACOES_ADICIONAIS, s.SER_STATUS, s.SER_DATA, " +
                        "s.COV_CPF, s.TUM_NUMERO, s.TUM_RUA, s.CEM_CNPJ, td.TUM_NOVO_NUMERO, td.TUM_NOVO_RUA, td.CEM_NOVO_CNPJ, td.FIN_CERTIDAO_OBITO " +
                        "FROM servico s " +
                        "JOIN transferencia_defunto td ON s.SER_ID = td.SER_ID " +
                        "WHERE s.SER_ID = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        TransferenciaDefunto td = new TransferenciaDefunto(
                            rs.getString("SER_TIPO"),
                            rs.getString("SER_DESCRICAO"),
                            rs.getString("SER_STATUS"),
                            rs.getDate("SER_DATA"),
                            rs.getString("COV_CPF"),
                            rs.getString("TUM_NUMERO"),
                            rs.getString("TUM_RUA"),
                            rs.getString("CEM_CNPJ"),
                            rs.getString("TUM_NOVO_NUMERO"),
                            rs.getString("TUM_NOVO_RUA"),
                            rs.getString("CEM_NOVO_CNPJ"),
                            rs.getString("FIN_CERTIDAO_OBITO")
                        );
                        td.setInformacoesAdicionais(rs.getString("SER_INFORMACOES_ADICIONAIS"));

                        return td;
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

    public void updateTransferenciaDefunto(TransferenciaDefunto td, int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlServico = "UPDATE servico SET SER_TIPO = ?, SER_DESCRICAO = ?, SER_INFORMACOES_ADICIONAIS = ?, " +
                                "SER_STATUS = ?, SER_DATA = ?, COV_CPF = ?, TUM_NUMERO = ?, TUM_RUA = ?, CEM_CNPJ = ? " +
                                "WHERE SER_ID = ?";

            try (PreparedStatement stmt = connection.prepareStatement(sqlServico)) {
                stmt.setString(1, td.getTipoServico());
                stmt.setString(2, td.getDescricao());
                stmt.setString(3, td.getInformacoesAdicionais());
                stmt.setString(4, td.getStatusServico());
                stmt.setDate(5, td.getDataServico());
                stmt.setString(6, td.getAdmCpf());
                stmt.setString(7, td.getTumNumero());
                stmt.setString(8, td.getTumRua());
                stmt.setString(9, td.getCemCnpj());
                stmt.setInt(10, id);

                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Falha ao atualizar o serviço.");
                }
            }

            String sqlExumacao = "UPDATE transferencia_defunto SET TUM_NOVO_NUMERO = ?, TUM_NOVO_RUA = ?, CEM_NOVO_CNPJ = ?, FIN_CERTIDAO_OBITO = ?  WHERE SER_ID = ?";

            try (PreparedStatement stmtEx = connection.prepareStatement(sqlExumacao)) {
                stmtEx.setString(1, td.getTumNumeroDestino());
                stmtEx.setString(2, td.getTumRuaDestino());
                stmtEx.setString(3, td.getCemCnpjDestino());
                stmtEx.setString(4, td.getFinCertidaoObito());
                stmtEx.setInt(5, id);

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

    public void deleteTransferenciaDefunto(int id){
        Conexao conn = new Conexao();
        try {
            conn.conectar();
            Connection connection = conn.getConnection();

            String sqlExumacao = "DELETE FROM transferencia_defunto WHERE SER_ID = ?";

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
