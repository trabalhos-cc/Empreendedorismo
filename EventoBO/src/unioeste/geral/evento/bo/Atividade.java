package unioeste.geral.evento.bo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Atividade {

	private int id;
	private String nome;
	private Date data;
	private Time horario;
	private TipoAtividade tipoAtividade;
	private Local local;
	private ArrayList<Apresentador> apresentadores;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}
	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public ArrayList<Apresentador> getApresentadores() {
		return apresentadores;
	}
	public void setApresentadores(ArrayList<Apresentador> apresentadores) {
		this.apresentadores = apresentadores;
	}
	

}