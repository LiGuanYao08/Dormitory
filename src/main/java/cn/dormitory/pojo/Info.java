package cn.dormitory.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统信息表
 */
@Component
public class Info {
    /**
     * 编号
     */
    private int id;
    /**
     * 信息对应类型码
     * 0：为学院类型（计算机，管理等），1：为专业类型（计算机，网工等），
     * 2：班级类型（16计科1，16计科2等），3：学生职位类型（班长，团支书等），
     * 4：教师职位类型（书记，主任，辅导员，科任（高数，英语）老师）
     */
    private int infoStatus;
    /**
     * 类型具体信息说明
     */
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(int infoStatus) {
        this.infoStatus = infoStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", infoStatus=" + infoStatus +
                ", message='" + message + '\'' +
                '}';
    }
}

