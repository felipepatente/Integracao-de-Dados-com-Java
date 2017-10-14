package objetos;

public class Tipo {
	
	private int codTipo;
	private String nmTipo;
	
	public Tipo(int codTipo, String nmTipo) {		
		this.codTipo = codTipo;
		this.nmTipo = nmTipo;
	}

	public int getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}

	public String getNmTipo() {
		return nmTipo;
	}

	public void setNmTipo(String nmTipo) {
		this.nmTipo = nmTipo;
	}
	
}
