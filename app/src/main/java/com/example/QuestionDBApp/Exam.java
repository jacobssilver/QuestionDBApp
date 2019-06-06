package com.example.QuestionDBApp;

public class Exam {

    private String exam_name;
    private int exam_imageid;

    public Exam(String examName,int exam_id){
        this.exam_name = examName;
        this.exam_imageid = exam_id;

    }
    public String getExam_name(){
        return exam_name;
    }
    public int getExam_imageid(){
        return exam_imageid;
    }
}
