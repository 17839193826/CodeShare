package com.code.web.controller;

import com.code.common.vo.PageVo;
import com.code.common.vo.ResultVo;
import com.code.common.vo.V_Send;
import com.code.domain.Send;
import com.code.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SendController {
    @Autowired
    private SendService service;

    //新增
    @RequestMapping(value = "addsend.do",method = {RequestMethod.POST})
     public String add(Send send) {
        if (service.insert(send)) {
            System.out.println("今天星期天");
            return "senglist";

        } else {
            return "";
        }
    }
   /* //删除
    //从有效变成无效
    @RequestMapping(value = "addsend1", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete(int id) {
        return service.delete(id);
    }

    //从封禁状态变成无效
    @RequestMapping(value = "addsend2",method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete1(int id) {
        return service.delete1(id);
    }

    //从有效变封禁
    @RequestMapping(value = "addsend3", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete2(int id) {
        return service.delete2(id);
    }

    //从封禁变有效
    @RequestMapping(value = "addsend4", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete3(int id) {
        return service.delete3(id);
    }

    //从有效变成关闭评论
    @RequestMapping(value = "addsend5", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete4(int id) {
        return service.delete4(id);
    }

    //从关闭评论变成有效
    @RequestMapping(value = "addsend6", method = {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete5(int id) {
        return service.delete5(id);
    }*/

   //从有效变成无效   flag 0:是无效,1:有效 2：封禁 3关闭评论
    @RequestMapping(value = "delsend.do",method = {RequestMethod.POST})
    @ResponseBody
    public  ResultVo del(int id){
        if (service.updateFlag(0,id)){
            return ResultVo.setOK("成功");
        }else {
            return ResultVo.setERROR("失败");
        }
    }

    //从无效变有效
    @RequestMapping(value = "flagsend.do",method = {RequestMethod.POST})
    @ResponseBody
    public  ResultVo change(int id){
        if (service.updateFlag(1,id)){
            return ResultVo.setOK("成功");
        }else {
            return ResultVo.setERROR("失败");
        }
    }

    //从有效变封禁
    @RequestMapping(value = "upsend.do",method = {RequestMethod.POST})
    @ResponseBody
    public  ResultVo changge1(int id){
        if (service.updateFlag(2,id)){
            return ResultVo.setOK("成功");
        }else {
            return ResultVo.setERROR("失败");
        }
    }

    //从封禁变有效
    @RequestMapping(value = "up1send.do",method = {RequestMethod.POST})
    @ResponseBody
    public  ResultVo changge2(int id){
        if (service.updateFlag(1,id)){
            return ResultVo.setOK("成功");
        }else {
            return ResultVo.setERROR("失败");
        }
    }

    //从有效变关闭评论
    @RequestMapping(value = "up2send.do",method = {RequestMethod.POST})
    @ResponseBody
    public  ResultVo changge3(int id){
        if (service.updateFlag(3,id)){
            return ResultVo.setOK("成功");
        }else {
            return ResultVo.setERROR("失败");
        }
    }

    //从关闭评论到有效
    @RequestMapping(value = "up3send.do",method = {RequestMethod.POST})
    @ResponseBody
    public  ResultVo changge4(int id){
        if (service.updateFlag(1,id)){
            return ResultVo.setOK("成功");
        }else {
            return ResultVo.setERROR("失败");
        }
    }

    //从关闭评论到无效
    @RequestMapping(value = "up4send.do",method = {RequestMethod.POST})
    @ResponseBody
    public  ResultVo changge5(int id){
        if (service.updateFlag(0,id)){
            return ResultVo.setOK("成功");
        }else {
            return ResultVo.setERROR("失败");
        }
    }


    //查询分页
    @RequestMapping("pagesend.do")
    @ResponseBody
    public PageVo<V_Send> queryPage(int page, int limit){
        PageVo<V_Send> pagevo = service.queryByPage(page,limit);
        return  pagevo;
    }


    //随机查询10条帖子
    @RequestMapping(value="qusend.do")
    @ResponseBody
    public List<Send> queryRand(){
            return  service.queryRand();
    }


    //查看咨询的详情
    @RequestMapping(value = "listsend.do")
    @ResponseBody
    public Send queryById(int id){
    return     service.queryById(id);
    }
}



