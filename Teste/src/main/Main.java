package main;

import java.util.ArrayList;

import servico.UCManterEvento;
import unioeste.geral.evento.bo.Evento;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		UCManterEvento me = new UCManterEvento();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		Date ini = sdf.parse("27-11-2019");
//		Date fim = sdf.parse("29-11-2019");
//		int ok = me.cadastrarEvento("LatinoWare2", ini, fim);
//		
//		if(ok == 1) {
//			System.out.println("Evento cadastrado");
//		}else {
//			System.out.println("Erro");
//		}
		
		ArrayList<Evento> e = new ArrayList<>();
		
		e = me.consultaEvento("LatinoWare2");
		
		e.forEach(i->System.out.println(i.getNome() + " " + i.getDataInicio() + " " + i.getDataFim()));
	} 

}
