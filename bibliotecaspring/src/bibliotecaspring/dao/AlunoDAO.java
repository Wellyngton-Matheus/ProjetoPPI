package bibliotecaspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaspring.models.Aluno;

public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();

	}

	public  boolean inserir(Aluno aluno) {

		String sql = "insert into aluno (matricula, nome, cpf, dataNascimento, endereco) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getCpf());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, aluno.getEndereco());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Aluno> getLista() {
		List<Aluno> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from aluno;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);
				aluno.setEndereco(rs.getString("endereco"));
				
				result.add(aluno);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Aluno aluno) {
		String sql = "update aluno set matricula=?, nome=?, cpf=?, dataNascimento=?, endereco=? where matricula=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getCpf());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, aluno.getEndereco());
			stmt.setString(6, aluno.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Aluno aluno) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from aluno where id=?;");
			stmt.setLong(1, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Aluno getById(long l) {
		Aluno result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from aluno where matricula = ?;");
			stmt.setInt(1, (int) l);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Aluno();
				result.setMatricula(rs.getString("matricula"));
				result.setNome(rs.getString("nome"));
				result.setCpf(rs.getString("cpf"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(data);

				result.setEndereco(rs.getString("endereco"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Aluno getByMatricula(int matriculaAluno) {
		// TODO Auto-generated method stub
		return null;
	}

}
