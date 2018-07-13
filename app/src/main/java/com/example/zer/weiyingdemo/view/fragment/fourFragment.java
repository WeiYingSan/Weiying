package com.example.zer.weiyingdemo.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.example.zer.weiyingdemo.R;
import com.example.zer.weiyingdemo.view.activity.SettingActivity;
import com.example.zer.weiyingdemo.view.activity.ShouCangActivity;

import static android.content.Context.MODE_PRIVATE;

public class fourFragment extends Fragment implements View.OnClickListener,ColorChooserDialog.ColorCallback {

    private View view;
    private ImageView four_set;
    private RelativeLayout four_relative1;
    private RelativeLayout four_relative2;
    private RelativeLayout four_relative3;
    private RelativeLayout four_relative4;
    private LinearLayout four_line;
    private SharedPreferences user;

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
        four_relative3.setOnClickListener(this);
        four_relative4.setOnClickListener(this);
    }

    private void initView() {
        four_set = view.findViewById(R.id.four_set);
        four_relative1 = view.findViewById(R.id.four_relative1);
        four_relative2 = view.findViewById(R.id.four_relative2);
        four_relative3 = view.findViewById(R.id.four_relative3);
        four_relative4 = view.findViewById(R.id.four_relative4);
        four_line = view.findViewById(R.id.four_line);

        user = getActivity().getSharedPreferences("User", MODE_PRIVATE);
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
            case R.id.four_relative3:
                Intent intent1 = new Intent(getActivity(), ShouCangActivity.class);
                startActivity(intent1);
                break;
            case R.id.four_relative4:
                //颜色的数组
                int[] primary = new int[]{
                        Color.parseColor("#F44336"),
                        Color.parseColor("#FF0000"),
                        Color.parseColor("#FFFF00"),
                        Color.parseColor("#00FF00"),
                        Color.parseColor("#0000FF"),
                        Color.parseColor("#00FFFF"),
                        Color.parseColor("#FF00FF"),
                        Color.parseColor("#ff6600"),
                        Color.parseColor("#ff9966"),
                        Color.parseColor("#cc0000"),
                        Color.parseColor("#993399"),
                        Color.parseColor("#cc6699"),
                        Color.parseColor("#ffccff"),
                        Color.parseColor("#cc66cc"),
                        Color.parseColor("#cc33cc"),
                        Color.parseColor("#00ff33"),
                        Color.parseColor("#3399cc"),
                        Color.parseColor("#0066ff"),
                        Color.parseColor("#0099ff"),
                        Color.parseColor("#00cc99"),
                };
                //有些按钮是系统默认的
                new ColorChooserDialog.Builder(getActivity(), R.string.color_palette)
                        .accentMode(true)//
                        .customColors(primary, null)//两个颜色数组
                        .dynamicButtonColor(true)//动态按钮颜色
                        .customButton(0)//设置颜色不显示
                        .cancelButton(R.string.cancle)
                        .doneButton(R.string.done)
                        .show(getActivity());//传入上下文
                break;
        }
    }
    //颜色选择改变事件
    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {
        four_relative4.setBackgroundColor(selectedColor);
        four_line.setBackgroundColor(selectedColor);

        user.edit().putInt("color",selectedColor).commit();
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {
    }
}
