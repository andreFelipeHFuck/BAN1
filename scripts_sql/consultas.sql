-- Consultas

-- Inserção de dados-- Clientes

-- Cliente.tipo = 1 é pessoa física -> dataNascimento, sexo e CPF != NULL e CNPJ == NULL
-- Cliente.tipo = 2 é pessoa jurídica -> dataNascimento, sexo e CPF == NULL e CNPJ != NULL

-- Cliente:

-- Inserção

INSERT INTO clientes (tipo, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf)
VALUES (1, 'Andre', '2001-12-06', 'M', 'andre@email.com', '47999994365', 'Imperador', 'Itaum', 123, '126');

-- Pessoa Fisica:

-- Inserção
INSERT INTO clientes (tipo, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf)
VALUES (1, 'Andre', '2001-12-06', 'M', 'andre@email.com', '47999994365', 'Imperador', 'Itaum', 123, '126');

-- Listar
SELECT codCliente, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf FROM clientes
WHERE tipo=1;

-- JOIN
-- Saber o nome, cep do produto das pessoas fisica que compraram  determinado produto em um dos quatro trimestre
-- de um determinado ano
SELECT DISTINCT c.nome, c.cep
FROM clientes c JOIN venda v ON c.codcliente=v.codcliente
WHERE tipo=1 AND 
DATE_PART('MONTH', v.data) >= 10 AND DATE_PART('MONTH', v.data) <= 12
AND DATE_PART('YEAR', v.data) = 2023;

-- Subconsulta
-- Consulta SQL que conta quantos clientes já compraram todos os produtos da loja 
SELECT COUNT(*) FROM clientes c WHERE 
NOT EXISTS (SELECT * FROM produtos p WHERE
		   NOT EXISTS (SELECT * FROM venda v WHERE 
					  	c.codcliente=v.codcliente AND p.codproduto=v.codproduto))
AND c.tipo=1;


-- Pessoa Jurídica:

-- Inserção
INSERT INTO clientes (tipo, nome, email, telefone, rua, bairro, cep, cnpj)
VALUES (2, 'RoboCore', 'robocore@email.com', '1135227626', 'Imperador', 'Floresta', 321, '621');

-- Listar 
SELECT codCliente, nome, email, telefone, rua, bairro, cep, cnpj FROM clientes
WHERE tipo=2;

-- JOIN
-- Faça uma consulta que liste os principais clientes da loja,ou seja, as pessoas juridicas que mais compraram produtos. 
-- A consulta deve mostrar o nome da empresa, cnpj, cep, também deve mostrar quantidade de produtos 
-- já comprados e o dinheiro que essas empresas gastaram na loja

SELECT c.nome, c.cnpj, c.cep, COUNT(*) as qtdProdutosVendidos, SUM(v.quantidade * p.precounitvenda) as valor
FROM clientes c JOIN venda v ON c.codcliente=v.codcliente
JOIN produtos p ON p.codproduto=v.codproduto
WHERE c.tipo = 2
GROUP BY c.cnpj, c.nome, c.cep
ORDER BY valor DESC, qtdProdutosVendidos;

-- Subconsulta
-- Faça uma consulta que liste os clientes que tenha diminuido o número de produtos comprados de um trimestre para outro em um
-- determinado ano. Por exemplo, digamos que uma empresa tenha comprado 50 itens em no primeiro trimestre, já no
-- segundo semestre apenas comprou 35. Caso isso ocorra mostre o nome, cnpj, telefone, o número de produtos comprados nos
-- dois semestres. Não mostre a pessoa jurídica caso a compra com menor número tenha um valor superior a de maior número

SELECT nome, cnpj, telefone FROM clientes c
WHERE tipo=2
AND (SELECT SUM(quantidade) FROM venda 
	  WHERE c.codcliente=codcliente AND DATE_PART('MONTH', data)>=4 AND DATE_PART('MONTH', data)<=6 AND DATE_PART('YEAR', data) = 2023)
	  > 
	 (SELECT SUM(quantidade) FROM venda 
	  WHERE c.codcliente=codcliente AND DATE_PART('MONTH', data)>=7 AND DATE_PART('MONTH', data)<=9 AND DATE_PART('YEAR', data) = 2023);



-- Produto:
INSERT INTO produtos (precounitvenda, precounitcompra, descricao, quantidade, datasheet)
VALUES (0.05, 0.02, 'Resistor de filme de carbono de 1K (1000Ω), de 1/4W e tolerância de +/-5%.',
	   1000, NULL);
	   
-- Listar
SELECT * FROM produtos;

