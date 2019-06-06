package com.example.QuestionDBApp;

public class Forum {
    private String ProblemTitle;
    private String ProblemInfo;
    private String ProblemCom;

    public Forum(String problemtitle, String probleminfo,String problemcom){
        this.ProblemTitle = problemtitle;
        this.ProblemInfo = probleminfo;
        this.ProblemCom = problemcom;
    }

    public String getProblemTitle(){
        return ProblemTitle;
    }

    public String getProblemInfo(){
        return ProblemInfo;
    }

    public String getProblemCom(){
        return ProblemCom;
    }


}
