package cn.dormitory.service.impl;

import cn.dormitory.dao.StudentDao;
import cn.dormitory.pojo.Student;
import cn.dormitory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList ();
    }

    @Override
    public List<Student> getDimStudentList(String keyword) {
        return studentDao.getDimStudentList (keyword);
    }

    @Override
    public Student getStudentInfo(int id) {
        return studentDao.getStudentInfo (id);
    }

    @Override
    public int deleteStudent(int id) {
        int row = studentDao.deleteStudent (id);
        System.out.println ("删除成功代码：" + row);
        return row;
    }

    @Override
    public int updateStudent(String stuName, String stuGender, int stuJobStatus,
                             String stuHouseAddress, String stuPhone,
                             String stuRemark, int id) {
        int row = studentDao.updateStudent (stuName, stuGender, stuJobStatus, stuHouseAddress, stuPhone, stuRemark, id);
        System.out.println ("修改成功代码：" + row);
        return row;
    }

    @Override
    public int insertStudent(String stuName, String stuGender,
                             String stuNumber, String stuCollege,
                             String stuMajor, String stuGrade,
                             String stuClass, int stuJobStatus,
                             String stuPhone, String stuHouseAddress,
                             String stuRegistration, String stuRemark) {
        int row = studentDao.insertStudent (stuName, stuGender, stuNumber,
                stuCollege, stuMajor, stuGrade, stuClass,
                stuJobStatus, stuPhone, stuHouseAddress,
                stuRegistration, stuRemark);
        System.out.println ("添加成功：" + row);
        return row;
    }


}
