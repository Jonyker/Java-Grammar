package com.wukj.delegate.statics;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/13 0013 下午 6:06
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/13 0013 下午 6:06
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }



}
