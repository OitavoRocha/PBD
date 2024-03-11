package MusicFind.src;

import MusicFind.Interface.*;

public class App {
    static Login login;
    static Home home;
    static SearchPage search;
    static Registration registration;
    static RepertoireAdd repertoireAdd;
    static CreateEvent createEvent;
    static CreateBand createBand;
    static Band band;
    static Event event;
    static Musician musician;
    static NewUser newUser;
    static final database database = new database();

    public static void main(String[] args) throws Exception {
        //if (!database.connectDataBase()){
        //    return;
        //}
        //login = new Login(database);
        //home = new Home();
        search = new SearchPage(database, null);
        //registration = new Registration();
        //repertoireAdd = new RepertoireAdd();
        //createEvent = new CreateEvent();
        //createBand = new CreateBand();
        //band = new Band();
        //event = new Event();
        //musician = new Musician();
        //newUser = new NewUser(null, null);
    }
}
