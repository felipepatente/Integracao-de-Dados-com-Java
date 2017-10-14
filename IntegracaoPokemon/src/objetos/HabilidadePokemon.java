package objetos;

public class HabilidadePokemon {
	
	private int codHabilidade;
	private int codPokemon;
	
	public HabilidadePokemon(int codHabilidade, int codPokemon) {	
		this.codHabilidade = codHabilidade;
		this.codPokemon = codPokemon;
	}

	public int getCodHabilidade() {
		return codHabilidade;
	}

	public void setCodHabilidade(int codHabilidade) {
		this.codHabilidade = codHabilidade;
	}

	public int getCodPokemon() {
		return codPokemon;
	}

	public void setCodPokemon(int codPokemon) {
		this.codPokemon = codPokemon;
	}

}
