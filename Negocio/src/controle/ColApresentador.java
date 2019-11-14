package controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoApresentador;
import unioeste.geral.evento.bo.Apresentador;
import util.NegocioException;

public class ColApresentador {

	public Connection con;
	
	public ColApresentador(Connection connection) {
		con = connection;
	}
	
	public void inserirApresentador(ArrayList<Apresentador> apresentador, Connection con) throws NegocioException, SQLException {
		
		DaoApresentador apresentador1 = new DaoApresentador();
		apresentador1.insereApresentador(apresentador, con);
	}
	
	public ArrayList<Apresentador> consultarApresentador(int idApresentador, Connection con) throws NegocioException, SQLException{
		
		DaoApresentador apresentador = new DaoApresentador();
			
		ArrayList<Apresentador> apresentador1 = apresentador.consultarApresentador(idApresentador, con);
		return apresentador1;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
