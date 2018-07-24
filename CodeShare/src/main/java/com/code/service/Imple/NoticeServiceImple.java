package com.code.service.Imple;

import com.code.common.vo.ResultVo;
import com.code.dao.NoticeDao;
import com.code.domain.Notice;
import com.code.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImple implements NoticeService {

    @Autowired
    private NoticeDao dao;


    public boolean save(Notice notice) {
        return dao.save(notice)>0;
    }

    public List<Map<String,Object>> queryAll() {
        return dao.queryAll();
    }

    public ResultVo delete(int id) {
        if (dao.delete(id)>0){
            return ResultVo.setOK("公告删除成功！");
        }else{
            return ResultVo.setERROR("删除公告失败！");
        }
    }

    public ResultVo update(String title, String context, int id) {
        if (dao.Update(title,context,id)>0){
            return ResultVo.setOK("修改公告成功！");
        }else {
            return ResultVo.setERROR("修改公告失败！");
        }
    }
}
