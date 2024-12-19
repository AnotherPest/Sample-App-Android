package com.example.sqlite;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userTextView = findViewById(R.id.userTextView);
        String username = getIntent().getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            userTextView.setText(username);
        }
    }
}
