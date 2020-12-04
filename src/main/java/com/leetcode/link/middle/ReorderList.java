package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/4
 * #143
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 **/
public class ReorderList {

    public void reorderList(ListNode head) {
        //思路：找到链表中的第一个结点和最后一个结点
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode tail = getTailNode(p);
            tail.next = p.next;
            p.next = tail;
            p = p.next.next;
        }
    }

    //获取最后一个结点
    public ListNode getTailNode(ListNode listNode) {
        while (listNode.next != null) {
            //避免环出现
            ListNode p = listNode.next;
            if (listNode.next.next == null) {
                listNode.next = null;
            }
            listNode = p;
        }
        return listNode;
    }

}
