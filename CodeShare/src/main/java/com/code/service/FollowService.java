package com.code.service;

import com.code.domain.Follow;

import java.util.List;

public interface FollowService {
    boolean addFollow(Follow follow);

    boolean delFollow(Follow follow);

    List<Follow> queryFollow(Follow follow);
}
