package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import servico.UCManterEvento;
import unioeste.geral.evento.bo.Evento;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		UCManterEvento me = new UCManterEvento();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date ini = sdf.parse("27-11-2019");
		Date fim = sdf.parse("29-11-2019");
		int ok = me.cadastrarEvento("Contece", ini, fim);
		
		if(ok != 0) {
			System.out.println("Evento cadastrado");
		}else {
			System.out.println("Erro");
		}
		
		ArrayList<Evento> e = new ArrayList<>();
		
		e = me.consultaEvento("LatinoWar3");
		
		e.forEach(i->System.out.println(i.getNome() + " " + i.getDataInicio() + " " + i.getDataFim()));
	} 

}
