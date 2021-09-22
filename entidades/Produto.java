package entidades;

public class Produto {
	
	private int id; 
	private String descricao;
	private Marca marca;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String descricao, Marca marca) {
		this.descricao = descricao;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public String toString() {
		return "Codigo: "
				+ getId()
				+ "\n"
				+ "Nome Produto: "
				+ getDescricao()
				+ "\n"
				+ "Marca Produto: "
				+ getMarca();
				
				
	}

	
	

}
