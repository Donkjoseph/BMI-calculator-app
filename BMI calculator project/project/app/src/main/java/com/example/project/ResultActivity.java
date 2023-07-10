package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get the BMI and name from the extras
        double bmi = getIntent().getDoubleExtra("bmi", 0.0);
        String name = getIntent().getStringExtra("name");

        // Display the BMI and name in the appropriate views
        TextView bmiTextView = findViewById(R.id.bmi_text_view);
        bmiTextView.setText(String.format("%.1f", bmi));

        TextView nameTextView = findViewById(R.id.name_text_view);
        nameTextView.setText(name);

        TextView classificationTextView = findViewById(R.id.classification_text_view);
        if (bmi < 18.5) {
            classificationTextView.setText(" Underweight");
        } else if (bmi < 25) {
            classificationTextView.setText(" Normal weight");
        } else if (bmi < 30) {
            classificationTextView.setText(" Overweight");
        } else {
            classificationTextView.setText(" Obese");
        }

        // Set up the back button to return to the previous activity
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
