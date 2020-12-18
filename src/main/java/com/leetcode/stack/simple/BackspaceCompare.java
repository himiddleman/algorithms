package com.leetcode.stack.simple;

import java.util.Stack;

/**
 * author: tanguang
 * data: 2020/12/17
 * #844
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
 * # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 **/
public class BackspaceCompare {
    public static void main(String[] args) {
        BackspaceCompare compare = new BackspaceCompare();
        compare.backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public boolean backspaceCompare(String S, String T) {
        Stack first = getStack(S);
        Stack second = getStack(T);
        if (first.size() != second.size()) {
            return false;
        }
        while (!first.empty() && !second.empty()) {
            if (!first.pop().equals(second.pop())) {
                return false;
            }
        }

        return true;
    }

    private Stack getStack(String s) {
        Stack stack = new Stack();
        String[] array = s.split("");
        for (String str : array) {
            if (str.equals("#")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        return stack;
    }

}
