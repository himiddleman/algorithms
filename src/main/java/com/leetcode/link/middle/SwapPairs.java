package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/30
 * #24
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 1 2 3 4
 * 2 1 4 3
 **/
public class SwapPairs {

//    public ListNode swapPairs(ListNode head) {
//        //思路：递归
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = head.next;
//        head.next = swapPairs(newHead.next);
//        newHead.next = head;
//        return newHead;
//    }


    public ListNode swapPairs(ListNode head) {
        //方法二：设置哑结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = temp.next.next;
        }

        return dummyHead.next;
    }
}
