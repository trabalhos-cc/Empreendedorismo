package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import unioeste.geral.evento.bo.Apresentador;
import util.NegocioException;

public class DaoApresentador {

	public void insereApresentador(ArrayList<Apresentador> listaApresentador, Connection con) throws SQLException {

		String sql = "INSERT INTO apresentador (nome, instituicao, formacao) VALUES (?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Apresentador apresentador : listaApresentador) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, apresentador.getNome());
			create.setString(3, apresentador.getInstituicao());
			create.setString(4, apresentador.getFormacao());
			create.execute();
		}

	}

	public ArrayList<Apresentador> consultarApresentador(int idApresentador, Connection con) throws NegocioException, SQLException {
		
		ArrayList<Apresentador> m = new ArrayList<Apresentador>();
		String sql = "SELECT * FROM apresentador WHERE idapresentador = ?;" ;
				
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
}
