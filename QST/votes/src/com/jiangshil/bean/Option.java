package com.jiangshil.bean;


/**
 * 投票选项模型
 * @author 小龙人
 *
 */

public class Option {
	// 投票选项名称
    private String option; 
    // 投票选项票数
    private int num;
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