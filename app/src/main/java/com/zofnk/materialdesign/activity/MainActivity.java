package com.zofnk.materialdesign.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zofnk.materialdesign.OnItemClickListener;
import com.zofnk.materialdesign.R;
import com.zofnk.materialdesign.adapter.MainAdapter;

import static android.support.design.widget.Snackbar.make;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView mNavigationView;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionButton;
    private FloatingActionButton mFloatingActionButton2;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_2:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_3:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    private void initViews() {
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingActionButton2 = (FloatingActionButton) findViewById(R.id.fab2);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolBarLayout);
    }

    private void init() {
        setSupportActionBar(mToolBar);
        setToolbarTitle("Demo");
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerlayout,
                mToolBar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerlayout.setDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener());
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditActivity.start(MainActivity.this);
            }
        });
        mFloatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(mCollapsingToolbarLayout, "哈喽~", Snackbar.LENGTH_SHORT)
                        .setAction("快点这里", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                make(mCollapsingToolbarLayout, "啊~啊~~", Snackbar.LENGTH_SHORT).show();
                            }
                        });
                ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.YELLOW);
                snackbar.getView().setBackgroundResource(R.drawable.bg_snackbar);
                snackbar.show();
            }
        });
        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        MainAdapter mainAdapter = new MainAdapter(this);
        mRecyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListence(new OnItemClickListener() {
            @Override
            public void setOnclickListence(View view, int position) {
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                        view.findViewById(R.id.imgMain), MainActivity.this.getString(R.string.transition_book_img));
                ActivityCompat.startActivity(MainActivity.this,
                        new Intent(MainActivity.this, TabActivity.class)
                        , options.toBundle());
            }
        });
    }

    public void setToolbarTitle(String title) {
        mCollapsingToolbarLayout.setTitle(title);
    }

    private class OnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_blog:
                    Toast.makeText(MainActivity.this, "blog", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_about:
                    Toast.makeText(MainActivity.this, "about", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_version:
                    Toast.makeText(MainActivity.this, "version", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_sub1:
                    Toast.makeText(MainActivity.this, "sub1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_sub2:
                    Toast.makeText(MainActivity.this, "sub2", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return true;
        }
    }
}
