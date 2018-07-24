package com.code.common.vo;

import java.util.Date;

public class V_Send {
    private int id;
    private int uid;
    private int hot;
    private String pname;
    private String nickname;
    private String context;
    private  String title;
    private  Date createtime;
    private  int rep;//回复数量  2
    private  int look;//查看数量  1
    private Date lastTime;//最后回复时间

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

    @Override
    public String toString() {
        return "V_Send{" +
                "id=" + id +
                ", uid=" + uid +
                ", hot=" + hot +
                ", pname='" + pname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", context='" + context + '\'' +
                ", title='" + title + '\'' +
                ", createtime=" + createtime +
                ", rep=" + rep +
                ", look=" + look +
                ", lastTime=" + lastTime +
                '}';
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public int getLook() {
        return look;
    }

    public void setLook(int look) {
        this.look = look;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /*   select * from t_send s left join (select count(*) rep,sid from t_reply where type=2 and sid=1)
    r on s.id=r.sid

    left join
            (select context sid from t_reply where type=1 and sid=1)
    r1 on s.id=r1.sid

    left join
            (select createtime lastTime,sid from t_reply where type=2 and sid=1 order by createtime desc limit 0,1)
    r2 on s.id=r2.sid;*/



   /* SELECT a.*,b.rep,c.context,d.lastTime from t_send a,(select count(*) rep from t_reply where type=2 and sid=1) b,(select context from t_reply where type=1 and sid=1) c,
            (select createtime lastTime from t_reply where type=2 and sid=1 order by createtime desc limit 0,1) d where a.id=1*/




/*    SELECT a.*,rep,new,look,lastTime from t_send a,
(select count(*) rep from t_reply where type=2 and sid=1) b,
            (select count(1) look from t_reply where type=1 and sid=1) c,
            (select createtime lastTime from t_reply where type=2 and sid=1 order by createtime desc limit 0,1) d,
            (select context new from t_reply where type=2 and sid=1) e
    where  a.flag=1 and id=1*/
}
