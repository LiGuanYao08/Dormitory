package cn.dormitory.service.impl;

import cn.dormitory.dao.TeacherDao;
import cn.dormitory.pojo.Teacher;
import cn.dormitory.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;


    @Override
    public Teacher login(String teaNumber, String teaPassword) {
        return teacherDao.login (teaNumber, teaPassword);
    }

    @Override
    public Teacher getTeacherInfo(int id) {
        return teacherDao.getTeacherInfo (id);
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDao.getTeacherList ();
    }

    @Override
    public List<Teacher> getDimTeacherList(String keyword) {
        return teacherDao.getDimTeacherList (keyword);
    }

    @Override
    public int deleteTeacher(int id) {
        return teacherDao.deleteTeacher (id);
    }

    @Override
    public int updateTeacher(String teaName, String teaPassword,
                             int teaJobStatus, String teaSubjects,
                             String teaPhone, String teaWork,
                             String teaInfo, int id) {
        return teacherDao.updateTeacher (teaName, teaPassword, teaJobStatus,
                teaSubjects, teaPhone, teaWork, teaInfo, id);
    }

    @Override
    public int insertTeacher(String teaImgUrl, String teaName, String teaGender,
                             String teaNumber, String teaPassword, String teaCollege,
                             String teaMajor, int teaJobStatus, String teaSubjects,
                             String teaPhone, String teaWork, String teaRegistration,
                             String teaInfo) {
        System.out.println ("获取到的值：" + teaImgUrl + teaName + teaGender + teaNumber + teaPassword + teaCollege + teaMajor + teaJobStatus + teaSubjects + teaPhone + teaWork + teaRegistration + teaInfo);
        return teacherDao.insertTeacher (teaImgUrl, teaName, teaGender, teaNumber,
                teaPassword, teaCollege, teaMajor, teaJobStatus, teaSubjects,
                teaPhone, teaWork, teaRegistration, teaInfo);
    }
}
