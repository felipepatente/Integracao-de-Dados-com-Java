package objetos;

import java.util.ArrayList;

public class PokemonXML {
	
	private String nome;
	private String descricao;
	private double peso;
	private String sexo;
	private String categoria;
	private ArrayList<Fraqueza> fraquezas = new ArrayList<Fraqueza>();	
	
	public PokemonXML(){
		
	}
	
	public PokemonXML(String nome,String descricao,double peso,String sexo,String categoria,ArrayList<Fraqueza> fraquezas){
		this.nome = nome;
		this.descricao = descricao;
		this.peso = peso;
		this.sexo = sexo;
		this.categoria = categoria;
		this.fraquezas = fraquezas;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public ArrayList<Fraqueza> getFraquezas() {
		return fraquezas;
	}
	public void setFraquezas(ArrayList<Fraqueza> fraquezas) {
		this.fraquezas = fraquezas;
	}

}
