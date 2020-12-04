package com.leetcode.link.simple;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/3
 * <p>
 * #82
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，
 * 只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 **/

public class DeleteDuplicatesV2 {
    public static void main(String[] args) {
        DeleteDuplicatesV2 deleteDuplicatesV2 = new DeleteDuplicatesV2();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        deleteDuplicatesV2.deleteDuplicates(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        //思路：设置一个哑结点，p指向当前结点，pre指向当前结点的前一个结点
        //用于判断pre结点是否要移动
        boolean flag = true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p = p.next;
                flag = false;
            } else {
                p = p.next;
                if (flag) {
                    pre = pre.next;
                }
                pre.next = p;

                flag = true;
            }
        }
        //如果最后的结点时相同的，需要指向null
        if (!flag) {
            pre.next = null;
        }
        return dummy.next;
    }
}
