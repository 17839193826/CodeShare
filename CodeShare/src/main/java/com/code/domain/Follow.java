package com.code.domain;

public class Follow {
    private int id;
    private int uid;
    private int beuid;

    public Follow() {
    }

    public Follow(int uid, int beuid) {
        this.uid = uid;
        this.beuid = beuid;
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

    public int getBeuid() {
        return beuid;
    }

    public void setBeuid(int beuid) {
        this.beuid = beuid;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", uid=" + uid +
                ", beuid=" + beuid +
                '}';
    }
}
