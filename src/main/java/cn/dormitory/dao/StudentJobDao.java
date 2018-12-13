package cn.dormitory.dao;

import cn.dormitory.pojo.Student;
import cn.dormitory.pojo.StudentJob;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJobDao {
    /**
     * 被关联查询信息,列表形式
     */
    @Select("select * from t_studentjob where stuStatus=#{stuStatus}")
    List<StudentJob> getStudentJobList(@Param("stuStatus") int stuStatus);

    /**
     * 查询学生职位所有信息
     */
    @Select("select * from t_studentjob")
    List<StudentJob> getStudentJobAll();
}
