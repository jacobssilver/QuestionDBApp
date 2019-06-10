package com.example.QuestionDBApp;

public class Question {
    private int type;
    private int img;
    private int answer;
    private int state;

    public Question(int type,int img,int answer){
        this.type = type;
        this.img = img;
        this.answer = answer;
        this.state=0;
    }

    public int getType() {
        return type;
    }

    public int getImg() {
        return img;
    }

    public int getAnswer() {
        return answer;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
