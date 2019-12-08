package controle;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DaoAtividadeApresentador;

public class ColAtividadeApresentador {

public Connection con;
	
	public ColAtividadeApresentador(Connection connection) {

		con = connection;
	}
	
	public void inserir(int atividade, ArrayList<Integer> apresentador) throws Exception{ 
		
		DaoAtividadeApresentador daoAA = new DaoAtividadeApresentador();
		if(apresentador.size() >= 1) {
			for (int i = 0; i < apresentador.size(); i++) {
				daoAA.insere(atividade,apresentador.get(i), con);
			}
			
		}else {
			System.out.println("Não Existe Apresentadores relacionado à atividade!");
		}
	}
}
