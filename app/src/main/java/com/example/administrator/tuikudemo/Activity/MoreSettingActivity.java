package com.example.administrator.tuikudemo.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.administrator.tuikudemo.R;


public class MoreSettingActivity extends GeneralActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_setting);
        initToolbar("更多设置");
        initSpinner();
    }

    private void initSpinner() {

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Font,
                android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
    }

}
