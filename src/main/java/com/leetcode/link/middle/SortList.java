package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/30
 * #148
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 **/
public class SortList {

    public ListNode sortList(ListNode head) {
        //思路：冒泡排序？？？

        ListNode p1 = head;
        ListNode p2 = head;
        int temp;
        while (p1 != null) {
            while (p2 != null) {
                if (p1.val < p2.val) {
                    temp = p1.val;
                    p1.val = p2.val;
                    p2.val = temp;

                    p2 = p2.next;
                }
            }
            p2 = head;
            p1 = p1.next;
        }

        return head;
    }
}
