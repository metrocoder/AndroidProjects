package com.metrocoder.fadinganimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setImages();
    }

    private int count=0;
    private ArrayList<Integer> myImageList;

    private void setImages()
    {
        myImageList = new ArrayList<>();
        myImageList.add(R.drawable.sandpile1);
        myImageList.add(R.drawable.sandpile2);
    }

    public void fadeOut(View view)
    {

        ImageView imageView = findViewById(R.id.image);
        ImageView imageView2 = findViewById(R.id.image2);

        imageView.animate().alpha(0).setDuration(1500);
        imageView2.animate().alpha(1).setDuration(1500);
        imageView2.bringToFront();
        System.out.println("Image 1 Clicked");
    }

    public void fadeIn(View view)
    {

        ImageView imageView2 = findViewById(R.id.image2);
        ImageView imageView = findViewById(R.id.image);
        imageView2.animate().alpha(0).setDuration(1500);
        imageView.animate().alpha(1).setDuration(1500);
        imageView.bringToFront();
        System.out.println("Image 2 Clicked");
    }
}

