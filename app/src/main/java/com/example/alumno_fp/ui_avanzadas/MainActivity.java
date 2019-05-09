package com.example.alumno_fp.ui_avanzadas;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.alumno_fp.ui_avanzadas.Fragments.FirstWebFragment;
import com.example.alumno_fp.ui_avanzadas.Fragments.LoadWebFragment;
import com.example.alumno_fp.ui_avanzadas.Fragments.SecondWebFragment;
import com.example.alumno_fp.ui_avanzadas.Interfaces.SendUrl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SendUrl {


    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabs;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewpager);
        setUpViewPager(viewPager);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstWebFragment(), "FIRST WEB");
        adapter.addFragment(new SecondWebFragment(), "SECOND WEB");
        adapter.addFragment(new LoadWebFragment(), "LOAD WEB");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void sendData(String data, int position) {
        switch (position){
            case 0: {
                FirstWebFragment firstWebFragment = (FirstWebFragment) adapter.getItem(position);
                firstWebFragment.receivedUrl(data);
            }
            break;
            case 1: {
                SecondWebFragment secondWebFragment = (SecondWebFragment) adapter.getItem(position);
                secondWebFragment.receivedUrl(data);
            }
            break;
        }
    }

    static class FragmentAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
