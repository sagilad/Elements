package com.flow8.elements;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

public class resultActivity extends AppCompatActivity {

    double earthScore, fireScore, metalScore, waterScore, woodScore;
    TextView earthTxt, fireTxt, metalTxt, waterTxt, woodTxt;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        earthScore = getIntent().getExtras().getDouble("earthScore");
        fireScore = getIntent().getExtras().getDouble("fireScore");
        metalScore = getIntent().getExtras().getDouble("metalScore");
        waterScore = getIntent().getExtras().getDouble("waterScore");
        woodScore = getIntent().getExtras().getDouble("woodScore");
        name = getIntent().getExtras().getString("name");

        earthTxt = (TextView)findViewById(R.id.earthTxt);
        fireTxt = (TextView)findViewById(R.id.fireTxt);
        metalTxt = (TextView)findViewById(R.id.metalTxt);
        waterTxt = (TextView)findViewById(R.id.waterTxt);
        woodTxt = (TextView)findViewById(R.id.woodTxt);

        earthTxt.setText(String.valueOf((int)earthScore)+"%");
        fireTxt.setText(String.valueOf((int)fireScore)+"%");
        metalTxt.setText(String.valueOf((int)metalScore)+"%");
        waterTxt.setText(String.valueOf((int)waterScore)+"%");
        woodTxt.setText(String.valueOf((int)woodScore)+"%");

        SharedPreferences.Editor scores = getSharedPreferences("scores",MODE_PRIVATE).edit();
        scores.putInt("earthScore",(int)earthScore);
        scores.putInt("fireScore",(int)fireScore);
        scores.putInt("metalScore",(int)metalScore);
        scores.putInt("waterScore",(int)waterScore);
        scores.putInt("woodScore",(int)woodScore);
        scores.putString("name", name);

        scores.apply();


        IconRoundCornerProgressBar earthBar = (IconRoundCornerProgressBar)findViewById(R.id.earthBar);
        IconRoundCornerProgressBar fireBar = (IconRoundCornerProgressBar)findViewById(R.id.fireBar);
        IconRoundCornerProgressBar waterBar = (IconRoundCornerProgressBar)findViewById(R.id.waterBar);
        IconRoundCornerProgressBar metalBar = (IconRoundCornerProgressBar)findViewById(R.id.metalBar);
        IconRoundCornerProgressBar woodBar = (IconRoundCornerProgressBar)findViewById(R.id.woodBar);

        earthBar.setIconImageResource(R.drawable.earth);
        fireBar.setIconImageResource(R.drawable.fire);
        waterBar.setIconImageResource(R.drawable.water);
        metalBar.setIconImageResource(R.drawable.metal);
        woodBar.setIconImageResource(R.drawable.wood);


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
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(resultActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
