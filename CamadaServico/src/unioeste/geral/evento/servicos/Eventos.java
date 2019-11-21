package unioeste.geral.evento.servicos;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Eventos {

	@WebMethod
	public int cadastrarEvento(String nome, Date ini, Date fim) throws Exception;
}
