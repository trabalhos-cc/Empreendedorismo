package servico;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import controle.ColApresentador;
import controle.ColAtividade;
import controle.ColAtividadeApresentador;
import sql.Query;
import unioeste.geral.evento.bo.Apresentador;
import unioeste.geral.evento.bo.Atividade;
import unioeste.geral.evento.bo.Evento;
import unioeste.geral.evento.bo.Local;
import unioeste.geral.evento.bo.TipoAtividade;

public class UCManterAtividade {

	public UCManterAtividade() {}
	
	public int cadastrarAtividade(String nome, Date data, Date horaI, Date horaF, int bloco, int espaco, 
			int sala, ArrayList<Apresentador> apresentadores, int tipo, Evento ev) throws Exception{
	
		Connection con = Query.getConnection();
		con.setAutoCommit(false);

		ColAtividade colAtividade = new ColAtividade(con);
		ColApresentador colApresentador = new ColApresentador(con);
		ArrayList<Integer> idApresentadores = new ArrayList<>();
		ColAtividadeApresentador colAA = new ColAtividadeApresentador(con);
		
		int ok = 0;
		
		
		if(nome != null) {
				
				try {
				Atividade atv = new Atividade();
				atv.setNome(nome);
				atv.setData(new java.sql.Date(data.getTime()));
				atv.setHorarioI(new java.sql.Timestamp(horaI.getTime()));
				atv.setHorarioF(new java.sql.Timestamp(horaF.getTime()));
				atv.setApresentadores(apresentadores);
				atv.setEvento(ev);
				
				Local sl = new Local();
				sl.setBloco(bloco);
				sl.setEspaco(espaco);
				sl.setSala(sala);
				
				TipoAtividade tp = new TipoAtividade();
				tp.setId(tipo);
				
				
				idApresentadores = colApresentador.inserirApresentador(atv.getApresentadores(), con);
				
				if(idApresentadores.size() > 0) {
					ok = colAtividade.inserirAtividade(atv, sl, tp, con);
				}else {
					System.err.println("Os apresentadores não foram cadastrados - Erro na classe: " + UCManterAtividade.class.getName());
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				con.rollback();
				System.err.println("A atividade não foi cadastrado - Erro na classe: " + UCManterAtividade.class.getName());		
				}
				
		}else {
			System.err.println("Erro ao cadastrar atividade - NotNullName");
			return -1;
		}
		con.commit();

		try {colAA.inserir(ok, idApresentadores);}catch(Exception e) {e.printStackTrace();}
			con.commit();
			return ok;
	}
	
	
//	public ArrayList<Atividade> consultaAtividade(int id) throws Exception{
//		
//		Connection con = Query.getConnection();
//		ColAtividade colAtividade = new ColAtividade(con);
//		
//		ArrayList<Atividade> atividade = new ArrayList<>();
//		atividade = colAtividade.consultarAtividade(id, con);
//		
//		for (int i = 0; i < atividade.size(); i++) {
//			Atividade a = atividade.get(i);
//			ColLocal colLocal = new ColLocal(con);
//			a.setLocal(colLocal.consultarLocal(a.getId(), con));
//		}
//		
//		return atividade;
//		
//	}
	
	public ArrayList<TipoAtividade> getTipo() throws Exception{
		Connection con = Query.getConnection();
		
		ColAtividade colAtividade = new ColAtividade(con);
		return colAtividade.consultarTipoAtividade(con);
	}
}
