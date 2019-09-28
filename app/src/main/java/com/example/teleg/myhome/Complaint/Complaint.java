package com.example.teleg.myhome.Complaint;

import android.media.Image;

public class Complaint {
    int img;
    private String title;
    private String category;
    private String type;
    private String status;
    private String address;
    private String theme;
    private String text;
    private Image[] images;


    public Complaint(int img, String title, String category, String type, String status, String address, String theme, String text, Image[] images)
    {
        this.img = img;
        this.title = title;
        this.category = category;
        this.type = type;
        this.status = status;
        this.address = address;
        this.theme = theme;
        this.text = text;
        this.images = images;
    }

    public Complaint(int img, String title, String category, String type, String status, String address, String theme, String text)
    {
        this.img = img;
        this.title = title;
        this.category = category;
        this.type = type;
        this.status = status;
        this.address = address;
        this.theme = theme;
        this.text = text;
        //this.images = images;
    }

    public int getImg() {return  this.img;}
    public String getTitle() {return this.title;}
    public String getCategory(){return this.category;}
    public String getType() { return type; }
    public String getStatus() { return status; }
    public String getAddress() { return address; }
    public String getTheme() { return theme; }
    public String getText() { return text; }
    public Image[] getImages() { return images; }
}
