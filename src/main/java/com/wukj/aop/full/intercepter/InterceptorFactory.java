package com.wukj.aop.full.intercepter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 7:01
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 7:01
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class InterceptorFactory {

    private static final Map<InterceptorTargetDefination, List<InterceptorMethodDefination>> beforeMap;
    private static final Map<InterceptorTargetDefination, List<InterceptorMethodDefination>> afterMap;
    private static final Map<InterceptorTargetDefination, List<InterceptorMethodDefination>> exceptionMap;

    static {
        beforeMap = new HashMap<>();
        afterMap = new HashMap<>();
        exceptionMap = new HashMap<>();
    }

    public static void addBeforeInterceptor(InterceptorTargetDefination target,
                                            InterceptorMethodDefination interceptor) {
        addInterceptor(beforeMap, target, interceptor);
    }

    public static void addAfterInterceptor(InterceptorTargetDefination target,
                                            InterceptorMethodDefination interceptor) {
        addInterceptor(beforeMap, target, interceptor);
    }
    public static void addExceptionInterceptor(InterceptorTargetDefination target,
                                            InterceptorMethodDefination interceptor) {
        addInterceptor(beforeMap, target, interceptor);
    }

    private static void addInterceptor(Map<InterceptorTargetDefination, List<InterceptorMethodDefination>> map,
                                       InterceptorTargetDefination target,
                                       InterceptorMethodDefination interceptor) {
        List<InterceptorMethodDefination> interceptorList = map.get(target);

        if (interceptorList == null) {
            synchronized (InterceptorFactory.class) {
                if (interceptorList == null) {
                    interceptorList = new ArrayList<>();
                    map.put(target, interceptorList);
                }
            }
        }
        interceptorList.add(interceptor);
    }

    // 这是添加拦截器的方法：这里我给出添加前置拦截器的方法，后置和异常同理
    // 通过被拦截目标从Map中获得其拦截器链，给拦截器链添加拦截器

    // 注意！这里为了安全添加了锁，来保证每个目标的拦截器链只有一个


    public static List<InterceptorMethodDefination> getBeforeInterceptorList(
            InterceptorTargetDefination target) {
        return beforeMap.get(target);
    }


    public static Map<InterceptorTargetDefination, List<InterceptorMethodDefination>> getBeforeMap() {
        return beforeMap;
    }

    public static Map<InterceptorTargetDefination, List<InterceptorMethodDefination>> getAfterMap() {
        return afterMap;
    }

    public static Map<InterceptorTargetDefination, List<InterceptorMethodDefination>> getExceptionMap() {
        return exceptionMap;
    }
}
