package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import unioeste.geral.evento.bo.Evento;

public class DaoEvento {

public int insereEvento(String nome, Date ini, Date fim, Connection con) throws SQLException {
		
		String sql = "INSERT INTO \"Eventos\" (\"nome\", \"dtInicio\", \"dtFim\") VALUES (?,?,?)";
		
		PreparedStatement create = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		create.setString(1,nome);
		create.setDate(2, ini);
		create.setDate(3,fim);
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
	
	public ArrayList<Evento> consultar(String nome, Connection con) throws SQLException {
		
		ArrayList<Evento> m = new ArrayList<>();
		String sql = "SELECT evento.* , local.* FROM evento"
				+ " INNER JOIN local ON local.idlocal = evento.idlocal"
				+ " WHERE local.nome = ?;";
		
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setString(1, nome);
		ResultSet res = stt.executeQuery();
		
		int i = 0;
		while (res.next()) {
					
			Evento evento = new Evento();
			
			evento.setId(res.getInt("idevento"));
			evento.setNome(res.getString("nome"));
			evento.setDataInicio(res.getDate("dataInicio"));
			evento.setDataFim(res.getDate("dataFim"));
	
			m.add(i, evento);
			i++;
		}

		return m;
	}
	
	public boolean validarEvento(String nome) {return true;}
}
