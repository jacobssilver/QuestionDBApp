package com.example.QuestionDBApp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.QuestionDBApp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentQ3 extends Fragment {


    public FragmentQ3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //int img = R.drawable.img_a;
        Bundle bundle = getArguments();
        int img = bundle.getInt("QuestionImg",R.drawable.head_icon);
        View view = inflater.inflate(R.layout.fragment_fragment_3q, container, false);
        ImageView questionimg = view.findViewById(R.id.Question_img);
        questionimg.setImageResource(img);
        return view;
    }

}
