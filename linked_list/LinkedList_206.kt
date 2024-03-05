package linked_list

import ListNode
import generateLinkedList
import printList

// 206. 反转链表
// https://leetcode.cn/problems/reverse-linked-list/description/


fun main() {
    printList(reverseList(generateLinkedList(1,3)))
}

private fun reverseList(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var cur: ListNode? = head
    while (cur != null) {
        val node = cur.next
        cur.next = dummy.next
        dummy.next = cur
        cur = node
    }
    return dummy.next
}