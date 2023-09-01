package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.concurrent.atomic.AtomicBoolean;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String resultFromMain = getIntent().getStringExtra("key1");
        TextView textView = findViewById(R.id.txt_explore);
        textView.setText(resultFromMain);

        MaterialButton btn_destroy = findViewById(R.id.next_btn);
        btn_destroy.setOnClickListener(view -> {
            finishAffinity();
        });

        TextView heart = findViewById(R.id.imageButton);
        AtomicBoolean heart2 = new AtomicBoolean(false);
        heart.setOnClickListener(view -> {
            if (heart2.get()==false) {
                heart.setBackgroundResource(R.drawable.iconmonstr_heart);
                heart2.set(true);
            }
            else if (heart2.get() == true) {
                heart.setBackgroundResource(R.drawable.iconmonstr_heart_thin);
                heart2.set(false);
            }
        });
    }
}
