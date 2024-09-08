package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity {

    private TextView viewDip;
    private String currentInput = "";
    private String operator = "";
    private double operand1 = 0;
    private double operand2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewDip = findViewById(R.id.viewDip);

        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btnMul = findViewById(R.id.btnMul);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btnSub = findViewById(R.id.btnSub);
        Button btn0 = findViewById(R.id.btn0);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnEqual = findViewById(R.id.btnEqual);
        Button btnclr = findViewById(R.id.btnclr);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                handleButtonClick(b.getText().toString());
            }
        };

        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btn0.setOnClickListener(listener);
        btnAdd.setOnClickListener(listener);
        btnEqual.setOnClickListener(listener);
        btnclr.setOnClickListener(listener);
    }

    private void handleButtonClick(String value) {
        switch (value) {
            case "Del":
                currentInput = "";
                operand1 = 0;
                operand2 = 0;
                operator = "";
                viewDip.setText("0");
                break;
            case "=":
                operand2 = Double.parseDouble(currentInput);
                double result = 0;
                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                }
                viewDip.setText(String.valueOf(result));
                currentInput = String.valueOf(result);
                operator = "";
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operand1 = Double.parseDouble(currentInput);
                operator = value;
                currentInput = "";
                viewDip.setText(operand1 + " " + operator);
                break;
            default:
                currentInput += value;
                viewDip.setText(currentInput);
                break;
        }
    }
}
