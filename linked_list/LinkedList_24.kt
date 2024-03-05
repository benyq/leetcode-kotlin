package linked_list

import ListNode
import generateLinkedList
import printList

// 24. 两两交换链表中的节点
// https://leetcode.cn/problems/swap-nodes-in-pairs/description/

fun main() {
    printList(swapPairs(generateLinkedList(1)))
}

private fun swapPairs(head: ListNode?): ListNode? {
    var left = head
    var right = head?.next
    var pre: ListNode? = null
    var res: ListNode? = null
    while (left != null && right != null) {
        val node = right.next
        right.next = left
        left.next = node
        pre?.next = right

        if (res == null) res = right

        pre = left
        left = left.next
        right = left?.next
    }
    if (res == null) res = head
    return res
}

