package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoAtividadeApresentador {

	public void insere(int atividade, int apresentador,	Connection con) throws SQLException {

			String sql = "INSERT INTO \"AtividadeApresentador\" (\"atividade\", \"apresentador\")"
					+ "VALUES (?,?)";

			 PreparedStatement create = con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);

			
				create.setInt(1, atividade);
				create.setInt(2, apresentador);
				create.execute();
				ResultSet generatedKeys;
				try { 
					generatedKeys = create.getGeneratedKeys();
					generatedKeys.next();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}	
		}
	
//	public ArrayList<Apresentador> buscaApresentadores(int atividade, Connection con) throws SQLException{
//		String sql = "SELECT * FROM \"AtividadeApresentador\" WHERE = \"atividade\" = ?";
//		
//		PreparedStatement create = con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
//		create.setInt(1, atividade);
//		ResultSet res = create.executeQuery();
//		
//		int i=0;
//		while (res.next()) {
//			AApresentador a = new Apresentador();
//			
//			a.setId(res.getInt("id"));
//			
//			ativ.add(i,atividade);
//			i++;	
//		}
//	}
}
