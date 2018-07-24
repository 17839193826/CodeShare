package com.code.service;

import com.code.common.vo.PageVo;
import com.code.common.vo.UserDetailVo;
import com.code.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //新增
    boolean insert(User user);

    //登陆
    User login(String username, String password);

    //修改密码
    boolean updatePasswordById(String password, int id);

    //修改权限级别
    boolean updateLevelById(int level, int id);

    //分页查询所有有效用户
    PageVo<User> queryAllValidUser(int index, int count);

    //分页查询所有无效用户
    PageVo<User> queryAllInvalidUser(int index, int count);

    //根据id查询用户所有信息
    List<Map<String, Object>> queryOneUserById(int id);

    //修改个人信息
    boolean updateUserDetail(UserDetailVo userDetailVo);

    //增加发帖数
    boolean addSendNum(int uid);

    //增加回帖数
    boolean addReplyNum(int uid);

    //修改关注数
    boolean addOrSubFollow(int uid, String str);

    //修改粉丝数
    boolean addOrSubFans(int uid, String str);

    //修改头像
    boolean updatePhoto(String photo, int uid);
}
