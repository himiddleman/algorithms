package com.leetcode.link.simple;

/**
 * author: tanguang
 * data: 2020/11/25
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class ReverseList {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode = null;
        reverseList.reverseList(listNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode first = null;
        //思路：头插法反转链表
        while (head != null) {
            ListNode p = new ListNode(head.val);
            if (first == null) {
                first = p;
            } else {
                p.next = first;
                first = p;
            }
            head = head.next;
        }

        return first;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
