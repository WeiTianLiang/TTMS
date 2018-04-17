package com.example.wtl.ttms.AllFilmTypeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.ttms.Adapter.FilmAdapter;
import com.example.wtl.ttms.Class.Film;
import com.example.wtl.ttms.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 影片fragment
 * Created by WTL on 2018/4/16.
 */

public class AllFilmFragment extends Fragment {

    private List<Film> filmList = new ArrayList<>();
    private RecyclerView film_recycler;
    private FilmAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.film_racycler,container,false);
        film_recycler = view.findViewById(R.id.film_recycler);
        init();
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(200);
        animator.setChangeDuration(400);
        animator.setAddDuration(200);
        film_recycler.getBackground().setAlpha(150);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        film_recycler.setLayoutManager(manager);
        film_recycler.setItemAnimator(animator);
        adapter = new FilmAdapter(filmList,getContext());
        film_recycler.setAdapter(adapter);
        return view;
    }

    public void add(Film film) {

    }

    private void init() {
        Film film = new Film("恐怖片","猛鬼街","100分钟","不知道","￥24");
        filmList.add(film);
        Film film6 = new Film("恐怖片","猛鬼街2","100分钟","不知道","￥24");
        filmList.add(film6);
        Film film7 = new Film("恐怖片","猛鬼街3","100分钟","不知道","￥24");
        filmList.add(film7);
        Film film8 = new Film("恐怖片","猛鬼街4","100分钟","不知道","￥24");
        filmList.add(film8);

        Film film1 = new Film("搞笑片","大话西游","100分钟","不知道","￥24");
        filmList.add(film1);
        Film film11 = new Film("搞笑片","大话西游","100分钟","不知道","￥24");
        filmList.add(film11);
        Film film111 = new Film("搞笑片","大话西游","100分钟","不知道","￥24");
        filmList.add(film111);
        Film film1111 = new Film("搞笑片","大话西游","100分钟","不知道","￥24");
        filmList.add(film1111);

        Film film2 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film2);
        Film film23 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film23);
        Film film22 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film22);
        Film film222 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film222);

        Film film3 = new Film("爱情片","阿甘正传","100分钟","不知道","￥24");
        filmList.add(film3);
        Film film33 = new Film("爱情片","阿甘正传","100分钟","不知道","￥24");
        filmList.add(film33);
        Film film333 = new Film("爱情片","阿甘正传","100分钟","不知道","￥24");
        filmList.add(film333);
        Film film332 = new Film("爱情片","阿甘正传","100分钟","不知道","￥24");
        filmList.add(film332);
        Film film32 = new Film("爱情片","阿甘正传","100分钟","不知道","￥24");
        filmList.add(film32);

        Film film4 = new Film("战争片","血战钢锯岭","100分钟","不知道","￥24");
        filmList.add(film4);
        Film film44 = new Film("战争片","血战钢锯岭","100分钟","不知道","￥24");
        filmList.add(film44);
        Film film43 = new Film("战争片","血战钢锯岭","100分钟","不知道","￥24");
        filmList.add(film43);
        Film film42 = new Film("战争片","血战钢锯岭","100分钟","不知道","￥24");
        filmList.add(film42);

        Film film5 = new Film("动作片","功夫","100分钟","不知道","￥24");
        filmList.add(film5);
        Film film55 = new Film("动作片","功夫","100分钟","不知道","￥24");
        filmList.add(film55);
        Film film54 = new Film("动作片","功夫","100分钟","不知道","￥24");
        filmList.add(film54);
        Film film53 = new Film("动作片","功夫","100分钟","不知道","￥24");
        filmList.add(film53);
    }
}
