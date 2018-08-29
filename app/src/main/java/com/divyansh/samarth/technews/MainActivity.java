package com.divyansh.samarth.technews;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        Intent intent = getIntent();
        String site = intent.getStringExtra("key");
        if (site.equals("cnet")){
            toolbar.setBackgroundColor(Color.RED);
            toolbar.setLogo(getDrawable(R.drawable.cnet));
            tabLayout.setBackgroundColor(Color.RED);
            tabLayout.addTab(tabLayout.newTab().setText("All"));
            tabLayout.addTab(tabLayout.newTab().setText("News"));
            tabLayout.addTab(tabLayout.newTab().setText("Reviews"));
            tabLayout.addTab(tabLayout.newTab().setText("Android Update"));
            tabLayout.addTab(tabLayout.newTab().setText("Gaming"));
            tabLayout.addTab(tabLayout.newTab().setText("Cheapskate"));
            tabLayout.addTab(tabLayout.newTab().setText("Smart Home"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"cnet");
        }
        if(site.equals("techcrunch")){
            toolbar.setLogo(getDrawable(R.drawable.techcrunch));
            toolbar.setBackgroundColor(Color.parseColor("#FF26BA08"));
            tabLayout.setBackgroundColor(Color.parseColor("#FF26BA08"));
            tabLayout.addTab(tabLayout.newTab().setText("All"));
            tabLayout.addTab(tabLayout.newTab().setText("Social"));
            tabLayout.addTab(tabLayout.newTab().setText("Mobile"));
            tabLayout.addTab(tabLayout.newTab().setText("Enterprises"));
            tabLayout.addTab(tabLayout.newTab().setText("Startup"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"techcrunch");
        }
        if(site.equals("techradar")){
            toolbar.setLogo(getDrawable(R.drawable.techradar));
            toolbar.setBackgroundColor(Color.parseColor("#FF037094"));
            tabLayout.setBackgroundColor(Color.parseColor("#FF037094"));
            tabLayout.addTab(tabLayout.newTab().setText("All"));
            tabLayout.addTab(tabLayout.newTab().setText("Computing"));
            tabLayout.addTab(tabLayout.newTab().setText("Gaming"));
            tabLayout.addTab(tabLayout.newTab().setText("Mobile"));
            tabLayout.addTab(tabLayout.newTab().setText("Intenet"));
            tabLayout.addTab(tabLayout.newTab().setText("Networking"));
            tabLayout.addTab(tabLayout.newTab().setText("Software"));
            tabLayout.addTab(tabLayout.newTab().setText("Reviews"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"techradar");

        }
        if(site.equals("dataquest")){
            toolbar.setLogo(getDrawable(R.drawable.dataquest));
            toolbar.setBackgroundColor(Color.parseColor("#1E91C8"));
            tabLayout.setBackgroundColor(Color.parseColor("#1E91C8"));
            tabLayout.addTab(tabLayout.newTab().setText("All"));
            tabLayout.addTab(tabLayout.newTab().setText("News"));
            tabLayout.addTab(tabLayout.newTab().setText("DQtop20"));
            tabLayout.addTab(tabLayout.newTab().setText("Analytics"));
            tabLayout.addTab(tabLayout.newTab().setText("Big Data"));
            tabLayout.addTab(tabLayout.newTab().setText("Cloud"));
            tabLayout.addTab(tabLayout.newTab().setText("Data Center"));
            tabLayout.addTab(tabLayout.newTab().setText("Features"));
            tabLayout.addTab(tabLayout.newTab().setText("Internet"));
            tabLayout.addTab(tabLayout.newTab().setText("Mobility"));
            tabLayout.addTab(tabLayout.newTab().setText("Networking"));
            tabLayout.addTab(tabLayout.newTab().setText("Security"));
            tabLayout.addTab(tabLayout.newTab().setText("Software"));
            tabLayout.addTab(tabLayout.newTab().setText("Social Media"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"dataquest");
        }
        if(site.equals("gadget360")){
            toolbar.setLogo(getDrawable(R.drawable.gadget360));
            toolbar.setBackgroundColor(Color.RED);
            tabLayout.setBackgroundColor(Color.RED);
            tabLayout.addTab(tabLayout.newTab().setText("All"));
            tabLayout.addTab(tabLayout.newTab().setText("News"));
            tabLayout.addTab(tabLayout.newTab().setText("Entertainment"));
            tabLayout.addTab(tabLayout.newTab().setText("360 Daily"));
            tabLayout.addTab(tabLayout.newTab().setText("Gaming"));
            tabLayout.addTab(tabLayout.newTab().setText("Review"));
            tabLayout.addTab(tabLayout.newTab().setText("Mobiles"));
            tabLayout.addTab(tabLayout.newTab().setText("Features"));
            tabLayout.addTab(tabLayout.newTab().setText("Internet"));
            tabLayout.addTab(tabLayout.newTab().setText("Telecom"));
            tabLayout.addTab(tabLayout.newTab().setText("Polls"));
            tabLayout.addTab(tabLayout.newTab().setText("How to"));
            tabLayout.addTab(tabLayout.newTab().setText("India-top"));
            tabLayout.addTab(tabLayout.newTab().setText("Social"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"gadget360");
        }
        if(site.equals("pcquest")){
            toolbar.setLogo(getDrawable(R.drawable.pcquest));
            toolbar.setBackgroundColor(Color.parseColor("#CEC40E"));
            tabLayout.setBackgroundColor(Color.parseColor("#CEC40E"));
            tabLayout.addTab(tabLayout.newTab().setText("Community"));
            tabLayout.addTab(tabLayout.newTab().setText("Cloud Computing"));
            tabLayout.addTab(tabLayout.newTab().setText("Mobile"));
            tabLayout.addTab(tabLayout.newTab().setText("Technology Explained"));
            tabLayout.addTab(tabLayout.newTab().setText("Startup"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"pcquest");
        }
        if(site.equals("pcquest")){
            toolbar.setLogo(getDrawable(R.drawable.pcquest));
            toolbar.setBackgroundColor(Color.parseColor("#CEC40E"));
            tabLayout.setBackgroundColor(Color.parseColor("#CEC40E"));
            tabLayout.addTab(tabLayout.newTab().setText("Community"));
            tabLayout.addTab(tabLayout.newTab().setText("Cloud Computing"));
            tabLayout.addTab(tabLayout.newTab().setText("Mobile"));
            tabLayout.addTab(tabLayout.newTab().setText("Technology Explained"));
            tabLayout.addTab(tabLayout.newTab().setText("Startup"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"pcquest");
        }
        if(site.equals("opensource")){
            toolbar.setLogo(getDrawable(R.drawable.opensource));
            toolbar.setBackgroundColor(Color.parseColor("#690BF8"));
            tabLayout.setBackgroundColor(Color.parseColor("#690BF8"));
            tabLayout.addTab(tabLayout.newTab().setText("All"));
            tabLayout.addTab(tabLayout.newTab().setText("Developers"));
            tabLayout.addTab(tabLayout.newTab().setText("IT-Admin"));
            tabLayout.addTab(tabLayout.newTab().setText("CXOS"));
            tabLayout.addTab(tabLayout.newTab().setText("HOW-TOS"));
            tabLayout.addTab(tabLayout.newTab().setText("Basics"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"opensource");
        }
        if(site.equals("androidauthority")){
            toolbar.setLogo(getDrawable(R.drawable.androidauthority));
            toolbar.setBackgroundColor(Color.parseColor("#3B393E"));
            tabLayout.setBackgroundColor(Color.parseColor("#3B393E"));
            tabLayout.addTab(tabLayout.newTab().setText("All"));
            tabLayout.addTab(tabLayout.newTab().setText("News"));
            tabLayout.addTab(tabLayout.newTab().setText("Android-Development"));
            tabLayout.addTab(tabLayout.newTab().setText("Reviews"));
            tabLayout.addTab(tabLayout.newTab().setText("Apps & Games"));
            tabLayout.addTab(tabLayout.newTab().setText("How To"));
            pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),"androidauthority");
        }
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout
        ));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}

