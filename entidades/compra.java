package entidades;

public class Compra  {
	
	private int id;
	private Produto produto;
	private int quantidade;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	


	public Compra(  Produto produto, int quantidade, double valor) {
		
		
		this.produto = produto;
		this.quantidade = quantidade;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
}
