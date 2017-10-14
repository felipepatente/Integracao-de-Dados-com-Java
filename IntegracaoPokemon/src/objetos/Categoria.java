package objetos;

public class Categoria {
	
	private int codCategoria;
	private String nmCategoria;
	
	public Categoria(int codCategoria, String nmCategoria) {		
		this.codCategoria = codCategoria;
		this.nmCategoria = nmCategoria;
	}
	
	public int getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}
	public String getNmCategoria() {
		return nmCategoria;
	}
	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	
	

}
