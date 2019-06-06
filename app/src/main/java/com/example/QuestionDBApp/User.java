package com.example.QuestionDBApp;

public class User {
    private int user_img;
    private String user_name;
    private String user_sign;
    private String user_pronumber;

    public User(int img,String name,String sign,String pronumber){
        this.user_img=img;
        this.user_name=name;
        this.user_sign=sign;
        this.user_pronumber=pronumber;
    }

    public int getUser_img() {
        return user_img;
    }
    public String getUser_name(){
        return user_name;
    }
    public String getUser_sign(){
        return user_sign;
    }
    public String getUser_pronumber(){
        return user_pronumber;
    }
}
