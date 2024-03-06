package linked_list

import ListNode
import generateLinkedList
import printList

// 19. 删除链表的倒数第 N 个结点
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
// 快慢指针

fun main() {
    printList(removeNthFromEnd(generateLinkedList(1), 1))
}

private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var step = n
    val dummy = ListNode(-1)
    dummy.next = head
    var slow: ListNode? = dummy
    var fast = head
    while (step > 0 && fast != null) {
        fast = fast.next
        step--
    }
    while (fast != null) {
        fast = fast.next
        slow = slow?.next
    }
    slow?.next = slow?.next?.next
    return dummy.next
}