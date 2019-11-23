package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import servico.UCManterEvento;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		UCManterEvento me = new UCManterEvento();
		
		SimpleDateFormat sdfini = new SimpleDateFormat("27/11/2019");
		Date ini = sdfini.parse("27/11/2019");
		SimpleDateFormat sdffim = new SimpleDateFormat("29/11/2019");
		Date fim = sdffim.parse("29/11/2019");
		int ok = me.cadastrarEvento("LatinoWare", ini, fim);
		
		if(ok == 1) {
			System.out.println("Evento cadastrado");
		}else {
			System.out.println("Erro");
		}
	}

}
