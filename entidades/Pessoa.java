package entidades;

public class Pessoa {
	
	
	private int id;
	private String nome;
	private String indentificacao;
	private String tipoPessoa;
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	

	public Pessoa( String nome, String indentificacao, String tipoPessoa) {
		this.nome = nome;
		this.indentificacao = indentificacao;
		this.tipoPessoa = tipoPessoa;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public String getIndentificacao() {
		return indentificacao;
	}



	public void setIndentificacao(String indentificacao) {
		this.indentificacao = indentificacao;
	}



	public String getTipoPessoa() {
		return tipoPessoa;
	}



	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}




	
	
	

}
