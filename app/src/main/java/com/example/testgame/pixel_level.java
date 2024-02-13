package com.example.testgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class pixel_level extends AppCompatActivity {
    public int pixelImg;

        public int count = 0; //Счетчик правильных ответов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_pixel);

        // Получаем ссылки на элементы из макета
        ImageView questionImageView = findViewById(R.id.pixelImg);
        TextView questionTextView = findViewById(R.id.text_levels_description);
        Button answerButton1 = findViewById(R.id.answerButton1);
        Button answerButton2 = findViewById(R.id.answerButton2);
        Button answerButton3 = findViewById(R.id.answerButton3);
        Button answerButton4 = findViewById(R.id.answerButton4);

        // Установка изображения и текста вопроса
        questionImageView.setImageResource(R.drawable.camrypxl); // Замените your_image на имя вашего изображения в ресурсах
        questionTextView.setText("Что на картинке?");

        // Установка текста на кнопках с вариантами ответа
        answerButton1.setText("Ответ 1");
        answerButton2.setText("Ответ 2");
        answerButton3.setText("Ответ 3");
        answerButton4.setText("Ответ 4");

        // Обработка нажатий на кнопки с вариантами ответа
        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка выбора ответа 1
            }
        });

        answerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка выбора ответа 2
            }
        });

        answerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка выбора ответа 3
            }
        });

        answerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка выбора ответа 4
            }
        });
    }
    }
