package com.example.wtl.ttms.Class;

/**
 * 个人信息
 * Created by WTL on 2018/4/15.
 */

public class Personal {

    private String sign;
    private String content;

    public Personal(String sign,String content) {
        this.sign = sign;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getSign() {
        return sign;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
