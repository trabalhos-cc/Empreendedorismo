package controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoAtividade;
import dao.DaoLocal;
import unioeste.geral.evento.bo.Atividade;
import unioeste.geral.evento.bo.Local;
import unioeste.geral.evento.bo.TipoAtividade;
import util.NegocioException;

public class ColAtividade {

	public Connection con;
	
	public ColAtividade(Connection connection) {

		con = connection;
	}
	
	public int inserirAtividade(Atividade atividade, Local local, TipoAtividade tp, Connection con) throws NegocioException, SQLException {
		
		int res = 0;
		DaoAtividade daoAtividade = new DaoAtividade();
		DaoLocal daoLocal = new DaoLocal();
		int idlocal = daoLocal.getId(local.getBloco(), local.getEspaco(), local.getSala(), con);
		int idTipo = daoAtividade.getId(tp.getNome(), con);
//		int idApresentador = dao
		
		if(daoAtividade.validarAtividade(atividade.getNome(), con)) {
			if(idlocal != -1) {
				if(idTipo != -1) {
					res = daoAtividade.insereAtividade(atividade.getNome(), atividade.getData(),
							atividade.getHorarioI(), atividade.getHorarioF(), idlocal, idTipo, con);
				}else {
					System.out.println("Tipo de Palestra inexistexte!");
					
				}
			}else {
				System.out.println("Local inexistente!");
			}
		}else {
			System.err.println("Já existe uma atividade cadastrada com esse nome!");
		}
		
		return res;
	}
	
	public ArrayList<Atividade> consultarAtividade(int idAtividade, Connection con) throws NegocioException, SQLException{
		
		DaoAtividade atividade = new DaoAtividade();
			
		ArrayList<Atividade> atividade1 /*= atividade.consultarAtividade(idAtividade, con)*/ = null;
		
		return atividade1;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
