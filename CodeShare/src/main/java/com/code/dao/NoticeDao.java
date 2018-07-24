package com.code.dao;

import com.code.domain.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface NoticeDao {

    @Insert("insert into t_notice(title,context,createtime,uid,flag,pid) value(#{title},#{context},now(),#{uid},1,#{pid})")
    int save(Notice notice);

    @Select("select a.*,b.nickname from t_notice a,t_user b where a.uid=b.id")
    @ResultType(Map.class)
    List<Map<String,Object>> queryAll();

    @Delete("update t_notice set flag=2 where id=#{id}")
    int delete(int id);

    @Update("update t_notice set tiele=#{title},context=#{context} where flag=1 and id=#{id}")
    int Update(@Param("title") String title, @Param("context") String context, @Param("id") int id);
}
