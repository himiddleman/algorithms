package com.leetcode.array.middle;

/**
 * author: tanguang
 * data: 2020/11/19
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 **/
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        findNumberIn2DArray.findNumberIn2DArray(matrix, 1);
    }

//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        //思路1：迭代 O(n^2)
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        ////思路2：线性查找O(m+n) 从右上角开始遍历
        int row = 0;
        int col = matrix[0].length - 1;


        while (row < matrix.length || col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
