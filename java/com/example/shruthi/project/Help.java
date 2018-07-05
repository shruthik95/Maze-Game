package com.example.shruthi.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    public static final String Res_id="rs_id",Key_id="key_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();

        if(extras!=null)
        {
            String lbl=extras.getString(Res_id);
            final TextView text=(TextView)findViewById(R.id.textView);
            text.setText(lbl);

            String img_id=extras.getString(Key_id);
            int imgid=Integer.parseInt(img_id);

            final ImageView img=(ImageView)findViewById(R.id.imageView);
            img.setImageResource(imgid);
            img.setContentDescription(lbl);
        }
    }
}
