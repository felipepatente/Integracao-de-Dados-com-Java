package objetos;

public class Habilidade {
	
	private int codHabilidade;
	private String nmHabilidade;
	private String descricao;
	
	public Habilidade(int codHabilidade, String nmHabilidade, String descricao) {		
		this.codHabilidade = codHabilidade;
		this.nmHabilidade = nmHabilidade;
		this.descricao = descricao;
	}

	public int getCodHabilidade() {
		return codHabilidade;
	}

	public void setCodHabilidade(int codHabilidade) {
		this.codHabilidade = codHabilidade;
	}

	public String getNmHabilidade() {
		return nmHabilidade;
	}

	public void setNmHabilidade(String nmHabilidade) {
		this.nmHabilidade = nmHabilidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
