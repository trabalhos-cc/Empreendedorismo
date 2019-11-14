package servico;

import java.sql.Connection;
import java.util.ArrayList;

import controle.ColAtividade;
import controle.ColLocal;
import sql.Query;
import unioeste.geral.evento.bo.Atividade;

public class UCManterAtividade {

	public UCManterAtividade() {}
	
//	public void cadastrarAtividade(Atividade atividade) throws Exception{
//	
//		Connection con = Query.getConnection();
//		con.setAutoCommit(false);
//
//		ColAtividade colAtividade = new ColAtividade(con);
//		
//		try {
//			if(atividade != null) {
//				
//				ColLocal colLocal = new ColLocal(con);
//				
//				atividade.getLocal().setId(colLocal.consultarLocal(atividade.getLocal().getNome(), con).getId());
//				
//				int id = colAtividade.inserirAtividade(atividade, con);
//				
//				
//			}catch() {}
//		}
//	}
	
	public ArrayList<Atividade> consultaAtividade(int id) throws Exception{
		
		Connection con = Query.getConnection();
		
		ColAtividade colAtividade = new ColAtividade(con);
		
		ArrayList<Atividade> atividade = new ArrayList<>();
		atividade = colAtividade.consultarAtividade(id, con);
		
		for (int i = 0; i < atividade.size(); i++) {
			Atividade a = atividade.get(i);
			ColLocal colLocal = new ColLocal(con);
			a.setLocal(colLocal.consultarLocal(a.getId(), con));
		}
		
		return atividade;
		
	}
}
