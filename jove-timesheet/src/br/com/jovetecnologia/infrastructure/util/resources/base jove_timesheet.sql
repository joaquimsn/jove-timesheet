DROP DATABASE IF EXISTS jove_timesheet; 
CREATE DATABASE jove_timesheet;
USE jove_timesheet;

CREATE TABLE empresa(
	id_empresa INT NOT NULL AUTO_INCREMENT,
	razao_social VARCHAR(200) NOT NULL,
	fantasia VARCHAR(100) NOT NULL,
	cnpj VARCHAR(18) NOT NULL,
	logradouro VARCHAR(120) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	bairro VARCHAR(50) NOT NULL,
	complemento VARCHAR(50) NOT NULL,
	cidade VARCHAR(50) NOT NULL,
	uf VARCHAR(2) NOT NULL,
	cep VARCHAR(9) NOT NULL,
	telefone VARCHAR(15) NULL,
	email VARCHAR(100) NOT NULL,
	PRIMARY KEY (id_empresa)
);

CREATE TABLE departamento(
	id_departamento INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(150) NOT NULL,
	ativo BOOLEAN NULL,
	id_empresa int NOT NULL,
	PRIMARY KEY (id_departamento),
	CONSTRAINT fk_empresa_id_empresa
		FOREIGN KEY (id_empresa)
		REFERENCES empresa (id_empresa)
);

CREATE TABLE funcionario(
	id_funcionario INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	genero CHAR NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	logradouro VARCHAR(120) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	bairro VARCHAR(50) NOT NULL,
	complemento VARCHAR(50) NOT NULL,
	cidade VARCHAR(50) NOT NULL,
	uf VARCHAR(2) NOT NULL,
	cep VARCHAR(9) NOT NULL,
	telefone_fixo VARCHAR(15) NULL,
	celular VARCHAR(15) NULL,
	email VARCHAR(100) NOT NULL,
	fk_id_funcionario INT NULL,
	id_departamento INT NOT NULL,
	tipo_contrato VARCHAR(75) NOT NULL,
	carga_horaria TIME NOT NULL,
	tempo_refeicao TIME NULL,
	ativo BOOLEAN NULL,
	PRIMARY KEY (id_funcionario),
	UNIQUE KEY (email),
	CONSTRAINT fk_funcionario_fk_id_funcionario
		FOREIGN KEY (fk_id_funcionario)
		REFERENCES funcionario (id_funcionario),
	CONSTRAINT fk_departamento_id_departamento
		FOREIGN KEY (id_departamento)
		REFERENCES departamento (id_departamento)
);

CREATE TABLE usuario(
	id_funcionario INT NOT NULL,
	usuario VARCHAR(30) NOT NULL,
	senha VARCHAR(30)NOT NULL,
	nivel INT NOT NULL,
	ativo BOOLEAN NULL,
	PRIMARY KEY (id_funcionario),
	UNIQUE KEY (usuario),
	CONSTRAINT fk_funcionario_id_funcionario
		FOREIGN KEY (id_funcionario)
		REFERENCES funcionario (id_funcionario) 
);

CREATE TABLE projeto(
	id_projeto INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	ativo BOOLEAN NULL,
	PRIMARY KEY (id_projeto)
);

CREATE TABLE atividade(
	id_atividade INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	ativo BOOLEAN NULL,
	PRIMARY KEY (id_atividade)
);

CREATE TABLE tarefa(
	id_tarefa INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	ativo BOOLEAN NULL,
	PRIMARY KEY (id_tarefa)
);

