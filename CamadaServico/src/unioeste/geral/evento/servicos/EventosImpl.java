package unioeste.geral.evento.servicos;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import servico.UCManterEvento;

@WebService(endpointInterface="unioeste.geral.evento.servicos.Eventos")

public class EventosImpl implements Eventos{
	@Override
	@WebMethod
	public int cadastrarEvento(@WebParam(name = "nome")String nome,
			@WebParam(name ="ini")Date ini, 
			@WebParam(name = "fim") Date fim) throws Exception{
		
		UCManterEvento  ucME = new UCManterEvento();
		int ok = ucME.cadastrarEvento(nome, ini, fim);
		return ok;
	}
}
