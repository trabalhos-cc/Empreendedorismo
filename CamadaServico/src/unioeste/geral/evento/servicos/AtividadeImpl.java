package unioeste.geral.evento.servicos;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import unioeste.geral.evento.bo.Apresentador;

@WebService(endpointInterface="unioeste.geral.evento.servicos.Atividade")
public class AtividadeImpl implements Atividade {

	@Override
	@WebMethod
	public int cadastrarAtividade(@WebParam(name = "nome")String nome, 
			@WebParam(name = "data")Date data, 
			@WebParam(name = "horaI")Date horaI, 
			@WebParam(name = "horaI")Date horaF, 
			@WebParam(name = "bloco")int bloco, 
			@WebParam(name = "espaco")int espaco, 
			@WebParam(name = "sala")int sala,
			@WebParam(name = "apresentadores")ArrayList<Apresentador> apresentadores, 
			@WebParam(name = "tipo")String Tipo) throws Exception {
		return 0;
	}

}
