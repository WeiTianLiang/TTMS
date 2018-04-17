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
 * 演出厅信息修改弹窗
 * Created by WTL on 2018/4/14.
 */

public class DialogPerformanceChange extends Dialog {
    private TextView dialog_cancel;
    private TextView dialog_sure;
    private EditText dialog_performance_id;
    private EditText dialog_performance_name;
    private EditText dialog_performance_row;
    private EditText dialog_performance_column;

    private OnCanceClickListener onCanceClickListener;
    private OnSureClickListener onSureClickListener;

    private String performance_id;
    private String performance_name;
    private String performance_row;
    private String performance_column;

    public DialogPerformanceChange(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_performance_change);
        Montior();
        initEven();
        dialog_performance_row.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        dialog_performance_column.setInputType(EditorInfo.TYPE_CLASS_PHONE);
    }

    private void Montior() {
        dialog_cancel = findViewById(R.id.dialog_cancel);
        dialog_sure = findViewById(R.id.dialog_sure);
        dialog_performance_id = findViewById(R.id.dialog_performance_id);
        dialog_performance_name = findViewById(R.id.dialog_performance_name);
        dialog_performance_row = findViewById(R.id.dialog_performance_row);
        dialog_performance_column = findViewById(R.id.dialog_performance_column);
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
                performance_id = dialog_performance_id.getText().toString();
                performance_name = dialog_performance_name.getText().toString();
                performance_row = dialog_performance_row.getText().toString();
                performance_column = dialog_performance_column.getText().toString();
                onSureClickListener.onSureClick(performance_id,performance_name,performance_row,performance_column);
            }
        });
    }

    public void setChangeText(String performance_id,String performance_name,String performance_row,String performance_column) {
        dialog_performance_id.setText(performance_id);
        dialog_performance_name.setText(performance_name);
        dialog_performance_row.setText(performance_row);
        dialog_performance_column.setText(performance_column);
    }

    public interface OnCanceClickListener {
        void onCanceClick();
    }

    public interface OnSureClickListener {
        void onSureClick(String performance_id,String performance_name,String performance_row,String performance_column);
    }

    public void setOnCanceClickListener(OnCanceClickListener onCanceClickListener) {
        this.onCanceClickListener = onCanceClickListener;
    }

    public void setOnSureClickListener(OnSureClickListener onSureClickListener) {
        this.onSureClickListener = onSureClickListener;
    }
}
