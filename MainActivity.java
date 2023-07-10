package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, height, weight;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edit_username);
        height = findViewById(R.id.edit_height);
        weight = findViewById(R.id.edit_weight);
        calculate = findViewById(R.id.btn_calculate);
        result = findViewById(R.id.tv_result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                double h = Double.parseDouble(height.getText().toString());
                double w = Double.parseDouble(weight.getText().toString());
                double bmi = w / (h * h);
                result.setText(name + ", your BMI is: " + bmi);
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("bmi", bmi);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });
    }
}