package com.metrocoder.learnfrench;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view)
    {
        Button button = (Button) view;

        int tag = Integer.parseInt(button.getTag().toString());

        switch (tag)
        {
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.doyouspeakenglish);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.goodevening);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.hello);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.howareyou);
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ilivein);
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.mynameis);
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.please);
                break;
            default:
                mediaPlayer = MediaPlayer.create(this, R.raw.welcome);
        }

        mediaPlayer.start();

    }
}
