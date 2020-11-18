package com.leetcode.array.middle;

/**
 * author: tanguang
 * data: 2020/11/18
 * 给你一个整数数组 nums ，和一个整数 target 。
 * <p>
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 **/
public class SearchRotateArray {
    public static void main(String[] args) {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchRotateArray.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        //居然还通过了。。。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
