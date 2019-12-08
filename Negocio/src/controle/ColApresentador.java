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
	
	public ArrayList<Integer> inserirApresentador(ArrayList<Apresentador> apresentador, Connection con) throws NegocioException, SQLException {
		
		int res = 0;
		DaoApresentador apresentador1 = new DaoApresentador();
		ArrayList<Integer> id = new ArrayList<Integer>();
		if(apresentador.size() > 0) {
			for (Apresentador apresentador2 : apresentador) {
				if(apresentador1.validarApresentador(apresentador2.getNome(), con)) {
					res = apresentador1.insereApresentador(apresentador2.getNome(), apresentador2.getInstituicao(),
							apresentador2.getFormacao(), con);
					id.add(res);
				}else {
					System.out.println("Apresentador já possui Cadastro");
				}
			}
			
		}else {
			System.out.println("Não Existe nome de apresentadores relacionado à atividade!");
		}
		return id;
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
