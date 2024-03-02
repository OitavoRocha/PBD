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
