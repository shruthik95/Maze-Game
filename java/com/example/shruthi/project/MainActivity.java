package com.example.shruthi.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button play=(Button)findViewById(R.id.playbbtn); // initiate play button
       final Button about=(Button)findViewById(R.id.abtbttn); //initiate about button

        View.OnClickListener playlistener=new View.OnClickListener(){ // onclick listener for play button

            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        };
        play.setOnClickListener(playlistener);

        View.OnClickListener aboutlistener=new View.OnClickListener(){ //onclick listener for about button

            @Override
            public void onClick(View v) {
                Intent j=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.helpfulgames.com/subjects/brain-training/sliding-puzzle.html"));
                 startActivity(j);
            }
        };
         about.setOnClickListener(aboutlistener);
    }
}
