package com.leetcode.array.middle;

/**
 * author: tanguang
 * data: 2020/11/17
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 **/
public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        /**
         * 1,2,3
         * 4,5,6
         */
        System.out.println(minPathSum.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        //思路：动态规划，创建dp[][]，数组大小等于grid，记录每个位置的最小路径和
        //每个位置的最小路径和 和 相邻位置有关
        /**
         * 1 3 1
         * 1 5 1
         * 4 2 1
         */
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        //计算第一行的最小路径值
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //计算第一列的最小路径值
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //其他位置的最小路径值
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
