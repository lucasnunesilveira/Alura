SELECT LTRIM('          oLA') AS RESULTADO;
SELECT RTRIM('OLAS2       ') AS RESULTADO;
SELECT CONCAT('OLA', ' ' ,' TUDO BEM ', ' ?') AS RESULTADO;
SELECT LOWER('OLA TUDO BEM ?') AS RESULTADO;
SELECT SUBSTRING('OLA TUDO BEM ?', 5, 4) AS RESULTADO;
SELECT CONCAT(NOME,'(',CPF,')')AS RESULTADO FROM tabela_de_clientes;

-- Função que manipula datas --
SELECT CURDATE(); -- PEGA O DIA LOCAL 
SELECT CURRENT_TIME();
SELECT CURRENT_TIMESTAMP();
SELECT YEAR(CURRENT_TIMESTAMP());
SELECT DAY(CURRENT_TIMESTAMP());
SELECT MONTH(CURRENT_TIMESTAMP());
SELECT MONTHNAME(CURRENT_TIMESTAMP());
SELECT DATEDIFF(CURRENT_TIMESTAMP(),'2019-01-01') AS RESULTADO;
SELECT DATE_SUB(CURRENT_TIMESTAMP(),INTERVAL 5 DAY) AS RESULTADO;

SELECT DISTINCT DATA_VENDA,
DAYNAME(DATA_VENDA) AS DIA , MONTHNAME(DATA_VENDA) AS MES,
YEAR (DATA_VENDA) AS ANO FROM notas_fiscais;

SELECT NOME, TIMESTAMPDIFF (YEAR, DATA_DE_NASCIMENTO, CURDATE()) AS    IDADE
FROM  tabela_de_clientes;

-- FUNÇÃO MATEMATICAS 
SELECT (33+(232-4)*40/43) AS RESULTADO;
SELECT CEILING((33+(232-4)*40/43)) AS RESULTADO;
SELECT ROUND((33+(232-4)*40/43)) AS RESULTADO; -- arredonda pro mais proximo 
SELECT FLOOR((33+(232-4)*40/43)) AS RESULTADO;
SELECT RAND()AS RESULTADO;

SELECT NUMERO,QUANTIDADE,PRECO,ROUND(QUANTIDADE*PRECO, 2) AS FATURAMENTO FROM itens_notas_fiscais;
SELECT YEAR(DATA_VENDA), FLOOR(SUM(IMPOSTO * (QUANTIDADE * PRECO))) 
FROM notas_fiscais NF
INNER JOIN itens_notas_fiscais INF ON NF.NUMERO = INF.NUMERO
WHERE YEAR(DATA_VENDA) = 2016
GROUP BY YEAR(DATA_VENDA);

-- CONVESÃO DE DADOS 
SELECT CURRENT_TIMESTAMP() AS RESULTADO;
SELECT CONCAT('O DIA DE HOJE É : ', 
 DATE_FORMAT(CURRENT_TIMESTAMP(),'%W, %d/%m/%Y - %U')) AS RESULTADO;
 
 SELECT SUBSTRING(CONVERT(245.3,CHAR),2,4) AS RESULTADO;
 

