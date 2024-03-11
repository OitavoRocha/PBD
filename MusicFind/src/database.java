package MusicFind.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {
    
    static Connection con = null;

    public static boolean connectDataBase(){

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

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, usuario.genero);
            statement.setString(2, usuario.instrumento);
            statement.setInt(3, usuario.anos_experiencia);
            statement.setFloat(4, usuario.cache);
            statement.setInt(5, usuario.id);
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

        String sql = "INSERT INTO evento (nome, capacidade, foco, status_evento, date, endereço, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setInt(2, capacidade);
            statement.setString(3, foco);
            statement.setString(4, status_evento);
            statement.setString(5, date);
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

    public boolean insertRepertoireMusico(int idMusico, String musica){
                
        String sql = "INSERT INTO RepertorioMusico (idMusico, musica) VALUES (?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idMusico);
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

    public boolean insertAfiliado(int idMusico, int idBanda){

        String sql = "INSERT INTO Afiliado (idMusico, idBanda) VALUES (?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idMusico);
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


    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
