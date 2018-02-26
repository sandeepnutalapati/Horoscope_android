package com.example.sandeep.horoscope;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class HoroscopeActivity extends AppCompatActivity{

    private String data = "";
    private ViewPager viewPager;
    private TabLayout tabLayout;
    ImageView thisfader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        Transition slide=new Slide();
        getWindow().setExitTransition(slide);
        getWindow().setEnterTransition(slide);
        getWindow().setAllowEnterTransitionOverlap(false);

        viewPager=findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true,new ZoomOutPageTransformer());
        tabLayout=findViewById(R.id.sliding_tabs);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.black),getResources().getColor(R.color.colorPrimary));
        thisfader=findViewById(R.id.thisfader);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int sign=0;
        if(bundle != null){
            sign = bundle.getInt("sign");
        }
        String[] signs = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
        int[] ints={R.drawable.aries,R.drawable.tarus,R.drawable.gemini,R.drawable.cancer,R.drawable.leo,R.drawable.virgo,R.drawable.libra,R.drawable.scorpio,R.drawable.sagittarius,R.drawable.capricorn,R.drawable.aquarius_update,R.drawable.pisces};
        thisfader.setImageDrawable(getDrawable(ints[sign-1]));
        getSupportActionBar().setTitle(signs[sign-1]);
        data = data+sign;

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                HoroscopeActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    public String getMyData() {
        return data;
    }
}

