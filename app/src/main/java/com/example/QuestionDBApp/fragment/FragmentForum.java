package com.example.QuestionDBApp.fragment;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.QuestionDBApp.Forum;
import com.example.QuestionDBApp.ForumAdapter;
import com.example.QuestionDBApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentForum extends Fragment {
    private List<Forum> forumList = new ArrayList<>();
    public FragmentForum() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forum, container, false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //prolist
        initForum();
        final RecyclerView recyclerView = getActivity().findViewById(R.id.forum_recycle);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        final ForumAdapter forumAdapter = new ForumAdapter(getActivity(),forumList);
        recyclerView.setAdapter(forumAdapter);



        //search
        SearchView forum_search = getActivity().findViewById(R.id.forum_search);
        forum_search.setIconifiedByDefault(false);
        forum_search.setSubmitButtonEnabled(true);
        forum_search.setQueryHint("查找");
        forum_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //submit
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(getActivity(), "123", Toast.LENGTH_SHORT).show();
                return false;
            }
            //input
            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });

        //write
        Button write = getActivity().findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                final AlertDialog dialog = builder.create();
                View dialogView = View.inflate(getContext(),R.layout.question,null);
                dialog.setView(dialogView);
                dialog.show();
                final EditText title = dialogView.findViewById(R.id.question_title);
                final EditText explain = dialogView.findViewById(R.id.question_explain);
                Button btn_confirm = dialogView.findViewById(R.id.btn_confirm);
                Button btn_cancel = dialogView.findViewById(R.id.btn_cancel);

                btn_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Title = title.getText().toString();
                        String Explain = explain.getText().toString();
                        Forum forum = new Forum(Title,Explain,"0赞0评论");
                        forumList.add(forum);
                        forumAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    public void initForum(){
        Forum forum1 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum2 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum3 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum4 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum5 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum6 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum7 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum8 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");
        Forum forum9 = new Forum("帖子标题","这里是帖子描述。我是一个特别厉害的帖子哈哈哈。达瓦里希·乌拉！巴巴莎~~","999赞·999评论");

        forumList.add(forum1);
        forumList.add(forum2);
        forumList.add(forum3);
        forumList.add(forum4);
        forumList.add(forum5);
        forumList.add(forum6);
        forumList.add(forum7);
        forumList.add(forum8);
        forumList.add(forum9);
    }


}
