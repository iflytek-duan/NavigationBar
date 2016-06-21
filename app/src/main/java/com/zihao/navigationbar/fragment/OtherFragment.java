package com.zihao.navigationbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zihao.navigationbar.R;

/**
 * OtherFragment
 * Created by zihao on 2016/6/21 10:27.
 */
public class OtherFragment extends Fragment{

    private String mText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mText = getArguments().getString("title","");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other,container,false);
        initView(view);
        return view;
    }

    private void initView(View view){
        TextView titleTv = (TextView) view.findViewById(R.id.other_tv);
        titleTv.setText(mText);
    }

}