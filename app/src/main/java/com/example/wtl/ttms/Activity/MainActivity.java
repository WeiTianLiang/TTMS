package com.example.wtl.ttms.Activity;

import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms.Adapter.SidePollAdapter;
import com.example.wtl.ttms.AllFilmTypeFragment.AllFilmFragment;
import com.example.wtl.ttms.Fragment.FilmFragment;
import com.example.wtl.ttms.Fragment.PerformanceFragment;
import com.example.wtl.ttms.Fragment.PersonalFragment;
import com.example.wtl.ttms.Fragment.SitesFragment;
import com.example.wtl.ttms.Fragment.StaffFragment;
import com.example.wtl.ttms.R;
import com.example.wtl.ttms.Tool.HideScreenTop;
import com.example.wtl.ttms.Tool.ShowRecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    private ImageView side_poll_img;
    private RecyclerView side_poll_recycler;
    private TextView side_poll_show;
    private ImageView function;
    private SidePollAdapter adapter = null;

    private StaffFragment staffFragment;
    private PerformanceFragment performanceFragment;
    private PersonalFragment personalFragment;
    private SitesFragment sitesFragment;
    private FilmFragment filmFragment;

    private LinearLayout thehead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HideScreenTop.HideScreenTop(getWindow());
        Montior();
        drawer_layout.setScrimColor(Color.TRANSPARENT);
        changeFragment(0);
        thehead.getBackground().setAlpha(150);
    }

    //加载控件
    private void Montior() {
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        side_poll_img = (ImageView) findViewById(R.id.side_poll_img);
        side_poll_recycler = (RecyclerView) findViewById(R.id.side_poll_recycler);
        side_poll_show = (TextView) findViewById(R.id.side_poll_show);
        function = (ImageView) findViewById(R.id.function);
        thehead = (LinearLayout) findViewById(R.id.thehead);

        side_poll_img.setOnClickListener(this);
        function.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.side_poll_img:
                adapter = ShowRecyclerView.ShowRecyclerView(this, side_poll_recycler, drawer_layout, side_poll_show);
                drawer_layout.openDrawer(GravityCompat.START);
                adapter.setOnChangeFragmentListener(new SidePollAdapter.OnChangeFragmentListener() {
                    @Override
                    public void onChangeFragment(String s) {
                        if(s.equals("员工管理")) {
                            changeFragment(0);
                        }
                        if(s.equals("演出厅管理")) {
                            changeFragment(1);
                        }
                        if(s.equals("座位管理")) {
                            changeFragment(2);
                        }
                        if(s.equals("个人信息")) {
                            changeFragment(3);
                        }
                        if(s.equals("影片信息")) {
                            changeFragment(4);
                        }
                    }
                });
                break;
        }
    }

    private void changeFragment(int choose) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hidefragemnt(transaction);
        switch (choose) {
            case 0:
                if(staffFragment == null) {
                    staffFragment = new StaffFragment();
                    transaction.add(R.id.framelayout,staffFragment);
                } else {
                    transaction.show(staffFragment);
                }
                break;
            case 1:
                if(performanceFragment == null) {
                    performanceFragment = new PerformanceFragment();
                    transaction.add(R.id.framelayout,performanceFragment);
                } else {
                    transaction.show(performanceFragment);
                }
                break;
            case 2:
                if(sitesFragment == null) {
                    sitesFragment = new SitesFragment();
                    transaction.add(R.id.framelayout,sitesFragment);
                } else {
                    transaction.show(sitesFragment);
                }
                break;
            case 3:
                if(personalFragment == null) {
                    personalFragment = new PersonalFragment();
                    transaction.add(R.id.framelayout,personalFragment);
                } else {
                    transaction.show(personalFragment);
                }
                break;
            case 4:
                if(filmFragment == null) {
                    filmFragment = new FilmFragment();
                    transaction.add(R.id.framelayout,filmFragment);
                } else {
                    transaction.show(filmFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hidefragemnt(FragmentTransaction transaction) {
        if(staffFragment != null) {
            transaction.hide(staffFragment);
        }
        if(performanceFragment != null) {
            transaction.hide(performanceFragment);
        }
        if(personalFragment != null) {
            transaction.hide(personalFragment);
        }
        if(sitesFragment != null) {
            transaction.hide(sitesFragment);
        }
        if(filmFragment != null) {
            transaction.hide(filmFragment);
        }
    }

}
