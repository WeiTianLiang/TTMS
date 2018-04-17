package com.example.wtl.ttms.Class;

/**
 * 电影类
 * Created by WTL on 2018/4/16.
 */

public class Film {
    private String film_type;
    private String film_name;
    private String film_time;
    private String film_director;
    private String film_price;

    public Film(String film_type,String film_name,String film_time,String film_director,String film_price) {
        this.film_type = film_type;
        this.film_name = film_name;
        this.film_time = film_time;
        this.film_director = film_director;
        this.film_price = film_price;
    }

    public String getFilm_director() {
        return film_director;
    }

    public String getFilm_name() {
        return film_name;
    }

    public String getFilm_price() {
        return film_price;
    }

    public String getFilm_time() {
        return film_time;
    }

    public String getFilm_type() {
        return film_type;
    }

    public void setFilm_director(String film_director) {
        this.film_director = film_director;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public void setFilm_price(String film_price) {
        this.film_price = film_price;
    }

    public void setFilm_time(String film_time) {
        this.film_time = film_time;
    }

    public void setFilm_type(String film_type) {
        this.film_type = film_type;
    }
}
