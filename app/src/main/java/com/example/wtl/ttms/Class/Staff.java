package com.example.wtl.ttms.Class;

/**
 * 员工信息
 * Created by WTL on 2018/4/13.
 */

public class Staff {

    private int staff_head;
    private String staff_identity;
    private String staff_name;
    private String staff_id;
    private String staff_phone;
    private String staff_adress;

    public Staff(int staff_head,String staff_identity,String staff_name,String staff_id,String staff_phone,String staff_adress) {
        this.staff_head = staff_head;
        this.staff_id = staff_id;
        this.staff_identity = staff_identity;
        this.staff_name = staff_name;
        this.staff_phone = staff_phone;
        this.staff_adress = staff_adress;
    }

    public int getStaff_head() {
        return staff_head;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public String getStaff_identity() {
        return staff_identity;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public String getStaff_adress() {
        return staff_adress;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_adress(String staff_adress) {
        this.staff_adress = staff_adress;
    }

    public void setStaff_head(int staff_head) {
        this.staff_head = staff_head;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public void setStaff_identity(String staff_identity) {
        this.staff_identity = staff_identity;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }
}
