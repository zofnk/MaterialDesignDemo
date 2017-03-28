package com.zofnk.materialdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.zofnk.materialdesign.R;
import com.zofnk.materialdesign.adapter.MainPageAdapter;
import com.zofnk.materialdesign.fragment.FindFragment;
import com.zofnk.materialdesign.fragment.HomeFragment;
import com.zofnk.materialdesign.fragment.MineFragment;

public class TabActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mCollapsingToolBarLayout;
    private ImageView mIcon;
    private ViewPager mVp;
    private TabLayout mTabLayout;

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
        initViews();
        init();
    }

    private void initViews() {
        mVp = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mIcon = (ImageView) findViewById(R.id.imgIcon);
    }

    private void init() {
        mCollapsingToolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolBarLayout);
        mVp.setAdapter(new MainPageAdapter(getSupportFragmentManager(), mFragments, tabs));
        mTabLayout.setOnTabSelectedListener(new ViewPagerOnTabSelectedListener());
        mTabLayout.setupWithViewPager(mVp);
    }

    public void setToolBarBackground(@DrawableRes int resId) {
        mIcon.setImageResource(resId);
    }

    public void setToolbarTitle(String title) {
        mCollapsingToolBarLayout.setTitle(title);
    }

    private class ViewPagerOnTabSelectedListener extends TabLayout.ViewPagerOnTabSelectedListener {
        public ViewPagerOnTabSelectedListener() {
            super(TabActivity.this.mVp);
        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Log.e("onTabSelected : ", "" + tab.getPosition());
            switch (tab.getPosition()) {
                case 0:
                    setToolbarTitle("Home Detail");
//                        setToolBarBackground(R.mipmap.image);
                    break;
                case 1:
                    setToolbarTitle("Find Detail");
//                        setToolBarBackground(R.mipmap.image1);
                    break;
                case 2:
                    setToolbarTitle("Mine Detail");
//                        setToolBarBackground(R.mipmap.image);
                    break;
                default:
                    break;
            }
        }
    }
}
