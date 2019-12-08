package servico;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import controle.ColAtividade;
import controle.ColLocal;
import sql.Query;
import unioeste.geral.evento.bo.Apresentador;
import unioeste.geral.evento.bo.Atividade;
import unioeste.geral.evento.bo.Local;
import unioeste.geral.evento.bo.TipoAtividade;

public class UCManterAtividade {

	public UCManterAtividade() {}
	
	public int cadastrarAtividade(String nome, Date data, Date horaI, Date horaF, int bloco, int espaco, 
			int sala, ArrayList<Apresentador> apresentadores, String Tipo) throws Exception{
	
		Connection con = Query.getConnection();
		con.setAutoCommit(false);

		ColAtividade colAtividade = new ColAtividade(con);
		
		int ok = 0;
		
		
		if(nome != null) {
				
				try {
				Atividade atv = new Atividade();
				atv.setNome(nome);
				atv.setData(new java.sql.Date(data.getTime()));
				atv.setHorarioI(new java.sql.Timestamp(horaI.getTime()));
				atv.setHorarioF(new java.sql.Timestamp(horaF.getTime()));
				atv.setApresentadores(apresentadores);
				
				Local sl = new Local();
				sl.setBloco(bloco);
				sl.setEspaco(espaco);
				sl.setSala(sala);
				
				TipoAtividade tp = new TipoAtividade();
				tp.setNome(Tipo);
				
				ok = colAtividade.inserirAtividade(atv, sl, tp, con);
			}catch(Exception e) {
				e.printStackTrace();
				con.rollback();
				System.err.println("A atividade não foi cadastrado - Erro na classe: " + UCManterAtividade.class.getName());		
				}
				
		}else {
			System.err.println("Erro ao cadastrar atividade - NotNullName");
			
			return ok;
		}
			
			con.commit();
			return ok;
	}
	
//	public int cadastrarEvento(String nome, Date ini, Date fim) throws Exception{
//		
//		Connection con = Query.getConnection();
//		con.setAutoCommit(false);
//		
//		ColEvento colEvento = new ColEvento(con);
//		int ok = 0;
//		
//		try {
//			if(nome != "") {
//			
//				Evento e = new Evento();
//					
//				e.setNome(nome);
//				e.setDataInicio(new java.sql.Date(ini.getTime()));
//				e.setDataFim(new java.sql.Date(fim.getTime()));
//				ok = colEvento.inserirEvento(e, con);
//				
//			}
//			con.commit();
//				
//		}catch(Exception e) {
//			e.printStackTrace();
//			con.rollback();
//			System.err.println("O Evento não foi cadastrado - Erro na classe: " + UCManterEvento.class.getName());
//		}
//		return ok;
//}
	
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
