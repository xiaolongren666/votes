package com.jiangshil.bean;

/**
 * 
 * @author dell
 *
 */
public class Listing {
	// 标题
    private String title;
    // 选项个数
    private int optionNum;
    // 票数
    private int voteNum;
    // 
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
