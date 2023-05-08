package com.example.notagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int countY = 0;
    int countN = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton secret = findViewById(R.id.secret);
        Button yes = findViewById(R.id.Yes);
        TextView yestext = findViewById(R.id.Yes);
        TextView text = findViewById(R.id.text);
        Button no = findViewById(R.id.No);
        TextView notext = findViewById(R.id.No);

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (countY==0 && countN==0) {
                    text.setText("Система: Когда ты скачивал меня, ты думал, что я игра? Нет! Я живое приложение!  Я тебя огорчила? Хочешь выйти?");
                    yestext.setText("Да");
                    notext.setText("Нет");
                    countY++;
                    countN++;
                } else if (countY==1) {
                    System.exit(0);
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (countN==0) {
                    text.setText("Система: Ты злой:(");
                    yestext.setText(":(");
                    notext.setText(":(");
                    yes.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                            startActivity(intent);
                        }
                    });
                    no.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                            startActivity(intent);
                        }
                    });
                }else if (countY==1 && countN==1) {
                    text.setText("Система: Ты перепутал кнопку?");
                    countN++;
                }else if (countY==1 && countN==2) {
                    text.setText("Система: Давай я сама закроюсь?");
                    countN++;
                }else if (countY==1 && countN==3) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });

        secret.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Secret.class);
                startActivity(intent);
            }
        });
    }
}

