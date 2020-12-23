package com.leetcode.sort.simple;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/12/21
 * 快速排序
 **/
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        quickSort.quickSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    private void quickSort(int[] a) {
        qSort(a, 0, a.length - 1);
    }

    private void qSort(int[] a, int low, int high) {
        int pivot;
        if (low < high) {
            //选取枢轴，左边的元素均小于枢轴，右边的元素均大于枢轴
            pivot = getPivot(a, low, high);
            //低子表快速排序
            qSort(a, low, pivot - 1);
            //高子表快速排序
            qSort(a, pivot + 1, high);
        }
    }

    private int getPivot(int[] a, int low, int high) {
        int pivotKey = a[low];
        while (low < high) {
            while (a[high] > pivotKey) {
                high--;
            }
            swap(a, low, high);

            while (a[low] < pivotKey) {
                low++;
            }
            swap(a, low, high);
        }

        return low;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
