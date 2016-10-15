package com.example.nikolaibozhilov.nsk_android_app;

import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikolaibozhilov.nsk_android_app.model.Classes;
import com.example.nikolaibozhilov.nsk_android_app.model.User;
import com.orm.SugarContext;
import com.orm.SugarDb;


import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    TextView loginLink;
    EditText etUsername, etPassword, etEmail;
    Button btnRegister;
    Spinner favClass;
    ArrayList itemSelected = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        setTitle(getString(R.string.btnRegister));

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        favClass = (Spinner) findViewById(R.id.favClass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        loginLink = (TextView) findViewById(R.id.txtLoginLink);
        loginLink.setOnClickListener(this);
        btnRegister.setOnClickListener(this);


        favClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                itemSelected.add(parent.getItemAtPosition(pos).toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                //Delete DB if exist and create new
                //deleteDbIfExistAndInitNew();

                //Add users to already existing DB
                registerUser();

                break;
            case R.id.txtLoginLink:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
    private boolean doesDatabaseExist(ContextWrapper context, String dbName){
        File dbFIle = context.getDatabasePath(dbName);
        return dbFIle.exists();
    }
    private void initDbWithUser(String username, String password, String email, String favoriteClass){
        User user = new User(username, password, email, favoriteClass);
        user.save();
    }

    private void deleteDbIfExistAndInitNew(){
        String etUsr = etUsername.getText().toString();
        String etPass = etPassword.getText().toString();
        String etMail = etEmail.getText().toString();
        if(!(etUsr.isEmpty() || etPass.isEmpty() || etMail.isEmpty())) {
            if (doesDatabaseExist(this, "nsk_database.db")) {
                SugarDb sugarDb = new SugarDb(getApplicationContext());
                new File(sugarDb.getDB().getPath()).delete();
                SugarContext.init(getApplicationContext());
                boolean doesDbExist = doesDatabaseExist(this, "nsk_database.db");
                if (!doesDbExist) {
                    User.findById(User.class, (long) 1);
                    initDbWithUser(etUsername.getText().toString(), etPassword.getText().toString(), etEmail.getText().toString(), "");
                    Toast.makeText(this, "User created !", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Fields can not be empty !", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void registerUser(){
        String etUsr = etUsername.getText().toString();
        String etMail = etEmail.getText().toString();
        String etPass = etPassword.getText().toString();

        if(!(etUsr.isEmpty() || etPass.isEmpty() || etMail.isEmpty())) {
            SugarContext.init(getApplicationContext());
            List<User> usernamesTakenList = User.find(User.class, "username = ?",etUsr);
            List<User> emailsTakenList = User.find(User.class, "email = ?",etMail);

            int usernameTakenSize = usernamesTakenList.size();
            int emailTakenSize = emailsTakenList.size();
            if(usernameTakenSize > 0 || emailTakenSize >0){
                if(usernameTakenSize > 0 && emailTakenSize ==0){
                    Toast.makeText(this, "Username is already taken",Toast.LENGTH_LONG).show();
                }
                else if(usernameTakenSize == 0 && emailTakenSize >0){
                    Toast.makeText(this, "Email is already taken",Toast.LENGTH_LONG).show();
                }

            }
            else{
                initDbWithUser(etUsername.getText().toString(), etPassword.getText().toString(), etEmail.getText().toString(), itemSelected.get(itemSelected.size()-1).toString());

                Toast.makeText(this, "User created, You can now login!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MainActivity.class));

            }
            } else {
                Toast.makeText(this, "Fields can not be empty !", Toast.LENGTH_LONG).show();
            }
        }

    }
