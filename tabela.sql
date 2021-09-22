CREATE TABLE marca(
	id SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR(45) NOT NULL
);

CREATE TABLE produto (
	id SERIAL PRIMARY KEY NOT NULL,
	descricao VARCHAR(45) NOT NULL,
	marca INTEGER,
	FOREIGN KEY(marca) REFERENCES marca (id)
);

CREATE TABLE pessoa (
	id SERIAL PRIMARY KEY,
	nome TEXT,
	indentificacao VARCHAR(14) NOT NULL,
	tipoPessoa VARCHAR(45) NOT NULL
	
);

CREATE TABLE estoque (
	produto INTEGER PRIMARY KEY NOT NULL,
	quantidade int NOT NULL,
	valor NUMERIC NOT NULL,
	valorTotal NUMERIC NOT NULL,
	pessoa INTEGER NOT NULL,
	FOREIGN KEY(produto) REFERENCES produto (id),
	FOREIGN KEY(pessoa)  REFERENCES pessoa (id)
);


CREATE TABLE compra(
	id SERIAL PRIMARY KEY NOT NULL,
	produto INTEGER NOT NULL,
	quantidade INTEGER NOT NULL,
	FOREIGN KEY(produto) REFERENCES produto (id)
	
);

CREATE TABLE venda(
	id SERIAL PRIMARY KEY NOT NULL,
	produto INTEGER NOT NULL,
	quantidade INTEGER NOT NULL,
	FOREIGN KEY(produto) REFERENCES produto (id)
	
);








CREATE VIEW marcaproduto AS SELECT p.id , p.descricao, m.nome  FROM produto p inner join marca m on m.id = p.marca;

CREATE VIEW produtoestoque AS select e.produto, p.descricao,m.nome, e.quantidade, e.valor, e.valortotal from estoque e
INNER JOIN compra c on e.produto = c.produto join produto p on p.id = e.produto join marca m on p.marca = m.id;

CREATE VIEW compraprod AS select c.id, p.descricao, c.quantidade  from compra c inner join produto p on c.produto = p.id;

CREATE VIEW vendaprod AS select v.id, p.descricao, v.quantidade  from venda v inner join produto p on v.produto = p.id;
