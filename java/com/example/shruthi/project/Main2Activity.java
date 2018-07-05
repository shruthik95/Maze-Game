package com.example.shruthi.project;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class Main2Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> game = Arrays.asList(getResources().getStringArray(R.array.game));
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main2, R.id.textView, game));

    }
        protected void onListItemClick(ListView l, View v,int position,long id)
    {

        Intent intent=null ;
        switch (position)
        {
            case 0:
                intent=new Intent(Main2Activity.this,Play.class);

                break;

            case 1:
                intent=new Intent(Main2Activity.this,Play2.class);

                break;
        }
        startActivity(intent);
    }

}
