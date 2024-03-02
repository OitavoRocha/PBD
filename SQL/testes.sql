-- Inserção de usuários
INSERT INTO musicfind.Usuario (idUsuario, contato, rating, nome, tipo) VALUES
(1, '11111111111', 4.5, 'João Silva', 'Musico'),
(2, '22222222222', 3.8, 'Maria Souza', 'Musico'),
(3, '33333333333', 4.2, 'Pedro Oliveira', 'Usuario');

-- Inserção de músicos
INSERT INTO musicfind.Musico (genero, instrumento, anos_experiencia, cache, idUsuario) VALUES
('Rock', 'Guitarra', 8, 200.00, 1),
('Jazz', 'Saxofone', 10, 300.00, 2);

-- Inserção de eventos
INSERT INTO musicfind.Evento (nome, capacidade, foco, status_evento, idEvento, data, endereço, idUsuario) VALUES
('Festival de Rock', 500, 'Rock', 'Confirmado', 1, '2024-07-15', 'Rua Principal, 123', 3),
('Apresentação de Jazz', 200, 'Jazz', 'Confirmado', 2, '2024-08-20', 'Avenida Central, 456', 3);

-- Inserção de participações de músicos em eventos
INSERT INTO musicfind.ParticipaMusico (idEvento, idUsuario) VALUES
(1, 1),
(2, 1);

-- Inserção de bandas
INSERT INTO musicfind.Banda (idBanda, statusBanda, genero, cache, rating, nome) VALUES
(1, 'Ativa', 'Rock', 500.00, 4.0, 'The Rockers'),
(2, 'Ativa', 'Jazz', 600.00, 4.2, 'Jazzy Cats');

-- Inserção de participações de bandas em eventos
INSERT INTO musicfind.ParticipaBanda (idEvento, idBanda) VALUES
(1, 1),
(2, 2);

-- Inserção de afiliações de músicos em bandas
INSERT INTO musicfind.Afiliado (idMusico, idBanda) VALUES
(1, 1),
(1, 2);

-- Inserção de repertórios de músicos
INSERT INTO musicfind.RepertorioMusico VALUES 
(1, 'Sweet Child O'' Mine'), 
(1, 'November Rain'), 
(2, 'Take Five');

-- Inserção de repertórios de bandas
INSERT INTO musicfind.RepertorioBanda VALUES 
(1, 'Hallway to Hell'), 
(2, 'Blue Rondo à la Turk'),
(2, 'What a Wonderful World');