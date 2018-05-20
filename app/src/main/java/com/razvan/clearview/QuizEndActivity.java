package com.razvan.clearview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class QuizEndActivity extends AppCompatActivity {

    TextView endText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quizend);

        endText = (TextView) findViewById(R.id.endText);

        FirebaseAuth.getInstance().signOut();
    }
}
