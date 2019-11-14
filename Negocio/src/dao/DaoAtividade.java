package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unioeste.geral.evento.bo.Apresentador;
import unioeste.geral.evento.bo.Atividade;
import util.NegocioException;

public class DaoAtividade {

	public void insereAtividade(ArrayList<Atividade> listaAtividade, Connection con) throws SQLException {

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
		}

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
			atividade.setId(res.getInt("idapresentador"));
			atividade.setData(res.getDate("data"));
			atividade.setHorarioInicio(res.getTime("horarioInicio"));
			atividade.setHorarioFim(res.getTime("horarioFim"));
			
			
			atividade.setNome(res.getString("nome"));
			System.out.println(res.getString("Apresentador"));
			
			m.add(i,atividade);
			i++;	
		}
		return m;
	}
}
