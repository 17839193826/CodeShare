package com.code.web.controller;

import com.code.domain.Msg;
import com.code.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MsgController {
    @Autowired
    private MsgService service;

    //新增
    @RequestMapping("/msgsave.do")
    public String save(Msg msg){
        if (service.save(msg)){
            //
            System.out.println("留言成功");
        }
        return "msg.html";
    }

    @ResponseBody
    @RequestMapping("/msgall.do")
    public List<Msg> queryAll(){
        return service.queryAll();
    }

    @RequestMapping("/msgdel.do")
    public void msgdel(int id, HttpServletResponse response) throws IOException {
        if (service.delete(id)){//成功为1
            response.getWriter().print(1);
        }else {//失败为2
            response.getWriter().print(2);
        }
    }

}
