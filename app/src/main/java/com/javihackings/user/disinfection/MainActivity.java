package com.javihackings.user.disinfection;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        View fondo = findViewById(R.id.logo);
        ObjectAnimator anim = ObjectAnimator.ofInt(fondo, "backgroundColor", Color.BLACK,0x8200C8);
        anim.setDuration(500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
        ImageView img_animation = (ImageView) findViewById(R.id.logo);
        int min = 200;
        int max = 400;
        Random r = new Random();
        int maxAnim = 100;
        AnimationSet s = new AnimationSet(true);
        TranslateAnimation[] animation = new TranslateAnimation[maxAnim];
        for(int i=0; i<maxAnim;i++) {
            int i1 = r.nextInt(max)-min;
            int i2 = r.nextInt(max)-min;
            animation[i] = new TranslateAnimation(0.0f, i1, 0.0f, i2); //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
            animation[i].setDuration(1000);  // animation duration
            //animation.setRepeatCount(5);  // animation repeat count
            animation[i].setRepeatMode(2);   // repeat animation (left to right, right to left )
            //animation.setFillAfter(true);
            //img_animation.startAnimation(animation[i]);
            s.addAnimation(animation[i]);
            animation[i].setStartOffset(5000*i);
        }
        img_animation.startAnimation(s);
    }
}
