# MusicFind
Salvo aqui se encontra a implementação de um Banco de Dados para um aplicativo de contratação de serviços, onde músicos e bandas podem ser contratados para participar de eventos.

### Especificações
Usamos o PostgreSQL para a implementação do banco de dados, juntamente com Java Swing para desenvolver a interface. 
Utilizamos do JDBC para fazer a conexão entre as duas coisas.

### Como Executar
Primeiro, clone o repositório. Após isso é necessário colocar a biblioteca de referência para fazer a conexão com o PostgreSQL. É possível fazer isso adicionando o arquivo dentro da pasta "PostgreSQL" como referência do projeto.

Após, é necessário ter certeza que o nome do BD do postgres que criar será igual ao da instrução dentro do método "ConnectDatabase()" na classe database.java.

Os nomes usados são TrabalhoFinal para o BD, musicfind para o schema, localhost, usuario postgres e senha 1234


