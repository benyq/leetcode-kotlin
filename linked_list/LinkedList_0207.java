package linked_list;

// 面试题 02.07. 链表相交
// https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/

import java.util.Objects;

public class LinkedList_0207 {

    public static void main(String[] args) {
        LinkedList_0207 linkedList_0207 = new LinkedList_0207();
        ListNode node0 = generateLinkedList(8,4,5);
        ListNode nodeA = contact(generateLinkedList(4, 1), node0);
        ListNode nodeB = contact(generateLinkedList(5, 0, 1), node0);
        System.out.println(toString(linkedList_0207.getIntersectionNode(nodeA, nodeB)));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        int gap = Math.abs(lenA - lenB);
        curA = headA;
        curB = headB;
        if (lenA < lenB) {
            curA = headB;
            curB = headA;
        }
        while (gap -- > 0) {
            curA = curA.next;
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }


    private static ListNode generateLinkedList(int ...data) {
        if (data.length == 0) return null;
        ListNode head = new ListNode(data[0]);
        if (data.length == 1) return head;
        ListNode cur = head;
        for (int i = 1; i < data.length; i++) {
            ListNode node = new ListNode(data[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }

    private static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (head != null) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');
        return sb.toString();
    }

    private static ListNode contact(ListNode head, ListNode tail) {
        if (head == null) return tail;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tail;
        return head;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
}
