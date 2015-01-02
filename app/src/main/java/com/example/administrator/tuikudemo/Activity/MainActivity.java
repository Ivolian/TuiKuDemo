package com.example.administrator.tuikudemo.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.administrator.tuikudemo.Fragment.HotFragment;
import com.example.administrator.tuikudemo.Fragment.TopicFragment;
import com.example.administrator.tuikudemo.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;

    View sideMenuItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbarAndDrawerLayout();
        addOnClickListenersForSideMenu();
        initHotFragment();
    }

    private void initToolbarAndDrawerLayout() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("发现文章");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 联动两者
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    private void addOnClickListenersForSideMenu() {

        findViewById(R.id.rl_left_article).setOnClickListener(this);
        findViewById(R.id.rl_left_article_hot).setOnClickListener(this);
        findViewById(R.id.rl_left_topic).setOnClickListener(this);
        findViewById(R.id.rl_left_site).setOnClickListener(this);
        findViewById(R.id.rl_left_search).setOnClickListener(this);
        findViewById(R.id.rl_left_offline).setOnClickListener(this);
        findViewById(R.id.rl_left_setting).setOnClickListener(this);
    }

    private void initHotFragment() {

        selectSideMenuItem(R.id.rl_left_article_hot);
        sideMenuItemSelected = findViewById(R.id.rl_left_article_hot);
        addFragment(new HotFragment());
    }

    // ============================ onCreateOptionsMenu ============================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // ============================ onClick ============================

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            // 推荐
            case R.id.rl_left_article:
                noOneProductThisModule();
                break;

            // 发现
            case R.id.rl_left_article_hot:
                changeToHot();
                break;

            // 主题
            case R.id.rl_left_topic:
                changeToTopic();
                break;

            // 搜索
            case R.id.rl_left_search:
                noOneProductThisModule();
                break;
        }
    }

    // ============================ other functions ============================

    private void noOneProductThisModule() {

        NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(this);
        dialogBuilder
                .withTitle("提示")
                .withMessage("该模块没人愿意开发。")
                .show();
    }

    private void replaceFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }

    private void addFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();
    }

    private void selectSideMenuItem(int relativeLayoutId) {

        findViewById(relativeLayoutId).setBackgroundColor(getResources().getColor(R.color.green));
    }

    private void unSelectSideMenuItem() {

        sideMenuItemSelected.setBackgroundResource(R.drawable.drawer_menu_selector);
    }

    private void changeToHot() {

        unSelectSideMenuItem();
        selectSideMenuItem(R.id.rl_left_article_hot);
        sideMenuItemSelected = findViewById(R.id.rl_left_article_hot);
        replaceFragment(new HotFragment());
        drawerLayout.closeDrawers();
    }

    private void changeToTopic() {

        unSelectSideMenuItem();
        selectSideMenuItem(R.id.rl_left_topic);
        sideMenuItemSelected = findViewById(R.id.rl_left_topic);
        replaceFragment(new TopicFragment());
        drawerLayout.closeDrawers();
    }

}
