package bibliotecaspring.models;

public class Relatorio {
	
	int matriculaAluno;
	String aluno;
	String tituloLivro;
	String autor;
	int edicao;
	String dataEmprestimo;
	boolean atraso;
	public int getMatriculaAluno() {
		return matriculaAluno;
	}
	public void setMatriculaAluno(int matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	public String getAluno() {
		return aluno;
	}
	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public boolean isAtraso() {
		return atraso;
	}
	public void setAtraso(boolean atraso) {
		this.atraso = atraso;
	}
	@Override
	public String toString() {
		return "Relatorio [matriculaAluno=" + matriculaAluno + ", aluno=" + aluno + ", tituloLivro=" + tituloLivro
				+ ", autor=" + autor + ", edicao=" + edicao + ", dataEmprestimo=" + dataEmprestimo + ", atraso="
				+ atraso + "]";
	}
}
