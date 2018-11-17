package bibliotecaspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaspring.models.Emprestimo;
import bibliotecaspring.models.Relatorio;


public class EmprestimoDAO {
	private static Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public int qtdLivrosEmprestadosAluno(int matricula) {
		int contLivros = 0;
		String sql = "select emprestimo.id from emprestimo, aluno where aluno.matricula = emprestimo.mat_aluno && emprestimo.mat_aluno = ? && emprestimo.data_devolucao is null;";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, matricula);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				contLivros++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contLivros;
	}
	public static boolean inserir(Emprestimo emprestimo) {
		String sql = "insert into emprestimo (mat_aluno, id_livro, data_emprestimo, data_devolucao) values (?, ?, ?, ?);";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, emprestimo.getMatriculaAluno());
			stmt.setInt(2, emprestimo.getIdLivro());
			stmt.setDate(3, new java.sql.Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			stmt.setDate(4, null);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean setDataDevolucaoEmprestimo(int idEmprestimo) {
		String sql = "update emprestimo set data_devolucao = ? where id = ? && emprestimo.data_devolucao is null;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			Calendar dataDevolucao = Calendar.getInstance();
			stmt.setDate(1, new java.sql.Date(dataDevolucao.getTimeInMillis()));
			stmt.setInt(2, idEmprestimo);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean devolucaoLivro(int id) {
		String sql = "update livro set emprestado = 0 where id = ?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<String> getListaEmprestimosDoAluno(int matricula) {
		List<String> result = new ArrayList<>();

		try {
			String sql = "select livro.titulo from livro, emprestimo where emprestimo.id_livro = livros.id && emprestimo.mat_aluno = ? && livro.emprestado = 1;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, matricula);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				String titulo = rs.getString("titulo");
				// adicionando o objeto na lista
				result.add(titulo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<Emprestimo> getByMatAluno(int matricula){
		List<Emprestimo> result = new ArrayList<>();
		return result;
	}

	public int getIdEmprestimo(int idLivro) {
		int idEmprestimo = 0;
		try {
			String sql = "select emprestimo.id from emprestimos where emprestimo.id_livro = ? and emprestimos.data_devolucao is null;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idLivro);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				idEmprestimo = rs.getInt("id");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idEmprestimo;
	}
	
	public List<Relatorio> emprestimos(){
		List<Relatorio> result = new ArrayList<>();
		try {
			String sql = "select emprestimo.mat_aluno, aluno.nome, livro.titulo, livro.autor, livro.edicao, emprestimo.data_emprestimo from emprestimo, aluno, livro where emprestimo.mat_aluno = alunos.matricula && emprestimo.id_livro = livro.id && emprestimo.data_devolucao is null;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Relatorio r = new Relatorio();
				r.setMatriculaAluno(rs.getInt("mat_aluno"));
				r.setAluno(rs.getString("nome"));
				r.setTituloLivro(rs.getString("titulo"));
				r.setAutor(rs.getString("autor"));
				r.setEdicao(rs.getInt("edicao"));
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(rs.getDate("data_emprestimo"));
				r.setDataEmprestimo(dataEmprestimo.getTime().toString());
				
				Calendar dataCalendar = Calendar.getInstance();
				int tempoInicial = (int) dataEmprestimo.getTimeInMillis();
				int tempoAtual = (int) dataCalendar.getTimeInMillis();
				int inspiracao = tempoInicial + (24 * 60 * 60 * 1000 * 14);
				
				if(tempoAtual <= inspiracao) {
					r.setAtraso(true);
				}else {
					r.setAtraso(false);
				}
				result.add(r);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
