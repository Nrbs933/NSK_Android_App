package com.example.nikolaibozhilov.nsk_android_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikolaibozhilov.nsk_android_app.model.User;
import com.orm.SugarContext;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView registerLink;
    EditText etUsername, etPassword;
    Button btnLogin;
    public static String userProfile = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.btnLogin));
        registerLink = (TextView) findViewById(R.id.txtRegisterLink);
        etUsername = (EditText) findViewById(R.id.etLoginUsername);
        etPassword = (EditText) findViewById(R.id.etLoginPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);

    }
    public static String getProfileUser(){
        return userProfile;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String loginUsername = etUsername.getText().toString();
                String loginPassword = etPassword.getText().toString();
                SugarContext.init(getApplicationContext());
                ArrayList<String> arrUserPass = new ArrayList<>();
                if(!loginUsername.isEmpty() || !loginPassword.isEmpty()){
                    List<User> dbUsernamePasswordList = User.find(User.class, "username = ? and password = ?",loginUsername, loginPassword);
                    if(dbUsernamePasswordList.size()>0){
                        for(User user:dbUsernamePasswordList) {
                            arrUserPass.add(user.getUsername());
                            arrUserPass.add(user.getPassword());
                        }
                        String dbUsername = arrUserPass.get(0);
                        String dbPassword = arrUserPass.get(1);

                        if (dbUsername.equals(loginUsername) && dbPassword.equals(loginPassword)) {
                            userProfile = userProfile.replace(userProfile,loginUsername);
                            //Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(this, ProfileActivity.class));
                        }
                        else{
                            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(this, "Username does not exist, Please make a registration", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(this, "Username or password cannot be empty", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.txtRegisterLink:
                startActivity(new Intent(this, RegisterActivity.class));
            break;
        }
    }
}
