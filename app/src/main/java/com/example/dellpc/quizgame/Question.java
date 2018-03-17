package com.example.dellpc.quizgame;

import android.app.Activity;

/**
 * Created by dell pc on 27-06-2016.
 */
public class Question extends Activity {

    private int id;
    private String ques,oa,ob,oc,ans;
   public Question(){}

    public Question(int n,String s, String s1, String s2, String s3, String s4) {
        id=n;
        ques=s;
        ans=s1;
        oa=s2;
        ob=s3;
        oc=s4;
    }

    public int getId() {
        return id;
    }

    public String getQues()
    {
      return ques;
    }
    public String getAns()
    {
        return ans;
    }
    public String getOa()
    {
        return oa;
    }
    public String getOb()
    {
        return ob;
    }
    public String getOc()
    {
        return oc;
    }
    public void setId(int Id)
    {
        id=Id;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    public void setOb(String ob) {
        this.ob = ob;
    }

    public void setOa(String oa) {
        this.oa = oa;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

}
