package com.example.wtl.ttms.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms.Class.Film;
import com.example.wtl.ttms.Dialog.DialogDetailFilm;
import com.example.wtl.ttms.Dialog.DialogFilmChange;
import com.example.wtl.ttms.Dialog.DialogPerformanceDelete;
import com.example.wtl.ttms.R;

import java.util.List;

/**
 * 影片管理adapter
 * Created by WTL on 2018/4/16.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private List<Film> filmList;
    private Context context;

    public FilmAdapter(List<Film> filmList,Context context) {
        this.filmList = filmList;
        this.context = context;
    }

    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.film_card,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FilmAdapter.ViewHolder holder, final int position) {
        final Film film = filmList.get(position);
        holder.film_type.setText(film.getFilm_type());
        holder.film_name.setText(film.getFilm_name());
        holder.film_change.getBackground().setAlpha(190);
        holder.film_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogFilmChange filmChange = new DialogFilmChange(context);
                filmChange.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                filmChange.show();
                filmChange.setChangeText(film.getFilm_type(),film.getFilm_name(),film.getFilm_time(),film.getFilm_director(),film.getFilm_price());
                filmChange.setOnCanceClickListener(new DialogFilmChange.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        filmChange.dismiss();
                    }
                });
                filmChange.setOnSureClickListener(new DialogFilmChange.OnSureClickListener() {
                    @Override
                    public void onSureClick(String film_type, String film_name, String film_time, String film_director, String film_price) {
                        filmChange.dismiss();
                        film.setFilm_type(film_type);
                        film.setFilm_name(film_name);
                        film.setFilm_time(film_time);
                        film.setFilm_director(film_director);
                        film.setFilm_price(film_price);
                        notifyItemChanged(position);
                    }
                });
            }
        });
        holder.film_delete.getBackground().setAlpha(190);
        holder.film_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPerformanceDelete filmDelete = new DialogPerformanceDelete(context);
                filmDelete.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                filmDelete.show();
                filmDelete.setDelete_name(film.getFilm_name());
                filmDelete.setOnSureClickListener(new DialogPerformanceDelete.OnSureClickListener() {
                    @Override
                    public void onSureClick() {
                        filmDelete.dismiss();
                        remove(position);
                    }
                });
                filmDelete.setOnCanceClickListener(new DialogPerformanceDelete.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        filmDelete.dismiss();
                    }
                });
            }
        });
        holder.film.getBackground().setAlpha(170);
        holder.film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogDetailFilm detailFilm = new DialogDetailFilm(context);
                detailFilm.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                detailFilm.show();
                detailFilm.setfilmText(film.getFilm_type(),film.getFilm_name(),film.getFilm_time(),film.getFilm_director(),film.getFilm_price());
            }
        });
    }

    private void remove(int postion) {
        filmList.remove(postion);
        notifyItemRemoved(postion);
        notifyItemRangeChanged(postion, filmList.size() - postion);
    }

    public void add(Film film) {
        filmList.add(0,film);
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView film_type;
        TextView film_name;
        TextView film_change;
        TextView film_delete;
        LinearLayout film;

        public ViewHolder(View itemView) {
            super(itemView);
            film_change = itemView.findViewById(R.id.film_change);
            film_delete = itemView.findViewById(R.id.film_delete);
            film_type = itemView.findViewById(R.id.film_type);
            film_name = itemView.findViewById(R.id.film_name);
            film = itemView.findViewById(R.id.film);
        }
    }
}
