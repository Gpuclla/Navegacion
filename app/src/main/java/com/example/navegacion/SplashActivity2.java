package com.example.navegacion;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import pl.droidsonroids.gif.GifImageView;

public class SplashActivity2 extends AppCompatActivity {

    public static final long SPLASH_SCREEN_DELAY = 6000;
    MediaPlayer mp;
    Animation topanima, bottonanim;
    GifImageView img1, img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        topanima= AnimationUtils.loadAnimation(this,R.anim.top_animacion);
        bottonanim= AnimationUtils.loadAnimation(this,R.anim.boton_animacion);
        img1=findViewById(R.id.uac);
        img2=findViewById(R.id.sistemas);

        img1.setAnimation(topanima);
        img2.setAnimation(bottonanim);
        mp=MediaPlayer.create(SplashActivity2.this,R.raw.intro);
        mp.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass(SplashActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_DELAY);

    }
}
