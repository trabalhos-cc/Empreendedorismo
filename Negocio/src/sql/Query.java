package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Query {

	public static int getId(Connection conn, String query) throws SQLException {

		try {
			PreparedStatement stat = conn.prepareStatement(query);

			ResultSet res = stat.executeQuery();
			if (res.next())
				return res.getInt(1);
			else
				return 0;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static ArrayList<String> getTabela(Connection conn, String query) throws Exception {
		try {

			PreparedStatement stat = conn.prepareStatement(query);

			ResultSet res = stat.executeQuery();
			ArrayList<String> cliente = new ArrayList<String>();
			ResultSetMetaData rsmd = res.getMetaData();
			int colunas = rsmd.getColumnCount();
			res.next();
			for (int i = 1; i <= colunas; i++) {

				cliente.add(res.getString(i));
			}

			return cliente;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void insertSQLComand(Connection conn, String query) throws Exception {
		try {

			PreparedStatement create = conn.prepareStatement(query);
			create.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Connection getConnection() throws SQLException {

		try {
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/eventos?useTimezone=true&serverTimezone=UTC", "root", "root");
			
			return conn;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
}
