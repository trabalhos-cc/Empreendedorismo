package unioeste.geral.evento.servicos;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import unioeste.geral.evento.bo.Apresentador;

@WebService
public interface Atividade {

	@WebMethod
	public int cadastrarAtividade(String nome, Date data, Date horaI, Date horaF, int bloco, int espaco, 
			int sala, ArrayList<Apresentador> apresentadores, String Tipo) throws Exception;
}
