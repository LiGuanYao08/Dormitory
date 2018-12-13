package cn.dormitory.service;

import cn.dormitory.pojo.TeacherJob;

import java.util.List;

public interface TeacherJobService {
    /**
     * 查询教师职位信息
     */
    List<TeacherJob> getTeacherJobAll();
}
