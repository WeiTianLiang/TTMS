package com.example.wtl.ttms.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wtl.ttms.R;

/**
 * 影片修改
 * Created by WTL on 2018/4/16.
 */

public class DialogFilmChange extends Dialog{
    private TextView dialog_cancel;
    private TextView dialog_sure;
    private EditText dialog_film_type;
    private EditText dialog_film_name;
    private EditText dialog_film_time;
    private EditText dialog_film_director;
    private EditText dialog_film_price;

    private OnCanceClickListener onCanceClickListener;
    private OnSureClickListener onSureClickListener;

    private String film_type;
    private String film_name;
    private String film_time;
    private String film_director;
    private String film_price;

    public DialogFilmChange(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_film_change);
        Montior();
        initEven();
    }

    private void Montior() {
        dialog_cancel = findViewById(R.id.dialog_cancel);
        dialog_sure = findViewById(R.id.dialog_sure);
        dialog_film_type = findViewById(R.id.dialog_film_type);
        dialog_film_name = findViewById(R.id.dialog_film_name);
        dialog_film_time = findViewById(R.id.dialog_film_time);
        dialog_film_director = findViewById(R.id.dialog_film_director);
        dialog_film_price = findViewById(R.id.dialog_film_price);
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
                film_type = dialog_film_type.getText().toString();
                film_name = dialog_film_name.getText().toString();
                film_time = dialog_film_time.getText().toString();
                film_director = dialog_film_director.getText().toString();
                film_price = dialog_film_price.getText().toString();
                onSureClickListener.onSureClick(film_type,film_name,film_time,film_director,film_price);
            }
        });
    }

    public void setChangeText(String film_type,String film_name,String film_time,String film_director,String film_price) {
        dialog_film_type.setText(film_type);
        dialog_film_name.setText(film_name);
        dialog_film_time.setText(film_time);
        dialog_film_director.setText(film_director);
        dialog_film_price.setText(film_price);
    }

    public interface OnCanceClickListener {
        void onCanceClick();
    }

    public interface OnSureClickListener {
        void onSureClick(String film_type,String film_name,String film_time,String film_director,String film_price);
    }

    public void setOnCanceClickListener(OnCanceClickListener onCanceClickListener) {
        this.onCanceClickListener = onCanceClickListener;
    }

    public void setOnSureClickListener(OnSureClickListener onSureClickListener) {
        this.onSureClickListener = onSureClickListener;
    }
}
