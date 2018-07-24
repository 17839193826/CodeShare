package com.code.domain;

import java.util.Date;

public class Reply {
    private  int id;//主键
    private  int sid;//用户ID  发帖ID
   // private  int uid;//用户主键
    private   String context; //回复内容
    private Date createtime;//回复时间
    private  int flag;// 1：有效  0：无效
    private int type;// 1：是查看   2：是回复

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }



    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", sid=" + sid +

                ", context='" + context + '\'' +
                ", createtime=" + createtime +
                ", flag=" + flag +
                ", type=" + type +
                '}';
    }
}
