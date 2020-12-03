package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/1
 * #19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5
 **/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //思路：计算链表的长度，删除第count-n个结点
        //设置dummyHead优化
        //计算链表的元素数量
        if (head == null || head.next == null) {
            return null;
        }

        ListNode p = head;
        ListNode p2 = head;
        int count = 0;
        int i = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        //删除倒数第n个元素
        if (count - n == 0) {
            return head.next;
        }

        while (p2 != null && p2.next != null) {
            i++;
            if (i == count - n) {
                p2.next = p2.next.next;
                break;
            } else {
                p2 = p2.next;
            }
        }
        return head;
    }
}
