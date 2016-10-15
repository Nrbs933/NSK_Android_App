package com.example.nikolaibozhilov.nsk_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nikolaibozhilov.nsk_android_app.BossesActivities.BossesCategoryActivity;
import com.example.nikolaibozhilov.nsk_android_app.ClassesActivities.ClassesCategoryActivity;
import com.example.nikolaibozhilov.nsk_android_app.DungeonsActivities.DungeonsCategoryActivity;
import com.example.nikolaibozhilov.nsk_android_app.model.User;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 07-Oct-16.
 */

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtWelcome;
    Button btnLogout,btnClasses, btnDungeons, btnBosses, btnAbout;


    String user = MainActivity.getProfileUser();
    String userClassTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_layout);
        setTitle(getString(R.string.profileString));

        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnClasses = (Button) findViewById(R.id.btnClassesCategory);
        btnDungeons = (Button) findViewById(R.id.btnDungeonsCategory);
        btnBosses = (Button) findViewById(R.id.btnBossesCategory);
        btnAbout = (Button) findViewById(R.id.btnAbout);

        btnLogout.setOnClickListener(this);
        btnClasses.setOnClickListener(this);
        btnDungeons.setOnClickListener(this);
        btnBosses.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

        // SugarContext.init(getApplicationContext());
        List<User> favUserClassList = User.find(User.class, "username = ?",user);
        for(User user:favUserClassList){
            userClassTitle = userClassTitle.replace(userClassTitle,user.getFavoriteClass());
        }
        txtWelcome.setText("Welcome,"+ " \n " + user.toUpperCase().charAt(0) + user.substring(1,user.length())+" - The " + userClassTitle.toUpperCase().charAt(0) + userClassTitle.substring(1,userClassTitle.length()));

    }



    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnClassesCategory:
                    startActivity(new Intent(this, ClassesCategoryActivity.class));
                    break;
                case R.id.btnDungeonsCategory:
                    startActivity(new Intent(this, DungeonsCategoryActivity.class));
                    break;
                case R.id.btnBossesCategory:
                    startActivity(new Intent(this, BossesCategoryActivity.class));
                    break;
                case R.id.btnAbout:
                    startActivity(new Intent(this,AboutActivity.class));
                    break;
                case R.id.btnLogout:
                    startActivity(new Intent(this, MainActivity.class));
                    user = user.replace(user, "");
                    break;
            }
    }
}
