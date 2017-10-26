package objetos;

public class bdPokemon {
	
	private int codPokemon;
	private String nome;
	private String descricao;
	private double altura;
	private double peso;
	private int sexo;
	private int codCategoria;
	private int evoluiDe;
	
	public bdPokemon(int codPokemon, String nome, String descricao, String altura, String peso, int sexo,
			int codCategoria) {		
		this.codPokemon = codPokemon;
		this.nome = nome;
		this.descricao = descricao;
		setAltura(altura);
		setPeso(peso);		
		this.sexo = sexo;
		this.codCategoria = codCategoria;		
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

	public double getAltura() {
		return altura;
	}

	public void setAltura(String altura) {	
		this.altura = Double.parseDouble(altura.replace(",",".").replace(" m",""));
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = Double.parseDouble(peso.replace(",",".").replace(" Kg",""));		
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
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
