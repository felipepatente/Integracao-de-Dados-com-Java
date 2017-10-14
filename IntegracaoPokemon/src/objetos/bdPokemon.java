package objetos;

public class bdPokemon {
	
	private int codPokemon;
	private String nome;
	private String descricao;
	private String altura;
	private String peso;
	private String sexo;
	private int codCategoria;
	private int evoluiDe;
	
	public bdPokemon(int codPokemon, String nome, String descricao, String altura, String peso, String sexo,
			int codCategoria, int evoluiDe) {		
		this.codPokemon = codPokemon;
		this.nome = nome;
		this.descricao = descricao;
		this.altura = altura;
		this.peso = peso;
		this.sexo = sexo;
		this.codCategoria = codCategoria;
		this.evoluiDe = evoluiDe;
	}

	public int getCodPokemon() {
		return codPokemon;
	}

	public void setCodPokemon(int codPokemon) {
		this.codPokemon = codPokemon;
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

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
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

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public int getEvoluiDe() {
		return evoluiDe;
	}

	public void setEvoluiDe(int evoluiDe) {
		this.evoluiDe = evoluiDe;
	}
	
	

}
