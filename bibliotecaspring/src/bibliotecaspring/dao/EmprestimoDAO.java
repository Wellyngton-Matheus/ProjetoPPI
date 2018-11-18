package bibliotecaspring.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaspring.models.Aluno;
import bibliotecaspring.models.Emprestimo;
import bibliotecaspring.models.Livro;

public class EmprestimoDAO {
	private static Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Emprestimo emprestimo) {

		String sql = "insert into emprestimo (livro, aluno, dataEmprestimo, dataDevolucao) values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, emprestimo.getLivro().getId());
			stmt.setLong(2, emprestimo.getAluno().getId());			
			Calendar dataEmp = Calendar.getInstance();
			stmt.setDate(3, new java.sql.Date(dataEmp.getTimeInMillis()));
			stmt.setDate(4, null);
			
			stmt.execute();
			stmt.close();
			System.out.println("foi emprestado");

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public boolean qtdEmprestimos(Emprestimo emprestimo) throws SQLException {

		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimo where aluno = ? and dataDevolucao IS NULL;");
			stmt.setLong(1, emprestimo.getAluno().getId());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
			}
			stmt.close();
			if (cont > 2) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public List<Emprestimo> getLista() {
		try {

			List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection.prepareStatement("select * from emprestimo;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				emprestimo.add (criandoEmprestimo(rs));
				
			}
			rs.close();
			stmt.close();
			return emprestimo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean remover(Emprestimo emprestimo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where id=?;");
			stmt.setLong(1, emprestimo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private Emprestimo criandoEmprestimo(ResultSet rs) throws SQLException {
		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setId(rs.getLong("id"));
		Aluno aluno = new AlunoDAO().getById(rs.getLong("aluno"));
		emprestimo.setAluno(aluno);
		Livro livro = new LivroDAO().getById(rs.getLong("livro"));
		emprestimo.setLivro(livro);

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataEmprestimo"));
		emprestimo.setDataEmprestimo(data);

		if (rs.getDate("dataDevolucao") != null) {
			Calendar data2 = Calendar.getInstance();
			data2.setTime(rs.getDate("dataDevolucao"));
			emprestimo.setDataDevolucao(data2);
		}

		return emprestimo;
	}

	public boolean devolucao(Emprestimo emprestimo) {
		String sql = "update emprestimo set dataDevolucao=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(2, emprestimo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Emprestimo getEmprestimoByID(Long id) {
		try {

			Emprestimo emprestimo = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimos where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				emprestimo = criandoEmprestimo(rs);
			}
			rs.close();
			stmt.close();
			return emprestimo;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
	
	public boolean livroEmprestado(int id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select id from emprestimo where idLivro = ? and dataDevolucao is null;");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	

	

}