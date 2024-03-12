-- Inserções na tabela Usuario
INSERT INTO musicfind.Usuario (contato, rating, username, userpassword, tipo) VALUES
('11111111111', 4.5, 'joao', 'senha123', 'Musico'),
('22222222222', 3.8, 'maria', 'senha456', 'Usuario'),
('33333333333', 5.0, 'carlos', 'senha789', 'Musico'),
('44444444444', 4.2, 'ana', 'senha101', 'Usuario'),
('55555555555', 4.9, 'pedro', 'senha202', 'Musico'),
('66666666666', 3.5, 'lucas', 'senha303', 'Usuario'),
('77777777777', 4.0, 'julia', 'senha404', 'Musico'),
('88888888888', 4.7, 'camila', 'senha505', 'Usuario'),
('99999999999', 4.3, 'fernanda', 'senha606', 'Musico'),
('10101010101', 3.9, 'miguel', 'senha707', 'Usuario');

-- Inserções na tabela Musico
INSERT INTO musicfind.Musico (genero, instrumento, anos_experiencia, cache, idUsuario) VALUES
('Rock', 'Guitarra', 8, 200.00, 1),
('Pop', 'Vocal', 5, 150.00, 3),
('Jazz', 'Saxofone', 10, 300.00, 5),
('Blues', 'Guitarra', 7, 180.00, 7),
('Sertanejo', 'Violão', 6, 170.00, 9);

-- Inserções na tabela Evento
INSERT INTO musicfind.Evento (nome, capacidade, foco, status_evento, idEvento, data, endereço, idUsuario) VALUES
('Festival de Rock', 500, 'Rock', 'Confirmado', 1, '2024-07-15', 'Rua A, 123', 1),
('Show de Pop', 300, 'Pop', 'Confirmado', 2, '2024-06-20', 'Avenida B, 456', 3),
('Noite de Jazz', 200, 'Jazz', 'Confirmado', 3, '2024-08-10', 'Travessa C, 789', 5),
('Festa de Blues', 400, 'Blues', 'Confirmado', 4, '2024-09-05', 'Rua D, 321', 7),
('Rodeio', 1000, 'Sertanejo', 'Confirmado', 5, '2024-10-20', 'Avenida E, 654', 9);

-- Inserções na tabela Banda
INSERT INTO musicfind.Banda (statusBanda, genero, cache, rating, nome) VALUES
('Ativa', 'Rock', 250.00, 4.6, 'Banda X'),
('Ativa', 'Pop', 180.00, 4.0, 'Banda Y'),
('Ativa', 'Jazz', 300.00, 4.8, 'Banda Z');

-- Inserções na tabela ParticipaBanda
INSERT INTO musicfind.ParticipaBanda (idEvento, idBanda) VALUES
(1, 1),
(2, 2),
(3, 3),
(5, 3),
(4, 2);

-- Inserções na tabela ParticipaMusico
INSERT INTO musicfind.ParticipaMusico (idEvento, idUsuario) VALUES
(1, 1),
(2, 3),
(3, 5),
(4, 7),
(5, 9);

-- Inserções na tabela RepertorioMusico
INSERT INTO musicfind.RepertorioMusico (idMusico, musica) VALUES
(1, 'Smells Like Teen Spirit'),
(1, 'Sweet Child O Mine'),
(3, 'Feeling Good'),
(3, 'Take Five'),
(5, 'Summertime');

-- Inserções na tabela RepertorioBanda
INSERT INTO musicfind.RepertorioBanda (idBanda, musica) VALUES
(1, 'Bohemian Rhapsody'),
(1, 'Hotel California'),
(2, 'Shape of My Heart'),
(2, 'Firework'),
(3, 'So What');

-- Inserções na tabela Afiliado
INSERT INTO musicfind.Afiliado (idMusico, idBanda) VALUES
(1, 1),
(3, 3),
(5, 1),
(5, 2),
(5, 3);