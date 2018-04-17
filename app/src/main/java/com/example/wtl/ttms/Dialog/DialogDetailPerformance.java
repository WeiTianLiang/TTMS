package com.example.wtl.ttms.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.wtl.ttms.R;

/**
 * 演出厅信息详情
 * Created by WTL on 2018/4/15.
 */

public class DialogDetailPerformance extends Dialog {

    private TextView details_performance_id;
    private TextView details_performance_name;
    private TextView details_performance_row;
    private TextView details_performance_column;

    public DialogDetailPerformance(@NonNull Context context) {
        super(context,R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_performance_details);
        Montior();
    }

    private void Montior() {
        details_performance_id = findViewById(R.id.details_performance_id);
        details_performance_name = findViewById(R.id.details_performance_name);
        details_performance_row = findViewById(R.id.details_performance_row);
        details_performance_column = findViewById(R.id.details_performance_column);
    }

    public void setperformanceText(String performance_id,String performance_name,String performance_row,String performance_column) {
        details_performance_id.setText(performance_id);
        details_performance_name.setText(performance_name);
        details_performance_row.setText(performance_row);
        details_performance_column.setText(performance_column);
    }
}
