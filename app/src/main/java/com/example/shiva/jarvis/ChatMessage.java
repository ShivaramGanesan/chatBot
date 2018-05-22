package com.example.shiva.jarvis;

/**
 * Created by shiva on 12/22/2017.
 */

public class ChatMessage {

    private String time,message;
    private  boolean isMine;

    public ChatMessage() {
    }

    public ChatMessage(String time, String message, boolean isMine) {
        this.time = time;
        this.message = message;
        this.isMine = isMine;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
}
