package cn.dormitory.service.impl;

import cn.dormitory.dao.TeacherJobDao;
import cn.dormitory.pojo.TeacherJob;
import cn.dormitory.service.TeacherJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherJobServiceImpl implements TeacherJobService {

    @Autowired
    private TeacherJobDao teacherJobDao;

    @Override
    public List<TeacherJob> getTeacherJobAll() {
        return teacherJobDao.getTeacherJobAll ();
    }
}
