package cn.dormitory.controller;

import cn.dormitory.pojo.Student;
import cn.dormitory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 查询学生信息列表
     */
    @RequestMapping(value = "/getStudentInfoList", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudentInfoList(HttpServletRequest request) {
        //执行方法
        List<Student> studentList = studentService.getStudentList ();
        System.out.println ("获取到的全部学生信息列表：" + studentList);
        return studentList;
    }

    /**
     * 模糊查询学生信息列表
     */
    @RequestMapping(value = "/getDimStudentList/{keyword}", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getDimStudentList(@PathVariable String keyword) {
        List<Student> studentList = studentService.getDimStudentList (keyword);
        return studentList;
    }

    /**
     * 根据id查询学生个人信息
     */
    @RequestMapping(value = "/getStudentInfo", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentInfo(@RequestParam("id") int id) {
        System.out.println ("获取到的id:" + id);
        Student students = studentService.getStudentInfo (id);
        return students;
    }

    /**
     * 根据id删除指定学生
     */
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteStudent(@RequestParam("id") int id) {
        int row = studentService.deleteStudent (id);
        System.out.println ("删除成功的代码：" + row);
        //删除成功后跳转查询全部信息
    }

    /**
     * 修改学生信息
     */
    @RequestMapping(value = "/updateStudent", method = RequestMethod.PUT)
    @ResponseBody
    public void updateStudent(@RequestParam("id") int id, @RequestParam("stuName") String stuName,
                              @RequestParam("stuGender") String stuGender, @RequestParam("stuJobStatus") int stuJobStatus,
                              @RequestParam("stuHouseAddress") String stuHouseAddress, @RequestParam("stuPhone") String stuPhone,
                              @RequestParam("stuRemark") String stuRemark) {
        System.out.println ("获取到的studentName：" + stuName);
        int row = studentService.updateStudent (stuName, stuGender, stuJobStatus, stuHouseAddress, stuPhone, stuRemark, id);
        System.out.println ("更新成功：" + row);
        Student students = studentService.getStudentInfo (id);
        System.out.println ("更新后：" + students);
    }

    /**
     * 添加新学生
     */
    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    @ResponseBody
    public void insertStudent(@RequestParam("stuName") String stuName, @RequestParam("stuGender") String stuGender, @RequestParam("stuNumber") String stuNumber,
                              @RequestParam("stuCollege") String stuCollege, @RequestParam("stuMajor") String stuMajor, @RequestParam("stuGrade") String stuGrade,
                              @RequestParam("stuClass") String stuClass, @RequestParam("stuJobStatus") int stuJobStatus, @RequestParam("stuPhone") String stuPhone,
                              @RequestParam("stuHouseAddress") String stuHouseAddress, @RequestParam("stuRegistration") String stuRegistration,
                              @RequestParam("stuRemark") String stuRemark) {
        System.out.println ("添加学生获取到的student：" + stuName);
        int row = studentService.insertStudent (stuName, stuGender, stuNumber,
                stuCollege, stuMajor, stuGrade, stuClass,
                stuJobStatus, stuPhone, stuHouseAddress,
                stuRegistration, stuRemark);
        System.out.println ("添加成功：" + row);
    }
}
