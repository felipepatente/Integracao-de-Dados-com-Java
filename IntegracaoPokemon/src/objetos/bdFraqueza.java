package objetos;

public class bdFraqueza {
	
	private int codPokemon;
	private int codTipo;
	
	public bdFraqueza(int codPokemon, int codTipo) {	
		this.codPokemon = codPokemon;
		this.codTipo = codTipo;
	}

	public int getCodPokemon() {
		return codPokemon;
	}

	public void setCodPokemon(int codPokemon) {
		this.codPokemon = codPokemon;
	}

	public int getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}
	
	

}
