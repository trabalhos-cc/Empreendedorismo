package controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
		if (daoEvento.validarEvento(e.getNome(), con)){
			res = daoEvento.insereEvento(e.getNome(), e.getDataInicio(), e.getDataFim(), con);
		}else {
			System.out.println("Já existe um evento cadastrado com esse nome!");
		}
		return res ;
	}
	
	public ArrayList<Evento> consultarEvento(String nome, Connection con) throws NegocioException, SQLException {
		
		DaoEvento evento = new DaoEvento();
		ArrayList<Evento> res = new ArrayList<>();
		
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
