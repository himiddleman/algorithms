package com.leetcode.link.simple;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/27
 * #83
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 **/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //思路：这是一个有序链表，如果有重复元素那么一定是在结点的下一个位置
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
