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

CREATE TABLE jornada_trabalho(
	id_jornada_trabalho INT NOT NULL AUTO_INCREMENT,
	tipo_contrato VARCHAR(75) NOT NULL,
	carga_horaria TIME NOT NULL,
	periodo VARCHAR(50) NOT NULL,
	jornada VARCHAR(50) NOT NULL,
	tempo_refeicao TIME NULL,
	folga VARCHAR(25) NULL,
	ativo BOOLEAN NULL,
	PRIMARY KEY (id_jornada_trabalho)
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
	id_jornada_trabalho INT NOT NULL,
	ativo BOOLEAN NULL,
	PRIMARY KEY (id_funcionario),
	UNIQUE KEY (email),
	CONSTRAINT fk_funcionario_fk_id_funcionario
		FOREIGN KEY (fk_id_funcionario)
		REFERENCES funcionario (id_funcionario),
	CONSTRAINT fk_departamento_id_departamento
		FOREIGN KEY (id_departamento)
		REFERENCES departamento (id_departamento),
	CONSTRAINT fk_jornada_tr_id_jornada_trabalho
		FOREIGN KEY (id_jornada_trabalho)
		REFERENCES jornada_trabalho (id_jornada_trabalho)
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