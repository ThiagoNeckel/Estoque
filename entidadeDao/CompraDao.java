package entidadeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Compra;
import entidades.Produto;
import util.ConnectionFactory;

public class CompraDao {

	private Connection con = null;

	public CompraDao() {
		con = (ConnectionFactory.getConnection());
	}

	public boolean inserir(Compra compra) {

		String sql = "INSERT INTO compra ( produto, quantidade ) VALUES (?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, compra.getProduto().getId());
			stmt.setInt(2, compra.getQuantidade());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}

	public List<Compra> Buscartodos() {

		String sql = "SELECT * FROM public.compraprod";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Compra> compras = new ArrayList<Compra>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				Compra compra = new Compra();
				
				compra.setId(rs.getInt("id"));
				
				produto.setDescricao(rs.getString("descricao"));

				compra.setQuantidade(rs.getInt("quantidade"));

				compra.setProduto(produto);
				compras.add(compra);
			}
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return compras;
	}
	
	


	public boolean atualizar(Compra compra) {

		String sql = "UPDATE estoque SET quantidade = ? WHERE id= ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, compra.getQuantidade());
			stmt.setInt(2, compra.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	public boolean delete(Compra compra) {

		String sql = "DELETE FROM compra WHERE if = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, compra.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Deletar" + e);
			return false;
		}

	}


}
