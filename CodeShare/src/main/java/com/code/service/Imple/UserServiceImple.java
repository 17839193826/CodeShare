package com.code.service.Imple;

import com.code.common.util.MD5Utils;
import com.code.common.vo.PageVo;
import com.code.common.vo.UserDetailVo;
import com.code.dao.UserDao;
import com.code.dao.UserDetailDao;
import com.code.domain.User;
import com.code.domain.UserDetail;
import com.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    private UserDao dao;
    @Autowired
    private UserDetailDao detailDao;

    @Override
    public boolean insert(User user) {
        user.setPassword(MD5Utils.md5(user.getPassword()));
        if (dao.insert(user) > 0) {
            if (detailDao.addUserDetail(user.getId()) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        return dao.queryUserByUsernameAndPassword(username, MD5Utils.md5(password));
    }

    @Override
    public boolean updatePasswordById(String password, int id) {
        return dao.updatePasswordById(password, id) > 0;
    }

    @Override
    public boolean updateLevelById(int level, int id) {
        return dao.updateLevelById(level, id) > 0;
    }

    @Override
    public PageVo<User> queryAllValidUser(int page, int count) {
        PageVo<User> vo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * count;
        }
        List<User> list = dao.queryAllValidUser(index, count);
        if (list != null) {
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(dao.queryValidCount().intValue());
        } else {
            vo.setCode(1);
            vo.setMsg("暂无数据");
            vo.setData(new ArrayList<>());
            vo.setCount(0);
        }
        return vo;
    }

    @Override
    public PageVo<User> queryAllInvalidUser(int page, int count) {
        PageVo<User> vo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * count;
        }
        List<User> list = dao.queryAllInvalidUser(index, count);
        if (list != null) {
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(dao.queryValidCount().intValue());
        } else {
            vo.setCode(1);
            vo.setMsg("暂无数据");
            vo.setData(new ArrayList<>());
            vo.setCount(0);
        }
        return vo;
    }

    @Override
    public List<Map<String, Object>> queryOneUserById(int id) {
        return dao.queryOneUserById(id);
    }

    @Override
    public boolean updateUserDetail(UserDetailVo userDetailVo) {
        return detailDao.updateUserDetail(userDetailVo) > 0;
    }

    @Override
    public boolean addSendNum(int uid) {
        return detailDao.addSendNum(uid) > 0;
    }

    @Override
    public boolean addReplyNum(int uid) {
        return detailDao.addReplyNum(uid) > 0;
    }

    @Override
    public boolean addOrSubFollow(int uid, String str) {
        if ("add".equals(str)) {
            return detailDao.addFollow(uid) > 0;
        } else if ("sub".equals(str)) {
            return detailDao.reduceFollow(uid) > 0;
        }
        return false;
    }

    @Override
    public boolean addOrSubFans(int uid, String str) {
        if ("add".equals(str)) {
            return detailDao.addFans(uid) > 0;
        } else if ("sub".equals(str)) {
            return detailDao.reduceFans(uid) > 0;
        }
        return false;
    }

    @Override
    public boolean updatePhoto(String photo, int uid) {
        return detailDao.updatePhoto(photo, uid) > 0;
    }
}
