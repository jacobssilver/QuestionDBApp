package com.example.QuestionDBApp.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.QuestionDBApp.AttentionActivity;
import com.example.QuestionDBApp.ClassActivity;
import com.example.QuestionDBApp.R;
import com.example.QuestionDBApp.RankActivity;
import com.example.QuestionDBApp.User_PageActivity;
import com.example.QuestionDBApp.SettingActivity;
import com.example.QuestionDBApp.StaticsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMine extends Fragment {


    public FragmentMine() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView prorecord = getActivity().findViewById(R.id.problem_record);
        TextView prowrong = getActivity().findViewById(R.id.problem_wrong);

        prorecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StaticsActivity.class);
                startActivity(intent);
            }
        });
        prowrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClassActivity.class);
                startActivity(intent);
            }
        });


        ConstraintLayout user_mine = getActivity().findViewById(R.id.user_mine);
        user_mine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), User_PageActivity.class);
                startActivity(intent);
            }
        });
        ConstraintLayout rank_list = getActivity().findViewById(R.id.top_view);
        rank_list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RankActivity.class);
                startActivity(intent);
            }
        });
        ConstraintLayout statics = getActivity().findViewById(R.id.statics_view);
        statics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StaticsActivity.class);
                startActivity(intent);
            }
        });
        ConstraintLayout attention = getActivity().findViewById(R.id.attention_view);
        attention.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AttentionActivity.class);
                startActivity(intent);
            }
        });
        ConstraintLayout setting = getActivity().findViewById(R.id.set_view);
        setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
    }


}
