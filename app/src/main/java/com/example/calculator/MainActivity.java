package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String operation = "",minus="-",plus=" ";
    private Double first,second;
    private Double sum;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);

    }

    public void onNumberClick(View view) {
        String textButton = ((Button) view).getText().toString();
        if (textButton.equals("AC")) {
            textView.setText("0");
            first = 0.0;
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
              Double  curentValue = Double.parseDouble(textView.getText().toString());
              Double newValue=-curentValue;
              Double value=Double.parseDouble(String.valueOf(newValue));
                operation = "+/-";
                if (operation.equals("+/-")) {
                    sum=newValue;
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
                    sum = (first/100)*second;
                    textView.setText(cancelDouble(sum));
                }


                isOperationClick = true;
        }
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