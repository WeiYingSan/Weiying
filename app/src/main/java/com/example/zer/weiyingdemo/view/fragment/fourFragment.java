package com.example.zer.weiyingdemo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.view.activity.SettingActivity;

public class fourFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView four_set;
    private RelativeLayout four_relative1;
    private RelativeLayout four_relative2;
    private RelativeLayout four_relative3;
    private RelativeLayout four_relative4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fourfragment, null);

        initView();
        initData();

        return view;
    }

    private void initData() {
        four_set.setOnClickListener(this);
        four_relative2.setOnClickListener(this);
    }

    private void initView() {
        four_set = view.findViewById(R.id.four_set);
        four_relative1 = view.findViewById(R.id.four_relative1);
        four_relative2 = view.findViewById(R.id.four_relative2);
        four_relative3 = view.findViewById(R.id.four_relative3);
        four_relative4 = view.findViewById(R.id.four_relative4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.four_set:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.four_relative2:
                Toast.makeText(getActivity(),"敬请期待",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
