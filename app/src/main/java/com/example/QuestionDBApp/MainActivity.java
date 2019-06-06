package com.example.QuestionDBApp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.QuestionDBApp.fragment.FragmentForum;
import com.example.QuestionDBApp.fragment.FragmentHomepage;
import com.example.QuestionDBApp.fragment.FragmentMine;
import com.example.QuestionDBApp.fragment.FragmentProblem;


public class MainActivity extends AppCompatActivity {

    private FragmentHomepage fragment1 = new FragmentHomepage();
    private FragmentProblem fragment2;
    private FragmentForum fragment3;
    private FragmentMine fragment4;
    private Fragment[] fragments;
    private  int lastfragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(lastfragment!=0){
                        switchFragment(lastfragment,0);
                        lastfragment = 0;
                    }
                    return true;
                case R.id.navigation_dashboard:
                    if(lastfragment!=1){
                        switchFragment(lastfragment,1);
                        lastfragment = 1;
                    }
                    return true;
                case R.id.navigation_notifications:
                    if(lastfragment!=2){
                        switchFragment(lastfragment,2);
                        lastfragment = 2;
                    }
                    return true;
                case R.id.mine:
                    if(lastfragment!=3){
                        switchFragment(lastfragment,3);
                        lastfragment = 3;
                    }
                    return true;
            }
            return false;
        }
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main , fragment1).show(fragment1).commit();
        initfragment();
        lastfragment = 0;
    }

    private void initfragment(){

        fragment2 = new FragmentProblem();
        fragment3 = new FragmentForum();
        fragment4 = new FragmentMine();
        fragments = new Fragment[]{fragment1,fragment2,fragment3,fragment4};
    }

    private void switchFragment(int lastfragment, int index){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);
        if(!fragments[index].isAdded()){
            transaction.add(R.id.fragment_main,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

}
