package unioeste.geral.evento.bo;

import java.sql.Date;

public class Evento {

	private int id;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	
//	public Evento(String nome, Date ini, Date fim) {
//		this.nome = nome;
//		this.dataInicio = ini;
//		this.dataFim = fim;
//	}
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
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
