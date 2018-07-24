package com.code.service.Imple;

import com.code.common.vo.ResultVo;
import com.code.dao.ReplyDao;
import com.code.domain.Reply;
import com.code.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao dao;

    @Override
    public boolean save(Reply reply) {
        return dao.insert(reply)>0;
    }

    @Override   //查询咨询的回复
    public List<Reply> queryBySid(int sid) {
        return dao.queryBySid(sid);
    }

    @Override       //修改查看数量
    public ResultVo update(int sid) {
       if(dao.update(sid)>0){
           return  ResultVo.setOK("成功");
       }else {
           return  ResultVo.setERROR("失败");
       }
    }

    @Override  //更改查看次数
    public boolean changLook(int sid) {
            if(dao.queryByLook(sid)!=null){
                //修改
                return  dao.update(sid)>0;
            }else {
                Reply re = new Reply();
                re.setContext("1");
                re.setType(1);
                re.setSid(sid);
                return  dao.insert(re)>0;
            }
    }

    @Override  //删除留言
    public ResultVo delete(int id) {
       if (dao.delete(id)>0){
            return ResultVo.setOK("成功");
       }else {
           return  ResultVo.setERROR("成功");
       }
    }
}
