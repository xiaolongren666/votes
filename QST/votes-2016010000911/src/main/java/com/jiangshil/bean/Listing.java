package com.jiangshil.bean;

/**
 * ѡ����⣬
 * ѡ������
 * ͶƱ������
 * �õ�¼�˻��Ƿ���ͶƱ��
 * @author Administrator
 *
 */
public class Listing {
    private String title; //����
    private int optionNum;//ѡ������
    private int voteNum;//ͶƱ����
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
