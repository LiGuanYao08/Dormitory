package cn.dormitory.dao;

import cn.dormitory.pojo.Info;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoDao {
    /**
     * 添加学生查询所有信息表
     */
    @Select("select * from t_info")
    List<Info> getInfo();

    /**
     * 删除对应信息表
     */
    @Delete("delete from t_info where id=#{id}")
    int deleteInfo(@Param("id") int id);

    /**
     * 新增信息
     */
    @Insert("insert into t_info (infoStatus,message) values(#{infoStatus},#{message})")
    int insertInfo(@Param("infoStatus") int infoStatus, @Param("message") String message);

    /**
     * 修改信息
     */
    @Update("update t_info set message=#{message} where id=#{id}")
    int updateInfo(@Param("id") int id, @Param("message") String message);
}
