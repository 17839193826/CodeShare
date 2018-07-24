package com.code.service.Imple;

import com.code.dao.FollowDao;
import com.code.domain.Follow;
import com.code.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowDao dao;
    @Override
    public boolean addFollow(Follow follow) {
        return dao.addFollow(follow)>0;
    }

    @Override
    public boolean delFollow(Follow follow) {
        return dao.delFollow(follow)>0;
    }

    @Override
    public List<Follow> queryFollow(Follow follow) {
        return dao.queryFollow(follow);
    }
}
