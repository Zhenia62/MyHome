package com.example.teleg.myhome.Survey;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

public class SurveyDocumentInfo implements Parcelable {
    private String title;
    private String text;
    private String dateStart;
    private String dateStop;
    private String views;
    private String voted;

    public SurveyDocumentInfo(String title, String text, String dateStart, String dateStop, String views, String voted){
        this.title = title;
        this.text = text;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.views = views;
        this.voted = voted;
    }


    protected SurveyDocumentInfo(Parcel in) {
        String[] data = new String[6];
        in.readStringArray(data);
        title = data[0];
        text = data[1];
        dateStart = data[2];
        dateStop = data[3];
        views = data[4];
        voted = data[5];
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getDateStart() {
        return dateStart;
    }
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }
    public String getDateStop() {
        return dateStop;
    }
    public void setDateStop(String dateStop) {
        this.dateStop = dateStop;
    }
    public String getViews() {
        return views;
    }
    public void setViews(String views) {
        this.views = views;
    }
    public String getVoted() {
        return voted;
    }
    public void setVoted(String voted) {
        this.voted = voted;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                title,
                text,
                dateStart,
                dateStop,
                views,
                voted,
        });
    }


    public static final Creator<SurveyDocumentInfo> CREATOR = new Creator<SurveyDocumentInfo>() {
        @Override
        public SurveyDocumentInfo createFromParcel(Parcel in) {
            return new SurveyDocumentInfo(in);
        }

        @Override
        public SurveyDocumentInfo[] newArray(int size) {
            return new SurveyDocumentInfo[size];
        }
    };


}
