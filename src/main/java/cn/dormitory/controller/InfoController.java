package cn.dormitory.controller;

import cn.dormitory.pojo.Info;
import cn.dormitory.pojo.StudentJob;
import cn.dormitory.pojo.TeacherJob;
import cn.dormitory.service.InfoService;
import cn.dormitory.service.StudentJobService;
import cn.dormitory.service.TeacherJobService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private StudentJobService studentJobService;

    @Autowired
    private TeacherJobService teacherJobService;

    /**
     * 查询信息表设置
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    @ResponseBody
    public List<Info> getInfo() {
        System.out.println ("进入查询");
        List<Info> info = infoService.getInfo ();
        System.out.println ("查询成功");
        return info;
    }

    /**
     * 查询学生职位信息*
     */
    @RequestMapping(value = "/getStu", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentJob> getStu() {
        System.out.println ("进入查询");
        List<StudentJob> studentJobList = studentJobService.getStudentJobAll ();
        return studentJobList;
    }

    /**
     * 查询教师职位信息*
     */
    @RequestMapping(value = "/getTea", method = RequestMethod.GET)
    @ResponseBody
    public List<TeacherJob> getTea() {
        List<TeacherJob> teacherJobList = teacherJobService.getTeacherJobAll ();
        return teacherJobList;
    }

    /**
     * 删除对应信息表
     */
    @RequestMapping(value = "/deleteInfo", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteInfo(@RequestParam("id") int id) {
        int row = infoService.deleteInfo (id);
        System.out.println ("删除成功代码：" + row);
    }

    /**
     * 新增信息
     */
    @RequestMapping(value = "/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public void insertInfo(@RequestParam("infoStatus") int infoStatus, @RequestParam("message") String message) {
        int row = infoService.insertInfo (infoStatus, message);
        System.out.println ("新增成功代码：" + row);
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
    @ResponseBody
    public void updateInfo(@RequestParam("id") int id, @RequestParam("message") String message) {
        System.out.println ("获取的修改值：" + id + ":" + message);
        int row = infoService.updateInfo (id, message);
        System.out.println ("修改成功代码：" + row);
    }
}
