package com.wukj.tools.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目名称：Java-Grammar
 * 创建时间：2018/12/24 0024 下午 2:40
 * 作者：Jonyker
 * 博客：http://www.udevtech.com
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/12/24 0024 下午 2:40
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.
 * 2.
 * 3.
 */
public class HORegular {
    public static void main(String[] args) {

        // 港澳台正则表达式
        // String regxStr = "^(830000|820000|810000)\\d{4}(0[0-9]||(10|11||12))(0[0-9]|[12]\\d|3[01])\\d{4}$";
        // 检验密码复杂度，需满足，数字，字母大小写
        String regxStr = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{6,20}$";
        Pattern pattern = Pattern.compile(regxStr);

        String input = "123456Ss";
        Matcher m = pattern.matcher(input);
        if (m.matches()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

}
