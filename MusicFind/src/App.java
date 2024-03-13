package MusicFind.src;

import MusicFind.Interface.*;

public class App {
    static Login login;
    static final database database = new database();

    public static void main(String[] args) throws Exception {
        if (!database.connectDataBase()){
            System.out.println("Erro ao conectar ao banco de dados");
            return;
        }
        login = new Login(database);
    }
}
