package com.wukj.delegate.statics;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 6:07
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 6:07
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class ToIn {

    public static void main(String args[]) {

        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        //执行的是代理的方法
        proxy.save();

    }


}
