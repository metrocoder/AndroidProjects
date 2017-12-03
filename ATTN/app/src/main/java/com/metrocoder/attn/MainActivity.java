package com.metrocoder.attn;

import android.media.MediaPlayer;
import android.os.CountDownTimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    private int timeSet;
    private long time=0, elapsed=0;
    private SeekBar seekBar;
    private EditText editText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        editText = findViewById(R.id.timer);
        btn = findViewById(R.id.button);

        /*
        * Sets the max time that the user can choose to 60 minutes
        * */
        seekBar.setMax(60);
        seekBar.setProgress(15);
        editText.setText("15:00");
        time = 15 * 60000;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    editText.setText(String.valueOf(progress)+":00");
                    time = progress * 60000;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });


    }

    private CountDownTimer countDownTimer;

    public void signal(final View view) throws InterruptedException
    {
        seekBar.setEnabled(false);
        btn.setText("Stop");
        System.out.println("clicked");
        if (timeSet==1)
        {
            seekBar.setEnabled(true);
            time -= elapsed;
            countDownTimer.cancel();
            btn.setText("Start");
            timeSet = 0;
        }
        else
        {
            timeSet =1;
            countDownTimer = new CountDownTimer(time+100,1000)
            {
                public void onTick(long time)
                {
                    int min, seconds;
                    String display="";


                    elapsed+=1000;
                    min = (int)((time - elapsed)/60000);
                    seconds = (int)((time - elapsed)%60000);
                    display += String.valueOf(min);
                    display+=":";
                    display+=seconds;
                    display = display.substring(0,5);
                    seekBar.setProgress(min);
                    editText.setText(display);
                }

                public void onFinish()
                {
                    MediaPlayer player = MediaPlayer.create(view.getContext(),R.raw.bell);
                    player.start();
                    timeSet = 0;
                    elapsed = 0;
                    time=0;
                }
            }.start();
        }
    }


}
