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

import com.example.wtl.ttms.Adapter.StaffAdapter;
import com.example.wtl.ttms.Class.Staff;
import com.example.wtl.ttms.Dialog.DialogStaffChange;
import com.example.wtl.ttms.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工fragment
 * Created by WTL on 2018/4/13.
 */

public class StaffFragment extends Fragment {

    private List<Staff> staffList = new ArrayList<>();

    private FloatingActionButton collection;
    private RecyclerView content_recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_fragment,container,false);
        init();
        Montior(view);
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(200);
        animator.setChangeDuration(400);
        animator.setAddDuration(200);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        content_recycler.setLayoutManager(manager);
        content_recycler.setItemAnimator(animator);
        final StaffAdapter adapter = new StaffAdapter(staffList,getContext());
        content_recycler.setAdapter(adapter);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogStaffChange staffChange = new DialogStaffChange(getContext());
                staffChange.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                staffChange.show();
                staffChange.setOnCanceClickListener(new DialogStaffChange.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        staffChange.dismiss();
                    }
                });
                staffChange.setOnSureClickListener(new DialogStaffChange.OnSureClickListener() {
                    @Override
                    public void onSureClick(String identity,String name,String id,String phone,String address) {
                        staffChange.dismiss();
                        Staff staff = new Staff(R.mipmap.circleq,identity,name,id,phone,address);
                        adapter.add(staff);
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
        Staff staff = new Staff(R.mipmap.circleq,"管理员","魏天亮","301280","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff);
        Staff staff1 = new Staff(R.mipmap.circleq,"管理员","李赛鹏","301281","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff1);
        Staff staff2 = new Staff(R.mipmap.circleq,"管理员","刘陈诚","301282","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff2);
        Staff staff3 = new Staff(R.mipmap.circleq,"管理员","加里奥","301283","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff3);
        Staff staff4 = new Staff(R.mipmap.circleq,"管理员","猎空","301284","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff4);
        Staff staff5 = new Staff(R.mipmap.circleq,"管理员","麦克雷","301285","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff5);
        Staff staff6 = new Staff(R.mipmap.circleq,"管理员","梦奇","301286","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff6);
        Staff staff7 = new Staff(R.mipmap.circleq,"管理员","狂鼠","301287","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff7);
        Staff staff8 = new Staff(R.mipmap.circleq,"管理员","休斯顿","301288","1234567890","澳康达可是擦课程-发了疯似的");
        staffList.add(staff8);
    }
}
