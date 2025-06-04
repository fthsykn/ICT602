package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editFund, editRate, editMonths;
    Button btnCalculate, btnAbout;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFund = findViewById(R.id.editFund);
        editRate = findViewById(R.id.editRate);
        editMonths = findViewById(R.id.editMonths);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnAbout = findViewById(R.id.btnAbout);
        textResult = findViewById(R.id.textResult);

        Button btnClear = findViewById(R.id.btnClear);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDividend();
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editFund.setText("");
                editRate.setText("");
                editMonths.setText("");
                textResult.setText("");
            }
        });
    }

    private void calculateDividend() {
        try {
            double fund = Double.parseDouble(editFund.getText().toString());
            double rate = Double.parseDouble(editRate.getText().toString());
            int months = Integer.parseInt(editMonths.getText().toString());

            if (months < 1 || months > 12) {
                Toast.makeText(this, "Please enter months between 1 and 12", Toast.LENGTH_SHORT).show();
                return;
            }

            double monthlyDividend = (rate / 100.0 / 12.0) * fund;
            double totalDividend = monthlyDividend * months;

            String result = String.format("Monthly Dividend: RM %.2f\nTotal Dividend: RM %.2f",
                    monthlyDividend, totalDividend);

            textResult.setText(result);

        } catch (Exception e) {
            Toast.makeText(this, "Please enter valid numbers in all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
