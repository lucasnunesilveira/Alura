ALTER TABLE tbCliente ADD PRIMARY KEY (CPF);
ALTER TABLE tbCliente ADD column (DATA_NASCIMENTO DATE);

INSERT INTO tbCliente(CPF,NOME,ENDERECO1,ENDERECO2,BAIRRO,CIDADE,ESTADOS,CEP,IDADE,SEXO,LIMITE_CREDITO,
	VOLUME_COMPRAS,PRIMEIRA_COMPRA,DATA_NASCIMENTO)
    VALUES('91243450433','CHOCOLATE NUNES','RUA FRANCISCO PEREIRA BORBA','','LOT.NAZARE','CAMARAGIBE',
    'PERNAMBUCO','222222-222',14,'M',10000000000,2.400,0,'2008-04-12');

SELECT * FROM tbCliente