package bibliotecaspring.models;

public class Livro {
	int id;
	String titulo;
	String autor;
	String editora;
	int anoPublicado;
	int edicao;
	boolean statusEmprestado;

	public int getId() {
		return id;
	}

	public void setId(long l) {
		this.id = (int) l;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getanoPublicado() {
		return anoPublicado;
	}

	public void setanoPublicado(int anoPublicado) {
		this.anoPublicado = anoPublicado;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public boolean isStatusEmprestado() {
		return statusEmprestado;
	}

	public void setStatusEmprestado(boolean statusEmprestado) {
		this.statusEmprestado = statusEmprestado;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora
				+ ", anoPublicado=" + anoPublicado + ", stranoPublicado=" + ", edicao=" + edicao
				+ ", statusEmprestado=" + statusEmprestado + "]";
	}

	
}
