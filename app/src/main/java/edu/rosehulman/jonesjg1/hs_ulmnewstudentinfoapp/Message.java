package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

public class Message {
    public String id;
    public String user;
    public String message;
    public Long time;

    public Message(){

    }
    public Message(String id, String user, String text, Long time){
        this.id=id;
        this.user=user;
        this.message=text;
        this.time=time;
    }
}
