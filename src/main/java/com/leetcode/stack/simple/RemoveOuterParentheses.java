package com.leetcode.stack.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: tanguang
 * data: 2020/12/29
 * #1021
 * <p>
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 **/
public class RemoveOuterParentheses {
    public static void main(String[] args) {
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        System.out.println(removeOuterParentheses.removeOuterParentheses("()()"));
    }

    public String removeOuterParentheses(String S) {
        //将S进行分割：S = p1+p2+...+pn
        List<String> list = new ArrayList<>();
        final char left = '(';
        final char right = ')';
        Map<Character, Integer> map = new HashMap<>();
        map.put(left, 0);
        map.put(right, 0);
        char[] chars = S.toCharArray();
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.get(left) != 0 && map.get(left) == map.get(right)) {
                list.add(S.substring(pre + 1, i - 1));
                pre = i;
                map.clear();
                map.put(left, 0);
                map.put(right, 0);
            }
            if (left == (chars[i])) {
                map.put(left, map.get(left) + 1);
            } else {
                map.put(right, map.get(right) + 1);
            }


        }

        list.add(S.substring(pre + 1, S.length() - 1));

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    public String removeOuterParentheses1(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }
}
