package linked_list

import ListNode
import printList

// 707. 设计链表
// https://leetcode.cn/problems/design-linked-list/
// 定义虚拟头节点之后，添加或删除需要找到index前一个节点
//                  dummy -> node -> node -> node -> node
// dummy index       0     -> 1    -> 2    -> 3    -> 4
// real index                 0    -> 1    -> 2    -> 3

fun main() {
    val myLinkedList = MyLinkedList()
    myLinkedList.addAtHead(1)
    myLinkedList.println()
    myLinkedList.addAtTail(3)
    myLinkedList.println()
    myLinkedList.addAtIndex(1, 2)
    myLinkedList.println()
    println(myLinkedList.get(1))           // 返回 2
    myLinkedList.deleteAtIndex(1)    // 现在，链表变为 1->3
    myLinkedList.println()
    println(myLinkedList.get(0))
}

// 定义尾节点，把自己带坑里去了！！
class MyLinkedListOld() {
    private var head: ListNode? = null
    private var tail: ListNode? = null
    private var size = 0

    fun get(index: Int): Int {
        if (index < 0 || index >= size) return -1
        var cur = head
        for(i in 0 until size) {
            if (i == index) {
                return cur!!.`val`
            }else {
                cur = cur?.next
            }
        }
        return -1
    }

    fun addAtHead(`val`: Int) {
        if (head == null) {
            head = ListNode(`val`)
            tail = head
        } else {
            val node = ListNode(`val`)
            node.next = head
            head = node
        }
        size++
    }

    fun addAtTail(`val`: Int) {
        if (head == null) {
            head = ListNode(`val`)
            tail = head
        }else {
            val node = ListNode(`val`)
            tail?.next = node
            tail = node
        }
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0) return
        if (index > size) return
        if (size == 0 || index == 0) {
            addAtHead(`val`)
        }else if (index == size){
            addAtTail(`val`)
        }else {
            val node = ListNode(`val`)
            var dummy = ListNode(`val`)
            dummy.next = head
            var cur: ListNode? = dummy
            for (i in 0 until size) {
                if (i == index) {
                    node.next = cur?.next
                    cur?.next = node
                    break
                }else {
                    cur = cur?.next
                }
            }
            dummy.next = null
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index == 0) {
            head = head?.next
            size--
        }else {
            var cur = head
            var curIndex = 1
            while (cur?.next != null) {
                if (curIndex == index) {
                    cur.next = cur.next?.next
                    if (size - 1 == index) {
                        tail = cur
                    }
                    size--
                    break
                }else {
                    cur = cur.next
                }
                curIndex++
            }
        }
    }

    fun println() {
        printList(head)
    }
}

class MyLinkedList() {
    private var dummy: ListNode? = ListNode(0)
    private var size = 0

    fun get(index: Int): Int {
        return getNode(index + 1)?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        val node = ListNode(`val`)
        node.next = dummy?.next
        dummy?.next = node
        size++
    }

    fun addAtTail(`val`: Int) {
        val cur = getNode(size)
        if (cur == null) {
            addAtHead(`val`)
        }else {
            val node = ListNode(`val`)
            node.next = cur.next
            cur.next = node
            size++
        }
    }

    fun addAtIndex(index: Int, `val`: Int) {
        getNode(index)?.let {
            val node = ListNode(`val`)
            node.next = it.next
            it.next = node
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        getNode(index)?.let {
            it.next = it.next?.next
            size--
        }
    }

    private fun getNode(index: Int): ListNode? {
        if (index < 0 || index > size) return null
        var mIndex = index
        var cur = dummy
        while (mIndex -- > 0) {
            cur = cur?.next
        }
        return cur
    }

    fun println() {
        printList(dummy?.next)
    }
}
