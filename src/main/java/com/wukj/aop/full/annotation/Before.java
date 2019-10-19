package com.wukj.aop.full.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 6:52
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 6:52
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.前置拦截器方法
 * 2.参数需给出，该拦截器方法是作用于哪个类的哪个方法的
 * 3.method不填为*号表示 ：会给该类的所有方法增加该拦截器
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Before {
    Class<?> klass();

    String method() default "*";

}