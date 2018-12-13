package cn.dormitory.pojo;

import org.springframework.stereotype.Component;

/**
 * 教师职位状态
 */
@Component
public class TeacherJob {
    /**
     * 教师职位状态编号
     */
    private int id;
    /**
     * 教师职位状态码，对应职位
     */
    private int teaStatus;
    /**
     * 职位信息
     */
    private String teaPositionInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeaStatus() {
        return teaStatus;
    }

    public void setTeaStatus(int teaStatus) {
        this.teaStatus = teaStatus;
    }

    public String getTeaPositionInfo() {
        return teaPositionInfo;
    }

    public void setTeaPositionInfo(String teaPositionInfo) {
        this.teaPositionInfo = teaPositionInfo;
    }

    @Override
    public String toString() {
        return "TeacherJob{" +
                "id=" + id +
                ", teaStatus=" + teaStatus +
                ", teaPositionInfo='" + teaPositionInfo + '\'' +
                '}';
    }
}
