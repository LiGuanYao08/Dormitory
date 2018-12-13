package cn.dormitory.service.impl;

import cn.dormitory.dao.StudentJobDao;
import cn.dormitory.pojo.StudentJob;
import cn.dormitory.service.StudentJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentJobServiceImpl implements StudentJobService {

    @Autowired
    private StudentJobDao studentJobDao;

    @Override
    public List<StudentJob> getStudentJobAll() {
        return studentJobDao.getStudentJobAll ();
    }
}
