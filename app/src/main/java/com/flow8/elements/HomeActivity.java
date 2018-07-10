package com.flow8.elements;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;

/**
 * Created by GILADSAG on 9/19/2017.
 */

public class HomeActivity extends Fragment{
    ImageButton woodBtn, fireBtn, earthBtn, metalBtn, waterBtm, myElemBtn, exploreBtn, qBtn;
    private ViewPager mViewPager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home,container,false);
        woodBtn = (ImageButton)view.findViewById(R.id.woodBtn);
        fireBtn = (ImageButton)view.findViewById(R.id.fireBtn);
        earthBtn = (ImageButton)view.findViewById(R.id.earthBtn);
        metalBtn = (ImageButton)view.findViewById(R.id.metalBtn);
        waterBtm = (ImageButton)view.findViewById(R.id.waterBtn);

        myElemBtn = (ImageButton)view.findViewById(R.id.myElemBtn);
        exploreBtn = (ImageButton)view.findViewById(R.id.exploreBtn);

        qBtn = (ImageButton)view.findViewById(R.id.qBtn);

        mViewPager = (ViewPager) getActivity().findViewById(R.id.container);

        animate_qMark();


        myElemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);

            }
        });

        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
            }
        });

        qBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Intent i = new Intent(getContext(), preQuestionsActivity.class);
                startActivity(i);
            }
        });


        woodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Intent i = new Intent(getContext(), WoodActivity.class);
                startActivity(i);
            }
        });

        fireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Intent i = new Intent(getContext(), FireActivity.class);
                startActivity(i);
            }
        });

        earthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Intent i = new Intent(getContext(), EarthActivity.class);
                startActivity(i);
            }
        });

        metalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Intent i = new Intent(getContext(), MetalActivity.class);
                startActivity(i);
            }
        });

        waterBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Intent i = new Intent(getContext(), WaterActivity.class);
                startActivity(i);
            }
        });

        return view;

    }

    private void animate_qMark()
    {
        final ScaleAnimation growAnim = new ScaleAnimation(1.0f, 1.45f, 1.0f, 1.45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        final ScaleAnimation shrinkAnim = new ScaleAnimation(1.45f, 1.0f, 1.45f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        growAnim.setDuration(1600);
        shrinkAnim.setDuration(1600);

        qBtn.setAnimation(growAnim);
        growAnim.start();

        growAnim.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation){}

            @Override
            public void onAnimationRepeat(Animation animation){}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                qBtn.setAnimation(shrinkAnim);
                shrinkAnim.start();
            }
        });
        shrinkAnim.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation){}

            @Override
            public void onAnimationRepeat(Animation animation){}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                qBtn.setAnimation(growAnim);
                growAnim.start();
            }
        });
    }
}
