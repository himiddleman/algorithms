package com.leetcode.array.simple;

import java.util.List;

/**
 * author: tanguang
 * data: 2020/11/12
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 **/
public class YHTriangleV2 {
    public static void main(String[] args) {
        YHTriangleV2 yhTriangleV2 = new YHTriangleV2();
        System.out.println(yhTriangleV2.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        YHTriangle yhTriangle = new YHTriangle();
        return yhTriangle.generate(rowIndex + 1).get(rowIndex);
    }
}
