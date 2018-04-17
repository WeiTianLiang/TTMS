package com.example.wtl.ttms.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.wtl.ttms.R;

/**
 * 影片详情
 * Created by WTL on 2018/4/17.
 */

public class DialogDetailFilm extends Dialog{

    private TextView details_film_type;
    private TextView details_film_name;
    private TextView details_film_time;
    private TextView details_film_director;
    private TextView details_film_price;

    public DialogDetailFilm(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_film_details);
        Montior();
    }

    private void Montior() {
        details_film_type = findViewById(R.id.details_film_type);
        details_film_name = findViewById(R.id.details_film_name);
        details_film_time = findViewById(R.id.details_film_time);
        details_film_director = findViewById(R.id.details_film_director);
        details_film_price = findViewById(R.id.details_film_price);
    }

    public void setfilmText(String film_type,String film_name,String film_time,String film_director,String film_price) {
        details_film_type.setText(film_type);
        details_film_name.setText(film_name);
        details_film_time.setText(film_time);
        details_film_director.setText(film_director);
        details_film_price.setText(film_price);
    }

}
