-- Consultas

-- Inserção de dados-- Clientes

-- Cliente.tipo = 1 é pessoa física -> dataNascimento, sexo e CPF != NULL e CNPJ == NULL
-- Cliente.tipo = 2 é pessoa jurídica -> dataNascimento, sexo e CPF == NULL e CNPJ != NULL

-- Cliente:

-- Inserção

INSERT INTO clientes (tipo, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf, cnpj)
VALUES (1, 'Andre', '2001-12-06', 'M', 'andre@email.com', '47999994365', 'Imperador', 'Itaum', 123, '126', NULL);

-- Pessoa Fisica:

-- Inserção
INSERT INTO clientes (tipo, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf)
VALUES (1, 'Andre', '2001-12-06', 'M', 'andre@email.com', '47999994365', 'Imperador', 'Itaum', 123, '126');

-- Listar
SELECT codCliente, nome, datanascimento, sexo, email, telefone, rua, bairro, cep, cpf FROM clientes
WHERE tipo=1;

-- JOIN
-- Saber o nome, cep e quantidade do produto das pessoas fisica que compraram  determinado produto no ultimo em um dos quatro trimestre
-- de um determinado ano
SELECT c.nome, c.cep, v.quantidade, p.descricao
FROM clientes c JOIN venda v ON c.codcliente=v.codcliente
JOIN produtos p ON v.codproduto = p.codproduto
WHERE tipo=1 AND 
DATE_PART('MONTH', v.data) >= 10 AND DATE_PART('MONTH', v.data) <= 12
AND DATE_PART('YEAR', v.data) = 2023;

-- Subconsulta
-- Consulta SQL que mostra os dados do cliente já comprou todos os produtos da loja 
SELECT * FROM clientes c WHERE 
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
ORDER BY qtdProdutosVendidos, valor;

-- Subconsulta
-- Faça uma consulta que liste os clientes que tenha diminuido o número de produtos comprados de um trimestre para outro em um
-- determinado ano. Por exemplo, digamos que uma empresa tenha comprado 50 itens em no primeiro trimestre, já no
-- segundo semestre apenas comprou 35. Caso isso ocorra mostre o nome, cnpj, telefone, o número de produtos comprados nos
-- dois semestres. Não mostre a pessoa jurídica caso a compra com menor número tenha um valor superior a de maior número

SELECT nome, cnpj, telefone FROM clientes c
WHERE tipo=2
AND (SELECT COUNT(*) FROM venda 
	  WHERE c.codcliente=codcliente AND DATE_PART('MONTH', data)>=1 AND DATE_PART('MONTH', data)<=3)
	  > 
	 (SELECT COUNT(*) FROM venda 
	  WHERE c.codcliente=codcliente AND DATE_PART('MONTH', data)>=4 AND DATE_PART('MONTH', data)<=6);



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
-- 


-- Kits:


-- Fornecedor:
INSERT INTO fornecedor (nome, cnpj, email)
VALUES ('Forne1', '1234567', 'forne1@email.com' );


SELECT * FROM fornecedor


-- Transportadora:
INSERT INTO transportadora (nome, cnpj, email, custokm)
VALUES ('Trans1', '1234567', 'trans1@email.com', 2.3);

SELECT codTransportadora, nome, cnpj, email, custokm FROM transportadora;


SELECT * FROM transportadora:

-- Venda

-- Precisa de Cliente, Produto e Transportadora

-- Inserir
INSERT INTO venda (codcliente, codproduto, quantidade, formapagamento, codtransportadora, data)
VALUES(3, 1, 1000, 'pix', 2, '2023-12-11');

-- Listar
SELECT codvenda, codcliente, codproduto, quantidade, formapagamento, codtransportadora, data FROM venda;

-- JOIN
-- Mostrar quantos pessoas compraram produtos com determinada forma de pagamento
SELECT formapagamento, COUNT(*) 
FROM clientes c JOIN venda v ON c.codcliente = v.codcliente 
GROUP BY formapagamento;

-- Compra:
INSERT INTO compra (codfornecedor, codproduto, quantidade, codtransportadora, data)
VALUES(1, 1, 1000, 3, '2023-12-25');

SELECT codcompra, codfornecedor, codproduto, quantidade, codtransportadora, data FROM compra;
