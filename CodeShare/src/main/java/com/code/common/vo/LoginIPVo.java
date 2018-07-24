package com.code.common.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LoginIPVo {
	private int id;
	private String no;
	private String ip;
	private String location;
	@JsonFormat(pattern = "yy-MM-dd HH:mm:ss")
	private Timestamp lasttime;

	public LoginIPVo() {
		super();
	}

	public LoginIPVo(String no, String ip, String location) {
		super();
		this.no = no;
		this.ip = ip;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getLasttime() {
		return lasttime;
	}

	public void setLasttime(Timestamp lasttime) {
		this.lasttime = lasttime;
	}

	@Override
	public String toString() {
		return "LoginIPVo [id=" + id + ", no=" + no + ", ip=" + ip + ", location=" + location + ", lasttime=" + lasttime
				+ "]";
	}

}
