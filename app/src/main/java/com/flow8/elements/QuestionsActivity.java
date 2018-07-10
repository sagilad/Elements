package com.flow8.elements;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class QuestionsActivity extends AppCompatActivity {
    TextView questionTV;
    String questionStr, elementStr, name;
    List<String> EarthQuestionsList, FireQuestionsList, MetalQuestionsList, WaterQuestionsList, WoodQuestionsList, ElementsList;
    Random randomQuestion, randomElement;
    ImageButton neverBtn, falseBtn, nrBtn, trueBtn, veryTrueBtn;
    int numOfQuestions = 25;
    int earthCnt = numOfQuestions, fireCnt = numOfQuestions, metalCnt = numOfQuestions, waterCnt = numOfQuestions, woodCnt  = numOfQuestions;
    int totalQuestions = earthCnt + fireCnt + metalCnt + waterCnt + woodCnt;
    double earthScore = 0 , fireScore = 0, metalScore = 0, waterScore = 0, woodScore = 0, currentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        questionTV = (TextView)findViewById(R.id.question);
        neverBtn = (ImageButton)findViewById(R.id.neverBtn);
        falseBtn = (ImageButton)findViewById(R.id.falseBtn);
        nrBtn = (ImageButton)findViewById(R.id.nrBtn);
        trueBtn = (ImageButton)findViewById(R.id.trueBtn);
        veryTrueBtn = (ImageButton)findViewById(R.id.veryTrueBtn);
        name = getIntent().getExtras().getString("name");


        EarthQuestionsList = new ArrayList<String>(Arrays.asList(this.getResources().getStringArray(R.array.questions_earth)));
        FireQuestionsList = new ArrayList<String>(Arrays.asList(this.getResources().getStringArray(R.array.questions_fire)));
        MetalQuestionsList = new ArrayList<String>(Arrays.asList(this.getResources().getStringArray(R.array.questions_metal)));
        WaterQuestionsList = new ArrayList<String>(Arrays.asList(this.getResources().getStringArray(R.array.questions_water)));
        WoodQuestionsList = new ArrayList<String>(Arrays.asList(this.getResources().getStringArray(R.array.questions_wood)));
        ElementsList  = new ArrayList<String>(Arrays.asList(this.getResources().getStringArray(R.array.elements)));

        setQuestion();

        neverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore = -2;
                calcScore();
                checkFinish();
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore = -1;
                calcScore();
                checkFinish();
            }
        });

        nrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFinish();
            }
        });

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore = 1;
                calcScore();
                checkFinish();
            }
        });

        veryTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore = 2;
                calcScore();
                checkFinish();
            }
        });

    }

    public void calcScore(){
        if (elementStr.equals("Earth")) {
            earthScore = earthScore + currentScore;
        }

        else if (elementStr.equals("Fire")) {
            fireScore = fireScore + currentScore;
        }

        else if (elementStr.equals("Metal")) {
            metalScore = metalScore + currentScore;
        }

        else if (elementStr.equals("Water")) {
            waterScore = waterScore + currentScore;
        }

        else if (elementStr.equals("Wood")) {
            woodScore = woodScore + currentScore;
        }
    }

    public void checkFinish(){
        if (totalQuestions ==0){
            Intent intent = new Intent(QuestionsActivity.this, resultActivity.class);
            earthScore = Math.abs(earthScore);
            earthScore = (earthScore/(numOfQuestions*2))*100;

            fireScore = Math.abs(fireScore);
            fireScore = (fireScore/(numOfQuestions*2))*100;

            metalScore = Math.abs(metalScore);
            metalScore = (metalScore/(numOfQuestions*2))*100;

            waterScore = Math.abs(waterScore);
            waterScore = (waterScore/(numOfQuestions*2))*100;

            woodScore = Math.abs(woodScore);
            woodScore = (woodScore/(numOfQuestions*2))*100;

            intent.putExtra("earthScore", earthScore);
            intent.putExtra("fireScore", fireScore);
            intent.putExtra("metalScore", metalScore);
            intent.putExtra("waterScore", waterScore);
            intent.putExtra("woodScore", woodScore);
            intent.putExtra("name", name);
            startActivity(intent);
        }
        else {
            setQuestion();
        }
    }

    public void setQuestion(){
        totalQuestions --;
        randomQuestion = new Random();
        randomElement = new Random();

        int elementPos = randomElement.nextInt(ElementsList.size());
        elementStr = ElementsList.get(elementPos);
        randomQuestion = new Random();

        if (elementStr.equals("Earth")) {
            earthCnt --;
            if (earthCnt == 0){
                ElementsList.remove(elementPos);
            }
            int questionPos = randomQuestion.nextInt(EarthQuestionsList.size());
            questionStr = EarthQuestionsList.get(questionPos);
            EarthQuestionsList.remove(questionPos);
        }

        else if (elementStr.equals("Fire")) {
            fireCnt --;
            if (fireCnt == 0){
                ElementsList.remove(elementPos);
            }
            int questionPos = randomQuestion.nextInt(FireQuestionsList.size());
            questionStr = FireQuestionsList.get(questionPos);
            FireQuestionsList.remove(questionPos);
        }

        else if (elementStr.equals("Metal")) {
            metalCnt --;
            if (metalCnt == 0){
                ElementsList.remove(elementPos);
            }
            int questionPos = randomQuestion.nextInt(MetalQuestionsList.size());
            questionStr = MetalQuestionsList.get(questionPos);
            MetalQuestionsList.remove(questionPos);
        }

        else if (elementStr.equals("Water")) {
            waterCnt --;
            if (waterCnt == 0){
                ElementsList.remove(elementPos);
            }
            int questionPos = randomQuestion.nextInt(WaterQuestionsList.size());
            questionStr = WaterQuestionsList.get(questionPos);
            WaterQuestionsList.remove(questionPos);
        }

        else if (elementStr.equals("Wood")) {
            woodCnt --;
            if (woodCnt == 0){
                ElementsList.remove(elementPos);
            }
            int questionPos = randomQuestion.nextInt(WoodQuestionsList.size());
            questionStr = WoodQuestionsList.get(questionPos);
            WoodQuestionsList.remove(questionPos);
        }

        questionTV.setText(questionStr);
    }
}
