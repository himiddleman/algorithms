package com.leetcode.array.hard;

/**
 * author: tanguang
 * data: 2020/11/20
 * #84
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 **/
public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int mid = 0; mid < n; ++mid) {
            // 枚举高
            int height = heights[mid];
            int left = mid, right = mid;
            // 确定左右边界
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < n && heights[right + 1] >= height) {
                ++right;
            }
            // 计算面积
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }

//    public int largestRectangleArea(int[] heights) {
//        //思路：暴力解法 O(n^2)
//        int max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int minHeight = Integer.MAX_VALUE;
//            for (int j = i; j < heights.length; j++) {
//                minHeight = Math.min(minHeight, heights[j]);
//                max = Math.max(minHeight * (j - i + 1), max);
//            }
//
//        }
//        return max;
//    }
}
