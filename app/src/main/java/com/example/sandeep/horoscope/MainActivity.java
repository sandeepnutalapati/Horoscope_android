package com.example.sandeep.horoscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView button1 = findViewById(R.id.aries);
        ImageView button2 = findViewById(R.id.taurus);
        ImageView button3 = findViewById(R.id.gemini);
        ImageView button4 = findViewById(R.id.cancer);
        ImageView button5 = findViewById(R.id.leo);
        ImageView button6 = findViewById(R.id.virgo);
        ImageView button7 = findViewById(R.id.libra);
        ImageView button8 = findViewById(R.id.scorpio);
        ImageView button9 = findViewById(R.id.sagittarius);
        ImageView button10 = findViewById(R.id.capricorn);
        ImageView button11 = findViewById(R.id.acquarius);
        ImageView button12= findViewById(R.id.pisces);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,HoroscopeActivity.class);
        switch (v.getId()) {

            case R.id.aries:
                intent.putExtra("sign",1);
                startActivity(intent);
                break;

            case R.id.taurus:
                intent.putExtra("sign",2);
                startActivity(intent);
                break;

            case R.id.gemini:
                intent.putExtra("sign",3);
                startActivity(intent);
                break;

            case R.id.cancer:
                intent.putExtra("sign",4);
                startActivity(intent);
                break;

            case R.id.leo:
                intent.putExtra("sign",5);
                startActivity(intent);
                break;

            case R.id.virgo:
                intent.putExtra("sign",6);
                startActivity(intent);
                break;

            case R.id.libra:
                intent.putExtra("sign",7);
                startActivity(intent);
                break;

            case R.id.scorpio:
                intent.putExtra("sign",8);
                startActivity(intent);
                break;

            case R.id.sagittarius:
                intent.putExtra("sign",9);
                startActivity(intent);
                break;

            case R.id.capricorn:
                intent.putExtra("sign",10);
                startActivity(intent);
                break;

            case R.id.acquarius:
                intent.putExtra("sign",11);
                startActivity(intent);
                break;

            case R.id.pisces:
                intent.putExtra("sign",12);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
