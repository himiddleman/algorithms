package com.leetcode.stack.simple;

import java.util.Stack;

/**
 * author: tanguang
 * data: 2020/12/29
 * #232
 * 请你仅使用两个栈实现先入先出队列。
 * 队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 **/
public class MyQueue {
    public Stack<Integer> first;
    public Stack<Integer> second;

    public MyQueue() {
        first = new Stack();
        second = new Stack();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (first.empty()) {
            first.push(x);
        } else {
            while (!first.empty()) {
                second.push(first.pop());
            }
            first.push(x);
            while (!second.empty()) {
                first.push(second.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (first.empty()) {
            return -1;
        } else {
            return first.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (first.empty()) {
            return -1;
        } else {
            return first.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return first.empty();
    }
}
