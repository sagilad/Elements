package com.flow8.elements;

import android.content.Context;
import android.content.SharedPreferences;
import android.print.PrintAttributes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;

/**
 * Created by GILADSAG on 9/19/2017.
 */

public class MyElementsActivity extends Fragment{
    private static final String TAG = "SettingsFragment";
    String name;
    int earthScore, fireScore, metalScore, waterScore, woodScore;
    TextView earthTxt, fireTxt, metalTxt, waterTxt, woodTxt;

    TextView yourNameTxt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_elements,container,false);
        yourNameTxt = (TextView)view.findViewById(R.id.yourNameTxt);
        SharedPreferences scores = getContext().getSharedPreferences("scores", Context.MODE_PRIVATE);
        name = scores.getString("name", "Elements are not set yet");

        earthScore = scores.getInt("earthScore", 0);
        fireScore = scores.getInt("fireScore", 0);
        metalScore = scores.getInt("metalScore", 0);
        waterScore = scores.getInt("waterScore", 0);
        woodScore = scores.getInt("woodScore", 0);

        earthTxt = (TextView)view.findViewById(R.id.earthTxt);
        fireTxt = (TextView)view.findViewById(R.id.fireTxt);
        metalTxt = (TextView)view.findViewById(R.id.metalTxt);
        waterTxt = (TextView)view.findViewById(R.id.waterTxt);
        woodTxt = (TextView)view.findViewById(R.id.woodTxt);

        IconRoundCornerProgressBar earthBar = (IconRoundCornerProgressBar)view.findViewById(R.id.earthBar);
        IconRoundCornerProgressBar fireBar = (IconRoundCornerProgressBar)view.findViewById(R.id.fireBar);
        IconRoundCornerProgressBar waterBar = (IconRoundCornerProgressBar)view.findViewById(R.id.waterBar);
        IconRoundCornerProgressBar metalBar = (IconRoundCornerProgressBar)view.findViewById(R.id.metalBar);
        IconRoundCornerProgressBar woodBar = (IconRoundCornerProgressBar)view.findViewById(R.id.woodBar);

        earthBar.setIconImageResource(R.drawable.earth);
        fireBar.setIconImageResource(R.drawable.fire);
        waterBar.setIconImageResource(R.drawable.water);
        metalBar.setIconImageResource(R.drawable.metal);
        woodBar.setIconImageResource(R.drawable.wood);

        if (!name.equals("Elements are not set yet")) {

            yourNameTxt.setText(name);
            earthBar.setVisibility(View.VISIBLE);
            fireBar.setVisibility(View.VISIBLE);
            waterBar.setVisibility(View.VISIBLE);
            metalBar.setVisibility(View.VISIBLE);
            woodBar.setVisibility(View.VISIBLE);

            earthBar.setProgress((int) earthScore);
            fireBar.setProgress((int) fireScore);
            waterBar.setProgress((int) waterScore);
            metalBar.setProgress((int) metalScore);
            woodBar.setProgress((int) woodScore);

            earthTxt.setText(String.valueOf((int)earthScore)+"%");
            fireTxt.setText(String.valueOf((int)fireScore)+"%");
            metalTxt.setText(String.valueOf((int)metalScore)+"%");
            waterTxt.setText(String.valueOf((int)waterScore)+"%");
            woodTxt.setText(String.valueOf((int)woodScore)+"%");
        }

        else{
            RelativeLayout.LayoutParams p = (RelativeLayout.LayoutParams)yourNameTxt.getLayoutParams();
            p.topMargin= 1000;
            yourNameTxt.setLayoutParams(p);

            earthBar.setVisibility(View.INVISIBLE);
            fireBar.setVisibility(View.INVISIBLE);
            waterBar.setVisibility(View.INVISIBLE);
            metalBar.setVisibility(View.INVISIBLE);
            woodBar.setVisibility(View.INVISIBLE);

            earthTxt.setVisibility(View.INVISIBLE);
            fireTxt.setVisibility(View.INVISIBLE);
            metalTxt.setVisibility(View.INVISIBLE);
            waterTxt.setVisibility(View.INVISIBLE);
            woodTxt.setVisibility(View.INVISIBLE);
        }


        return view;
    }
}
