package com.leetcode.array.simple;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/11/13
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 **/
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void moveZeroes(int[] nums) {
        //int数组默认值为0，只需要删除0元素就行
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0 && i != nums.length - 1) {
                deleteElementAtIndexOf(nums, i);
                i--;
                length--;
            }
        }
    }

    private void deleteElementAtIndexOf(int[] nums, int j) {
        for (int i = j; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
            nums[i + 1] = 0;
        }
    }
}
