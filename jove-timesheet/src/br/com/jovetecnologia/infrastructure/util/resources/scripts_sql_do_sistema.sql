/*
    Script utilizado no sistema para manipular os endereços
    Requesitos:
    Base jove_endereco
*/


--Listar todos os UF
SELECT uf FROM tend_uf;

--Lista o endereço compelto com base no CEP informado
SELECT e.endereco, b.bairro, c.cidade, c.uf FROM tend_endereco e 
	INNER JOIN tend_bairro b ON e.cep = 02224010 AND b.id_bairro = e.id_bairro
	INNER JOIN tend_cidade c ON c.id_cidade = e.id_cidade;

--Lista as cidades com base na UF
SELECT c.cidade FROM tend_cidade c WHERE c.uf = 'BA';

--Lista os funcionários que já estão relacionado a um projeto informado
SELECT * FROM funcionario f
	INNER JOIN	 rel_projeto_funcionario rf ON rf.id_funcionario = f.id_funcionario AND rf.id_projeto = 1;

	