package com.leetcode.array.simple;


import java.util.HashMap;
import java.util.Map;

/**
 * author: tanguang
 * data: 2020/11/13
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 **/
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement.majorityElement(nums));
    }


    public int majorityElement(int[] nums) {
        //思路：使用哈希表
        Map<Integer, Integer> map = new HashMap<>();
        //key为数组元素，value为出现的次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

//    public int majorityElement(int[] nums) {
//        //时间复杂O(n^2)，效率低
//        //思路：计算每个元素在数组中出现的次数，返回出现次数超过一半的元素
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    count++;
//                }
//                if (count > nums.length / 2) {
//                    return nums[i];
//                }
//            }
//        }
//        return -1;
//    }
}
