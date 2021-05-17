package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private EditText num1;
    private EditText num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonSum);
        num1 = findViewById(R.id.editNum1);
        num2 = findViewById(R.id.editNum2);
        result = findViewById(R.id.result);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Integer number1 = Integer.parseInt(num1.getText().toString());
        Integer number2 = Integer.parseInt(num2.getText().toString());
        Integer resultInt = number1 + number2;
        result.setText(resultInt.toString());
    }
}