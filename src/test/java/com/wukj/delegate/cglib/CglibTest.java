package com.wukj.delegate.cglib;

import com.wukj.delegate.statics.UserDao;

import org.junit.Test;

public class CglibTest {

    @Test
    public void testCglib() {

        // 目标对象
        UserDao target = new UserDao();
        // 代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        // 执行代理对象的方法
        proxy.save();

    }
}
