package objetos;

import java.util.ArrayList;

public class PokemonXML {
	
	private String nome;
	private String descricao;
	private String peso;
	private String categoria;
	private ArrayList<Fraqueza> fraquezas = new ArrayList<Fraqueza>();
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
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
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
