package model;

import java.io.Serializable;
import java.util.HashMap;

public class Clients implements Serializable {

    private HashMap<User, Client> clients = new HashMap<User, Client>();

    public synchronized void put(User user, Client client) {
        clients.put(user,client);
    }

    public synchronized Client get(User user) {
        return get(user);
    }

    // fler synchronized-metoder som behövs

    public HashMap<User, Client> getHashMapList() {
        return clients;
    }

    public void setClients(HashMap<User, Client> clients) {
        this.clients = clients;
    }
}




