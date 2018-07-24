package com.code.domain;

import java.sql.Date;

public class UserDetail {
    private int id;
    private int uid;
    private String email;
    private int sendnum;
    private int replynum;
    private int follow;
    private int fans;
    private String sign;
    private String photo;
    private int sex;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSendnum() {
        return sendnum;
    }

    public void setSendnum(int sendnum) {
        this.sendnum = sendnum;
    }

    public int getReplynum() {
        return replynum;
    }

    public void setReplynum(int replynum) {
        this.replynum = replynum;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", uid=" + uid +
                ", email='" + email + '\'' +
                ", sendnum=" + sendnum +
                ", replynum=" + replynum +
                ", follow=" + follow +
                ", fans=" + fans +
                ", sign='" + sign + '\'' +
                ", photo='" + photo + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
