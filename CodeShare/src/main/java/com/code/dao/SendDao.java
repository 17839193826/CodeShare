package com.code.dao;

import com.code.common.vo.V_Send;
import com.code.domain.Send;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SendDao {
        //新增咨询
    @Insert("insert into t_send(title,context,createtime,flag,hot,uid,pid)value (#{title},#{context},now(),1,0,#{uid},#{pid})")
    int insert(Send send);

    //查询  分页
    @Select(
            "select s.*,rep,look,lastTime,nickname,pname from t_send s\n" +
                    " left join (select count(*) rep,sid from t_reply  where type=2 group by sid ) r1 on s.id=r1.sid \n" +
                    "left join (select count(*) look,sid from t_reply where type=1 GROUP BY sid) r2 on s.id=r2.sid \n" +
                    "left join (select id,nickname from t_user where flag=1) r4 on r4.id=s.uid\n"+
                    "LEFT JOIN (SELECT id,name pname from t_plate where flag=1) r5 on r5.id=s.pid\n"+
                    "left join (select MAX(createtime) lastTime,sid from t_reply where type=2 group by sid) r3 on s.id=r3.sid where  s.flag = 1  limit #{rowindex},#{count}")

    @ResultType(V_Send.class)                //给index命名为rowindex                       //rid
    List<V_Send> queryByPage(@Param("rowindex") int index, @Param("count") int count);

        //最开始的查询
   /* @Select("SELECT a.*, rep, new, look, lastTime from t_send a,\n" +
            "(select count(*) rep from t_reply where type=2 and sid=1) b,\n"+
            "(select count(1) look from t_reply where type=1 and sid=1) c,\n" +
            "(select createtime lastTime from t_reply where type=2 and sid=1 order by createtime desc limit 0,1) d,\n" +
            "(select context new from t_reply where type=2 and sid=1) e\n" +
            " where  a.flag=1 and id=#{id} order by hot desc b.rep desc limit #{rowindex},#{count}")*/

   //最开始查询的迭代
 /*   SELECT a.*,rep,new,look,lastTime from t_send a,\n" +
            "(select count(*) rep from t_reply where type=2 and sid=1) b,\n" +
            "(select count(1) look from t_reply where type=1 and sid=1) c,\n" +
            "(select createtime lastTime from t_reply where type=2 and sid=1 order by createtime desc limit 0,1) d,\n" +
            "(select context new f t_reply where type=2 and sid=1) e\n" +
            " where a.flag=1 limit #{rowindex},#{count}")*/


//查询所有  全面
/*    SELECT a.*,rep,new,look,lastTime from t_send a,
(select count(*) rep from t_reply where type=2 ) b,
            (select count(1) look from t_reply where type=1 ) c,
            (select createtime lastTime from t_reply where type=2 and sid=1 order by createtime desc limit 0,1) d,
            (select context new from t_reply where type=2 ) e
    where  a.flag=1*/



//查询不带回复
/*SELECT a.*,rep,look,lastTime from t_send a,
(select count(*) rep from t_reply where type=2 ) b,
            (select count(1) look from t_reply where type=1 ) c,
            (select createtime lastTime from t_reply where type=2 and sid=1 order by createtime desc limit 0,1) d
    where  a.flag=1*/


    //查询咨询详情
    @Select("select * from t_Send where id=#{id}")
    @ResultType(Send.class)
    public  Send queryById(int id);

  /*      //删除
    //从有效变成无效               0:是无效 1是有效 2是封禁 3是关闭评论
    @Update("update t_send set flag=0 where id=#{id}")
    int delete(int id);


    //从封禁状态变成无效
    @Update("update t_send set flag=0 where id=#{id} and flag=2 ")
    int delete1(int id);




    //从有效变封禁
    @Update("update t_send set flag=2 where id=#{id} and flag=1")
    int delete2(int id);

    //从封禁变有效
    @Update("update t_send set flag=1 where id=#{id} and flag=2")
    int delete3(int id);


    //从有效变成关闭评论
    @Update("update t_send set flag=3 where id=#{id} and flag=1")
    int delete4(int id);

    //从关闭评论变成有效
    @Update("update t_send set flag=1 where id=#{id} and flag=3")
    int delete5(int id);*/

    //修改帖子状态    0:是无效 1是有效 2是封禁 3是关闭评论
    @Update("update t_send set flag=#{flag} where id=#{id}")
    int updateFlag(@Param("flag") int flag, @Param("id") int id);


   /*
    //修改
    @Update("update t_send set title=#{title},context=#{contest} Where flag=1")
    int update(Send send);*/


    //总数量
    @Select("select count(*) from t_send where flag=1")
    @ResultType(Long.class)
    Long queryCount();

    //从表中随机抽取6条帖子进行展示
    @Select("select * from t_send  order by  rand() limit 6")
    @ResultType(Send.class)
    List<Send> queryRand();

    @Update("update t_send set hot=#{hot} where id=#{id}")
    public  int updatehot(@Param("hot") int hot, @Param("id") int id);

    //查询咨询列表
    @Select("")
    public List<V_Send> queryAll();


}

