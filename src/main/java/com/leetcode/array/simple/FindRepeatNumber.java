package com.leetcode.array.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * author: tanguang
 * data: 2020/11/16
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 **/
public class FindRepeatNumber {
    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int[] nums = {0, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(findRepeatNumber.findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        //思路：使用哈希表找到重复元素 O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}
