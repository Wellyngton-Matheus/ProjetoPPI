package bibliotecaspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaspring.models.Livro;

public class LivroDAO {
	private Connection connection;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean livroEstaEmprestado(int id) {
		try {
		PreparedStatement stmt = this.connection.prepareStatement("select * from livros where id = ?;");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next() && rs.getBoolean("emprestado")) {
			return true;
		}
		}catch(SQLException e) {
			System.out.println("nao deu certo");
		}
		return false;
	}
	public boolean inserir(Livro livro) {
		String sql = "insert into livros (titulo, autor, editora, anoPublicacao, edicao) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setDate(4, new java.sql.Date(livro.getAnoPublicacao().getTimeInMillis()));
			stmt.setInt(5, livro.getEdicao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Livro> getLista() {
		List<Livro> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));

				// montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("anoPublicacao"));
				livro.setAnoPublicacao(data);
				livro.setStrAnoPublicacao(data.YEAR+"");
				livro.setEdicao(rs.getInt("edicao"));

				// adicionando o objeto na lista
				result.add(livro);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Livro livro) {
		String sql = "update livros set titulo=?, autor=?, editora=?, anoPublicacao=?, edicao=?, emprestado=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setDate(4, new java.sql.Date(livro.getAnoPublicacao().getTimeInMillis()));
			stmt.setInt(5, livro.getEdicao());
			stmt.setBoolean(6, livro.isStatusEmprestado());
			stmt.setInt(7, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from livros where id=?;");
			stmt.setInt(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Livro getByTitle(String titulo) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros where titulo = ?;");
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Livro();
				result.setId(rs.getInt("id"));
				result.setTitulo(rs.getString("titulo"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				// montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("anoPublicacao"));
				result.setAnoPublicacao(data);
				result.setStrAnoPublicacao(data.YEAR+"");
				result.setEdicao(rs.getInt("edicao"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public Livro getById(int id) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros where id = ?;");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Livro();
				result.setId(rs.getInt("id"));
				result.setTitulo(rs.getString("titulo"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				// montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("anoPlublicacao"));
				result.setAnoPublicacao(data);
				result.setStrAnoPublicacao(data.YEAR+"");
				result.setEdicao(rs.getInt("edicao"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
