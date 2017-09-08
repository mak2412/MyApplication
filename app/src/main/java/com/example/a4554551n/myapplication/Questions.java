package com.example.a4554551n.myapplication;

public class Questions {

    public String mQuestions [] = {
            "ข้อใดต่อไปนี้เป็นชื่อท้องถิ่นของแปรงล้างขวด",
            "ข้อใดต่อไปนี้เป็นชื่อท้องถิ่นของแปรงล้างขวด",
            "ข้อใดต่อไปนี้เป็นชื่อท้องถิ่นของแปรงล้างขวด",
            "ข้อใดต่อไปนี้เป็นชื่อท้องถิ่นของแปรงล้างขวด",
            "ข้อใดต่อไปนี้เป็นชื่อท้องถิ่นของแปรงล้างขวด"
    };
    private String mChoices [] [] = {
            {"ปิดจงวา","หลิวดอก","มะต้อง","ก้ามปู"},
            {"ปิดจงวา","หลิวดอก","มะต้อง","ก้ามปู"},
            {"ปิดจงวา","หลิวดอก","มะต้อง","ก้ามปู"},
            {"ปิดจงวา","หลิวดอก","มะต้อง","ก้ามปู"},
            {"ปิดจงวา","หลิวดอก","มะต้อง","ก้ามปู"}
    };
    private String mCorrecAnwers [] = {"ปิดจงวา","หลิวดอก","มะต้อง","ก้ามปู"};

    public String getQuestions(int a){
        String question = mQuestions[a];
        return question;
    }
    public  String getChoices1(int a){
        String choice = mChoices[a][0];
        return choice;
    }
    public  String getChoices2(int a){
        String choice = mChoices[a][1];
        return choice;
    }
    public  String getChoices3(int a){
        String choice = mChoices[a][2];
        return choice;
    }
    public  String getChoices4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrecAnwer(int a){
        String anwer = mCorrecAnwers[a];
        return anwer;
    }
}
