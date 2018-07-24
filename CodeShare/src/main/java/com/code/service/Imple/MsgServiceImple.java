package com.code.service.Imple;

import com.code.dao.MsgDao;
import com.code.domain.Msg;
import com.code.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImple implements MsgService {
    @Autowired
    private MsgDao dao;

    public boolean save(Msg msg) {
        return dao.insert(msg)>0;
    }

    public List<Msg> queryAll() {
        return dao.queryAll();
    }

    public boolean delete(int id) {
        return dao.delete(id)>0;
    }
}
