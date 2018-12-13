package cn.dormitory.pojo;

import org.springframework.stereotype.Component;

/**
 * 教师信息表
 */
@Component
public class Teacher {
    /**
     * 教师编号
     */
    private int id;
    /**
     * 教师用户头像上传
     */
    private String teaImgUrl;
    /**
     * 教师姓名
     */
    private String teaName;
    /**
     * 性别
     */
    private String teaGender;
    /**
     * 工号
     */
    private String teaNumber;
    /**
     * 登录密码
     */
    private String teaPassword;
    /**
     * 所在学院
     */
    private String teaCollege;
    /**
     * 所在专业
     */
    private String teaMajor;
    /**
     * 职位状态,对应教师职位，数字表示
     */
    private int teaJobStatus;
    /**
     * 就任科目
     */
    private String teaSubjects;
    /**
     * 联系方式
     */
    private String teaPhone;
    /**
     * 办公地点
     */
    private String teaWork;
    /**
     * 登记时间
     */
    private String teaRegistration;
    /**
     * 备注信息
     */
    private String teaInfo;
    /**
     * 关联的教师职位状态信息
     */
    private TeacherJob teacherJob;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeaImgUrl() {
        return teaImgUrl;
    }

    public void setTeaImgUrl(String teaImgUrl) {
        this.teaImgUrl = teaImgUrl;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaGender() {
        return teaGender;
    }

    public void setTeaGender(String teaGender) {
        this.teaGender = teaGender;
    }

    public String getTeaNumber() {
        return teaNumber;
    }

    public void setTeaNumber(String teaNumber) {
        this.teaNumber = teaNumber;
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword;
    }

    public String getTeaCollege() {
        return teaCollege;
    }

    public void setTeaCollege(String teaCollege) {
        this.teaCollege = teaCollege;
    }

    public String getTeaMajor() {
        return teaMajor;
    }

    public void setTeaMajor(String teaMajor) {
        this.teaMajor = teaMajor;
    }

    public int getTeaJobStatus() {
        return teaJobStatus;
    }

    public void setTeaJobStatus(int teaJobStatus) {
        this.teaJobStatus = teaJobStatus;
    }

    public String getTeaSubjects() {
        return teaSubjects;
    }

    public void setTeaSubjects(String teaSubjects) {
        this.teaSubjects = teaSubjects;
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone;
    }

    public String getTeaWork() {
        return teaWork;
    }

    public void setTeaWork(String teaWork) {
        this.teaWork = teaWork;
    }

    public String getTeaRegistration() {
        return teaRegistration;
    }

    public void setTeaRegistration(String teaRegistration) {
        this.teaRegistration = teaRegistration;
    }

    public String getTeaInfo() {
        return teaInfo;
    }

    public void setTeaInfo(String teaInfo) {
        this.teaInfo = teaInfo;
    }

    public TeacherJob getTeacherJob() {
        return teacherJob;
    }

    public void setTeacherJob(TeacherJob teacherJob) {
        this.teacherJob = teacherJob;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teaImgUrl='" + teaImgUrl + '\'' +
                ", teaName='" + teaName + '\'' +
                ", teaGender='" + teaGender + '\'' +
                ", teaNumber='" + teaNumber + '\'' +
                ", teaPassword='" + teaPassword + '\'' +
                ", teaCollege='" + teaCollege + '\'' +
                ", teaMajor='" + teaMajor + '\'' +
                ", teaJobStatus=" + teaJobStatus +
                ", teaSubjects='" + teaSubjects + '\'' +
                ", teaPhone='" + teaPhone + '\'' +
                ", teaWork='" + teaWork + '\'' +
                ", teaRegistration='" + teaRegistration + '\'' +
                ", teaInfo='" + teaInfo + '\'' +
                ", teacherJob=" + teacherJob +
                '}';
    }
}
