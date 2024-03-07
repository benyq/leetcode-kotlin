package linked_list

import ListNode
import contact
import generateLinkedList
import lastNode
import printList

// 142. 环形链表 II
// https://leetcode.cn/problems/linked-list-cycle-ii/
// 快慢指针找到环形入口，数学证明了
fun main() {
    val node0 = generateLinkedList(4, 2, 7, 8)
    lastNode(node0)?.next = node0
    println(detectCycle(contact(generateLinkedList(1, 6), node0))?.`val`)
}

private fun detectCycle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            var n1 = fast
            var n2 = head
            while (n1 != n2) {
                n1 = n1?.next
                n2 = n2?.next
            }
            return n1
        }
    }
    return null
}