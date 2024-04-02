package com.example.mastercalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.io.LineReader;

public class UtilityPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_utility_page);
        //id binding
        LinearLayout utilityBackBtn=findViewById(R.id.utilityBackBtn);
        LinearLayout mutualFundCalc=findViewById(R.id.mutualFundCalc);
        LinearLayout interestCalc=findViewById(R.id.interestCalc);
        LinearLayout discountCalc=findViewById(R.id.discountCalc);
        LinearLayout emiCalc=findViewById(R.id.emiCalc);
        LinearLayout schoolCalc=findViewById(R.id.schoolCalc);
        LinearLayout ageCalc=findViewById(R.id.ageCalc);

        utilityBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
        mutualFundCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtilityPage.this, Mutual.class);
                startActivity(intent);
            }
        });
        interestCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtilityPage.this,InterestCalc.class);
                startActivity(intent);
            }
        });
        discountCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtilityPage.this,DiscountCalc.class);
                startActivity(intent);
            }
        });
        emiCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtilityPage.this,EmiCalc.class);
                startActivity(intent);
            }
        });
        schoolCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtilityPage.this,SchoolResult.class);
                startActivity(intent);
            }
        });
        ageCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (UtilityPage.this, AgeCalculator.class);
                startActivity(intent);
            }
        });
    }
}