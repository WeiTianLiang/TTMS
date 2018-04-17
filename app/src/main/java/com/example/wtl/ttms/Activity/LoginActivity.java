package com.example.wtl.ttms.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms.R;
import com.example.wtl.ttms.Tool.HideScreenTop;

import yanzhikai.textpath.AsyncTextPathView;
import yanzhikai.textpath.SyncTextPathView;
import yanzhikai.textpath.painter.FireworksPainter;
import yanzhikai.textpath.painter.PenPainter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout frontback;
    private EditText account;
    private EditText possword;
    private SyncTextPathView first_start;
    private TextView login;
    private TextView forgot;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        HideScreenTop.HideScreenTop(getWindow());
        Montior();
        frontback.getBackground().setAlpha(220);
        account.getBackground().setAlpha(100);
        possword.getBackground().setAlpha(100);
        first_start.setPathPainter(new PenPainter());
        first_start.startAnimation(0, 1);
    }

    private void Montior() {
        frontback = (LinearLayout) findViewById(R.id.frontback);
        account = (EditText) findViewById(R.id.Account);
        possword = (EditText) findViewById(R.id.Password);
        first_start = (SyncTextPathView) findViewById(R.id.first_start);
        login = (TextView) findViewById(R.id.login);
        forgot = (TextView) findViewById(R.id.forgot);
        register = (TextView) findViewById(R.id.register);

        login.setOnClickListener(this);
        forgot.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.forgot:
                Intent intent2 = new Intent(LoginActivity.this,ForgotRegisterActivity.class);
                startActivity(intent2);
                break;
            case R.id.register:
                Intent intent1 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
