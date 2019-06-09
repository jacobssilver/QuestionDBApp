package com.example.QuestionDBApp;

public class Comment {

    private  int img;
    private String name;
    private String content;
    private String num;
    private String date;

    public Comment(int img,String name,String content,String num,String date){
        this.img = img;
        this.name = name;
        this.content = content;
        this.num = num;
        this.date =date;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getNum() {
        return num;
    }

    public String getDate() {
        return date;
    }
}
