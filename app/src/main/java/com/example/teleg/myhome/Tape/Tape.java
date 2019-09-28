package com.example.teleg.myhome.Tape;

public class Tape {

    private String count;
    private String title;
    private String text;

    public Tape( String count, String title, String text)
    {

        this.count = count;
        this.title = title;
        this.text = text;
    }

    public String getCount() {return this.count;}
    public String getTitle() { return this.title; }
    public String getText() {
        return this.text;
    }
}
