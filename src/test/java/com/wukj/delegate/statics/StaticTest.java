package com.wukj.delegate.statics;

import org.junit.Test;

public class StaticTest {

    @Test
    public void testStatic() {

       //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        //执行的是代理的方法
        proxy.save();

    }
}



