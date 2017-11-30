package com.metrocoder.numberguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Random seed = new Random();
    private int expected = seed.nextInt(20)+1;;

    public void randomGuess(View view)
    {
        EditText number = findViewById(R.id.input);
        int val = Integer.parseInt(number.getText().toString());



        if(val<expected)
            Toast.makeText(this, "Higher..", Toast.LENGTH_LONG).show();
        else if (val>expected)
            Toast.makeText(this,"Lower...", Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "Awesome! Try Again...", Toast.LENGTH_LONG).show();
            expected = seed.nextInt(20)+1;
        }

    }
}
