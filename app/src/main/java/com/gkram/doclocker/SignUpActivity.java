package com.gkram.doclocker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z0-9])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    TextView SignUp_textview_login;
    TextInputEditText SignUp_textinputedittext_emailId,SignUp_textinputedittext_password,SignUp_textinputedittext_phonenumber,SignUp_textinputedittext_dateofbirth;
    Button SignUp_button_login;
    private int year;
    private int month;
    private int day;
    String EmailID;
    String Password;
    String PhoneNumber;
    String DateofBirth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Calendar calendar = Calendar.getInstance();

        SignUp_textinputedittext_emailId = findViewById(R.id.SignUp_textinputedittext_emailId);
        SignUp_textinputedittext_password = findViewById(R.id.SignUp_textinputedittext_password);
        SignUp_textinputedittext_phonenumber = findViewById(R.id.SignUp_textinputedittext_phonenumber);
        SignUp_textinputedittext_dateofbirth = findViewById(R.id.SignUp_textinputedittext_dateofbirth);
        SignUp_button_login = findViewById(R.id.SignUp_button_login);
        SignUp_textview_login = findViewById(R.id.SignUp_textview_login);



        SignUp_textview_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });

        SignUp_textinputedittext_dateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        SignUp_textinputedittext_dateofbirth.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        SignUp_button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmailID = SignUp_textinputedittext_emailId.getText().toString().trim();
                Password = SignUp_textinputedittext_password.getText().toString().trim();
                PhoneNumber = SignUp_textinputedittext_phonenumber.getText().toString().trim();
                DateofBirth = SignUp_textinputedittext_dateofbirth.getText().toString().trim();

//                validateEmail();
//                validatePassword();
//                validatePhoneNumber();
//                validateDateofBirth();
//                if (!validateEmail() | !validatePassword() | !validatePhoneNumber() | !validateDateofBirth()){
//                    return;
//                }else{
//                    startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
//                    finish();
//                }
                    startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                    finish();

            }
        });


    }

    private boolean validateDateofBirth() {
        DateofBirth = SignUp_textinputedittext_dateofbirth.getText().toString().trim();
        if (Password.isEmpty()){
            SignUp_textinputedittext_dateofbirth.setError("Field can't be empty");
            return false;
        }else{
            SignUp_textinputedittext_dateofbirth.setError(null);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        PhoneNumber = SignUp_textinputedittext_phonenumber.getText().toString().trim();
        if (Password.isEmpty()){
            SignUp_textinputedittext_phonenumber.setError("Field can't be empty");
            return false;
        }else if (!Patterns.PHONE.matcher(PhoneNumber).matches()){
            SignUp_textinputedittext_phonenumber.setError("Inavlid Phone Number");
            return false;
        }else{
            SignUp_textinputedittext_phonenumber.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        Password = SignUp_textinputedittext_password.getText().toString().trim();
        if (Password.isEmpty()){
            SignUp_textinputedittext_password.setError("Field can't be empty");
            return false;
        }else if (Password.length() < 4){
            SignUp_textinputedittext_password.setError("Password Length Should be at least 4 letters");
            return false;
        }else if (!PASSWORD_PATTERN.matcher(Password).matches()){
            SignUp_textinputedittext_password.setError("Password too week");
            return false;
        }else{
            SignUp_textinputedittext_password.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        EmailID = SignUp_textinputedittext_emailId.getText().toString().trim();
        if (EmailID.isEmpty()){
            SignUp_textinputedittext_emailId.setError("Field can't be empty");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(EmailID).matches()){
            SignUp_textinputedittext_emailId.setError("Please enter a valid Email ID");
            return false;
        }else{
            SignUp_textinputedittext_emailId.setError(null);
            return true;
        }
    }


}