CREATE TABLE registro(
	id_registro INT NOT NULL AUTO_INCREMENT,
	data_registro DATE NOT NULL,
	inicio TIME NOT NULL,
	fim TIME NULL,
	observacao VARCHAR(300) NOT NULL,
	data_acatamento DATE NULL,
	aprovado INT NULL,
	id_funcionario INT NOT NULL,
	id_projeto INT NOT NULL,
	id_atividade INT NOT NULL,
	id_tarefa INT NOT NULL,
	PRIMARY KEY (id_registro),
	CONSTRAINT fk_func_id_funcionario
		FOREIGN KEY (id_funcionario)
		REFERENCES funcionario (id_funcionario),
	CONSTRAINT fk_projeto_id_projeto
		FOREIGN KEY (id_projeto)
		REFERENCES projeto (id_projeto),
	CONSTRAINT fk_atividade_id_atividade
		FOREIGN KEY (id_atividade)
		REFERENCES atividade (id_atividade),
	CONSTRAINT fk_tarefa_id_tarefa
		FOREIGN KEY (id_tarefa)
		REFERENCES tarefa (id_tarefa)
);

-- ********** Dados para teste **********

INSERT INTO empresa(razao_social, fantasia, cnpj, logradouro, numero, bairro, complemento, cidade, uf, cep, telefone, email) 
	values('Empresa exemplo', 'exemplo', '00000000000000', 'av. exemplo', '00', 'ex', 'ex', 'São Paulo', 'SP', '0000000', 
			'(00) 0000-0000', 'exemplo@exemplo.com');

INSERT INTO departamento(nome, descricao, ativo, id_empresa) 
	values('TI', 'Desenvolvimento e Treinamento', 1, 1);

INSERT INTO funcionario(nome, genero, data_nascimento, cpf, logradouro, numero, bairro, complemento, cidade, uf, cep, 
	telefone_fixo, celular, email, fk_id_funcionario, id_departamento, tipo_contrato, carga_horaria, tempo_refeicao, ativo)
	VALUES
	('administrador', 'm', '1990-02-20', '000.000.000-00', 'av. exemplo', '00', 'ex', 'ex', 'São Paulo', 'SP', '0000000', 
	'(00) 0000-0000', '(00) 0000-0000', 'admin@admin.com', null, 1, 'efetivo', '08:00:00', '01:00:00', 1),
	('funcionario', 'm', '1990-02-20', '000.000.000-00', 'av. exemplo', '00', 'ex', 'ex', 'São Paulo', 'SP', '0000000', 
	'(00) 0000-0000', '(00) 0000-0000', 'funcionario@user.com', 1, 1, 'efetivo', '08:00:00', '01:00:00', 1);

INSERT INTO usuario(id_funcionario, usuario, senha, nivel, ativo) values
	(1, 'admin', 'admin', 2, 1),
	(2, 'user', 'user', 1, 1);

INSERT INTO atividade(nome, descricao, ativo) values
	('GETLOG - Versão 2', 'Desenvolvimento do novo sitema da jove',  1),
	('GETLOG - Legado', 'Correção em ultima instancia do GETLOG versão 1 ',  1),
	('Ferias', 'Periodo de ferias dos funcionarios',  1),
	('Ladrão de Tempo', 'Registro de atividades inesperadas',  1),
	('Time Sheet', 'Projeto Time Sheet', 1);

INSERT INTO atividade(nome, descricao, ativo) values
	('Refatoração', 'Tempo utilizado para melhoria do código',  1),
	('Codificação', 'Tempo destinado para codificação',  1),
	('Estudo', 'Tempo destinato a estudos de novas tecnlogias ou recurso para implementação no projeto',  1),
	('Criação de Telas', 'Tempo utilizado pra criação de novas interfaces graficas', 1);

INSERT INTO atividade(nome, descricao, ativo) values
	('Codificação', 'Tempo utilizado criar código',  1),
	('Refeição', 'Tempo destinado a refieção obrigatoria',  1),
	('Reunião', 'Tempo destinado em reuniões',  1),
	('Planejamento', 'Tempo destinado para planejar e organizar ideias',  1),
	('Suporte Omaha', 'Tempo destinado soluções de problemas na Omaha', 1);
