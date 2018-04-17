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
 * 员工信息修改弹窗
 * Created by WTL on 2018/4/14.
 */

public class DialogStaffChange extends Dialog {

    private TextView dialog_cancel;
    private TextView dialog_sure;
    private EditText dialog_identity;
    private EditText dialog_name;
    private EditText dialog_id;
    private EditText dialog_phone;
    private EditText dialog_address;

    private OnCanceClickListener onCanceClickListener;
    private OnSureClickListener onSureClickListener;

    private String identity;
    private String name;
    private String id;
    private String phone;
    private String address;

    public DialogStaffChange(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_staff_change);
        Montior();
        initEven();
        dialog_id.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        dialog_phone.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    }

    private void Montior() {
        dialog_cancel = findViewById(R.id.dialog_cancel);
        dialog_sure = findViewById(R.id.dialog_sure);
        dialog_identity = findViewById(R.id.dialog_identity);
        dialog_name = findViewById(R.id.dialog_name);
        dialog_id = findViewById(R.id.dialog_id);
        dialog_phone = findViewById(R.id.dialog_phone);
        dialog_address = findViewById(R.id.dialog_address);
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
                identity = dialog_identity.getText().toString();
                name = dialog_name.getText().toString();
                id = dialog_id.getText().toString();
                phone = dialog_phone.getText().toString();
                address = dialog_address.getText().toString();
                onSureClickListener.onSureClick(identity,name,id,phone,address);
            }
        });
    }

    public void setChangeText(String identity,String name,String id,String phone,String address) {
        dialog_identity.setText(identity);
        dialog_name.setText(name);
        dialog_id.setText(id);
        dialog_phone.setText(phone);
        dialog_address.setText(address);
    }

    public interface OnCanceClickListener {
        void onCanceClick();
    }

    public interface OnSureClickListener {
        void onSureClick(String identity,String name,String id,String phone,String address);
    }

    public void setOnCanceClickListener(OnCanceClickListener onCanceClickListener) {
        this.onCanceClickListener = onCanceClickListener;
    }

    public void setOnSureClickListener(OnSureClickListener onSureClickListener) {
        this.onSureClickListener = onSureClickListener;
    }

}
