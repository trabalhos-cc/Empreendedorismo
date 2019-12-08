package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import servico.UCManterAtividade;
import servico.UCManterEvento;
import unioeste.geral.evento.bo.Apresentador;
import unioeste.geral.evento.bo.Evento;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		UCManterEvento me = new UCManterEvento();
		Evento ev = new Evento();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date ini = sdf.parse("27-11-2019");
		Date fim = sdf.parse("29-11-2019");
		int ok = me.cadastrarEvento("TesteFinal", ini, fim);
		
		ev.setNome("TesteFinal");
		if(ok != 0) {
			System.out.println("Evento cadastrado");
		}else {
			System.out.println("Erro");
		}
		
//		ArrayList<Evento> e = new ArrayList<>();
//		
//		e = me.consultaEvento("LatinoWar3");
//		
//		e.forEach(i->System.out.println(i.getNome() + " " + i.getDataInicio() + " " + i.getDataFim()));
		
		UCManterAtividade ma = new UCManterAtividade();
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");
		Date inic = sdfDate.parse("27-11-2019");
		Date hIni = sdfTime.parse("13:30");
		Date hFim = sdfTime.parse("15:00");
		ArrayList<Apresentador> a = new ArrayList<>();
		Apresentador ap = new Apresentador();
		Apresentador ap2 = new Apresentador();
		ap.setNome("14");
		ap.setInstituicao("Unioeste");
		ap.setFormacao("Graduando");
		a.add(ap);
		ap2.setNome("21");
		ap2.setInstituicao("UNIOESTE");
		ap2.setFormacao("Graduando");
		a.add(ap2);
		ma.cadastrarAtividade("Poesia do 7", inic, hIni, hFim, 12, 3, 2, a, 1, ev);
		
//		ArrayList<TipoAtividade> aux = ma.getTipo();
//		
//		for (TipoAtividade string : aux) {
//			System.out.println(string.getId() + " " + string.getNome());
//		}
		
	} 

}
