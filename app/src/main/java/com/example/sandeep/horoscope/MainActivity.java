package com.example.sandeep.horoscope;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView button1;
    ImageView button2;
    ImageView button3;
    ImageView button4;
    ImageView button5;
    ImageView button6;
    ImageView button7;
    ImageView button8;
    ImageView button9;
    ImageView button10;
    ImageView button11;
    ImageView button12;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void Initailsetup(){
        button1 = findViewById(R.id.aries);
        button2 = findViewById(R.id.taurus);
        button3 = findViewById(R.id.gemini);
        button4 = findViewById(R.id.cancer);
        button5 = findViewById(R.id.leo);
        button6 = findViewById(R.id.virgo);
        button7 = findViewById(R.id.libra);
        button8 = findViewById(R.id.scorpio);
        button9 = findViewById(R.id.sagittarius);
        button10 =findViewById(R.id.capricorn);
        button11 =findViewById(R.id.acquarius);
        button12= findViewById(R.id.pisces);
    }
    @Override
    public void onClick(View v) {
        Initailsetup();
        v.setTransitionName("fader");
        switch (v.getId()) {

            case R.id.aries:
                gotonext(1,v);
                break;

            case R.id.taurus:
                gotonext(2,v);
                break;

            case R.id.gemini:
                gotonext(3,v);
                break;

            case R.id.cancer:
                gotonext(4,v);
                break;

            case R.id.leo:
                gotonext(5,v);
                break;

            case R.id.virgo:
                gotonext(6,v);
                break;

            case R.id.libra:
                gotonext(7,v);
                break;

            case R.id.scorpio:
                gotonext(8,v);
                break;

            case R.id.sagittarius:
                gotonext(9,v);
                break;

            case R.id.capricorn:
                gotonext(10,v);
                break;

            case R.id.acquarius:
                gotonext(11,v);
                break;

            case R.id.pisces:
                gotonext(12,v);
                break;
            default:
                break;
        }
    }
    void gotonext(int value,View v){

        intent= new Intent(this,HoroscopeActivity.class);
        intent.putExtra("sign",value);
        Explode explode=new Explode();
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);
        getWindow().setAllowReturnTransitionOverlap(false);
        Bundle bundle= ActivityOptions.makeSceneTransitionAnimation(this,v,"fader").toBundle();
        startActivity(intent,bundle);
    }
}
