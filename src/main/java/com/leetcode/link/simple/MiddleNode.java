package com.leetcode.link.simple;

import com.leetcode.link.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * author: tanguang
 * data: 2020/11/26
 * #876
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 **/
public class MiddleNode {
    public static void main(String[] args) {
        MiddleNode middleNode = new MiddleNode();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        middleNode.middleNode(listNode);
    }

    public ListNode middleNode(ListNode head) {
        //思路：使用哈希表
        Map<Integer, ListNode> map = new HashMap<>();
        int count = 0;
        while (head != null) {
            map.put(count, head);
            count++;
            head = head.next;
        }

        return map.get(count / 2);
    }
}
