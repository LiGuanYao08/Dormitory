package cn.dormitory.service;

import cn.dormitory.pojo.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoService {
    /**
     * 添加用户查询信息设置
     */
    List<Info> getInfo();

    /**
     * 删除对应信息表
     */
    int deleteInfo(@Param("id") int id);

    /**
     * 新增信息
     */
    int insertInfo(@Param("infoStatus") int infoStatus, @Param("message") String message);

    /**
     * 修改信息
     */
    int updateInfo(@Param("id") int id, @Param("message") String message);
}
