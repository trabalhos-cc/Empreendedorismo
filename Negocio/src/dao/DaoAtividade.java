package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import unioeste.geral.evento.bo.Atividade;
import unioeste.geral.evento.bo.TipoAtividade;
import util.NegocioException;

public class DaoAtividade {
	
	public boolean validarAtividade(String nome, Connection con) {
		
		ArrayList<Atividade> a = new ArrayList<>();

		try {
			a = consultarPorNome(nome, con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(a.size() > 0) return false;
		return true;
	}

	public int insereAtividade(String nome, Date data, Timestamp horaI, Timestamp horaF, int local, int tipo , int evento,
		Connection con) throws SQLException {

		String sql = "INSERT INTO \"Atividade\" (\"nome\", \"data\", \"horarioI\", \"horarioF\", \"idLocal\", \"idTipoAtividade\", \"idEvento\" )"
				+ "VALUES (?,?,?,?,?,?,?) RETURNING \"idAtividade\"";

		 PreparedStatement create = con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);

		
			create.setString(1, nome);
			create.setDate(2, data);
			create.setTimestamp(3, horaI);
			create.setTimestamp(4, horaF);
			create.setInt(5, local);
			create.setInt(6, tipo);
			create.setInt(7, evento);
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

	public ArrayList<Atividade> consultarPorNome(String nome, Connection con) throws NegocioException, SQLException {
		
		ArrayList<Atividade> m = new ArrayList<Atividade>();
		String sql = "SELECT nome FROM \"Atividade\" WHERE \"nome\" = ?;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setString(1, nome);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Atividade atividade = new Atividade();
			atividade.setNome(res.getString("nome"));

//			System.out.println(res.getString("Apresentador"));
			
			m.add(i,atividade);
			i++;	
		}
		return m;
	}
	public int getId(String nome, Connection con) throws SQLException{
		String sql = "SELECT id FROM \"TipoAtividade\" WHERE \"nome\" = ?";
		
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setString(1, nome);
		ResultSet res = stt.executeQuery();
		if (!res.next()) return -1;
		
		return res.getInt("id");
	}
	
	public ArrayList<TipoAtividade> consultarTipo(Connection con) throws SQLException{
		ArrayList<TipoAtividade> m = new ArrayList<TipoAtividade>();
		String sql = "SELECT * FROM \"TipoAtividade\"";
		
		PreparedStatement stt = con.prepareStatement(sql);
		ResultSet res = stt.executeQuery();
		
		while(res.next()) {
			TipoAtividade ta = new TipoAtividade();
			ta.setId(res.getInt("id"));
			ta.setNome(res.getString("nome"));
			m.add(ta);
		}
		return m;
	}
	
	public TipoAtividade consultarTipo(int id, Connection con) throws SQLException{
		String sql = "SELECT * FROM \"TipoAtividade\" WHERE \"id\" = ?";
		
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, id);
		ResultSet res = stt.executeQuery();
		if (!res.next()) return null;
		TipoAtividade ta = new TipoAtividade();
		ta.setId(res.getInt("id"));
		ta.setNome(res.getString("nome"));
		
		return ta;
	}
	public ArrayList<Atividade> buscarAtividadesPorEvento(int id, Connection con)throws SQLException{
		String sql = "SELECT * FROM \"Atividade\" WHERE \"idEvento\" = ?";
		ArrayList<Atividade> ativ = new ArrayList<Atividade>();
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, id);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Atividade atividade = new Atividade();
			DaoLocal local = new DaoLocal();
			DaoEvento evento = new DaoEvento();
			
			atividade.setId(res.getInt("idAtividade"));
			atividade.setNome(res.getString("nome"));
			atividade.setData(res.getDate("data"));
			atividade.setHorarioI(res.getTimestamp("horarioI"));
			atividade.setHorarioF(res.getTimestamp("horarioF"));
			atividade.setLocal(local.consultar(res.getInt("idLocal"), con));
			atividade.setTipoAtividade(consultarTipo(res.getInt("idTipoAtividade"), con));
			atividade.setEvento(evento.consultarEvento(res.getInt("idEvento"), con));
			
			ativ.add(i,atividade);
			i++;	
		}
		return ativ;
	}
	
	
	 
}
