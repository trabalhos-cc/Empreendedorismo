package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unioeste.geral.evento.bo.Atividade;
import unioeste.geral.evento.bo.Local;
import unioeste.geral.evento.bo.SubLugar;
import unioeste.geral.evento.bo.TipoAtividade;
import util.NegocioException;

public class DaoAtividade {

	public int insereAtividade(ArrayList<Atividade> listaAtividade, Connection con) throws SQLException {

		String sql = "INSERT INTO atividade (nome, data, horarioInicio, horarioFim, idtipoAtividade, idlocal) VALUES (?,?,?,?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Atividade atividade : listaAtividade) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, atividade.getNome());
			create.setDate(2, new Date (atividade.getData().getTime()));
			create.setTime(3, atividade.getHorarioInicio());
			create.setTime(4, atividade.getHorarioFim());
			create.setInt(5, atividade.getTipoAtividade().getId());
			create.setInt(6, atividade.getLocal().getId());
			create.execute();
			ResultSet generatedKeys;
			try { 
				generatedKeys = create.getGeneratedKeys();
				generatedKeys.next();
			    return generatedKeys.getInt(1);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			    return 0;
			}
		}
		return 0;
	}

	public ArrayList<Atividade> consultarAtividade(int idAtividade, Connection con) throws NegocioException, SQLException {
		
		ArrayList<Atividade> m = new ArrayList<Atividade>();
		String sql = "SELECT * FROM atividade WHERE idatividade = ?;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, idAtividade);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Atividade atividade = new Atividade();
			TipoAtividade ta = new TipoAtividade();
			atividade.setId(res.getInt("idapresentador"));
			atividade.setData(res.getDate("data"));
			atividade.setHorarioInicio(res.getTime("horarioInicio"));
			atividade.setHorarioFim(res.getTime("horarioFim"));
			atividade.setNome(res.getString("nome"));
			
			ta.setId(res.getInt("idtipoAtividade"));
			ta.setNome(res.getString("nome"));
			atividade.setTipoAtividade(ta);
			
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
			atividade.setLocal(local);
			System.out.println(res.getString("Apresentador"));
			
			m.add(i,atividade);
			i++;	
		}
		return m;
	}
}
