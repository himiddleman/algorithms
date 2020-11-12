package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: tanguang
 * data: 2020/11/12
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 **/
public class YHTriangle {
    public static void main(String[] args) {
        YHTriangle yhTriangle = new YHTriangle();
        yhTriangle.generate(3).stream().forEach(System.out::println);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        //初始化集合
        List<Integer> first = Stream.of(1).collect(Collectors.toList());
        list.add(first);
        if (numRows == 1) {
            return list;
        }
        List<Integer> second = Stream.of(1, 1).collect(Collectors.toList());
        list.add(second);
        if (numRows == 2) {
            return list;
        }

        //思路：下一个数组的生成基于上一个数组
        for (int i = 2; i < numRows; i++) {
            List<Integer> source = list.get(i - 1);
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < source.size(); j++) {
                if (j - 1 < 0) {
                    subList.add(j, source.get(j));
                } else {
                    subList.add(j, source.get(j - 1) + source.get(j));
                }
            }
            subList.add(1);
            list.add(subList);
        }

        return list;
    }
}
