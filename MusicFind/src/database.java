package MusicFind.src;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class database {
    
    static Connection con = null;

    public boolean connectDataBase(){

        String url = "jdbc:postgresql://localhost:5432/TrabalhoFinal?currentSchema=musicfind";
        String user = "postgres";
        String password = "1234";


        try {
            con = DriverManager.getConnection(url, user, password);
        }catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados " + e.getMessage());
            return false;
        }
        System.out.println("Conexão realizada com sucesso");
        return true;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean insertUser(User usuario){

        String sql = "INSERT INTO usuario (contato, rating, username, userpassword, tipo) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, usuario.contato);
            statement.setFloat(2, usuario.rating);
            statement.setString(3, usuario.username);
            statement.setString(4, usuario.userpassword);
            statement.setString(5, usuario.tipo);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                if (usuario.tipo.equals("Musico")){
                    insertMusician(usuario);
                } else {
                    System.out.println("Novo usuário inserido com sucesso.");
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertMusician(User usuario){

        String sql = "INSERT INTO musico (genero, instrumento, anos_experiencia, cache, idusuario) VALUES (?, ?, ?, ?, ?)";

        usuario.setId(getUserId(usuario.getUsername()));
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, usuario.getGenero());
            statement.setString(2, usuario.getInstrumento());
            statement.setInt(3, usuario.getAnos_experiencia());
            statement.setFloat(4, usuario.getCache());
            statement.setInt(5, usuario.getId());
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Novo músico inserida com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertEvent(String nome, int capacidade, String foco, String status_evento,String date, String endereço, int id_usuario){

        String sql = "INSERT INTO evento (nome, capacidade, foco, status_evento, data, endereço, idusuario) VALUES (?, ?, ?, ?, ?, ?, ?)";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Converter para java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(data.getTime());

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setInt(2, capacidade);
            statement.setString(3, foco);
            statement.setString(4, status_evento);
            statement.setDate(5, sqlDate);
            statement.setString(6, endereço);
            statement.setInt(7, id_usuario);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Novo evento inserido com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return false;
    }

    public boolean insertRepertoireBanda(int idBanda, String musica){
            
        String sql = "INSERT INTO RepertorioBanda (idBanda, musica) VALUES (?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBanda);
            statement.setString(2, musica);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Nova música inserida no repertório da banda com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertRepertoireMusico(int idUsuario, String musica){
                
        String sql = "INSERT INTO RepertorioMusico (idusuario, musica) VALUES (?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            statement.setString(2, musica);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Nova música inserida no repertório do músico com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean insertBand(String statusBanda, String genero, float cache, float rating, String nome){
            
        String sql = "INSERT INTO banda (statusBanda, genero, cache, rating, nome) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, statusBanda);
            statement.setString(2, genero);
            statement.setFloat(3, cache);
            statement.setFloat(4, rating);
            statement.setString(5, nome);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Nova banda inserida com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertParticipaMusico(int idEvento, int idUsuario){
                
        String sql = "INSERT INTO ParticipaMusico (idEvento, idUsuario) VALUES (?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idEvento);
            statement.setInt(2, idUsuario);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Músico participando do evento com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    
    }

    public boolean insertParticipaBanda(int idEvento, int idBanda){
                
        String sql = "INSERT INTO ParticipaBanda (idEvento, idBanda) VALUES (?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idEvento);
            statement.setInt(2, idBanda);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Banda participando do evento com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertAfiliado(int idUsuario, int idBanda){

        String sql = "INSERT INTO Afiliado (idUsuario, idBanda) VALUES (?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            statement.setInt(2, idBanda);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Músico afiliado à banda com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getBandaId(String nomeBanda){

        String sql = "SELECT idBanda FROM Banda WHERE nome = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nomeBanda);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                System.out.println("Id da banda retornado com sucesso");
                // Retorna o id da banda com o nome passado no resultado da consulta
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getEventoId(String nomeEvento){

        String sql = "SELECT idEvento FROM Evento WHERE nome = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nomeEvento);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                System.out.println("Id do evento retornado com sucesso");
                // Retorna o id do evento com o nome passado no resultado da consulta
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Método para retornar uma lista com os dados de um usuario a partir do idusuario
    public ArrayList<String> getUserDataFromID(int idUsuario){

        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                System.out.println("Dados do usuário retornados com sucesso");
                ArrayList<String> userData = new ArrayList<String>();
                userData.add(rs.getString(1));
                userData.add(rs.getString(2));
                userData.add(rs.getString(3));
                userData.add(rs.getString(4));
                userData.add(rs.getString(5));
                userData.add(rs.getString(6));
                return userData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getUserDataFromUsername(String username){

        String sql = "SELECT * FROM Usuario WHERE username = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                System.out.println("Dados do usuário retornados com sucesso");
                ArrayList<String> userData = new ArrayList<String>();
                userData.add(rs.getString(1));
                userData.add(rs.getString(2));
                userData.add(rs.getString(3));
                userData.add(rs.getString(4));
                userData.add(rs.getString(5));
                userData.add(rs.getString(6));
                return userData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getBandaData(int idBanda){

        String sql = "SELECT * FROM Banda WHERE idBanda = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBanda);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()) {
                System.out.println("Dados da banda retornados com sucesso");
                ArrayList<String> bandaData = new ArrayList<String>();
                bandaData.add(rs.getString(2));
                bandaData.add(rs.getString(3));
                bandaData.add(rs.getString(4));
                bandaData.add(rs.getString(5));
                bandaData.add(rs.getString(6));
                return bandaData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getMusicoData(int idUsuario){

        String sql = "SELECT * FROM Musico WHERE idUsuario = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                System.out.println("Dados do músico retornados com sucesso");
                ArrayList<String> musicoData = new ArrayList<String>();
                musicoData.add(rs.getString(1));
                musicoData.add(rs.getString(2));
                musicoData.add(rs.getString(3));
                musicoData.add(rs.getString(4));
                musicoData.add(rs.getString(5));
                return musicoData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getEventoData(int idEvento){

        String sql = "SELECT * FROM Evento WHERE idEvento = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idEvento);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                System.out.println("Dados do evento retornados com sucesso");
                ArrayList<String> eventoData = new ArrayList<String>();
                eventoData.add(rs.getString(1));
                eventoData.add(rs.getString(2));
                eventoData.add(rs.getString(3));
                eventoData.add(rs.getString(4));
                eventoData.add(rs.getString(5));
                eventoData.add(rs.getString(6));
                eventoData.add(rs.getString(7));
                eventoData.add(rs.getString(8));
                return eventoData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getUserUsernamePassword(String username){
            
        String sql = "SELECT username, userpassword FROM Usuario WHERE username = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()) {
                System.out.println("Dados do usuário retornados com sucesso");
                ArrayList<String> userData = new ArrayList<String>();
                userData.add(rs.getString(1));
                userData.add(rs.getString(2));
                return userData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getNomeFromBandaOnEvent(int idEvento){
            
        String sql = "select nome from participaBanda natural join banda where idevento = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idEvento);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                // Enquanto houverem resultados, adiciona o nome da banda à lista
                ArrayList<String> bandas = new ArrayList<String>();
                while (rs.next()){
                    bandas.add(rs.getString(1));
                }
                System.out.println("Nome das bandas retornado com sucesso");
                System.out.println(bandas);
                return bandas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getNomeFromMusicoOnEvent(int idEvento){
            
        String sql = "select username from participaMusico natural join usuario where idevento = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idEvento);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                // Enquanto houverem resultados, adiciona o nome do músico à lista
                ArrayList<String> musicos = new ArrayList<String>();
                while (rs.next()){
                    musicos.add(rs.getString(1));
                }
                System.out.println("Nome dos músicos retornado com sucesso");
                return musicos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getNomeFromMusicoOnBanda(int idBanda){
            
        String sql = "select username from afiliado join usuario on idusuario = idusuario where idbanda = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBanda);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                // Enquanto houverem resultados, adiciona o nome do músico à lista
                ArrayList<String> musicos = new ArrayList<String>();
                while (statement.getResultSet().next()){
                    musicos.add(rs.getString(1));
                }
                System.out.println("Nome dos músicos retornado com sucesso");
                return musicos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getRepertoireMusico (int idUsuario) {
        String sql = "SELECT musica FROM RepertorioMusico WHERE idusuario = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            // Enquanto houverem resultados, adiciona o nome do músico à lista 
            ArrayList<String> repertoire = new ArrayList<String>();
            while (rs.next()){
                repertoire.add(rs.getString(1));
            }
            System.out.println("Repertório do músico retornado com sucesso");
            return repertoire;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static int getUserId(String search) {
        String sql = "SELECT idusuario FROM usuario WHERE username = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, search);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            if (rs.next()   ) {
                System.out.println("Id do usuário retornado com sucesso");
                // Retorna o id do usuário com o nome passado no resultado da consulta
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<String>  getEventsFromUser(int id) {
        String sql = "SELECT * FROM evento WHERE idusuario = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            // Enquanto houverem resultados, adiciona o nome do músico à lista 
            ArrayList<String> events = new ArrayList<String>();
            while (rs.next()){
                events.add(rs.getString(1));
            }
            System.out.println("Eventos do usuário retornado com sucesso");
            return events;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getEventosFromBanda(int idBanda) {
        String sql = "SELECT nome FROM evento NATURAL JOIN participabanda WHERE idbanda = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBanda);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            // Enquanto houverem resultados, adiciona o nome do músico à lista 
            ArrayList<String> eventos = new ArrayList<String>();
            while (rs.next()){
                eventos.add(rs.getString(1));
            }
            System.out.println("Eventos da banda retornado com sucesso");
            return eventos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> getAfiliadoBanda(int idBanda) {
        String sql = "SELECT * FROM afiliado WHERE idbanda = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBanda);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            // Enquanto houverem resultados, adiciona o nome do músico à lista 
            ArrayList<Integer> afiliados = new ArrayList<Integer>();
            while (rs.next()){
                afiliados.add(rs.getInt(1));
            }
            System.out.println("Afiliados da banda retornado com sucesso");
            return afiliados;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getRepertoireBanda(int idBanda) {
        String sql = "SELECT musica FROM repertoriobanda WHERE idbanda = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBanda);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            // Enquanto houverem resultados, adiciona o nome do músico à lista 
            ArrayList<String> repertoire = new ArrayList<String>();
            while (rs.next()){
                repertoire.add(rs.getString(1));
            }
            System.out.println("Repertório da banda retornado com sucesso");
            return repertoire;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getUsernames() {
        String sql = "SELECT username FROM usuario";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            // Executa a consulta de busca
            ResultSet rs = statement.executeQuery();
            // Verifica se a consulta foi bem-sucedida 
            // Enquanto houverem resultados, adiciona o nome do músico à lista 
            ArrayList<String> usernames = new ArrayList<String>();
            while (rs.next()){
                usernames.add(rs.getString(1));
            }
            System.out.println("Usernames retornados com sucesso");
            return usernames;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
