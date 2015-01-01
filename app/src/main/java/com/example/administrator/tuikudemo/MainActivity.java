package com.example.administrator.tuikudemo;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
    }

    private void initToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("发现文章");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addListenerForToolbar(toolbar);
    }

    private void addListenerForToolbar(Toolbar toolbar) {

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    // ============================ menu ============================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
