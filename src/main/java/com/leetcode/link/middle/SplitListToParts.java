package com.leetcode.link.middle;

import com.leetcode.link.ListNode;

/**
 * author: tanguang
 * data: 2020/12/7
 * <p>
 * #725
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 **/
public class SplitListToParts {
    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] nodeArray = new ListNode[k];
        //1.计算链表的长度
        ListNode init = root;
        int count = 0;
        while (init != null) {
            init = init.next;
            count++;
        }

        //2.创建数组array,记录分割后的各个链表的长度
        int[] array = new int[k];
        int averageSize = count / k;
        int remind = count % k;
        for (int i = 0; i < array.length; i++) {
            if (i < remind) {
                array[i] = averageSize + 1;
            } else {
                array[i] = averageSize;
            }
        }

        //对数组遍历，计算每个分隔链表的指针开始位置，注意需要将最后结点的指针置为null
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
        //[[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
        ListNode pre = root;
        ListNode subNode = root;
        for (int j = 0; j < array.length; j++) {
            int nodeSize = array[j];

            while (subNode != null && nodeSize > 0) {
                ListNode nextNode = subNode.next;
                if (nodeSize == 1) {
                    subNode.next = null;
                    nodeArray[j] = pre;
                    subNode = nextNode;
                    pre = nextNode;
                } else {
                    subNode = subNode.next;
                }

                nodeSize--;
            }
        }
        return nodeArray;
    }
}
