package com.mango.myframe;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.mango.myframe.electives.ElectivesFragment;
import com.mango.myframe.homepage.HomePageFragment;
import com.mango.myframe.widget.CommonTabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String FONT_PATH = "fonts/fontawesome-webfont.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        ArrayList<String> tabTitles = new ArrayList<String>(){{
            add("首页");
            add("必修");
            add("选修");
            add("曲谱库");
            add("iTV");
            add("工具");
        }};
        ArrayList<Fragment> fragments = new ArrayList<Fragment>(){{
            add(new HomePageFragment());
            add(new HomePageFragment());
            add(new ElectivesFragment());
            add(new HomePageFragment());
            add(new HomePageFragment());
            add(new HomePageFragment());
        }};
        CommonTabLayout commonTabLayout = findViewById(R.id.common_tab);
        commonTabLayout.setTabData(tabTitles);
        commonTabLayout.setTabData(tabTitles, this, R.id.fl_fragment_container, fragments);
        commonTabLayout.setCurrentTab(0);
        TextView faUser = findViewById(R.id.tv_fa_user);
        Typeface font = Typeface.createFromAsset(getAssets(), FONT_PATH);
        faUser.setTypeface(font);
    }



}
