package com.wukj.algorithm.sort;

/*
 * 项目名称：Java-Algorithm
 * 创建时间：Feb 12, 20199:17:52 AM
 * 作者：Jonyker
 * 简书：https://www.jianshu.com/u/07642698e7f4
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：Feb 12, 20199:17:52 AM
 * 备注：
 * 版本：V.1.0
 * 描述：
 * 1.冒泡排序
 * 2.
 * 3.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] x = { 6, 2, 4 };
        bubble_sort(x);
        System.out.println("----------最后顺序：");
        for (int i : x) {
            System.out.println("x:" + i);
        }

    }

    static void bubble_sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = i; j < unsorted.length; j++) {
                if (unsorted[i] < unsorted[j]) {

                    int tempi = unsorted[i];
                    int tempj = unsorted[j];
                    unsorted[i] = tempj;
                    unsorted[j] = tempi;

                }
                System.out.println("----------内层此时顺序：" + "i=" + i + ",j=" + j);
                for (int n : unsorted) {
                    System.out.println("n:" + n);
                }
            }
            System.out.println("----------外层此时顺序：");
            for (int w : unsorted) {
                System.out.println("w:" + w);
            }
        }
    }

}
