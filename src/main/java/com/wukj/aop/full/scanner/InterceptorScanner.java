package com.wukj.aop.full.scanner;

import com.wukj.aop.full.annotation.After;
import com.wukj.aop.full.annotation.Aspect;
import com.wukj.aop.full.annotation.Before;
import com.wukj.aop.full.annotation.ThrowException;
import com.wukj.aop.full.exception.ExceptionInterceptorReturnTypeNotVoid;
import com.wukj.aop.full.exception.WrongOfAfterInterceptorReturnType;
import com.wukj.aop.full.exception.WrongOfBeforeInterceptorReturnType;
import com.wukj.aop.full.exception.WrongOfExceptionInterceptorReturnType;
import com.wukj.aop.full.intercepter.InterceptorFactory;
import com.wukj.aop.full.intercepter.InterceptorMethodDefination;
import com.wukj.aop.full.intercepter.InterceptorTargetDefination;

import java.lang.reflect.Method;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:24
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:24
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class InterceptorScanner {
    public static void scanInterceptor(String packageName) {
        new PackageScanner() {
            @Override
            public void dealClass(Class<?> klass) {
                if (!klass.isAnnotationPresent(Aspect.class)) {
                    return;
                }
                try {
                    Object object = klass.newInstance();
                    Method[] methods = klass.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Before.class)) {
                            Before before = method.getAnnotation(Before.class);
                            dealBeforeInterceptor(klass, object, method, before);
                        } else if (method.isAnnotationPresent(After.class)) {
                            After after = method.getAnnotation(After.class);
                            dealAfterInterceptor(klass, object, method, after);
                        } else if (method.isAnnotationPresent(ThrowException.class)) {
                            ThrowException throwException = method.getAnnotation(ThrowException.class);
                            dealExceptionInterceptor(klass, object, method, throwException);
                        }
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.packageScanner(packageName);
    }
    private static void dealBeforeInterceptor(Class<?> klass, Object object, Method method, Before before)
            throws Exception {
        Class<?> returnType = method.getReturnType();
        if (!returnType.equals(boolean.class)) {
            throw new WrongOfBeforeInterceptorReturnType("前置拦截器(" + method + ")返回值只能是boolean类型");
        }
        Class<?> targetClass = before.klass();

        String targetMethodStr = before.method();
        if (targetMethodStr.equals("*")) {
            Method[] methods = targetClass.getDeclaredMethods();
            for (Method targetMethod : methods) {
                InterceptorTargetDefination target = new InterceptorTargetDefination(targetClass, targetMethod);
                InterceptorMethodDefination interceptor = new InterceptorMethodDefination(klass, method, object);
                InterceptorFactory.addBeforeInterceptor(target, interceptor);
            }
        } else {
            Method targetMethod = targetClass.getDeclaredMethod(before.method(), method.getParameterTypes());
            InterceptorTargetDefination target = new InterceptorTargetDefination(before.klass(), targetMethod);
            InterceptorMethodDefination interceptor = new InterceptorMethodDefination(klass, method, object);
            InterceptorFactory.addBeforeInterceptor(target, interceptor);
        }
    }


    private static void dealAfterInterceptor(Class<?> klass, Object object, Method method, After after)
            throws Exception {
        Class<?> returnType = method.getReturnType();
        Class<?> targetClass = after.klass();
        String targetMethodStr = after.method();
        Method targetMethod = targetClass.getDeclaredMethod(targetMethodStr, after.parameterTypes());
        Class<?> targetReturntype = targetMethod.getReturnType();
        if (!returnType.equals(targetReturntype)) {
            throw new WrongOfAfterInterceptorReturnType("后置拦截器(" + method + ")返回值不是" + targetReturntype);
        }

        if (targetMethodStr.equals("*")) {
            Method[] methods = targetClass.getDeclaredMethods();
            for (Method targetAllMethod : methods) {
                InterceptorTargetDefination target = new InterceptorTargetDefination(targetClass, targetAllMethod);
                InterceptorMethodDefination interceptor = new InterceptorMethodDefination(klass, method, object);
                InterceptorFactory.addAfterInterceptor(target, interceptor);
            }
        } else {
            InterceptorTargetDefination target = new InterceptorTargetDefination(targetClass, targetMethod);
            InterceptorMethodDefination interceptor = new InterceptorMethodDefination(klass, method, object);
            InterceptorFactory.addAfterInterceptor(target, interceptor);
        }
    }

    private static void dealExceptionInterceptor(Class<?> klass, Object object, Method method, ThrowException throwException)
            throws Exception {
        Class<?> returnType = method.getReturnType();
        if (!returnType.equals(void.class)) {
            throw new ExceptionInterceptorReturnTypeNotVoid("异常拦截器(" + method + ")返回值不是void类型");
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1 || parameterTypes[0].equals(Throwable.class)) {
            throw new WrongOfExceptionInterceptorReturnType("异常拦截器(" + method + ")参数类型必须是Throwable");
        }
        Class<?> targetClass = throwException.klass();
        String targetMethodStr = throwException.method();
        if (targetMethodStr.equals("*")) {
            Method[] methods = targetClass.getDeclaredMethods();
            for (Method targetMethod : methods) {
                InterceptorTargetDefination target = new InterceptorTargetDefination(targetClass, targetMethod);
                InterceptorMethodDefination interceptor = new InterceptorMethodDefination(klass, method, object);
                InterceptorFactory.addExceptionInterceptor(target, interceptor);
            }
        } else {
            Method targetMethod = targetClass.getDeclaredMethod(targetMethodStr, method.getParameterTypes());
            InterceptorTargetDefination target = new InterceptorTargetDefination(throwException.klass(), targetMethod);
            InterceptorMethodDefination interceptor = new InterceptorMethodDefination(klass, method, object);
            InterceptorFactory.addExceptionInterceptor(target, interceptor);
        }
    }

}
