package com.metrocoder.simpleaudio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Loads our MP3 into the media player for manipulation
        mediaPlayer = MediaPlayer.create(this, R.raw.glory);


        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());


        /*
        * The timer is used to run a task during a fixed period
        * of time. In this case it will update the seek bar
        * according to the positon of the audio file
        * */
        new Timer().scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                //This updates the progress of the song on the seekbar
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                    mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                mediaPlayer.start();
            }
        });




    }

    public void play(View view)
    {
        mediaPlayer.start();
    }

    public void pause(View view)
    {
        mediaPlayer.pause();
    }
}
