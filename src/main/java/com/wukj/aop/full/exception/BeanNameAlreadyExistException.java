package com.wukj.aop.full.exception;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 上午 11:17
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 上午 11:17
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class BeanNameAlreadyExistException extends Exception {

    private static final long serialVersionUID = 1L;

    public BeanNameAlreadyExistException(String message) {
        super(message);
    }

}
