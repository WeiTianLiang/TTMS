package com.example.wtl.ttms.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.wtl.ttms.R;

/**
 * 员工信息详情
 * Created by WTL on 2018/4/15.
 */

public class DialogDetailStaff extends Dialog {

    private TextView details_identity;
    private TextView details_name;
    private TextView details_id;
    private TextView details_phone;
    private TextView details_address;

    public DialogDetailStaff(@NonNull Context context) {
        super(context,R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_staff_details);
        Montior();
    }

    private void Montior() {
        details_identity = findViewById(R.id.details_identity);
        details_name = findViewById(R.id.details_name);
        details_id = findViewById(R.id.details_id);
        details_phone = findViewById(R.id.details_phone);
        details_address = findViewById(R.id.details_address);
    }

    public void setChangeText(String identity,String name,String id,String phone,String address) {
        details_identity.setText(identity);
        details_name.setText(name);
        details_id.setText(id);
        details_phone.setText(phone);
        details_address.setText(address);
    }
}
