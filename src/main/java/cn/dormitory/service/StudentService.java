package cn.dormitory.service;

import cn.dormitory.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    /**
     * 查询学生列表信息
     */
    List<Student> getStudentList();

    /**
     * 模糊查询学生列表信息
     */
    List<Student> getDimStudentList(@Param("keyword") String keyword);

    /**
     * 根据id查询学生个人信息
     */
    Student getStudentInfo(@Param("id") int id);

    /**
     * 根据id删除指定学生
     */
    int deleteStudent(@Param("id") int id);

    /**
     * 修改学生信息
     */
    int updateStudent(@Param("stuName") String stuName, @Param("stuGender") String stuGender,
                      @Param("stuJobStatus") int stuJobStatus, @Param("stuHouseAddress") String stuHouseAddress,
                      @Param("stuPhone") String stuPhone, @Param("stuRemark") String stuRemark, @Param("id") int id);

    /**
     * 添加新学生
     */
    int insertStudent(@Param("stuName") String stuName, @Param("stuGender") String stuGender, @Param("stuNumber") String stuNumber,
                      @Param("stuCollege") String stuCollege, @Param("stuMajor") String stuMajor, @Param("stuGrade") String stuGrade,
                      @Param("stuClass") String stuClass, @Param("stuJobStatus") int stuJobStatus, @Param("stuPhone") String stuPhone,
                      @Param("stuHouseAddress") String stuHouseAddress, @Param("stuRegistration") String stuRegistration,
                      @Param("stuRemark") String stuRemark);
}
