package com.example.testgame;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;

    public int numLeft; //Переменная для левой картинки
    public int numRight; //Переменная для правой картинки
    Array array = new Array(); // Создали новый объект из класса Array
    Random random = new Random(); // Для генерации случайных чисел
    public int count = 0; //Счетчик правильных ответов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1); //Установили текст

        final ImageView imgleft = (ImageView)findViewById(R.id.imgleft);
        //round corner
        imgleft.setClipToOutline(true);
        final ImageView imgright = (ImageView)findViewById(R.id.imgright);
        //round corner
        imgright.setClipToOutline(true);

        //Путь к левой TextView
        final TextView text_left = findViewById(R.id.textleft);
        final TextView text_right = findViewById(R.id.textright);
        //Fullscreen
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Dialog window
        dialog = new Dialog(this); //создаем окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //Скрываем заголовок
        dialog.setContentView(R.layout.previewdialog); //Путь к макету
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// Прозрачный фон
        dialog.setCancelable(false); //Кнопка назад откл
        //Кнопка которая закрывает диалоговое окно - Начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки - Начало
                try {
                    //Вернуться назад к выбору уровней - Начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);//Создали намерение для перехода
                    startActivity(intent);//Старт намерения
                    finish();//закрыть этот класс
                    //Вернуться назад к выбору уровней - Конец
                }catch (Exception e) {
                    //Здесь кода не будет
                }
                dialog.dismiss();//Закрываем окно
                //Обрабатываем нажатие кнопки - Конец
            }
        });
        //Кнопка которая закрывает диалоговое окно - Конец


        //Кнопка "Продолжить" - Начало
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); //Закрываем диалоговое окно
            }
        });
        //Кнопка "Продолжить" - Конец

        dialog.show();// Показать окно
        //Кнопка "Назад" - Начало
        Button btn_back = (Button) findViewById(R.id.button_back_level1);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обработка нажатия - Начало
                try {
                    //Вернуться к выбору уровней - Начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    //Вернуться к выбору уровней - Конец
                }catch (Exception e) {

                }
                //Обработка нажатия - Конец
            }
        });
        //Кнопка "Назад" - Конец

        //Массив для прогресса игры - Начало
        final int[] progress = {
            R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,R.id.point6,R.id.point7,
            R.id.point8,R.id.point9,R.id.point10,R.id.point11,R.id.point12,R.id.point13,R.id.point14,
            R.id.point15,R.id.point16,R.id.point17,R.id.point18,R.id.point19,R.id.point20,
        };
        //Массив для прогресса игры - Конец


        //Подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);
        //Подключаем анимацию - конец

        numLeft = random.nextInt(10);//Генерируем случайное число
        imgleft.setImageResource(array.images1[numLeft]);//Достаем картинку
        text_left.setText(array.texts1[numLeft]);//Достаем из массива текст

        numRight = random.nextInt(10);//Генерируем правое число
        //Цикл с предусловием, проверяющее равенство чисел - начало
        while (numLeft==numRight){
            numRight = random.nextInt(10);
        }
        //Цикл с предусловием, проверяющее равенство чисел - конец
        imgright.setImageResource(array.images1[numRight]);
        text_right.setText(array.texts1[numRight]);

        //Обрабатываем нажатие на левую картинку - Начало
        imgleft.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условаия касания - НАчало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgright.setEnabled(false);//Блокируем правую картинку
                    if (numLeft > numRight) {
                        imgleft.setImageResource(R.drawable.imgtrue);
                    } else {
                        imgleft.setImageResource(R.drawable.imgfalse);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //Если отпустил палец - начало
                    if (numLeft > numRight) {
                        if (count < 20) {
                            count = count + 1;
                        }
                        //Закрашиваем прогресс - начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);//Закрашиваем серым
                        }
                        //Закрашиваем прогресс - конец
                        //Закрашиваем зеленым - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Закрашиваем зеленым - Конец
                    } else {
                        if (count > 0) {
                            if (count==1) {
                                count=0;
                            } else {
                                count = count - 2;
                            }
                        }
                        //Закрашиваем прогресс - начало
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);//Закрашиваем серым
                        }
                        //Закрашиваем прогресс - конец
                        //Закрашиваем зеленым - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Закрашиваем зеленым - Конец
                    }
                    if (count==20){
                        //Выход из уровня
                    }else {
                        numLeft = random.nextInt(10);//Генерируем случайное число
                        imgleft.setImageResource(array.images1[numLeft]);//Достаем картинку
                        imgleft.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);//Достаем из массива текст

                        numRight = random.nextInt(10);//Генерируем правое число
                        //Цикл с предусловием, проверяющее равенство чисел - начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //Цикл с предусловием, проверяющее равенство чисел - конец
                        imgright.setImageResource(array.images1[numRight]);
                        imgright.startAnimation(a);
                        text_right.setText(array.texts1[numRight]);
                        imgright.setEnabled(true);
                    }
                }
                //Если отпустил палец - конец
                    return true;
            }    //Условаия касания - КОнец
        });
        //Обрабатываем нажатие на левую картинку - Конец
        //Обрабатываем нажатие на правую картинку - Начало
        imgright.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условаия касания - НАчало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgleft.setEnabled(false);//Блокируем левую картинку
                    if (numLeft < numRight) {
                        imgright.setImageResource(R.drawable.imgtrue);
                    } else {
                        imgright.setImageResource(R.drawable.imgfalse);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //Если отпустил палец - начало
                    if (numLeft < numRight) {
                        if (count < 20) {
                            count = count + 1;
                        }
                        //Закрашиваем прогресс - начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);//Закрашиваем серым
                        }
                        //Закрашиваем прогресс - конец
                        //Закрашиваем зеленым - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Закрашиваем зеленым - Конец
                    } else {
                        if (count > 0) {
                            if (count==1) {
                                count=0;
                            } else {
                                count = count - 2;
                            }
                        }
                        //Закрашиваем прогресс - начало
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);//Закрашиваем серым
                        }
                        //Закрашиваем прогресс - конец
                        //Закрашиваем зеленым - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Закрашиваем зеленым - Конец
                    }
                    if (count==20){
                        //Выход из уровня
                    }else {
                        numLeft = random.nextInt(10);//Генерируем случайное число
                        imgleft.setImageResource(array.images1[numLeft]);//Достаем картинку
                        imgleft.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);//Достаем из массива текст

                        numRight = random.nextInt(10);//Генерируем правое число
                        //Цикл с предусловием, проверяющее равенство чисел - начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //Цикл с предусловием, проверяющее равенство чисел - конец
                        imgright.setImageResource(array.images1[numRight]);
                        imgright.startAnimation(a);
                        text_right.setText(array.texts1[numRight]);
                        imgleft.setEnabled(true);
                    }
                }
                //Если отпустил палец - конец
                return true;
            }    //Условаия касания - КОнец
        });
        //Обрабатываем нажатие на правую картинку - конец



    }
    //Системная кнопка назад - Начало
    @Override
    public void onBackPressed() {
        //Обработка нажатия - Начало
        super.onBackPressed();
        try {
            //Вернуться к выбору уровней - Начало
            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent);
            finish();
            //Вернуться к выбору уровней - Конец
        } catch (Exception e) {
        }
    }
    //Системная кнопка назад - Конец
}