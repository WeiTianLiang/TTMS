package com.example.wtl.ttms.Tool;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 自定义viewpager适配器
 * Created by WTL on 2018/4/16.
 */

public class FilmFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    private List<String> list;

    public FilmFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> list) {
        super(fm);
        this.fragmentList = fragmentList;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
