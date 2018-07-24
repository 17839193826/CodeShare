package com.code.dao;

import com.code.common.vo.UserDetailVo;
import com.code.domain.UserDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;

public interface UserDetailDao {
    //修改个人信息
    @Update("UPDATE t_user a,t_userdetail b set a.nickname=#{nickname},b.email=#{email},b.sign=#{sign},b.birthday=#{birthday},b.sex=#{sex} where a.id=#{id}")
    int updateUserDetail(UserDetailVo userDetailVo);

    //新增
    @Insert("insert into t_userdetail(uid) values(#{uid})")
    int addUserDetail(int uid);

    //增加发帖数
    @Update("update t_userdetail set sendnum=sendnum+1 where uid=#{uid}")
    int addSendNum(int uid);

    //增加回帖数
    @Update("update t_userdetail set replynum=replynum+1 where uid=#{uid}")
    int addReplyNum(int uid);

    //增加关注数
    @Update("update t_userdetail set follow=follow+1 where uid=#{uid}")
    int addFollow(int uid);

    //减少关注数
    @Update("update t_userdetail set follow=follow-1 where uid=#{uid}")
    int reduceFollow(int uid);

    //增加粉丝数
    @Update("update t_userdetail set fans=fans+1 where uid=#{uid}")
    int addFans(int uid);

    //减少粉丝数
    @Update("update t_userdetail set fans=fans-1 where uid=#{uid}")
    int reduceFans(int uid);

    //修改头像
    @Update("update t_userdetail set photo=#{photo} where uid=#{uid}")
    int updatePhoto(@Param("photo") String photo, @Param("uid") int uid);

}
