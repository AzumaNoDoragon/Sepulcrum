package aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dominio.Tumulo;

public class crudTumulo {
    public void createTumulo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            String sql = "Insert into tumulo (ocupante, cemiterio, quadraTumulo, ruaTumulo, numeroTumulo, ocupadoDesde, ocupado, perpetuo) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, textField_1.getText());
            pst.setString(2, textField_2.getText());
            pst.setString(3, textField_3.getText());
            pst.setString(4, textField_4.getText());
            pst.setString(5, textField_5.getText());
            pst.setString(6, textField_6.getText());
            pst.setString(7, textField_7.getText());
            pst.setString(8, textField_8.getText());

            pst.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readTumulo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            Statement stmt = c.createStatement();
            String sql = "SELECT * FROM tumulo";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            while (rs.next()) {
                Tumulo tumulo = new Tumulo();
                tumulo.setIdTumulo(rs.getInt("idTumulo"));
                tumulo.setOcupante(rs.getInt("ocupante"));
                tumulo.setCemiterio(rs.getString("cemiterio"));
                tumulo.setQuadraTumulo(rs.getString("quadraTumulo"));
                tumulo.setRuaTumulo(rs.getString("ruaTumulo"));
                tumulo.setNumeroTumulo(rs.getString("numeroTumulo"));
                tumulo.setOcupadoDesde(rs.getString("ocupadoDesde"));
                tumulo.setOcupado(rs.getBoolean("ocupado"));
                tumulo.setPerpetuo(rs.getBoolean("perpetuo"));
            }

            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateTumulo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            String sql = "UPDATE tumulo SET (ocupante, ocupadoDesde, ocupado, perpetuo) values (?,?,?,?)";
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
    
    public void paTumulo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
            String sql = "DELETE FROM tumulo(idTumulo) values (?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, textField_1.getText());
            
            pst.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}