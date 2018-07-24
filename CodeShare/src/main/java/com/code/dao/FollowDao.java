package com.code.dao;

import com.code.domain.Follow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import java.util.List;


public interface FollowDao {
    //添加关注
    @Insert("insert into t_follow(uid,beuid) values(#{uid},#{beuid})")
    int addFollow(Follow follow);

    //取消关注
    @Delete("delete from t_follow where uid=#{uid} and beuid=#{beuid}")
    int delFollow(Follow follow);

    //查询是否关注
    @Select("select * from t_follow where uid=#{uid} and beuid=#{beuid}")
    @ResultType(Follow.class)
    List<Follow> queryFollow(Follow follow);
}
