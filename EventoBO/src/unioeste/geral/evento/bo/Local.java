package unioeste.geral.evento.bo;

public class Local {

	private int id;
	private String nome;
	private String latitude;
	private String longitude;
	private SubLugar subLugar;
	
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
	public SubLugar getSubLugar() {
		return subLugar;
	}
	public void setSubLugar(SubLugar subLugar) {
		this.subLugar = subLugar;
	}
	
	
}
