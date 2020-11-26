package com.leetcode.link.simple;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/11/26
 * #237
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。
 * 传入函数的唯一参数为 要被删除的节点 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，
 * 该链表应变为 4 -> 1 -> 9.
 * 示例 2：
 * <p>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，
 * 该链表应变为 4 -> 5 -> 9.
 **/
public class DeleteNode {
    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        ListNode listNode = new ListNode(4, new ListNode(5, new ListNode(9, new ListNode(1))));
        deleteNode.deleteNode(listNode);
    }

    public void deleteNode(ListNode node) {
        //将node变成node的下一个节点，删除下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
