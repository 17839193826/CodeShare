package com.code.web.controller;

import com.code.common.vo.PageVo;
import com.code.common.vo.UserDetailVo;
import com.code.domain.User;
import com.code.domain.UserDetail;
import com.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/regist.do")
    public String Regist(User user) {
        System.out.println(user);
        service.insert(user);
        return "login";
    }

    //登录
    @RequestMapping("/login.do")
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("用户名：" + username + ",密码：" + password);
        User user = service.login(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            Cookie cookie = new Cookie("nickname", user.getNickname());
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
            try {
                if (user.getLevel() > 2) {
                    response.sendRedirect("/admin/index.html");
                } else {
                    response.sendRedirect("index.html");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //注销登陆
    @RequestMapping("/loginout.do")
    public void loginout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        try {
            Cookie cookie = new Cookie("nickname", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //修改密码
    @RequestMapping("/updatePassword.do")
    public String updatePasswordById(String password, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            if (service.updatePasswordById(password, user.getId())) {
                return "";
            }
        }
        return "";
    }

    //修改权限级别
    @RequestMapping("/updateLevel.do")
    public String updateLevelById(int level, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            if (service.updateLevelById(level, user.getId())) {
                return "";
            }
        }
        return "";
    }

    //修改个人信息
    @RequestMapping("/updateUser.do")
    public String updateUserUser(UserDetailVo userDetailVo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            userDetailVo.setId(user.getId());
            service.updateUserDetail(userDetailVo);
            return "set";
        }
        return "set";

    }

    //修改头像
    @RequestMapping("/updatePhoto.do")
    public String updatePhoto(String photo, int uid) {
        if (service.updatePhoto(photo, uid)) {
            return "";
        }
        return "";
    }


    //增加发帖数
    @RequestMapping("/addSend.do")
    public String addSendNum(int uid) {
        if (service.addSendNum(uid)) {
            return "";
        }
        return "";
    }


    //增加回帖数
    @RequestMapping("/addReply.do")
    public String addReplyNum(int uid) {
        if (service.addReplyNum(uid)) {
            return "";
        }
        return "";
    }

    //修改关注数
    @RequestMapping("/aosFollow.do")
    public String addOrSubFollow(int uid, String str) {
        if (service.addOrSubFollow(uid, str)) {
            return "";
        }
        return "";
    }


    //修改粉丝数
    @RequestMapping("/aosFans.do")
    public String addOrSubFans(int uid, String str) {
        if (service.addOrSubFans(uid, str)) {
            return "";
        }
        return "";
    }

    //根据id查询用户所有信息
    @RequestMapping("/queryOneUser.do")
    @ResponseBody
    public List<Map<String, Object>> queryOneUserById(int id) {
            return service.queryOneUserById(id);
    }

    //查询登陆用户所有信息
    @RequestMapping("/queryLogin.do")
    @ResponseBody
    public List<Map<String, Object>> queryLogin(HttpServletRequest request) {
        User user=(User)request.getSession().getAttribute("user");
        if (user != null) {
            return service.queryOneUserById(user.getId());
        }
        return  null;
    }


    //分页查询所有有效用户
    @RequestMapping("/queryAll.do")
    @ResponseBody
    public PageVo<User> queryAllValidUser(int page, int limit) {
        return service.queryAllValidUser(page, limit);
    }


    //分页查询所有无效用户
    @RequestMapping("/queryAllIn.do")
    @ResponseBody
    public PageVo<User> queryAllInvalidUser(int page, int limit) {
        return service.queryAllInvalidUser(page, limit);
    }
}
