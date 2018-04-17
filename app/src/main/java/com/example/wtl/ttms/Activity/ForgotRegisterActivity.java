package com.example.wtl.ttms.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms.R;
import com.example.wtl.ttms.Tool.HideScreenTop;

import yanzhikai.textpath.SyncTextPathView;
import yanzhikai.textpath.painter.PenPainter;

public class ForgotRegisterActivity extends AppCompatActivity {

    private LinearLayout forgot_back;
    private SyncTextPathView forgot_head;
    private EditText forgot_id;
    private EditText forgot_possword;
    private EditText forgot_repeat_pssword;
    private TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_register);
        HideScreenTop.HideScreenTop(getWindow());
        Montior();
        forgot_back.getBackground().setAlpha(220);
        forgot_id.getBackground().setAlpha(100);
        forgot_possword.getBackground().setAlpha(100);
        forgot_repeat_pssword.getBackground().setAlpha(100);
        forgot_head.setPathPainter(new PenPainter());
        forgot_head.startAnimation(0,1);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Montior() {
        forgot_id = (EditText) findViewById(R.id.forgot_id);
        forgot_possword = (EditText) findViewById(R.id.forgot_possword);
        forgot_repeat_pssword = (EditText) findViewById(R.id.forgot_repeat_pssword);
        forgot = (TextView) findViewById(R.id.forgot);
        forgot_back = (LinearLayout) findViewById(R.id.forgot_back);
        forgot_head = (SyncTextPathView) findViewById(R.id.forgot_head);
    }
}
