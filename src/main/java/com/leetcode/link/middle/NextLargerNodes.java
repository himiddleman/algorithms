package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/4
 * #1019
 * <p>
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * <p>
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * <p>
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * <p>
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 * <p>
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 **/
public class NextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        //思路：对于链表中的任意结点p，找比p值大的最近的结点值
        //计算链表的长度
        ListNode countNode = head;
        int count = 0;
        while (countNode != null) {
            countNode = countNode.next;
            count++;
        }
        int[] array = new int[count];
        int i = 0;
        ListNode p = head;
        while (p != null) {
            ListNode inner = p.next;
            while (inner != null) {
                if (inner.val > p.val) {
                    array[i] = inner.val;
                    break;
                }
                inner = inner.next;
            }
            p = p.next;
            i++;
        }

        return array;
    }
}
