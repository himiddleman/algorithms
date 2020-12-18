package com.leetcode.stack.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * author: tanguang
 * data: 2020/12/18
 * #1441. 用栈操作构建数组
 * <p>
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。
 * <p>
 * 题目数据保证答案是唯一的。
 **/
public class BuildArray {
    public static void main(String[] args) {
        BuildArray buildArray = new BuildArray();
        int[] target = {2, 3, 4};
        buildArray.buildArray(target, 4).stream().forEach(System.out::print);
    }

    public List<String> buildArray(int[] target, int n) {
        //["Push","Pop","Push","Push","Push"]
        List<String> list = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == count) {
                list.add("Push");
                count++;
            } else {
                while (count < target[i]) {
                    list.add("Push");
                    list.add("Pop");
                    count++;
                }
                list.add("Push");
                count++;
            }
        }
        return list;
    }
}
