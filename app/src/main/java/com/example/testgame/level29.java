package com.example.testgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class level29 extends AppCompatActivity {

        private Button answerButton1, answerButton2, answerButton3, answerButton4;
        private ImageView questionImageView;

        Handler handler = new Handler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.level_pixel);

            //Кнопка "Назад" - Начало
            Button btn_back = (Button) findViewById(R.id.button_back_level1);
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Обработка нажатия - Начало
                    try {
                        //Вернуться к выбору уровней - Начало
                        Intent intent = new Intent(level29.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                        //Вернуться к выбору уровней - Конец
                    }catch (Exception e) {

                    }
                    //Обработка нажатия - Конец
                }
            });
            //Кнопка "Назад" - Конец


            // Находим кнопки ответов и изображение по их id
            answerButton1 = findViewById(R.id.answerButton1);
            answerButton2 = findViewById(R.id.answerButton2);
            answerButton3 = findViewById(R.id.answerButton3);
            answerButton4 = findViewById(R.id.answerButton4);
            questionImageView = findViewById(R.id.pixelImg);

            // Устанавливаем обработчик клика для каждой кнопки ответа
            answerButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(1);
                }
            });
            answerButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(2);
                }
            });

            answerButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(3);
                }
            });

            answerButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(4);
                }
            });
            // Повторите это для остальных кнопок

        }

        // Метод для проверки правильности ответа
        private void checkAnswer(int selectedAnswer) {
            if (selectedAnswer == 4) {
                // Правильный ответ
                Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show();
                // Изменяем цвет кнопки на зеленый
                answerButton4.setBackgroundResource(R.drawable.button_background_correct);
                // Заменяем изображение на новое
                questionImageView.setImageResource(R.drawable.camry);
                // Дополнительный код, например, переход на следующий уровень или что-то еще
            } else {
                // Неправильный ответ
                Toast.makeText(this, "Неправильно. Попробуйте еще раз!", Toast.LENGTH_SHORT).show();
                // Изменяем цвет кнопки на красный
                switch (selectedAnswer) {
                    case 1:
                        answerButton1.setBackgroundResource(R.drawable.button_background_incorrect);
                        break;
                    case 2:
                        answerButton2.setBackgroundResource(R.drawable.button_background_incorrect);
                        break;
                    case 3:
                        answerButton3.setBackgroundResource(R.drawable.button_background_incorrect);
                        break;
                }
                // Создаем Handler
               // Устанавливаем задержку в 3 секунды
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Возвращаем цвет кнопки на исходный
                        switch (selectedAnswer) {
                            case 1:
                                answerButton1.setBackgroundResource(R.color.btn_back);
                                break;
                            case 2:
                                answerButton2.setBackgroundResource(R.color.btn_back);
                                break;
                            case 3:
                                answerButton3.setBackgroundResource(R.color.btn_back);
                                break;
                        }
                    }
                }, 1000); // 1000 миллисекунд = 1 секунды
            }
        }
    }
