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
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            yesterday = jsonResponse.getJSONObject("yesterday").getString("horoscope");
                            today = jsonResponse.getJSONObject("today").getString("horoscope");
                            tomorrow = jsonResponse.getJSONObject("tomorrow").getString("horoscope");

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        textView1.setText(yesterday);
                        textView2.setText(today);
                        textView3.setText(tomorrow);
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
