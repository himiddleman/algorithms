package com.leetcode.array;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/11/12
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 **/
public class MergeArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeArray mergeArray = new MergeArray();
        mergeArray.merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(System.out::println);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //思路：先合并，后排序
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        //对num1排序
        Arrays.sort(nums1);
    }
}
