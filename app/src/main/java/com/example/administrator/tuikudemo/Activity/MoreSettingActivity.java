package com.example.administrator.tuikudemo.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.administrator.tuikudemo.R;
import com.example.administrator.tuikudemo.Util.ActivityUtil;


public class MoreSettingActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_setting);
        initToolbar();
        initSpinner();
    }

    private void initToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("更多设置");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initSpinner(){

        ArrayAdapter<CharSequence> arrayAdapter =  ArrayAdapter.createFromResource(this, R.array.Font,
                android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                ActivityUtil.finishActivityWithAnim(this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
