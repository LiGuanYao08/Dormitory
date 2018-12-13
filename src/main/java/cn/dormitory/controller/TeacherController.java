package cn.dormitory.controller;

import cn.dormitory.pojo.Teacher;
import cn.dormitory.service.TeacherService;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 教师用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Teacher teacher, HttpSession session, HttpServletRequest request) {
        System.out.println ("获取到的teacher：" + teacher.getTeaNumber () + ":" + teacher.getTeaPassword ());
        //执行登录操作,密码不做加密处理---------
        Teacher teachers = teacherService.login (teacher.getTeaNumber (), teacher.getTeaPassword ());
        if (teachers != null && teachers.getTeaNumber ().equals (teacher.getTeaNumber ())) {
            System.out.println ("-------------------------------------------------------------------");
            System.out.println ("登录成功之后的teacher：" + teachers);
            //保存入session中<---不使用spring session--->
            session.setAttribute ("teacherInfo", teachers);
            //进入主页面
            //重定向
            return "redirect:adminIndex.jsp";
        } else {
            System.out.println ("----------------------------登录失败------------------------------");
            request.setAttribute ("code", "账户或者密码错误，请确认后再登录");
            //请求转发到登录界面并提示错误
            return "forward:/login.jsp";
        }
    }

    /**
     * 教师安全退出登录
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        //清除session对象中得所有信息
        session.removeAttribute ("teacherInfo");
        session.invalidate ();
        request.setAttribute ("code", "已安全退出登录");
        return "forward:/login.jsp";
    }

    /**
     * 获取教师个人信息
     */
    @RequestMapping(value = "/getTeacherInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Teacher getTeacherInfo(@PathVariable int id) {
        Teacher teachers = teacherService.getTeacherInfo (id);
        System.out.println ("查询教师个人信息：" + teachers);
        return teachers;
    }

    /**
     * 查询教师集合列表
     */
    @RequestMapping(value = "/getTeacherList", method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getTeacherList() {
        System.out.println ("执行查询");
        List<Teacher> teacherList = teacherService.getTeacherList ();
        System.out.println ("查询之后的：" + teacherList);
        return teacherList;
    }

    /**
     * 模糊查询教师集合
     * 根据 工号，姓名
     */
    @RequestMapping(value = "/getDimTeacherList/{keyword}", method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getDimTeacherList(@PathVariable String keyword) {
        List<Teacher> teacherList = teacherService.getDimTeacherList (keyword);
        return teacherList;
    }

    /**
     * 删除指定教师
     */
    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTeacher(@RequestParam int id, HttpServletRequest request) {
        //删除服务器的数据
        Teacher teachers = teacherService.getTeacherInfo (id);
        //获取服务器路径
        String imgUrl = request.getSession ().getServletContext ().getRealPath ("/WEB-INF/static/teacherImg/" + teachers.getTeaNumber ());
        //创建文件对象
        File deFile = new File (imgUrl);
        //判断文件是否存在
        if (deFile.exists ()) {
            //判断是否是文件
            if (deFile.isFile ()) {
                //删除文件
                deFile.delete ();
                //否则如果是一个目录
            } else if (deFile.isDirectory ()) {
                //定义目录下所有文件，并且删除
                File[] files = deFile.listFiles ();
                files[0].delete ();
                //删除文件夹
                boolean code = deFile.delete ();
                if (code) {
                    System.out.println ("删除成功" + code);
                } else {
                    System.out.println ("删除失败" + code);
                }
            }
        } else {
            System.out.println ("删除的文件不存在");
        }
        int row = teacherService.deleteTeacher (id);

        System.out.println ("删除成功的代码:" + row);
    }

    /**
     * 修改教师信息
     */
    @RequestMapping(value = "/updateTeacher", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTeacher(@RequestParam("teaName") String teaName,
                              @RequestParam("teaPassword") String teaPassword, @RequestParam("teaJobStatus") int teaJobStatus,
                              @RequestParam("teaSubjects") String teaSubjects, @RequestParam("teaPhone") String teaPhone,
                              @RequestParam("teaWork") String teaWork, @RequestParam("teaInfo") String teaInfo,
                              @RequestParam("id") int id) {
        //更新操作
        int row = teacherService.updateTeacher (teaName, teaPassword, teaJobStatus, teaSubjects, teaPhone, teaWork, teaInfo, id);
        System.out.println ("更新成功代码：" + row);
    }

    /**
     * 添加教师
     */
    @RequestMapping(value = "/insertTeacher", method = RequestMethod.POST)
    @ResponseBody
    public void insertTeacher(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("teaName") String teaName,
                              @RequestParam("teaGender") String teaGender, @RequestParam("teaNumber") String teaNumber,
                              @RequestParam("teaPassword") String teaPassword, @RequestParam("teaCollege") String teaCollege,
                              @RequestParam("teaMajor") String teaMajor, @RequestParam("teaJobStatus") int teaJobStatus,
                              @RequestParam("teaSubjects") String teaSubjects, @RequestParam("teaPhone") String teaPhone,
                              @RequestParam("teaWork") String teaWork, @RequestParam("teaRegistration") String teaRegistration,
                              @RequestParam("teaInfo") String teaInfo, HttpServletRequest request) {
        /**
         * 判断是否有同一个用户
         * */
        List<Teacher> teacherList = teacherService.getTeacherList ();
        for (int i = 0; i < teacherList.size (); i++) {
            if (teacherList.get (i).getTeaNumber ().equals (teaNumber)) {
                System.out.println ("传进来的：" + teaNumber);
                System.out.println ("已存在该用户");
                return;
            } else if (i == (teacherList.size () - 1)) {
                /**
                 * 图片上传服务器
                 * */
                //定义获取的文件名
                String fileName;
                //获取的文件拓展名
                String fileHZM;
                //定义文件上传路径
                String filePath;
                //设置数据库保存路径
                String teaImgUrl;
                try {
                    //获取文件名，使用随机数UUID给图片重命名，并且去掉“-”
                    fileName = UUID.randomUUID ().toString ().replaceAll ("-", "");
                    System.out.println ("重命名后的文件名：" + fileName);
                    //获取文件拓展名
                    fileHZM = FilenameUtils.getExtension (file.getOriginalFilename ());
                    System.out.println ("获取的文件拓展名：" + fileHZM);
                    //设置文件上传路径,以工号作为目录区分
                    filePath = request.getSession ().getServletContext ().getRealPath ("/WEB-INF/static/teacherImg/" + teaNumber);
                    //创建文件对象
                    File fileUrl = new File (filePath);
                    //创建文件路径,没有父目录就创建一个
                    fileUrl.mkdirs ();
                    System.out.println ("文件上传路径：" + fileUrl);
                    //以绝对路径保存重命名后的图片
                    file.transferTo (new File (filePath + "\\" + fileName + "." + fileHZM));
                    //设置数据库的路径值
                    teaImgUrl = "/static/teacherImg/" + teaNumber + "/" + fileName + "." + fileHZM;
                    /**
                     * 存取到数据库的操作
                     * */
                    int row = teacherService.insertTeacher (teaImgUrl, teaName, teaGender,
                            teaNumber, teaPassword, teaCollege, teaMajor, teaJobStatus,
                            teaSubjects, teaPhone, teaWork, teaRegistration, teaInfo);
                    System.out.println ("增加成功的代码：" + row);
                } catch (IllegalAccessError e) {
                    System.out.println ("上传失败");
                    e.fillInStackTrace ();
                } catch (IOException e) {
                    System.out.println ("上传失败：io流引起");
                    e.printStackTrace ();
                }
            }
        }
    }
}
