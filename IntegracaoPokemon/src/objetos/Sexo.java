package objetos;

public class Sexo {
	
	private int sexo;
	private String tipoSexo;
	
	public Sexo(int sexo, String tipoSexo) {	
		this.sexo = sexo;
		this.tipoSexo = tipoSexo;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(String tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

}
