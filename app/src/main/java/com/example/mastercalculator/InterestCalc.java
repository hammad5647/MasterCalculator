package com.example.mastercalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InterestCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_interest_calc);
        //id Binding
        LinearLayout intBackBtn=findViewById(R.id.intBackBtn);
        LinearLayout intCalcBtn=findViewById(R.id.intCalcBtn);
        EditText intAmountInput=findViewById(R.id.intAmountInput);
        EditText intRateInput=findViewById(R.id.intRateInput);
        EditText intYearInput=findViewById(R.id.intYearInput);
        EditText intResult=findViewById(R.id.intResult);

        intBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        intCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Princ_amount = intAmountInput.getText().toString();
                String IntRate = intRateInput.getText().toString();
                String IntYear = intYearInput.getText().toString();

                if (Princ_amount.isEmpty()) {
                    intAmountInput.setError("Amount Required");
                }
                else if (IntRate.isEmpty())
                {
                    intRateInput.setError("Interest Rate Required");
                }
                else if (IntYear.isEmpty())
                {
                    intYearInput.setError("Total Year Required");
                }
                else
                {
                    int p=Integer.parseInt(Princ_amount);
                    double r=Double.parseDouble(IntRate)/100;
                    int t=Integer.parseInt(IntYear);

                    double ans=p*(1+(r*t));

                    intResult.setText(""+ans);
                }
            }
        });
    }
}