package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoAtividadeApresentador {

	public void insere(int atividade, int apresentador,	Connection con) throws SQLException {

		System.out.println(atividade);
		System.out.println(apresentador);
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
}
