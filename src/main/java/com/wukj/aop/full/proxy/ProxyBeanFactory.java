package com.wukj.aop.full.proxy;

import com.wukj.aop.full.exception.BeanNameAlreadyExistException;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:10
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:10
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class ProxyBeanFactory {
    private static final Map<String, FyProxy> beanMap;
    private static final Map<String, String> beanNameMap;

    static {
        beanMap = new HashMap<>();
        beanNameMap = new HashMap<>();
    }

    // beanNameMap是类名和注解自定义名字的对应（因为考虑到使用者会在注解中给类名别的“称谓”）
    public <T> T creatCglibProxy(Class<?> klass) throws Exception {
        return cglibProxy(klass, klass.newInstance());
    }

    public <T> T creatCglibProxy(Object object) {
        return cglibProxy(object.getClass(), object);
    }

    // 以CGLIB方式为例：
    // 这里的目的是最上层创建代理并将其加入Map中
    // 若该类已经存在代理，即fyProxy对象
    // 则直接返回该对象
    @SuppressWarnings("unchecked")
    private <T> T cglibProxy(Class<?> klass, Object object) {
        String className = klass.getName();
        FyProxy fyProxy = beanMap.get(className);
        if (fyProxy != null) {
            return (T) fyProxy.getProxy();
        }
        Proxyfactory proxyfactory = new Proxyfactory();
        T proxy = proxyfactory.getCglibProxy(klass, object);
        beanMap.put(className, proxyfactory.getFyProxy());
        return proxy;
    }

    public void addBeanName(String className, String beanName) throws BeanNameAlreadyExistException {
        String orgClassName = beanNameMap.get(className);
        if (orgClassName != null) {
            throw new BeanNameAlreadyExistException("Bean名称(" + beanName + ")重复！");
        }
        beanNameMap.put(className, beanName);
    }



    public FyProxy getFyProxy(Class<?> klass){
        return getFyProxy(klass.getName());
    }

    public FyProxy getFyProxy(String className){
       return beanMap.get(className);
    }

}
