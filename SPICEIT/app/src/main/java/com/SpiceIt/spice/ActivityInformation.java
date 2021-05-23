package com.SpiceIt.spice;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityInformation extends FragmentActivity  {

    private ViewPager viewPager;
    private ActionBar actionBar;
    private AdapterInformation tabPagerAdapter;
    private String  r = "Tips" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipetab);

        TextView i = new TextView(this);
        i.setText("Eat atleast one:");
        i.setTextColor(Color.BLACK);
        i.setTextSize(20);
        TextView k = new TextView(this);
        k.setText("1.A Yellow Banana ");
        ImageView simpleImageView= new ImageView(this) ;
        simpleImageView.setImageResource(R.drawable.yell);
        k.setTextColor(Color.BLUE);
        k.setTextSize(16);
        simpleImageView.setMaxHeight(8);
        simpleImageView.setMaxWidth(6);

        TextView w =new TextView(this);
        w.setText("2.Drink Juice");
        w.setTextSize(16);
        ImageView s= new ImageView(this) ;
        s.setImageResource(R.drawable.juice);
        s.setMaxWidth(18);
        s.setMaxHeight(14);
        w.setTextColor(Color.BLUE);
        TextView p =new TextView(this);
        p.setText("3.Greens and Vegetables ");
        p.setTextSize(16);
        p.setTextColor(Color.BLUE);
        ImageView si= new ImageView(this) ;
        si.setImageResource(R.drawable.veg);

        actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.header)));
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.header)));

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(i);
        ll.addView(k);
        ll.addView(simpleImageView);
        ll.addView(w);
        ll.addView(s);
        ll.addView(p);
        ll.addView(si);

        setContentView(ll);


    }
}