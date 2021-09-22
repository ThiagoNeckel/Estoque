package entidades;

public class Estoque {

	private Produto produto;
	private Pessoa pessoa;
	private int quantidade;
	private double valor;
	private double valorTotal;
	
	
	public Estoque() {
		// TODO Auto-generated constructor stub
	}

	public Estoque(Pessoa pessoa, Produto produto, int quantidade, double valor) {

		this.pessoa = pessoa;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal= valorTotal;
		
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String toString() {
		return getProduto().toString() + "Quantidade Estoque: " + getQuantidade() + "\n" + "Valor por unidade: "
				+ String.format("%.2f", getValor()) + "\n" + "Valor total: " + String.format("%.2f", valorTotal)
				+ "\n";
	}

	

	

	
	

		
	
	
	

	
	






}
