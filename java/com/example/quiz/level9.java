package com.example.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class level9 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;


    public int numLeft;
    public int numRight;

    Array array = new Array();
    Random random = new Random();



    public int count = 0;//счетчик ответов


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создаем перееменую текст левлс
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);


        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        // скругляет углы левой
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        // скругляет углы правой
        img_right.setClipToOutline(true);


        final  TextView text_left = findViewById(R.id.text_left);

        final  TextView text_right = findViewById(R.id.text_right);


        //Развернуть игру н

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // развернуть игру к


        //вызово диалогово окна в начале игры
        dialog = new Dialog(this); //новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // закрытие диалог окно
        dialog.setContentView(R.layout.previewdialog); // путь к макету диалого окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалог окна
        dialog.setCancelable(false);

        //устанавливаем картинку начало
        ImageView previewimg = (ImageView)dialog.findViewById(R.id.previewing);
        previewimg.setImageResource(R.drawable.stekstek);

        //к

        //описание н

        TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.levelDef);

        //к


        //закртие диалог окна
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обратавыне наж кнопки
                try {
                    //вернутся к выбору ур
                    Intent intent = new Intent(level9.this, GameLevels.class); //намерение для перехода
                    startActivity(intent); //намерение
                    finish();//закрыть класс
                    //конец
                }catch (Exception e){
                    //нет кода
                }
                dialog.dismiss();//закрытие диалог окно

            }
        });
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show(); // показ диалог окна


        //_______________________________________________________//
        //вызово диалогово окна в начале игры
        dialogEnd = new Dialog(this); //новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // закрытие диалог окно
        dialogEnd.setContentView(R.layout.dialogend); // путь к макету диалого окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалог окна
        dialogEnd.setCancelable(false);

        //факты
        TextView textdeascriptionEnd =(TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdeascriptionEnd.setText(R.string.levelDefEnd);

        //факты


        //закртие диалог окна
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обратавыне наж кнопки
                try {
                    //вернутся к выбору ур
                    Intent intent = new Intent(level9.this, GameLevels.class); //намерение для перехода
                    startActivity(intent); //намерение
                    finish();//закрыть класс
                    //конец
                }catch (Exception e){
                    //нет кода
                }
                dialogEnd.dismiss();//закрытие диалог окно

            }
        });
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(level9.this, level10.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                }
                dialogEnd.dismiss();
            }
        });


        //_________________________________________________________//


        //нада начало

        Button btn_back = (Button)findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                //начало
                Intent intent = new Intent(level9.this, GameLevels.class);
                startActivity(intent);
                finish();
                //конец

            }catch (Exception e){
                //кода нет
            }
            }
        });
        //конец

        //массив для прогерсса


        final int[] progress = {
                R.id.pointi1, R.id.pointi2, R.id.pointi3, R.id.pointi4, R.id.pointi5, R.id.pointi6,
                R.id.pointi7, R.id.pointi8, R.id.pointi9, R.id.pointi10, R.id.pointi11, R.id.pointi12,
                R.id.pointi13, R.id.pointi14, R.id.pointi15, R.id.pointi16, R.id.pointi17, R.id.pointi18,
                R.id.pointi19, R.id.pointi20
        };

        //к


        //анимация н

        final Animation a = AnimationUtils.loadAnimation(level9.this, R.anim.alpha);

        //к


        ///МАСИВЫЫЫЫЫЫЫЫЫЫЫЫЫЫ
        numLeft = random.nextInt(10);
        img_left.setImageResource(array.imagest9[numLeft]);
        text_left.setText(array.texts9[numLeft]);

        numRight = random.nextInt(10);
        //цикл с пред условием

        while (numLeft == numRight) {
            numRight = random.nextInt(10);

        }


        img_right.setImageResource(array.imagest9[numRight]);
        text_right.setText(array.texts9[numRight]);


        //обратобтка л к

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN) {
                ///коснуться
                    img_right.setEnabled(false);
                    if(numLeft>numRight) {
                        img_left.setImageResource(R.drawable.yes);
                    }else{
                        img_left.setImageResource(R.drawable.no);
                    }
                }else if(event.getAction()== MotionEvent.ACTION_UP){
                    //палец кос
                    if(numLeft>numRight){
                        //если картин б
                        if (count<20){
                            count=count+1;
                        }
                        //сер ц н
                        for(int i=0;i<20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                            for(int i=0; i<count; i++){
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //к
                    }else {
                        //к
                         if(count>0) {
                             if(count ==1) {
                                 count=0;
                             }else {
                                 count=count-3;
                             }
                         }
                        for(int i=0;i<19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }


                    //к
                    if (count==20) {
                        //выход из уровня
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("level1", 1);
                        if(level >9) {

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("level", 10);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.imagest9[numLeft]);
                        img_left.setAnimation(a);
                        text_left.setText(array.texts9[numLeft]);

                        numRight = random.nextInt(10);
                        //цикл с пред условием

                        while (numLeft == numRight) {
                            numRight = random.nextInt(10);

                        }


                        img_right.setImageResource(array.imagest9[numRight]);
                        img_right.setAnimation(a);
                        text_right.setText(array.texts9[numRight]);

                        img_right.setEnabled(true);
                    }
                }


                return true;
            }
        });
        //к

        //обратобтка PRABAIIII кAPTINKY

        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN) {
                    ///коснуться
                    img_left.setEnabled(false);
                    if(numLeft<numRight) {
                        img_right.setImageResource(R.drawable.yes);
                    }else{
                        img_right.setImageResource(R.drawable.no);
                    }
                }else if(event.getAction()== MotionEvent.ACTION_UP){
                    //палец кос
                    if(numLeft<numRight){
                        //если картин б
                        if (count<20){
                            count=count+1;
                        }
                        //сер ц н
                        for(int i=0;i<20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //к
                    }else {
                        //к
                        if(count>0) {
                            if(count ==1) {
                                count=0;
                            }else {
                                count=count-3;
                            }
                        }
                        for(int i=0;i<19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }


                    //к
                    if (count==20) {
                        //выход из уровня
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("level1", 1);
                        if(level >9) {

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("level", 10);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.imagest9[numLeft]);
                        img_left.setAnimation(a);
                        text_left.setText(array.texts9[numLeft]);

                        numRight = random.nextInt(10);
                        //цикл с пред условием

                        while (numLeft == numRight) {
                            numRight = random.nextInt(10);

                        }


                        img_right.setImageResource(array.imagest9[numRight]);
                        img_right.setAnimation(a);
                        text_right.setText(array.texts9[numRight]);

                        img_left.setEnabled(true);
                    }
                }


                return true;
            }
        });
        //к


    }
    //систем начало
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            //начало
            Intent intent = new Intent(level9.this, GameLevels.class);
            startActivity(intent);
            finish();
            //конец

        } catch (Exception e) {
            //кода нет
        }
    }
    //систем конец



}