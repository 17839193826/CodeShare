package com.code.web.controller;

import com.code.common.vo.ResultVo;
import com.code.domain.Reply;

import com.code.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService service;

    //新增回复
    @RequestMapping(value = "addreply.do", method = {RequestMethod.POST})
    public String add(Reply reply) {
        if (service.save(reply)) {
            return "";
        } else {
            return "";
        }
    }

    //查询咨询回复的内容
    @RequestMapping("listreply.do")
    @ResponseBody
    public List<Reply> queryBySid(int sid) {
        return service.queryBySid(sid);
    }

    //修改查看次数
    @ResponseBody
    @RequestMapping(value = "lookreply.do", method = {RequestMethod.POST})
    public ResultVo update(int sid) {
        return service.update(sid);
    }

    //更改查看次数
    @ResponseBody
    @RequestMapping(value = "upreply.do", method = {RequestMethod.POST})
    public boolean changLook(int sid) {
        return service.changLook(sid);
    }

    //删除留言
    @RequestMapping(value = "delreply.do", method = {RequestMethod.POST})
    public ResultVo delete(int id) {
        return service.delete(id);
    }

}
