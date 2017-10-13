package objetos;

import java.util.ArrayList;

public class Pokemon {
	
	private String numeroPokedex;
	private String nome;
	private String descricao;
	private String categoria;
	private String sexo;
	private String evoluiDe;
	private String peso;
	private String tipos;
	private ArrayList<Fraqueza> fraquezas;
	private String altura;
	private String habilidade;
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
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getTipos() {
		return tipos;
	}
	public void setTipos(String tipos) {
		this.tipos = tipos;
	}
	public ArrayList<Fraqueza> getFraquezas() {
		return fraquezas;
	}
	public void setFraquezas(ArrayList<Fraqueza> fraquezas) {
		this.fraquezas = fraquezas;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

}
