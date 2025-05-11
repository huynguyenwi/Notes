package com.example.notes.NoteModel;


public class Notes {
    private int id;
    private String title;
    private String description;
    private String date;
    private String time;

    private int color1;
    private int color2;

    public Notes(){

    }

//    public Notes(String title, String description, String date, String time) {
//        this.title = title;
//        this.description = description;
//        this.date = date;
//        this.time = time;
//    }
//
//    public Notes(int id, String title, String description, String date, String time) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.date = date;
//        this.time = time;
//    }

    public Notes(int id, String title, String description, String date, String time, int color1, int color2) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.color1 = color1;
        this.color2 = color2;
    }

    public Notes(String title, String description, String date, String time, int color1, int color2) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.color1 = color1;
        this.color2 = color2;
    }

    public int getColor1() {
        return color1;
    }

    public void setColor1(int color1) {
        this.color1 = color1;
    }

    public int getColor2() {
        return color2;
    }

    public void setColor2(int color2) {
        this.color2 = color2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
