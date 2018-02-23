package com.example.sandeep.horoscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button1 = findViewById(R.id.imageButton1);
        ImageButton button2 = findViewById(R.id.imageButton2);
        ImageButton button3 = findViewById(R.id.imageButton3);
        ImageButton button4 = findViewById(R.id.imageButton4);
        ImageButton button5 = findViewById(R.id.imageButton5);
        ImageButton button6 = findViewById(R.id.imageButton6);
        ImageButton button7 = findViewById(R.id.imageButton7);
        ImageButton button8 = findViewById(R.id.imageButton8);
        ImageButton button9 = findViewById(R.id.imageButton9);
        ImageButton button10 = findViewById(R.id.imageButton10);
        ImageButton button11 = findViewById(R.id.imageButton11);
        ImageButton button12= findViewById(R.id.imageButton12);

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

            case R.id.imageButton1:
                intent.putExtra("sign",1);
                startActivity(intent);
                break;

            case R.id.imageButton2:
                intent.putExtra("sign",2);
                startActivity(intent);
                break;

            case R.id.imageButton3:
                intent.putExtra("sign",3);
                startActivity(intent);
                break;

            case R.id.imageButton4:
                intent.putExtra("sign",4);
                startActivity(intent);
                break;

            case R.id.imageButton5:
                intent.putExtra("sign",5);
                startActivity(intent);
                break;

            case R.id.imageButton6:
                intent.putExtra("sign",6);
                startActivity(intent);
                break;

            case R.id.imageButton7:
                intent.putExtra("sign",7);
                startActivity(intent);
                break;

            case R.id.imageButton8:
                intent.putExtra("sign",8);
                startActivity(intent);
                break;

            case R.id.imageButton9:
                intent.putExtra("sign",9);
                startActivity(intent);
                break;

            case R.id.imageButton10:
                intent.putExtra("sign",10);
                startActivity(intent);
                break;

            case R.id.imageButton11:
                intent.putExtra("sign",11);
                startActivity(intent);
                break;

            case R.id.imageButton12:
                intent.putExtra("sign",12);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
