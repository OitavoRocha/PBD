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

-- Remover um musico de uma banda
    delete from musicfind.afiliado
    where idmusico = 1 and idbanda = 1;

-- Adicionar um musico a uma banda
    insert into musicfind.afiliado values (1, 1);

-- Adicionar uma musica ao repertório de uma banda
    insert into musicfind.repertoriobanda values (1, 'Sweet Home Alabama');

-- Alterar o rating de um musico
    update musicfind.usuario set rating = 4.8
    where username = 'joao';

-- Selecionar todos os usuarios com rating maior que 4.5
    select * from musicfind.usuario
    where rating > 4.5;

-- Selecionar todos os eventos que vão acontecer
    select * from musicfind.evento
    where data > current_date;

-- Alterar o cache de uma banda para receber um aumento de 50%
    update musicfind.banda set cache = cache * 1.5
    where nome = 'Banda X';

