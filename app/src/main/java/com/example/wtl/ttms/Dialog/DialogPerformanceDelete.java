package com.example.wtl.ttms.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.wtl.ttms.R;

/**
 * 演出厅信息删除弹窗
 * Created by WTL on 2018/4/14.
 */

public class DialogPerformanceDelete extends Dialog{

    private TextView dialog_cancel;
    private TextView dialog_sure;
    private TextView delete_name;

    private OnCanceClickListener onCanceClickListener;
    private OnSureClickListener onSureClickListener;

    public DialogPerformanceDelete(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_performance_delete);
        Montior();
        initEven();
    }

    private void Montior() {
        dialog_cancel = findViewById(R.id.dialog_cancel);
        dialog_sure = findViewById(R.id.dialog_sure);
        delete_name = findViewById(R.id.delete_name);
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
                onSureClickListener.onSureClick();
            }
        });
    }

    public void setDelete_name(String name) {
        delete_name.setText(name);
    }

    public interface OnCanceClickListener {
        void onCanceClick();
    }

    public interface OnSureClickListener {
        void onSureClick();
    }

    public void setOnCanceClickListener(OnCanceClickListener onCanceClickListener) {
        this.onCanceClickListener = onCanceClickListener;
    }

    public void setOnSureClickListener(OnSureClickListener onSureClickListener) {
        this.onSureClickListener = onSureClickListener;
    }

}
