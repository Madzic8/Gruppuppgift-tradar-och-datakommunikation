package model;

import javax.naming.ldap.HasControls;
import java.util.ArrayList;
import java.util.HashMap;

public class UnsentMessages {

    private HashMap<User, ArrayList<Message>> unsent = new HashMap<>();


    //TODO: Hämta ArrayList - om null skapa en och placera i unsend, Lägga till Message i ArrayList
    public void put(User user, Message message){

    }

    /*
    public synchronized ArrayList<Message> get(User user) {

    }

     */
    // fler synchronized-metoder som behövs
}




