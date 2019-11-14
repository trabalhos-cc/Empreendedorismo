package controle;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoLocal;
import unioeste.geral.evento.bo.Local;
import util.NegocioException;

public class ColLocal {

	public Connection con;
	
	public ColLocal(Connection connection) {
		con = connection;
	}
	
	public int inserirLocal(Local l, Connection con) throws NegocioException, SQLException {
		
		int res = 0;
		DaoLocal daoLocal = new DaoLocal();
		
		res = daoLocal.insereLocal(l, con);
		return res ;
	}
	
	public Local consultarLocal(int id, Connection con) throws NegocioException, SQLException {
		
		DaoLocal local = new DaoLocal();
		Local res = new Local();
		
		res = local.consultar(id, con);
		return res;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
