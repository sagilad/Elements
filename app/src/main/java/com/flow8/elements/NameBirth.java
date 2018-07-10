package com.flow8.elements;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Field;

public class NameBirth extends AppCompatActivity {

    private String[] daySpinnerStr, monthSpinnerStr, yearSpinnerStr;
    private ImageButton contBtn;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_birth);

        final EditText nameEdit = (EditText) findViewById(R.id.nameEdit);

        contBtn = (ImageButton)findViewById(R.id.contBtn);

        this.daySpinnerStr = new String[]{
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","28","29","30","31"
        };

        this.monthSpinnerStr = new String[]{
                "1","2","3","4","5","6","7","8","9","10","11","12"
        };

        this.yearSpinnerStr = new String[]{
                "1930","1931","1932","1933","1934","1935","1936","1937","1938","1939","1940","1941","1942","1943","1944","1945","1946","1947","1948","1949","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"
        };

        Spinner daySpinner = (Spinner)findViewById(R.id.daySpinner);
        Spinner monthSpinner = (Spinner)findViewById(R.id.monthSpinner);
        Spinner yearSpinner = (Spinner)findViewById(R.id.yearSpinner);
        try {
            Field popup = Spinner.class.getDeclaredField("mPopup");
            popup.setAccessible(true);

            // Get private mPopup member variable and try cast to ListPopupWindow
            android.widget.ListPopupWindow popupWindowDay = (android.widget.ListPopupWindow) popup.get(daySpinner);
            android.widget.ListPopupWindow popupWindowYear = (android.widget.ListPopupWindow) popup.get(yearSpinner);

            // Set popupWindow height to 500px
            popupWindowDay.setHeight(500);
            popupWindowYear.setHeight(500);
        }
        catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {
            // silently fail...
        }

        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daySpinnerStr);
        daySpinner.setAdapter(adapterDay);

        ArrayAdapter<String> adapterMonth = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monthSpinnerStr);
        monthSpinner.setAdapter(adapterMonth);

        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yearSpinnerStr);
        yearSpinner.setAdapter(adapterYear);

        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEdit.getText().toString();
                if (name.equals(""))
                    Toast.makeText(getApplicationContext(),"you must enter a valid name", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(NameBirth.this, QuestionsActivity.class);
                    i.putExtra("name", name);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NameBirth.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
