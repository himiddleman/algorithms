package com.leetcode.sort.simple;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/12/21
 * 简单选择排序
 **/
public class SimpleSelectionSort {

    public static void main(String[] args) {
        SimpleSelectionSort simpleSelectionSort = new SimpleSelectionSort();
        int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        simpleSelectionSort.simpleSelectionSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    private void simpleSelectionSort(int[] a) {
        //min为最小值所在下标位置
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a, i, min);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
