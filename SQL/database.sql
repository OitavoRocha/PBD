CREATE TABLE musicfind.Usuario (
    idUsuario SERIAL PRIMARY KEY,
    contato VARCHAR(11),
    rating FLOAT CHECK (rating <= 5.0 AND rating >= 0.0),
    username VARCHAR(30),
    userpassword VARCHAR(30),
    tipo VARCHAR(30) CHECK (tipo = 'Musico' OR tipo = 'Usuario')
);

CREATE TABLE musicfind.Musico (
    genero VARCHAR(30),
    instrumento VARCHAR(30),
    anos_experiencia INT,
    cache FLOAT,
    idUsuario INT PRIMARY KEY references musicfind.Usuario(idUsuario)
);

CREATE TABLE musicfind.Evento (
    nome VARCHAR(30),
    capacidade INT,
    foco VARCHAR(30),
    status_evento VARCHAR(30),
    idEvento SERIAL PRIMARY KEY,
    data DATE,
    endereço VARCHAR(30),
    idUsuario INT references musicfind.Usuario(idUsuario)
);

CREATE TABLE musicfind.ParticipaMusico (
    idEvento INT references musicfind.Evento(idEvento),
    idUsuario INT references musicfind.Usuario(idUsuario),
    PRIMARY KEY (idEvento, idUsuario)
);

CREATE TABLE musicfind.Banda (
    idBanda SERIAL PRIMARY KEY,
    statusBanda VARCHAR(10),
    genero VARCHAR(10),
    cache FLOAT,
    rating FLOAT CHECK (rating >= 0 AND rating <= 5),
    nome VARCHAR(50)
);

CREATE TABLE musicfind.ParticipaBanda (
    idEvento INT references musicfind.Evento(idEvento),
    idBanda INT references musicfind.Banda(idBanda),
    PRIMARY KEY (idEvento, idBanda)
);

CREATE TABLE musicfind.RepertorioMusico (
    idUsuario INT references musicfind.Musico(idUsuario),
    musica VARCHAR(50),
    PRIMARY KEY (idUsuario, musica)
);

CREATE TABLE musicfind.RepertorioBanda (
    idBanda INT references musicfind.Banda(idBanda),
    musica VARCHAR(50),
    PRIMARY KEY (idBanda, musica)
);

CREATE TABLE musicfind.Afiliado (
    idUsuario INT NOT NULL,
    idBanda INT NOT NULL,
    PRIMARY KEY (idUsuario, idBanda),
    FOREIGN KEY (idUsuario) REFERENCES musicfind.Usuario(idUsuario),
    FOREIGN KEY (idBanda) REFERENCES musicfind.Banda(idBanda)
);