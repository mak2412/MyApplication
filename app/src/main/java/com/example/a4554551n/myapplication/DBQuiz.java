package com.example.a4554551n.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBQuiz extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "quiz";
    private static final String TABLE_NAME = "BotanyQuiz";
    private static final String KEY_ID = "id";
    private static final String QUESTIONS = "question";
    private static final String ANSWER = "answer";
    private static final String OPTIONA = "optiona";
    private static final String OPTIONB = "optionb";
    private static final String OPTIONC = "optionc";
    private static final String OPTIOND = "optiond";

    private SQLiteDatabase dba;

    public DBQuiz(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + QUESTIONS + " TEXT, "
                + ANSWER + " TEXT, " + OPTIONA + " TEXT, " + OPTIONB + " TEXT, " + OPTIONC
                + " TEXT, " + OPTIOND + " TEXT);";

        db.execSQL(CREATE_TABLE);

//        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + QUESTIONS + ", " + ANSWER
//                + ", " + OPTIONA + ", "+ OPTIONB +", "+ OPTIONC +", "+ OPTIOND +
//                ") VALUES ('ถิ่นกำเนิดของเหลืองปรีดียาธรอยู่ที่ใด', 'อเมริกา', 'ไทย','อังกฤษ','อเมริกา','จีน');");

//        final String Insert_Data="INSERT INTO TABLE_NAME VALUES(1,'ถิ่นกำเนิดของเหลืองปรีดียาธรอยู่ที่ใด','อเมริกา','ไทย','อังกฤษ','อเมริกา','จีน')";
//        db.execSQL(Insert_Data);

        addQuestions(db);

    }

    private void addQuestions(SQLiteDatabase db) {
        Questions q1 = new Questions("ถิ่นกำเนิดของเหลืองปรีดียาธรอยู่ที่ใด", "อเมริกา",
                "ไทย", "อังกฤษ", "อเมริกา", "จีน");
        this.addQuestion(q1,db);
        Questions q2 = new Questions("เหลืองปรีดียาธรเป็นไม้ชนิดใด",
                "ไม้ยืนต้นขนาดเล็ก", "ไม้ยืนต้นขนาดเล็ก", "ไม้ยืนต้นขนาดกลาง", "ไม้ยืนต้นขนาดใหญ่", "ไม้ยืนต้นขนาดกลางถึงใหญ่");
        this.addQuestion(q2,db);
        Questions q3 = new Questions("ดอกของปรีดียาธรมีสีอะไร",
                "เหลือง", "ม่วง", "ส้ม", "แดง", "เหลือง");
        this.addQuestion(q3,db);
        Questions q4 = new Questions("ผลของเหลืองปรีดียาธรยาวประมาณเท่าไร",
                "10ซม", "5ซม", "10ซม", "15ซม", "20ซม");
        this.addQuestion(q4,db);
        Questions q5 = new Questions("ประโยชน์ของเหลืองปรีดียาธร",
                "ใช้ประดับ", "ใช้เป็นอาหาร", "ใช้ประดับ", "ใช้เป็นยา", "ใช้สร้างบ้าน");
        this.addQuestion(q5,db);

//        add more questions
    }

    // addding new questions to db
    public void addQuestion(Questions question,SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(QUESTIONS, question.getQuestion());
        values.put(ANSWER, question.getAnswer());
        values.put(OPTIONA, question.getOptionA());
        values.put(OPTIONB, question.getOptionB());
        values.put(OPTIONC, question.getOptionC());
        values.put(OPTIOND, question.getOptionD());

        db.insert(TABLE_NAME, null, values);
    }

    public List<Questions> getAllQuestions() {
        List<Questions> questionList = new ArrayList<Questions>();

        String query = "SELECT * FROM " + TABLE_NAME;
        dba = this.getReadableDatabase();
        Cursor cursor = dba.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Questions quest = new Questions();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setOptionA(cursor.getString(3));
                quest.setOptionB(cursor.getString(4));
                quest.setOptionC(cursor.getString(5));
                quest.setOptionD(cursor.getString(6));

                questionList.add(quest);

            } while (cursor.moveToNext());
        }

        cursor.close();
        dba.close();
        return questionList;
    }

    public int rowCount() {
        int row = 0;
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        row = cursor.getCount();

        cursor.close();
        return row;
    }

    //Drop DataBases//
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
