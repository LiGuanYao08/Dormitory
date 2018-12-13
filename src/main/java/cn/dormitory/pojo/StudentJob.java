package cn.dormitory.pojo;

import org.springframework.stereotype.Component;

/**
 * 学生职位状态
 */
@Component
public class StudentJob {
    /**
     * 职位状态id编号
     */
    private int id;
    /**
     * 学生状态码
     */
    private int stuStatus;
    /**
     * 职位信息
     */
    private String stuPositionInfo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(int stuStatus) {
        this.stuStatus = stuStatus;
    }

    public String getStuPositionInfo() {
        return stuPositionInfo;
    }

    public void setStuPositionInfo(String stuPositionInfo) {
        this.stuPositionInfo = stuPositionInfo;
    }

    @Override
    public String toString() {
        return "StudentJob{" +
                "id=" + id +
                ", stuStatus=" + stuStatus +
                ", stuPositionInfo='" + stuPositionInfo + '\'' +
                '}';
    }
}
