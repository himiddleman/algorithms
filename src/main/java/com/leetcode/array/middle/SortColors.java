package com.leetcode.array.middle;

import java.util.Arrays;

/**
 * author: tanguang
 * data: 2020/11/19
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 **/
public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }


    public void sortColors(int[] nums) {
        //思路：数组排序
//        Arrays.sort(nums);

        //冒泡排序
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
