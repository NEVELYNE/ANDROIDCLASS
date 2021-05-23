package com.SpiceIt.spice;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityProfile extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    private ActionBar actionBar;
    private AdapterProfile tabPagerAdapter;
    private String[] tabs = { "About Us" };
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar = getActionBar();
        actionBar = getActionBar();
        actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.header)));
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.header)));
        actionBar.setTitle("Profile");

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
        ImageView prof= new ImageView(this) ;
        prof.setImageResource(R.drawable.eve);

        TextView j = new TextView(this);
        j.setText("             Nakanwagi Evelyne");
        j.setTextAlignment(20);
        j.setTextSize(20);
        j.setTextColor(Color.BLUE);

        TextView w= new TextView(this);
        w.setText("  2018bcs004@std.must.ac.ug");
        w.setTextAlignment(16);
        w.setTextSize(20);
        w.setTextColor(Color.CYAN);

        TextView t = new TextView(this);
        t.setText("                   0787490040");
        t.setTextAlignment(20);
        t.setTextSize(20);
        t.setTextColor(Color.BLUE);

        ImageView phil= new ImageView(this) ;
        phil.setImageResource(R.drawable.phil);

        TextView h = new TextView(this);
        h.setText("             Ahimbisibwe Phillip");
        h.setTextAlignment(20);
        h.setTextSize(20);
        h.setTextColor(Color.BLUE);

        TextView wi= new TextView(this);
        wi.setText("  2017bce002@std.must.ac.ug");
        wi.setTextAlignment(16);
        wi.setTextSize(20);
        wi.setTextColor(Color.CYAN);

        TextView ti = new TextView(this);
        ti.setText("                   0776227647");
        ti.setTextAlignment(20);
        ti.setTextSize(20);
        ti.setTextColor(Color.BLUE);



        LinearLayout ll = new LinearLayout(this);

        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(prof);
        ll.addView(w);
        ll.addView(j);
        ll.addView(t);
        ll.addView(phil);

        ll.addView(wi);
        ll.addView(ti);
        ll.addView(h);

        setContentView(ll);
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }
}