package com.leetcode.stack.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * author: tanguang
 * data: 2020/12/29
 * #155
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 **/
public class MinStack {
    public List<Integer> first;
    //辅助栈，栈顶存储的是栈中的最小元素
    //每次添加元素都和最小元素比较，并插入最小元素
    public List<Integer> second;

    public MinStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    public void push(int x) {
        first.add(x);
        if (second.isEmpty()) {
            second.add(x);
        } else {
            second.add(second.get(second.size() - 1) > x ? x : second.get(second.size() - 1));
        }
    }

    public void pop() {
        first.remove(first.size() - 1);
        second.remove(second.size() - 1);
    }

    public int top() {
        return first.get(first.size() - 1);
    }

    public int getMin() {
        return second.get(second.size() - 1);
    }
}
