package com.leetcode.array;

/**
 * author: tanguang
 * data: 2020/11/11
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 **/
public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = {3, 5, 7, 9, 10};
        System.out.println(searchInsert.searchInsert(nums, 8));
    }

//    public int searchInsert(int[] nums, int target) {
//        if(nums.length == 1) {
//            if(target > nums[0]) {
//                return 1;
//            }else {
//                return 0;
//            }
//        }
//
//        //插值查找 慎用
//        int high = nums.length - 1;
//        int low = 0;
//        while (low < high) {
//            int middle = low + (high - low) * (target - nums[low]) / (nums[high] - nums[low]);
//            if(middle < 0) {
//                return 0;
//            }
//            if (target < nums[middle]) {
//                high = middle - 1;
//            } else if (target > nums[middle]) {
//                low = middle + 1;
//            } else {
//                return middle;
//            }
//        }
//        return low;
//    }

    public int searchInsert(int[] nums, int target) {
        //二分法
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target < nums[middle]) {
                high = middle - 1;
            } else if (target > nums[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return low;
    }

//    public int searchInsert(int[] nums, int target) {
//        int index = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                index = i;
//                break;
//            }
//        }
//
//        if (index == -1) {
//            //1,3,5,6   7
//            //1,3      0
//            //1, 2, 4, 6, 7     5
//            //思路：数组中未找到指定值 二分法查找插入
//            int middle = (nums.length) / 2;
//            while (true) {
//                if (target < nums[middle]) {
//                    middle = middle / 2;
//                    if (target > nums[middle]) {
//                        return middle + 1;
//                    }
//                    if (middle == 0) {
//                        break;
//                    }
//                } else {
//                    middle = (middle + nums.length) / 2;
//                    if (target < nums[middle]) {
//                        return middle;
//                    }
//                    if (middle == nums.length - 1) {
//                        break;
//                    }
//                }
//            }
//
//            if (nums[middle] > target) {
//                return middle;
//            } else {
//                return middle + 1;
//            }
//        } else {
//            return index;
//        }
//    }
}
