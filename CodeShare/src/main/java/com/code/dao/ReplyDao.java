package com.code.dao;

import com.code.domain.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReplyDao {
    //新增回复
    @Insert("insert into t_reply(context,createtime,flag,type,sid,uid) value(#{context},now(),1,2,#{sid},#{uid})")
    public int insert(Reply reply);

    //查询咨询回复
    @Select("select * from t_reply where type=2 and  sid=#{sid}")
    @ResultType(Reply.class)
    public List<Reply> queryBySid(int sid);

    //修改查看数量  type 1:是查看   2：回复
    @Update("update t_reply set content=content+1 where type=1 and sid=#{sid}")
    public int update(int sid);

    //获取查看数量
    @Update("select * from t_reply where type=1 and sid=#{sid}")
    @ResultType(Reply.class)
    public Reply queryByLook(int sid);

    //删除回复
    @Update("update t_reply set flag=0 where id=#{id}")
    int delete(int id);


}
