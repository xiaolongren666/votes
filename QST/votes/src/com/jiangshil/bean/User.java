package com.jiangshil.bean;

public class User {
    private int id; //用户id
    private String username;//用户名
    private String password;//用户密码
    private int type;//类型
    private int status;//状态
    
    
    public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}