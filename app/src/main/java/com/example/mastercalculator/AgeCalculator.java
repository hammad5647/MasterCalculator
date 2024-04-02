package com.example.mastercalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgeCalculator extends AppCompatActivity {
    EditText birthDate;
    EditText birthMonth;
    EditText birthYear;

    TextView ageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);
        //id binding
        LinearLayout ageCalcBackBtn=findViewById(R.id.ageCalcBackBtn);
        birthDate=findViewById(R.id.birthDate);
        birthMonth=findViewById(R.id.birthMonth);
        birthYear=findViewById(R.id.birthYear);
        LinearLayout ageCalcBtn=findViewById(R.id.ageCalcBtn);
        ageResult=findViewById(R.id.ageResult);

        ageCalcBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ageCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birth_date=birthDate.getText().toString();
                String birth_month=birthMonth.getText().toString();
                String birth_year=birthYear.getText().toString();

                if(birth_date.isEmpty())
                {
                    birthDate.setError("Date Required");
                }
                else if(birth_month.isEmpty())
                {
                    birthMonth.setError("Month Required");
                }
                else if(birth_year.isEmpty())
                {
                    birthYear.setError("Year Required");
                }
                else
                {
                    count();
                }
            }
        });
        }
    void count()
    {
        int c_date=30,c_month=12,c_year=2024;
        int b_date=Integer.parseInt(birthDate.getText().toString());
        int b_month=Integer.parseInt(birthMonth.getText().toString());
        int b_year=Integer.parseInt(birthYear.getText().toString());

        int date,month,year;

        year=c_year-b_year;

        if(c_date>b_date && c_month>b_month)
        {
            date=c_date-b_date;
            month=c_month-b_month;
        }
        else
        {
            if(c_month<b_month || c_date<b_date)
            {
                year=year-1;
                c_month=c_month+12;
                month=c_month-b_month;
            }
            else
            {
                month=c_month-b_month;
            }
            if(c_date<b_date)
            {
                month=month-1;
                c_date=c_date+30;
                date=c_date-b_date;
            }
            else
            {
                date=c_date-b_date;
            }
        }
        ageResult.setText("Your Age is : "+year);
    }
}