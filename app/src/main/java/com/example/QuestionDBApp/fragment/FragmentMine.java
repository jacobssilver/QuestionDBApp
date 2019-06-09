package com.example.QuestionDBApp.fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.QuestionDBApp.AttentionActivity;
import com.example.QuestionDBApp.ClassActivity;
import com.example.QuestionDBApp.R;
import com.example.QuestionDBApp.RankActivity;
import com.example.QuestionDBApp.RankAdapter;
import com.example.QuestionDBApp.SecondActivity;
import com.example.QuestionDBApp.SettingActivity;
import com.example.QuestionDBApp.User;

import java.util.List;

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
        ConstraintLayout user_mine = getActivity().findViewById(R.id.user_mine);
        user_mine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
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
