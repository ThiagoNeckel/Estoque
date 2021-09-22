package entidadeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Pessoa;
import util.ConnectionFactory;

public class PessoaDao  {

	private Connection con = null;

	public PessoaDao() {
		con = (ConnectionFactory.getConnection());
	}

	
	public boolean inserir(Pessoa pessoa) {
		
		String sql = "INSERT INTO pessoa  (nome, indentificacao, tipoPessoa) VALUES (?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getIndentificacao());
			stmt.setString(3, pessoa.getTipoPessoa());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}

	public List<Pessoa> Buscartodos() {

		String sql = "SELECT * FROM pessoa";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.executeQuery();
			

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setIndentificacao(rs.getString("indentificacao"));
				pessoa.setTipoPessoa(rs.getString("tipoPessoa"));
				pessoas.add(pessoa);
				
			}
			
			
		
			   
			
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return pessoas;
	}


	public boolean atualizar(Pessoa pessoa) {
		
		String sql = "UPDATE pessoa SET  nome = ?, indentificacao = ?, tipoPessoa = ?  WHERE id = (?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			;
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getIndentificacao());
			stmt.setString(3, pessoa.getTipoPessoa());
			stmt.setInt(4, pessoa.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	
	public boolean delete(Pessoa pessoa) {
		
		String sql = "DELETE FROM pessoa WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, pessoa.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Deletar" + e);
			return false;
		}
	}

	
	public long proximoCodigo() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		return pessoas.size() + 1;
	}

}
