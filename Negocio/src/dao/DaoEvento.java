package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import unioeste.geral.evento.bo.Evento;
import unioeste.geral.evento.bo.Local;
import unioeste.geral.evento.bo.Responsabilidade;
import unioeste.geral.evento.bo.Staff;
import unioeste.geral.evento.bo.SubLugar;

public class DaoEvento {

public int insereEvento(Evento evento, Connection con) throws SQLException {
		
		String sql = "INSERT INTO evento (nome, dataInicio, dataFim, horarioInicio, horarioFim, idstaff, idlocal) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement create = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		create.setString(1,evento.getNome());
		create.setDate(2, new Date (evento.getDataInicio().getTime()));
		create.setDate(3,new Date (evento.getDataFim().getTime()));
		create.setTime(4, evento.getHorarioInicio());
		create.setTime(5, evento.getHorarioFim());
		create.setInt(6, evento.getStaff().getId());
		create.setInt(7, evento.getLocal().getId());
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
	
	public Evento consultar(String nome, Connection con) throws SQLException {
		String sql = "SELECT evento.*, staff.*, local.* FROM evento"
				+ " INNER JOIN staff ON staff.idstaff = evento.idstaff"
				+ " INNER JOIN local ON local.idlocal = evento.idlocal"
				+ " WHERE local.nome = ?;";
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setString(1, nome);
		ResultSet res = stt.executeQuery();
		if (!res.next()) {
			return null;
		}
		Local local = new Local();
		Staff staff  = new Staff();
		Evento evento = new Evento();
		
		Responsabilidade respon = new Responsabilidade();
		SubLugar sub = new SubLugar();
		
		evento.setId(res.getInt("idevento"));
		evento.setNome(res.getString("nome"));
		evento.setDataInicio(res.getDate("dataInicio"));
		evento.setDataFim(res.getDate("dataFim"));
		evento.setHorarioInicio(res.getTime("horarioInicio"));
		evento.setHorarioFim(res.getTime("horarioFim"));
		
		local.setId(res.getInt("idlocal"));
		local.setNome(res.getString("nome"));
		local.setLatitude(res.getString("latitude"));
		local.setLatitude(res.getString("longitude"));
		
		staff.setId(res.getInt("idstaff"));
		staff.setNome(res.getString("nome"));
		staff.setCpf(res.getString("cpf"));
		
		respon.setId(res.getInt("idresponsabilidade"));
		respon.setSetor(res.getString("setor"));
		
		staff.setResponsabilidade(respon);
		evento.setStaff(staff);
		
		sub.setId(res.getInt("idsublocal"));
		sub.setBloco(res.getString("bloco"));
		sub.setBloco(res.getString("espaco"));
		sub.setBloco(res.getString("sala"));
		
		local.setSubLugar(sub);
		evento.setLocal(local);

		return evento;
	}
}
