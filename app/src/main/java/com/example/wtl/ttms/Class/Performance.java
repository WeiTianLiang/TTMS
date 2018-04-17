package com.example.wtl.ttms.Class;

/**
 * 演出厅类
 * Created by WTL on 2018/4/14.
 */

public class Performance {

    private String performance_id;
    private String performance_name;
    private String row;
    private String column;

    public Performance(String performance_id,String performance_name,String row,String column) {
        this.performance_id = performance_id;
        this.performance_name = performance_name;
        this.row = row;
        this.column = column;
    }

    public String getPerformance_id() {
        return performance_id;
    }

    public String getPerformance_name() {
        return performance_name;
    }

    public void setPerformance_id(String performance_id) {
        this.performance_id = performance_id;
    }

    public void setPerformance_name(String performance_name) {
        this.performance_name = performance_name;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }

    public String getRow() {
        return row;
    }
}
