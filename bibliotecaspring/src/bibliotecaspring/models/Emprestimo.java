package bibliotecaspring.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Emprestimo {
	int idLivro;
	int matriculaAluno;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	Calendar dataEmprestimo;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	Calendar dataDevolucao;

	String nomeAluno;
	String tituloLivroEmprestado;

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(int matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getTituloLivroEmprestado() {
		return tituloLivroEmprestado;
	}

	public void setTituloLivroEmprestado(String tituloLivroEmprestado) {
		this.tituloLivroEmprestado = tituloLivroEmprestado;
	}

	@Override
	public String toString() {
		return "Emprestimo [idLivro=" + idLivro + ", matriculaAluno=" + matriculaAluno + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", nomeAluno=" + nomeAluno
				+ ", tituloLivroEmprestado=" + tituloLivroEmprestado + "]";
	}
}
