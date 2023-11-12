-- Consultas

-- Inserção de dados

-- Clientes

-- Cliente.tipo = 1 é pessoa física -> dataNascimento, sexo e CPF != NULL e CNPJ == NULL
-- Cliente.tipo = 2 é pessoa jurídica -> dataNascimento, sexo e CPF == NULL e CNPJ != NULL

-- Cliente

INSERT INTO clientes (tipo, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf, cnpj)
VALUES (1, 'Andre', '2001-12-06', 'M', 'andre@email.com', '47999994365', 'Imperador', 'Itaum', 123, '126', NULL);

-- Pessoa Fisica
INSERT INTO clientes (tipo, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf)
VALUES (1, 'Andre', '2001-12-06', 'M', 'andre@email.com', '47999994365', 'Imperador', 'Itaum', 123, '126');

-- Pessoa Jurídica 
INSERT INTO clientes (tipo, nome, email, telefone, rua, bairro, cep, cnpj)
VALUES (2, 'RoboCore', 'robocore@email.com', '1135227626', 'Imperador', 'Floresta', 321, '621');

SELECT * FROM clientes;

-- Produto 
INSERT INTO produtos (precounitvenda, precounitcompra, descricao, quantidade, datasheet)
VALUES (0.05, 0.02, 'Resistor de filme de carbono de 1K (1000Ω), de 1/4W e tolerância de +/-5%.',
	   1000, NULL);


SELECT * FROM produtos;

-- Kits


-- Fornecedor
INSERT INTO fornecedor (nome, cnpj, email)
VALUES ('Forne1', '1234567', 'forne1@email.com' );


SELECT * FROM fornecedor


-- Transportadora
INSERT INTO transportadora (nome, cnpj, email, custokm)
VALUES ('Trans1', '1234567', 'trans1@email.com', 2.3);


SELECT * FROM transportadora

-- Venda

-- Compra

