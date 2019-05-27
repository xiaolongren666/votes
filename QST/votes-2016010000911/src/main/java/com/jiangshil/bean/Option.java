package com.jiangshil.bean;


/**
 * 存储每个选项对应的票数。
 * @author Administrator
 *
 */

public class Option {
    private String option; //选项
    private int num;//数量
    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

}