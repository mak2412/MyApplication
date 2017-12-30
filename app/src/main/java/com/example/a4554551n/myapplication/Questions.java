package com.example.a4554551n.myapplication;

public class Questions {

    private int ID;
    private String Question,Answer, optionA, optionB, optionC, optionD;

    public Questions() {
        ID = 0;
        Question = "";
        optionA = "";
        optionB = "";
        optionC = "";
        optionD = "";
        Answer = "";
    }

    public Questions( String Question, String Answer, String optionA, String optionB, String optionC,
                    String optionD) {
        this.Question = Question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.Answer = Answer;

    }

    public int getID() {
        return ID;
    }

    public String getQuestion() {
        return Question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
