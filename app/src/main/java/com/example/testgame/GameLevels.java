package com.example.testgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w= getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);finish();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //Кнопка уровень 1
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e) {
                }
            }
        });
        //Button Level 1 - finish
        //Кнопка уровень 2
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 3
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level3.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 4
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });
//Кнопка уровень 4
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level5.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 6
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level6.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 7
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level7.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 8
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level8.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 9
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level9.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 10
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level10.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });
        //Кнопка уровень 29
        TextView textView29 = (TextView) findViewById(R.id.textView29);
        textView29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, level29.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
            }
        });


    }
    //Системная кнопка
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    }