package com.razvan.clearview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignUp, btnAlready;
    private FirebaseAuth auth;

    public static boolean isEmailValid(CharSequence emailCheck) {
        String expression = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailCheck);
        return matcher.matches();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnAlready = (Button) findViewById(R.id.btnAlreadySignedUp);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);


        btnAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Please enter your email adress", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!isEmailValid(email)){
                    Toast.makeText(getApplicationContext(), "Please enter a valid email adress", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<6){
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String leftEmail = email.substring(0, Math.min(email.length(), 4));
                byte[] emailAscii = email.getBytes();


                final String UserID;

                UserID  = leftEmail + emailAscii.toString();


                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "Sign up failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                    intent.putExtra("UID",UserID);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                            });

            }
        });
    }
}
