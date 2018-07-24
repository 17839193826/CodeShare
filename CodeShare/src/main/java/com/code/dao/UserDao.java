package com.code.dao;

import com.code.domain.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

public interface UserDao {
    //注册
    @Insert("insert into t_user(username,password,nickname,level,createtime,flag) values(#{username},#{password},#{nickname},1,now(),1)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")//获取自增主键的值
    int insert(User user);

    //登陆
    @Select("select * from t_user where username=#{username} and password=#{password} and flag=1")
    @ResultType(User.class)
    User queryUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //修改密码
    @Update("update t_user set password=#{password} where id=#{id} flag=1")
    int updatePasswordById(@Param("password") String password, @Param("id") int id);

    //修改权限级别
    @Update("update t_user set level=#{level} where id=#{id} and flag=1")
    int updateLevelById(@Param("level") int level, @Param("id") int id);

    //注销账号
    @Update("update t_user set flag=2 where id=#{id}")
    int updateFlagById(int id);

    //分页查询所有有效用户
    @Select("select * from t_user where flag=1 order by createtime desc limit #{index},#{count}")
    @ResultType(User.class)
    List<User> queryAllValidUser(@Param("index") int index, @Param("count") int count);

    //分页查询所有无效用户
    @Select("select * from t_user where flag=1 order by createtime desc limit #{index},#{count}")
    @ResultType(User.class)
    List<User> queryAllInvalidUser(@Param("index") int index, @Param("count") int count);

    //根据id查询用户所有信息
    @Select("select a.id,a.username,a.createtime,a.nickname,a.flag,a.level,b.* from t_user a,t_userdetail b where a.id=b.uid and a.id=#{id} and a.flag=1")
    @ResultType(Map.class)
    List<Map<String, Object>> queryOneUserById(int id);

    //查询有效用户数量
    @Select("select cout(*) from t_user where flag=1")
    @ResultType(Long.class)
    Long queryValidCount();

    //查询无效用户数量
    @Select("select cout(*) from t_user where flag=2")
    @ResultType(Long.class)
    Long queryInvalidCount();

}
