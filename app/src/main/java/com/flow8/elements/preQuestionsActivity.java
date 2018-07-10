package com.flow8.elements;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

public class preQuestionsActivity extends AppCompatActivity {

    ImageButton okGotItBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_questions);
        okGotItBtn = (ImageButton)findViewById(R.id.okGotItBtn);

        okGotItBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
                v.startAnimation(buttonClick);
                Intent i = new Intent(preQuestionsActivity.this, NameBirth.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(preQuestionsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
