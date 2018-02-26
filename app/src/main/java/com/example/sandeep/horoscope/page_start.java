package com.example.sandeep.horoscope;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Rajesh on 26-02-2018.
 */

public class page_start extends AppCompatActivity{

    ExpandableListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);
        listView=findViewById(R.id.expandableListView);

    }


}
