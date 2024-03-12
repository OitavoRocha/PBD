--  consultas nas tabelas criadas e demais operações - -> mínimo de 6 consultas no banco,
--  sendo no mínimo 4 delas contendo junções entre tabelas.

--  SELECT pra pegar o repertório de uma banda pelo nome
    select musica from 
    musicfind.RepertorioBanda natural join musicfind.banda
    where nome = 'Banda X';

-- SELECT pra pegar o repertório de um músico pelo nome
    select musica from 
    musicfind.RepertorioMusico join musicfind.musico on idmusico = idusuario
	natural join musicfind.usuario
    where username = 'joao';

-- SELECT pra pegar os eventos que um músico vai participar
    select nome from 
    musicfind.evento natural join musicfind.participamusico
    natural join musicfind.usuario
    where username = 'julia';

-- SELECT pra pegar os nomes de musicos que estão em uma banda
    select username from
	musicfind.afiliado join musicfind.usuario on idmusico = idusuario
	where idbanda = 3

-- SELECT para pegar o username e password de um usuario
    select username, userpassword from musicfind.usuario
    where username = 'joao';

-- SELECT para pegar o rating de um musico
    select rating from musicfind.usuario where username = 'joao';

