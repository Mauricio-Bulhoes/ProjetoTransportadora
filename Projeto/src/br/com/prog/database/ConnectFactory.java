package br.com.prog.database;


import java.sql.*;

public class ConnectFactory {


	public static Connection getConnection() throws ProjetoException {
		try {
			String driver, url, usuario, senha;
			driver = "org.postgresal.Driver";
			url = "jdbc:postgresql://localhost:5432/BancoTransportadora";
			usuario = "postgres";
			senha = "1234";

			Class.forName("org.postgresql.Driver");
			Connection con;
			con = DriverManager.getConnection(url, usuario, senha);

			con.setAutoCommit(true);

			return con;

		} catch (ClassNotFoundException cnf) {
			String msg = "Driver de conexao com o banco nao encontrado \n mensagem original: "
					+ cnf.getMessage();
			throw new ProjetoException(msg);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjetoException("t");

		}

	}

}
