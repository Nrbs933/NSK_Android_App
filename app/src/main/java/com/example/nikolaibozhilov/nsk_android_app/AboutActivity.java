package com.example.nikolaibozhilov.nsk_android_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Nikolai Bozhilov on 14-Oct-16.
 */

public class AboutActivity extends AppCompatActivity {

    private TextView aboutTxt;
    private Animation animation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);

        animation = AnimationUtils.loadAnimation(this,R.anim.about_animation);
        aboutTxt = (TextView) findViewById(R.id.txtAboutText);
        aboutTxt.setText("NSK ANROID \n\n\n"+"MADE BY \n"+"Nikolay Bozhilov\n"+"Stanislav Bozhilov\n"+"Kristiyan Belev\n");
        aboutTxt.startAnimation(animation);
    }
}
