data class ListNode(
    val `val`: Int,
    var next: ListNode? = null
)


fun generateLinkedList(vararg list: Int): ListNode? {
    if (list.isEmpty()) return null
    val head = ListNode(list[0])
    if (list.size == 1) return head
    var cur = head
    for (i in 1..< list.size) {
        val node = ListNode(list[i])
        cur.next = node
        cur = node
    }
    return head
}

fun contact(head: ListNode?, tail: ListNode?): ListNode? {
    if (head == null) return null
    var cur: ListNode? = head
    while (cur?.next != null) {
        cur = cur.next
    }
    cur?.next = tail
    return head
}

fun lastNode(head: ListNode?): ListNode? {
    var cur = head
    while (cur?.next != null) {
        cur = cur.next
    }
    return cur
}

fun printList(head: ListNode?) {
    var cur = head
    val content = StringBuilder("[")
    while (cur != null) {
        content.append(cur.`val`).append(",")
        cur = cur.next
    }
    if (content.last() == ',') {
        content.deleteAt(content.lastIndex)
    }
    content.append(']')
    println(content.toString())
}