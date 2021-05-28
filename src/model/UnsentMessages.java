package model;

import javax.naming.ldap.HasControls;
import java.util.ArrayList;
import java.util.HashMap;

public class UnsentMessages {

    private HashMap<User, ArrayList<Message>> unsent = new HashMap<>();


    //TODO: Hämta ArrayList - om null skapa en och placera i unsend, Lägga till Message i ArrayList
    public synchronized void put(User user, Message message){
        //unsent.put(user,message);
    }


    public synchronized ArrayList<Message> get(User user) {
          ArrayList<Message> messages = unsent.get(user);
          return messages;
    }


    // fler synchronized-metoder som behövs
}




