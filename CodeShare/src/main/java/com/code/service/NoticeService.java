package com.code.service;


import com.code.common.vo.ResultVo;
import com.code.domain.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {

    boolean save(Notice notice);
    List<Map<String,Object>> queryAll();
    ResultVo delete(int id);
    ResultVo update(String title, String context, int id);
}
