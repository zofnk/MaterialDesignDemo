package com.zofnk.materialdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zofnk.materialdesign.R;
import com.zofnk.materialdesign.adapter.MainPageAdapter;
import com.zofnk.materialdesign.fragment.FindFragment;
import com.zofnk.materialdesign.fragment.HomeFragment;
import com.zofnk.materialdesign.fragment.MineFragment;

public class TabActivity extends AppCompatActivity {

    private Toolbar mToolBar;

    public static void start(Context context) {
        Intent starter = new Intent(context, TabActivity.class);
        context.startActivity(starter);
    }

    private Fragment[] mFragments = new Fragment[]{
            HomeFragment.newInstance(),
            FindFragment.newInstance(),
            MineFragment.newInstance()
    };

    private String[] tabs = {
            "Home",
            "Find",
            "Mine"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ViewPager vp = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setTitle("Detial Info");
        vp.setAdapter(new MainPageAdapter(getSupportFragmentManager(), mFragments, tabs));
        tabLayout.setupWithViewPager(vp);
    }
}