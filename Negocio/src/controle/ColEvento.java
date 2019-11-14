package controle;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoEvento;
import unioeste.geral.evento.bo.Evento;
import util.NegocioException;

public class ColEvento {

public Connection con;
	
	public ColEvento(Connection connection) {
		con = connection;
	}
	
	public int inserirEvento(Evento e, Connection con) throws NegocioException, SQLException {
		
		int res = 0;
		DaoEvento daoEvento = new DaoEvento();
		
		res = daoEvento.insereEvento(e, con);
		return res ;
	}
	
	public Evento consultarEvento(String nome, Connection con) throws NegocioException, SQLException {
		
		DaoEvento evento = new DaoEvento();
		Evento res = new Evento();
		
		res = evento.consultar(nome, con);
		return res;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
