package aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dominio.Cadastro;
import dominio.Tumulo;

public class CRUDGC {
    public void createTumulo() {
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

    public void createFalecido() {
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

    public void readTumulo() {

    }

    public void readFalecido() {

    }

    public void updateTumulo() {

    }

    public void updateFalecido() {

    }

    public void paTumulo() {

    }

    public void paFalecido() {

    }
}