-- JOIN
-- Faça uma pesquisa SQL que mostre os 10 produtos mais lucrativos no trimestre, ou seja os produtos que tem a maior taxa de lucro
-- (precoUnitVenda - precoUnitCompra) e que foram mais vendidos (quantidade * (precoUnitVenda - precoUnitCompra)). Mostre o
-- codigo do Produto, lucro 
SELECT p.codproduto, (SUM(v.quantidade) * (p.precounitvenda - p.precounitcompra)) as lucro
FROM produtos p JOIN venda v ON p.codproduto=v.codproduto
WHERE DATE_PART('MONTH', v.data) >= 10 AND DATE_PART('MONTH', v.data) <= 12
AND DATE_PART('YEAR', v.data) = 2023
GROUP BY p.codproduto
ORDER BY lucro
LIMIT 10;

-- Subconsulta
-- Os produtos mais baratos
SELECT codProduto, descricao FROM produtos WHERE
precounitvenda >= ALL (SELECT precounitvenda FROM produtos);

-- Kits:
SELECT * FROM kits


-- Fornecedor:
-- Insert
INSERT INTO fornecedor (nome, cnpj, email)
VALUES ('Forne1', '1234567', 'forne1@email.com' );

-- Listar
SELECT * FROM fornecedor

-- JOIN


-- Subconsulta


-- Transportadora:

-- Insert
INSERT INTO transportadora (nome, cnpj, email, custokm)
VALUES ('Trans1', '1234567', 'trans1@email.com', 2.3);

-- Listar
SELECT codTransportadora, nome, cnpj, email, custokm FROM transportadora;

-- JOIN
-- 
SELECT t.codtransportadora, t.nome, COUNT(*)
FROM transportadora t JOIN venda v ON t.codtransportadora=v.codtransportadora
GROUP BY t.codtransportadora;

-- Subconsulta
SELECT codtransportadora, nome, custokm
FROM transportadora 
WHERE custokm >= ALL (SELECT custokm FROM transportadora)



-- Venda

-- Precisa de Cliente, Produto e Transportadora

-- Inserção
INSERT INTO venda (codcliente, codproduto, quantidade, formapagamento, codtransportadora, data)
VALUES(3, 1, 1000, 'pix', 2, '2023-12-11');

-- Listar
SELECT codvenda, codcliente, codproduto, quantidade, formapagamento, codtransportadora, data FROM venda;

-- JOIN
-- Mostrar quantos pessoas compraram produtos com determinada forma de pagamento
SELECT formapagamento, COUNT(*) 
FROM clientes c JOIN venda v ON c.codcliente = v.codcliente 
GROUP BY formapagamento;

-- Faça uma consulta SQL que devolva o preço total da compra feita por um cliente, calcule o preço total dos produtos comprados
-- (aplique o desconto caso a compra seja no Pix) mais o preço total do frete (km * custoKm). Mostre o preço do produto,
-- preço do frete e o preço total da compra.
SELECT (p.precounitcompra * v.quantidade) as precoProduto, (10 * t.custokm) as frete,
(p.precounitcompra * v.quantidade) + (10 * t.custokm) as precoTotal, v.formapagamento
FROM produtos p JOIN venda v ON p.codproduto=v.codproduto
JOIN transportadora t ON v.codtransportadora = t.codtransportadora
WHERE v.formapagamento='pix'
UNION
SELECT 0.9 * (p.precounitcompra * v.quantidade) as precoProduto, (10 * t.custokm) as frete, 
0.9*(p.precounitcompra * v.quantidade) + (10 * t.custokm) as precoTotal, v.formapagamento
FROM produtos p JOIN venda v ON p.codproduto=v.codproduto
JOIN transportadora t ON v.codtransportadora = t.codtransportadora
WHERE v.formapagamento!='pix';

-- Subconsulta
-- Faça uma pesquisa SQL que devolva todas as pessoas juridica que fizeram compras na loja
SELECT * FROM venda WHERE 
codcliente IN (SELECT codcliente FROM clientes WHERE tipo=2);


-- Compra:
-- Inserção
INSERT INTO compra (codfornecedor, codproduto, quantidade, codtransportadora, data)
VALUES(1, 1, 1000, 3, '2023-12-25');

-- Listar
SELECT codcompra, codfornecedor, codproduto, quantidade, codtransportadora, data FROM compra;

-- JOIN 
-- Solicitar o nome dos produtos mais comprados, ordene pelo preço
SELECT p.descricao FROM produtos p JOIN compra c ON p.codproduto=c.codproduto
ORDER BY p.precounitcompra

-- Subconsulta
