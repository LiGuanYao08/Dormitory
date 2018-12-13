package cn.dormitory.service;

import cn.dormitory.pojo.StudentJob;

import java.util.List;

public interface StudentJobService {
    /**
     * 查询学生职位所有信息
     */
    List<StudentJob> getStudentJobAll();
}
