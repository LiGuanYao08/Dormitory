package cn.dormitory.service.impl;

import cn.dormitory.dao.InfoDao;
import cn.dormitory.pojo.Info;
import cn.dormitory.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao;


    @Override
    public List<Info> getInfo() {
        return infoDao.getInfo ();
    }

    @Override
    public int deleteInfo(int id) {
        return infoDao.deleteInfo (id);
    }

    @Override
    public int insertInfo(int infoStatus, String message) {
        return infoDao.insertInfo (infoStatus, message);
    }

    @Override
    public int updateInfo(int id, String message) {
        return infoDao.updateInfo (id, message);
    }
}
