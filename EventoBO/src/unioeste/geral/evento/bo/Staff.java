package unioeste.geral.evento.bo;

public class Staff {

	private int id;
	private String nome;
	private String cpf;
	private Responsabilidade responsabilidade;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Responsabilidade getResponsabilidade() {
		return responsabilidade;
	}
	public void setResponsabilidade(Responsabilidade responsabilidade) {
		this.responsabilidade = responsabilidade;
	}
	
	
}
