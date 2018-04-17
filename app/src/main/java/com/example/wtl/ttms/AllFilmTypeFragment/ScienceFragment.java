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
 * 科幻片
 * Created by WTL on 2018/4/16.
 */

public class ScienceFragment extends Fragment{

    private List<Film> filmList = new ArrayList<>();
    private RecyclerView film_recycler;

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
        final FilmAdapter adapter = new FilmAdapter(filmList,getContext());
        film_recycler.setAdapter(adapter);
        return view;
    }

    private void init() {
        Film film2 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film2);
        Film film23 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film23);
        Film film22 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film22);
        Film film222 = new Film("科幻片","明日边缘","100分钟","不知道","￥24");
        filmList.add(film222);
    }

}
