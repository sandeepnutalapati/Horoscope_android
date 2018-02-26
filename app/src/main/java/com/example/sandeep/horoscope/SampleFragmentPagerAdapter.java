package com.example.sandeep.horoscope;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SANDEEP on 2/23/2018.
 */


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 6;
    private String tabTitles[] = new String[] { "Sun Sign", "Food", "Career", "Love", "Money", "Wellness" };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==1||position==4){
            return WeeklyPageFragment.newInstance(position + 1);
        }
        else {
            return DailyPageFragment.newInstance(position + 1);
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}