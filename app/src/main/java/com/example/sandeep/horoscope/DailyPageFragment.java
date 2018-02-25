package com.example.sandeep.horoscope;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;



public class DailyPageFragment extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static DailyPageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        DailyPageFragment fragment = new DailyPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_daily_page, container, false);

        HoroscopeActivity activity = (HoroscopeActivity) getActivity();
        final String sign = activity.getMyData();

        final TextView textView1 = view.findViewById(R.id.textView1);
        final TextView textView2 = view.findViewById(R.id.textView2);
        final TextView textView3 = view.findViewById(R.id.textView3);
        final TextView text_date1= view.findViewById(R.id.date1);
        final TextView text_date2= view.findViewById(R.id.date2);
        final TextView text_date3= view.findViewById(R.id.date3);
        String tabTitles[] = new String[]{"sunsign", "food", "career", "love", "money", "wellness"};


        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String category = "" + tabTitles[mPage - 1];
        String url = "";
        url = "https://infinite-chamber-78657.herokuapp.com/" + category +"/"+ sign;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String yesterday = "";
                        String today = "";
                        String tomorrow = "";
                        String uyesterday="";
                        String utoday="";
                        String utomorrow="";
                        String date1="";
                        String date2="";
                        String date3="";
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            yesterday = jsonResponse.getJSONObject("yesterday").getString("horoscope");
                            today = jsonResponse.getJSONObject("today").getString("horoscope");
                            tomorrow = jsonResponse.getJSONObject("tomorrow").getString("horoscope");
                            uyesterday=yesterday.substring(13);
                            date1=yesterday.substring(0,12);
                            utoday=today.substring(13);
                            date2=today.substring(0,12);
                            utomorrow=tomorrow.substring(13);
                            date3=tomorrow.substring(0,12);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        textView1.setText(uyesterday);
                        text_date1.setText(date1);
                        textView2.setText(utoday);
                        text_date2.setText(date2);
                        textView3.setText(utomorrow);
                        text_date3.setText(date3);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView1.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
        //textView1.setText("Fragment #" + mPage);
        return view;
    }

}
