package com.code.web.controller;

import com.code.domain.Follow;
import com.code.domain.User;
import com.code.service.FollowService;
import com.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class FollowController {
    @Autowired
    private FollowService service;

    @Autowired
    private UserService userService;
    @RequestMapping("/addFollow.do")
    @ResponseBody
    String addFollow(int beuid, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Follow follow = new Follow(user.getId(), beuid);
            List<Follow> list = service.queryFollow(follow);
            if (list == null || list.size() == 0) {
                if (service.addFollow(follow)) {
                    userService.addOrSubFollow(user.getId(),"add");
                    return "1";
                }
            } else {
                if (service.delFollow(follow)) {
                    userService.addOrSubFollow(user.getId(),"sub");
                    return "0";
                }
            }
        }
        return "nologin";
    }

    @RequestMapping("/queryFollow.do")
    @ResponseBody
    String queryFollow(int beuid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Follow follow = new Follow(user.getId(), beuid);
            List<Follow> list = service.queryFollow(follow);
            if (list == null || list.size() == 0) {
                return "0";
            } else {
                return "1";
            }
        }
        return "nologin";
    }

}
