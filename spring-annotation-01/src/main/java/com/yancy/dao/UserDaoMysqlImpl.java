package com.yancy.dao;

import org.springframework.stereotype.Repository;

@Repository("userDaoMysql")
public class UserDaoMysqlImpl implements IUserDao {
    @Override
    public String selNameByCrdlsNo(String crdlsNo) {
        return "Mysql根据" + crdlsNo + "查询用户";
    }
}
