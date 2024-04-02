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

public class EmiCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_emi_calc);
        //id binding
        LinearLayout emiBackBtn=findViewById(R.id.emiBackBtn);
        EditText emiAmount=findViewById(R.id.emiAmount);
        EditText emiRate=findViewById(R.id.emiRate);
        EditText emiYear=findViewById(R.id.emiYear);
        LinearLayout emiCalcBtn=findViewById(R.id.emiCalcBtn);
        TextView emiInterestAmount=findViewById(R.id.emiInterestAmount);
        TextView emiTotalInterest=findViewById(R.id.emiTotalInterest);
        TextView emiTotalPay=findViewById(R.id.emiTotalPay);

        emiBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        emiCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount_emi=emiAmount.getText().toString();
                String rate_emi=emiRate.getText().toString();
                String year_emi=emiYear.getText().toString();

                if(amount_emi.isEmpty())
                {
                    emiAmount.setError("Amount Required");
                }
                else if(rate_emi.isEmpty())
                {
                    emiRate.setError("Rate Required");
                }
                else if(year_emi.isEmpty())
                {
                    emiYear.setError("Year Required");
                }
                else
                {
                    int p=Integer.parseInt(amount_emi);
                    double r=Double.parseDouble(rate_emi)/(12*100);
                    int n=Integer.parseInt(year_emi)*12;

                    double ans=p*r*(Math.pow((1+r),n))/(Math.pow((1+r),n)-1);
                    double pay_amount=ans*n;
                    double total_interest=pay_amount-p;

                    emiInterestAmount.setText(String.format("%.2f",ans));
                    emiTotalInterest.setText(String.format("%.2f",total_interest));
                    emiTotalPay.setText(String.format("%.2f",pay_amount));
                }

            }
        });
    }
}