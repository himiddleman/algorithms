package com.leetcode.array.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: tanguang
 * data: 2020/11/17
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 **/
public class SearchRange {
    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        Arrays.stream(searchRange.searchRange(nums, 8)).forEach(System.out::print);
    }

    public int[] searchRange(int[] nums, int target) {
        //思路：将所有匹配的索引值存储起来，取最前和最后索引值
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indexList.add(i);
            }
        }

        if (indexList.size() == 1) {
            return new int[]{indexList.get(0), indexList.get(0)};
        } else if (indexList.size() >= 2) {
            return new int[]{indexList.get(0), indexList.get(indexList.size() - 1)};
        }

        return new int[]{-1, -1};
    }
}
