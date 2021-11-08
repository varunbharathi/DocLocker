package com.gkram.doclocker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText Login_textinputedittext_emailId,Login_textinputedittext_password;
    Button Login_button_login;
    TextView Login_textview_signup,Login_textview_forgotpassword;
    String EmailID;
    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login_textinputedittext_emailId = findViewById(R.id.Login_textinputedittext_emailId);
        Login_textinputedittext_password = findViewById(R.id.Login_textinputedittext_password);
        Login_button_login = findViewById(R.id.Login_button_login);
        Login_textview_signup = findViewById(R.id.Login_textview_signup);
        Login_textview_forgotpassword = findViewById(R.id.Login_textview_forgotpassword);

        Login_textview_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });

        Login_textview_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
            }
        });

        Login_button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmailID = Login_textinputedittext_emailId.getText().toString().trim();
                Password = Login_textinputedittext_password.getText().toString().trim();
                validateEmail();
                validatePassword();
            }
        });
    }

    private boolean validatePassword() {
        Password = Login_textinputedittext_password.getText().toString().trim();
        if (Password.isEmpty()){
            Login_textinputedittext_password.setError("Field can't be empty");
            return false;
        }else{
            Login_textinputedittext_password.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        EmailID = Login_textinputedittext_emailId.getText().toString().trim();
        if (EmailID.isEmpty()){
            Login_textinputedittext_emailId.setError("Field can't be empty");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(EmailID).matches()){
            Login_textinputedittext_emailId.setError("Please enter a valid Email ID");
            return false;
        }else{
            Login_textinputedittext_emailId.setError(null);
            return true;
        }
    }
}