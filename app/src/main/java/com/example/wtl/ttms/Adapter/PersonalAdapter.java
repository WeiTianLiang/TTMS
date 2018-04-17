package com.example.wtl.ttms.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms.Class.Personal;
import com.example.wtl.ttms.R;

import java.util.List;

/**
 * 个人信息适配器
 * Created by WTL on 2018/4/15.
 */

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.ViewHolder> {

    private List<Personal> personalList;
    private Context context;

    public PersonalAdapter(List<Personal> personalList,Context context) {
        this.personalList = personalList;
        this.context = context;
    }

    @Override
    public PersonalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.personal_card,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Personal personal = personalList.get(position);
        holder.personal_text.setText(personal.getSign());
        holder.personal_content.setText(personal.getContent());
        holder.person_back.getBackground().setAlpha(150);
    }

    @Override
    public int getItemCount() {
        return personalList.size();
    }

    public void changeperson(int pos,String s) {
        personalList.get(pos).setContent(s);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView personal_text;
        TextView personal_content;
        LinearLayout person_back;

        public ViewHolder(View itemView) {
            super(itemView);
            person_back = itemView.findViewById(R.id.person_back);
            personal_text = itemView.findViewById(R.id.personal_text);
            personal_content = itemView.findViewById(R.id.personal_content);
        }
    }

}
