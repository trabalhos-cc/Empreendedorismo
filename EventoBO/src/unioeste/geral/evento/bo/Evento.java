package unioeste.geral.evento.bo;

import java.sql.Time;
import java.util.Date;

public class Evento {

	private int id;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	private Time horarioInicio;
	private Time horarioFim;
	
	public Date getDataFim() {
		return this.dataFim;
	}
	public Date getdataInicio() {
		return this.dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Time getHorarioInicio() {
		return this.horarioInicio;
	}
	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Time getHorarioFim() {
		return this.horarioFim;
	}
	public void setHorarioFim(Time horarioFim) {
		this.horarioFim = horarioFim;
	}
	private Staff staff;
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
	public Date getDataInicio() {
		return dataInicio;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	
	
}
