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

public class RegisterActivity extends AppCompatActivity {

    private EditText register_id;
    private EditText register_name;
    private EditText register_possword;
    private EditText repeat_pssword;
    private TextView register;
    private LinearLayout registerfront;
    private SyncTextPathView register_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        HideScreenTop.HideScreenTop(getWindow());
        Montior();
        registerfront.getBackground().setAlpha(220);
        register_id.getBackground().setAlpha(100);
        register_name.getBackground().setAlpha(100);
        register_possword.getBackground().setAlpha(100);
        repeat_pssword.getBackground().setAlpha(100);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        register_head.setPathPainter(new PenPainter());
        register_head.startAnimation(0, 1);
    }

    private void Montior() {
        register_id = (EditText) findViewById(R.id.register_id);
        register_name = (EditText) findViewById(R.id.register_name);
        register_possword = (EditText) findViewById(R.id.register_possword);
        repeat_pssword = (EditText) findViewById(R.id.repeat_pssword);
        register = (TextView) findViewById(R.id.register);
        registerfront = (LinearLayout) findViewById(R.id.registerfront);
        register_head = (SyncTextPathView) findViewById(R.id.register_head);
    }
}
