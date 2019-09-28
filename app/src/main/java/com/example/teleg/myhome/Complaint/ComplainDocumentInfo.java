package com.example.teleg.myhome.Complaint;

import android.os.Parcel;
import android.os.Parcelable;

public class ComplainDocumentInfo implements Parcelable {
    private  String text;
    private  String theme;
    private  String address;
    private  String status;
    private  String type;
    private  String category;
    private  String title;
    private  String img;


    public ComplainDocumentInfo(String text, String theme, String address, String status, String type, String category, String title, String img) {

        this.text = text;
        this.theme = theme;
        this.address = address;
        this.status = status;
        this.type = type;
        this.category = category;
        this.title = title;
        this.img = img;
    }


    public ComplainDocumentInfo(Parcel in) {
        String[] data = new String[8];
        in.readStringArray(data);
        text = data[0];
        theme = data[1];
        address = data[2];
        status = data[3];
        type = data[4];
        category = data[5];
        title = data[6];
        img = data[7];
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }


    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }


    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
        text,
        theme,
        address,
        status,
        type,
        category,
        title,
        img,
        });
    }

    public static final Parcelable.Creator<ComplainDocumentInfo> CREATOR = new Parcelable.Creator<ComplainDocumentInfo>(){

        @Override
        public ComplainDocumentInfo createFromParcel(Parcel source) {
            return new ComplainDocumentInfo(source);
        }

        @Override
        public ComplainDocumentInfo[] newArray(int size) {
            return new ComplainDocumentInfo[size];
        }
    };
}
