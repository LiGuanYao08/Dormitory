package cn.dormitory.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 学生信息表
 */
@Component
public class Student {
    /**
     * id编号
     */
    private int id;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学生性别
     */
    private String stuGender;
    /**
     * 学号
     */
    private String stuNumber;
    /**
     * 学院
     */
    private String stuCollege;
    /**
     * 专业
     */
    private String stuMajor;
    /**
     * 年级
     */
    private String stuGrade;
    /**
     * 班级
     */
    private String stuClass;
    /**
     * 职位状态，对应学生状态表
     * 以数字表示职位
     */
    private int stuJobStatus;
    /**
     * 联系方式
     */
    private String stuPhone;
    /**
     * 家庭地址
     */
    private String stuHouseAddress;
    /**
     * 登记时间
     */
    private String stuRegistration;
    /**
     * 备注信息
     */
    private String stuRemark;
    /**
     * 关联的表信息，学生列表形式
     */
    private List<StudentJob> studentJobList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public int getStuJobStatus() {
        return stuJobStatus;
    }

    public void setStuJobStatus(int stuJobStatus) {
        this.stuJobStatus = stuJobStatus;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuHouseAddress() {
        return stuHouseAddress;
    }

    public void setStuHouseAddress(String stuHouseAddress) {
        this.stuHouseAddress = stuHouseAddress;
    }

    public String getStuRegistration() {
        return stuRegistration;
    }

    public void setStuRegistration(String stuRegistration) {
        this.stuRegistration = stuRegistration;
    }

    public String getStuRemark() {
        return stuRemark;
    }

    public void setStuRemark(String stuRemark) {
        this.stuRemark = stuRemark;
    }

    public List<StudentJob> getStudentJobList() {
        return studentJobList;
    }

    public void setStudentJobList(List<StudentJob> studentJobList) {
        this.studentJobList = studentJobList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuNumber='" + stuNumber + '\'' +
                ", stuCollege='" + stuCollege + '\'' +
                ", stuMajor='" + stuMajor + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuJobStatus=" + stuJobStatus +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuHouseAddress='" + stuHouseAddress + '\'' +
                ", stuRegistration='" + stuRegistration + '\'' +
                ", stuRemark='" + stuRemark + '\'' +
                ", studentJobList=" + studentJobList +
                '}';
    }
}

