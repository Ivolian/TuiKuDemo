package com.example.administrator.tuikudemo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.tuikudemo.Activity.FeedbackActivity;
import com.example.administrator.tuikudemo.Activity.MoreSettingActivity;
import com.example.administrator.tuikudemo.R;
import com.example.administrator.tuikudemo.Util.ActivityUtil;


public class SettingFragment extends Fragment implements View.OnClickListener {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        addOnClickListeners(
                R.id.rl_more_setting, R.id.rl_feedback
        );

        return rootView;
    }

    private void addOnClickListeners(int... relativeLayoutIds) {

        for (int id : relativeLayoutIds) {
            rootView.findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.rl_more_setting:
                ActivityUtil.startActivityWithAnim(getActivity(), MoreSettingActivity.class);
                break;

            case R.id.rl_feedback:
                ActivityUtil.startActivityWithAnim(getActivity(), FeedbackActivity.class);
                break;
        }
    }

}
