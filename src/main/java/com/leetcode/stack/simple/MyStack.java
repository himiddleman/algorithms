package com.leetcode.stack.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * author: tanguang
 * data: 2020/12/29
 * #225
 * 用队列实现栈
 **/
public class MyStack {
    public List<Integer> linkedList;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        linkedList = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        linkedList.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return linkedList.remove(linkedList.size() - 1);
    }

    /**
     * Get the top element.
     */
    public int top() {
        return linkedList.get(linkedList.size() - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return linkedList.size() == 0;
    }
}
