package com.wukj.aop.full.scanner;

import com.wukj.aop.full.annotation.Autowired;
import com.wukj.aop.full.annotation.Bean;
import com.wukj.aop.full.annotation.Component;
import com.wukj.aop.full.bean.BeanMethodDefination;
import com.wukj.aop.full.proxy.FyProxy;
import com.wukj.aop.full.proxy.ProxyBeanFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:31
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:31
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public abstract class AnnotationScanner {

    public AnnotationScanner() {
    }

    public abstract void dealClass(Class<?> klass);

    // 这个是增加类名和用户注解中自定义类名的对应关系
    // beanNameMap是类名和注解自定义名字的对应（因为考虑到使用者会在注解中给类名别的“称谓”）
    // 给定包路径，扫描此包
    public static void scanPackage(String packageName) throws Exception {
        ProxyBeanFactory proxyBeanFactory = new ProxyBeanFactory();

        // 该list的作用？别急，看下面
        List<BeanMethodDefination> methodList = new ArrayList<>();

        new PackageScanner() {
            // 这里是个内部类，看过我包扫描代码的人应该了解
            // 这里在循环中
            @Override
            public void dealClass(Class<?> klass) {

                // 扫描出带有Component的类
                if (!klass.isAnnotationPresent(Component.class)) {
                    return;
                }
                Component component = klass.getAnnotation(Component.class);
                String name = component.name();

                try {
                    // 创建该类的代理
                    proxyBeanFactory.creatCglibProxy(klass);

                    creatBean(null, klass, name, proxyBeanFactory);

                    // 执行该类中所有带有Bean注解的方法
                    // 并执行
                    // 执行时肯定要原类的对象
                    // 这就是我在FyProxy中存原类对象的原因
                    FyProxy fyProxy = proxyBeanFactory.getFyProxy(klass);
                    Object object = fyProxy.getObject();

                    Method[] methods = klass.getDeclaredMethods();
                    for (Method method : methods) {
                        if (!method.isAnnotationPresent(Bean.class)) {
                            continue;
                        }
                        // 执行方法
                        invokeBeanMethod(object, method, proxyBeanFactory, methodList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.packageScanner(packageName);


        // 在所有类扫描完毕后
        // 这里遍历了那个list
        // 然后执行list中的method
        // 这个list里面其实是带有参数的方法
        // 为了解决带参方法参数需要对象而该对象所属类没被扫描到的问题
        for (BeanMethodDefination beanMethod : methodList) {
            Class<?> returnType = beanMethod.getReturnType();
            Parameter[] paras = beanMethod.getParameters();
            Object object = beanMethod.getObject();
            String beanName = beanMethod.getBeanName();
            Method method = beanMethod.getMethod();

            // 执行多参方法
            Object result = invokeMuliParaMethod(object, method, paras, proxyBeanFactory);
            // 创建bean
            creatBean(result, returnType, beanName, proxyBeanFactory);
        }
    }

    private static void invokeBeanMethod(Object object, Method method,
                                         ProxyBeanFactory proxyBeanFactory, List<BeanMethodDefination> methodList)
            throws Exception {
        // 获得方法返回值类型
        Class<?> returnType = method.getReturnType();

        // 需判断，若该方法返回void，无须执行，咱这是要得到Bean！
        if (method.getReturnType().equals(void.class)) {
            return;
        }

        // 下面判断方法参数个数，有参应在无参方法全部处理完再处理
        // 所以用到了list
        Bean bean = method.getAnnotation(Bean.class);
        String beanName = bean.name();
        Parameter[] parameters = method.getParameters();
        int count = parameters.length;
        if (count <= 0) {
            // 无参方法直接执行并创建bean
            Object result = method.invoke(object);
            creatBean(result, returnType, beanName, proxyBeanFactory);
        } else {
            methodList.add(new BeanMethodDefination(method, object, returnType, parameters, beanName));
        }
    }


    private static Object invokeMuliParaMethod(Object object, Method method,
                                               Parameter[] parameters, ProxyBeanFactory proxyBeanFactory) throws Exception {
        int count = parameters.length;
        Object paras[] = new Object[count];
        for (int index = 0; index < count; index++) {
            Parameter parameter = parameters[index];
            String className = parameter.getType().getName();
            FyProxy fyProxy = proxyBeanFactory.getFyProxy(className);
            Object beanObject = fyProxy.getObject();
            if (beanObject != null) {
                paras[index] = parameter;
            }
        }
        return method.invoke(object, paras);
    }

    private static void creatBean(Object result, Class<?> klass, String beanName, ProxyBeanFactory proxyBeanFactory)
            throws Exception {
        if (result != null) {
            proxyBeanFactory.creatCglibProxy(result);
        } else {
            proxyBeanFactory.creatCglibProxy(klass);
        }
        if (beanName.length() > 0) {
            proxyBeanFactory.addBeanName(klass.getName(), beanName);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<?> klass) {
        ProxyBeanFactory proxyBeanFactory = new ProxyBeanFactory();
        FyProxy fyProxy = proxyBeanFactory.getFyProxy(klass);

        if (!fyProxy.isInjection()) {
            injectBean(proxyBeanFactory, klass, fyProxy.getObject());
        }

        return (T) fyProxy.getProxy();
    }

    public static void injectBean(ProxyBeanFactory proxyBeanFactory, Class<?> klass,
                                  Object object) {

        // 获得该klass所需要的所有成员
        // 遍历
        // 判断其是否有Autowired注解
        // 有则在ProxyBeanFactory中找到代理，将其设置为已注入（为解决循环依赖问题）
        // 判断该成员的类是否也已经注入
        // 若没有
        // 则递归
        // 最后将对象赋给成员  完成注入！！
        Field[] fields = klass.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Autowired.class)) {
                continue;
            }
            FyProxy fyProxy = proxyBeanFactory.getFyProxy(klass);
            fyProxy.setInjection(true);

            Class<?> beanType = field.getType();

            FyProxy fieldProxy = proxyBeanFactory.getFyProxy(beanType);
            if (!fieldProxy.isInjection()) {
                injectBean(proxyBeanFactory, beanType, fieldProxy.getObject());
            }
            field.setAccessible(true);
            try {
                field.set(object, fieldProxy.getObject());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
