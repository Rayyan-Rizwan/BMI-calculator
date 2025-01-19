package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //  Start
        //Variables declare:-
        EditText edtweight, edtHeight, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;

        //connect variables with xml
        edtweight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        //after clicking on button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Convert into integers
                int weight = Integer.parseInt(edtweight.getText().toString());
                int height = Integer.parseInt(edtHeight.getText().toString());
                int heightIn = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = (height * 12) + heightIn;
                double totalCm = totalIn * 2.54;
                double totalM = totalCm / 100;
                double bmi = weight / (totalM * totalM);

                if (bmi < 18.5) {
                    txtResult.setText("Underweight");
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    txtResult.setText("Normal");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}