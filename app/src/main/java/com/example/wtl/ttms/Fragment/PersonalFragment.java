package com.example.wtl.ttms.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.wtl.ttms.Adapter.PersonalAdapter;
import com.example.wtl.ttms.Class.Personal;
import com.example.wtl.ttms.Dialog.DialogPersonalChange;
import com.example.wtl.ttms.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 个人信息fragment
 * Created by WTL on 2018/4/15.
 */

public class PersonalFragment extends Fragment{

    private FrameLayout personal;
    private CircleImageView personal_head;
    private FloatingActionButton personalcollection;
    private RecyclerView personal_recycler;
    private List<Personal> personalList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment,container,false);
        Montior(view);
        init();
        personal.getBackground().setAlpha(170);
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setRemoveDuration(200);
        animator.setChangeDuration(400);
        animator.setAddDuration(200);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        personal_recycler.setLayoutManager(manager);
        personal_recycler.setItemAnimator(animator);
        final PersonalAdapter adapter = new PersonalAdapter(personalList,getContext());
        personal_recycler.setAdapter(adapter);
        personal_head.getBackground().setAlpha(170);
        personalcollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPersonalChange personalChange = new DialogPersonalChange(getContext());
                personalChange.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                personalChange.show();
                personalChange.setChangeText(personalList.get(0).getContent(),personalList.get(1).getContent(),personalList.get(2).getContent(),personalList.get(3).getContent()
                        ,personalList.get(4).getContent(),personalList.get(5).getContent(),personalList.get(6).getContent());
                personalChange.setOnCanceClickListener(new DialogPersonalChange.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        personalChange.dismiss();
                    }
                });
                personalChange.setOnSureClickListener(new DialogPersonalChange.OnSureClickListener() {
                    @Override
                    public void onSureClick(String dialog_identity,String dialog_id,String dialog_name
                            ,String dialog_age,String dialog_sex,String dialog_phone,String dialog_address) {
                        personalChange.dismiss();
                        adapter.changeperson(0,dialog_identity);
                        adapter.changeperson(1,dialog_id);
                        adapter.changeperson(2,dialog_name);
                        adapter.changeperson(3,dialog_age);
                        adapter.changeperson(4,dialog_sex);
                        adapter.changeperson(5,dialog_phone);
                        adapter.changeperson(6,dialog_address);
                    }
                });
            }
        });
        return view;
    }

    private void Montior(View view) {
        personal = view.findViewById(R.id.personal);
        personal_head = view.findViewById(R.id.personal_head);
        personalcollection = view.findViewById(R.id.personalcollection);
        personal_recycler = view.findViewById(R.id.personal_recycler);
    }

    private void init() {
        Personal personal = new Personal("身份:","管理员");
        personalList.add(personal);
        Personal personal1 = new Personal("员工号:","3232134");
        personalList.add(personal1);
        Personal personal2 = new Personal("姓名:","按时间");
        personalList.add(personal2);
        Personal personal3 = new Personal("年龄:","18");
        personalList.add(personal3);
        Personal personal4 = new Personal("性别:","男");
        personalList.add(personal4);
        Personal personal5 = new Personal("电话号","123893423");
        personalList.add(personal5);
        Personal personal6 = new Personal("地址","啊实打实艰苦地塞的看看");
        personalList.add(personal6);
    }

}
