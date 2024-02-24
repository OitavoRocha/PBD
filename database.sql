CREATE TABLE musicfind.Usuario (
    idUsuario INT PRIMARY KEY,
    contato VARCHAR(11),
    rating FLOAT CHECK (rating <= 5.0 AND rating >= 0.0),
    nome VARCHAR(15)
);

CREATE TABLE musicfind.Musico (
    genero VARCHAR(15),
    instrumento VARCHAR(15),
    anos_experiencia INT,
    cache FLOAT,
    idUsuario INT PRIMARY KEY references musicfind.Usuario(idUsuario)
);

CREATE TABLE musicfind.EventManager (
    anos_experiencia INT,
    idUsuario INT PRIMARY KEY references musicfind.Usuario(idUsuario)
);

CREATE TABLE musicfind.Evento (
    idEvento INT PRIMARY KEY,
    nome VARCHAR(15),
    capacidade INT,
    data DATE,
    status_evento VARCHAR(15),
    foco VARCHAR(15)
);

CREATE TABLE musicfind.ParticipaMusico (
    idEvento INT references musicfind.Evento(idEvento),
    idUsuario INT references musicfind.Usuario(idUsuario),
    PRIMARY KEY (idEvento, idUsuario)
);

CREATE TABLE musicfind.Banda (
    idBanda INT NOT NULL,
    statusBanda VARCHAR(10),
    genero VARCHAR(10),
    nome VARCHAR(50),
    cache FLOAT,
    rating FLOAT CHECK (rating >= 0 AND rating <= 5),
    PRIMARY KEY (idBanda)
);

CREATE TABLE musicfind.ParticipaBanda (
    idEvento INT references musicfind.Evento(idEvento),
    idBanda INT references musicfind.Banda(idBanda),
    PRIMARY KEY (idEvento, idBanda)
);

CREATE TABLE musicfind.LocalEvento (
    alvara VARCHAR(15),
    lotacao_max INT,
    endereco VARCHAR(15) PRIMARY KEY
);

CREATE TABLE musicfind.HistoricoMusico (
    nomeEvento VARCHAR(15),
    idMusico INT references musicfind.Musico(idUsuario),
    avaliacao FLOAT CHECK (avaliacao >= 0 AND avaliacao <= 5),
    PRIMARY KEY (idMusico)
);

CREATE TABLE musicfind.Repertorio (
    musica VARCHAR(15),
    idMusico INT references musicfind.Musico(idUsuario),
    PRIMARY KEY (idMusico)
);

CREATE TABLE musicfind.GrandePorte (
    idEvento INT references musicfind.Evento(idEvento),
    PRIMARY KEY (idEvento)
);

CREATE TABLE musicfind.Em (
    enderecoLocal varchar(15) references musicfind.LocalEvento(endereco),
    idGrandePorte int references musicfind.GrandePorte(idEvento),
    PRIMARY KEY (enderecoLocal, idGrandePorte)
);

CREATE TABLE musicfind.HistoricoBanda (
    nomeEvento VARCHAR(50),
    avaliacao FLOAT CHECK (avaliacao >= 0 AND avaliacao <= 5),
    idBanda INT,
    PRIMARY KEY (idBanda),
    FOREIGN KEY (idBanda) REFERENCES musicfind.Banda(idBanda)
);

CREATE TABLE musicfind.RepertorioBanda (
    musica VARCHAR(50),
    idBanda INT,
    PRIMARY KEY (idBanda),
    FOREIGN KEY (idBanda) REFERENCES musicfind.Banda(idBanda)
);

CREATE TABLE musicfind.Afiliado (
    idMusico INT NOT NULL,
    idBanda INT NOT NULL,
    PRIMARY KEY (idMusico, idBanda),
    FOREIGN KEY (idMusico) REFERENCES musicfind.Usuario(idUsuario),
    FOREIGN KEY (idBanda) REFERENCES musicfind.Banda(idBanda)
);

CREATE TABLE musicfind.PequenoPorte (
    endereco VARCHAR(50),
    idEvento INT,
    PRIMARY KEY (idEvento),
    FOREIGN KEY (idEvento) REFERENCES musicfind.Evento(idEvento)
);

CREATE TABLE musicfind.Cria (
    idEventManager INT,
    idGrandePorte INT,
    PRIMARY KEY (idEventManager, idGrandePorte),
    FOREIGN KEY (idGrandePorte) REFERENCES musicfind.Evento(idEvento),
    FOREIGN KEY (idEventManager) REFERENCES musicfind.Usuario(idUsuario)
);
