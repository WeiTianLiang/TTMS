package com.example.wtl.ttms.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wtl.ttms.R;

/**
 * 修改个人信息
 * Created by WTL on 2018/4/15.
 */

public class DialogPersonalChange extends Dialog {

    private TextView dialog_cancel;
    private TextView dialog_sure;
    private EditText personal_dialog_identity;
    private EditText personal_dialog_id;
    private EditText personal_dialog_name;
    private EditText personal_dialog_age;
    private EditText personal_dialog_sex;
    private EditText personal_dialog_phone;
    private EditText personal_dialog_address;

    private OnCanceClickListener onCanceClickListener;
    private OnSureClickListener onSureClickListener;

    private String dialog_identity;
    private String dialog_id;
    private String dialog_name;
    private String dialog_age;
    private String dialog_sex;
    private String dialog_phone;
    private String dialog_address;

    public DialogPersonalChange(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_personal);
        Montior();
        initEven();
        personal_dialog_age.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        personal_dialog_id.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        personal_dialog_phone.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    }

    private void Montior() {
        dialog_cancel = findViewById(R.id.dialog_cancel);
        dialog_sure = findViewById(R.id.dialog_sure);
        personal_dialog_identity = findViewById(R.id.personal_dialog_identity);
        personal_dialog_id = findViewById(R.id.personal_dialog_id);
        personal_dialog_name = findViewById(R.id.personal_dialog_name);
        personal_dialog_age = findViewById(R.id.personal_dialog_age);
        personal_dialog_sex = findViewById(R.id.personal_dialog_sex);
        personal_dialog_phone = findViewById(R.id.personal_dialog_phone);
        personal_dialog_address = findViewById(R.id.personal_dialog_address);
    }

    private void initEven() {
        dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCanceClickListener.onCanceClick();
            }
        });

        dialog_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_identity = personal_dialog_identity.getText().toString();
                dialog_id = personal_dialog_id.getText().toString();
                dialog_name = personal_dialog_name.getText().toString();
                dialog_age = personal_dialog_age.getText().toString();
                dialog_sex = personal_dialog_sex.getText().toString();
                dialog_phone = personal_dialog_phone.getText().toString();
                dialog_address = personal_dialog_address.getText().toString();
                onSureClickListener.onSureClick(dialog_identity,dialog_id,dialog_name,dialog_age,dialog_sex,dialog_phone,dialog_address);
            }
        });
    }

    public void setChangeText(String dialog_identity,String dialog_id,String dialog_name
            ,String dialog_age,String dialog_sex,String dialog_phone,String dialog_address) {
        personal_dialog_identity.setText(dialog_identity);
        personal_dialog_id.setText(dialog_id);
        personal_dialog_name.setText(dialog_name);
        personal_dialog_age.setText(dialog_age);
        personal_dialog_sex.setText(dialog_sex);
        personal_dialog_phone.setText(dialog_phone);
        personal_dialog_address.setText(dialog_address);
    }

    public interface OnCanceClickListener {
        void onCanceClick();
    }

    public interface OnSureClickListener {
        void onSureClick(String dialog_identity,String dialog_id,String dialog_name
                ,String dialog_age,String dialog_sex,String dialog_phone,String dialog_address);
    }

    public void setOnCanceClickListener(OnCanceClickListener onCanceClickListener) {
        this.onCanceClickListener = onCanceClickListener;
    }

    public void setOnSureClickListener(OnSureClickListener onSureClickListener) {
        this.onSureClickListener = onSureClickListener;
    }


}
