package com.cphoto.pojo;

public class User {
    private Long id;

    private String userid;

    private String password;

    private String head;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", userid=" + userid + ", password=" + password + ", head=" + head + "]";
	}
    
    
}