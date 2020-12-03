package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/2
 * #1669
 * <p>
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 * <p>
 * a，b为索引，从0开始
 **/
public class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //思路：找到list1的a,b处的结点，以及list2的尾结点

        //list1链表长度
        ListNode countNode = list1;
        int count = 0;
        while (countNode != null) {
            count++;
            countNode = countNode.next;
        }

        //a,b处结点
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        ListNode areaNode = dummy;
        int index = 0;
        ListNode aNode = null;
        ListNode bNode = null;
        while (areaNode != null) {
            if (index == a) {
                aNode = areaNode;
            }
            if (b + 2 > count) {
                bNode = null;
            } else if (index == b + 2) {
                bNode = areaNode;
            }
            areaNode = areaNode.next;
            index++;
        }

        //list2尾结点
        ListNode p2 = list2;
        while (p2.next != null) {
            p2 = p2.next;
        }
        ListNode tail = p2;

        //链表的拼接
        aNode.next = list2;
        tail.next = bNode;
        return list1;
    }
}
