package com.example.wtl.ttms.Adapter;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.wtl.ttms.Class.SidePoll;
import com.example.wtl.ttms.R;

import java.util.List;

/**
 * 测拉框适配器
 * Created by WTL on 2018/4/12.
 */

public class SidePollAdapter extends RecyclerView.Adapter<SidePollAdapter.ViewHolder> {

    private List<SidePoll> pollList;
    private Context context;
    private DrawerLayout drawer;
    private TextView textview;

    private Animation change_theme_show;
    private OnChangeFragmentListener onChangeFragmentListener;

    public SidePollAdapter(List<SidePoll> pollList, Context context, DrawerLayout drawer,TextView textview) {
        this.pollList = pollList;
        this.context = context;
        this.drawer = drawer;
        this.textview = textview;
    }

    @Override
    public SidePollAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sidepollcard,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SidePollAdapter.ViewHolder holder, int position) {
        final SidePoll sidePoll = pollList.get(position);
        holder.sidepolltext.setText(sidePoll.getSidepolltext());
        holder.sidepolltext.getBackground().setAlpha(220);
        change_theme_show = AnimationUtils.loadAnimation(context,R.anim.change_theme_show);
        holder.sidepolltext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawers();
                textview.setText(holder.sidepolltext.getText());
                textview.startAnimation(change_theme_show);
                onChangeFragmentListener.onChangeFragment(holder.sidepolltext.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pollList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView sidepolltext;

        public ViewHolder(View itemView) {
            super(itemView);
            sidepolltext = itemView.findViewById(R.id.sidepolltext);
        }
    }

    public interface OnChangeFragmentListener {
        void onChangeFragment(String s);
    }

    public void setOnChangeFragmentListener(OnChangeFragmentListener onChangeFragmentListener) {
        this.onChangeFragmentListener = onChangeFragmentListener;
    }

}
