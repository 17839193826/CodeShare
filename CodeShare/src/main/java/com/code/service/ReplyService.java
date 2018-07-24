package com.code.service;

import com.code.common.vo.ResultVo;
import com.code.domain.Reply;

import java.util.List;

public interface ReplyService {
    //新增回复
    public  boolean save(Reply reply);

    //查询咨询的回复
    public List<Reply> queryBySid(int sid);

    //修改查看数量
    public ResultVo update(int sid);

    ////更改查看次数
    public  boolean changLook(int sid);


    //删除留言
    public  ResultVo delete(int id);
}
