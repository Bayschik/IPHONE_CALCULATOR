package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private Button switchButton, buttonEqual;
    private EditText textView;
    private String operation = "", minus = "-", plus = " ";
    private Double first, second, sum;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        switchButton = findViewById(R.id.switch_button);

        buttonEqual = findViewById(R.id.btn_equal);

        findViewById(R.id.switch_button).setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("key1", textView.getText().toString());
            startActivity(intent);
            finish();
        });
    }

    public void onNumberClick(View view) {
        String textButton = ((MaterialButton) view).getText().toString();
        if (textButton.equals("AC")) {
            textView.setText("0");
            first = 0.0;
        }
        if(textButton.equals("AC")){
            switchButton.setVisibility(View.INVISIBLE);
        } else if (textView.getText().toString().contains(".0")) {
            textView.append(textButton);
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        String textButton = ((Button) view).getText().toString();
        switch (textButton) {
            case "+":
                first = Double.parseDouble(textView.getText().toString());
                operation = "+";
                isOperationClick = true;
                break;
            case "-":
                first = Double.parseDouble(textView.getText().toString());
                operation = "-";
                isOperationClick = true;
                break;
            case "X":
                first = Double.parseDouble(textView.getText().toString());
                operation = "X";
                isOperationClick = true;
                break;
            case "/":
                first = Double.parseDouble(textView.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case "%":
                first = Double.parseDouble(textView.getText().toString());
                operation = "%";
                isOperationClick = true;
                break;
            case ".":
                first = Double.parseDouble(textView.getText().toString());
                operation = ".";
                isOperationClick = true;
                break;
            case "+/-":
                Double currentValue = Double.parseDouble(textView.getText().toString());
                Double newValue = -currentValue;
                Double value = Double.parseDouble(String.valueOf(newValue));
                operation = "+/-";
                if (operation.equals("+/-")) {
                    sum = newValue;
                    textView.setText(cancelDouble(value));
                    isOperationClick = true;
                }
                break;
            case "=":
                second = Double.parseDouble(textView.getText().toString());
                if (operation.equals("+")) {
                    sum = first + second;
                    textView.setText(cancelDouble(sum));
                } else if (operation.equals("-")) {
                    sum = first - second;
                    textView.setText(cancelDouble(sum));
                } else if (operation.equals("X")) {
                    sum = first * second;
                    textView.setText(cancelDouble(sum));
                } else if (operation.equals("/")) {
                    sum = first / second;
                    textView.setText(cancelDouble(sum));
                } else if (operation.equals("%")) {
                    sum = (first / 100) * second;
                    textView.setText(cancelDouble(sum));
                } if (view.getId() == R.id.btn_equal) {
                    switchButton.setVisibility(View.VISIBLE);
                }
                isOperationClick = true;
        }

//        buttonEqual.setOnClickListener(view1 -> {
//            if (textView.isShown()){
//                switchButton.setVisibility(View.INVISIBLE);
//            }else {
//                switchButton.setVisibility(View.VISIBLE);
//            }
//        });
    }
    public String cancelDouble(Double number){
        String text = number.toString();
        if(text.substring(text.length()-2).equals(".0")){
            return text.substring(0, text.length()-2);
        }else{
            return number.toString();
        }
    }
}