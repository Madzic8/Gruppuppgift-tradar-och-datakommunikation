package model;

import javax.swing.*;
import java.io.Serializable;

public class Message implements Serializable {
    private User user;
    private String message;
    private ImageIcon sentImage;

    public Message(User user, String message)
    {
        this.user = user;
        this.message = message;
    }

    public Message(User user, String message, ImageIcon sentImage)
    {
        this.user = user;
        this.message = message;
        this.sentImage = sentImage;
    }

    public Message(User user, ImageIcon sentImage)
    {
        this.user = user;
        this.sentImage = sentImage;
    }

    //<editor-fold desc="Getters and setters">
    public ImageIcon GetUserPicture()
    {
        return user.getImageIcon();
    }

    public String GetUsername()
    {
        return user.getUsername();
    }

    public User GetUser()
    {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public ImageIcon getSentImage() {
        return sentImage;
    }

    @Override
    public String toString() {
        if (sentImage != null) {
            return user + " | " + message + " + attached image.";
        }
        else {
            return "textMessage: " + message + " & image: " + sentImage;
        }
    }

//</editor-fold>
}
