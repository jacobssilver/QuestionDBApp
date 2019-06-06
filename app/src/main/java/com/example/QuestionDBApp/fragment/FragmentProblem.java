package com.example.QuestionDBApp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.QuestionDBApp.Exam;
import com.example.QuestionDBApp.ExamAdapter;
import com.example.QuestionDBApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProblem extends Fragment {

    private List<Exam> examList = new ArrayList<>();
    private List<Exam> exam2List = new ArrayList<>();
    public FragmentProblem() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_problem, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initExam();
        RecyclerView recyclerView = getActivity().findViewById(R.id.exam1_recycle);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),4);
        recyclerView.setLayoutManager(layoutManager);
        ExamAdapter examAdapter = new ExamAdapter(getActivity(),examList);
        recyclerView.setAdapter(examAdapter);

        initExam2();
        RecyclerView recyclerView2 = getActivity().findViewById(R.id.exam2_recycle);
        GridLayoutManager layoutManager2 = new GridLayoutManager(getActivity(),4);
        recyclerView2.setLayoutManager(layoutManager2);
        ExamAdapter examAdapter2 = new ExamAdapter(getActivity(),exam2List);
        recyclerView2.setAdapter(examAdapter2);
    }
    private void initExam(){
    Exam computer = new Exam("computer",R.drawable.computer);
    examList.add(computer);
    Exam computer2 = new Exam("computer",R.drawable.computer);
    examList.add(computer2);
    Exam computer3 = new Exam("computer",R.drawable.computer);
    examList.add(computer3);
    Exam computer4 = new Exam("computer",R.drawable.computer);
    examList.add(computer4);
    Exam computer5 = new Exam("computer",R.drawable.computer);
    examList.add(computer5);
        Exam computer6 = new Exam("computer",R.drawable.computer);
        examList.add(computer6);
        Exam computer7 = new Exam("computer",R.drawable.computer);
        examList.add(computer7);
        Exam computer8 = new Exam("computer",R.drawable.computer);
        examList.add(computer8);
        Exam computer9 = new Exam("computer",R.drawable.computer);
        examList.add(computer9);
        Exam computer10 = new Exam("computer",R.drawable.computer);
        examList.add(computer10);
    }
    private void initExam2(){
        Exam computer = new Exam("computer",R.drawable.computer);
        exam2List.add(computer);
        Exam computer2 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer2);
        Exam computer3 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer3);
        Exam computer4 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer4);
        Exam computer5 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer5);
        Exam computer6 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer6);
        Exam computer7 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer7);
        Exam computer8 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer8);
        Exam computer9 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer9);
        Exam computer10 = new Exam("computer",R.drawable.computer);
        exam2List.add(computer10);
    }
}
