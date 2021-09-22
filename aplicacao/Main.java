package aplicacao;

import java.text.DecimalFormat;
import java.util.Scanner;



import entidadeDao.*;
import entidades.*;


public class Main {
	 private static final Scanner sc = new Scanner(System.in);
	 private static final DecimalFormat df = new DecimalFormat("#,###.00");
	public static void main(String[] args) {
		
		//dados ja inseridos!!!
		dados();
		dadospro();
		dadosps();
		dadosCompra();
		dadosVenda();
		dadosEstq();
		
		//menu();
	
	

	}
	
	private static void dados() {
				
		MarcaDao dao = new MarcaDao();
		dao.inserir(new Marca("Qboa"));
		
		
	}
	
	private static void dadospro() {
		Marca marca = new Marca();
		marca.setId(1);
		ProdutoDao dao = new ProdutoDao();
		dao.inserir(new Produto("Fandagos", marca));
		
	}
	
	private static void dadosps() {
		
		PessoaDao dao = new PessoaDao();
		dao.inserir(new Pessoa("Thiago", "22233311112", "Funcionario"));
		
	}
	
	private static void dadosEstq() {
		Pessoa pessoa = new Pessoa();
		Produto produto = new Produto();
		Estoque estoque = new Estoque();
		pessoa.setId(1);
		produto.setId(2);
		EstoqueDao dao = new EstoqueDao();
		estoque.setPessoa(pessoa);
		estoque.setProduto(produto);
		estoque.setQuantidade(30);
		estoque.setValor(5.00);
		estoque.setValorTotal(estoque.getValor());
		dao.inserir(estoque);
	}
	
	private static void dadosCompra() {
		Compra compra = new Compra();
		CompraDao dao = new CompraDao();
		Produto produto = new Produto();
		compra.setQuantidade(5);
		produto.setId(1);
		compra.setProduto(produto);
		dao.inserir(compra);
		
	}
	
	private static void dadosVenda() {
		Venda venda = new Venda();
		VendaDao dao = new VendaDao();
		Produto produto = new Produto();
		venda.setQuantidade(1);
		produto.setId(1);
		venda.setProduto(produto);
		dao.inserir(venda);
		
	}

	private static void menu() {
		int opcao;
		
		do {
			imprimeOpcoes();
			opcao = sc.nextInt();
			trataOpcaoMenu(opcao);
		} while (opcao != 0);
		
		System.exit(0);
		
	}

