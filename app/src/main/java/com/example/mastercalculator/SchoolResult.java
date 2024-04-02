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

public class SchoolResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_school_result);
        //id Binding
        LinearLayout schoolBackBtn=findViewById(R.id.schoolBackBtn);
        EditText totalMarks=findViewById(R.id.totalMarks);
        EditText yourTotalMarks=findViewById(R.id.yourTotalMarks);
        LinearLayout schoolCalcBtn=findViewById(R.id.schoolCalcBtn);
        TextView marksPercentage=findViewById(R.id.marksPercentage);

        schoolBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        schoolCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marks_total=totalMarks.getText().toString();
                String your_total=yourTotalMarks.getText().toString();

                if(marks_total.isEmpty())
                {
                    totalMarks.setError("Marks Required");
                }
                else if(your_total.isEmpty())
                {
                    yourTotalMarks.setError("Marks Required");
                }
                else
                {
                    int total_marks=Integer.parseInt(marks_total);
                    int your_total_marks=Integer.parseInt(your_total);

                    double ans=your_total_marks*100/total_marks;

                    marksPercentage.setText(String.format("%.2f",ans));
                }
            }
        });
    }
}