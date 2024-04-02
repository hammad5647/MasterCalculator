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

public class DiscountCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_discount_calc);
        //id binding
        LinearLayout discBackBtn=findViewById(R.id.discBackBtn);
        EditText discPriceBtn=findViewById(R.id.discPriceBtn);
        EditText discBtn=findViewById(R.id.discBtn);
        LinearLayout discCalcBtn=findViewById(R.id.discCalcBtn);
        TextView afterDisc=findViewById(R.id.afterDisc);
        TextView savedAmount=findViewById(R.id.savedAmount);

        discBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        discCalcBtn.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                String Price=discPriceBtn.getText().toString();
                String Discount=discBtn.getText().toString();

                if(Price.isEmpty())
                {
                    discPriceBtn.setError("Price Required");
                }
                else if(Discount.isEmpty())
                {
                    discBtn.setError("Discount Required");
                }
                else
                {
                    int p=Integer.parseInt(Price);
                    double d=Double.parseDouble(Discount)/100;

                    double after_disc=p-(p*d);
                    double saved_amount=p-after_disc;

                    afterDisc.setText(""+after_disc);
                    savedAmount.setText(""+saved_amount);
                }
            }
        });
    }
}