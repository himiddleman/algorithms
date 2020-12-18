package com.leetcode.stack.simple;

import java.util.Stack;

/**
 * author: tanguang
 * data: 2020/12/17
 * #682. 棒球比赛
 * <p>
 * 你现在是一场采特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 **/
public class CalPoints {
    public int calPoints(String[] ops) {
        //+,D,C
        Stack stack = new Stack();
        for (String str : ops) {
            switch (str) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push((int) stack.peek() * 2);
                    break;
                case "+":
                    stack.push((int) stack.peek() + (int) stack.elementAt(stack.size() - 2));
                    break;
                default:
                    stack.push(Integer.valueOf(str));

            }
        }

        int count = 0;
        while (!stack.empty()) {
            count += (int) stack.pop();
        }
        return count;
    }
}
