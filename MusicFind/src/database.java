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

    public static boolean insertUser(String contato, float rating, String username, String userpassword, String tipo){

        String sql = "INSERT INTO usuario (contato, rating, username, userpassword, tipo) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, contato);
            statement.setFloat(2, rating);
            statement.setString(3, username);
            statement.setString(4, userpassword);
            statement.setString(5, tipo);
            // Executa a consulta de inserção
            int rowsInserted = statement.executeUpdate();
            // Verifica se a inserção foi bem-sucedida (pelo menos uma linha afetada)
            if (rowsInserted > 0) {
                System.out.println("Novo usuário inserido com sucesso.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertMusician(String genero, String instrumento, int anos_experiencia, float cache, int id_usuario){

        String sql = "INSERT INTO musico (genero, instrumento, anos_experiencia, cache, idusuario) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, genero);
            statement.setString(2, instrumento);
            statement.setInt(3, anos_experiencia);
            statement.setFloat(4, cache);
            statement.setInt(5, id_usuario);
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

    public static boolean insertEvent(String nome, int capacidade, String foco, String status_evento, int idEvento, String date, String endereço, int id_usuario){

        String sql = "INSERT INTO evento (nome, capacidade, foco, status_evento, idEvento, date, endereço, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setInt(2, capacidade);
            statement.setString(3, foco);
            statement.setString(4, status_evento);
            statement.setInt(5, idEvento);
            statement.setString(6, date);
            statement.setString(7, endereço);
            statement.setInt(8, id_usuario);
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

    public static boolean insertRepertoireBanda(int idBanda, String musica){
            
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

    public static boolean insertRepertoireMusico(int idMusico, String musica){
                
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


    public static boolean insertBand(int idBanda, String statusBanda, String genero, float cache, float rating, String nome){
            
        String sql = "INSERT INTO banda (idBanda, statusBanda, genero, cache, rating, nome) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idBanda);
            statement.setString(2, statusBanda);
            statement.setString(3, genero);
            statement.setFloat(4, cache);
            statement.setFloat(5, rating);
            statement.setString(6, nome);
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

    public static boolean insertParticipaMusico(int idEvento, int idUsuario){
                
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

    public static boolean insertParticipaBanda(int idEvento, int idBanda){
                
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

    public static boolean insertAfiliado(int idMusico, int idBanda){

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
