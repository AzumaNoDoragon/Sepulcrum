package aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classeEndereco.*;
import classeServico.*;
import classePessoa.*;

public class crud {
	//Crud Adm
	public void createAdm() {
		
	}
	
	public void readAdm() {
		
	}
	
	public void updateAdm() {
		
	}
	
	public void deleteAdm() {
		
	}
	
	//Crud Cemiterio
	public void createCemiterio() {
		
	}
	
	public void readCemiterio() {
		
	}
	
	public void updateCemiterio() {
		
	}
	
	public void deleteCemiterio() {
		
	}
	
	// Crud Defunto
	public void createDefunto() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
			String sql = "Insert into cadastro (ocupa, pessoaPublica, nome, certidaoObito, numeroTumulo, dataNascimento, dataObito) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, textField_1.getText());
			pst.setBoolean(2, textField_2.getText());
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

	public void readDefunto() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM cadastro";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				Defunto df = new Defunto();
				df.setIdFalecido(rs.getInt("idFalecido"));
				df.setOcupa(rs.getInt("ocupa"));
				df.setPessoaPublica(rs.getBoolean("pessoaPublica"));
				df.setNome(rs.getString("nome"));
				df.setCertidaoObito(rs.getString("certidaoObito"));
				df.setDataNascimento(rs.getString("dataNascimento"));
				df.setDataObito(rs.getString("dataObito"));
			}

			stmt.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateDefunto() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
			String sql = "UPDATE cadastro SET (ocupa, pessoaPublica, nome) values (?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, textField_1.getText());
			pst.setBoolean(2, textField_2.getText());
			pst.setString(3, textField_3.getText());

			pst.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void paDefunto() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
			String sql = "DELETE FROM cadastro(idTumulo) values (?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, textField_1.getText());

			pst.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Crud Exumacao
	public void createExumacao() {
		
	}
	
	public void readExumacao() {
		
	}
	
	public void updateExumacao() {
		
	}
	
	public void deleteExumacao() {
		
	}
	
	//Crud ManutencaoTumular
	public void createManutencaoTumular() {
		
	}
	
	public void readManutencaoTumular() {
		
	}
	
	public void updateManutencaoTumular() {
		
	}
	
	public void deleteManutencaoTumular() {
		
	}
	
	//Crud Parente
	public void createParente() {
		
	}
	
	public void readParente() {
		
	}
	
	public void updateParente() {
		
	}
	
	public void deleteParente() {
		
	}
	
	// Crud Tumulo
	public void createTumulo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cemiterio", "root", "");
			String sql = "Insert into tumulo (ocupante, cemiterio, quadraTumulo, ruaTumulo, numeroTumulo, ocupadoDesde, ocupado, perpetuo) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, textField_1.getText());
			pst.setString(2, textField_2.getText());
			pst.setString(3, textField_3.getText());
			pst.setString(4, textField_4.getText());
			pst.setString(5, textField_5.getText());
			pst.setString(6, textField_6.getText());
			pst.setBoolean(7, textField_7.getText());
			pst.setBoolean(8, textField_8.getText());

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
			pst.setInt(1, textField_1.getText());
			pst.setString(2, textField_2.getText());
			pst.setBoolean(3, textField_3.getText());
			pst.setBoolean(4, textField_4.getText());

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
			pst.setInt(1, textField_1.getText());

			pst.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Crud Vistoria
	public void createVistoria() {
		
	}
	
	public void readVistoria() {
		
	}
	
	public void updateVistoria() {
		
	}
	
	public void deleteVistoria() {
		
	}
}