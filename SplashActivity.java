package com.example.pallabi.pharmiz;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    ProgressBar mprogress;
    int i=0;
    Handler hdlr = new Handler();
    TextView txtView,logo,tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT<16){
            Window w=getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else{
            View decorView = getWindow().getDecorView();
            //hide the status bar
            int visibility=View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(visibility);
            //Hide action bar that too if necessary
            ActionBar actionBar=getSupportActionBar();
            assert actionBar!=null;
//            actionBar.hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView= findViewById(R.id.im2);
        mprogress = findViewById(R.id.splash_screen_progress_bar);
        txtView= findViewById(R.id.tView);
        logo= findViewById(R.id.logo);
        tag=  findViewById(R.id.tag);

        Animation ani1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomandrotate);
        imageView.startAnimation(ani1);
        Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_left);
        logo.startAnimation(animation);
        Animation animation1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        tag.startAnimation(animation1);

        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void startApp() {
        if (PreferenceManager.getDefaultSharedPreferences(this)
                .getString(Key.EMAIL,"").equals("")) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        else
            startActivity(new Intent(getApplicationContext(),ListActivity.class));
    }

    private void doWork() {
        i = mprogress.getProgress();
        while (i < 100) {
            i += 2;
            hdlr.post(new Runnable() {
                public void run() {
                    mprogress.setProgress(i);
                    txtView.setText(i+"/"+mprogress.getMax());
                }
            });
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
