package unioeste.geral.evento.bo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Atividade {

	private int id;
	private String nome;
	private Date data;
	private Timestamp horarioI;
	private Timestamp horarioF;
	private Local local;
	private ArrayList<Apresentador> apresentadores;
	
	public Timestamp getHorarioI() {
		return horarioI;
	}
	public void setHorarioI(Timestamp horarioI) {
		this.horarioI = horarioI;
	}
	public Timestamp getHorarioF() {
		return horarioF;
	}
	public void setHorarioF(Timestamp horarioF) {
		this.horarioF = horarioF;
	}
	private TipoAtividade tipoAtividade;
	
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