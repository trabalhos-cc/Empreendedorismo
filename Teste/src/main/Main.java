package main;

import java.util.ArrayList;

import servico.UCManterAtividade;
import unioeste.geral.evento.bo.Atividade;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		UCManterAtividade ma = new UCManterAtividade();
		ArrayList<Atividade> atividades = new ArrayList<>();
		
		atividades = ma.consultaAtividade(1);
		
		for(int i = 0; i < atividades.size(); i++) {
			System.out.println(atividades.get(i).getId());
		}
	}

}
