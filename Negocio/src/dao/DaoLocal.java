package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import unioeste.geral.evento.bo.Local;

public class DaoLocal {

	public int insereLocal(Local local, Connection con) throws SQLException {
		
		String sql = "INSERT INTO local (nome, latitude, longitude, bloco, espaço, sala) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement create = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		create.setString(1,local.getNome());
		create.setString(2,local.getLatitude());
		create.setString(3,local.getLongitude());
		create.setInt(4, local.getBloco());
		create.setInt(5, local.getEspaco());
		create.setInt(6,  local.getSala());
		create.execute();
		ResultSet generatedKeys;
		try {
			generatedKeys = create.getGeneratedKeys();
			generatedKeys.next();
		    return generatedKeys.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    return 0;
		}
	}
	
	public Local consultar(int id, Connection con) throws SQLException {
		String sql = "SELECT * FROM \"Local\""
				+ " WHERE \"idLocal\" = ?;";
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, id);
		ResultSet res = stt.executeQuery();
		if (!res.next()) {
			return null;
		}
		Local local = new Local();
		
		local.setId(res.getInt("idLocal"));
		local.setNome(res.getString("nome"));
		local.setLatitude(res.getString("latitude"));
		local.setLatitude(res.getString("longitude"));
		local.setBloco(res.getInt("bloco"));
		local.setEspaco(res.getInt("espaço"));
		local.setSala(res.getInt("sala"));
		
		return local;
	}
	
	public int getId(int bloco, int espaco, int sala, Connection con) throws SQLException{
		String sql = "SELECT \"idLocal\" FROM \"Local\" WHERE (\"bloco\" = ? and \"espaço\" = ? and \"sala\" = ?)";
		
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, bloco);
		stt.setInt(2, espaco);
		stt.setInt(3, sala);
		ResultSet res = stt.executeQuery();
		if (!res.next()) return -1;
		
		return res.getInt("idLocal");
	}
	
	public String consultarLatitude (int id, Connection con) throws SQLException{
		String sql = "SELECT \"latitude\"FROM \"Local\"Where \"idLocal\" = ? ";
		
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, id);
		ResultSet res = stt.executeQuery();
		if (!res.next()) return null;
		
		return res.getString("latitude");
	}
	
	public String consultarLongitude (int id, Connection con) throws SQLException{
		String sql = "SELECT \"longitude\"FROM \"Local\"Where \"idLocal\" = ? ";
		
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, id);
		ResultSet res = stt.executeQuery();
		if (!res.next()) return null;
		
		return res.getString("longitude");
	}
}
