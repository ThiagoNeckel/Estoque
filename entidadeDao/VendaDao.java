package entidadeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Venda;
import entidades.Produto;
import util.ConnectionFactory;

public class VendaDao {

	private Connection con = null;

	public VendaDao() {
		con = (ConnectionFactory.getConnection());
	}

	public boolean inserir(Venda venda) {

		String sql = "INSERT INTO venda ( produto, quantidade ) VALUES (?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, venda.getProduto().getId());
			stmt.setInt(2, venda.getQuantidade());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}

	public List<Venda> Buscartodos() {

		String sql = "select * from venda";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Venda> vendas = new ArrayList<Venda>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				Venda venda = new Venda();
				
				venda.setId(rs.getInt("id"));
				
				produto.setDescricao(rs.getString("descricao"));
				
				venda.setQuantidade(rs.getInt("quantidade"));

				venda.setProduto(produto);
				vendas.add(venda);
			}
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return vendas;
	}
	
	


	public boolean atualizar(Venda venda) {

		String sql = "UPDATE venda SET quantidade = ? WHERE id= ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, venda.getQuantidade());
			stmt.setInt(2, venda.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	public boolean delete(Venda venda) {

		String sql = "DELETE FROM venda WHERE if = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, venda.getId());
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
