package com.code.service.Imple;

import com.code.common.vo.PageVo;
import com.code.common.vo.V_Send;
import com.code.dao.SendDao;
import com.code.domain.Send;
import com.code.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SendServiceImpl implements SendService {
    @Autowired
    private SendDao dao;

    @Override
    public boolean insert(Send send) {
        return dao.insert(send) > 0;
    }

    @Override
    public boolean updateFlag(int flag, int id) {
        return dao.updateFlag(flag,id)>0;
    }

    /*@Override
    public ResultVo delete(int id) {
        if (dao.delete(id) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete1(int id) {
        if (dao.delete(id) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete2(int id) {
        if (dao.delete(id) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete3(int id) {
        if (dao.delete(id) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete4(int id) {
        if (dao.delete(id) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public ResultVo delete5(int id) {
        if (dao.delete(id) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }*/

    @Override
    public PageVo<V_Send> queryByPage(int page, int count) {
            PageVo<V_Send> vo = new PageVo<>();
            int index = 0;
            if (page > 0) {
                index = (page - 1) * count;
            }
            List<V_Send> list = dao.queryByPage(index, count);
            if (list != null) {
                vo.setCode(0);
                vo.setMsg("");
                vo.setData(list);
                vo.setCount(dao.queryCount().intValue());
            } else {
                vo.setCode(1);
                vo.setMsg("暂时没有数据");
                vo.setData(new ArrayList<>());
                vo.setCount(0);
            }
            return vo;
        }

    @Override
    public Long queryCount(int index, int count) {
     return    dao.queryCount();
    }

    @Override
    public List<Send> queryRand() {
        return dao.queryRand();
    }

    @Override
    public Send queryById(int id) {
        return dao.queryById(id);
    }

}
