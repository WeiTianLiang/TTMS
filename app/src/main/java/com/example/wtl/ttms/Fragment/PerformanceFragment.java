package com.example.wtl.ttms.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wtl.ttms.Adapter.PerformanceAdapter;
import com.example.wtl.ttms.AllFilmTypeFragment.ActionFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.FunnyFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.HorrorFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.LoveFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.ScienceFragment;
import com.example.wtl.ttms.AllFilmTypeFragment.WarFragment;
import com.example.wtl.ttms.Class.Performance;
import com.example.wtl.ttms.Dialog.DialogPerformanceChange;
import com.example.wtl.ttms.AllFilmTypeFragment.AllFilmFragment;
import com.example.wtl.ttms.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 演出厅fragment
 * Created by WTL on 2018/4/14.
 */

public class PerformanceFragment extends Fragment {

    private List<Performance> performanceList = new ArrayList<>();

    private FloatingActionButton collection;
    private RecyclerView content_recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_fragment,container,false);
        Montior(view);
        init();
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(200);
        animator.setChangeDuration(400);
        animator.setAddDuration(200);
        content_recycler.getBackground().setAlpha(150);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        content_recycler.setLayoutManager(manager);
        content_recycler.setItemAnimator(animator);
        final PerformanceAdapter adapter = new PerformanceAdapter(performanceList,getContext());
        content_recycler.setAdapter(adapter);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPerformanceChange performanceChange = new DialogPerformanceChange(getContext());
                performanceChange.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                performanceChange.show();
                performanceChange.setOnCanceClickListener(new DialogPerformanceChange.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        performanceChange.dismiss();
                    }
                });
                performanceChange.setOnSureClickListener(new DialogPerformanceChange.OnSureClickListener() {
                    @Override
                    public void onSureClick(String performance_id, String performance_name, String performance_row, String performance_column) {
                        performanceChange.dismiss();
                        Performance performance = new Performance(performance_id,performance_name,performance_row,performance_column);
                        adapter.add(performance);
                        content_recycler.scrollToPosition(0);
                    }
                });
            }
        });
        return view;
    }

    private void Montior(View view) {
        content_recycler = view.findViewById(R.id.content_recycler);
        collection = view.findViewById(R.id.collection);
    }

    private void init() {
        Performance performance = new Performance("1号","斗破苍穹演出厅","46","32");
        performanceList.add(performance);
        Performance performance1 = new Performance("2号","武动乾坤演出厅","46","32");
        performanceList.add(performance1);
        Performance performance2 = new Performance("3号","无限恐怖演出厅","46","32");
        performanceList.add(performance2);
        Performance performance3 = new Performance("4号","盗墓笔记演出厅","46","32");
        performanceList.add(performance3);
        Performance performance4 = new Performance("5号","死神来了演出厅","46","32");
        performanceList.add(performance4);
        Performance performance5 = new Performance("6号","傲世九重天演出厅","46","32");
        performanceList.add(performance5);
        Performance performance6 = new Performance("7号","星辰变演出厅","46","32");
        performanceList.add(performance6);
    }
}
