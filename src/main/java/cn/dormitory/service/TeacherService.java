package cn.dormitory.service;

import cn.dormitory.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    /**
     * teacher逻辑层接口
     */
    Teacher login(@Param("teaNumber") String teaNumber, @Param("teaPassword") String teaPassword);

    /**
     * 获取教师个人信息
     */
    Teacher getTeacherInfo(@Param("id") int id);

    /**
     * 查询教师集合列表
     */
    List<Teacher> getTeacherList();

    /**
     * 模糊查询教师集合
     */
    List<Teacher> getDimTeacherList(@Param("keyword") String keyword);

    /**
     * 删除指定教师
     */
    int deleteTeacher(@Param("id") int id);

    /**
     * 修改教师信息
     */
    int updateTeacher(@Param("teaName") String teaName, @Param("teaPassword") String teaPassword,
                      @Param("teaJobStatus") int teaJobStatus, @Param("teaSubjects") String teaSubjects,
                      @Param("teaPhone") String teaPhone, @Param("teaWork") String teaWork,
                      @Param("teaInfo") String teaInfo, @Param("id") int id);

    /**
     * 添加教师
     */
    int insertTeacher(@Param("teaImgUrl") String teaImgUrl, @Param("teaName") String teaName,
                      @Param("teaGender") String teaGender, @Param("teaNumber") String teaNumber,
                      @Param("teaPassword") String teaPassword, @Param("teaCollege") String teaCollege,
                      @Param("teaMajor") String teaMajor, @Param("teaJobStatus") int teaJobStatus,
                      @Param("teaSubjects") String teaSubjects, @Param("teaPhone") String teaPhone,
                      @Param("teaWork") String teaWork, @Param("teaRegistration") String teaRegistration,
                      @Param("teaInfo") String teaInfo);
}
