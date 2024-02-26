INSERT INTO Usuario VALUES(1, '123456789', 5.0, 'Joao');

INSERT INTO Usuario VALUES(2, '00000000', 3.0, 'Otavio');

INSERT INTO Usuario VALUES(3, '987654321', 4.2, 'Miguel');

SELECT * FROM eventmanager

INSERT INTO Musico VALUES('Rock', 'Guitarra', 5, 100.0, 1);

INSERT INTO Musico VALUES('Rock', 'Viola', 5, 100.0, 1);

INSERT INTO eventmanager VALUEs(10, 3)




-- Inserções na tabela Usuario
INSERT INTO musicfind.Usuario (idUsuario, contato, rating, nome) VALUES
(1, '11111111111', 4.5, 'João'),
(2, '22222222222', 3.8, 'Maria'),
(3, '33333333333', 4.0, 'Pedro'),
(4, '44444444444', 4.2, 'Ana'),
(5, '55555555555', 4.7, 'Luiza');


-- Inserções na tabela Musico
INSERT INTO musicfind.Musico (genero, instrumento, anos_experiencia, cache, idUsuario) VALUES
('Pop', 'Violão', 3, 800.00, 2),
('Blues', 'Harmonica', 4, 900.00, 4),
('Funk', 'Baixo', 6, 1200.00, 5);

-- Inserções na tabela EventManager
INSERT INTO musicfind.EventManager (anos_experiencia, idUsuario) VALUES
(2, 3);

-- Inserções na tabela Evento
INSERT INTO musicfind.Evento (idEvento, nome, capacidade, data, status_evento, foco) VALUES
(1, 'Show de Rock', 500, '2024-03-15', 'Confirmado', 'Rock'),
(2, 'Festival de Jazz', 1000, '2024-04-20', 'Confirmado', 'Jazz'),
(3, 'Festa Pop', 300, '2024-05-10', 'Pendente', 'Pop'),
(4, 'Encontro de Blues', 200, '2024-06-25', 'Confirmado', 'Blues'),
(5, 'Baile Funk', 800, '2024-07-15', 'Confirmado', 'Funk');

-- Inserções na tabela ParticipaMusico
INSERT INTO musicfind.ParticipaMusico (idEvento, idUsuario) VALUES
(2, 2),
(2, 4),
(4, 4),
(5, 5);

-- Inserções na tabela HistoricoMusico
INSERT INTO musicfind.HistoricoMusico (nomeEvento, idMusico, avaliacao) VALUES
('Festival de Jazz', 2, 4.2),
('Festival de Jazz', 4, 4.0),
('Baile Funk', 5, 4.8);

-- Inserções na tabela Banda
INSERT INTO musicfind.Banda (idBanda, statusBanda, genero, nome, cache, rating) VALUES
(1, 'Ativa', 'Rock', 'The Rockers', 2000.00, 4.5),
(2, 'Ativa', 'Pop', 'Pop Star', 1800.00, 4.0),
(3, 'Ativa', 'Jazz', 'Jazz Fusion', 2200.00, 4.2),
(4, 'Inativa', 'Blues', 'Blues Express', 1900.00, 3.8),
(5, 'Ativa', 'Funk', 'Funk Machine', 2100.00, 4.6);	

-- Inserções na tabela ParticipaBanda
INSERT INTO musicfind.ParticipaBanda (idEvento, idBanda) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Inserções na tabela LocalEvento
INSERT INTO musicfind.LocalEvento (alvara, lotacao_max, endereco) VALUES
('123ABC', 1000, 'Rua Principal, 123'),
('456DEF', 500, 'Avenida Central, 456'),
('789GHI', 2000, 'Praça do Centro, 789'),
('101JKL', 800, 'Rua dos Artistas, 101'),
('112MNO', 1500, 'Avenida da Praia, 112');

-- Inserções na tabela Repertorio
INSERT INTO musicfind.Repertorio (musica, idMusico) VALUES
('Billie Jean', 2),
('The Thrill is Gone', 4),
('Get Lucky', 5);

-- Inserções na tabela GrandePorte
INSERT INTO musicfind.GrandePorte (idEvento) VALUES
(1);

-- Inserções na tabela Em
INSERT INTO musicfind.Em (enderecoLocal, idGrandePorte) VALUES
('Rua Principal, 123', 1);

-- Inserções na tabela HistoricoBanda
INSERT INTO musicfind.HistoricoBanda (nomeEvento, idBanda, avaliacao) VALUES
('Show de Rock', 1, 4.5),
('Festival de Jazz', 2, 4.0),
('Festa Pop', 3, 4.3),
('Encontro de Blues', 4, 3.8),
('Baile Funk', 5, 4.7);

-- Inserções na tabela RepertorioBanda
INSERT INTO musicfind.RepertorioBanda (musica, idBanda) VALUES
('Bohemian Rhapsody', 1),
('Like a Prayer', 2),
('Summertime', 3),
('Sweet Home Chicago', 4),
('Uptown Funk', 5);

-- Inserções na tabela Afiliado
INSERT INTO musicfind.Afiliado (idMusico, idBanda) VALUES
(2, 2),
(4, 4),
(5, 5);

-- Inserções na tabela PequenoPorte
INSERT INTO musicfind.PequenoPorte (endereco, idEvento) VALUES
('Avenida Central, 456', 2),
('Praça do Centro, 789', 3),
('Rua dos Artistas, 101', 4),
('Avenida da Praia, 112', 5);

-- Inserções na tabela Cria
INSERT INTO musicfind.Cria (idEventManager, idGrandePorte) VALUES
(3, 1);
