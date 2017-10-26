package objetos;

import java.util.ArrayList;

public class Pokemon {
	
	private String numeroPokedex;
	private String nome;
	private String descricao;
	private String categoria;
	private String sexo;
	private String evoluiDe;
	private double peso;
	private ArrayList<TipoPokemon> tipos;
	private ArrayList<Fraqueza> fraquezas;
	private double altura;
	private String habilidade;
	
	public Pokemon(){
		
	}
	
	public Pokemon(String nome, String descricao, double peso, String sexo, String categoria, ArrayList<Fraqueza> fraquezas){
		this.nome = nome;
		this.descricao = descricao;
		this.peso = peso;
		this.sexo = sexo;
		this.categoria = categoria;
		this.fraquezas = fraquezas;
	}
	
	public String getNumeroPokedex() {
		return numeroPokedex;
	}
	public void setNumeroPokedex(String numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEvoluiDe() {
		return evoluiDe;
	}
	public void setEvoluiDe(String evoluiDe) {
		this.evoluiDe = evoluiDe;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public ArrayList<TipoPokemon> getTipos() {
		return tipos;
	}
	public void setTipos(ArrayList<TipoPokemon> tipos) {
		this.tipos = tipos;
	}
	public ArrayList<Fraqueza> getFraquezas() {
		return fraquezas;
	}
	public void setFraquezas(ArrayList<Fraqueza> fraquezas) {
		this.fraquezas = fraquezas;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

}
