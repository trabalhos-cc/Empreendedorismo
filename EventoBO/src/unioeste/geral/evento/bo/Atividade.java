package unioeste.geral.evento.bo;

import java.sql.Date;
import java.sql.Time;

public class Atividade {

	private int id;
	private String nome;
	private Date data;
	private Time horarioInicio;
	private Time horarioFim;
	private TipoAtividade tipoAtividade;
	private Local local;
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
	public Time getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Time getHorarioFim() {
		return horarioFim;
	}
	public void setHorarioFim(Time horarioFim) {
		this.horarioFim = horarioFim;
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
	
	
	
	
}