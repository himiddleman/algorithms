package com.leetcode.sort.simple;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/12/21
 * 直接插入排序
 **/
public class StraightInsertionSort {
    public static void main(String[] args) {
        StraightInsertionSort straightInsertionSort = new StraightInsertionSort();
        int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20, 3, 1, 6};
        straightInsertionSort.straightInsertionSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    private void straightInsertionSort(int[] a) {
        int i, j, temp;
        for (i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                temp = a[i];
                for (j = i - 1; (j >= 0) && (a[j] > temp); j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;
            }
        }
    }
}
