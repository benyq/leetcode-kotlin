package linked_list

import ListNode
import generateLinkedList
import printList


// 203. 移除链表元素
// https://leetcode.cn/problems/remove-linked-list-elements/description/
fun main() {
    printList(removeElements(generateLinkedList(listOf(1,2,6,3,4,5,6)), 6))
    printList(removeElements(generateLinkedList(listOf()), 1))
    printList(removeElements(generateLinkedList(listOf(7, 7, 7, 7)), 7))
}

private fun removeElements_old(head: ListNode?, `val`: Int): ListNode? {
    val dummyHead = ListNode(0)
    dummyHead.next = head
    var cur: ListNode? = dummyHead.next
    var prev: ListNode? = dummyHead
    while (cur != null) {
        if (cur.`val` != `val`) {
            prev = cur
            cur = cur.next
        }else {
            cur = cur.next
            prev?.next = cur
        }
    }
    return dummyHead.next
}

private fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val h = ListNode(0)
    var node: ListNode? = h
    h.next = head

    while (node != null) {
        //此处逻辑需要记住。找到目标值和未找到目标值是互斥关系
        if (node.next?.`val` == `val`) {
            node.next = node.next?.next
        } else {
            node = node.next
        }
    }
    return h.next
}