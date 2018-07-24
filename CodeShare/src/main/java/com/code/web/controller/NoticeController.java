package com.code.web.controller;

import com.code.common.vo.ResultVo;
import com.code.domain.Notice;
import com.code.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService service;

    @RequestMapping("/noticeadd.do")
    public String save(Notice notice){
        if (service.save(notice)){
            System.out.println("添加成功！");
        }
        return "notice.html";
    }

    @ResponseBody
    @RequestMapping("/noticelist.do")
    public List<Map<String,Object>> queryAll(){
        List<Map<String,Object>> list = service.queryAll();
        return list;
    }

    @RequestMapping("/noticeupdate.do")
    public String updateFrom(String title, String context, int id){
        if (service.update(title, context, id).getCode()==1000){
            return "";
        }else{
            return "";
        }
    }

    @RequestMapping("/noticedelete.do")
    @ResponseBody
    public ResultVo delete(int id){
        return service.delete(id);
    }

}
