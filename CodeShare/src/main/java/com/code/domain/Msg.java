package com.code.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Msg {
    private int id;
    private int beuid;
    private int uid;
    private String msg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String flag;//1有效 2无效

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBeuid() {
        return beuid;
    }

    public void setBeuid(int beuid) {
        this.beuid = beuid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", beuid=" + beuid +
                ", uid=" + uid +
                ", msg='" + msg + '\'' +
                ", createtime=" + createtime +
                ", flag='" + flag + '\'' +
                '}';
    }
}
