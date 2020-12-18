package com.leetcode.stack.simple;

import java.util.Stack;

/**
 * author: tanguang
 * data: 2020/12/18
 * #1544. 整理字符串
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * <p>
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 **/
public class MakeGood {
    public static void main(String[] args) {
        MakeGood makeGood = new MakeGood();
        System.out.println(makeGood.makeGood("leEeetcode"));
        System.out.println(makeGood.makeGood("abBAcC"));
    }

    public String makeGood(String s) {
        //相邻的字符相同则删除
        //相邻字符的ascii码相差为32
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        Stack stack = new Stack();
        for (char c : chars) {
            if (!stack.empty()) {
                if ((char) stack.peek() - c == 32 || c - (char) stack.peek() == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
