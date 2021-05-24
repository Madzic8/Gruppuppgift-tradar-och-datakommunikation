package model;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client(String ipAddress, int port) {
        System.out.println("Establishing connection. Please wait...");
        try {
            socket = new Socket(ipAddress,port);
            oos = new ObjectOutputStream( new BufferedOutputStream(socket.getOutputStream()) );
            ois = new ObjectInputStream( new BufferedInputStream(socket.getInputStream()) );
            System.out.println("Connected!");
        } catch (IOException e) {
            System.out.println("Could not connect");
            e.printStackTrace();
        }
        start();
    }

    public void run() {
        while(!Thread.interrupted()) {
            System.out.println("Running");

            Buffer<Message> messagesBuffer = new Buffer<Message>();
            // TODO : hårdkodade data, datan bör var dynamsika
            User user = new User("Johan", null);
            Message messageTest = new Message(user, "Hello, It's me");
            messagesBuffer.put(messageTest);

            try {
                while(true) {

                    Message message = messagesBuffer.get();
                    if(message != null) {
                        System.out.println("Client sent: " + message.toString());
                        oos.writeObject(message);
                        oos.flush();
                    }

                    Message messageRecieved = (Message) ois.readObject();
                    System.out.println("Client recieved: " + messageRecieved.toString());

                }
            }catch(IOException | InterruptedException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
