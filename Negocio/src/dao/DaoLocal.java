package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import unioeste.geral.evento.bo.Local;
import unioeste.geral.evento.bo.SubLugar;

public class DaoLocal {

	public int insereLocal(Local local, Connection con) throws SQLException {
		
		String sql = "INSERT INTO local (nome, latitude, longitude, idsublocal) VALUES (?,?,?,?)";
		
		PreparedStatement create = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		create.setString(1,local.getNome());
		create.setString(2,local.getLatitude());
		create.setString(3,local.getLongitude());
		create.setInt(4, local.getSubLugar().getId());
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
		String sql = "SELECT local.*, sublugar.* FROM local"
				+ " INNER JOIN sublugar ON sublugar.idsublugar = local.idsublugar"
				+ " WHERE local.idlocal = ?;";
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, id);
		ResultSet res = stt.executeQuery();
		if (!res.next()) {
			return null;
		}
		Local local = new Local();
		SubLugar subLocal  = new SubLugar();
		
		local.setId(res.getInt("idlocal"));
		local.setNome(res.getString("nome"));
		local.setLatitude(res.getString("latitude"));
		local.setLatitude(res.getString("longitude"));
		
		subLocal.setId(res.getInt("idsublugar"));
		subLocal.setBloco(res.getString("bloco"));
		subLocal.setBloco(res.getString("espaco"));
		subLocal.setBloco(res.getString("sala"));
		
		local.setSubLugar(subLocal);

		return local;
	}
}
