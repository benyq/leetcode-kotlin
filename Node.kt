import java.util.*

class ListNode(
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


class TreeNode(
    val `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null


) {
    override fun toString(): String {
        return "TreeNode(`val`=$`val`, left=$left, right=$right)"
    }
}


fun arrayToBinaryTree(arr: Array<Int?>): TreeNode? {
    if (arr.isEmpty()) return null

    val nodes = arr.map { if (it == null) null else TreeNode(it) }

    val n = nodes.size
    for (i in 0 until n) {
        val node = nodes[i]
        if (node != null) {
            val leftIndex = 2 * i + 1
            val rightIndex = 2 * i + 2
            if (leftIndex < n) {
                node.left = nodes[leftIndex]
            }
            if (rightIndex < n) {
                node.right = nodes[rightIndex]
            }
        }
    }

    return nodes[0]
}