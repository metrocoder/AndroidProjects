package com.metrocoder.sprout;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private ArrayList<Button> button;
    private Button play;
    private TextView problem;
    private TextView ticker;
    private ImageView img;
    private int time = 30, solution, correct,count=0, wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Get ImageView from Activity
        * */
        img = findViewById(R.id.face);

        /*
        * This adds all the buttons that are currently present on the screen
        *
        * */
        button = new ArrayList<>();
        button.add((Button) findViewById(R.id.button0));
        button.add((Button) findViewById(R.id.button1));
        button.add((Button) findViewById(R.id.button2));
        button.add((Button) findViewById(R.id.button3));

//        Disables the buttons
        disableBtns();

        /*
        * To set the text for the Play button
        * */
        play = findViewById(R.id.play);
        play.setText("Play!");

        /*
        * Initialize the TextView variables
        * */
        problem = findViewById(R.id.problem);
        ticker = findViewById(R.id.ticker);

    }


    /*
    * This is the method that will be called when the play button is pressed.
    * */
    public void triggered(View view)
    {
        Button b = (Button) view;
        b.setVisibility(View.INVISIBLE);
        b.setEnabled(false);
        enableBtns();
        problemGen();
        setButton();

        new CountDownTimer((30*1000),1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                time-=1;
                ticker.setText(String.valueOf(time));

            }

            @Override
            public void onFinish()
            {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.bell);
                mediaPlayer.start();
                img.setVisibility(View.INVISIBLE);
                play.setVisibility(View.VISIBLE);
                play.setEnabled(true);
                play.setText("Play Again?");
                disableBtns();
                problem.setText(count+"\t/\t"+wrong+" correct!");
            }
        }.start();
    }


    /*
    * This is the method that is called when a solution is clicked
    * */
    public void selection(View view)
    {
        Button selected = (Button)view;
        if (selected.getId()==button.get(correct).getId())
        {
            count++;
            img.setImageResource(R.drawable.nerd);
            img.setVisibility(View.VISIBLE);
        }
        else
        {
            wrong = ++wrong + count;
            img.setImageResource(R.drawable.poop);
            img.setVisibility(View.VISIBLE);
        }

        problemGen();
        setButton();
    }

    private void problemGen()
    {
        Random seed = new Random();
        int a= seed.nextInt(20);
        int b = seed.nextInt(20);
        setProblem(a+"+"+b);
        solution = a+b;
    }

    private void setButton()
    {
        Random seed = new Random();
        int act = correct = seed.nextInt(3);

        for (Button btn : button)
        {
            btn.setText(String.valueOf(seed.nextInt(40)+5));
        }

        button.get(act).setText(String.valueOf(solution));
    }

    private void setProblem(String text)
    {
        this.problem.setText(text);
    }

    private void disableBtns()
    {
        /*
        * Set the buttons to disabled
        * */
        for (Button b : button)
        {
            b.setEnabled(false);
        }
    }
    private void enableBtns()
    {
        /*
        * Set the buttons to disabled
        * */
        for (Button b : button)
        {
            b.setEnabled(true);
        }
    }
}
