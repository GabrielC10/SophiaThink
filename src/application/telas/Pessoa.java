package application.telas;

public class Pessoa {
	private Integer nchamada;
	private String nome;
	private Integer idade;
	private String caracteristica;
	private String email;
	
	public void setNchamada(Integer nchamada){
		this.nchamada = nchamada;
	}
	public Integer getNchamada(){
		return this.nchamada;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setCaracteristica(String caracteristica){
		this.caracteristica = caracteristica;
	}
	public String getCaracteristica(){
		return this.caracteristica;
	}
	
	public void setIdade(Integer idade){
		this.idade = idade;
	}
	public Integer getIdade(){
		return this.idade;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public String getString(){
		return getString();
	}
}
