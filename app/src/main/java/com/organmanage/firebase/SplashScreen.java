package com.organmanage.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private ImageView logo;
    private TextView title,slogan;


    Animation topAnimation,bottomAnimation;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }

        progressBar= (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        logo =findViewById(R.id.logo);
        title=findViewById(R.id.title);
        slogan =findViewById(R.id.slogan);

        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        logo.setAnimation(topAnimation);
        title.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);

        int SPLASH_SCREEN=4300;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent();
                intent.setClass(SplashScreen.this,
                        LoginActivity.class);

                startActivity(intent);
                finish();

            }
        }, SPLASH_SCREEN);
    }
}
