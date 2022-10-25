package aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dominio.Cadastro;

public class crudCadastro {
    public void createFalecido() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            String sql = "Insert into cadastro (ocupa, pessoaPublica, nome, certidaoObito, numeroTumulo, dataNascimento, dataObito) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, textField_1.getText());
            pst.setString(2, textField_2.getText());
            pst.setString(3, textField_3.getText());
            pst.setString(4, textField_4.getText());
            pst.setString(5, textField_5.getText());
            pst.setString(6, textField_6.getText());
            pst.setString(7, textField_7.getText());

            pst.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFalecido() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            Statement stmt = c.createStatement();
            String sql = "SELECT * FROM cadastro";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setIdFalecido(rs.getInt("idFalecido"));
                cadastro.setOcupa(rs.getInt("ocupa"));
                cadastro.setPessoaPublica(rs.getBoolean("pessoaPublica"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setCertidaoObito(rs.getString("certidaoObito"));
                cadastro.setDataNascimento(rs.getString("dataNascimento"));
                cadastro.setDataObito(rs.getString("dataObito"));
            }
            
            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateFalecido() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            String sql = "UPDATE cadastro SET (ocupa, pessoaPublica, nome) values (?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, textField_1.getText());
            pst.setString(2, textField_2.getText());
            pst.setString(4, textField_3.getText());
            pst.setString(5, textField_4.getText());
            
            pst.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    public void paFalecido() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            String sql = "DELETE FROM cadastro(idTumulo) values (?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, textField_1.getText());
            
            pst.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
