package com.example.teleg.myhome.Event;

public class Event {
    int img;
    private String user;
    //private String title;
    private String address;
    private String type;
    private String text;
    private String date;


    public Event(int img, String user, String address,  String type, String text, String date)
    {
        this.img = img;
        this.user = user;
        this.address= address;
        this.type = type;
        this.text = text;
        this.date = date;
    }

    public int getImg() {
        return this.img;
    }

    public String getUser() {
        return this.user;
    }

    //public String getTitle() {
        //return this.title;
    //}

    public String getAddress() {
        return this.address;
    }

    public String getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public String getDate() {
        return this.date;
    }
}
