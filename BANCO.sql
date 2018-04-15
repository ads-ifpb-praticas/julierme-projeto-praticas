CREATE TABLE Atendente(
	matricula int PRIMARY KEY,
	nome varchar[200],
	atendimento date,
	hora_chegada time,
	hora_saida time
);

CREATE TABLE Cliente(
	id int PRIMARY KEY,
	nome varchar[200],
	email varchar[200]
);

CREATE TABLE Servico(
	codigo bigint,
	atendente int,
	duracao int,
	categoria varchar[100],
	PRIMARY KEY (codigo),
	FOREIGN KEY (atendente) REFERENCES Atendente(matricula)
);

CREATE TABLE Atendimento(
	codigo bigint,
	cliente int,
	tiposervico bigint,
	data date,
	horario time,
	confirmado boolean,
	PRIMARY KEY (codigo),
	FOREIGN KEY (cliente) REFERENCES Cliente(id)
);

CREATE TABLE Pesquisa(
	id bigint,
	atendimento bigint,
	respondido boolean,
	nota float,
	PRIMARY KEY (id),
	FOREIGN KEY (atendimento) REFERENCES Atendimento(codigo)
);