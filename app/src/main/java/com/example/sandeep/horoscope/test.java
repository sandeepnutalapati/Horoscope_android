package com.example.sandeep.horoscope;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class test extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        ProgressBar progressBar=findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        TextView textView=findViewById(R.id.testview);
        textView.setVisibility(View.INVISIBLE);
    }
}
