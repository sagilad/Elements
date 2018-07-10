package com.flow8.elements;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private LinearLayout Dots_Layout;
    private ImageView[] dots;
    private SectionsPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dots_Layout = (LinearLayout)findViewById(R.id.dotsLayout);


        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        createDots(1);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager){
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyElementsActivity());
        adapter.addFragment(new HomeActivity());
        adapter.addFragment(new ExploreActivity());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }

    private void createDots(int current_position)
    {
        if(Dots_Layout != null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[adapter.getCount()];

        for(int i = 0; i<adapter.getCount(); i++ )
        {
            dots[i] = new ImageView(this);
            if(i==current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }

            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(18,0,18,0);

            Dots_Layout.addView(dots[i], params);
        }

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


}
