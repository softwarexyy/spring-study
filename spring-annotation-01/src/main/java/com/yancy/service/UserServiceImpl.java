package com.yancy.service;

import com.yancy.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userDaoMysql")         // 强制使用userDaoOracle的实现
    private IUserDao userDao;

    @Override
    public String getNameByCrdlsNo(String crdlsNo) {
        return userDao.selNameByCrdlsNo(crdlsNo);
    }
}
