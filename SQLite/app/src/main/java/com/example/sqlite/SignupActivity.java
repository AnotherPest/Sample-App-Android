package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sqlite.databinding.ActivitySignupBinding;
import com.example.sqlite.SQLiteConnector.SQLiteConnector;
import com.example.sqlite.model.User;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    private SQLiteConnector databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new SQLiteConnector(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSignup();
            }
        });

        binding.loginButtonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLogin();
            }
        });
    }

    private void performSignup() {
        String username = binding.signupUsername.getText().toString().trim();
        String email = binding.signupEmail.getText().toString().trim();
        String password = binding.signupPassword.getText().toString().trim();
        String confirmPassword = binding.signupConfirm.getText().toString().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(SignupActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if user already exists
        if (!databaseHelper.checkUser(email)) {
            // Add user to the database
            boolean insert = databaseHelper.addUser(new User(1,username, email, password)); // Ensure this method exists and is correct
            if (insert) {
                Toast.makeText(SignupActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                navigateToLogin();
            } else {
                Toast.makeText(SignupActivity.this, "Registration failed, try again", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignupActivity.this, "This email already in used, please try another one...", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToLogin() {
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
