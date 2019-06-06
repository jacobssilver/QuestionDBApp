package com.example.QuestionDBApp.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.QuestionDBApp.Exam;
import com.example.QuestionDBApp.ExamAdapter;
import com.example.QuestionDBApp.R;
import com.example.QuestionDBApp.SecondActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHomepage extends Fragment {


    //memo
    private String[] memodata = {"距四六级考试还有20天","距期末考试还有30天","距四六级考试还有20天","距期末考试还有30天","距四六级考试还有20天","距期末考试还有30天"};
    List<String> list = Arrays.asList(memodata);
    List memoList = new ArrayList(list);
    ArrayAdapter<String> memoadapter ;
    View memocontentView;

//    list
    private List<Exam> exam_main_List = new ArrayList<>();
    public FragmentHomepage() {
        // Required empty public constructor
    }

    public  void onStart(){
        super.onStart();
    }
    public  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        memocontentView =  inflater.inflate(R.layout.fragment_homepage, container, false);
        return memocontentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //banner
        Banner banner = getActivity().findViewById(R.id.banner_home);
        List<Integer> bannerimg = new ArrayList<>();
        bannerimg.add(R.drawable.img_a );
        bannerimg.add(R.drawable.img_b );
        bannerimg.add(R.drawable.img_c );

        banner.setImages(bannerimg)//设置图集
                .setDelayTime(3000)//轮播间隔时间
                .setImageLoader(new GlideImageLoader())//设置图片加载器
                .start();

        //user_home
        ConstraintLayout user = getActivity().findViewById(R.id.user_home);
        user.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });


        //memo
        memoadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,memoList);
        ListView memolist = getActivity().findViewById(R.id.memoList);
        memolist.setAdapter(memoadapter);
        memolist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                //定义AlertDialog.Builder对象，当长按列表项的时候弹出确认删除对话框
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

                builder.setMessage("确定删除?");
                builder.setTitle("提示");

                //添加AlertDialog.Builder对象的setPositiveButton()方法
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(memoList.remove(position)!=null){
                            System.out.println("success");
                        }else {
                            System.out.println("failed");
                        }
                        memoadapter.notifyDataSetChanged();
                        Toast.makeText(getActivity(), "删除列表项", Toast.LENGTH_SHORT).show();

                    }
                });

                //添加AlertDialog.Builder对象的setNegativeButton()方法
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();
                return false;
            }
        });

//        list
        initExam();
        RecyclerView recyclerView = getActivity().findViewById(R.id.exam_main_recycle);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),4);
        recyclerView.setLayoutManager(layoutManager);
        ExamAdapter examAdapter = new ExamAdapter(getActivity(),exam_main_List);
        recyclerView.setAdapter(examAdapter);

    }
    //banner 图片加载器
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    private void initExam(){
        Exam computer = new Exam("computer",R.drawable.computer);
        exam_main_List.add(computer);
        Exam computer2 = new Exam("computer",R.drawable.computer);
        exam_main_List.add(computer2);
        Exam computer3 = new Exam("computer",R.drawable.computer);
        exam_main_List.add(computer3);
        Exam computer4 = new Exam("computer",R.drawable.computer);
        exam_main_List.add(computer4);
        Exam computer5 = new Exam("computer",R.drawable.computer);
        exam_main_List.add(computer5);

    }
}
