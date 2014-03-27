DROP DATABASE IF EXISTS jove_timesheet; 
CREATE DATABASE jove_timesheet;
USE jove_timesheet;

CREATE TABLE atividade (
 id_atividade INT(11) NOT NULL PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 descricao VARCHAR(200) NOT NULL,
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 usuario_modificador INT(11) NOT NULL
);


CREATE TABLE empresa (
 id_empresa INT(11) NOT NULL PRIMARY KEY,
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
 telefone VARCHAR(15),
 email VARCHAR(100) NOT NULL,
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 usuario_modificador INT(11) NOT NULL
);


CREATE TABLE projeto (
 id_projeto INT(11) NOT NULL PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 descricao VARCHAR(200) NOT NULL,
 data_inicio  DATE NOT NULL,
 data_fim DATE,
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 usuario_modificador INT(11) NOT NULL
);


CREATE TABLE rel_projeto_atividade (
 id_projeto INT(11) NOT NULL,
 id_atividade INT(11) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 usuario_modificador INT(11) NOT NULL,

 PRIMARY KEY (id_projeto,id_atividade),

 FOREIGN KEY (id_projeto) REFERENCES projeto (id_projeto),
 FOREIGN KEY (id_atividade) REFERENCES atividade (id_atividade)
);


CREATE TABLE tarefa (
 id_tarefa INT(11) NOT NULL PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 descricao VARCHAR(200) NOT NULL,
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 usuario_modificador INT(11) NOT NULL
);


CREATE TABLE departamento (
 id_departamento INT(11) NOT NULL PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 descricao VARCHAR(150) NOT NULL,
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 id_empresa INT(11),
 usuario_modificador INT(11) NOT NULL,

 FOREIGN KEY (id_empresa) REFERENCES empresa (id_empresa)
);


CREATE TABLE funcionario (
 id_funcionario INT(11) NOT NULL PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 genero VARCHAR(1) NOT NULL,
 data_nascimento DATE NOT NULL,
 cpf VARCHAR(14) NOT NULL,
 logradouro VARCHAR(120) NOT NULL,
 numero VARCHAR(10) NOT NULL,
 bairro VARCHAR(50),
 complemento VARCHAR(50),
 cidade VARCHAR(50) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 cep VARCHAR(9) NOT NULL,
 telefone_fixo VARCHAR(15),
 celular VARCHAR(15),
 email VARCHAR(100) NOT NULL,
 tipo_contrato VARCHAR(75) NOT NULL,
 carga_horaria DATETIME NOT NULL,
 tempo_refeicao DATETIME,
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 id_departamento INT(11),
 id_superior INT(11),
 usuario_modificador INT(11) NOT NULL,

 FOREIGN KEY (id_departamento) REFERENCES departamento (id_departamento),
 FOREIGN KEY (id_superior) REFERENCES funcionario (id_funcionario),

 CONSTRAINT EMAIL UNIQUE(email)
);


CREATE TABLE registro (
 id_registro INT(11) NOT NULL PRIMARY KEY,
 data_registro DATE NOT NULL,
 hora_inicio DATETIME NOT NULL,
 hora_fim DATETIME,
 observacao VARCHAR(300) NOT NULL,
 data_acatamento DATE,
 aprovado INT(11),
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 id_funcionario INT(11),
 id_projeto INT(11),
 id_atividade INT(11),
 id_tarefa INT(11),
 usuario_modificador INT(11) NOT NULL,

 FOREIGN KEY (id_funcionario) REFERENCES funcionario (id_funcionario),
 FOREIGN KEY (id_projeto) REFERENCES projeto (id_projeto),
 FOREIGN KEY (id_atividade) REFERENCES atividade (id_atividade),
 FOREIGN KEY (id_tarefa) REFERENCES tarefa (id_tarefa)
);


CREATE TABLE rel_atividade_tarefa (
 id_atividade INT(11) NOT NULL,
 id_tarefa INT(11) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 usuario_modificador INT(11) NOT NULL,

 PRIMARY KEY (id_atividade,id_tarefa),

 FOREIGN KEY (id_atividade) REFERENCES atividade (id_atividade),
 FOREIGN KEY (id_tarefa) REFERENCES tarefa (id_tarefa)
);


CREATE TABLE rel_projeto_funcionario (
 id_funcionario INT(11) NOT NULL,
 id_projeto INT(11) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 usuario_modificador INT(11) NOT NULL,

 PRIMARY KEY (id_funcionario,id_projeto),

 FOREIGN KEY (id_funcionario) REFERENCES funcionario (id_funcionario),
 FOREIGN KEY (id_projeto) REFERENCES projeto (id_projeto)
);


CREATE TABLE usuario (
 id_usuario INT(11) NOT NULL PRIMARY KEY,
 login VARCHAR(30) NOT NULL,
 senha VARCHAR(50) NOT NULL,
 nivel INT(11) NOT NULL,
 ativo BIT(1) NOT NULL,
 data_cadastro DATETIME NOT NULL,
 data_manutencao DATETIME NOT NULL,
 id_funcionario INT(11),
 usuario_modificador INT(11) NOT NULL,

 FOREIGN KEY (id_funcionario) REFERENCES funcionario (id_funcionario),

 CONSTRAINT LOGIN UNIQUE(login)
);

