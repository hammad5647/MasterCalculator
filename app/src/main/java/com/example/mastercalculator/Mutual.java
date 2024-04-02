package com.example.mastercalculator;

import android.content.Intent;
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

public class   Mutual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual);

        //id binding
        LinearLayout mutualBackBtn=findViewById(R.id.mutualBackBtn);
        LinearLayout mutualCalcBtn=findViewById(R.id.mutualCalcBtn);
        EditText mutualInvestInput=findViewById(R.id.mutualInvestInput);
        EditText mutualRateInput=findViewById(R.id.mutualRateInput);
        EditText mutualYearInput=findViewById(R.id.mutualYearInput);
        EditText rInvested=findViewById(R.id.rInvested);
        EditText rReturn=findViewById(R.id.rReturn);
        EditText tValue=findViewById(R.id.tValue);

       mutualBackBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
       mutualCalcBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

            String invest_amount=mutualInvestInput.getText().toString();
            String invest_rate=mutualRateInput.getText().toString();
            String invest_year=mutualYearInput.getText().toString();

            if(invest_amount.isEmpty())
            {
                mutualInvestInput.setError("Invest Amount Required");
            }
            else if(invest_rate.isEmpty())
            {
              mutualRateInput.setError("Rate Required");
            }
            else if (invest_year.isEmpty())
            {
                mutualYearInput.setError("Total Years Required");
            }
            else
            {
                int p=Integer.parseInt(invest_amount);
                double i=Double.parseDouble(invest_rate)/12/100;
                int n=Integer.parseInt(invest_year)*12;

                double ans=p*((Math.pow (1+i,n)-1)/i)*(1+i);
                double est_return=ans-(p*n);
                double invested=p*n;

                tValue.setText(String.format("%.2f",ans));
                rInvested.setText(String.format("%.2f",invested));
                rReturn.setText(String.format("%.2f",est_return));
            }
           }
       });
        Intent intent=getIntent();
    }
}