package unioeste.apoio.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;



public class SQLConnect {
	
	public static Connection getConnection(String user, String pw) throws SQLException, ClassNotFoundException {
		  
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventos?useTimezone=true&serverTimezone=UTC", "root", "root");
			return connection;
		}catch (Exception e) {System.out.println(e); } 
		return null;
	}
	
	public static void insertSQLComand(Connection conn, String query) throws Exception{
		try {	
			PreparedStatement create = conn.prepareStatement(query);
			create.executeUpdate();			
		}catch(Exception e) {System.out.println(e);}
	}
	 
	public static ArrayList<String> getTabela(Connection conn, String query) throws Exception
	{
		try {
			
			PreparedStatement stat = conn.prepareStatement(query);
			
			ResultSet res = stat.executeQuery();
			ArrayList<String> cliente = new ArrayList<String>();
			
			ResultSetMetaData rsmd = res.getMetaData();
			int colunas = rsmd.getColumnCount();
			res.next();
			
			for(int i = 1; i <= colunas; i++){
				
				cliente.add(res.getString(i));
			}
			
			return cliente;
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return null;	
	}
	
	public static String getSelect(Connection conn, String query) throws Exception
	{
		try {
			
			PreparedStatement stat = conn.prepareStatement(query);
			
			ResultSet res = stat.executeQuery();
			String cliente;
			
			res.next();
			
			cliente = res.getString(1);
			
			return cliente;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;	
	}
}
