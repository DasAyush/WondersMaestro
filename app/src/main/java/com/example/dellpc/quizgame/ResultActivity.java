package com.example.dellpc.quizgame;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by dell pc on 27-06-2016.
 */
public class ResultActivity extends Activity {
    Button again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textResult=(TextView)findViewById(R.id.textResult);
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        int s=bundle.getInt("scores");
        if(s==0)
        textResult.setText(" Your Final Score: "+s+". \n Got stuck on the first question....duh!!!! \n I Am Sure You Will Have Another Go!!!");
        else if(s>=1&&s<=4)
            textResult.setText(" Your Final Score: "+s+". \n Awww...dats poor xD xD \n Hope, You Hated It!!!");
        else if(s>=5&&s<=8)
            textResult.setText(" Your Final Score: "+s+". \n Dude!!!That was some good game...  \n Hope, You Enjoyed It!!!");
        else if(s==9)
            textResult.setText(" Your Final Score: "+s+". \n Ooooh....So close!!!! \n Hope, You Are Really Disappointed...hahahaha!!!");
        else
            textResult.setText(" Your Final Score: "+s+". \n I Bet You're Damn Lucky xP!!!! \n You Win!!!");
        again=(Button)findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
z