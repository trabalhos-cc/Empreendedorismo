package unioeste.geral.evento.bo;

public class Local {

	private int id;
	private String nome;
	private String latitude;
	private String longitude;
	private int bloco;
	private int espaco;
	private int sala;
	
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
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getBloco() {
		return bloco;
	}
	public void setBloco(int bloco) {
		this.bloco = bloco;
	}
	public int getEspaco() {
		return espaco;
	}
	public void setEspaco(int espaco) {
		this.espaco = espaco;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	
}
