package com.example.wtl.ttms.Tool;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.example.wtl.ttms.Adapter.SidePollAdapter;
import com.example.wtl.ttms.Class.SidePoll;

import java.util.ArrayList;
import java.util.List;

/**
 * 加载展示recyclerview
 * Created by WTL on 2018/4/12.
 */

public class ShowRecyclerView {

    private static TextSideAnimation textSideAnimation = null;
    private static TextSideAnimation textSideAnimationhide = null;

    public static SidePollAdapter ShowRecyclerView(final Context context, final RecyclerView recyclerView, final DrawerLayout drawerLayout, final TextView textView) {
        final List<SidePoll> pollList = new ArrayList<>();
        SidePollAdapter adapter;
        init(pollList);
        final LinearLayoutManager manager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);
        adapter = new SidePollAdapter(pollList,context,drawerLayout,textView);
        recyclerView.setAdapter(adapter);
        runlayourAnimation(recyclerView);
        return adapter;
    }

    private static void init(List<SidePoll> pollList) {
        SidePoll staff = new SidePoll("员工管理");
        pollList.add(staff);
        SidePoll performance  = new SidePoll("演出厅管理");
        pollList.add(performance);
        SidePoll seat = new SidePoll("座位管理");
        pollList.add(seat);
        SidePoll personal = new SidePoll("个人信息");
        pollList.add(personal);
        SidePoll film = new SidePoll("影片信息");
        pollList.add(film);
    }

    private static void runlayourAnimation(RecyclerView recyclerView) {
        if(textSideAnimation == null) {
            textSideAnimation = new TextSideAnimation(90, 0, 0.0f, recyclerView.getHeight() / 2.0f);
            textSideAnimation.setFillAfter(true);
            textSideAnimation.setDuration(260);
            textSideAnimation.setInterpolator(new AccelerateInterpolator());
        }
        LayoutAnimationController animationController = new LayoutAnimationController(textSideAnimation);
        animationController.setDelay(0.3f);
        recyclerView.setLayoutAnimation(animationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

}
