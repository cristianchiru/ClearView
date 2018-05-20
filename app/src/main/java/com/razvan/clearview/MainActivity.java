package com.razvan.clearview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{


    Button A1, A2, A3, A4, A5, A6;
    TextView question;
    TextView scoretest;

    FirebaseFirestore database;

    int score=0;
    int index=0;

    final String Questions [] = {
            "Do you do things slowly?",
            "Does your future seem hopeless?",
            "Is it hard for you to concentrate?",
            "Is the pleasure and joy gone out of your life?",
            "Do you have a difficulty in making decisions?",
            "Did you loose interest in once inportant life aspects?",
            "Do you feel sad, blue and unhappy most of the time?",
            "Do you feel agitated and restless most of the time?",
            "Do you feel fatigued?",
            "Does it take a great effort to do simple things?",
            "Do you feel you are a guilty person who needs punishement?",
            "Do you feel like a failure?",
            "Do you feel lifeless?",
            "Is your sleep too short, too much or broken?",
            "Do you spend time thinking how to kill yourself?",
            "Do you feel trapped",
            "Even when good things happen to you, you're still depressed?",
            "Did you loose or gained weight without a diet?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        A1 = (Button) findViewById(R.id.answer1);
        A2 = (Button) findViewById(R.id.answer2);
        A3 = (Button) findViewById(R.id.answer3);
        A4 = (Button) findViewById(R.id.answer4);
        A5 = (Button) findViewById(R.id.answer5);
        A6 = (Button) findViewById(R.id.answer6);

        question = (TextView) findViewById(R.id.QuestionsView);

        scoretest = (TextView) findViewById(R.id.scoretest);

        database = FirebaseFirestore.getInstance();

        question.setText(Questions[index]);


            A1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    question = (TextView) findViewById(R.id.QuestionsView);
                    scoretest = (TextView) findViewById(R.id.scoretest);
                    if(index<Questions.length-1) {
                        index++;
                        question.setText(Questions[index]);
                        scoretest.setText(String.valueOf(score));
                    }else {

                        Map<Object,Object> scoremap = new HashMap<>();
                        scoremap.put("uniqueID", getIntent().getStringExtra("UID"));
                        scoremap.put("score",score);
                        scoremap.put("date", ServerValue.TIMESTAMP);

                        database.collection("users").add(scoremap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Toast.makeText(MainActivity.this, "Database connection succes!", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Database connection failed!", Toast.LENGTH_LONG).show();
                            }
                        });

                        Intent intent = new Intent(MainActivity.this, QuizEndActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

            A2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    question = (TextView) findViewById(R.id.QuestionsView);
                    scoretest = (TextView) findViewById(R.id.scoretest);
                    score += 1;
                    if(index<Questions.length-1) {
                        index++;
                        question.setText(Questions[index]);
                        scoretest.setText(String.valueOf(score));
                    }else {

                        Map<Object,Object> scoremap = new HashMap<>();
                        scoremap.put("uniqueID", getIntent().getStringExtra("UID"));
                        scoremap.put("score",score);
                        scoremap.put("date", ServerValue.TIMESTAMP);

                        database.collection("users").add(scoremap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Toast.makeText(MainActivity.this, "Database connection succes!", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Database connection failed!", Toast.LENGTH_LONG).show();
                            }
                        });

                        Intent intent = new Intent(MainActivity.this, QuizEndActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

            A3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    question = (TextView) findViewById(R.id.QuestionsView);
                    scoretest = (TextView) findViewById(R.id.scoretest);
                    score += 2;
                    if(index<Questions.length-1) {
                        index++;
                        question.setText(Questions[index]);
                        scoretest.setText(String.valueOf(score));
                    }else {

                        Map<Object,Object> scoremap = new HashMap<>();
                        scoremap.put("uniqueID", getIntent().getStringExtra("UID"));
                        scoremap.put("score",score);
                        scoremap.put("date", ServerValue.TIMESTAMP);

                        database.collection("users").add(scoremap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Toast.makeText(MainActivity.this, "Database connection succes!", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Database connection failed!", Toast.LENGTH_LONG).show();
                            }
                        });

                        Intent intent = new Intent(MainActivity.this, QuizEndActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

            A4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    question = (TextView) findViewById(R.id.QuestionsView);
                    scoretest = (TextView) findViewById(R.id.scoretest);
                    score += 3;
                    if(index<Questions.length-1) {
                        index++;
                        question.setText(Questions[index]);
                        scoretest.setText(String.valueOf(score));
                    }else {

                        Map<Object,Object> scoremap = new HashMap<>();
                        scoremap.put("uniqueID", getIntent().getStringExtra("UID"));
                        scoremap.put("score",score);
                        scoremap.put("date", ServerValue.TIMESTAMP);

                        database.collection("users").add(scoremap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Toast.makeText(MainActivity.this, "Database connection succes!", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Database connection failed!", Toast.LENGTH_LONG).show();
                            }
                        });

                        Intent intent = new Intent(MainActivity.this, QuizEndActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

            A5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    question = (TextView) findViewById(R.id.QuestionsView);
                    scoretest = (TextView) findViewById(R.id.scoretest);
                    score += 4;
                    if(index<Questions.length-1) {
                        index++;
                        question.setText(Questions[index]);
                        scoretest.setText(String.valueOf(score));
                    }else {

                        Map<Object,Object> scoremap = new HashMap<>();
                        scoremap.put("uniqueID", getIntent().getStringExtra("UID"));
                        scoremap.put("score",score);
                        scoremap.put("date", ServerValue.TIMESTAMP);

                        database.collection("users").add(scoremap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Toast.makeText(MainActivity.this, "Database connection succes!", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Database connection failed!", Toast.LENGTH_LONG).show();
                            }
                        });

                        Intent intent = new Intent(MainActivity.this, QuizEndActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

            A6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    question = (TextView) findViewById(R.id.QuestionsView);
                    scoretest = (TextView) findViewById(R.id.scoretest);
                    score += 5;
                    if(index<Questions.length-1) {
                        index++;
                        question.setText(Questions[index]);
                        scoretest.setText(String.valueOf(score));
                    }else {

                        Map<Object,Object> scoremap = new HashMap<>();
                        scoremap.put("uniqueID", getIntent().getStringExtra("UID"));
                        scoremap.put("score",score);
                        scoremap.put("date", ServerValue.TIMESTAMP);

                        database.collection("users").add(scoremap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //Toast.makeText(MainActivity.this, "Database connection succes!", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Database connection failed!", Toast.LENGTH_LONG).show();
                            }
                        });

                        Intent intent = new Intent(MainActivity.this, QuizEndActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });





    }
}
