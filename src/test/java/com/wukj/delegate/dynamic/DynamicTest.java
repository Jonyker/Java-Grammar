package com.wukj.delegate.dynamic;

import com.wukj.delegate.statics.IUserDao;
import com.wukj.delegate.statics.UserDao;

import org.junit.Test;

public class DynamicTest {

    @Test
    public void testDynamic() {

        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class com.wukj.delegate.statics.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0 内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法 【代理对象】
        proxy.save();

    }
}
