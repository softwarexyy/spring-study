package com.yancy.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public String selNameByCrdlsNo(String crdlsNo) {
        return "默认实现根据" + crdlsNo + "获取用户名";
    }
}
