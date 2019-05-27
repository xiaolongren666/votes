package com.jiangshil.bean;

/**
 * 选项标题，
 * 选项数，
 * 投票人数。
 * 该登录账户是否已投票。
 * @author Administrator
 *
 */
public class Listing {
    private String title; //标题
    private int optionNum;//选项数量
    private int voteNum;//投票数量
    private boolean isVote;


    public boolean getIsVote() {
        return isVote;
    }
    public void setIsVote(boolean isVote) {
        this.isVote = isVote;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getOptionNum() {
        return optionNum;
    }
    public void setOptionNum(int optionNum) {
        this.optionNum = optionNum;
    }
    public int getVoteNum() {
        return voteNum;
    }
    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

}
