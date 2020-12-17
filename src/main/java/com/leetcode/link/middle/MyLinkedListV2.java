package com.leetcode.link.middle;

/**
 * author: tanguang
 * data: 2020/12/8
 **/
//LinkedList框架 双链表版本
public class MyLinkedListV2 {
    ListNodeV2 head; //哨兵结点
    ListNodeV2 tail;    //哨兵结点
    int size;

    public MyLinkedListV2() {
        size = 0;
        head = new ListNodeV2(0);
        tail = new ListNodeV2(0);
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.deleteAtIndex(1);
        System.out.println("");
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNodeV2 curr;
        if (index > size / 2) {
            //从后遍历
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        } else {
            //从前遍历
            curr = head;
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
        }

        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }

        //pre指向index的前一个结点，next指向index结点
        ListNodeV2 pre, next;
        if (index > size / 2) {
            //从后遍历
            next = tail;
            for (int i = 0; i < size - index; i++) {
                next = next.prev;
            }
            pre = next.prev;
        } else {
            //从前遍历
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            next = pre.next;
        }

        //调整pre，next指针
        ListNodeV2 p = new ListNodeV2(val);
        pre.next = p;
        p.prev = pre;
        p.next = next;
        next.prev = p;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        //pre指向index的前一个结点，next指向index的后一个结点
        ListNodeV2 pre, next;
        if (index > size / 2) {
            //从后遍历
            next = tail;
            for (int i = 0; i < size - index - 1; i++) {
                next = next.prev;
            }
            pre = next.prev.prev;
        } else {
            //从前遍历
            pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            next = pre.next.next;
        }

        //调整pre，next指针
        pre.next = next;
        next.prev = pre;
        size--;
    }
}

class ListNodeV2 {
    public int val;
    public ListNodeV2 prev;
    public ListNodeV2 next;

    public ListNodeV2(int val) {
        this.val = val;
    }
}
