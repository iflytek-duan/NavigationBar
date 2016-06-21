package com.zihao.navigationbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.zihao.navigationbar.adapter.TabFragmentAdapter;
import com.zihao.navigationbar.fragment.OtherFragment;

import java.util.ArrayList;

/**
 * MainActivity
 * @author zihao by 2016年6月21日10:16:06
 * @version v1.0.1
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private String[] mTitles = new String[]{"女装","男装","儿童","鞋品","居家生活","美食茶酒",
            "数码产品","内衣","美妆配饰","文娱运动","家纺家织"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        initViewPager();
    }

    private void initViewPager() {
        ArrayList<Fragment> fragmentList = new ArrayList<>();

        for (String title : mTitles) {
            OtherFragment otherFragment = new OtherFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            otherFragment.setArguments(bundle);
            fragmentList.add(otherFragment);
        }

        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(),
                fragmentList, mTitles);
        mViewPager.setAdapter(tabFragmentAdapter);

        // 初始化
        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        // 将ViewPager和TabLayout绑定
        tablayout.setupWithViewPager(mViewPager);
        // 设置tab文本的没有选中（第一个参数）和选中（第二个参数）的颜色
        tablayout.setTabTextColors(0xff518235, Color.WHITE);
    }


}