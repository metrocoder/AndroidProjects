package com.metrocoder.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<String> ans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SeekBar seekBar = findViewById(R.id.test);
        seekBar.setMax(21);
        seekBar.setMin(1);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                    multi(progress);


                Log.i("Progress",String.valueOf(progress));
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




    private void multi(int num)
    {
        ListView listView = findViewById(R.id.list);

        ArrayAdapter<String> adapter;
        ArrayList<String> solution = new ArrayList<>();
        for (int i=1;i<10;i++)
        {
            solution.add(String.valueOf(num*i));
        }

        System.out.println(solution);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,solution);
        listView.setAdapter(adapter);

    }

}
