package entidadeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Marca;
import entidades.Pessoa;
import entidades.Produto;
import util.ConnectionFactory;

public class ProdutoDao  {
	private Connection con = null;

	public ProdutoDao() {
		con = (ConnectionFactory.getConnection());
	}


	public boolean inserir(Produto produto) {
		 
		String sql = "INSERT INTO produto (marca, descricao) VALUES (?, ?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getMarca().getId());
			stmt.setString(2, produto.getDescricao());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}

	
	public List<Produto> Buscartodos() {

		String sql = "SELECT *  FROM marcaProduto";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Produto> produtos = new ArrayList<Produto>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				Marca marca = new Marca();
				marca.setNome(rs.getString("nome"));

				produto.setMarca(marca);

				produtos.add(produto);
			}
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return produtos;
	}

	
	public boolean atualizar(Produto produto) {
		
		String sql = "UPDATE produto SET descricao = ? WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getDescricao());
			stmt.setInt(2, produto.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	public boolean delete(Produto produto) {
		
		String sql = "DELETE FROM produto WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getId());
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
		List<Pessoa> produtos = new ArrayList<Pessoa>();

		return produtos.size() + 1;
	}

}
