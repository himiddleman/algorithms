package com.leetcode.link.simple;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/27
 * #160
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 **/
public class GetIntersectionNode {
    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode common = new ListNode(4, new ListNode(5));
        ListNode headA = new ListNode(1, new ListNode(2, common));
        ListNode headB = new ListNode(2, new ListNode(3, common));

        getIntersectionNode.getIntersectionNode(headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //思路：让两个链表都走相同的距离（m+n），屏蔽链表的长度差，如果能够相交则返回，无相交则走m+n的长度。
        //时间复杂度O(m+n)，空间复杂度O（1）
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            //到达为节点后转向headB链表
            pa = pa == null ? headB : pa.next;
            //到达为节点后转向headA链表
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
