package com.leetcode.array.middle;

/**
 * author: tanguang
 * data: 2020/11/18
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1:
 * <p>
 * 1 1
 * 1 1
 * 1 1
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 **/
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        //思路：动态规划，创建一个数组dp，表示到达该位置的可能路经数
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        //第一行元素的路径数
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        //第一列元素的路径数
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }

        //其他位置的路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }

        }
        return dp[m - 1][n - 1];
    }
}
