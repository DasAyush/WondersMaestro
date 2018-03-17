package com.example.dellpc.quizgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell pc on 27-06-2016.
 */
public class SQHelper extends SQLiteOpenHelper {

    private static final String Database_name="wonder";
    private static final String Table_quest="worlds";
    private static final String key_id="qid";
    private static final String key_ques="ques";
    private static final String key_ans="ans";
    private static final String key_opA="opa";
    private static final String key_opB="opb";
    private static final String key_opC="opc";

    private static final int Database_version=1;
    private SQLiteDatabase dbase;

    public SQHelper(Context context) {
        super(context, Database_name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sq="CREATE TABLE "+Table_quest+"("+key_id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+key_ques+" TEXT,"+key_ans+" TEXT,"+key_opA+
                " TEXT,"+key_opB+" TEXT,"+key_opC+" TEXT)";
        db.execSQL(sq);
        addQues();
    }

    private void addQues() {
        Question q1=new Question(1,"1.Which of the following is an ancient seven wonder?", "The Hanging Gardens Of Babylon","The Colosseum",
                "The Hanging Gardens Of Babylon","The Great Wall Of China");
        this.addQues(q1);
        Question q2=new Question(2,"2.Which of the following is the oldest of them?","Great Pyramid Of Giza","Petra","Chichen Itza","Great Pyramid Of Giza");
        this.addQues(q2);
        Question q3=new Question(3,"3.What does the statue of Christ The Redeemer symbolise?","Peace","Peace","Love","Unity");
        this.addQues(q3);
        Question q4=new Question(4,"4.Which of the following was a part of the Maya Civilization?","Chichen Itza","The Colosseum","Chichen Itza","Machu Picchu");
        this.addQues(q4);
        Question q5=new Question(5,"5.The pyramids were capable of being seen from many miles away because they were covered in what?","Limestone","Mirrors","Precious gems","Limestone");
        this.addQues(q5);
        Question q6=new Question(6,"6.The Seven Wonders Of The Ancient World are all what?","Man-made","Natural phenomena","Man-made","Still to be seen today");
        this.addQues(q6);
        Question q7=new Question(7,"7.Which wonder was discovered by a Swiss explorer in 1812?","Petra","The Colosseum","Machu Picchu","Petra");
        this.addQues(q7);
        Question q8=new Question(8,"8.The Mausoleum Of Halicarnassus was built as a?","Tomb","Lighthouse","Fort","Tomb");
        this.addQues(q8);
        Question q9=new Question(9,"9.The Colosseum is located in?","Rome","Italy","Rome","Egypt");
        this.addQues(q9);
        Question q10=new Question(10,"10.The Taj Mahal was designed by?","Ustad Ahmad","Shah Jahan","Ustad Ahmad","Shahabuddin");
        this.addQues(q10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("DROP THE TABLE IF IT Already Exists"+Table_quest);
        onCreate(db);
    }
    public void addQues(Question table)
    {
        ContentValues values=new ContentValues();
        values.put(key_ques,table.getQues());
        values.put(key_ans,table.getAns());
        values.put(key_opA,table.getOa());
        values.put(key_opB,table.getOb());
        values.put(key_opC,table.getOc());
        dbase.insert(Table_quest,null,values);
    }
    public List<Question> getAllQues()
    {
        List<Question> list=new ArrayList<Question>();
        String selectQuery="Select * from "+Table_quest;
        dbase=this.getReadableDatabase();
        Cursor cursor=dbase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Question table=new Question();
                table.setId(cursor.getInt(0));
                table.setQues(cursor.getString(1));
                table.setAns(cursor.getString(2));
                table.setOa(cursor.getString(3));
                table.setOb(cursor.getString(4));
                table.setOc(cursor.getString(5));
                list.add(table);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
