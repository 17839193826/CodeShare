package com.code.domain;

import java.util.Date;

public class Send {
        private  int id;//主键
        private  int uid;//用户主键
        private  String title;//题目
        private  String context;//发帖内容

    private Date createtime;//发帖时间
    private int pid;//所属板块主键
  //  private  int rid;//回复表的主键

    private int flag;//帖子状态  0：无效，1：有效，2：封禁，3：关闭评论
    private  int hot;//是否热帖  1：加精  2置顶





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "Send{" +
                "id=" + id +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", createtime=" + createtime +
                ", pid=" + pid +

                ", flag=" + flag +
                ", hot=" + hot +
                '}';
    }
}
