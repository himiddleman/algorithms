package com.leetcode.stack.simple;

import java.util.Stack;

/**
 * author: tanguang
 * data: 2020/12/18
 * 1598. 文件夹操作日志搜集器
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * <p>
 * 下面给出对变更操作的说明：
 * <p>
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 * <p>
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * <p>
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数
 **/
public class MinOperations {
    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        String[] array = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations.minOperations(array));
    }

    public int minOperations(String[] logs) {
        //求栈的大小
        Stack stack = new Stack();
        for (String str : logs) {
            if ("./".equals(str)) {
                //donothing
            } else if ("../".equals(str)) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        return stack.size();
    }
}
