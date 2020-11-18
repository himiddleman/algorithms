package com.leetcode.array.hard;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/11/16
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 **/
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //思路：先合并有序数组，再查找中位数
        int[] merge = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            merge[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            merge[nums1.length + i] = nums2[i];
        }

        Arrays.sort(merge);

        int index = merge.length % 2;
        if (index == 0) {
            return Double.valueOf(merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2;
        } else {
            return Double.valueOf(merge[merge.length / 2]);
        }
    }
}
