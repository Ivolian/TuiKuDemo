package com.example.administrator.tuikudemo.Activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.tuikudemo.Fragment.HotFragment;
import com.example.administrator.tuikudemo.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        HotFragment hotFragment = new HotFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, hotFragment).commit();
    }

    private void initToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("发现文章");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addListenerForToolbar(toolbar);
    }

    private void addListenerForToolbar(Toolbar toolbar) {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        RelativeLayout relativeLayout = (RelativeLayout) drawerLayout.findViewById(R.id.rl_left_article_hot);
        relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
        relativeLayout.setOnClickListener(this);

        findViewById(R.id.rl_left_article).setOnClickListener(this);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
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
            case R.id.rl_left_article:
                iWontProduct();
                break;
            case R.id.rl_left_article_hot:
                break;
        }
    }

    // ============================ other functions ============================

    // 我不会开发这个模块
    private void iWontProduct() {

        NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(this);
        dialogBuilder
                .withTitle("提示")
                .withMessage("该模块没人愿意开发。")
                .show();
    }

}
