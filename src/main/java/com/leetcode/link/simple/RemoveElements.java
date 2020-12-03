package com.leetcode.link.simple;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/27
 * #203
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 **/
public class RemoveElements {
    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode listNode = new ListNode(1, new ListNode(6, new ListNode(3, new ListNode(6))));
        removeElements.removeElements(listNode, 6);
    }

//    public ListNode removeElements(ListNode head, int val) {
//        //思路：删除链表中的指定值
//        ListNode p = head;
//        while (p != null && p.next != null) {
//            if(p.next.val == val) {
//                //p的前一个元素指向p的后一个元素
//                p.next  = p.next.next;
//            }else {
//              p = p.next;
//            }
//        }
//
//        //针对于第一个结点的处理
//        if(head != null && head.val == val) {
//            return head.next;
//        }
//        return head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        //思路：设置一个头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                //p的前一个元素指向p的后一个元素
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
