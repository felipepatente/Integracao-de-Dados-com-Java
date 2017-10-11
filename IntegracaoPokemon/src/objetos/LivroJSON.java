package objetos;
import java.util.ArrayList;

public class LivroJSON {
	
	private String codAcervo;
	private String tipoMaterial;
	private String titulo;
	private String classificacao;
	private String isbn;
	private int qtd;
	
	private ArrayList<Autor> autores = new ArrayList<Autor>();
	
	public String getCodAcervo() {
		return codAcervo;
	}

	public void setCodAcervo(String codAcervo) {
		this.codAcervo = codAcervo;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

}
