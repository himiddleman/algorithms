package com.leetcode.sort.simple;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/12/21
 * 冒泡算法
 **/
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        bubbleSort.bubbleSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    //初级版
//    private void bubbleSort(int[] a) {
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                if (a[i] > a[j]) {
//                    swap(a, i, j);
//                }
//            }
//        }
//    }

    //正宗冒泡
//    private void bubbleSort(int[] a) {
//        for (int i = 0; i < a.length; i++) {
//            for (int j = a.length - 1; j > i; j--) {
//                if (a[j] < a[j - 1]) {
//                    swap(a, j, j - 1);
//                }
//            }
//        }
//    }

    //优化，如果是部分有序的，减少判断次数
    private void bubbleSort(int[] a) {
        boolean flag = true;

        for (int i = 0; i < a.length && flag; i++) {
            flag = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                    flag = true;
                }
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