	private static void imprimeOpcoes() {
		System.out.println("+-------------------------+");
		System.out.println("| ### PROJETO ESTOQUE ### |");
		System.out.println("|                         |");
		System.out.println("| 1 - Estoque             |");
		System.out.println("| 2 - Cadastros           |");
		System.out.println("|                         |");
		System.out.println("| 0 - Sair                |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}

	private static void trataOpcaoMenu(int opcao) {
		switch (opcao) {
		case 1:
			menuEstoque();
			break;
		case 2:
			menuCadastros();
			break;

		}
	}
	

	private static void imprimeOpcoesEstoque() {
		System.out.println("+-------------------------+");
		System.out.println("| ###   Estoque  ###      |");
		System.out.println("|                         |");
		System.out.println("|     1 - Compra          |");
		System.out.println("|     2 - Venda           |");
		System.out.println("|                         |");
		System.out.println("| 0 - Voltar              |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}

	private static void menuEstoque() {
		

		int opcao;
		do {
			imprimeOpcoesEstoque();

			opcao = sc.nextInt();
			trataOpcaoMenuEstoque(opcao);
		} while (opcao != 0);
		menu();
	}

	private static void trataOpcaoMenuEstoque(int estoque) {
		ListEstoque();
		switch (estoque) {
		
		case 1: {
			System.out.println("Compra cadastradas:");
			ListCompra();
			
			int opcao;

			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuEstoque(estoque, opcao);
				break;
			} while (opcao != 0);
			
		}
		case 2: {
			System.out.println("Venda cadastrados:");
			ListVenda();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuEstoque(estoque, opcao);
				break;
			} while (opcao != 0);
		}
		case 3: {
			System.out.println("Usuarios cadastrados:");
			LisPessoa();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuEstoque(estoque, opcao);
				break;
			} while (opcao != 0);
			
		}
		}
	}

	private static void trataAcaoMenuEstoque(int estoque, int opcao) {
		switch (estoque) {
		case 1: {
			trataAcaoCadastroCompra(opcao);
			break;
		}

		case 2: {
			trataAcaoCadastroVenda(opcao);
			break;
		}
		}
	}

	private static void imprimeOpcoesCadastros() {
		System.out.println("+-------------------------+");
		System.out.println("| ### Cadastros  ###      |");
		System.out.println("|                         |");
		System.out.println("|     1 - Marcas          |");
		System.out.println("|     2 - Produtos        |");
		System.out.println("|     3 - Usuarios        |");
		System.out.println("|                         |");
		System.out.println("| 0 - Voltar              |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}

	private static void menuCadastros() {
		
		int opcao;
		do {
			imprimeOpcoesCadastros();

			opcao = sc.nextInt();
			trataOpcaoMenuCadastros(opcao);
		} while (opcao != 0);
		menu();
	}

	

	private static void imprimeAcoesCadastros() {
		
		System.out.println("+-------------------------+");
		System.out.println("| 1 - Inserir             |");
		System.out.println("| 2 - Alterar             |");
		System.out.println("| 3 - Excluir             |");
		System.out.println("|                         |");
		System.out.println("| 0 - Voltar              |");
		System.out.println("+-------------------------+");
		System.out.print("Digite uma Opção: ");
	}
	
	
	private static void trataOpcaoMenuCadastros(int cadastro) {
		
		switch (cadastro) {
		case 1: {
			System.out.println("Marcas cadastradas:");
			ListMarca();
			int opcao;
			
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuCadastros(cadastro, opcao);
				break;	
			} while (opcao != 0);
		}
		case 2: {
			System.out.println("Produtos cadastrados:");
			LisProd();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuCadastros(cadastro, opcao);
				break;
			} while (opcao != 0);
		}
		case 3: {
			System.out.println("Usuarios cadastrados:");
			LisPessoa();
			int opcao;
			do {
				imprimeAcoesCadastros();
				opcao = sc.nextInt();
				trataAcaoMenuCadastros(cadastro, opcao);
				break;
			} while (opcao != 0);
		}
		}
	}

	public static void inserirMarca() {
		
		Marca marca = new Marca();
		MarcaDao dao = new MarcaDao();
		System.out.println("Nome");
		marca.setNome(sc.nextLine());

		if (dao.inserir(marca)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarMarca() {
		
		Marca marca = new Marca();
		MarcaDao dao = new MarcaDao();
		System.out.println("Digite o id da marca a ser atualizada:");
		marca.setId(sc.nextInt());
		System.out.println("Atualizar nome:");
		sc.nextLine();
		marca.setNome(sc.nextLine());
		if (dao.atualizar(marca)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deleteMarca() {
		
		Marca marca = new Marca();
		MarcaDao dao = new MarcaDao();
		System.out.println("Digite o id da marca a ser deletada:");
		marca.setId(sc.nextInt());
		if (dao.delete(marca)) {
			System.out.println("Deletada  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void ListMarca() {

		MarcaDao dao = new MarcaDao();

		for (Marca m : dao.Buscartodos()) {
			System.out.println("Id"+ m.getId()+ " Nome Marca: " + m.getNome());
		}
	}

	public static void inserirProd() {
		
		Produto produto = new Produto();
		Marca marca = new Marca();
		ProdutoDao dao = new ProdutoDao();
		System.out.println("Descricao");
		produto.setDescricao(sc.nextLine());
		System.out.println("Marca:");
		marca.setId(sc.nextInt());
		produto.setMarca(marca);
		if (dao.inserir(produto)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarProd() {
		
		Produto produto = new Produto();
		Marca marca = new Marca();
		ProdutoDao dao = new ProdutoDao();
		System.out.println("Digite o id da produto a ser atualizada:");
		produto.setId(sc.nextInt());
		System.out.println("Descricao");
		sc.nextLine();
		produto.setDescricao(sc.nextLine());
		System.out.println("Marca:");
		marca.setId(sc.nextInt());
		produto.setMarca(marca);
		if (dao.atualizar(produto)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deleteProd() {
		
		Produto produto = new Produto();
		ProdutoDao dao = new ProdutoDao();
		System.out.println("Digite o id da produto a ser deletada:");
		produto.setId(sc.nextInt());
		if (dao.delete(produto)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void LisProd() {
		ProdutoDao dao = new ProdutoDao();

		for (Produto p : dao.Buscartodos()) {
			System.out.println("id: " + p.getId() + " Descricao: " + p.getDescricao() + " Nome: " + p.getMarca().getNome());
		}

	}

	public static void inserirPessoa() {
		
		Pessoa pessoa = new Pessoa();
		PessoaDao dao = new PessoaDao();
		System.out.println("Nome: ");
		pessoa.setNome(sc.nextLine());
		System.out.println("CPF/CNPJ");
		pessoa.setIndentificacao(sc.nextLine());
		System.out.println("tipoPessoa digite funcionario / cliente:");
		pessoa.setTipoPessoa(sc.nextLine());
		if (dao.inserir(pessoa)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void atualizarPessoa() {
		
		Pessoa pessoa = new Pessoa();
		PessoaDao dao = new PessoaDao();
		System.out.println("Digite o id da pessoa a ser atualizada:");
		pessoa.setId(sc.nextInt());
		System.out.println("Nome: ");
		sc.nextLine();
		pessoa.setNome(sc.nextLine());
		System.out.println("CPF/CNPJ");
		pessoa.setIndentificacao(sc.nextLine());
		System.out.println("tipoPessoa digite funcionario / cliente:");
		pessoa.setTipoPessoa(sc.nextLine());
		if (dao.atualizar(pessoa)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void deletePessoa() {
		
		Pessoa pessoa = new Pessoa();
		PessoaDao dao = new PessoaDao();
		System.out.println("Digite o id da pessoa a ser deletada:");
		pessoa.setId(sc.nextInt());
		if (dao.delete(pessoa)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void LisPessoa() {
		PessoaDao dao = new PessoaDao();

		for (Pessoa p : dao.Buscartodos()) {
			System.out.println("id: " + p.getId() + " Nome: " + p.getNome() + " cpf/cnpj: " + p.getIndentificacao()
					+ " Tipo Pessoa: " + p.getTipoPessoa());
		}

	}

	public static void inserirCompra() {
		
		
		Produto produto = new Produto();
		EstoqueDao estoque = new EstoqueDao();
		CompraDao dao = new CompraDao();
		Compra compra = new Compra();
		
		System.out.println("Digite o id do Produto:");
		produto.setId(sc.nextInt());
		compra.setProduto(produto);
		System.out.println("Digite a quantidade:");
		compra.setQuantidade(sc.nextInt());
		
		if (dao.inserir(compra)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
		estoque.somaQtd();
		
	}

	public static void atualizarCompra() {

		EstoqueDao estoque = new EstoqueDao();
		Compra compra = new Compra();
		CompraDao dao = new CompraDao();
		System.out.println("Digite o id da Compra:");
		compra.setId(sc.nextInt());
		System.out.println("Digite a quantidade:");
		compra.setQuantidade(sc.nextInt());
		
		if (dao.atualizar(compra)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
		estoque.somaQtd();
	}
	
	public static void deletaCompra() {
		
		Compra compra = new Compra();
		CompraDao dao = new CompraDao();
		System.out.println("Digite o id da Compra:");
		compra.setId(sc.nextInt());
		
		
		if (dao.delete(compra)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}
	

	public static void inserirVenda() {
		
		EstoqueDao estoque = new EstoqueDao();
		
		Produto produto = new Produto();
		Venda venda = new Venda();
		VendaDao dao = new VendaDao();
		
		System.out.println("Digite o id do Produto:");
		produto.setId(sc.nextInt());
		venda.setProduto(produto);
		System.out.println("Digite a quantidade:");
		venda.setQuantidade(sc.nextInt());
		
		if (dao.inserir(venda)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
		estoque.subQtd();
	}

	public static void atualizarVenda() {
		
		EstoqueDao estoque = new EstoqueDao();
		Venda venda = new Venda();
		VendaDao dao = new VendaDao();
		System.out.println("Digite o id da Compra:");
		venda.setId(sc.nextInt());
		System.out.println("Digite a quantidade:");
		venda.setQuantidade(sc.nextInt());
		
		if (dao.atualizar(venda)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
		estoque.subQtd();
	}
	
	public static void deletaVenda() {
		
		Venda venda = new Venda();
		VendaDao dao = new VendaDao();
		System.out.println("Digite o id da Venda:");
		venda.setId(sc.nextInt());
		
		
		if (dao.delete(venda)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}
	
public static void inserirEstoque() {
		
		
		
		Pessoa pessoa = new Pessoa();
		Estoque estoque = new Estoque();
		Produto produto = new Produto();
		EstoqueDao dao = new EstoqueDao();
		
		System.out.println("Digite o id do Pessoa:");
		pessoa.setId(sc.nextInt());
		estoque.setPessoa(pessoa);
		System.out.println("Digite id Produto:");
		produto.setId(sc.nextInt());
		estoque.setProduto(produto);
		System.out.println("Digite a Quantidade:");
		estoque.setQuantidade(sc.nextInt());
		System.out.println("Digite o valor:");
		estoque.setValor(sc.nextInt());
		if (dao.inserir(estoque)) {
			System.out.println("Salvo com sucesso!!");
		} else {
			System.out.println("erro ");
		}
		
	}

	public static void atualizarEstoque() {
		
		Estoque estoque = new Estoque();
		Produto produto = new Produto();
		EstoqueDao dao = new EstoqueDao();;
		System.out.println("Digite o id do Produto:");
		produto.setId(sc.nextInt());
		estoque.setProduto(produto);
		System.out.println("Digite a quantidade:");
		estoque.setQuantidade(sc.nextInt());
		
		if (dao.atualizar(estoque)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
		
	}
	
	

	public static void deleteEstoque() {
		
		Estoque estoque = new Estoque();
		Produto produto = new Produto();
		EstoqueDao dao = new EstoqueDao();
		System.out.println("Digite o id a ser deletada:");
		produto.setId(sc.nextInt());
		estoque.setProduto(produto);
		if (dao.delete(estoque)) {
			System.out.println("Atualizado  com sucesso!!");
		} else {
			System.out.println("erro ");
		}
	}

	public static void ListEstoque() {
		EstoqueDao dao = new EstoqueDao();

		for (Estoque e : dao.Buscartodos()) {
			System.out.println("id " + e.getProduto().getId() + " Descricao: " + e.getProduto().getDescricao() + " Nome: "
					+ e.getProduto().getMarca().getNome() + " Quantidade: "+ e.getQuantidade()+ " valor: "+ df.format(e.getValor())+ " valortotal: "+ df.format(e.getValorTotal()) );
		}

	}
	
	public static void ListCompra() {
		CompraDao dao = new CompraDao();

		for (Compra c : dao.Buscartodos()) {
			System.out.println("id " + c.getId() + " Descricao: " + c.getProduto().getDescricao() + " Quantidade: "+ c.getQuantidade() );
		}

	}
	
	public static void ListVenda() {
		VendaDao dao = new VendaDao();

		for (Venda v : dao.Buscartodos()) {
			System.out.println("id " + v.getId() + " Descricao: " + v.getProduto().getDescricao() + " Quantidade: "+ v.getQuantidade() );
		}

	}
	
	
	private static void trataAcaoMenuCadastros(int cadastro, int opcao) {
		switch (cadastro) {
		case 1: {
			trataAcaoCadastroMarca(opcao);
			break;
		}
		case 2: {
			trataAcaoCadastroProduto(opcao);
			break;
		}

		case 3: {
			trataAcaoCadastroUsuario(opcao);
			break;
		}
		}
	}

	private static void trataAcaoCadastroProduto(int acao) {
		while(true) {
		switch (acao) {
		case 1: {
			inserirProd();
			break;
		}

		case 2: {
			atualizarProd();
			break;
		}

		case 3: {
			deleteProd();
			break;
		}
		}menuCadastros();
		}

	}

	private static void trataAcaoCadastroMarca(int acao) {
		while(true) {
		switch (acao) {
		
		case 1: {
			inserirMarca();
		}

		case 2: {
			atualizarMarca();
			break;
		}

		case 3: {
			deleteMarca();
			break;
		}
		}menuCadastros();
		}
	}

	private static void trataAcaoCadastroUsuario(int acao) {
		while(true) {
		switch (acao) {
		case 1: {
			inserirPessoa();
			break;
		}

		case 2: {
			atualizarPessoa();
			break;
		}

		case 3: {
			deletePessoa();
			break;
		}
		}menuCadastros();
		}

	}

	private static void trataAcaoCadastroVenda(int acao) {
		while(true) {
		switch (acao) {
		case 1: {
			inserirVenda();
			break;
		}

		case 2: {
			atualizarVenda();
			break;
		}

		case 3: {
			deletaVenda();
			break;
		}
		}menuEstoque();
		}
	}

	private static void trataAcaoCadastroCompra(int acao) {
		while(true) {
		switch (acao) {
		case 1: {
			inserirCompra();
			break;
		}

		case 2: {
			atualizarCompra();
			break;
		}

		case 3: {
			deletaCompra();
			break;
		}
		}menuEstoque();
		}
	}

}
