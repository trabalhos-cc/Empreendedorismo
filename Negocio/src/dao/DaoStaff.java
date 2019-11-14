package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import unioeste.geral.evento.bo.Responsabilidade;
import unioeste.geral.evento.bo.Staff;

public class DaoStaff {

public int insereStaff(Staff staff, Connection con) throws SQLException {
		
		String sql = "INSERT INTO staff (nome, cpf, idresponsabilidade) VALUES (?,?,?)";
		
		PreparedStatement create = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		create.setString(1,staff.getNome());
		create.setString(2,staff.getCpf());
		create.setInt(3,staff.getResponsabilidade().getId());
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
	
	public Staff consultar(String cpf, Connection con) throws SQLException {
		String sql = "SELECT staff.*, responsabilidade.* FROM staff"
				+ " INNER JOIN responsabilidade ON responsabilidade.idresponsabilidade = staff.idresponsabilidade"
				+ " WHERE staff.cpf = ?;";
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setString(1, cpf);
		ResultSet res = stt.executeQuery();
		if (!res.next()) {
			return null;
		}
		
		Staff staff = new Staff();
		Responsabilidade responsabilidade  = new Responsabilidade();
		
		staff.setId(res.getInt("idstaff"));
		staff.setNome(res.getString("nome"));
		staff.setCpf(res.getString("cpf"));
		
		responsabilidade.setId(res.getInt("idresponsabilidade"));
		responsabilidade.setSetor(res.getString("setor"));
		
		
		staff.setResponsabilidade(responsabilidade);

		return staff;
	}
}
