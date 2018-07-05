package com.example.shruthi.project;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Play2 extends AppCompatActivity {

    private TextView move;
    private TextView feedbackText;
    private Button[] buttons;
    private static final Integer[] num = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8 / 9, 10, 11, 12, 13, 14, 15};

    private ArrayList<Integer> cells = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);

        Button helpbttn = (Button) findViewById(R.id.helpbutton); //help button
        Button quibttn = (Button) findViewById(R.id.quitButton);// quit button

        //onclicklistener for quit button
        View.OnClickListener quitlistner = new View.OnClickListener() { // onclick listener for quit button
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Play2.this, Main2Activity.class);
                startActivity(i);
            }
        };
        quibttn.setOnClickListener(quitlistner);

        //onclicklistener for helpbutton
        View.OnClickListener helplistener = new View.OnClickListener() { // onclick listener for help button
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Play2.this, Help.class);
                i.putExtra(Help.Res_id,getResources().getString(R.string.helptext2));
                i.putExtra(Help.Key_id,Integer.toString(R.drawable.image2));
                startActivity(i);
            }
        };
        helpbttn.setOnClickListener(helplistener);

        buttons = findbuttons(); // storing buttons in an array

        // arranging the random numbers to the arraylist
        for (int i = 0; i < 16; i++) {
            this.cells.add(i);
        }
        Collections.shuffle(this.cells); //random cells array

        fill_grid(); // fill the grid with random numbers


        move = (TextView) findViewById(R.id.scoretxt); //used to store the score
        feedbackText = (TextView) findViewById(R.id.Moveid); // used to display the feedback of the game

        for (int i = 1; i < 16; i++) { //movement of blocks
            buttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    makeMove((Button) v);
                }
            });
        }


        move.setText("0");
        feedbackText.setText(R.string.feedback);

    }

    public Button[] findbuttons() { //arranging buttons to the array.
        Button[] b = new Button[16];

        b[0] = (Button) findViewById(R.id.Button0);
        b[1] = (Button) findViewById(R.id.Button1);
        b[2] = (Button) findViewById(R.id.Button2);
        b[3] = (Button) findViewById(R.id.Button3);
        b[4] = (Button) findViewById(R.id.Button4);
        b[5] = (Button) findViewById(R.id.Button5);
        b[6] = (Button) findViewById(R.id.Button6);
        b[7] = (Button) findViewById(R.id.Button7);
        b[8] = (Button) findViewById(R.id.Button8);
        b[9]=  (Button) findViewById(R.id.Button9);
        b[10]=  (Button) findViewById(R.id.Button10);
        b[11]=  (Button) findViewById(R.id.Button11);
        b[12]=  (Button) findViewById(R.id.Button12);
        b[13]=  (Button) findViewById(R.id.Button13);
        b[14]=  (Button) findViewById(R.id.Button14);
        b[15]=  (Button) findViewById(R.id.Button15);
        return b;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void makeMove(final Button b) {
        Boolean bad_move = true;
        int b_text,b_pos,zuk_pos;
        b_text=Integer.parseInt((String) b.getText());
        b_pos= position(b_text);
        zuk_pos= position(0);
        switch(zuk_pos)
        {
            case(0):
                if(b_pos==1||b_pos==3)
                    bad_move =false;
                break;
            case(1):
                if(b_pos==0||b_pos==2||b_pos==4)
                    bad_move =false;
                break;
            case(2):
                if(b_pos==1||b_pos==3 || b_pos==6)
                    bad_move =false;
                break;
            case(3):
                if(b_pos==2||b_pos==7)
                    bad_move =false;
                break;
            case(4):
                if(b_pos==0||b_pos==5||b_pos==8)
                    bad_move =false;
                break;
            case(5):
                if(b_pos==1||b_pos==4||b_pos==6 || b_pos==9)
                    bad_move =false;
                break;
            case(6):
                if(b_pos==2||b_pos==5 || b_pos==7 || b_pos==10)
                    bad_move =false;
                break;
            case(7):
                if(b_pos==3||b_pos==6||b_pos==11)
                    bad_move =false;
                break;
            case(8):
                if(b_pos==4||b_pos==9 || b_pos==12)
                    bad_move =false;
                break;
            case(9):
                if(b_pos==5||b_pos==8 || b_pos==10 || b_pos==13)
                    bad_move =false;
                break;

            case(10):
                if(b_pos==6||b_pos==9 || b_pos==11 || b_pos==14)
                    bad_move =false;
                break;
            case(11):
                if(b_pos==7||b_pos==10|| b_pos==15)
                    bad_move =false;
                break;

            case(12):
                if(b_pos==8||b_pos==13)
                    bad_move =false;
                break;

            case(13):
                if(b_pos==9||b_pos==12|| b_pos==14)
                    bad_move =false;
                break;
            case(14):
                if(b_pos==10||b_pos==13|| b_pos==15)
                    bad_move =false;
                break;
            case(15):
                if(b_pos==11||b_pos==14)
                    bad_move =false;
                break;
        }

        if(bad_move)
        {
            feedbackText.setText("Move Not Allowed");
            return;
        }
        feedbackText.setText("Move OK");
        // moving the block with blank space
        cells.remove(b_pos);
        cells.add(b_pos, 0);
        cells.remove(zuk_pos);
        cells.add(zuk_pos,b_text);


        fill_grid(); //fill the grid after the movement

        move.setText( Integer.toString(Integer.parseInt((String) move.getText())+1));

        // calculating the winner by matching number in grid with num array.
        for(int i=0;i<16;i++)
        {
            if(!Objects.equals(cells.get(i), num[i]))
            {
                return;
            }
        }
        feedbackText.setText("we have a winner");
    }

    public void fill_grid() //fill the grid
    {
        for(int i=0;i<16;i++)
        {
            int text=cells.get(i);
            @SuppressWarnings("deprecation") AbsoluteLayout.LayoutParams absParams =
                    (AbsoluteLayout.LayoutParams)buttons[text].getLayoutParams();
            switch(i)
            {
                case(0):

                absParams.x = 5;
                absParams.y = 5;
                buttons[text].setLayoutParams(absParams);
                break;
                case(1):

                    absParams.x = 100;
                    absParams.y = 5;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(2):

                    absParams.x = 195;
                    absParams.y = 5;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(3):

                    absParams.x = 290;
                    absParams.y = 5;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(4):

                    absParams.x =5;
                    absParams.y =100;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(5):

                    absParams.x = 100;
                    absParams.y =100;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(6):

                    absParams.x = 195;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(7):

                    absParams.x = 290;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(8):

                    absParams.x = 5;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(9):

                    absParams.x = 100;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(10):

                    absParams.x = 195;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(11):

                    absParams.x = 290;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(12):

                    absParams.x = 5;
                    absParams.y = 290;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(13):

                    absParams.x = 100;
                    absParams.y = 290;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(14):

                    absParams.x = 195;
                    absParams.y = 290;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case(15):

                    absParams.x = 290;
                    absParams.y = 290;
                    buttons[text].setLayoutParams(absParams);
                    break;

            }


        }

    }

    public int position(int element) //finding the element position in the grid
    {
        int i;
        for(i=0;i<15;i++)
        {
            if(cells.get(i)==element)
            {
                break;
            }
        }
        return i;
    }
}

