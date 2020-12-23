package com.leetcode.sort.simple;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/12/21
 * 归并排序
 **/
public class MergingSort {
    public static void main(String[] args) {
        MergingSort mergingSort = new MergingSort();
        int[] a = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        mergingSort.mergingSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    private void mergingSort(int[] a) {
        mSort(a, a, 0, a.length - 1);
    }

    //将sa[s...t]数组归并排序为ta[s...t]数组
    private void mSort(int[] sa, int[] ta, int s, int t) {
        int[] ta2 = new int[sa.length];
        //m为序列的分割点
        int m;
        if (s == t) {
            ta[s] = sa[s];
        } else {
            //取中点位置
            m = (s + t) / 2;
            //将sa[s...m]归并排序为ta2[s...m]
            mSort(sa, ta2, s, m);
            //将sa[m+1...t]归并排序为ta2[m+1...t]
            mSort(sa, ta2, m + 1, t);
            //将ta2[s...m]和ta2[m+1...t]归并到ta[s...t]
            merge(ta2, ta, s, m, t);
        }
    }

    private void merge(int[] ta2, int[] ta, int s, int m, int t) {
        int i, j, k, l;
        for (i = s, j = m + 1, k = s; i <= m && j <= t; k++) {
            if (ta2[i] > ta2[j]) {
                ta[k] = ta2[j++];
            } else {
                ta[k] = ta2[i++];
            }
        }

        if (i > m) {
            //将ta2[m+1...t]中剩余元素复制到ta数组中
            for (l = 0; l <= t - j; l++) {
                ta[k + l] = ta2[j + l];
            }
        }

        if (j > t) {
            //将ta2[s...m]中剩余元素复制到ta数组中
            for (l = 0; l <= m - i; l++) {
                ta[k + l] = ta2[i + l];
            }
        }
    }
}
