package cn.dormitory.dao;

import cn.dormitory.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    /**
     * 查询全部学生列表信息
     */
    @Select("select * from t_student")
    @Results({
            @Result(
                    property = "studentJobList",
                    column = "stuJobStatus",
                    one = @One(select = "cn.dormitory.dao.StudentJobDao.getStudentJobList"))})
    List<Student> getStudentList();

    /**
     * 模糊查询学生信息列表
     */
    @Select("select * from t_student where concat(stuName,stuNumber,stuCollege,stuMajor,stuGrade,stuClass) like concat('%',#{keyword},'%')")
    @Results({
            @Result(
                    property = "studentJobList",
                    column = "stuJobStatus",
                    one = @One(select = "cn.dormitory.dao.StudentJobDao.getStudentJobList"))})
    List<Student> getDimStudentList(@Param("keyword") String keyword);

    /**
     * 根据id查询单个学生信息
     */
    @Select("select * from t_student where id=#{id}")
    @Results({
            @Result(
                    property = "studentJobList",
                    column = "stuJobStatus",
                    one = @One(select = "cn.dormitory.dao.StudentJobDao.getStudentJobList"))})
    Student getStudentInfo(@Param("id") int id);

    /**
     * 根据id删除指定学生
     */
    @Delete("delete from t_student where id=#{id}")
    int deleteStudent(@Param("id") int id);

    /**
     * 修改学生信息
     */
    @Update("update t_student set stuName=#{stuName}," +
            "stuGender=#{stuGender},stuJobStatus=#{stuJobStatus}," +
            "stuHouseAddress=#{stuHouseAddress},stuPhone=#{stuPhone},stuRemark=#{stuRemark} where id=#{id}")
    int updateStudent(@Param("stuName") String stuName, @Param("stuGender") String stuGender,
                      @Param("stuJobStatus") int stuJobStatus, @Param("stuHouseAddress") String stuHouseAddress,
                      @Param("stuPhone") String stuPhone, @Param("stuRemark") String stuRemark, @Param("id") int id);

    /**
     * 添加新学生
     */
    @Insert("insert into t_student (stuName,stuGender,stuNumber," +
            "stuCollege,stuMajor,stuGrade,stuClass," +
            "stuJobStatus,stuPhone,stuHouseAddress," +
            "stuRegistration,stuRemark) values(#{stuName},#{stuGender},#{stuNumber}," +
            "#{stuCollege},#{stuMajor},#{stuGrade},#{stuClass},#{stuJobStatus}" +
            ",#{stuPhone},#{stuHouseAddress},#{stuRegistration},#{stuRemark})")
    int insertStudent(@Param("stuName") String stuName, @Param("stuGender") String stuGender, @Param("stuNumber") String stuNumber,
                      @Param("stuCollege") String stuCollege, @Param("stuMajor") String stuMajor, @Param("stuGrade") String stuGrade,
                      @Param("stuClass") String stuClass, @Param("stuJobStatus") int stuJobStatus, @Param("stuPhone") String stuPhone,
                      @Param("stuHouseAddress") String stuHouseAddress, @Param("stuRegistration") String stuRegistration,
                      @Param("stuRemark") String stuRemark);
}
