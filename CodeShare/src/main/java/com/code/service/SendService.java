package com.code.service;

import com.code.common.vo.PageVo;
import com.code.common.vo.V_Send;
import com.code.domain.Send;

import java.util.List;

public interface SendService {
        //新增
    public boolean insert(Send send);
    /*//删除
    //从有效变成无效               0:是无效 1是有效 2是封禁 3是关闭评论
    public ResultVo delete(int id);
    //从封禁状态变成无效
    public ResultVo delete1(int id);
    //从有效变封禁
    public ResultVo delete2(int id);
    //从封禁变有效
    public ResultVo delete3(int id);
    //从有效变成关闭评论
    public ResultVo delete4(int id);
    //从关闭评论变成有效
    public ResultVo delete5(int id);
*/

    //修改帖子状态
    public boolean updateFlag(int flag, int id);


    //查询分页
    public PageVo<V_Send> queryByPage(int page, int count);

    //查询数量
    public Long queryCount(int index, int count);

    //随机查询10条帖子
    public List<Send> queryRand();

    //查看咨询详情页
    public  Send queryById(int id);
}
