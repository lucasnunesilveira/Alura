SELECT * FROM tbcliente;
SELECT CPF,NOME FROM tbcliente;
SELECT CPF,NOME FROM tbcliente LIMIT 5;
SELECT CPF AS CPF_CLIENTE , NOME AS NOME_CLIENTE FROM tbcliente;
SELECT NOME,IDADE,SEXO,CPF FROM tbcliente;

-- SEPARA POR FILTRO
SELECT * FROM tbproduto WHERE PRODUTO = '544931';
SELECT * FROM tbcliente WHERE CIDADE = 'Rio de Janeiro';

-- aqui , ele faz um update todos que tem sabor limão para  citrios 
UPDATE tbproduto SET SABOR = 'CÍTRICOS' WHERE SABOR = 'limão';

-- filtro por determinada "regra"
SELECT * FROM tbcliente WHERE IDADE >= 22 && IDADE < 32; -- <>  DIFERENTE
SELECT * FROM tbcliente WHERE NOME > 'Fernando Cavalcante';
SELECT * FROM tbproduto WHERE PRECO_LISTA BETWEEN 15.007 AND 16.009;

-- select por datas 
SELECT * FROM tbcliente WHERE DATA_NASCIMENTO > '1995-01-13';
SELECT * FROM tbcliente WHERE year(DATA_NASCIMENTO) = 1995;
SELECT * FROM tbcliente WHERE MONTH(DATA_NASCIMENTO) = 9;

-- filtro composto de produtos 
SELECT * FROM tbproduto WHERE PRECO_LISTA >= 16.007 AND PRECO_LISTA <= 16.009;
SELECT * FROM tbcliente WHERE IDADE>=18 AND IDADE <= 22 AND SEXO = 'M';
SELECT * FROM tbcliente WHERE (IDADE >= 18 AND IDADE <=22 AND SEXO = 'M' )
						   OR (CIDADE = 'Rio de Janeiro' OR BAIRRO = 'jardins');
SELECT 