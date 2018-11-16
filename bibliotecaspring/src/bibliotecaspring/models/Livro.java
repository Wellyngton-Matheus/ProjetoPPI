package bibliotecaspring.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Livro {
	int id;
	String titulo;
	String autor;
	String editora;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	Calendar anoPublicacao;
	String strAnoPublicacao;
	int edicao;
	boolean statusEmprestado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Calendar getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Calendar anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getStrAnoPublicacao() {
		return strAnoPublicacao;
	}

	public void setStrAnoPublicacao(String strAnoPublicacao) {
		this.strAnoPublicacao = strAnoPublicacao;
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
				+ ", anoPublicacao=" + anoPublicacao + ", strAnoPublicacao=" + strAnoPublicacao + ", edicao=" + edicao
				+ ", statusEmprestado=" + statusEmprestado + "]";
	}

	
}
