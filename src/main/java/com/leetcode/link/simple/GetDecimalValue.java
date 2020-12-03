package com.leetcode.link.simple;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/30
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 **/
public class GetDecimalValue {
    public static void main(String[] args) {
        GetDecimalValue getDecimalValue = new GetDecimalValue();
        ListNode listNode = new ListNode(1, new ListNode(0, new ListNode(1)));
        getDecimalValue.getDecimalValue(listNode);
    }

    public int getDecimalValue(ListNode head) {
        //思路：先计算链表中元素个数,再转换为10进制数
        ListNode p = head;
        int count = 0;
        int i = 0;
        int sum = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        while (head != null) {
            i++;
            sum += head.val * (Math.pow(2, count - i));
            head = head.next;
        }
        return sum;
    }
}
