package com.wukj.binary;

public class ByteUtils {

    public static void main(String[] args) {

        byte aa = 127;
        aa++;
        System.out.println(aa);

        // int n = 450;
        int n = 150;
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));
        System.out.println(n + "的十进制是:" + Integer.toString(n, 10));

        /**
         * 笔记内容为：
         * 【2进制】 转 【10进制】
         * 【2进制】 转 【08进制】
         * 【2进制】 转 【16进制】
         *
         * 【10进制】 转 【2进制】
         * 【08进制】 转 【2进制】
         * 【16进制】 转 【2进制】
         *
         *
         */

        // *********************************************【二进制】转【其他进制】************************************************
        // 二进制字符串
        // 十进制值：150
        // String s = "10010110";
        String s = Integer.toBinaryString(n);
        /**
         * 二进制转十进制：
         * 二进制位由左边到右边是从高位到地位递减，一个byte有8个bit组成。
         * 方法：把二进制数按权展开、相加即得十进制数。
         *
         * 计算二进制转十进制的方式为：
         * 10010110 = 10010110 = 0*2^0 + 1*2^1 + 1*2^2 + 0*2^3 + 1*2^4 + 0*2^5 + 0*2^6 + 1*2^7 = 0 + 2 + 4 + 0 + 16 + 0 + 0 + 128 = 150
         * 组成十进制数：150
         */
        System.out.println("二进制 " + s + " 转成十进制为：" + from2To10(s));
        /**
         * 二进制转八进制：2^3=8，所以3个为一组
         * 将二进制bit由低位向高位，按照3个bit为一组进行拆分，高位不足，进行补0
         * 方法：3位二进制数按权展开相加得到1位八进制数。（注意事项，3位二进制转成八进制是从右到左开始转换，不足时补0）。
         *
         * 计算：10010110 -> [十进制的150]
         * 10010110 = 10010110 = 010|010|110
         * 个位：第一组：110 = 0*2^0 + 1*2^1 + 1*2^2 = 0 + 2 + 4 = 6
         * 十位：第二组：010 = 0*2^0 + 1*2^1 + 0*2^2 = 0 + 2 + 0 = 2
         * 百位：第三组：010 = 0*2^0 + 1*2^1 + 0*2^2 = 0 + 2 + 0 = 2
         * 组成8进制数为：226
         *
         */
        System.out.println("二进制 " + s + " 转成八进制为：" +from2To8(s));
        /**
         * 二进制转十六进制：2^4=16，所以4个为一组
         * 将二进制bit由低位向高位，按照4个bit为一组进行拆分，高位不足，进行补0
         *   十进制：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
         * 十六进制：1 2 3 4 5 6 7 8 9  A  B  C  D  E  F
         * 方法：与二进制转八进制方法近似，八进制是取三合一，十六进制是取四合一。（注意事项，4位二进制转成十六进制是从右到左开始转换，不足时补0）
         *
         * 计算：10010110 -> [十进制的150]
         * 10010110 = 10010110 = 1001|0110
         * 第一位：第一组：0110 = 0*2^0 + 1*2^1 + 1*2^2 + 0*2^3 = 0 + 2 + 4 + 0 = 6
         * 第二位：第二组：1001 = 1*2^0 + 0*2^1 + 0*2^2 + 1*2^3 = 1 + 0 + 0 + 8 = 9
         * 组成16进制数为：96
         *
         * 计算：111000010 -> [十进制的450]
         * 111000010 = 000111000010 = 0001|1100|0010
         * 第一位：第一组：0010 = 0*2^0 + 1*2^1 + 0*2^2 + 0*2^3 = 0 + 2 + 0 + 0 = 2
         * 第二位：第二组：1100 = 0*2^0 + 0*2^1 + 1*2^2 + 1*2^3 = 0 + 0 + 4 + 8 = 12 -> C
         * 第三位：第三组：0001 = 1*2^0 + 0*2^1 + 0*2^2 + 0*2^3 = 1 + 0 + 0 + 0 = 1
         * 组成16进制数为：1C2
         *
         */
        System.out.println("二进制 " + s + " 转成十六进制为：" +from2To16(s));

        // *********************************************【其他进制】转【二进制】************************************************
        /**
         * 十进制转二进制：
         * 方法：十进制数除2取余法，即十进制数除2，余数为权位上的数，得到的商值继续除2，依此步骤继续向下运算直到商为0为止。
         *
         * 计算：十进制150 转 二进制数
         * 150 / 2 = 75 ~ 0
         *  75 / 2 = 37 ~ 1
         *  37 / 2 = 18 ~ 1
         *  18 / 2 =  9 ~ 0
         *   9 / 2 =  4 ~ 1
         *   4 / 2 =  2 ~ 0
         *   2 / 2 =  1 ~ 0
         *   1 / 2 =  0 ~ 1
         * 计算结果：
         */
        System.out.println("十进制 " + n + " 转成二进制为：" + Integer.toBinaryString(n));
        System.out.println("十进制 " + n + " 转成二进制为：" + from10To2(n));

        /**
         * 八进制转二进制：
         * 方法：八进制数通过除2取余法，得到二进制数，对每个八进制为3个二进制，不足时在最左边补零。
         *
         * 计算：十进制150=八进制226 转 二进制数
         * 2 -> = 2 / 2 = 1 ~ 0
         *      = 1 / 2 = 0 ~ 1
         *      = 10
         *      = 010
         * 2 -> = 2 / 2 = 1 ~ 0
         *      = 1 / 2 = 0 ~ 1
         *      = 10
         *      = 010
         * 6 -> = 6 / 2 = 3 ~ 0
         *      = 3 / 2 = 1 ~ 1
         *      = 1 / 2 = 0 ~ 1
         *      = 110
         * 计算结果：010010110 -> 10010110
         */
        System.out.println("八进制 " + Integer.toOctalString(n) + " 转成二进制为：" +from8To2(Integer.toOctalString(n)) );




        // Integer 中封装好了一个方法：
        // 能够直接计算二进制中的1的个数，在竞赛中很有用.
        // 下文是150的二进制，所以150的二进制中有 3 个'1',
        System.out.println(n + "的二进制数有：" +Integer.bitCount(n) + "个“1”");

        // 指定指定补零，%08d，标识在10前面补6个0，凑齐8位
        System.out.println(String.format("%08d", 10));
        System.out.println(String.format("%04d", 10));

    }


    /**
     * 十进制 转 二进制：调用JDK的函数
     * @param number    十进制数字
     * @return  返回二进制数
     */
    private static String from10To2(int number){
        if (number < 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int quo = number / 2;
        int rem = number % 2;
        builder.insert(0,rem);
        while (quo != 0){
            rem = quo % 2;
            quo = quo / 2;
            builder.insert(0,rem);
        }
        return builder.toString();
    }

    /**
     * 八进制 转 二进制：调用JDK的函数
     * @param number    八进制数
     * @return  返回二进制数
     */
    private static String from8To2(String number){
        StringBuilder builder = new StringBuilder();
        char[] letters = number.toCharArray();
        int bit;
        int rem;
        StringBuffer buffer;
        for (int i = letters.length-1; i >= 0; i--) {
            buffer = new StringBuffer();
            bit = Integer.parseInt(String.valueOf(letters[i]));
            System.out.println("八进制-------------------："+ bit);
            // 八进制中最大为7，循环次数最大为3
            for (int j = 0; j < 3; j++) {
                /**
                 * 7/2=3~1
                 * 3/2=1~1
                 * 1/2=0~1
                 */
                bit = bit / 2;
                rem = bit % 2;
                System.out.println("八进制--bit：" + bit);
                if(bit == 0){
                    // 三个bit为一组，不够补0
                    buffer.insert(0,0);
                } else {
                    buffer.append(rem);
                }
            }
            System.out.println("八进制-----buffer："+ buffer.toString());
//            builder.insert(0,buffer.toString());
        }
        return builder.toString();
    }

    /**
     * 二进制 转 十进制：调用JDK的函数
     * @param binary    二进制字符串
     * @return  返回十进制数
     */
    private static int from2To10(String binary){
        // 第一个参数：二进制字符串
        // 第二个参数：进制数，参数一是二进制字符串，此处填写：2
        return Integer.parseInt(binary,2);
    }

    /**
     * 二进制 转 八进制
     * @param binary    二进制字符串
     * @return  返回十进制数
     */
    private static int from2To8(String binary){
        // System.out.println("---------二进制 转 八进制----start---");
        StringBuilder buffer = new StringBuilder(binary);
        // 组长度
        int gLen = 3;
        int bLen = binary.length();
        int len = bLen / gLen;
        int yu = bLen % gLen;
        if(yu != 0){
            len++;
            for (int i = 0; i <(gLen-yu); i++) {
                // 二进制字符串高位补0
                buffer.insert(0,"0");
            }
        }
        // System.out.println("二进制字符串高位补位：" + buffer.toString());
        String[] group = new String[len];
        int start = 0;
        StringBuilder numBuffer = new StringBuilder();
        for (int i = 0; i < len; i++) {
            group[i] = buffer.substring(start,start + gLen);
            // System.out.println("3个bit为一组：" + group[i]);
            int unit = 0;
            for (int j = 0; j < gLen; j++) {
                int bit = Integer.parseInt(String.valueOf(group[i].charAt(j)));
                unit += bit * Math.pow(2,(gLen-1)-j);
            }
            numBuffer.append(unit);
            start += gLen;
        }
        // System.out.println("---------二进制 转 八进制------end---");
        return Integer.parseInt(numBuffer.toString());
    }


    /**
     * 二进制 转 十六进制数
     * @param binary    二进制字符串
     * @return  返回十六进制数
     */
    private static String from2To16(String binary){
        // System.out.println("---------二进制 转 十六进制----start---");
        String letter = "0123456789ABCDEF";
        StringBuilder buffer = new StringBuilder(binary);
        // 组长度
        int gLen = 4;
        int bLen = binary.length();
        int len = bLen / gLen;
        int yu = bLen % gLen;
        if(yu != 0){
            len++;
            for (int i = 0; i <(gLen-yu); i++) {
                // 二进制字符串高位补0
                buffer.insert(0,"0");
            }
        }
        // System.out.println("二进制字符串高位补位：" + buffer.toString());
        String[] group = new String[len];
        int start = 0;
        StringBuilder numBuffer = new StringBuilder();
        for (int i = 0; i < len; i++) {
            group[i] = buffer.substring(start,start + gLen);
            // System.out.println("4个bit为一组：" + group[i]);
            int unit = 0;
            for (int j = 0; j < gLen; j++) {
                int bit = Integer.parseInt(String.valueOf(group[i].charAt(j)));
                unit += bit * Math.pow(2,(gLen-1)-j);
            }
            numBuffer.append(letter.charAt(unit));
            start += gLen;
        }
        // System.out.println("---------二进制 转 十六进制------end---");
        return numBuffer.toString();
    }

}
