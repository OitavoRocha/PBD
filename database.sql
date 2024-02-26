CREATE TABLE musicfind.Usuario (
    idUsuario INT PRIMARY KEY,
    contato VARCHAR(11),
    rating FLOAT CHECK (rating <= 5.0 AND rating >= 0.0),
    nome VARCHAR(30)
);

CREATE TABLE musicfind.Musico (
    genero VARCHAR(30),
    instrumento VARCHAR(30),
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
    nome VARCHAR(30),
    capacidade INT,
    data DATE,
    status_evento VARCHAR(30),
    foco VARCHAR(30)
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
    alvara VARCHAR(30),
    lotacao_max INT,
    endereco VARCHAR(30) PRIMARY KEY
);

CREATE TABLE musicfind.HistoricoMusico (
    nomeEvento VARCHAR(30),                                         -- idEvento não seria melhor?
    idMusico INT references musicfind.Musico(idUsuario),
    avaliacao FLOAT CHECK (avaliacao >= 0 AND avaliacao <= 5),
    PRIMARY KEY (idMusico)                                          -- histórico musico não pode ter idmusico como chave primária
);                                                                  -- pois um músico pode ter participado de vários eventos

CREATE TABLE musicfind.Repertorio (
    musica VARCHAR(30),
    idMusico INT references musicfind.Musico(idUsuario),            -- idmusico como chave primária não faz sentido
    PRIMARY KEY (idMusico)                                          -- pois um músico pode ter várias músicas no repertório
);

CREATE TABLE musicfind.GrandePorte (
    idEvento INT references musicfind.Evento(idEvento),
    PRIMARY KEY (idEvento)
);

CREATE TABLE musicfind.Em (
    enderecoLocal varchar(30) references musicfind.LocalEvento(endereco),
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
