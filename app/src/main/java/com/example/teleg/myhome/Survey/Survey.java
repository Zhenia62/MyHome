package com.example.teleg.myhome.Survey;

public class Survey {

    private int img;

    private String title;
    private String text;

    private String[] variants;

    private String location;

    private String dateStart;
    private String dateStop;
    private String views;
    private String voted;


    public Survey(int img, String title, String text, String location,  String dateStart,  String dateStop, String views, String voted, String[] variants)
    {
        this.img = img;

        this.title = title;
        this.text = text;

        this.location = location;

        this.variants = variants;

        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.views= views;
        this.voted = voted;

    }

    public Survey(int img, String title, String text, String dateStart,  String dateStop, String views, String voted, String[] variants)
    {

        this.img = img;

        this.title = title;
        this.text = text;

        this.variants = variants;

        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.views= views;
        this.voted = voted;

    }


    public Survey(int img, String title, String text, String dateStart,  String dateStop, String views, String voted)
    {

        this.img = img;

        this.title = title;
        this.text = text;

        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.views= views;
        this.voted = voted;

    }


    public int getImg(){return this.img;}

    public String getTitle() { return this.title; }
    public String getText() {
        return this.text;
    }

    public String[] getVariants() {
        return this.variants;
    }
    public String getLocation() {return this.location;}

    public String getDateStart() {
        return this.dateStart;
    }
    public String getDateStop() {
        return this.dateStop;
    }
    public String getViews() {
        return this.views;
    }
    public String getVoted() {
        return this.voted;
    }
}

