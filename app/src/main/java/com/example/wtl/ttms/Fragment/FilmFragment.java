package com.example.wtl.ttms.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.ttms.Adapter.FilmAdapter;
import com.example.wtl.ttms.AllFilmTypeFragment.ActionFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.AllFilmFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.FunnyFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.HorrorFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.LoveFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.ScienceFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.WarFragment;
import com.example.wtl.ttms.Class.Film;
import com.example.wtl.ttms.Dialog.DialogFilmChange;
import com.example.wtl.ttms.R;
import com.example.wtl.ttms.Tool.FilmFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by WTL on 2018/4/16.
 */

public class FilmFragment extends Fragment {

    private List<String> stringList;
    private FloatingActionButton filmcollection;
    private TabLayout film_navigation;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private FragmentPagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.film_fragment,container,false);
        Montior(view);
        addTablayout(film_navigation);
        addfragment();
        pagerAdapter = new FilmFragmentAdapter(getFragmentManager(),fragmentList,stringList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(6);
        film_navigation.setupWithViewPager(viewPager);
        filmcollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogFilmChange filmChange = new DialogFilmChange(getContext());
                filmChange.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                filmChange.show();
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
                        Film film = new Film(film_type,film_name,film_time,film_director,film_price);

                    }
                });
            }
        });
        return view;
    }

    private void Montior(View view) {
        filmcollection = view.findViewById(R.id.filmcollection);
        film_navigation = view.findViewById(R.id.film_navigation);
        viewPager = view.findViewById(R.id.viewpager);
    }

    private void addTablayout(TabLayout tabLayout) {
        stringList = new ArrayList<>();
        stringList.add("全部");
        stringList.add("恐怖片");
        stringList.add("搞笑片");
        stringList.add("科幻片");
        stringList.add("爱情片");
        stringList.add("战争片");
        stringList.add("动作片");
        for(String str:stringList) {
            tabLayout.addTab(tabLayout.newTab().setText(str));
        }
    }

    private void addfragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new AllFilmFragment());
        fragmentList.add(new HorrorFragment());
        fragmentList.add(new FunnyFragment());
        fragmentList.add(new ScienceFragment());
        fragmentList.add(new LoveFragment());
        fragmentList.add(new WarFragment());
        fragmentList.add(new ActionFragment());
    }
}
