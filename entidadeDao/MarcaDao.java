package entidadeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Marca;
import entidades.Pessoa;
import util.ConnectionFactory;

public class MarcaDao  {

	private Connection con = null;

	public MarcaDao() {
		
		con = (ConnectionFactory.getConnection());
	}


	
	public boolean inserir(Marca marca) {
		
		String sql = "INSERT INTO marca (nome) VALUES (?)";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, marca.getNome());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Inserir" + e);
			return false;
		}

	}


	public List<Marca> Buscartodos() {

		String sql = "SELECT * FROM marca";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Marca> marcas = new ArrayList<Marca>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Marca marca = new Marca();
				marca.setId(rs.getInt("id"));
				marca.setNome(rs.getString("nome"));
				marcas.add(marca);

			}
			stmt.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("erro" + e);
		}
		return marcas;
	}


	public boolean atualizar(Marca marca) {
		
		String sql = "UPDATE marca SET nome = ? WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, marca.getNome());
			stmt.setInt(2, marca.getId());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			System.out.println("erro ao Atualizar" + e);
			return false;
		}

	}

	
	public boolean delete(Marca marca) {
		
		String sql = "DELETE FROM marca WHERE id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, marca.getId());
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
		List<Pessoa> marcas = new ArrayList<Pessoa>();

		return marcas.size() + 1;
	}

}
