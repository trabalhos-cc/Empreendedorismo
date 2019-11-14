package controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoAtividade;
import unioeste.geral.evento.bo.Atividade;
import util.NegocioException;

public class ColAtividade {

	public Connection con;
	
	public ColAtividade(Connection connection) {

		con = connection;
	}
	
	public void inserirAtividade(ArrayList<Atividade> atividade, Connection con) throws NegocioException, SQLException {
		
		DaoAtividade atividade1 = new DaoAtividade();
		atividade1.insereAtividade(atividade, con);
	}
	
	public ArrayList<Atividade> consultarAtividade(int idAtividade, Connection con) throws NegocioException, SQLException{
		
		DaoAtividade atividade = new DaoAtividade();
			
		ArrayList<Atividade> atividade1 = atividade.consultarAtividade(idAtividade, con);
		
		return atividade1;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
