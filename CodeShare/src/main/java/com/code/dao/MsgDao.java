package com.code.dao;

import com.code.domain.Msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MsgDao {

    //新增留言
    @Insert("insert into t_msg (beuid,uid,msg,createtime,flag) values(#{beuid},#{uid},#{msg},now(),1)")
    int insert(Msg msg);

    //查看留言
    @Select("select * from t_msg")
    @ResultType(Msg.class)
    List<Msg> queryAll();

    //删除留言
    @Delete("delete from t_msg where id=#{id}")
    int delete(int id);
    /*//自己查看自己的留言
    @Select("select * from t_msg where uid=#{uid}")
    @ResultType(Msg.class)
    Msg queryById(int uid);*/
}
