package com.example.wtl.ttms.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wtl.ttms.Class.Staff;
import com.example.wtl.ttms.Dialog.DialogDetailStaff;
import com.example.wtl.ttms.Dialog.DialogStaffChange;
import com.example.wtl.ttms.Dialog.DialogStaffDelete;
import com.example.wtl.ttms.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 员工管理适配器
 * Created by WTL on 2018/4/13.
 */

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder>{

    private List<Staff> staffList;
    private Context context;

    public StaffAdapter(List<Staff> staffList,Context context) {
        this.staffList = staffList;
        this.context = context;
    }

    @Override
    public StaffAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.staff_card,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StaffAdapter.ViewHolder holder, final int position) {
        final Staff staff = staffList.get(position);
        holder.staff_head.setImageResource(staff.getStaff_head());
        holder.staff_name.setText(staff.getStaff_name());
        holder.staff_id.setText(staff.getStaff_id());
        holder.staff_identity.setText(staff.getStaff_identity());
        holder.staff_delete.getBackground().setAlpha(170);
        holder.staff_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogStaffDelete dialogStaffDelete = new DialogStaffDelete(context);
                dialogStaffDelete.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialogStaffDelete.show();
                dialogStaffDelete.setDelete_id(staff.getStaff_id());
                dialogStaffDelete.setOnSureClickListener(new DialogStaffDelete.OnSureClickListener() {
                    @Override
                    public void onSureClick() {
                        dialogStaffDelete.dismiss();
                        remove(position);
                    }
                });
                dialogStaffDelete.setOnCanceClickListener(new DialogStaffDelete.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        dialogStaffDelete.dismiss();
                    }
                });
            }
        });
        holder.staff_change.getBackground().setAlpha(190);
        holder.staff_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogStaffChange dialogStaffChange = new DialogStaffChange(context);
                dialogStaffChange.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialogStaffChange.show();
                dialogStaffChange.setChangeText(staff.getStaff_identity(),staff.getStaff_name(),staff.getStaff_id(),staff.getStaff_phone(),staff.getStaff_adress());
                dialogStaffChange.setOnCanceClickListener(new DialogStaffChange.OnCanceClickListener() {
                    @Override
                    public void onCanceClick() {
                        dialogStaffChange.dismiss();
                    }
                });
                dialogStaffChange.setOnSureClickListener(new DialogStaffChange.OnSureClickListener() {
                    @Override
                    public void onSureClick(String identity,String name,String id,String phone,String address) {
                        dialogStaffChange.dismiss();
                        staff.setStaff_identity(identity);
                        staff.setStaff_name(name);
                        staff.setStaff_id(id);
                        staff.setStaff_phone(phone);
                        staff.setStaff_adress(address);
                        notifyItemChanged(position);
                    }
                });
            }
        });
        holder.touming.getBackground().setAlpha(190);
        holder.touming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogDetailStaff detailStaff = new DialogDetailStaff(context);
                detailStaff.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                detailStaff.show();
                detailStaff.setChangeText(staff.getStaff_identity(),staff.getStaff_name(),staff.getStaff_id(),staff.getStaff_phone(),staff.getStaff_adress());
            }
        });
    }

    private void remove(int postion) {
        staffList.remove(postion);
        notifyItemRemoved(postion);
        notifyItemRangeChanged(postion, staffList.size() - postion);
    }

    public void add(Staff staff) {
        staffList.add(0,staff);
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView staff_head;
        TextView staff_identity;
        TextView staff_name;
        TextView staff_id;
        TextView staff_change;
        TextView staff_delete;
        LinearLayout touming;

        public ViewHolder(View itemView) {
            super(itemView);
            staff_head = itemView.findViewById(R.id.staff_head);
            staff_id = itemView.findViewById(R.id.staff_id);
            staff_identity = itemView.findViewById(R.id.staff_identity);
            staff_name = itemView.findViewById(R.id.staff_name);
            staff_change = itemView.findViewById(R.id.staff_change);
            staff_delete = itemView.findViewById(R.id.staff_delete);
            touming = itemView.findViewById(R.id.touming);
        }
    }
}
