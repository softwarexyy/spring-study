package com.yancy.dao;

import org.springframework.stereotype.Repository;

@Repository("userDaoOracle")
public class UserDaoOracleImpl implements IUserDao {
    @Override
    public String selNameByCrdlsNo(String crdlsNo) {
        return "Oracle根据" + crdlsNo + "查询用户";
    }
}
