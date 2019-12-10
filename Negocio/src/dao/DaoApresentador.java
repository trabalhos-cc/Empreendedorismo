package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import unioeste.geral.evento.bo.Apresentador;
import util.NegocioException;

public class DaoApresentador {

	public int insereApresentador(String nome, String instituicao, String formacao, Connection con) throws SQLException {

		String sql = "INSERT INTO \"Apresentador\" (\"nome\", \"instituição\", \"formação\") VALUES (?,?,?) RETURNING \"idApresentador\"";

		PreparedStatement create = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);		
		create.setString(1, nome);
		create.setString(2, instituicao);
		create.setString(3, formacao);
		create.execute();
		ResultSet generatedKeys;
		try {
			generatedKeys = create.getGeneratedKeys();
			generatedKeys.next();
			
		    return generatedKeys.getInt("idApresentador");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    return 0;
		}

	}

	public ArrayList<Apresentador> consultarApresentador(int idApresentador, Connection con) throws NegocioException, SQLException {
		
		ArrayList<Apresentador> m = new ArrayList<Apresentador>();
		String sql = "SELECT * FROM Apresentador WHERE idApresentador = ?;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, idApresentador);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Apresentador apresentador = new Apresentador();
			apresentador.setId(res.getInt("idapresentador"));
			apresentador.setInstituicao(res.getString("instituicao"));
			apresentador.setFormacao(res.getString("formacao"));
			apresentador.setNome(res.getString("nome"));
			System.out.println(res.getString("Apresentador"));
			
			m.add(i,apresentador);
			i++;	
		}
		return m;
	}
	
	public ArrayList<Apresentador> consultarPorNome(String nome, Connection con) throws NegocioException, SQLException {
		
		ArrayList<Apresentador> m = new ArrayList<Apresentador>();
		String sql = "SELECT nome FROM \"Apresentador\" WHERE \"nome\" = ?;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setString(1, nome);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Apresentador a = new Apresentador();
			a.setNome(res.getString("nome"));			
			m.add(i,a);
			i++;	
		}
		return m;
	}
	
	public boolean validarApresentador(String nome, Connection con)throws NegocioException, SQLException{
		ArrayList<Apresentador> a = new ArrayList<>();

		try {
			a = consultarPorNome(nome, con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(a.size() > 0) return false;
		return true;
	}
}
