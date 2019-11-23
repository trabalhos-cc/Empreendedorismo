package servico;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import controle.ColEvento;
import sql.Query;
import unioeste.geral.evento.bo.Evento;

public class UCManterEvento {

	public UCManterEvento() {}
	
	public int cadastrarEvento(String nome, Date ini, Date fim) throws Exception{
		
			Connection con = Query.getConnection();
			con.setAutoCommit(false);
			
			ColEvento colEvento = new ColEvento(con);
			int ok = 0;
			
			try {
				if(nome != "") {
				
					Evento e = new Evento();
						
					e.setNome(nome);
					e.setDataInicio(new java.sql.Date(ini.getTime()));
					e.setDataFim(new java.sql.Date(fim.getTime()));
					ok = colEvento.inserirEvento(e, con);
					
				}
				con.commit();
					
			}catch(Exception e) {
				e.printStackTrace();
				con.rollback();
				System.err.println("O Evento não foi cadastrado - Erro na classe: " + UCManterEvento.class.getName());
			}
			return ok;
	}
	
	public ArrayList<Evento> consultaEvento (String nome)throws Exception {
		
		Connection con = Query.getConnection();
		
		ColEvento colEvento = new ColEvento(con);
		ArrayList <Evento> evento = new ArrayList<>();
		evento = colEvento.consultarEvento(nome, con);
				
		
		return evento;
	}
}
