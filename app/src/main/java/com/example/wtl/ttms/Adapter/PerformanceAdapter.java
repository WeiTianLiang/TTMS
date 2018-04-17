package com.example.wtl.ttms.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms.Class.Performance;
import com.example.wtl.ttms.Dialog.DialogDetailPerformance;
import com.example.wtl.ttms.Dialog.DialogPerformanceChange;
import com.example.wtl.ttms.Dialog.DialogPerformanceDelete;
import com.example.wtl.ttms.R;

import java.util.List;

/**
 * 演出听适配器
 * Created by WTL on 2018/4/14.
 */

public class PerformanceAdapter extends RecyclerView.Adapter<PerformanceAdapter.ViewHolder> {

    private List<Performance> performanceList;
    private Context context;

    public PerformanceAdapter(List<Performance> performanceList,Context context) {
        this.performanceList = performanceList;
        this.context = context;
    }

    @Override
    public PerformanceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.performance_card,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PerformanceAdapter.ViewHolder holder, final int position) {
        final Performance performance = performanceList.get(position);
        holder.performance_id.setText(performance.getPerformance_id());
        holder.performance_name.setText(performance.getPerformance_name());
        holder.performance_delete.getBackground().setAlpha(190);
        holder.performance_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPerformanceDelete performanceDelete = new DialogPerformanceDelete(context);
                performanceDelete.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                performanceDelete.show();
                performanceDelete.setDelete_name(performance.getPerformance_name());
                performanceDelete.setOnSureClickListener(new DialogPerformanceDelete.OnSureClickListener() {
                    @Override
                    public void onSureClick() {
                        performanceDelete.dismiss();
                        remove(position);
                    }
                });
                performanceDelete.setOnCanceClickListener(new DialogPerformanceDelete.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        performanceDelete.dismiss();
                    }
                });
            }
        });
        holder.performance_change.getBackground().setAlpha(190);
        holder.performance_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPerformanceChange performanceChange = new DialogPerformanceChange(context);
                performanceChange.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                performanceChange.show();
                performanceChange.setChangeText(performance.getPerformance_id(),performance.getPerformance_name(),performance.getRow(),performance.getColumn());
                performanceChange.setOnCanceClickListener(new DialogPerformanceChange.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        performanceChange.dismiss();
                    }
                });
                performanceChange.setOnSureClickListener(new DialogPerformanceChange.OnSureClickListener() {
                    @Override
                    public void onSureClick(String performance_id,String performance_name,String performance_row,String performance_column) {
                        performanceChange.dismiss();
                        performance.setPerformance_id(performance_id);
                        performance.setPerformance_name(performance_name);
                        performance.setRow(performance_row);
                        performance.setColumn(performance_column);
                        notifyItemChanged(position);
                    }
                });
            }
        });
        holder.pertouming.getBackground().setAlpha(170);
        holder.pertouming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogDetailPerformance detailPerformance = new DialogDetailPerformance(context);
                detailPerformance.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                detailPerformance.show();
                detailPerformance.setperformanceText(performance.getPerformance_id(),performance.getPerformance_name(),performance.getRow(),performance.getColumn());
            }
        });
    }

    private void remove(int postion) {
        performanceList.remove(postion);
        notifyItemRemoved(postion);
        notifyItemRangeChanged(postion, performanceList.size() - postion);
    }

    public void add(Performance performance) {
        performanceList.add(0,performance);
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return performanceList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView performance_id;
        TextView performance_name;
        TextView performance_change;
        TextView performance_delete;
        LinearLayout pertouming;

        public ViewHolder(View itemView) {
            super(itemView);
            performance_id = itemView.findViewById(R.id.performance_id);
            performance_name = itemView.findViewById(R.id.performance_name);
            performance_change = itemView.findViewById(R.id.performance_change);
            performance_delete = itemView.findViewById(R.id.performance_delete);
            pertouming = itemView.findViewById(R.id.pertouming);
        }
    }
}
