package com.metrocoder.currencycoverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view)
    {
        EditText dollar = findViewById(R.id.dollars);
        float dollars = Float.valueOf(dollar.getText().toString()), toEuro;

        toEuro = dollars * (float) 0.843733;

        String converted = String.valueOf(toEuro);
        Toast.makeText(this, converted.substring(0,converted.indexOf(".")+3), Toast.LENGTH_LONG).show();
    }
}
