package com.example.dellpc.quizgame;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {

    List<Question> list;
    Question currentQues;
    int scores = 0, qid = 0;
    TextView ques, score, timer;
    Button b1, b2, b3;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQHelper db = new SQHelper(this);
        list = db.getAllQues();
        currentQues = list.get(qid);
        score = (TextView) findViewById(R.id.score);
        ques = (TextView) findViewById(R.id.ques);
        timer = (TextView) findViewById(R.id.timer);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        setQuesView();
        timer.setText("00:02:00");
        CounterClass counterClass = new CounterClass(60000, 1000);
        counterClass.start();
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      getAnswer(b1.getText().toString());
                                  }
                              }
        );
        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      getAnswer(b2.getText().toString());
                                  }
                              }
        );
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      getAnswer(b3.getText().toString());
                                  }
                              }
        );
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void getAnswer(String s) {

        if (currentQues.getAns().equals(s)) {
            scores++;
            score.setText("Score=> " + scores);
        }
        else {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("scores", scores);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
        if (qid < 10) {
            currentQues = list.get(qid);
            setQuesView();
        }
        else {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("scores", scores);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("NewApi")

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
             long milli=millisUntilFinished;
            String time=String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(milli),TimeUnit.MILLISECONDS.toMinutes(milli)
                    -TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milli)),TimeUnit.MILLISECONDS.toSeconds(milli)
                    -TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milli)));
            System.out.println(time);
            timer.setText(time);
        }

         @Override
        public void onFinish() {
           timer.setText("TIME'S UP!!!!");
        }
    }
    private void setQuesView(){
        ques.setText(currentQues.getQues());
        b1.setText(currentQues.getOa());
        b3.setText(currentQues.getOc());
        b2.setText(currentQues.getOb());
        qid++;
        if (qid == 11){

        }
    }
}
