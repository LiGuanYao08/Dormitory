package cn.dormitory.dao;

import cn.dormitory.pojo.TeacherJob;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherJobDao {
    /**
     * 被关联查询的信息
     */
    @Select("select * from t_teacherjob where teaStatus=#{teaStatus}")
    TeacherJob getJob(@Param("teaStatus") int teaStatus);

    /**
     * 查询教师所有职位信息
     */
    @Select("select * from t_teacherjob")
    List<TeacherJob> getTeacherJobAll();
}
