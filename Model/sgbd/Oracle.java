package Model.sgbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Oracle {
	
	private String driver  = "oracle.jdbc.driver.OracleDriver";
	private String url     = "jdbc:oracle:thin:@localhost:1521/xe";
	private String usuario = "system";
	private String senha   = "123";

	private Connection conexao;
	private Statement  comando;

	public boolean carregaDriver() {
		boolean retorno=false;
		try {
			Class.forName(driver);
			
			retorno=true;
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		return retorno;
	}

	public boolean conecta() {
		boolean retorno=false;
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			retorno = true;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return retorno;
	}

	public boolean comando() {
		boolean retorno=false;
		try {
			comando = conexao.createStatement();
			retorno = true;
		} catch (SQLException e) {
			System.out.println (e.toString());
		}
		return retorno;
	}

	public boolean consulta(String sql) {
		boolean retorno = false;
		try {
			int r = comando.executeUpdate(sql);
			conexao.commit();
			if (r > 0) retorno = true;
		} catch (SQLException e) {
			System.out.println (e.toString());
		}
		return retorno;
	}

	public void disconecta() {
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println (e.toString());
		}
	}



}
