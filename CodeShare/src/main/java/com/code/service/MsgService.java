package com.code.service;


import com.code.domain.Msg;

import java.util.List;

public interface MsgService {
    //新增
    boolean save(Msg msg);
    //查询
    List<Msg> queryAll();
    //删除
    boolean delete(int id);
    /*//自己查询自己的
    Msg queryById(int uid);*/
}
