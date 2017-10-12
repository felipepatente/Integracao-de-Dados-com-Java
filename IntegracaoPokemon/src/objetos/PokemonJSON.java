package objetos;

import java.util.ArrayList;

public class PokemonJSON {
	
	private String nome;
	private String descricao;
	private String peso;
	private String sexo;
	private String categoria;
	private ArrayList<TipoPokemon> tipos = new ArrayList<TipoPokemon>();
	
	public PokemonJSON(){
		
	}
	
	public PokemonJSON(String nome,String descricao,String peso,String sexo,String categoria,ArrayList<TipoPokemon> tipos ){
		this.nome = nome;
		this.descricao = descricao;
		this.peso = peso;
		this.sexo = sexo;
		this.categoria = categoria;
		this.tipos = tipos;
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
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public ArrayList<TipoPokemon> getTipos() {
		return tipos;
	}
	public void setTipos(ArrayList<TipoPokemon> tipos) {
		this.tipos = tipos;
	}

}
