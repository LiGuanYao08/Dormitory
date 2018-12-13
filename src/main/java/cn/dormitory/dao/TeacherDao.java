package cn.dormitory.dao;

import cn.dormitory.pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    /**
     * 教师用户登录
     * Teacher
     */
    @Select("select * from t_teacher where teaNumber=#{teaNumber} and teaPassword=#{teaPassword}")
    @Results({
            @Result(id = true, column = "teaNumber", property = "teaNumber"),
            @Result(id = true, column = "teaPassword", property = "teaPassword"),
            @Result(
                    property = "teacherJob",
                    column = "teaJobStatus",
                    one = @One(select = "cn.dormitory.dao.TeacherJobDao.getJob"))})
    Teacher login(@Param("teaNumber") String teaNumber, @Param("teaPassword") String teaPassword);

    /**
     * 根据id获取教师个人信息
     */
    @Select("select * from t_teacher where id=#{id}")
    @Results({
            @Result(id = true, column = "teaNumber", property = "teaNumber"),
            @Result(id = true, column = "teaPassword", property = "teaPassword"),
            @Result(
                    property = "teacherJob",
                    column = "teaJobStatus",
                    one = @One(select = "cn.dormitory.dao.TeacherJobDao.getJob"))})
    Teacher getTeacherInfo(@Param("id") int id);

    /**
     * 查询教师集合列表
     */
    @Select("select * from t_teacher")
    @Results({
            @Result(id = true, column = "teaNumber", property = "teaNumber"),
            @Result(id = true, column = "teaPassword", property = "teaPassword"),
            @Result(
                    property = "teacherJob",
                    column = "teaJobStatus",
                    one = @One(select = "cn.dormitory.dao.TeacherJobDao.getJob"))})
    List<Teacher> getTeacherList();

    /**
     * 模糊搜索教师集合
     * 根据 姓名 工号模糊查询
     */
    @Select("select * from t_teacher where concat(teaName,teaNumber) like concat('%',#{keyword},'%')")
    @Results({
            @Result(
                    property = "teacherJob",
                    column = "teaJobStatus",
                    one = @One(select = "cn.dormitory.dao.TeacherJobDao.getJob"))})
    List<Teacher> getDimTeacherList(@Param("keyword") String keyword);

    /**
     * 根据id删除指指定教师
     */
    @Delete("delete from t_teacher where id=#{id}")
    int deleteTeacher(@Param("id") int id);

    /**
     * 修改教师信息
     */
    @Update("update t_teacher set teaName=#{teaName},teaPassword=#{teaPassword},teaJobStatus=#{teaJobStatus}," +
            "teaSubjects=#{teaSubjects},teaPhone=#{teaPhone}," +
            "teaWork=#{teaWork},teaInfo=#{teaInfo} where id=#{id}")
    int updateTeacher(@Param("teaName") String teaName, @Param("teaPassword") String teaPassword,
                      @Param("teaJobStatus") int teaJobStatus, @Param("teaSubjects") String teaSubjects,
                      @Param("teaPhone") String teaPhone, @Param("teaWork") String teaWork,
                      @Param("teaInfo") String teaInfo, @Param("id") int id);

    /**
     * 添加新教师
     */
    @Insert("insert into t_teacher (teaImgUrl,teaName,teaGender," +
            "teaNumber,teaPassword,teaCollege,teaMajor," +
            "teaJobStatus,teaSubjects,teaPhone,teaWork," +
            "teaRegistration,teaInfo) values(#{teaImgUrl}," +
            "#{teaName},#{teaGender},#{teaNumber},#{teaPassword}," +
            "#{teaCollege},#{teaMajor},#{teaJobStatus},#{teaSubjects}," +
            "#{teaPhone},#{teaWork},#{teaRegistration},#{teaInfo})")
    int insertTeacher(@Param("teaImgUrl") String teaImgUrl, @Param("teaName") String teaName,
                      @Param("teaGender") String teaGender, @Param("teaNumber") String teaNumber,
                      @Param("teaPassword") String teaPassword, @Param("teaCollege") String teaCollege,
                      @Param("teaMajor") String teaMajor, @Param("teaJobStatus") int teaJobStatus,
                      @Param("teaSubjects") String teaSubjects, @Param("teaPhone") String teaPhone,
                      @Param("teaWork") String teaWork, @Param("teaRegistration") String teaRegistration,
                      @Param("teaInfo") String teaInfo);
}
