package model;

import java.util.LinkedList;

public class MessageManager
{
    Buffer<Message> messageBuffer;
    private Thread thread;
    private LinkedList<Callback> list = new LinkedList<Callback>();

    public MessageManager(Buffer<Message> messageBuffer)
    {
        this.messageBuffer = messageBuffer;
    }

    public void addCallback(Callback callback)
    {
        list.add(callback);
    }

    public void start()
    {
        if(thread==null) {
            thread = new Worker();
            thread.start();
        }
    }

    private class Worker extends Thread
    {
        public void run() {

            while (!Thread.interrupted())
            {
                try {
                    Message message = messageBuffer.get();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).updateMessage(message);
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                thread = null; //Gör tråden "tom" så vi kan starta den igen
            }
        }
    }
}
